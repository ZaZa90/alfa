package com.example.demo.repository;

import com.example.demo.entity.Silly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;

@Component
@Transactional(readOnly = true)
public interface SillyRepository extends JpaRepository<Silly, BigInteger>, JpaSpecificationExecutor<Silly> {

    @Query("select coalesce(MAX(numSilly),0) FROM Silly WHERE numSupersilly = :numSupersilly")
    BigInteger findMaxNumSilly(@Param("numSupersilly") BigInteger numSupersilly);
}
