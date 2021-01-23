package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "T_PAD_SUPERSILLY")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Supersilly {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NUM_SUPERSILLY")
    private BigInteger numSupersilly;

}
