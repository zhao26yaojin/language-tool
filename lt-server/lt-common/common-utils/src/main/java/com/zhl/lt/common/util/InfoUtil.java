package com.zhl.lt.common.util;

import com.zhl.lt.common.dto.InfoDTO;
import com.zhl.lt.common.enums.LanguageEnum;
import com.zhl.lt.common.enums.LevelEnum;
import org.apache.commons.compress.utils.Lists;

import java.util.List;

public class InfoUtil {

	public static List<InfoDTO> getAllLanguageInfo() {
		List<InfoDTO> infoDTOList = Lists.newArrayList();

		for (LanguageEnum languageEnum : LanguageEnum.values()) {
			infoDTOList.add(new InfoDTO(languageEnum.getCode(), languageEnum.getDesc()));
		}

		return infoDTOList;
	}

	public static List<InfoDTO> getAllLevelInfo() {
		List<InfoDTO> infoDTOList = Lists.newArrayList();

		for (LevelEnum levelEnum : LevelEnum.values()) {
			infoDTOList.add(new InfoDTO(levelEnum.getCode(), levelEnum.getDesc()));
		}

		return infoDTOList;
	}

}
