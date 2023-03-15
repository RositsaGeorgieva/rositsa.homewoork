package rositsa.homework.rest;

import java.net.Inet4Address;
import java.net.UnknownHostException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

import rositsa.homework.service.ParkingEventService;
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

//	private static final int PRICE_CAR_1H = 1;
//	private static final int PRICE_CAR_24H = 10;
//	private static final int PRICE_BUS_1H = 5;
//	private static final int PRICE_BUS_24H = 40;
//	private static final int BUS_SPOTS = 10;
//	private static final int CAR_SPOTS = 50;
	
	ParkingEventService parkingEventService;
	
	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(RestApplication.class, args);
		
		
		System.out.println("REST API documentation and REST HTML client are available on:");
		System.out.println("\thttp://localhost:8080/swagger-ui.html");
		
	}
	
	

}
