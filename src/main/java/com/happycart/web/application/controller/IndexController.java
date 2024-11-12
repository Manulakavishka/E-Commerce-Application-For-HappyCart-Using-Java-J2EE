package com.happycart.web.application.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.glassfish.jersey.server.mvc.Viewable;

@Path("/index")
public class IndexController {
    @GET
    public Viewable index(){
        return new Viewable("/frontend/index");
    }

}
