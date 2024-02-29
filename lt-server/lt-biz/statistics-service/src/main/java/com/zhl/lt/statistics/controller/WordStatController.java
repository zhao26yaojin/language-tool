package com.zhl.lt.statistics.controller;

import com.zhl.lt.common.rest.RestResponse;
import com.zhl.lt.statistics.model.vo.StatWordVO;
import com.zhl.lt.statistics.service.StatWordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "词汇统计模块")
@RestController
@RequestMapping("/word")
public class WordStatController {

	@Autowired
	StatWordService statWordService;

	@Operation(summary = "记录单词查询信息")
	@PostMapping("record")
	public RestResponse<Boolean> recordInfo(@RequestBody StatWordVO statWordVO) {
		Boolean result = statWordService.recordWord(statWordVO);
		if (result) {
			return RestResponse.ok();
		}
		else {
			return RestResponse.error(result);
		}
	}

}
