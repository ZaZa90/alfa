package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class SillyDto {

    private String desNome;
    private String desCognome;
    private boolean flgAlive;
}
