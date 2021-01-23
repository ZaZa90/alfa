package com.example.demo.specification;

import com.example.demo.entity.Supersilly;
import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigInteger;

@UtilityClass
public class SupersillySpecification {
    public static Specification<Supersilly> withNumSupersilly(BigInteger numSupersilly) {
        return numSupersilly == null ? null :
                (root, criteriaQuery, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get("numSupersilly"), numSupersilly);
    }
}
