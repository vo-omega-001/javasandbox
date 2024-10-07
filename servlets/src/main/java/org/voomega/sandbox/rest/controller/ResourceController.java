package org.voomega.sandbox.rest.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("resource")
public class ResourceController {

    private static final Logger LOGGER = java.util.logging.Logger.getLogger(ResourceController.class.getName());

    public ResourceController() {
        LOGGER.log(Level.WARNING, "Load resource controller");
    }

    @GET
    @Path("/{id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public Response getResource(@PathParam("id") String id) {
        return Response.status(Response.Status.OK).entity("{\"resource\": {\"id\": 1, \"name\": \"res01\"}}").build();
    }

    @GET
    @Produces({ "application/json" })
    public Response getResources() {
        return Response.status(Response.Status.OK).entity("{\"resource\": [{\"id\": 1, \"name\": \"res01\"}, {\"id\": 2, \"name\": \"res02\"}]}").build();
    }
}
