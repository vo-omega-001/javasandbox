package org.voomega.sandbox.servlets.logger;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.loader.WebappLoader;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.junit.Test;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.voomega.sandbox.rest.AppConfig;

import javax.servlet.ServletException;
import java.io.File;

public class LoggerServletTest {

    @Test
    public void deployServlet() {
        String webappDirLocation = "src/main/webapp/";
        Tomcat tomcat = new Tomcat();

        //The port that we should run on can be set into an environment variable
        //Look for that variable and default to 8080 if it isn't there.
        String webPort = System.getenv("PORT");
        if(webPort == null || webPort.isEmpty()) {
            webPort = "8090";
        }
        tomcat.setPort(Integer.parseInt(webPort));

        try {
            System.out.println("configuring app with basedir: " + new File(webappDirLocation).getAbsolutePath());
            StandardContext context  = (StandardContext) tomcat.addWebapp("/", new File(webappDirLocation).getAbsolutePath());

            addServlets(context);
            addJaxRsServlet(context);

            try {
                tomcat.start();
            } catch (LifecycleException e) {
                e.printStackTrace();
            }
            tomcat.getServer().await();

        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    private void addServlets(Context context) {
        // Declare an alternative location for your "WEB-INF/classes" dir
        // Servlet 3.0 annotation will work
        File additionWebInfClasses = new File("target/classes");
        WebResourceRoot resources = new StandardRoot(context);
        resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes",
                additionWebInfClasses.getAbsolutePath(), "/"));
        context.setResources(resources);
    }

    private void addJaxRsServlet(Context context) {
        Tomcat.addServlet( context, "CXFServlet", new CXFServlet() );
        context.addServletMapping( "/rest/*", "CXFServlet" );
        context.addApplicationListener( ContextLoaderListener.class.getName() );
        context.setLoader( new WebappLoader( Thread.currentThread().getContextClassLoader() ));
        context.addParameter( "contextClass", AnnotationConfigWebApplicationContext.class.getName() );
        context.addParameter( "contextConfigLocation", AppConfig.class.getName() );
    }
}
