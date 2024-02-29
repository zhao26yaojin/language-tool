package com.zhl.lt.lexical.controller;

import com.zhl.lt.common.rest.RestResponse;
import com.zhl.lt.lexical.model.qo.SysDictQO;
import com.zhl.lt.lexical.service.SysDictService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name = "测试模块")
@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	SysDictService sysDictService;

	@GetMapping("/hello")
	public RestResponse<String> getWord() {
		return RestResponse.ok("hello world");
	}

	@PostMapping("/cache/dict/clear")
	public RestResponse<Boolean> clearDictCache(@RequestBody SysDictQO qo) {
		sysDictService.clearDictCache(qo);

		return RestResponse.ok(true);
	}

}
