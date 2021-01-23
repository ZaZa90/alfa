package com.example.demo.bin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SillyInputBin {

    private BigInteger numSupersilly;
    private BigInteger numSilly;
    private String desNome;
    private String desCognome;
    private boolean flgAlive;
}
