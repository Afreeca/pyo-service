package com.interview.itv.pyoservice.service;

import com.interview.itv.pyoservice.model.Pyo;
import com.interview.itv.pyoservice.repository.PyoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PyoServiceImp implements PyoService {

    @Autowired
    PyoRepository pyoRepository;

    @Override
    public Pyo bookPyo(Pyo pyo) {
        return pyoRepository.save(pyo);
    }

    @Override
    public Pyo getAll() {
        return null;
    }

    @Override
    public void cancelPyo(Long CampaignId) {
        pyoRepository.deletePyoByCampaignId(CampaignId);
    }

    @Override
    public boolean pyoExists(Long pyo) {
        return pyoRepository.existsById(pyo);
    }
}