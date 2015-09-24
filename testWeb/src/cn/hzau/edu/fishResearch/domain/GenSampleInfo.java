package cn.hzau.edu.fishResearch.domain;

import java.sql.Timestamp;

/**
 * GenSampleInfo entity. @author MyEclipse Persistence Tools
 */

public class GenSampleInfo implements java.io.Serializable {

	// Fields

	private Integer id;
	private GenPrim genPrim;
	private BaseMonitSite baseMonitSite;
	private String genGuid;
	private String monitPerson;
	private String measureNo;
	private String sequence;
	private String gene;
	private String ownerUnit;
	private String ownerId;
	private Timestamp operateTime;
	private Integer dataState;

	// Constructors

	/** default constructor */
	public GenSampleInfo() {
	}

	/** minimal constructor */
	public GenSampleInfo(String genGuid, String monitPerson, String measureNo,
			String sequence, String gene, String ownerId,
			Timestamp operateTime, Integer dataState) {
		this.genGuid = genGuid;
		this.monitPerson = monitPerson;
		this.measureNo = measureNo;
		this.sequence = sequence;
		this.gene = gene;
		this.ownerId = ownerId;
		this.operateTime = operateTime;
		this.dataState = dataState;
	}

	/** full constructor */
	public GenSampleInfo(GenPrim genPrim, BaseMonitSite baseMonitSite,
			String genGuid, String monitPerson, String measureNo,
			String sequence, String gene, String ownerUnit, String ownerId,
			Timestamp operateTime, Integer dataState) {
		this.genPrim = genPrim;
		this.baseMonitSite = baseMonitSite;
		this.genGuid = genGuid;
		this.monitPerson = monitPerson;
		this.measureNo = measureNo;
		this.sequence = sequence;
		this.gene = gene;
		this.ownerUnit = ownerUnit;
		this.ownerId = ownerId;
		this.operateTime = operateTime;
		this.dataState = dataState;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public GenPrim getGenPrim() {
		return this.genPrim;
	}

	public void setGenPrim(GenPrim genPrim) {
		this.genPrim = genPrim;
	}

	public BaseMonitSite getBaseMonitSite() {
		return this.baseMonitSite;
	}

	public void setBaseMonitSite(BaseMonitSite baseMonitSite) {
		this.baseMonitSite = baseMonitSite;
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

	public String getSequence() {
		return this.sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	public String getGene() {
		return this.gene;
	}

	public void setGene(String gene) {
		this.gene = gene;
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

}