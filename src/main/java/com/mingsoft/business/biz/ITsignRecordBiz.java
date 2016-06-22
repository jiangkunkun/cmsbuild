package com.mingsoft.business.biz;

import java.util.List;
import java.util.Map;

import com.mingsoft.basic.biz.IBasicBiz;
import com.mingsoft.business.entity.TsignRecordEntity;
import com.mingsoft.util.PageUtil;

public interface ITsignRecordBiz extends IBasicBiz {
	public int queryCountByCond(TsignRecordEntity tsignRecordEntity);
	public List<TsignRecordEntity> queryByPage(PageUtil page,TsignRecordEntity tsignRecordEntity);
	public void saveEntity(TsignRecordEntity tsignRecordEntity);
	public void deleteEntity(int id);
	public TsignRecordEntity getTsignRecordEntity(int id);
	public void updateEntity(TsignRecordEntity tsignRecordEntity);
	public List<TsignRecordEntity> findTsignRecordByParam(int userId);
	public Map<String, String> saveSignRecord(int userId);
}
