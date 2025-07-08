package com.abc.cmpinfo.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

/**
 * Web Service Configuration Class
 * Configures SOAP endpoints and WSDL generation
 */
@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

    /**
     * Configure Message Dispatcher Servlet for SOAP requests
     */
    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(
            ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    /**
     * Generate WSDL definition from XSD schema
     */
    @Bean(name = "company")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema companySchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("CompanyPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://www.abc.org/cmpinfo");
        wsdl11Definition.setSchema(companySchema);
        wsdl11Definition.setServiceName("CompanyService");
        return wsdl11Definition;
    }

    /**
     * Load XSD schema for WSDL generation
     */
    @Bean
    public XsdSchema companySchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/company.xsd"));
    }
}

