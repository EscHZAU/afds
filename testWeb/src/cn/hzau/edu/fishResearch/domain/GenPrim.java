package cn.hzau.edu.fishResearch.domain;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * GenPrim entity. @author MyEclipse Persistence Tools
 */

public class GenPrim implements java.io.Serializable {

	// Fields

	private Integer id;
	private GenMolecuMaker genMolecuMaker;
	private String genGuid;
	private String monitPerson;
	private String measureNo;
	private String primType;
	private String postSeq;
	private String reverSeq;
	private String ownerUnit;
	private String ownerId;
	private Timestamp operateTime;
	private Integer dataState;
	private Set genSampleInfos = new HashSet(0);
	private Set genColonyResears = new HashSet(0);

	// Constructors

	/** default constructor */
	public GenPrim() {
	}

	/** minimal constructor */
	public GenPrim(String genGuid, String monitPerson, String measureNo,
			String primType, String postSeq, String reverSeq, String ownerId,
			Timestamp operateTime, Integer dataState) {
		this.genGuid = genGuid;
		this.monitPerson = monitPerson;
		this.measureNo = measureNo;
		this.primType = primType;
		this.postSeq = postSeq;
		this.reverSeq = reverSeq;
		this.ownerId = ownerId;
		this.operateTime = operateTime;
		this.dataState = dataState;
	}

	/** full constructor */
	public GenPrim(GenMolecuMaker genMolecuMaker, String genGuid,
			String monitPerson, String measureNo, String primType,
			String postSeq, String reverSeq, String ownerUnit, String ownerId,
			Timestamp operateTime, Integer dataState, Set genSampleInfos,
			Set genColonyResears) {
		this.genMolecuMaker = genMolecuMaker;
		this.genGuid = genGuid;
		this.monitPerson = monitPerson;
		this.measureNo = measureNo;
		this.primType = primType;
		this.postSeq = postSeq;
		this.reverSeq = reverSeq;
		this.ownerUnit = ownerUnit;
		this.ownerId = ownerId;
		this.operateTime = operateTime;
		this.dataState = dataState;
		this.genSampleInfos = genSampleInfos;
		this.genColonyResears = genColonyResears;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public GenMolecuMaker getGenMolecuMaker() {
		return this.genMolecuMaker;
	}

	public void setGenMolecuMaker(GenMolecuMaker genMolecuMaker) {
		this.genMolecuMaker = genMolecuMaker;
	}

	public String getGenGuid() {
		return this.genGuid;
	}

	public void setGenGuid(String genGuid) {
		this.genGuid = genGuid;
	}

	public String getMonitPerson() {
		return this.monitPerson;
	}

	public void setMonitPerson(String monitPerson) {
		this.monitPerson = monitPerson;
	}

	public String getMeasureNo() {
		return this.measureNo;
	}

	public void setMeasureNo(String measureNo) {
		this.measureNo = measureNo;
	}

	public String getPrimType() {
		return this.primType;
	}

	public void setPrimType(String primType) {
		this.primType = primType;
	}

	public String getPostSeq() {
		return this.postSeq;
	}

	public void setPostSeq(String postSeq) {
		this.postSeq = postSeq;
	}

	public String getReverSeq() {
		return this.reverSeq;
	}

	public void setReverSeq(String reverSeq) {
		this.reverSeq = reverSeq;
	}

	public String getOwnerUnit() {
		return this.ownerUnit;
	}

	public void setOwnerUnit(String ownerUnit) {
		this.ownerUnit = ownerUnit;
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

	public Set getGenSampleInfos() {
		return this.genSampleInfos;
	}

	public void setGenSampleInfos(Set genSampleInfos) {
		this.genSampleInfos = genSampleInfos;
	}

	public Set getGenColonyResears() {
		return this.genColonyResears;
	}

	public void setGenColonyResears(Set genColonyResears) {
		this.genColonyResears = genColonyResears;
	}

}