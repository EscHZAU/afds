package cn.hzau.edu.fishResearch.domain;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * BaseMonitUnit entity. @author MyEclipse Persistence Tools
 */

public class BaseMonitUnit implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String ownerId;
	private Timestamp operateTime;
	private Integer dataState;
	private Set genMolecuMakers = new HashSet(0);
	private Set baseMonitPersonels = new HashSet(0);
	private Set syUserInfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public BaseMonitUnit() {
	}

	/** minimal constructor */
	public BaseMonitUnit(String name, String ownerId, Timestamp operateTime,
			Integer dataState) {
		this.name = name;
		this.ownerId = ownerId;
		this.operateTime = operateTime;
		this.dataState = dataState;
	}

	/** full constructor */
	public BaseMonitUnit(String name, String ownerId, Timestamp operateTime,
			Integer dataState, Set genMolecuMakers, Set baseMonitPersonels,
			Set syUserInfos) {
		this.name = name;
		this.ownerId = ownerId;
		this.operateTime = operateTime;
		this.dataState = dataState;
		this.genMolecuMakers = genMolecuMakers;
		this.baseMonitPersonels = baseMonitPersonels;
		this.syUserInfos = syUserInfos;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwnerId() {
		return this.ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public Timestamp getOperateTime() {
		return this.operateTime;
	}

	public void setOperateTime(Timestamp operateTime) {
		this.operateTime = operateTime;
	}

	public Integer getDataState() {
		return this.dataState;
	}

	public void setDataState(Integer dataState) {
		this.dataState = dataState;
	}

	public Set getGenMolecuMakers() {
		return this.genMolecuMakers;
	}

	public void setGenMolecuMakers(Set genMolecuMakers) {
		this.genMolecuMakers = genMolecuMakers;
	}

	public Set getBaseMonitPersonels() {
		return this.baseMonitPersonels;
	}

	public void setBaseMonitPersonels(Set baseMonitPersonels) {
		this.baseMonitPersonels = baseMonitPersonels;
	}

	public Set getSyUserInfos() {
		return this.syUserInfos;
	}

	public void setSyUserInfos(Set syUserInfos) {
		this.syUserInfos = syUserInfos;
	}

}