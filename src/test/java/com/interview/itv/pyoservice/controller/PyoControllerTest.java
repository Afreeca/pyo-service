package com.interview.itv.pyoservice.controller;

import com.interview.itv.pyoservice.dto.PyoDtoRequest;
import com.interview.itv.pyoservice.exception.NotFoundException;
import com.interview.itv.pyoservice.model.Break;
import com.interview.itv.pyoservice.model.Campaign;
import com.interview.itv.pyoservice.model.Pyo;
import com.interview.itv.pyoservice.service.PyoService;
import com.interview.itv.pyoservice.utils.Types;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PyoControllerTest {

    @Mock
    PyoService pyoService;

    @InjectMocks
    PyoController pyoController;

    Break breakA;
    Campaign campaignA;
    Pyo pyoA;
    PyoDtoRequest pyoDtoRequest;

    Map<String, Object> pyoMap;
    List<Map<String, Object>> pyolist;
    @Before
    public void init(){

        breakA = new Break();
        breakA.setBreakId(1L);
        breakA.setDate(LocalDate.of(2021, Month.NOVEMBER, 27));
        breakA.setDuration(205);
        breakA.setTime(95800);

        campaignA = new Campaign();
        campaignA.setCampaignId(2L);
        campaignA.setAdvertiserId("242323");
        campaignA.setDemographic(Types.Profile.ADULTS);
        campaignA.setPyoPercentage(80);
        campaignA.setSpotLength(90);
        campaignA.setTargetTVR(11);

        pyoA = new Pyo();
        pyoA.setAdvertiserId("242323");
        pyoA.setBreakId(1L);
        pyoA.setId(1L);
        pyoA.setCampaignId(2L);

        pyoDtoRequest =  new PyoDtoRequest();
        pyoDtoRequest.setAdvertiserId("242323");
        pyoDtoRequest.setBreakId(1L);
        pyoDtoRequest.setCampaignId(2L);

        pyoMap = new HashMap<>();
        pyoMap.put("spot_length", 210);
        pyoMap.put("duration", breakA.getDuration());
        pyoMap.put("start_time", breakA.getTime());
        pyoMap.put("broadcast_date", breakA.getDate());
        pyoMap.put("id", campaignA.getCampaignId());
        pyoMap.put("advertiser_id", campaignA.getAdvertiserId());

        pyolist = new ArrayList<>();
        pyolist.add(pyoMap);
    }

    @Test
    public  void testGetAllTPyo(){
        when(pyoService.getAllPyo()).thenReturn(pyolist);
        ResponseEntity<List<Map<String, Object>>> response = pyoController.getBreaksPyo();
        Assert.assertEquals(pyolist, response.getBody());
    }

//    @Test
//    public  void testBookPyo(){
//        Mockito.when(pyoService.bookPyo(pyoA)).thenReturn(pyoA);
//
//        PyoService spy = PowerMockito.spy(pyoService);
//        Mockito.doNothing().when(spy, "validatePyoRequest", ArgumentMatchers.any());
//        ResponseEntity<Pyo> response =  pyoController.bookPyo(pyoDtoRequest);
//        Assert.assertEquals(pyoA, response.getBody());
//    }

    @Test
    public  void testDeleteByIdTest(){
        when(pyoService.pyoExists(pyoA.getBreakId())).thenReturn(true);
        pyoController.cancelPyo(pyoA.getBreakId());
        verify(pyoService, times(1)).cancelPyo(pyoA.getBreakId());
    }

    @Test(expected = NotFoundException.class)
    public  void testDeleteByIdTestUnknownBreakId(){
        when(pyoService.pyoExists(3L)).thenThrow(new NotFoundException(""));
        pyoController.cancelPyo(3L);
        verify(pyoService, times(0)).cancelPyo(3L);
    }
}
