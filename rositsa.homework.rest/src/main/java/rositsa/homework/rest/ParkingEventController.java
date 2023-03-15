package rositsa.homework.rest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import rositsa.homework.core.ParkingEvent;
import rositsa.homework.rest.controller.parkingevent.get.ListParkingEventsResponse;
import rositsa.homework.service.ParkingEventService;

/**
 * 
 * ParkingEventController<br/>
 * 
 *
 * @version $Id:$
 * @author rosy@inerty.com
 * @since 1.0
 *
 */
@Controller
@EnableAutoConfiguration
@RequestMapping("parkingevent")
public class ParkingEventController {

	/** Logger */
	private static final Logger logger = LogManager.getLogger(ParkingEventController.class);
	
	@Autowired
	private ParkingEventService parkingEventService;
	
	
	@ApiOperation(value = "get", nickname = "get", notes= "Get all parking events")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = ListParkingEventsResponse.class)})
	@RequestMapping(method = RequestMethod.GET, path="/list",  produces = "application/json")
	public @ResponseBody ListParkingEventsResponse list() {
		
		logger.info("List all parking events");
		
		ListParkingEventsResponse response = new ListParkingEventsResponse();
		
		List<ParkingEvent> parkingEvents = new ArrayList<ParkingEvent>();
		
		
		parkingEvents.addAll(parkingEventService.findAll());
		
		response.setParkingEvents(parkingEvents);
		
		return response;
	}
	
	@ApiOperation(value = "get", nickname = "get", notes= "Get occupied spots")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = ListParkingEventsResponse.class)})
	@RequestMapping(method = RequestMethod.GET, path="/findOccupied",  produces = "application/json")
	public @ResponseBody ListParkingEventsResponse listOccupied() {
		
		logger.info("Get occupied spots");
		
		ListParkingEventsResponse response = new ListParkingEventsResponse();
		
		List<ParkingEvent> parkingEvents = new ArrayList<ParkingEvent>();
		
		
		parkingEvents.addAll(parkingEventService.findOccupied());
		
		response.setParkingEvents(parkingEvents);
		
		return response;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ParkingEvents Controler - Implementation of ParkingEvent REST API";
	}

	public void setParkingEventService(ParkingEventService parkingEventService) {
		this.parkingEventService = parkingEventService;
	}

	
}