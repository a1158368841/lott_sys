package com.lott_sys.vo;

/**
 * Lottery entity. @author MyEclipse Persistence Tools
 */

public class Lottery implements java.io.Serializable {

	// Fields

	private Integer lottId;
	private String lottNums;
	private String num1;
	private String num2;
	private String num3;
	private String num4;
	private String num5;
	private Float salePrice;

	// Constructors

	/** default constructor */
	public Lottery() {
	}

	/** minimal constructor */
	public Lottery(Integer lottId) {
		this.lottId = lottId;
	}

	/** full constructor */
	public Lottery(Integer lottId, String lottNums, String num1, String num2,
			String num3, String num4, String num5, Float salePrice) {
		this.lottId = lottId;
		this.lottNums = lottNums;
		this.num1 = num1;
		this.num2 = num2;
		this.num3 = num3;
		this.num4 = num4;
		this.num5 = num5;
		this.salePrice = salePrice;
	}

	// Property accessors

	public Integer getLottId() {
		return this.lottId;
	}

	public void setLottId(Integer lottId) {
		this.lottId = lottId;
	}

	public String getLottNums() {
		return this.lottNums;
	}

	public void setLottNums(String lottNums) {
		this.lottNums = lottNums;
	}

	public String getNum1() {
		return this.num1;
	}

	public void setNum1(String num1) {
		this.num1 = num1;
	}

	public String getNum2() {
		return this.num2;
	}

	public void setNum2(String num2) {
		this.num2 = num2;
	}

	public String getNum3() {
		return this.num3;
	}

	public void setNum3(String num3) {
		this.num3 = num3;
	}

	public String getNum4() {
		return this.num4;
	}

	public void setNum4(String num4) {
		this.num4 = num4;
	}

	public String getNum5() {
		return this.num5;
	}

	public void setNum5(String num5) {
		this.num5 = num5;
	}

	public Float getSalePrice() {
		return this.salePrice;
	}

	public void setSalePrice(Float salePrice) {
		this.salePrice = salePrice;
	}

}