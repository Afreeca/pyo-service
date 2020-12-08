package com.interview.itv.pyoservice.service;

import com.interview.itv.pyoservice.model.Pyo;
import org.springframework.stereotype.Service;

@Service
public interface PyoService {
    Pyo bookPyo(Pyo pyo);
    Pyo getAll();
    boolean pyoExists(Long pyo);
    void cancelPyo(Long pyoId);
}