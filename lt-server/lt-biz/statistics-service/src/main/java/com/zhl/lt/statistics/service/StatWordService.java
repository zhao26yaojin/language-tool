package com.zhl.lt.statistics.service;

import com.zhl.lt.statistics.model.entity.StatWord;
import com.zhl.lt.statistics.model.vo.StatWordVO;
import com.zhl.lt.statistics.qo.StatWordQO;

public interface StatWordService {

	Boolean recordWord(StatWordVO vo);

	StatWord selectEntity(StatWordQO qo);

}
