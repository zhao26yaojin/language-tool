package com.zhl.lt.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class JacksonUtil {

	private final static ObjectMapper MAPPER = new ObjectMapper();

	public static String encode(Object obj) {
		try {
			return MAPPER.writeValueAsString(obj);
		}
		catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static <T> T decode(String json, Class<T> clazz) {
		try {
			return MAPPER.readValue(json, clazz);
		}
		catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static <T> List<T> decode(String json) {
		try {
			return MAPPER.readValue(json, new TypeReference<>() {
			});
		}
		catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return null;
	}

}
