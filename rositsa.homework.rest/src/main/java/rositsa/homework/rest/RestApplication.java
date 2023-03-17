package rositsa.homework.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * VM arg --add-opens java.base/java.lang=ALL-UNNAMED
 * @author rosy
 *
 */
@EnableSwagger2
@ComponentScan({"rositsa.homework.rest", "rositsa.homework.service", "rositsa.homework.dao"})
@ImportResource({"classpath*:applicationContext-persistence.xml"})
@SpringBootApplication
public class RestApplication {
	
	/**
	 * Application entry point
	 * 
	 * @param args - no args
	 */
	public static void main(String[] args) {

		SpringApplication.run(RestApplication.class, args);
		
		System.out.println("REST API documentation and REST HTML client are available on:");
		System.out.println("\thttp://localhost:8080/swagger-ui.html");
		
	}
	
	

}
