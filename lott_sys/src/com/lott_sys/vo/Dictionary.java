package com.lott_sys.vo;

/**
 * Dictionary entity. @author MyEclipse Persistence Tools
 */

public class Dictionary implements java.io.Serializable {

	// Fields

	private Integer dictId;
	private Integer dictEntry;
	private String strentry;
	private String dictPrompt;
	private Integer dictCode;
	private String entryName;

	// Constructors

	/** default constructor */
	public Dictionary() {
	}

	/** minimal constructor */
	public Dictionary(Integer dictId) {
		this.dictId = dictId;
	}

	/** full constructor */
	public Dictionary(Integer dictId, Integer dictEntry, String strentry,
			String dictPrompt, Integer dictCode, String entryName) {
		this.dictId = dictId;
		this.dictEntry = dictEntry;
		this.strentry = strentry;
		this.dictPrompt = dictPrompt;
		this.dictCode = dictCode;
		this.entryName = entryName;
	}

	// Property accessors

	public Integer getDictId() {
		return this.dictId;
	}

	public void setDictId(Integer dictId) {
		this.dictId = dictId;
	}

	public Integer getDictEntry() {
		return this.dictEntry;
	}

	public void setDictEntry(Integer dictEntry) {
		this.dictEntry = dictEntry;
	}

	public String getStrentry() {
		return this.strentry;
	}

	public void setStrentry(String strentry) {
		this.strentry = strentry;
	}

	public String getDictPrompt() {
		return this.dictPrompt;
	}

	public void setDictPrompt(String dictPrompt) {
		this.dictPrompt = dictPrompt;
	}

	public Integer getDictCode() {
		return this.dictCode;
	}

	public void setDictCode(Integer dictCode) {
		this.dictCode = dictCode;
	}

	public String getEntryName() {
		return this.entryName;
	}

	public void setEntryName(String entryName) {
		this.entryName = entryName;
	}

}