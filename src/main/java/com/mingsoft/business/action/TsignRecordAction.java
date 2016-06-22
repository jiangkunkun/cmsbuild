package com.mingsoft.business.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mingsoft.base.action.BaseAction;
import com.mingsoft.business.biz.ITsignRecordBiz;
/**
 * 
 * @ClassName: TsignRecordAction
 * @Description:签到记录控制类
 * @author: jk
 * @date: 2016年6月22日 下午2:54:45
 *
 */
@Controller("tsignRecordAction")
@RequestMapping("/manager/tsignRecord")
public class TsignRecordAction extends BaseAction {
	
	@Autowired
	private ITsignRecordBiz iTsignRecordBiz;
	
	/**
	 * 
	 * @Title: saveSignRecord
	 * @Author: jk
	 * @Description: 保存签到记录，一天只能签到一次哦,同时更新个人信息表的积分
	 * @param @param request
	 * @param @param response
	 * @param @return
	 * @return Map<String,String>
	 * @throws
	 */
	@RequestMapping("/saveSignRecord") 
	@ResponseBody
	public Map<String, String> saveSignRecord(HttpServletRequest request,HttpServletResponse response){
		 String userId = request.getParameter("userId");
		 return iTsignRecordBiz.saveSignRecord(Integer.parseInt(userId));
	}

}
