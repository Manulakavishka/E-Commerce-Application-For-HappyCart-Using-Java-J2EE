package com.happycart.web.application.service;

import com.happycart.web.application.entity.ProfileImage;
import com.happycart.web.application.entity.User;
import com.happycart.web.application.util.HibernateUtil;
import jakarta.persistence.Query;
import jakarta.persistence.Tuple;
import jakarta.persistence.criteria.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserService implements CustomerServicee {
    @Override
    public User getByEmail(String email){
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.get(User.class, email);
    }

@Override
    public void save(User user){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(user);
        transaction.commit();
        session.close();
        System.out.println("success");
    }

    @Override
    public List<Tuple> getAllUser() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
//            List<Employee> employees = session.createQuery("SELECT u FROM Employee u", Employee.class).getResultList();
//            session.close();
//            return employees;
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Tuple> tupleQuery = cb.createTupleQuery();
            Root<User> root5 = tupleQuery.from(User.class);
            tupleQuery.multiselect(
                    root5.get("email").alias("email"),
                    root5.get("fname").alias("fn"), //as
                    root5.get("lname").alias("ln"),
                    root5.get("gender").alias("gender"),
                    root5.get("password").alias("pw"),
                    root5.get("mobile").alias("mobile"),
                    root5.get("varification_code").alias("varification_code"),
                    root5.get("joined_date").alias("hire"),
                    root5.get("status").alias("status")
                    );

            List<Tuple> list = session.createQuery(tupleQuery).getResultList();
            return list;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public void updateUser(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
        System.out.println("success");
    }

    @Override
    public void deleteUser(String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        User user = session.createQuery("SELECT u FROM User u WHERE u.email=:email", User.class)
                .setParameter("email", email)
                .uniqueResult();
        session.remove(user);
        transaction.commit();
        session.close();
        System.out.println("success");
    }

    public List<Tuple> getUserDataWithPics(String toMail) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder cb = session.getCriteriaBuilder();

            // Create a CriteriaQuery for Tuple
            CriteriaQuery<Tuple> tupleQuery = cb.createTupleQuery();

            // Define the root entity (User) and join with ProfileImage
            Root<User> userRoot = tupleQuery.from(User.class);
            Join<User, ProfileImage> profileImageJoin = userRoot.join("profileImages", JoinType.INNER);

            // Define the selection of columns with aliases
            tupleQuery.multiselect(
                    userRoot.get("email").alias("email"),
                    userRoot.get("fname").alias("fn"),
                    userRoot.get("lname").alias("ln"),
                    userRoot.get("gender").alias("gender"),
                    userRoot.get("password").alias("pw"),
                    userRoot.get("mobile").alias("mobile"),
                    userRoot.get("varificationCode").alias("varification_code"), // Note: Use the correct attribute name
                    userRoot.get("joinedDate").alias("hire"),
                    userRoot.get("status").alias("status"),
                    profileImageJoin.get("path").alias("path")
            );

            // Add a WHERE clause for filtering by email
            Predicate emailPredicate = cb.equal(userRoot.get("email"), toMail);
            tupleQuery.where(emailPredicate);

            List<Tuple> list = session.createQuery(tupleQuery).getResultList();
            return list;
        } catch (Exception e) {
            return null;
        }
    }


}
