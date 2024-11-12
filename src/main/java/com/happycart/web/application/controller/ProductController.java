package com.happycart.web.application.controller;

import com.happycart.web.application.dto.RegisterDTO;
import com.happycart.web.application.entity.NewProduct;
import com.happycart.web.application.entity.User;
import com.happycart.web.application.service.UserService;
import com.happycart.web.application.util.Encryption;
import com.happycart.web.application.util.HibernateUtil;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.glassfish.jersey.server.mvc.Viewable;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDateTime;

@Path("/addproduct")
public class ProductController {
    @GET
    @Produces(MediaType.TEXT_HTML)
    public Viewable index(){
//        return new Viewable("/index");
        return new Viewable("/frontend/productadd");

    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response register(NewProduct product) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(product);
        transaction.commit();
        session.close();
        System.out.println("success");
        return Response.status(Response.Status.OK).entity("Add Success..   <br> <br> <button onClick='window.location.reload(true)'>Go Back</button>").build();
    }

}
