package rositsa.homework.rest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import rositsa.homework.core.ParkingEvent;
import rositsa.homework.rest.Status.ResponseTypes;
import rositsa.homework.rest.controller.parkingevent.BaseRestException;
import rositsa.homework.rest.controller.parkingevent.create.CreateResponse;
import rositsa.homework.rest.controller.parkingevent.create.UpdateResponse;
import rositsa.homework.rest.controller.parkingevent.get.ListParkingEventsResponse;
import rositsa.homework.service.FullParkingException;
import rositsa.homework.service.ParkingEventService;

/**
 * 
 * ParkingEventController
 * 
 * @author rositsa
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
	
	/**
	 * List all parking events
	 * 
	 * @return list of parkingEvents
	 */
	@ApiOperation(value = "List all parking events", nickname = "getAll", notes= "Get all parking events")
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
	
	/**
	 * List occupied spots at this moment
	 * 
	 * @return list of parkingEvents
	 * 
	 */
	@ApiOperation(value = "List occupied spots NOW", nickname = "getOccupiedSpots", notes= "Get occupied spots at this moment")
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
	
	/**
	 * List parking events by date
	 * 
	 * @param date - observed date
	 * 
	 * @return list of parkingEvents
	 * 
	 * @throws ParseException
	 * 
	 */
	@ApiOperation(value = "List parking events by date", nickname = "findByDate", notes= "Get parked vehicles by date")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = ListParkingEventsResponse.class)})
	@RequestMapping(method = RequestMethod.GET, path="/finByDate/{date}",  produces = "application/json")
	public @ResponseBody ListParkingEventsResponse findByDate(@PathVariable("date") @ApiParam(name = "date", value = "2023-03-15", required = true) String date) throws ParseException {
		
		logger.info("Get parked vehicle by date " + date);
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date parseDate = sf.parse(date);
		
		System.out.println("date is: " + parseDate);
		
		List<ParkingEvent> parkingEvents = parkingEventService.findByDate(parseDate);
		
		ListParkingEventsResponse response = new ListParkingEventsResponse();
		
		response.setParkingEvents(parkingEvents);
		
		return response;
	}
	
	/**
	 * Gets number of all occupied spots at this moment
	 * 
	 * @return number of spots
	 */
	@ApiOperation(value = "Number of occupied spots NOW", nickname = "getNumberOfOccupiedSpots", notes= "Get Number of occupied spots")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = ListParkingEventsResponse.class)})
	@RequestMapping(method = RequestMethod.GET, path="/numberOfOccupiedSpots",  produces = "application/json")
	public @ResponseBody int numberOfOccupiedSpots() {
		
		logger.info("Number of occupied spots NOW");
		
		return parkingEventService.findOccupied().size();
	}
	
	/**
	 * Gets number of occupied by cars spots at this moment
	 * 
	 * @return number of spots
	 * 
	 */
	@ApiOperation(value = "Number of occupied by cars spots NOW", nickname = "getNumberOfOccupiedByCarsSpots", notes= "Get Number of occupied CAR spots")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = ListParkingEventsResponse.class)})
	@RequestMapping(method = RequestMethod.GET, path="/findOccupiedCarSpots",  produces = "application/json")
	public @ResponseBody int findOccupiedCarSpots() {
		
		logger.info("Number of occupied by cars spots NOW");
		
		return ParkingEventService.CAR_SPOTS - parkingEventService.findFreeCarSpots();
	}
	
	/**
	 * Gets number of occupied by busses spots at this moment
	 * 
	 * @return number of spots
	 * 
	 */
	@ApiOperation(value = "Number of occupied by busses spots NOW", nickname = "getNumberOfOccupiedByBussesSpots", notes= "Get Number of occupied BUS spots")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = ListParkingEventsResponse.class)})
	@RequestMapping(method = RequestMethod.GET, path="/findOccupiedBusSpots",  produces = "application/json")
	public @ResponseBody int findOccupiedBusSpots() {
		
		logger.info("Number of occupied by busses spots NOW");
		
		return ParkingEventService.BUS_SPOTS - parkingEventService.findFreeBusSpots();
	}
	
	/**
	 * Create ParkingEvent
	 * 
	 * @param type - type of vehicle
	 * 
	 * @param plateNumber - number of vehicle
	 * 
	 * @return ParkingEvent
	 * 
	 * @throws FullParkingException
	 */
	@ApiOperation(value = "Enter parking - create parking event", nickname = "entering parking", notes= "Create parking event")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = CreateResponse.class)})
	@RequestMapping(method = RequestMethod.POST, path="/{type}/{plateNumber}", produces = "application/json")
	public @ResponseBody CreateResponse create(@PathVariable("type") String type, @PathVariable("plateNumber") String plateNumber) throws FullParkingException {

		logger.info("Create parking event: " + plateNumber + ". Type " + type);
		
		ParkingEvent parkingEvent = new ParkingEvent();
		
		parkingEvent.setPlateNumber(plateNumber);
		
		parkingEvent.setType(type);
		
		parkingEventService.enterParking(plateNumber, type);
		
		logger.info("Parking event created successfully: " + parkingEvent);
		
		CreateResponse response = new CreateResponse(plateNumber);
		
		return response;
	}
	
	/**
	 * Update ParkindEvent
	 * 
	 * @param plateNumber - the number of vehicle
	 * 
	 * @return updateResponse
	 * 
	 * @throws BaseRestException
	 */
	@ApiOperation(value = "Exit parking - update parking event", nickname = "exit the parking", notes= "Update parking event with endDate")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = CreateResponse.class)})
	@RequestMapping(method = RequestMethod.PUT, path="/{plateNumber}", produces = "application/json")
	public @ResponseBody UpdateResponse update(@PathVariable("plateNumber") String plateNumber) throws BaseRestException {

		logger.info("Update parking event [plateNumber=" + plateNumber + "]");
		
		ParkingEvent parkingEvent = parkingEventService.get(plateNumber);
		
		parkingEventService.exitParking(plateNumber);
		
		return new UpdateResponse(parkingEvent.getPlateNumber());
	}
	
	
	/**
	 * toSting
	 */
	@Override
	public String toString() {
		return "ParkingEvents Controler - Implementation of ParkingEvent REST API";
	}

	/**
	 * set ParkingEventService
	 * 
	 * @param parkingEventService
	 * 
	 */
	public void setParkingEventService(ParkingEventService parkingEventService) {
		this.parkingEventService = parkingEventService;
	}
	
	
	/**
	 * 
	 * FullParkingException handler
	 * 
	 * @param e - exception
	 * 
	 * @return status
	 */
	@ExceptionHandler({FullParkingException.class})
	public @ResponseBody Status error(FullParkingException e) {
		Status status = new Status();
		status.setCode("406");
		status.setMessage(e.getMessage());
		status.setType(ResponseTypes.ERROR);
		return status;
	}
}
	