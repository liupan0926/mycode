package com.example.leetcode;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class SolutionTest {

	/**
	 * { "a":"b", "c":{ "dd":"ee", "ff":"gg" } }
	 * 
	 * 
	 * 
	 * { "a":"b", "c.dd":"ee", "c.ff":"gg" }
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		String str = "{ \"a\":\"b\", \"c\":{ \"dd\": \"ee\", \"ff\":\"gg\",\"xx\":{\"yy\":\"zz\"} } }";

		JSONObject json = JSON.parseObject(str);

		SolutionTest sol = new SolutionTest();

		Map<String, String> res = sol.convert(json);

		System.out.println(JSON.toJSONString(res));

	}

	public Map<String, String> convert(JSONObject json) {

		Map<String, String> result = convertByKey(json);

		return result;

	}

	public Map<String, String> convertByKey(JSONObject json) {

		Map<String, String> result = new HashMap<>();

		for (Map.Entry<String, Object> entry : json.entrySet()) {
			String key = entry.getKey();
			Object obj = entry.getValue();
			if (obj instanceof String) {
				result.put(key, obj.toString());
			} else {
				Map<String, String> aaa = convertByKey(JSONObject.parseObject(obj.toString()));
				for (Map.Entry<String, String> ent : aaa.entrySet()) {
					result.put(key + "." + ent.getKey(), ent.getValue());
				}
			}
		}
		return result;
	}

}
