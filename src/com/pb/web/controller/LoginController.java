package com.pb.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.pb.entity.Account;
import com.test.InitAndDestroySeqBean;

public class LoginController extends AbstractController {
	private String successView;
	private String failView;
	private InitAndDestroySeqBean initAndDestroySeqBean;
	
	
	public InitAndDestroySeqBean getInitAndDestroySeqBean() {
		return initAndDestroySeqBean;
	}
	public void setInitAndDestroySeqBean(InitAndDestroySeqBean initAndDestroySeqBean) {
		this.initAndDestroySeqBean = initAndDestroySeqBean;
	}
	public String getSuccessView() {
		return successView;
	}
	public void setSuccessView(String successView) {
		this.successView = successView;
	}
	public String getFailView() {
		return failView;
	}
	public void setFailView(String failView) {
		this.failView = failView;
	}
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method 
		String cardNo=request.getParameter("cardNo");
		String password= String.valueOf(Integer.parseInt(request.getParameter("password").toString()));
		Account account =getAccount(cardNo,password);
		Map<String ,Object> model=new HashMap<String,Object>();
		if(account !=null){
			model.put("account", account);
			return new ModelAndView(getSuccessView(),model);
		}else{
			model.put("error", "卡号和密码不正确");
			return new ModelAndView(getFailView(),model);
		}		
	}
	public Account getAccount(String cardNo,String password){
		if(cardNo.equals("123")&&password.equals("123")){
			Account account =new Account();
			account.setCardNo(cardNo);
			account.setBalance(88.8f);
			return account;
		}else{
			return null;
		}
	}

}
