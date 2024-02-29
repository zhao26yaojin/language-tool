package com.zhl.lt.lexical.controller;

import com.zhl.lt.common.dto.LanguageInfo;
import com.zhl.lt.common.rest.RestResponse;
import com.zhl.lt.common.util.LanguageUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "通用信息模块")
@RestController
@RequestMapping("/info")
public class InfoController {

	@Operation(summary = "查询单词信息")
	@GetMapping("/language")
	public RestResponse<List<LanguageInfo>> languageInfo() {

		return RestResponse.ok(LanguageUtil.getAllLanguageInfo());
	}

}
