package com.first.app.util;

import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonUtil {

	@SuppressWarnings("rawtypes")
	public static String mapToJsonString(Map m){
		String strJson = "";
		ObjectMapper om = new ObjectMapper();
		try {
			strJson = om.writeValueAsString(m);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return strJson;
	}
	@SuppressWarnings("rawtypes")
	public static Map jsonStringToMap(String strJsonstring){
		ObjectMapper om = new ObjectMapper();
		Map m = null;
		try {
			m = om.readValue(strJsonstring, Map.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return m;
	}

		

}
