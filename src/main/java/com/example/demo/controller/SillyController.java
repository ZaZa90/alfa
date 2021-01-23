package com.example.demo.controller;

import com.example.demo.bin.SillyInputBin;
import com.example.demo.dto.SillyDto;
import com.example.demo.entity.Silly;
import com.example.demo.service.SillyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.util.List;

import static com.example.demo.constant.ControllerConstant.APPLICATION_HAL_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/super/{numSuperSilly}/silly", produces = {APPLICATION_JSON_VALUE, APPLICATION_HAL_JSON_VALUE})
public class SillyController {

    @Autowired
    private SillyService service;

    @GetMapping
    public List<Silly> getSillyList(@PathVariable(name = "numSuperSilly") @NotNull final BigInteger numSuperSilly) {
        return service.retrieveSillyList(numSuperSilly);
    }

    @GetMapping(path = "/{numSilly}")
    public Silly getSillyList(@PathVariable(name = "numSuperSilly") @NotNull final BigInteger numSuperSilly,
                              @PathVariable(name = "numSilly") @NotNull final BigInteger numSilly) {
        return service.retrieveSilly(numSuperSilly, numSilly);
    }

    @PostMapping
    public Silly postSilly(@PathVariable(name = "numSuperSilly") @NotNull final BigInteger numSuperSilly,
                           @RequestBody SillyDto dto) {
        SillyInputBin inputBin = SillyInputBin.builder()
                .numSupersilly(numSuperSilly)
                .desCognome(dto.getDesCognome())
                .desNome(dto.getDesNome())
                .flgAlive(dto.isFlgAlive())
                .build();
        return service.createSilly(inputBin);
    }

    @PutMapping(path = "/{numSilly}")
    public Silly putSilly(@PathVariable(name = "numSuperSilly") @NotNull final BigInteger numSuperSilly,
                          @PathVariable(name = "numSilly") @NotNull final BigInteger numSilly,
                          @RequestBody SillyDto dto) {
        SillyInputBin inputBin = SillyInputBin.builder()
                .numSupersilly(numSuperSilly)
                .numSilly(numSilly)
                .desCognome(dto.getDesCognome())
                .desNome(dto.getDesNome())
                .flgAlive(dto.isFlgAlive())
                .build();
        return service.modifySilly(inputBin);
    }

    @DeleteMapping(path = "/{numSilly}")
    public Silly deleteSilly(@PathVariable(name = "numSuperSilly") @NotNull final BigInteger numSuperSilly,
                             @PathVariable(name = "numSilly") BigInteger numSilly) {
        return service.deleteSilly(numSuperSilly, numSilly);
    }
}
