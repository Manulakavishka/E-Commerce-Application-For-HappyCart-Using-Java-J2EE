package com.happycart.web.application.controller;

import com.happycart.web.application.dto.RegisterDTO;
import com.happycart.web.application.entity.Status;
import com.happycart.web.application.entity.User;
import com.happycart.web.application.mail.VerificationMail;
import com.happycart.web.application.provider.MailServiceProvider;
import com.happycart.web.application.service.UserService;
import com.happycart.web.application.util.Encryption;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.glassfish.jersey.server.mvc.Viewable;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Path("/register")
public class RegisterController {
    @GET
    @Produces(MediaType.TEXT_HTML)
    public Viewable index(){
//        return new Viewable("/index");
        return new Viewable("/frontend/register");

    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response register(RegisterDTO registerDTO){
        UserService userService = new UserService();
        User byEmail = userService.getByEmail(registerDTO.getEmail());
        if(byEmail !=null){
            return Response.status(Response.Status.BAD_REQUEST).entity("Email already exist.  <br> <br> <button onClick='window.location.reload(true)'>Go Back</button>").build();
        } else {

            if (registerDTO.getFname().isEmpty()) {
                return Response.status(Response.Status.BAD_REQUEST).entity("Please Enter Your First Name!  <br> <br> <button onClick='window.location.reload(true)'>Go Back</button>").build();

            } else if (registerDTO.getFname().length() > 50) {
                return Response.status(Response.Status.BAD_REQUEST).entity("First Name Must Be Less Than 50 Characters!  <br> <br> <button onClick='window.location.reload(true)'>Go Back</button>").build();

            } else if (registerDTO.getLname().isEmpty()) {
                return Response.status(Response.Status.BAD_REQUEST).entity("Please Enter Your Last Name!  <br> <br> <button onClick='window.location.reload(true)'>Go Back</button>").build();


            } else if (registerDTO.getLname().length() > 50) {
                return Response.status(Response.Status.BAD_REQUEST).entity("Last Name Must Be Less Than 50 Characters!  <br> <br> <button onClick='window.location.reload(true)'>Go Back</button>").build();

            } else if (registerDTO.getEmail().isEmpty()) {
                return Response.status(Response.Status.BAD_REQUEST).entity("Please Enter Your Email Address!  <br> <br> <button onClick='window.location.reload(true)'>Go Back</button>").build();

            } else if (registerDTO.getEmail().length() >= 100) {
                return Response.status(Response.Status.BAD_REQUEST).entity("Email Must Be Less Than 100 Characters!  <br> <br> <button onClick='window.location.reload(true)'>Go Back</button>").build();

            }  else if (registerDTO.getPassword().isEmpty()) {
                return Response.status(Response.Status.BAD_REQUEST).entity("Please Enter Your Password!  <br> <br> <button onClick='window.location.reload(true)'>Go Back</button>").build();

            } else if (registerDTO.getPassword().length() < 5 || registerDTO.getPassword().length() > 20) {
                return Response.status(Response.Status.BAD_REQUEST).entity("Password Length Should Be Between 05 and 20  <br> <br> <button onClick='window.location.reload(true)'>Go Back</button>").build();

            } else if (!registerDTO.getPassword().equals(registerDTO.getRepassword())) {
                return Response.status(Response.Status.BAD_REQUEST).entity("Password Does Not Match.  <br> <br> <button onClick='window.location.reload(true)'>Go Back</button>").build();

            } else if (isValidEmail(registerDTO.getPassword())) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity("Invalid Email Address. <br> <br> <button onClick='window.location.reload(true)'>Go Back</button>")
                        .build();
            } else if (registerDTO.isAgreeTerms()==false) {
                return Response.status(Response.Status.BAD_REQUEST).entity("Please Read And Agree to Agreement  <br> <br> <button onClick='window.location.reload(true)'>Go Back</button>").build();
            }else {
                User user = new User();
                LocalDateTime now = LocalDateTime.now();
                user.setJoined_date(now);
                user.setEmail(registerDTO.getEmail());
                user.setPassword(Encryption.encrypt(registerDTO.getPassword()));
                user.setFname(registerDTO.getFname());
                user.setLname(registerDTO.getLname());
                user.setGender(registerDTO.getGender());
                user.setMobile(registerDTO.getMobile());

                String verificationCode = UUID.randomUUID().toString();
                user.setVarification_code(verificationCode);

                user.setStatus(Status.INACTIVE);
                userService.save(user);

                VerificationMail mail = new VerificationMail(user.getEmail(),verificationCode);
                MailServiceProvider.getInstance().sendMail(mail);

                return Response.status(Response.Status.OK).entity("Register Success..   <br> <br> <button onClick='window.location.reload(true)'>Go Back</button>").build();

            }


            ///

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
