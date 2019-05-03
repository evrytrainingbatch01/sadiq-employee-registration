package com.evry.employee.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.config.annotation.EnableWs;

import com.evry.employee.resources.EmployeeResourceImpl;
/**
 * 
 * @author sadiq.ahamad
 *
 */
@Configuration
@EnableWs
public class ConfigClass {
	
	@Bean
	  public ServletRegistrationBean<CXFServlet> servletRegistrationBean(){
	      return new ServletRegistrationBean<CXFServlet>(new CXFServlet(),"/api/*");
	  }
	
	@Bean(name="cxf") 
	public SpringBus springBus() { 
	    return new SpringBus(); 
	} 

	@Bean 
	public EmployeeResourceImpl myService() { 
	    return new EmployeeResourceImpl(); 
	} 

	@Bean 
	public Endpoint endpoint() { 
	    EndpointImpl endpoint = new EndpointImpl(springBus(), myService()); 
	    endpoint.publish("/service"); 
	    return endpoint; 
	} 
	

}
