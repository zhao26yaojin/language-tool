package com.zhl.lt.lexical.controller;

import com.zhl.lt.common.rest.PageBean;
import com.zhl.lt.common.rest.PageParam;
import com.zhl.lt.common.rest.RestResponse;
import com.zhl.lt.lexical.model.qo.WordQO;
import com.zhl.lt.lexical.model.vo.WordInfoVO;
import com.zhl.lt.lexical.model.vo.WordVO;
import com.zhl.lt.lexical.service.WordInfoService;
import com.zhl.lt.lexical.service.WordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "词汇管理模块")
@RestController
@RequestMapping("/word")
@Slf4j
public class WordManageController {

	@Autowired
	WordInfoService wordInfoService;

	@Autowired
	WordService wordService;

	@Operation(summary = "查询单词信息")
	@GetMapping("/info")
	public RestResponse<WordInfoVO> wordInfo(WordQO wordQO) {
		WordInfoVO wordInfoVO = wordInfoService.getWordInfo(wordQO);

		return RestResponse.ok(wordInfoVO);
	}

	@Operation(summary = "保存单词信息")
	@PostMapping("save")
	public RestResponse<String> saveInfo(@RequestBody WordInfoVO wordInfoVO) {
		String result = wordInfoService.saveWordInfo(wordInfoVO);
		if (StringUtils.isEmpty(result)) {
			return RestResponse.ok();
		}
		else {
			return RestResponse.error(result);
		}
	}

	@Operation(summary = "查询单词分页列表")
	@GetMapping("/page")
	public RestResponse<PageBean<WordVO>> page(WordQO wordQO, PageParam pageParam) {
		PageBean<WordVO> pageBean = wordService.selectVOPage(wordQO, pageParam);

		return RestResponse.ok(pageBean);
	}

	@Operation(summary = "删除单词信息")
	@PostMapping("delete")
	public RestResponse<String> deleteInfoList(@RequestBody List<Long> idList) {
		String result = wordInfoService.deleteByIds(idList);
		if (StringUtils.isEmpty(result)) {
			return RestResponse.ok();
		}
		else {
			return RestResponse.error(result);
		}
	}

}
