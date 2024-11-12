package com.happycart.web.application.controller;

import com.happycart.web.application.entity.NewProduct;
import com.happycart.web.application.entity.User;
import com.happycart.web.application.util.HibernateUtil;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.glassfish.jersey.server.mvc.Viewable;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Path("/searchproduct")

public class SearchController {
    @GET
    @Produces(MediaType.TEXT_HTML)
    public Viewable index(){
//        return new Viewable("/index");
        return new Viewable("/frontend/productadd");

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response register(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        NewProduct product = session.get(NewProduct.class, id);
        System.out.println("success");
        return Response.status(Response.Status.OK).entity("" +
                "<table id=\"example1\">\n" +
                "    <tr>\n" +
                "        <th>Id</th>\n" +
                "        <th>delivery_fee_colombo</th>\n" +
                "        <th>delivery_fee_other</th>\n" +
                "        <th>description</th>\n" +
                "        <th>price</th>\n" +
                "        <th>qty</th>\n" +
                "        <th>title</th>\n" +
                "    </tr>\n" +
                "        <tr>\n" +
                "            <td>"+product.getId()+"</td>\n" +
                "            <td>"+product.getDelivery_fee_colombo()+"</td>\n" +
                "            <td>"+product.getDelivery_fee_other()+"</td>\n" +
                "            <td>"+product.getDescription()+"</td>\n" +
                "            <td>"+product.getPrice()+"</td>\n" +
                "            <td>"+product.getQty()+"</td>\n" +
                "            <td>"+product.getTitle()+"</td>\n" +
                "        </tr>\n" +
                "\n" +
                "</table>" +
                " <br> <br> <button onClick='window.location.reload(true)'>Go Back</button>").build();
    }
    public User getByEmail(String email){
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.get(User.class, email);
    }
}
