package org.xgo.fileUpAndDownLearn.base;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public abstract class Controller_ {

	public Map<String, Object> result(Object object, String error) {
		Map<String, Object> result = new HashMap<String, Object>();
		// 有错误
		if (StringUtils.isNotBlank(error)) {
			result.put("error", error);
		} else {
			result.put("object", object);
		}
		return result;
	}

}
