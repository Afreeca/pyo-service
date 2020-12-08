package com.interview.itv.pyoservice.controller;

import com.interview.itv.pyoservice.dto.PyoDtoRequest;
import com.interview.itv.pyoservice.dto.PyoDtoResponse;
import com.interview.itv.pyoservice.exception.NotFoundException;
import com.interview.itv.pyoservice.exception.PyoExistsException;
import com.interview.itv.pyoservice.model.Pyo;
import com.interview.itv.pyoservice.repository.BreakRepository;
import com.interview.itv.pyoservice.repository.CampaignRepository;
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
@ApiResponses(value = {
        @ApiResponse(code = 500, message = "Server Error"),
        @ApiResponse(code = 400, message = "Something Went Wrong"),
        @ApiResponse(code = 409, message = "Conflict With Existing Resource"),
        @ApiResponse(code = 404, message = "Resource Not Found")})
public class PyoController {

    @Autowired
    PyoService pyoService;

    @Autowired
    BreakRepository breakRepository;

    @Autowired
    CampaignRepository campaignRepository;

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
        validatePyoRequest(pyoDto);
        Pyo pyo = modelMapper.map(pyoDto, Pyo.class);
        return new ResponseEntity<>(pyoService.bookPyo(pyo), HttpStatus.OK);
    }

    @ApiOperation(value="Cancel a PYO request")
    @DeleteMapping(value="/break/{campaignId}")
    public ResponseEntity<Void> cancelPyo(@PathVariable Long campaignId) {
        if(!pyoService.pyoExists(campaignId))
            throw new NotFoundException(String.format("PYO with campaignId '%d' Not found", campaignId));
        pyoService.cancelPyo(campaignId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    private void validatePyoRequest(PyoDtoRequest pyo) {
        if (campaignRepository.existsById(pyo.getCampaignId()) && breakRepository.existsById(pyo.getBreakId())) {
            throw new PyoExistsException(String.format("Pyo with campaignId '%d' and breakId '%d' already exists", pyo.getCampaignId(), pyo.getBreakId()));
        } else if (!campaignRepository.existsById(pyo.getCampaignId())) {
            throw new NotFoundException(String.format("Campaign with Id '%d' Not found", pyo.getCampaignId()));
        } else if (!breakRepository.existsById(pyo.getBreakId())) {
            throw new NotFoundException(String.format("Break with Id '%d' Not found", pyo.getCampaignId()));
        }
    }
}
