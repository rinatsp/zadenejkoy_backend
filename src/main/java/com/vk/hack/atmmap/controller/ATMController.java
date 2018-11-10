package com.vk.hack.atmmap.controller;

import com.vk.hack.atmmap.model.ATM;
import com.vk.hack.atmmap.service.ATMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class ATMController {

    private ATMService service;

    @Autowired
    public ATMController(ATMService service) {
        this.service = service;
    }

    @GetMapping("/filter")
    public List<ATM> getFiltered(@RequestParam(value = "bank", required = false) String bank,
                                 @RequestParam(value = "type", required = false) ATM.Type type,
                                 @RequestParam(value = "distance", required = false) Integer distance,
                                 @RequestParam(value = "lat", required = false) Double lat,
                                 @RequestParam(value = "lon", required = false) Double lon,
                                 @RequestParam(value = "currency", required = false) ATM.Currency currency,
                                 @RequestParam(value = "workFrom", required = false)  Integer workFrom,
                                 @RequestParam(value = "workTill",required = false) Integer workTill,
                                 @RequestParam(value = "workAround",required = false)Boolean workAround) {
        return service.getFiltered(bank, type, distance, lat, lon,currency,workFrom,workTill,workAround);
    }

}
