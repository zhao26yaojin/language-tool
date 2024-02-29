package com.zhl.lt.statistics.utils;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeTest {

	DateTimeFormatter dfDateTime = DateTimeFormatter.ofPattern("yyMMddHH");

	@Test
	public void test1() {
		LocalDateTime now = LocalDateTime.now();

		int year = now.getYear();

		long t1 = System.currentTimeMillis();

		// System.out.println(String.format("%d%02d%02d", now.getYear() % 100,
		// now.getMonthValue(), now.getDayOfMonth()));
		int aa = 0;
		for (int i = 0; i < 1000; i++) {
			aa = now.getYear() % 100 * 1000000 + now.getMonthValue() * 10000 + now.getDayOfMonth() * 100
					+ now.getHour();
		}

		System.out.println(aa);

		long t2 = System.currentTimeMillis();
		System.out.println(t2 - t1);

		int bb = 0;
		for (int i = 0; i < 1000; i++) {
			bb = Integer.valueOf(now.format(dfDateTime));
		}

		System.out.println(bb);

		long t3 = System.currentTimeMillis();
		System.out.println(t3 - t2);
	}

}
