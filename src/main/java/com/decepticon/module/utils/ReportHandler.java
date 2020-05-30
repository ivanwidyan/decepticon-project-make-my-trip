package com.decepticon.module.utils;

import com.decepticon.module.json.Data;
import com.decepticon.module.json.MasterData;
import com.decepticon.module.json.MasterJson;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReportHandler {
    public static HashMap<String, String> masterHashMap = new HashMap<>();

    public static void main(String[] args) {
        generateDummyReport();

//        Handler.getKeyName().add("dark magician");
//        Handler.getKeyName().add("fire hole");
//
//        prepareReport();
//
//        generateSampleData("fandom");
//        generateTempData("fandom");
//
//        generateSampleData("api");
//        generateTempData("api");
//
//        readFromTempData();
//        generateMasterJson();

//        generateSampleData("api");
//        generateTempData("api");

        /*File apiTxt = new File("target/autobot/report/assets/json/data/api.txt");
        File wikiTxt = new File("target/autobot/report/assets/json/data/wiki.txt");
        if (apiTxt.exists() && wikiTxt.exists()) {
            readFromTempData();
            generateMasterJson();
        }*/
    }

    public static void generateDummyReport() {
        Handler.getKeyName().add("dark magician");
        Handler.getKeyName().add("fire hole");

        prepareReport();

        generateSampleData("fandom");
        generateTempData("fandom");

        generateSampleData("api");
        generateTempData("api");

        readFromTempData();
        generateMasterJson();
    }

    public static void generateMasterJson() {
        List<MasterJson> listMasterJson = new ArrayList<>();

        for (int i = 0; i < Handler.getKeyName().size(); i++) {
            try {
                String penerbangan = Handler.getKeyName().get(i).toLowerCase();

                Data fandom = createData(penerbangan, "fandom");
                Data api = createData(penerbangan, "api");

                MasterData masterData = new MasterData();
                masterData.fandom = fandom;
                masterData.api = api;

                String firstKey = penerbangan + ".";
                MasterJson masterJson = new MasterJson();
                masterJson.name = getMasterHashMapValue(firstKey + "name");
                masterJson.driver = getMasterHashMapValue(firstKey + "driver");
                masterJson.data = masterData;

                listMasterJson.add(masterJson);
            } catch (Exception e) {
                System.out.println("generateSingleJsonReport:" + e);
            }
        }

        String jsonSkyScanner = Utility.objToJsonString(listMasterJson);
        Utility.writeToFile(jsonSkyScanner,
                "target/autobot/report/data/json/master.json");
    }

    public static Data createData(String keyName, String parallelKey) {
        Data data = new Data();

        String secondKey = keyName + "." + parallelKey + ".";
        data.name = getMasterHashMapValue(secondKey + "name");
        data.attribute = getMasterHashMapValue(secondKey + "attribute");
        data.types = getMasterHashMapValue(secondKey + "types");
        data.atk = getMasterHashMapValue(secondKey + "atk");
        data.def = getMasterHashMapValue(secondKey + "def");
        data.img = getMasterHashMapValue(secondKey + "img");
        data.ss = getMasterHashMapValue(secondKey + "ss");

        return data;
    }

    public static String getMasterHashMapValue(String key) {
        try {
            String value = masterHashMap.get(key);
            if (value == null)
                return "-";
            else
                return value;
        } catch (Exception e) {
            System.out.println("Error getting " + key);
            return "-";
        }
    }

    public static void readFromTempData() {
        File folder = new File("target/autobot/report/data/json/temp");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            String fileName = listOfFiles[i].getName();
            System.out.println("\nFile name: " + fileName);
            List<String> listTempData = new ArrayList<>();
            try {
                listTempData = Utility.readFromFile("target/autobot/report/data/json/temp/" + fileName);
            } catch (Exception e) {
                System.out.println("Error read temp json: " + e);
            }

            for (int j = 0; j < listTempData.size(); j++) {
                String keyValue = listTempData.get(j);
                String[] arrayMap = keyValue.split("=");
                masterHashMap.put(arrayMap[0], arrayMap[1]);
                System.out.println(keyValue);
            }
        }
    }

    public static void generateTempData(String parallelKey) {
        Utility.writeToFile(Handler.getCoreHashMap(),
                "target/autobot/report/data/json/temp/" + parallelKey + ".txt");
        Handler.clearCoreHashMap();
    }

    public static void prepareReport() {
        File tmpDir = new File("target/autobot/report");
        System.out.println("report exist: " + tmpDir.exists());

        if (!tmpDir.exists()) {
            try {
                File sourceLocation = new File("autobot");
                File targetLocation = new File("target/autobot/report");
                FileUtils.copyDirectory(sourceLocation, targetLocation);
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        }
    }

    public static void generateSampleData(String parallelKey) {
        String keyName = "";
        String firstKey = "";
        String secondKey = "";
        String test = "";

        keyName = "dark magician";
        firstKey = keyName + ".";
        secondKey = keyName + "." + parallelKey + ".";

        Handler.putCoreHashMap(firstKey + "name", "dark magician");
        Handler.putCoreHashMap(firstKey + "driver", "chrome");

        Handler.putCoreHashMap(secondKey + "name", "Dark Magician");
        Handler.putCoreHashMap(secondKey + "attribute", "Dark");
        Handler.putCoreHashMap(secondKey + "types", "Monster");
        Handler.putCoreHashMap(secondKey + "atk", "1000");
        Handler.putCoreHashMap(secondKey + "def", "2000");
        Handler.putCoreHashMap(secondKey + "img", "https://assets-global.website-files.com/5b0ee246bd5a96cce5ca393b/5cba23a2d8a14794538026eb_skyscanner%2015.jpg");
        Handler.putCoreHashMap(secondKey + "ss", "https://assets-global.website-files.com/5b0ee246bd5a96cce5ca393b/5cba23a2d8a14794538026eb_skyscanner%2015.jpg");

        keyName = Handler.getKeyName().get(0);
        parallelKey = "fandom"; // fandom, api, db
        firstKey = keyName + ".";
        secondKey = keyName + "." + parallelKey + ".";

        Handler.putCoreHashMap(firstKey + "name", "fire hole");
        Handler.putCoreHashMap(firstKey + "driver", "firefox");

        Handler.putCoreHashMap(secondKey + "name", "Fire Hole");
        Handler.putCoreHashMap(secondKey + "attribute", "chrome");
        Handler.putCoreHashMap(secondKey + "types", "Spell");
        Handler.putCoreHashMap(secondKey + "atk", "-");
        Handler.putCoreHashMap(secondKey + "def", "-");
        Handler.putCoreHashMap(secondKey + "img", "https://assets-global.website-files.com/5b0ee246bd5a96cce5ca393b/5cba23a2d8a14794538026eb_skyscanner%2015.jpg");
        Handler.putCoreHashMap(secondKey + "ss", "https://assets-global.website-files.com/5b0ee246bd5a96cce5ca393b/5cba23a2d8a14794538026eb_skyscanner%2015.jpg");
    }
 }