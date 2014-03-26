package com.lott_sys.vo;

/**
 * Playmethods entity. @author MyEclipse Persistence Tools
 */

public class Playmethods implements java.io.Serializable {

	// Fields

	private Short methodId;
	private String methodName;
	private Float methodPrice;
	private String methodComment;

	// Constructors

	/** default constructor */
	public Playmethods() {
	}

	/** minimal constructor */
	public Playmethods(Short methodId) {
		this.methodId = methodId;
	}

	/** full constructor */
	public Playmethods(Short methodId, String methodName, Float methodPrice,
			String methodComment) {
		this.methodId = methodId;
		this.methodName = methodName;
		this.methodPrice = methodPrice;
		this.methodComment = methodComment;
	}

	// Property accessors

	public Short getMethodId() {
		return this.methodId;
	}

	public void setMethodId(Short methodId) {
		this.methodId = methodId;
	}

	public String getMethodName() {
		return this.methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public Float getMethodPrice() {
		return this.methodPrice;
	}

	public void setMethodPrice(Float methodPrice) {
		this.methodPrice = methodPrice;
	}

	public String getMethodComment() {
		return this.methodComment;
	}

	public void setMethodComment(String methodComment) {
		this.methodComment = methodComment;
	}

}