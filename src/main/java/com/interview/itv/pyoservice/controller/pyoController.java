package com.interview.itv.pyoservice.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
@ApiOperation(value="/pyo/v1/", tags = "PYO RestFul API" )
@ApiResponses(value = {
        @ApiResponse(code = 400, message = "Something went wrong"),
        @ApiResponse(code = 401, message = "Unauthorised Operation"),
        @ApiResponse(code = 403, message = "Access denied")})
public class pyoController {

    @ApiOperation(value="Get a list of breaks with their associated PYO requests")
    @GetMapping("/break")
    public ResponseEntity<ArrayList<?>> getBreaks() {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @ApiOperation(value="Book a PYO request for a campaign in a specific break")
    @PostMapping("/break")
    public ResponseEntity<ArrayList<?>> bookPyo() {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }


    @ApiOperation(value="Cancel a PYO request")
    @DeleteMapping("/break/{breakId}")
    public ResponseEntity<ArrayList<?>> cancelPyo(@PathVariable int breakId) {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

//	private void validateInput(UUID clientId, LocalDate from, LocalDate to, long limit, long offset) {
//		if (clientId == null) {
//			throw new BadRequestException("null client id", "client id cannot be null", "get-on-us-payments.null-client");
//		} else if (from != null && to != null && to.isBefore(from)) {
//			throw new BadRequestException("invalid dates", "to date cannot be before from", "get-on-us-payments.invalid-dates");
//		} else if (limit <= 0) {
//			throw new BadRequestException("invalid limit", "limit must be positive", "get-on-us-payments.invalid-limit");
//		} else if (offset < 0) {
//			throw new BadRequestException("invalid offset", "offset cannot be negative", "get-on-us-payments.invalid-offset");
//		}
//	}
}
