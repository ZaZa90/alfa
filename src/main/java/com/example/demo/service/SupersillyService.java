package com.example.demo.service;

import com.example.demo.entity.Supersilly;
import com.example.demo.exception.SillyException;
import com.example.demo.repository.SupersillyRepository;
import com.example.demo.specification.SupersillySpecification;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.List;

@Service
public class SupersillyService {

    @Autowired
    private SupersillyRepository supersillyRepository;

    public List<Supersilly> retrieveSupersillyList(){
        return supersillyRepository.findAll();
    }

    @Transactional
    public Supersilly createSupersilly() {
        return supersillyRepository.save(new Supersilly());
    }

    @Transactional
    public Supersilly deleteSupersilly(BigInteger numSupersilly) {
        Supersilly supersilly = retrieveSupersilly(numSupersilly);
        supersillyRepository.delete(supersilly);
        return supersilly;
    }

    private Supersilly retrieveSupersilly(BigInteger numSupersilly) {
        List<Supersilly> supersillyList = supersillyRepository.findAll(SupersillySpecification.withNumSupersilly(numSupersilly));
        if (CollectionUtils.isEmpty(supersillyList)) {
            throw SillyException.getSupersillyNotFoundException();
        }
        return IterableUtils.first(supersillyList);
    }
}
