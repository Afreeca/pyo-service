package com.interview.itv.pyoservice.service;

import com.interview.itv.pyoservice.model.Pyo;
import com.interview.itv.pyoservice.repository.PyoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class PyoServiceImp implements PyoService {

    @Autowired
    PyoRepository pyoRepository;

    @Override
    public Pyo bookPyo(Pyo pyo) { return pyoRepository.save(pyo); }

    @Override
    public void cancelPyo(Long pyoId) { pyoRepository.deleteById(pyoId); }

    @Override
    public boolean pyoExists(Long pyo) {
        return pyoRepository.existsById(pyo);
    }

    @Override
    public List<Map<String, Object>> getAllPyo() {
       return pyoRepository.findPyo();
    }
}
