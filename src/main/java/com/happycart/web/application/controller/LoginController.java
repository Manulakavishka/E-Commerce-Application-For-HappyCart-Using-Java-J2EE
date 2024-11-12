package com.happycart.web.application.controller;

import com.happycart.web.application.dto.AuthDTO;
import com.happycart.web.application.entity.Status;
import com.happycart.web.application.entity.User;
import com.happycart.web.application.service.CustomerServicee;
import com.happycart.web.application.service.UserService;
import com.happycart.web.application.util.Encryption;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import org.glassfish.jersey.server.mvc.Viewable;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Path("/login")
public class LoginController {
    @GET
    public Viewable index(){
        return new Viewable("/frontend/login");
    }

    @Context
    UriInfo uriInfo;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response loginAction(AuthDTO authDTO, @Context HttpServletRequest request) throws ServletException, IOException {
        if (authDTO.getEmail().isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Please Enter Your Email Address!  <br> <br> <button onClick='window.location.reload(true)'>Go Back</button>").build();

        } else if (authDTO.getEmail().length() >= 100) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Email Must Be Less Than 100 Characters!  <br> <br> <button onClick='window.location.reload(true)'>Go Back</button>").build();

        }else if (!isValidEmail(authDTO.getEmail())) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Invalid Email Address. <br> <br> <button onClick='window.location.reload(true)'>Go Back</button>")
                    .build();
        }  else if (authDTO.getPassword().isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Please Enter Your Password!  <br> <br> <button onClick='window.location.reload(true)'>Go Back</button>").build();

        } else if (authDTO.getPassword().length() < 5 || authDTO.getPassword().length() > 20) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid Password <br> <br> <button onClick='window.location.reload(true)'>Go Back</button>").build();

        } else {
CustomerServicee userService = new UserService();
            User byEmail = userService.getByEmail(authDTO.getEmail());
            if(byEmail ==null){
                return Response.status(Response.Status.BAD_REQUEST).entity("Email not exist.").build();
            } else {
                if(byEmail.getPassword().equals(Encryption.encrypt(authDTO.getPassword()))){
                    if(byEmail.getStatus().equals(Status.ACTIVE)){
                        boolean checkUser = false;
                        request.getSession().setAttribute("user",authDTO);
                        checkUser = true;
                        return Response.status(Response.Status.OK).build();
                    }else {
                        return Response.status(Response.Status.FORBIDDEN)
                                .entity("Please Confirm your email. <br> <br> <button onClick='window.location.reload(true)'>Go Back</button>")
                                .build();
                    }

                }else {
                    return Response.status(Response.Status.UNAUTHORIZED)
                            .entity("Invalid Email or Password. <br> <br> <button onClick='window.location.reload(true)'>Go Back</button>")
                            .build();
                }


            }
        }
    }

    private boolean isValidEmail(String email) {
        // Define a regular expression for a valid email address
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";

        // Compile the regular expression
        Pattern pattern = Pattern.compile(emailRegex);

        // Match the email against the pattern
        Matcher matcher = pattern.matcher(email);

        // Return true if the email matches the pattern, indicating it's valid
        return matcher.matches();
    }

}
