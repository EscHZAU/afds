package cn.hzau.edu.fishResearch.domain;

/**
 * SyStateCode entity. @author MyEclipse Persistence Tools
 */

public class SyStateCode implements java.io.Serializable {

	// Fields

	private Integer id;
	private String stateId;
	private String stateName;

	// Constructors

	/** default constructor */
	public SyStateCode() {
	}

	/** full constructor */
	public SyStateCode(String stateId, String stateName) {
		this.stateId = stateId;
		this.stateName = stateName;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStateId() {
		return this.stateId;
	}

	public void setStateId(String stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return this.stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

}