package org.sgi.project.controller;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sgi.project.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

@RestController
class ELKController {
    private static final Logger LOG = LogManager.getLogger(ELKController.class.getName());

    @Autowired
    RestTemplate restTemplete;

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @RequestMapping(value = "/elk")
    public String helloWorld() {
        String response = "Welcome to JavaInUse" + new Date();
//        LOG.log(Level.INFO, response);

        Person person=new Person().setUsername("ali").setPassword("123");
//        LOG.log(Level.INFO, "{\"username\":ali,\"password\":123}");
        LOG.trace("person",person);
        return response;
    }

    @RequestMapping(value = "/exception")
    public String exception() {
        String response = "";
        try {
            throw new Exception("Exception has occured....");
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error(e);

            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            String stackTrace = sw.toString();
            LOG.error("Exception - " + stackTrace);
            response = stackTrace;
        }

        return response;
    }

    @GetMapping("/hi")
    public String hi(){
        return "Hello";
    }
}
