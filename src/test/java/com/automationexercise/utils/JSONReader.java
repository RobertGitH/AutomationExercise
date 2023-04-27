package com.automationexercise.utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JSONReader {

    public static String existingUser(String data) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader fileReader = new FileReader("src\\test\\resources\\testData\\ExistingUser.json");
        Object obj = jsonParser.parse(fileReader);
        JSONObject existingUser = (JSONObject) obj;
        return (String)existingUser.get(data);
    }

    public static String accountDetails(String data) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader fileReader = new FileReader("src\\test\\resources\\testData\\AccountDetails.json");
        Object obj = jsonParser.parse(fileReader);
        JSONObject accountDetails = (JSONObject) obj;
        return (String)accountDetails.get(data);
    }
}
