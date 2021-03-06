package com.vk.hack.atmmap.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vk.hack.atmmap.model.ATM;
import com.vk.hack.atmmap.util.DistanceUtil;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ATMServiceImpl implements ATMService {

    private static List<ATM> atms;
    private static List<String> banks;

    @PostConstruct
    private void init() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        atms = mapper.readValue(getClass().getClassLoader().getResource("data.json"), new TypeReference<List<ATM>>() {
        });
        banks = atms.stream()
            .map(ATM::getBank)
            .distinct()
            .collect(Collectors.toList());
    }


    @Override
    public List<ATM> getFiltered(String bank, ATM.Type type, Integer distance, Double lat, Double lon,
                                 ATM.Currency currency, Integer workFrom, Integer workTill, Boolean workAround) {

        Stream<ATM> atmStream = atms.stream().filter(atm -> bank == null || atm.getBank().equalsIgnoreCase(bank))
            .filter(atm -> type == null || atm.getType().equals(type))
            .filter(atm -> distance == null || DistanceUtil.distance(lat, lon, atm.getLat(), atm.getLon()) <= distance/1000.0)
            .filter(atm -> currency == null || atm.getCurrency().equals(currency));
        if (workAround != null && workAround) {
            return atmStream.filter(ATM::isAroundTheClock).collect(Collectors.toList());
        }

        return atmStream.filter(atm -> workFrom == null || atm.getWorkFrom() <= workFrom)
            .filter(atm -> workTill == null || atm.getWorkTill() >= workTill)
            .collect(Collectors.toList());
    }

    @Override
    public List<String> getBanks() {
        return banks;
    }
}
