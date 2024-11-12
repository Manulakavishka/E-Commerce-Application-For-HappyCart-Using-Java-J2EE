package com.happycart.web.application.service;

import com.happycart.web.application.entity.*;
import com.happycart.web.application.util.HibernateUtil;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Tuple;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProductService {
    public Product getByProductId(Long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.get(Product.class, id);
    }
    public void save(User user){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(user);
        transaction.commit();
        session.close();
        System.out.println("success");
    }

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
    public List<Tuple> getAllCategories() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Tuple> tupleQuery = cb.createTupleQuery();
            Root<Category> root5 = tupleQuery.from(Category.class);
            tupleQuery.multiselect(
                    root5.get("id").alias("id"),
                    root5.get("category_name").alias("category_name")
            );

            List<Tuple> list = session.createQuery(tupleQuery).getResultList();
            return list;
        }catch (Exception e){
            return null;
        }
    }

    public void updateUser(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
        System.out.println("success");
    }

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

//    public List<Product> getProductByCategory(Long categoryId) {
//        try {
//            int limit=4;
//            int offset=0;
//            Session session = HibernateUtil.getSessionFactory().openSession();
//            CriteriaBuilder cb = session.getCriteriaBuilder();
//            CriteriaQuery<Product> query = cb.createQuery(Product.class);
//            Root<Product> root = query.from(Product.class);
//
//            // Define the WHERE clause
//            Predicate categoryIdPredicate = cb.equal(root.get("category_id"), categoryId);
//            Predicate statusIdPredicate = cb.equal(root.get("status"), Status.ACTIVE);
//            Predicate combinedPredicate = cb.and(categoryIdPredicate, statusIdPredicate);
//
//            query.where(combinedPredicate);
//
//            // Define the ORDER BY clause
//            query.orderBy(cb.desc(root.get("datetime_added")));
//
//            List<Product> products = session.createQuery(query)
//                    .setFirstResult(offset)
//                    .setMaxResults(limit)
//                    .getResultList();
//
//            return products;
//        } catch (Exception e) {
//            return null;
//        }
//    }

    public List<Product> getProductByCategory(Long category_id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Category category = new Category();
        category.setId(category_id);

        Query<Product> fromProducts = session.createQuery("FROM Product p WHERE p.category_id =: category_id",Product.class);
        fromProducts.setParameter("category_id",category);
        List<Product> products = fromProducts.getResultList();

        transaction.commit();
        session.close();

        return products;
    }


    public Images getImagesByProductId(Long productId) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            Product product = new Product();
            product.setId(productId);

            Query<Images> fromProducts = session.createQuery("FROM Images p WHERE p.product_id =: product_id",Images.class);

            fromProducts.setParameter("product_id",product);

            Images products = fromProducts.getSingleResult();

            transaction.commit();
            session.close();
            return products;

        }catch (NoResultException n){
            System.out.println("Errrorrr");
            return null;
        }


    }

    public WatchList watchList(Long pid, String email){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Product pd = new Product();
        pd.setId(pid);

        User u = new User();
        u.setEmail(email);
        System.out.println("hhhhhhh");
        System.out.println(pid);
        System.out.println(email);
        System.out.println("ggggggg");
        String hql = "FROM WatchList w WHERE w.product_id = :product_id AND w.uses_email = :uses_email";
        Query<WatchList> query = session.createQuery(hql, WatchList.class);
        query.setParameter("product_id", pd);
        query.setParameter("uses_email",u );

        try{
            WatchList results = query.getSingleResult();
            System.out.println("hhhhh");
            System.out.println(results.getId());

            transaction.commit();
            session.close();

            return results;
        }catch (NoResultException n){
            WatchList list = new WatchList();
            list.setId(0L);
            return list;
        }


    }

    public List<Tuple> getAllProduct() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Tuple> tupleQuery = cb.createTupleQuery();
            System.out.println("qwer");
            Root<NewProduct> root5 = tupleQuery.from(NewProduct.class);
            System.out.println("43545");
            tupleQuery.multiselect(
                    root5.get("id").alias("id"),
                    root5.get("delivery_fee_colombo").alias("delivery_fee_colombo"),
                    root5.get("delivery_fee_other").alias("delivery_fee_other"),
                    root5.get("description").alias("description"),
                    root5.get("price").alias("price"),
                    root5.get("qty").alias("qty"),
                    root5.get("title").alias("title")
            );
            System.out.println("hhhhhhh");
            List<Tuple> list = session.createQuery(tupleQuery).getResultList();
            System.out.println("gggggggg");
            return list;
        }catch (Exception e){
            System.out.println("errorrrrr");
            return null;
        }
    }
}
