package com.changjiang.common.service;

import org.springframework.stereotype.Service;

import com.changjiang.common.domain.LogDO;
import com.changjiang.common.domain.PageDO;
import com.changjiang.common.utils.Query;
@Service
public interface LogService {
	PageDO<LogDO> queryList(Query query);
	int remove(Long id);
	int batchRemove(Long[] ids);
}
