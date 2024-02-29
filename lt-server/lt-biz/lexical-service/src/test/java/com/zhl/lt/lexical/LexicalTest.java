package com.zhl.lt.lexical;

import com.zhl.lt.common.util.JacksonUtil;
import com.zhl.lt.common.enums.LanguageEnum;
import org.junit.jupiter.api.Test;

public class LexicalTest {

	@Test
	public void test1() {
		String result = JacksonUtil.encode(LanguageEnum.values());

		System.out.println(result);
	}

}
