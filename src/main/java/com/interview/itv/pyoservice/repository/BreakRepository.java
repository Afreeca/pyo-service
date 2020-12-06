package com.interview.itv.pyoservice.repository;

import com.interview.itv.pyoservice.dto.PyoDto;
import com.interview.itv.pyoservice.model.Break;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BreakRepository extends JpaRepository<Break, Long> {

//    @Query("SELECT b.broadcast_date, b.start_time, b.duration, c.advertiser_id, c.spot_length FROM break b LEFT JOIN campaign c on b.id=c.id")
//    List<PyoDto> findByWithPyo();
}
