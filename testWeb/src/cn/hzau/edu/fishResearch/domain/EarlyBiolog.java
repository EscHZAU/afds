package cn.hzau.edu.fishResearch.domain;

import java.sql.Timestamp;

/**
 * EarlyBiolog entity. @author MyEclipse Persistence Tools
 */

public class EarlyBiolog implements java.io.Serializable {

	// Fields

	private Integer id;
	private EarlySurveyState earlySurveyState;
	private BaseFish baseFish;
	private String earGuid;
	private String monitPerson;
	private String moniteNo;
	private String fishNo;
	private String fishName;
	private String developEgg;
	private Double diamEgg;
	private Double diamEggMemb;
	private Integer totalLeng;
	private String charPig;
	private String charEmbr;
	private String remark;
	private String ownerUnit;
	private String ownerId;
	private Timestamp operateTime;
	private Integer dataState;

	// Constructors

	/** default constructor */
	public EarlyBiolog() {
	}

	/** minimal constructor */
	public EarlyBiolog(String earGuid, String monitPerson, String moniteNo,
			String fishNo, String fishName, String ownerId,
			Timestamp operateTime, Integer dataState) {
		this.earGuid = earGuid;
		this.monitPerson = monitPerson;
		this.moniteNo = moniteNo;
		this.fishNo = fishNo;
		this.fishName = fishName;
		this.ownerId = ownerId;
		this.operateTime = operateTime;
		this.dataState = dataState;
	}

	/** full constructor */
	public EarlyBiolog(EarlySurveyState earlySurveyState, BaseFish baseFish,
			String earGuid, String monitPerson, String moniteNo, String fishNo,
			String fishName, String developEgg, Double diamEgg,
			Double diamEggMemb, Integer totalLeng, String charPig,
			String charEmbr, String remark, String ownerUnit, String ownerId,
			Timestamp operateTime, Integer dataState) {
		this.earlySurveyState = earlySurveyState;
		this.baseFish = baseFish;
		this.earGuid = earGuid;
		this.monitPerson = monitPerson;
		this.moniteNo = moniteNo;
		this.fishNo = fishNo;
		this.fishName = fishName;
		this.developEgg = developEgg;
		this.diamEgg = diamEgg;
		this.diamEggMemb = diamEggMemb;
		this.totalLeng = totalLeng;
		this.charPig = charPig;
		this.charEmbr = charEmbr;
		this.remark = remark;
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

	public EarlySurveyState getEarlySurveyState() {
		return this.earlySurveyState;
	}

	public void setEarlySurveyState(EarlySurveyState earlySurveyState) {
		this.earlySurveyState = earlySurveyState;
	}

	public BaseFish getBaseFish() {
		return this.baseFish;
	}

	public void setBaseFish(BaseFish baseFish) {
		this.baseFish = baseFish;
	}

	public String getEarGuid() {
		return this.earGuid;
	}

	public void setEarGuid(String earGuid) {
		this.earGuid = earGuid;
	}

	public String getMonitPerson() {
		return this.monitPerson;
	}

	public void setMonitPerson(String monitPerson) {
		this.monitPerson = monitPerson;
	}

	public String getMoniteNo() {
		return this.moniteNo;
	}

	public void setMoniteNo(String moniteNo) {
		this.moniteNo = moniteNo;
	}

	public String getFishNo() {
		return this.fishNo;
	}

	public void setFishNo(String fishNo) {
		this.fishNo = fishNo;
	}

	public String getFishName() {
		return this.fishName;
	}

	public void setFishName(String fishName) {
		this.fishName = fishName;
	}

	public String getDevelopEgg() {
		return this.developEgg;
	}

	public void setDevelopEgg(String developEgg) {
		this.developEgg = developEgg;
	}

	public Double getDiamEgg() {
		return this.diamEgg;
	}

	public void setDiamEgg(Double diamEgg) {
		this.diamEgg = diamEgg;
	}

	public Double getDiamEggMemb() {
		return this.diamEggMemb;
	}

	public void setDiamEggMemb(Double diamEggMemb) {
		this.diamEggMemb = diamEggMemb;
	}

	public Integer getTotalLeng() {
		return this.totalLeng;
	}

	public void setTotalLeng(Integer totalLeng) {
		this.totalLeng = totalLeng;
	}

	public String getCharPig() {
		return this.charPig;
	}

	public void setCharPig(String charPig) {
		this.charPig = charPig;
	}

	public String getCharEmbr() {
		return this.charEmbr;
	}

	public void setCharEmbr(String charEmbr) {
		this.charEmbr = charEmbr;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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