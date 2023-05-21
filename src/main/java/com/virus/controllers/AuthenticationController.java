package com.virus.controllers;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virus.model.dtos.AppUserDTO;
import com.virus.model.enumerateds.ErrorCode;
import com.virus.model.exceptions.UserManagementException;
import com.virus.services.dto.UserConverterService;
import com.virus.services.entity.UserService;

/*
* Controller for API Rest. 
* 
* Annotated by @RestController and @RequestMapping. its mapped in [url]:[port]/auth
* 
* This controller is responsible for the creation and login of users in the system. It also allows account activation.
* 
* @author J. Rubén Daza
*/
@RestController
@RequestMapping(path = "/auth")
public class AuthenticationController {

	@Autowired
	protected UserService service;

	@Autowired
	protected UserConverterService converter;

	/*
	 * HTTP/POST
	 * 
	 * This method allows you to register a new user in the system.
	 * 
	 * @param user UserDTO
	 * 
	 * @return ResponseEntity<BodyErrorCode>.
	 */
	@PostMapping("/sign-up")
	public ResponseEntity<?> signUpUser(@RequestBody AppUserDTO user) {
		ResponseEntity<?> response = null;

		try {
			// We dont need control anything here, Security package do.

			Logger.global.info("USUARIO RECIBIDO: \n" + user.toString());
			
			user = service.signUpUser(user);
			response = ResponseEntity.status(HttpStatus.OK).body(ErrorCode.NO_ERROR);
		} catch (UserManagementException ex) {
			ex.printStackTrace();
			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorCode.TOKEN_EXPIRED); //TOKEN_EXPIRED BC I CAN! /!\ Remind change later.
		} catch (Exception ex) {
			ex.printStackTrace();
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ErrorCode.INDETERMINATE_ERROR);
		}
		return response;
	}

	/*
	 * HTTP/POST
	 * 
	 * This controller allows logging an account in the system, in the response the
	 * JWT token will be returned.
	 * 
	 * @param user UserDTO
	 * 
	 * @return ResponseEntity<BodyErrorCode>.
	 */
	@GetMapping("/sign-in")
	public ResponseEntity<?> signIn(@RequestBody AppUserDTO user) {
		ResponseEntity<?> response = null;
		
		// We dont need control anything here, Security package do.
		response = ResponseEntity.status(HttpStatus.OK).body(ErrorCode.NO_ERROR);
		
		return response;
	}

}