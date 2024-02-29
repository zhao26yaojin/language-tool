package com.zhl.lt.common.util;

import com.zhl.lt.common.dto.LanguageInfo;
import com.zhl.lt.common.enums.LanguageEnum;
import org.apache.commons.compress.utils.Lists;

import java.util.List;

public class LanguageUtil {

	public static List<LanguageInfo> getAllLanguageInfo() {
		List<LanguageInfo> languageInfoList = Lists.newArrayList();

		for (LanguageEnum languageEnum : LanguageEnum.values()) {
			languageInfoList.add(new LanguageInfo(languageEnum.getCode(), languageEnum.getDesc()));
		}

		return languageInfoList;
	}

}
