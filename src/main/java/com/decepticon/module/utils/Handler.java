package com.decepticon.module.utils;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class Handler {
    private static HashMap<String, String> coreHashMap = new HashMap<>();
    private static List<String> keyNameList = new ArrayList<>();

    public static List<String> getKeyName() {
//        if (keyNameList.isEmpty()) {
//            keyNameList = Utility.readFromFile("src/test/resources/keyname.csv");
//        }
        return keyNameList;
    }

    public static HashMap<String, String> getCoreHashMap() {
        return coreHashMap;
    }

    public static String getCoreHashMapValue(String key) {
        try {
            String value = coreHashMap.get(key);
            if (value == null)
                return "-";
            else
                return value;
        } catch (Exception e) {
            System.out.println("Error getting " + key);
            return "-";
        }
    }

    public static void putCoreHashMap(String key, String value) {
        try {
            coreHashMap.put(key, value);
        } catch (Exception e) {
            coreHashMap.put(key, "-");
        }
    }

    public static void clearCoreHashMap() {
        coreHashMap.clear();
    }

    public static Boolean checkPokemonType(String input, String expected) {
        String[] listInput = input.split(",");
        String[] listExpected = expected.split(",");

        Boolean result = false;
        for (int i = 0; i < listInput.length; i++) {
            for (int j = 0; j < listExpected.length; j++) {
                if (listInput[i].equalsIgnoreCase(listExpected[j])) {
                    result = true;
                    break;
                }
                else if (Dictionary.checkIndonesiaToEnglish(listInput[i], listExpected[j])) {
                    result = true;
                    break;
                }
                else
                    result = false;
            }
            if (result == false)
                return false;
        }
        return result;
    }
}