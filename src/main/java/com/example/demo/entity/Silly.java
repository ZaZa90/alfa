package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "T_PAD_SILLY")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Silly {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SILLY")
    private BigInteger id;

    @Column(name = "NUM_SUPERSILLY")
    private BigInteger numSupersilly;

    @Column(name = "NUM_SILLY")
    private BigInteger numSilly;

    @Column(name = "DES_NOME")
    private String desNome;

    @Column(name = "DES_COGNOME")
    private String desCognome;

    @Column(name = "FLG_ALIVE")
    private boolean flgAlive;

}
