package com.zhl.lt.lexical.controller;

import com.zhl.lt.common.rest.RestResponse;
import com.zhl.lt.lexical.model.qo.SysDictQO;
import com.zhl.lt.lexical.model.vo.SysDictVO;
import com.zhl.lt.lexical.service.SysDictService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "字典信息模块")
@RestController
@RequestMapping("/dict")
public class SysDictController {

	@Autowired
	SysDictService sysDictService;

	@Operation(summary = "查询单词信息")
	@GetMapping("/list")
	public RestResponse<List<SysDictVO>> selectList(SysDictQO qo) {
		return RestResponse.ok(sysDictService.selectVOList(qo));
	}

}
