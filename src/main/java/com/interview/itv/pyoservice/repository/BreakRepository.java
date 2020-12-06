package com.interview.itv.pyoservice.repository;

import com.interview.itv.pyoservice.model.Break;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BreakRepository extends JpaRepository<Break, Long> { }
