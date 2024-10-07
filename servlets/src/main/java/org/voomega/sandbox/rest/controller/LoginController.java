package org.voomega.sandbox.rest.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("login")
public class LoginController {

    private static final Logger LOGGER = Logger.getLogger(LoginController.class.getName());

    public LoginController() {
        LOGGER.log(Level.WARNING, "Load resource controller");
    }

    @GET
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public Response getResources(@QueryParam("login") String login, @QueryParam("pwd") String password) {
        return Response.status(Response.Status.OK).entity("logged").build();
    }
}
