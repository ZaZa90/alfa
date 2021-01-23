package com.example.demo.controller;

import com.example.demo.entity.Supersilly;
import com.example.demo.service.SupersillyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

import static com.example.demo.constant.ControllerConstant.APPLICATION_HAL_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/super", produces = {APPLICATION_JSON_VALUE, APPLICATION_HAL_JSON_VALUE})
public class SupersillyController {

    @Autowired
    private SupersillyService service;

    @GetMapping(path = "")
    public List<Supersilly> getSupersillyList() {
        return service.retrieveSupersillyList();
    }

    @PostMapping()
    public Supersilly postSupersilly() {
        return service.createSupersilly();
    }

    @DeleteMapping(path = "/{numSupersilly}")
    public Supersilly deleteSupersilly(@PathVariable(name = "numSupersilly")BigInteger numSupersilly) {
        return service.deleteSupersilly(numSupersilly);
    }
}
