package com.interview.itv.pyoservice.repository;

import com.interview.itv.pyoservice.model.Break;
import com.interview.itv.pyoservice.model.Campaign;
import com.interview.itv.pyoservice.model.Pyo;
import com.interview.itv.pyoservice.service.PyoServiceImp;
import com.interview.itv.pyoservice.utils.Types;
import org.junit.Assert;
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

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PyoRepositoryTest {

    @Mock
    PyoRepository pyoRepository;

    @InjectMocks
    PyoServiceImp pyoService;

    Break breakA;
    Campaign campaignA;
    Pyo pyoA;

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
    public void testFindPyo(){
        when(pyoRepository.findPyo()).thenReturn(pyolist);
        List<Map<String, Object>> result = pyoService.getAllPyo();
        Assert.assertEquals(pyolist, result);
    }
}
