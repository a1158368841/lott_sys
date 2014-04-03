/**
 * 
 */
package com.lott_sys.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.lott_sys.dao.LotteryDAO;
import com.lott_sys.util.LotteryOperator;
import com.lott_sys.vo.Lottery;
import com.lott_sys.vo.LotteryInfo;

/**
 * @author caozx10172
 *
 */
public class LotteryAction implements ServletRequestAware{

	private Lottery lottery;
	private LotteryInfo lottinfo;
	private LotteryOperator lo;
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
		List<LotteryInfo> lottinfolist = new ArrayList<LotteryInfo>();
		for(Lottery l:list){
			if("1001".equals(method)){
				lottinfolist.add(lo.getBig_Small(l));
			}else if("1002".equals(method)){
				lottinfolist.add(lo.getOdd_Even(l));
			}else if("1003".equals(method)){
				lottinfolist.add(lo.getPrime_Composite(l));
			}else if("1004".equals(method)){
				lottinfolist.add(lo.get012(l));
			}else if("1005".equals(method)){
				lottinfolist.add(lo.getTiles012(l));
			}
		}
		request.setAttribute("lottinfolist", lottinfolist);
		return "show";
	}
	
	public String query(){
		List<Lottery> list = new ArrayList<Lottery>();
		int dx =Integer.valueOf(request.getParameter("dx"));
		int jo =Integer.valueOf(request.getParameter("jo"));
		int zh =Integer.valueOf(request.getParameter("zh"));
		int l012 =Integer.valueOf(request.getParameter("l012"));
		list = lo.query(dx,jo, zh, l012, 50);
		request.setAttribute("lottlist", list);
		return "show";
	}
	
	
	public Lottery getLottery() {
		return lottery;
	}

	public void setLottery(Lottery lottery) {
		this.lottery = lottery;
	}

	public LotteryInfo getLottinfo() {
		return lottinfo;
	}

	public void setLottinfo(LotteryInfo lottinfo) {
		this.lottinfo = lottinfo;
	}

	public LotteryOperator getLo() {
		return lo;
	}

	public void setLo(LotteryOperator lo) {
		this.lo = lo;
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
