package com.nutripal.cps.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nutripal.cps.entity.CallData;

@Repository
public interface CallDataRepo extends JpaRepository<CallData, Integer> {

}
