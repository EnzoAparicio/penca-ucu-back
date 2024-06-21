package uy.edu.ucu.pencaucu.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {

	public static <T> ResponseEntity<T> okResponse(T entity) {
		return new ResponseEntity<T>(entity, HttpStatus.OK);
	}
	
	public static <T> ResponseEntity<T> noContent() {
		return new ResponseEntity<T>(HttpStatus.NO_CONTENT);
	}
	
	public static <T> ResponseEntity<T> badRequest() {
		return new ResponseEntity<T>(HttpStatus.BAD_REQUEST);
	}
	
	public static <T> ResponseEntity<T> internalError() {
		return new ResponseEntity<T>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
