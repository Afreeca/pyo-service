package com.interview.itv.pyoservice.service;

import com.interview.itv.pyoservice.dto.PyoDtoRequest;
import com.interview.itv.pyoservice.model.Break;
import com.interview.itv.pyoservice.model.Campaign;
import com.interview.itv.pyoservice.model.Pyo;
import com.interview.itv.pyoservice.repository.PyoRepository;
import com.interview.itv.pyoservice.utils.Types;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PyoServiceTest {

    @InjectMocks
    PyoServiceImp pyoService;

    @Mock
    PyoRepository pyoRepository;

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
    public void testBookPyo() {
        when(pyoRepository.save(pyoA)).thenReturn(pyoA);
        Pyo newPyo = pyoService.bookPyo(pyoA);
        assertEquals(pyoA, newPyo);
    }

    @Test
    public void testCancelPyo() {
        pyoService.cancelPyo(pyoA.getBreakId());
        verify(pyoRepository, times(1)).deleteById(pyoA.getBreakId());
    }

    @Test
    public  void testPyoExists(){
        when(pyoRepository.existsById(pyoA.getBreakId())).thenReturn(true);
        boolean result = pyoService.pyoExists(pyoA.getBreakId());
        assertTrue(result);
    }

    @Test
    public  void testPyoExistsIdNotFound(){
        when(pyoRepository.existsById(pyoA.getBreakId())).thenReturn(false);
        boolean result = pyoService.pyoExists(pyoA.getBreakId());
        assertFalse(result);
    }

    @Test
    public  void testGetAllPyo(){
        when(pyoRepository.findPyo()).thenReturn(pyolist);
        List<Map<String, Object>> result = pyoService.getAllPyo();
        assertEquals(pyolist, result);
    }
}
