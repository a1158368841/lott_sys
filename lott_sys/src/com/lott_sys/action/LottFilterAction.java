package com.lott_sys.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.lott_sys.util.NumFilter;

public class LottFilterAction implements ServletRequestAware{

	private HttpSession session;
	private HttpServletRequest request;
	private NumFilter numfilter;
	
	public String filter(){
		String dxqy = request.getParameter("dxqy");
		String dx1 = request.getParameter("dx1");
		String dx2 = request.getParameter("dx2");
		String joqy = request.getParameter("joqy");
		String jo1 = request.getParameter("jo1");
		String jo2 = request.getParameter("jo2");
		String zhqy = request.getParameter("zhqy");
		String zh1 = request.getParameter("zh1");
		String zh2 = request.getParameter("zh2");

		List<String> list = new ArrayList<String>();
		List<String> dxlist = new ArrayList<String>();
		List<String> jolist = new ArrayList<String>();
		List<String> zhlist = new ArrayList<String>();
		
		if(dxqy!= null){
			dxlist = numfilter.filter(Integer.valueOf(dx1), 1001);
		}
		if(joqy!= null){
			jolist = numfilter.filter(Integer.valueOf(jo1), 1002);
		}
		if(zhqy!= null){
			zhlist = numfilter.filter(Integer.valueOf(zh1), 1003);
		}
		dxlist.retainAll(jolist);
		dxlist.retainAll(zhlist);
		list = dxlist;
		request.setAttribute("list", list);
		return "filter";
	}
	
	public NumFilter getNumfilter() {
		return numfilter;
	}

	public void setNumfilter(NumFilter numfilter) {
		this.numfilter = numfilter;
	}

	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		request = arg0;
		session = request.getSession();
	}

}
