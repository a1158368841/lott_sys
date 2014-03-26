package com.lott_sys.vo;

import com.lott_sys.dao.DictionaryDAO;

/**
 * 页面显示时用
 * @author caozx10172
 *
 */
public class LotteryInfo {

	private Integer lottId;
	private String num1;
	private String num2;
	private String num3;
	private String num4;
	private String num5;
    //号码对用指标值
	private int num1info;
	private int num2info;
	private int num3info;
	private int num4info;
	private int num5info;
	private int suminfo;
	

	
	public LotteryInfo(){
		
	}
	
	public LotteryInfo(Lottery l){
		this.lottId = l.getLottId();
		this.num1 = l.getNum1();
		this.num2 = l.getNum2();
		this.num3 = l.getNum3();
		this.num4 = l.getNum4();
		this.num5 = l.getNum5();

	}
	
	public Integer getLottId() {
		return lottId;
	}
	public void setLottId(Integer lottId) {
		this.lottId = lottId;
	}

	public String getNum1() {
		return num1;
	}

	public void setNum1(String num1) {
		this.num1 = num1;
	}

	public String getNum2() {
		return num2;
	}

	public void setNum2(String num2) {
		this.num2 = num2;
	}

	public String getNum3() {
		return num3;
	}

	public void setNum3(String num3) {
		this.num3 = num3;
	}

	public String getNum4() {
		return num4;
	}

	public void setNum4(String num4) {
		this.num4 = num4;
	}

	public String getNum5() {
		return num5;
	}

	public void setNum5(String num5) {
		this.num5 = num5;
	}

	public int getNum1info() {
		return num1info;
	}

	public void setNum1info(int num1info) {
		this.num1info = num1info;
	}

	public int getNum2info() {
		return num2info;
	}

	public void setNum2info(int num2info) {
		this.num2info = num2info;
	}

	public int getNum3info() {
		return num3info;
	}

	public void setNum3info(int num3info) {
		this.num3info = num3info;
	}

	public int getNum4info() {
		return num4info;
	}

	public void setNum4info(int num4info) {
		this.num4info = num4info;
	}

	public int getNum5info() {
		return num5info;
	}

	public void setNum5info(int num5info) {
		this.num5info = num5info;
	}

	public int getSuminfo() {
		return suminfo;
	}

	public void setSuminfo(int suminfo) {
		this.suminfo = suminfo;
	}

	

	
}
