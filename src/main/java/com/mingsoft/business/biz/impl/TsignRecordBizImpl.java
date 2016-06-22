package com.mingsoft.business.biz.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mingsoft.basic.biz.impl.BasicBizImpl;
import com.mingsoft.business.biz.ITsignRecordBiz;
import com.mingsoft.business.dao.ITsignRecordDao;
import com.mingsoft.business.dao.ITuserDao;
import com.mingsoft.business.entity.TsignRecordEntity;
import com.mingsoft.business.entity.TuserEntity;
import com.mingsoft.util.PageUtil;
@Service("TsignRecordBizImpl")
public class TsignRecordBizImpl extends BasicBizImpl implements ITsignRecordBiz {

	@Autowired
	private ITsignRecordDao iTsignRecordDao;
	@Autowired
	private ITuserDao iTuserDao;

	@Override
	public int queryCountByCond(TsignRecordEntity tsignRecordEntity) {
		if (tsignRecordEntity==null) {
			tsignRecordEntity = new TsignRecordEntity();
		}
		return this.iTsignRecordDao.queryCountByCond(tsignRecordEntity);
	}

	@Override
	public List<TsignRecordEntity> queryByPage(PageUtil page, TsignRecordEntity tsignRecordEntity) {
		if (tsignRecordEntity!=null) {
			tsignRecordEntity.setPage(page);
			tsignRecordEntity.setOrder(false);
			tsignRecordEntity.setOrderBy("CREATE_TIME");
		}
		return this.iTsignRecordDao.queryByPage(tsignRecordEntity);
	}

	@Override
	public void saveEntity(TsignRecordEntity tsignRecordEntity) {
		if (tsignRecordEntity.getId()==0) {
			this.iTsignRecordDao.saveEntity(tsignRecordEntity);
		}else {
			this.iTsignRecordDao.updateEntity(tsignRecordEntity);
		}
	}

	@Override
	public TsignRecordEntity getTsignRecordEntity(int id) {
		return this.iTsignRecordDao.getTsignRecordEntity(id);
	}

	@Override
	public void updateEntity(TsignRecordEntity tsignRecordEntity) {
		this.iTsignRecordDao.updateEntity(tsignRecordEntity);
	}

	@Override
	public List<TsignRecordEntity> findTsignRecordByParam(int userId) {
		return iTsignRecordDao.findTsignRecordByParam(userId);
	}

	@Override
	public Map<String, String> saveSignRecord(int userId) {
		 Map<String, String> msgMap = new HashMap<String,String>();
		 List<TsignRecordEntity>  tsignRecordList = iTsignRecordDao.findTsignRecordByParam(userId);
		 if(tsignRecordList !=null && tsignRecordList.size()>0){
				msgMap.put("msgCode", "error");
	 			msgMap.put("msg", "您今日已签过!");
	 			return msgMap;
		 }
		 try{
		 //保存签到记录
		 TsignRecordEntity tsignRecord =new TsignRecordEntity();
		 tsignRecord.setPoint(1);
		 tsignRecord.setUserId(userId);
		 tsignRecord.setCreateTime(new Date());
		 tsignRecord.setModifyTime(new Date());
		 this.saveEntity(tsignRecord);
		 //更新用户积分信息
		 TuserEntity tuserEntity = (TuserEntity) iTuserDao.getTuserEntity(userId);
		 if(tuserEntity != null){
			 tuserEntity.setPoint(tuserEntity.getPoint()+1);
			 iTuserDao.updateEntity(tuserEntity);
		 }
			msgMap.put("msgCode", "success");
 			msgMap.put("msg", "签到成功！");
		 }catch(Exception e){
			    e.printStackTrace();
				msgMap.put("msgCode", "error");
	 			msgMap.put("msg", "签到失败！");
		 }
		return msgMap;
	}
}
