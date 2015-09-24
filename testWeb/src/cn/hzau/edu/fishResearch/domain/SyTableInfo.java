package cn.hzau.edu.fishResearch.domain;

/**
 * SyTableInfo entity. @author MyEclipse Persistence Tools
 */

public class SyTableInfo implements java.io.Serializable {

	// Fields

	private SyTableInfoId id;

	// Constructors

	/** default constructor */
	public SyTableInfo() {
	}

	/** full constructor */
	public SyTableInfo(SyTableInfoId id) {
		this.id = id;
	}

	// Property accessors

	public SyTableInfoId getId() {
		return this.id;
	}

	public void setId(SyTableInfoId id) {
		this.id = id;
	}

}