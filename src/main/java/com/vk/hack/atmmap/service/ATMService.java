package com.vk.hack.atmmap.service;

import com.vk.hack.atmmap.model.ATM;
import com.vk.hack.atmmap.model.ATM.Type;

import java.util.List;

public interface ATMService {

    List<ATM> getFiltered(String bank, Type type, Integer distance, Double lat, Double lon, ATM.Currency currency,Integer workFrom,Integer workTill,Boolean workAround);

    List<String> getBanks();
}
