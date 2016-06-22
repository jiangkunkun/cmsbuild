package com.mingsoft.business.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mingsoft.base.dao.IBaseDao;
import com.mingsoft.business.entity.TsignRecordEntity;

public interface ITsignRecordDao extends IBaseDao {
	public int queryCountByCond(TsignRecordEntity tsignRecordEntity);
	public List<TsignRecordEntity> queryByPage(TsignRecordEntity tsignRecordEntity);
	public void saveEntity(TsignRecordEntity tsignRecordEntity);
	public void deleteEntity(@Param("id")int id);
	public TsignRecordEntity getTsignRecordEntity(@Param("id")int id);
	public void updateEntity(TsignRecordEntity tsignRecordEntity);
	public List<TsignRecordEntity> findTsignRecordByParam(@Param("id")int userId);
}
	