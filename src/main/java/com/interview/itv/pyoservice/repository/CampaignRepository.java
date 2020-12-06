package com.interview.itv.pyoservice.repository;

import com.interview.itv.pyoservice.model.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Long> { }
