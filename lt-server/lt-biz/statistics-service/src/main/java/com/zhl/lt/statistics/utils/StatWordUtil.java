package com.zhl.lt.statistics.utils;

import com.zhl.lt.common.util.JacksonUtil;
import com.zhl.lt.statistics.model.entity.StatWord;
import org.apache.commons.compress.utils.Lists;

import java.time.LocalDateTime;
import java.util.List;

public class StatWordUtil {

	public static void mergeRecord(StatWord entity, StatWord existStatWord) {
		List<Integer> recordList = existStatWord == null ? Lists.newArrayList()
				: JacksonUtil.decode(existStatWord.getRecord());

		LocalDateTime now = LocalDateTime.now();
		int record = now.getYear() % 100 * 1000000 + now.getMonthValue() * 10000 + now.getDayOfMonth() * 100
				+ now.getHour();
		if (!recordList.contains(record)) {
			recordList.add(record);

			entity.setRecord(JacksonUtil.encode(recordList));
			entity.setCount(recordList.size());
		}
	}

}
