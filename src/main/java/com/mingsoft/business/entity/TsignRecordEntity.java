package com.mingsoft.business.entity;

import java.util.Date;

import com.mingsoft.base.entity.BaseEntity;
import com.mingsoft.util.PageUtil;
/**
 * 
 * @ClassName: TsignRecordEntity
 * @Description:签到记录表
 * @author: jk
 * @date: 2016年6月22日 下午2:29:34
 *
 */
public class TsignRecordEntity extends BaseEntity {
	private int id;
	private int userId;
	private int point;
	private Date createTime;
	private Date modifyTime;//修改时间
	private PageUtil page;
	private String orderBy;
	private boolean order;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	public PageUtil getPage() {
		return page;
	}
	public void setPage(PageUtil page) {
		this.page = page;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	public boolean isOrder() {
		return order;
	}
	public void setOrder(boolean order) {
		this.order = order;
	}
	
	
	
	
}
