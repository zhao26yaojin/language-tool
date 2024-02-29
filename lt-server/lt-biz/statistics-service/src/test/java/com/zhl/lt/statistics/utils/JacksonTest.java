package com.zhl.lt.statistics.utils;

import com.zhl.lt.common.util.JacksonUtil;
import com.zhl.lt.statistics.model.entity.StatWord;
import org.junit.jupiter.api.Test;

public class JacksonTest {

	@Test
	public void test1() {
		StatWord statWord = new StatWord();
		statWord.setId(12L);
		statWord.setName("aa");

		String ss = JacksonUtil.encode(statWord);

		System.out.println(ss);

		StatWord statWord2 = JacksonUtil.decode(ss, statWord.getClass());

		System.out.println(statWord2);

	}

}
