package rositsa.homework.rest;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Index controller<br/>
 * 
 * Used to check the status of the test server<br/>
 * 
 * @version $Id:$
 * @author Rositsa
 * @since 1.0
 *
 */
@Controller
@EnableAutoConfiguration
public class IndexController {

    @ApiOperation(value = "index", nickname = "index")
	@RequestMapping(method = RequestMethod.GET, path="/", produces = "text/html")
	@ApiResponses(value = 
		{ 
			@ApiResponse(code = 200, message = "Success", response = String.class)
		}
	) 
    @ResponseBody String home() {
        return "Homework Server is up!";
    }
    
    /* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Index Controler - Show emulator's status";
	}
	
	@ExceptionHandler({Exception.class})
	public @ResponseBody Status error(Exception e) {
		Status status = new Status();
		status.setMessage(e.getMessage());
		return status;
	}
}