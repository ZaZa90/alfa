package com.example.demo.service;

import com.example.demo.SillyMapper;
import com.example.demo.bin.SillyInputBin;
import com.example.demo.entity.Silly;
import com.example.demo.exception.SillyException;
import com.example.demo.repository.SillyRepository;
import com.example.demo.specification.SillySpecification;
import lombok.AllArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.util.List;

@Service
@AllArgsConstructor
public class SillyService {

    private SillyRepository sillyRepository;
    private SillyMapper sillyMapper;

    public List<Silly> retrieveSillyList(@NotNull BigInteger numSuperSilly){
        return sillyRepository.findAll(SillySpecification.withNumSupersilly(numSuperSilly));
    }

    public Silly retrieveSilly(@NotNull BigInteger numSuperSilly, BigInteger numSilly){
        Specification<Silly> sillySpecification = SillySpecification.withNumSupersilly(numSuperSilly)
                .and(SillySpecification.withNumSilly(numSilly));
        List<Silly> sillyList = sillyRepository.findAll(sillySpecification);
        if (CollectionUtils.isEmpty(sillyList)) {
            throw SillyException.getSillyNotFoundException();
        }
        return IterableUtils.first(sillyList);
    }

    @Transactional
    public Silly createSilly(SillyInputBin silly) {
        BigInteger numSilly = sillyRepository.findMaxNumSilly(silly.getNumSupersilly()).add(BigInteger.ONE);
        silly.setNumSilly(numSilly);
        return sillyRepository.save(sillyMapper.mapBinToEntity(silly));
    }

    @Transactional
    public Silly modifySilly(SillyInputBin inputBin) {
        Silly sillyFromDb = retrieveSilly(inputBin.getNumSupersilly(), inputBin.getNumSilly());
        Silly newSilly = sillyMapper.mapBinToEntity(inputBin);
        sillyMapper.updateSillyEntity(sillyFromDb, newSilly);
        return sillyFromDb;
    }

    @Transactional
    public Silly deleteSilly(@NotNull BigInteger numSuperSilly, BigInteger numSilly) {
        Silly silly = retrieveSilly(numSuperSilly, numSilly);
        sillyRepository.delete(silly);
        return silly;
    }
}
