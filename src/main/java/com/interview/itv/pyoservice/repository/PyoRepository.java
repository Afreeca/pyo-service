package com.interview.itv.pyoservice.repository;

import com.interview.itv.pyoservice.model.Pyo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PyoRepository extends JpaRepository<Pyo, Long> {
    void deleteByCampaignId(Long campaignId);

//    @Query("SELECT b.broadcast_date, b.start_time, b.duration, c.advertiser_id, c.spot_length FROM break b LEFT JOIN campaign c on b.id=c.id")
//    List<PyoDto> findByWithPyo();
}
