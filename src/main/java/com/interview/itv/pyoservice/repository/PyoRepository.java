package com.interview.itv.pyoservice.repository;

import com.interview.itv.pyoservice.model.Pyo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PyoRepository extends JpaRepository<Pyo, Long> {
    @Query(value = "SELECT b.id AS campaignId, b.broadcast_date, b.start_time, b.duration, bc.advertiser_id, c.spot_length FROM break b INNER JOIN break_campaign bc on b.id=bc.break_id INNER JOIN campaign c on bc.campaign_id=c.id", nativeQuery = true)
    List<Map<String, Object>> findPyo();
}
