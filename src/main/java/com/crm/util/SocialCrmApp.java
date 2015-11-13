package com.crm.util;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

import com.datastax.driver.core.Cluster;

@SpringBootApplication
@ComponentScan(basePackages={"com.crm.*"})
public class SocialCrmApp {

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SocialCrmApp.class);
	}
	
    public static void main(String[] args) {
        SpringApplication.run(SocialCrmApp.class, args);
    }
    
    @Bean
    public TemplateResolver templateResolver(){
        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML5");
        templateResolver.setCacheable(false);

        return templateResolver;
    }
    
 
 
   @Bean
   public SpringTemplateEngine templateEngine(){
         SpringTemplateEngine templateEngine = new SpringTemplateEngine();
         templateEngine.setTemplateResolver(templateResolver());
     /*    templateEngine.addDialect(new SpringSecurityDialect());*/
         return templateEngine;
   }

     @Bean
     public ViewResolver viewResolver(){
         ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
         viewResolver.setTemplateEngine(templateEngine());
         viewResolver.setOrder(0);
         return viewResolver;
      }
     
     @Bean
		public CassandraOperations establishDBConnection(){
			return new CassandraTemplate(Cluster.builder().addContactPoints("10.20.3.163").build().connect("icrm"));
		}
     
}

