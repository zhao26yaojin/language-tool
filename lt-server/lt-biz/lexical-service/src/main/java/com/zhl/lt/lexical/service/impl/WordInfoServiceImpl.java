package com.zhl.lt.lexical.service.impl;

import com.zhl.lt.lexical.model.entity.TbWord;
import com.zhl.lt.lexical.model.qo.PhraseQO;
import com.zhl.lt.lexical.model.qo.SentenceQO;
import com.zhl.lt.lexical.model.qo.WordQO;
import com.zhl.lt.lexical.model.vo.PhraseVO;
import com.zhl.lt.lexical.model.vo.SentenceVO;
import com.zhl.lt.lexical.model.vo.WordInfoVO;
import com.zhl.lt.lexical.model.vo.WordVO;
import com.zhl.lt.lexical.service.PhraseService;
import com.zhl.lt.lexical.service.SentenceService;
import com.zhl.lt.lexical.service.WordInfoService;
import com.zhl.lt.lexical.service.WordService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.zhl.lt.common.rest.ErrorMsg.*;

@Service
@Slf4j
public class WordInfoServiceImpl implements WordInfoService {

	@Autowired
	WordService wordService;

	@Autowired
	SentenceService sentenceService;

	@Autowired
	PhraseService phraseService;

	@Override
	public WordInfoVO getWordInfo(WordQO wordQO) {
		WordInfoVO wordInfoVO = new WordInfoVO();

		WordVO wordVO = wordService.selectVO(wordQO);
		if (wordVO == null) {
			return wordInfoVO;
		}

		wordInfoVO.setWord(wordVO);

		SentenceQO sentenceQO = new SentenceQO();
		sentenceQO.setWordId(wordVO.getId());
		List<SentenceVO> sentenceVOList = sentenceService.selectVOList(sentenceQO);
		wordInfoVO.setSentenceList(sentenceVOList);

		PhraseQO phraseQO = new PhraseQO();
		phraseQO.setWordId(wordVO.getId());
		List<PhraseVO> phraseVOList = phraseService.selectVOList(phraseQO);
		wordInfoVO.setPhraseList(phraseVOList);

		return wordInfoVO;
	}

	@Override
	@Transactional
	public String saveWordInfo(WordInfoVO wordInfoVO) {
		if (wordInfoVO == null || wordInfoVO.getWord() == null) {
			return NULL_PARAMETERS;
		}

		if (StringUtils.isEmpty(wordInfoVO.getWord().getName())
				|| StringUtils.isEmpty(wordInfoVO.getWord().getSrcLang())) {
			return NULL_PARAMETERS;
		}

		// 新增
		if (wordInfoVO.getWord().getId() == null) {
			WordQO wordQO = new WordQO();
			wordQO.setName(wordInfoVO.getWord().getName());
			wordQO.setSrcLang(wordInfoVO.getWord().getSrcLang());
			boolean exist = wordService.exists(wordQO);
			if (exist) {
				return DUPLICATE_DATA;
			}
		}

		boolean result = wordService.saveVO(wordInfoVO.getWord());
		if (result) {
			if (CollectionUtils.isNotEmpty(wordInfoVO.getSentenceList())) {
				for (SentenceVO sentenceVO : wordInfoVO.getSentenceList()) {
					sentenceVO.setWordId(wordInfoVO.getWord().getId());
				}

				sentenceService.saveVOList(wordInfoVO.getSentenceList());
			}

			if (CollectionUtils.isNotEmpty(wordInfoVO.getPhraseList())) {
				for (PhraseVO phraseVO : wordInfoVO.getPhraseList()) {
					phraseVO.setWordId(wordInfoVO.getWord().getId());
				}

				phraseService.saveVOList(wordInfoVO.getPhraseList());
			}
		}

		return null;
	}

	@Override
	@Transactional
	public String deleteByIds(List<Long> idList) {
		if (CollectionUtils.isEmpty(idList)) {
			return NULL_PARAMETERS;
		}

		SentenceQO sentenceQO = new SentenceQO();
		sentenceQO.setWordIdList(idList);
		sentenceService.delete(sentenceQO);

		PhraseQO phraseQO = new PhraseQO();
		phraseQO.setWordIdList(idList);
		phraseService.delete(phraseQO);

		wordService.deleteByIds(idList);

		return "";

	}

}
