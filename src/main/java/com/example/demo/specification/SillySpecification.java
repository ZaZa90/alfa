package com.example.demo.specification;

import com.example.demo.entity.Silly;
import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigInteger;

@UtilityClass
public class SillySpecification {
    public static Specification<Silly> withNumSupersilly(BigInteger numSupersilly) {
        return numSupersilly == null ? null :
                (root, criteriaQuery, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get("numSupersilly"), numSupersilly);
    }

    public static Specification<Silly> withNumSilly(BigInteger numSilly) {
        return numSilly == null ? null :
                (root, criteriaQuery, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get("numSilly"), numSilly);
    }
}
