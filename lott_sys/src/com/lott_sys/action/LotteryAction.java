/**
 * 
 */
package com.lott_sys.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.lott_sys.dao.LotteryDAO;
import com.lott_sys.vo.Lottery;

/**
 * @author caozx10172
 *
 */
public class LotteryAction implements ServletRequestAware{

	private Lottery lottery;
	private LotteryDAO lotterydao;
	private HttpSession session;
	private HttpServletRequest request;
	private String method; //玩法
	private String num;    //显示数量
	
	public String add(){
		lotterydao.save(lottery);
		return "success";
	}
	
	public String show(){
		List<Lottery> list = lotterydao.findAll();
		for(Lottery l:list){
			System.out.println(l.getLottId());
		}
		request.setAttribute("lottlist", list);
		return "show";
	}
	
	
	
	public Lottery getLottery() {
		return lottery;
	}
	public void setLottery(Lottery lottery) {
		this.lottery = lottery;
	}
	public LotteryDAO getLotterydao() {
		return lotterydao;
	}
	public void setLotterydao(LotteryDAO lotterydao) {
		this.lotterydao = lotterydao;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		request = arg0;
		session = request.getSession();
	}
	
}
