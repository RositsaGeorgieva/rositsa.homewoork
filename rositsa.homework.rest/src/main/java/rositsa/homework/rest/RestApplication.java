package rositsa.homework.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
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
@ComponentScan({"rositsa.homework.rest"})
@ImportResource({"classpath*:applicationContext-persistence.xml"})
@SpringBootApplication
public class RestApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(RestApplication.class, args);
		
	}

}
