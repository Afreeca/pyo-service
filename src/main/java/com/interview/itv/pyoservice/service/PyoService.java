package com.interview.itv.pyoservice.service;

import com.interview.itv.pyoservice.model.Pyo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface PyoService {
    Pyo bookPyo(Pyo pyo);
    boolean pyoExists(Long pyo);
    void cancelPyo(Long pyoId);
    List<Map<String, Object>> getAllPyo();
}
