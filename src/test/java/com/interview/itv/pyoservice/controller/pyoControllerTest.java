package com.interview.itv.pyoservice.controller;

import com.interview.itv.pyoservice.model.Break;
import com.interview.itv.pyoservice.service.PyoService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

@RunWith(MockitoJUnitRunner.class)
public class pyoControllerTest {

    @Mock
    PyoService pyoService;

    @InjectMocks
    PyoController pyoController;

    Break breakA, breakB;
    ArrayList<Break> breaks;

    @Before
    public void init(){

        breakA = new Break();
        breakB = new Break();

        breakA.setBreakId(1L);
        breakA.setDate(LocalDate.of(2021, Month.NOVEMBER, 27));
        breakA.setDuration(205);
        breakA.setTime(95800);

        breakB.setBreakId(2L);
        breakB.setDate(LocalDate.of(2021, Month.NOVEMBER, 28));
        breakB.setDuration(200);
        breakB.setTime(105800);

        breaks = new ArrayList<>();
        breaks.add(breakA);
    }

    @Test
    public  void getAllTest(){
//        Mockito.when(likeService.findAll()).thenReturn(likes);
//        ResponseEntity<ArrayList<Like>> response = likeController.getAll();
//        Assert.assertEquals(likes, response.getBody());
    }

    @Test
    public  void deleteByIdTest(){
//        likeService.deleteById(likeA.getId());
//        Mockito.verify(likeService, Mockito.times(1)).deleteById(likeA.getId());
    }

}
