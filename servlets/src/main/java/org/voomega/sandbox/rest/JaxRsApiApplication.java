package org.voomega.sandbox.rest;

import org.voomega.sandbox.rest.controller.ResourceController;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.logging.Level;
import java.util.logging.Logger;

@ApplicationPath( "api" )
public class JaxRsApiApplication extends Application {

    private static final Logger LOGGER = java.util.logging.Logger.getLogger(JaxRsApiApplication.class.getName());
    static {
        LOGGER.log(Level.WARNING, "Load resource controller");
    }

}
