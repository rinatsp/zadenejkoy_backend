package com.vk.hack.atmmap.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vk.hack.atmmap.model.ATM;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class TestController {

    @GetMapping("/test")
    List<ATM> test() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(getClass().getClassLoader().getResource("atm.json"), new TypeReference<List<ATM>>() {
        });
    }
}
