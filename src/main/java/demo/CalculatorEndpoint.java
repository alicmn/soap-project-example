package demo;

import com.calculator.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CalculatorEndpoint {
	private static final String NAMESPACE_URI = "https://calculator.com/calculation";

	private static final Logger log =
			LoggerFactory.getLogger(CalculatorEndpoint.class);

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "addRequest")
	@ResponsePayload
	public AddResponse getCountry(@RequestPayload AddRequest request) {
		AddResponse response = new AddResponse();
		response.setResult(request.getX()+request.getY());
		log.info("A request for adding: " + request.getX() + " + " + request.getY());
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "multiplicationRequest")
	@ResponsePayload
	public MultiplicationResponse getCountry(@RequestPayload MultiplicationRequest request) {
		MultiplicationResponse  response = new MultiplicationResponse();
		response.setResult(request.getX()*request.getY());
		log.info("A request for multiplication: " + request.getX() + " * " + request.getY());
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "minusRequest")
	@ResponsePayload
	public MinusResponse getCountry(@RequestPayload MinusRequest request) {
		MinusResponse response = new MinusResponse();
		response.setResult(request.getX()-request.getY());
		log.info("A request for substraction: " + request.getX() + " - " + request.getY());
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "divisionRequest")
	@ResponsePayload
	public DivisionResponse getCountry(@RequestPayload DivisionRequest request) {
		DivisionResponse response = new DivisionResponse();
		response.setResult(request.getX()/request.getY());
		log.info("A request for division: " + request.getX() + " - " + request.getY());
		return response;
	}

}
