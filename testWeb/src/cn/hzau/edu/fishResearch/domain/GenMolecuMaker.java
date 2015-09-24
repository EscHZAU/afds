package cn.hzau.edu.fishResearch.domain;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * GenMolecuMaker entity. @author MyEclipse Persistence Tools
 */

public class GenMolecuMaker implements java.io.Serializable {

	// Fields

	private Integer id;
	private BaseMonitUnit baseMonitUnit;
	private BaseFish baseFish;
	private String genGuid;
	private String monitPerson;
	private String measureNo;
	private String fishName;
	private String software;
	private String reference;
	private String ownerUnit;
	private String ownerId;
	private Timestamp operateTime;
	private Integer dataState;
	private Set genPrims = new HashSet(0);

	// Constructors

	/** default constructor */
	public GenMolecuMaker() {
	}

	/** minimal constructor */
	public GenMolecuMaker(String genGuid, String monitPerson, String measureNo,
			String fishName, String software, String ownerId,
			Timestamp operateTime, Integer dataState) {
		this.genGuid = genGuid;
		this.monitPerson = monitPerson;
		this.measureNo = measureNo;
		this.fishName = fishName;
		this.software = software;
		this.ownerId = ownerId;
		this.operateTime = operateTime;
		this.dataState = dataState;
	}

	/** full constructor */
	public GenMolecuMaker(BaseMonitUnit baseMonitUnit, BaseFish baseFish,
			String genGuid, String monitPerson, String measureNo,
			String fishName, String software, String reference,
			String ownerUnit, String ownerId, Timestamp operateTime,
			Integer dataState, Set genPrims) {
		this.baseMonitUnit = baseMonitUnit;
		this.baseFish = baseFish;
		this.genGuid = genGuid;
		this.monitPerson = monitPerson;
		this.measureNo = measureNo;
		this.fishName = fishName;
		this.software = software;
		this.reference = reference;
		this.ownerUnit = ownerUnit;
		this.ownerId = ownerId;
		this.operateTime = operateTime;
		this.dataState = dataState;
		this.genPrims = genPrims;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BaseMonitUnit getBaseMonitUnit() {
		return this.baseMonitUnit;
	}

	public void setBaseMonitUnit(BaseMonitUnit baseMonitUnit) {
		this.baseMonitUnit = baseMonitUnit;
	}

	public BaseFish getBaseFish() {
		return this.baseFish;
	}

	public void setBaseFish(BaseFish baseFish) {
		this.baseFish = baseFish;
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

	public String getFishName() {
		return this.fishName;
	}

	public void setFishName(String fishName) {
		this.fishName = fishName;
	}

	public String getSoftware() {
		return this.software;
	}

	public void setSoftware(String software) {
		this.software = software;
	}

	public String getReference() {
		return this.reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
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

	public Set getGenPrims() {
		return this.genPrims;
	}

	public void setGenPrims(Set genPrims) {
		this.genPrims = genPrims;
	}

}