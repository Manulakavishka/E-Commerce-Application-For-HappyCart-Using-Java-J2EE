package com.happycart.web.application.service;

import com.happycart.web.application.entity.Message;
import com.happycart.web.application.entity.Status;
import com.happycart.web.application.entity.User;
import com.happycart.web.application.util.HibernateUtil;
import jakarta.persistence.Tuple;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class MessageService {
    public static Long getUserCount(String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        UserService userService = new UserService();
        User user = userService.getByEmail(email);

        Query<Long> query = session.createQuery("SELECT COUNT(*) FROM Message m  WHERE m.from_email=:from_email AND m.status=:status", Long.class)
                .setParameter("from_email", user)
                 .setParameter("status", Status.ACTIVE);
            Long userCount = query.uniqueResult();

            session.getTransaction().commit();

            return userCount;

    }

//    public List<Tuple> getAllMessage() {
//        try {
//            Session session = HibernateUtil.getSessionFactory().openSession();
//            CriteriaBuilder cb = session.getCriteriaBuilder();
//            CriteriaQuery<Tuple> tupleQuery = cb.createTupleQuery();
//            Root<Message> root5 = tupleQuery.from(Message.class);
//            tupleQuery.multiselect(
//                    root5.get("email").alias("email"),
//                    root5.get("fname").alias("fn"), //as
//                    root5.get("lname").alias("ln"),
//                    root5.get("gender").alias("gender"),
//                    root5.get("password").alias("pw"),
//                    root5.get("mobile").alias("mobile"),
//                    root5.get("varification_code").alias("varification_code"),
//                    root5.get("joined_date").alias("hire"),
//                    root5.get("status").alias("status")
//            );
//
//            List<Tuple> list = session.createQuery(tupleQuery).getResultList();
//            return list;
//        }catch (Exception e){
//            return null;
//        }
//    }
    public static List<Tuple> getAllMessage(String email) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Tuple> tupleQuery = cb.createTupleQuery();
            Root<Message> root = tupleQuery.from(Message.class);

            // Define the selection of columns with aliases
            tupleQuery.multiselect(
                    root.get("id").alias("id"),
                    root.get("content").alias("content"),
                    root.get("date_time").alias("date_time"),
                    root.get("status").alias("status"),
                    root.get("from_email").alias("from_email"),
                    root.get("to_email").alias("to_email")
            );

            // Create predicates (conditions) based on the provided parameters
            List<Predicate> predicates = new ArrayList<>();
                predicates.add(cb.equal(root.get("status"), Status.ACTIVE));
            if (email != null) {
                predicates.add(cb.equal(root.get("from_email"), email));
            }

            // Combine the predicates using AND
            Predicate[] predicateArray = predicates.toArray(new Predicate[0]);
            tupleQuery.where(predicateArray);

            List<Tuple> list = session.createQuery(tupleQuery).getResultList();
            return list;
        } catch (Exception e) {
            return null;
        }
    }

}
