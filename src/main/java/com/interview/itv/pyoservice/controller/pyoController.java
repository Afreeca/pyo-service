package com.interview.itv.pyoservice.controller;

import com.interview.itv.pyoservice.dto.PyoDto;
import com.interview.itv.pyoservice.model.Campaign;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<ArrayList<PyoDto>> getBreaksPyo() {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @ApiOperation(value="Book a PYO request for a campaign in a specific break")
    @PostMapping("/break")
    public ResponseEntity<Campaign> bookPyo(@Valid @RequestBody PyoDto Pyo) {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @ApiOperation(value="Cancel a PYO request")
    @DeleteMapping("/break/{campaignId}")
    public ResponseEntity<Campaign> cancelPyo(@PathVariable int campaignId) {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
