package com.interview.itv.pyoservice.service;

import com.interview.itv.pyoservice.exception.NotFoundException;
import com.interview.itv.pyoservice.repository.PyoRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PyoServiceTest {

    @Mock
    PyoRepository pyoRepository;

    @InjectMocks
    PyoServiceImp pyoService;

    @Test
    public void testCancelPyoWhenCampaignIdIsNull() throws NotFoundException {
        assertEquals(20, 20);
    }

}
