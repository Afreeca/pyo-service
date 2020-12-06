package com.interview.itv.pyoservice.controller;

import com.interview.itv.pyoservice.dto.PyoDtoRequest;
import com.interview.itv.pyoservice.dto.PyoDtoResponse;
import com.interview.itv.pyoservice.model.Pyo;
import com.interview.itv.pyoservice.service.PyoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
@ApiResponses(value = {
        @ApiResponse(code = 400, message = "Something went wrong"),
        @ApiResponse(code = 401, message = "Unauthorised Operation"),
        @ApiResponse(code = 403, message = "Access denied")})
public class PyoController {

    @Autowired
    PyoService pyoService;

    @Autowired
    private ModelMapper modelMapper;

    @ApiOperation(value="Get a list of breaks with their associated PYO requests")
    @GetMapping(value="/break")
    public ResponseEntity<ArrayList<PyoDtoResponse>> getBreaksPyo() {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @ApiOperation(value="Book a PYO request for a campaign in a specific break")
    @PostMapping(value="/break")
    public ResponseEntity<Pyo> bookPyo(@Valid @RequestBody PyoDtoRequest pyoDto) {
        System.out.println("MERDA: " + pyoDto.getBreakId());
        Pyo pyoReq = Pyo.convert(pyoDto);
        return new ResponseEntity<Pyo>(pyoService.bookPyo(pyoReq), HttpStatus.OK);
    }

//    private PyoDtoRequest convertToDto(PyoDtoRequest pyoDto) {
//        Pyo pyo = modelMapper.map(pyoDto, Pyo.class);
//        pyo.setBreakId(pyoDto.getBreakId()),
//                postDto.wait(post.getBreakId(),
//                userService.getCurrentUser().getPreference().getTimezone());
//        return postDto;
//    }

    @ApiOperation(value="Cancel a PYO request")
    @DeleteMapping(value="/break/{campaignId}")
    public ResponseEntity<Pyo> cancelPyo(@PathVariable int campaignId) {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
