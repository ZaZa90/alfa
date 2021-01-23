package com.example.demo.repository;

import com.example.demo.entity.Supersilly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;

@Component
@Transactional(readOnly = true)
public interface SupersillyRepository extends JpaRepository<Supersilly, BigInteger>, JpaSpecificationExecutor<Supersilly> {

    @Query("select coalesce(MAX(numSupersilly),0) FROM Supersilly")
    BigInteger findMaxNumSupersilly();
}
