package com.utils;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import io.qameta.allure.Step;

public class JSONData {
	
	String n;
	@Step
	public String readJSONData(String keyword) throws IOException, ParseException
	{
		Reader reader = new FileReader("Testdata/data.json");			
		JSONParser parser = new JSONParser();
		JSONArray jsonArr = (JSONArray)parser.parse(reader);
		for(Object obj : jsonArr)
		{
			JSONObject jo = (JSONObject)obj;			
			n = (String)jo.get(keyword);
			
		}
	
		return n;

}
	
	
}
