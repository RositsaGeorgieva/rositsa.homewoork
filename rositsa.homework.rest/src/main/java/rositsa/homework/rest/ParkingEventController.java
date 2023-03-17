package rositsa.homework.rest;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
import rositsa.homework.rest.controller.parkingevent.create.CreateParkingEventBody;
import rositsa.homework.rest.controller.parkingevent.create.CreateResponse;
import rositsa.homework.rest.controller.parkingevent.create.UpdateParkingEventBody;
import rositsa.homework.rest.controller.parkingevent.create.UpdateResponse;
import rositsa.homework.rest.controller.parkingevent.get.ListParkingEventsResponse;
import rositsa.homework.service.FullParkingException;
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
	
	Calendar calendar = Calendar.getInstance();
	Date now = calendar.getTime();
	
	
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
	
	@ApiOperation(value = "findByDate", nickname = "findByDate", notes= "Get parked vehicles by date")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = ListParkingEventsResponse.class)})
	@RequestMapping(method = RequestMethod.GET, path="/finByDate/{date}",  produces = "application/json")
	public @ResponseBody ListParkingEventsResponse findByDate(@PathVariable("date") @ApiParam(name = "date", value = "2023-03-15", required = true) String date) {
		
		logger.info("Get parked vehicle by date " + date);
		
		ListParkingEventsResponse response = new ListParkingEventsResponse();
		
		List<ParkingEvent> parkingEvents = new ArrayList<ParkingEvent>();
		
		
		response.setParkingEvents(parkingEvents);
		
		return response;
	}
	
	@ApiOperation(value = "get", nickname = "get", notes= "Get Number of occupied spots")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = ListParkingEventsResponse.class)})
	@RequestMapping(method = RequestMethod.GET, path="/numberOfOccupiedSpots",  produces = "application/json")
	public @ResponseBody int numberOfOccupiedSpots() {
		
		logger.info("numberOfOccupiedSpots");
		
		return parkingEventService.findOccupied().size();
	}
	
	@ApiOperation(value = "get", nickname = "get", notes= "Get Number of occupied CAR spots")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = ListParkingEventsResponse.class)})
	@RequestMapping(method = RequestMethod.GET, path="/findOccupiedCarSpots",  produces = "application/json")
	public @ResponseBody int findOccupiedCarSpots() {
		
		logger.info("findOccupiedCarSpots");
		
		return ParkingEventService.CAR_SPOTS - parkingEventService.findFreeCarSpots();
	}
	
	@ApiOperation(value = "get", nickname = "get", notes= "Get Number of occupied BUS spots")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = ListParkingEventsResponse.class)})
	@RequestMapping(method = RequestMethod.GET, path="/findOccupiedBusSpots",  produces = "application/json")
	public @ResponseBody int findOccupiedBusSpots() {
		
		logger.info("findOccupiedBusSpots");
		
		return ParkingEventService.BUS_SPOTS - parkingEventService.findFreeBusSpots();
	}
	
	/**
	 * @param type
	 * @param plateNumber
	 * @return
	 * @throws FullParkingException
	 */
	@ApiOperation(value = "create", nickname = "create", notes= "Create parking event")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = CreateResponse.class)})
	@RequestMapping(method = RequestMethod.POST, path="/type/{type}/plateNumber/{plateNumber}", produces = "application/json")
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
	 * @param plateNumber
	 * @return
	 * @throws BaseRestException
	 */
	@ApiOperation(value = "update", nickname = "update", notes= "Update parking event with endDate")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = CreateResponse.class)})
	@RequestMapping(method = RequestMethod.PUT, path="/plateNumber/{plateNumber}", produces = "application/json")
	public @ResponseBody UpdateResponse update(@PathVariable("plateNumber") String plateNumber) throws BaseRestException {

		logger.info("Update parking event [plateNumber=" + plateNumber + "]");
		
		ParkingEvent parkingEvent = parkingEventService.get(plateNumber);
		
		parkingEventService.exitParking(plateNumber);
		
		return new UpdateResponse(parkingEvent.getPlateNumber());
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
	
	@ExceptionHandler({FullParkingException.class})
	public @ResponseBody Status error(FullParkingException e) {
		Status status = new Status();
		status.setCode("406");
		status.setMessage(e.getMessage());
		status.setType(ResponseTypes.ERROR);
		return status;
	}
}
	