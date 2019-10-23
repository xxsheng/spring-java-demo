package com.springboot.demo.api.config;

import java.nio.charset.Charset;

import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.boot.web.embedded.tomcat.TomcatWebServer;
import org.springframework.boot.web.server.WebServer;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ServerConfig implements ApplicationListener<WebServerInitializedEvent> {
    


    @Override
    public void onApplicationEvent(WebServerInitializedEvent event) {
        TomcatWebServer webserver = (TomcatWebServer) event.getWebServer();
        Charset uriCharset = webserver.getTomcat().getConnector().getURICharset();
        String uriEncoding = webserver.getTomcat().getConnector().getURIEncoding();
        
        log.info("Get uriCharset port {}", uriCharset);
        log.info("Get uriEncoding port {}", uriEncoding);
        
        //log.info("Get WebServer port {}", serverPort);



    }

}
