package com.decepticon.module.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class Dictionary {

    private static HashMap<String, List<String>> indonesiaToEnglish = new HashMap<>();

    private static void initiateDictionary() {
        indonesiaToEnglish.put("listrik", new ArrayList<>(Arrays.asList("electric")));
        indonesiaToEnglish.put("api", new ArrayList<>(Arrays.asList("fire")));
        indonesiaToEnglish.put("terbang", new ArrayList<>(Arrays.asList("flying")));
        indonesiaToEnglish.put("psikis", new ArrayList<>(Arrays.asList("psychic")));
        indonesiaToEnglish.put("racun", new ArrayList<>(Arrays.asList("poison")));
        indonesiaToEnglish.put("air", new ArrayList<>(Arrays.asList("water")));
        indonesiaToEnglish.put("rumput", new ArrayList<>(Arrays.asList("grass")));
    }

    public static Boolean checkIndonesiaToEnglish (String input, String expected) {
        if (indonesiaToEnglish.isEmpty())
            initiateDictionary();
        List<String> englishList = indonesiaToEnglish.get(input);
        if (englishList == null)
            return false;
        else
            return englishList.contains(expected.toLowerCase());
    }
}
