package org.voomega.sandbox.rest;

import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.voomega.sandbox.rest.controller.LoginController;
import org.voomega.sandbox.rest.controller.ResourceController;

import javax.ws.rs.ext.RuntimeDelegate;
import java.util.Arrays;
import java.util.Collections;

@Configuration
public class AppConfig {

    @Bean( destroyMethod = "shutdown" )
    public SpringBus cxf() {
        return new SpringBus();
    }

    @Bean
    public Server jaxRsServer() {
        JAXRSServerFactoryBean factory = RuntimeDelegate.getInstance().createEndpoint( jaxRsApiApplication(), JAXRSServerFactoryBean.class );
        factory.setServiceBeans(
                Arrays.asList(
                    resourceController(),
                    loginController()
                ));
//        factory.setAddress( /*'/' + */factory.getAddress() );
        factory.setProviders(Collections.<Object>singletonList(jsonProvider()));
        return factory.create();
    }

    @Bean
    public JaxRsApiApplication jaxRsApiApplication() {
        return new JaxRsApiApplication();
    }

    @Bean
    public LoginController loginController() {
        return new LoginController();
    }

    @Bean
    public ResourceController resourceController() {
        return new ResourceController();
    }

//    @Bean
//    public PeopleService peopleService() {
//        return new PeopleService();
//    }

    @Bean
    public JacksonJsonProvider jsonProvider() {
        return new JacksonJsonProvider();
    }
}
