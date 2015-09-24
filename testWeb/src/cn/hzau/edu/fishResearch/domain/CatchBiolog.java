package cn.hzau.edu.fishResearch.domain;

import java.sql.Timestamp;

/**
 * CatchBiolog entity. @author MyEclipse Persistence Tools
 */

public class CatchBiolog implements java.io.Serializable {

	// Fields

	private Integer id;
	private CatchFishObj catchFishObj;
	private BaseFish baseFish;
	private String catGuid;
	private String monitPerson;
	private String measureNo;
	private String sex;
	private String periGona;
	private Double gonaWeigh;
	private Double sampleWeigh;
	private Integer fecundity;
	private Double absFecundity;
	private Double eggDiam;
	private Double wetWeigh;
	private Integer pepDegree;
	private Integer intestLeng;
	private String ageMateria;
	private Integer age;
	private String remark;
	private String ownerUnit;
	private String ownerId;
	private Timestamp operateTime;
	private Integer dataState;

	// Constructors

	/** default constructor */
	public CatchBiolog() {
	}

	/** minimal constructor */
	public CatchBiolog(String catGuid, String monitPerson, String measureNo,
			String ownerId, Timestamp operateTime, Integer dataState) {
		this.catGuid = catGuid;
		this.monitPerson = monitPerson;
		this.measureNo = measureNo;
		this.ownerId = ownerId;
		this.operateTime = operateTime;
		this.dataState = dataState;
	}

	/** full constructor */
	public CatchBiolog(CatchFishObj catchFishObj, BaseFish baseFish,
			String catGuid, String monitPerson, String measureNo, String sex,
			String periGona, Double gonaWeigh, Double sampleWeigh,
			Integer fecundity, Double absFecundity, Double eggDiam,
			Double wetWeigh, Integer pepDegree, Integer intestLeng,
			String ageMateria, Integer age, String remark, String ownerUnit,
			String ownerId, Timestamp operateTime, Integer dataState) {
		this.catchFishObj = catchFishObj;
		this.baseFish = baseFish;
		this.catGuid = catGuid;
		this.monitPerson = monitPerson;
		this.measureNo = measureNo;
		this.sex = sex;
		this.periGona = periGona;
		this.gonaWeigh = gonaWeigh;
		this.sampleWeigh = sampleWeigh;
		this.fecundity = fecundity;
		this.absFecundity = absFecundity;
		this.eggDiam = eggDiam;
		this.wetWeigh = wetWeigh;
		this.pepDegree = pepDegree;
		this.intestLeng = intestLeng;
		this.ageMateria = ageMateria;
		this.age = age;
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

	public CatchFishObj getCatchFishObj() {
		return this.catchFishObj;
	}

	public void setCatchFishObj(CatchFishObj catchFishObj) {
		this.catchFishObj = catchFishObj;
	}

	public BaseFish getBaseFish() {
		return this.baseFish;
	}

	public void setBaseFish(BaseFish baseFish) {
		this.baseFish = baseFish;
	}

	public String getCatGuid() {
		return this.catGuid;
	}

	public void setCatGuid(String catGuid) {
		this.catGuid = catGuid;
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

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPeriGona() {
		return this.periGona;
	}

	public void setPeriGona(String periGona) {
		this.periGona = periGona;
	}

	public Double getGonaWeigh() {
		return this.gonaWeigh;
	}

	public void setGonaWeigh(Double gonaWeigh) {
		this.gonaWeigh = gonaWeigh;
	}

	public Double getSampleWeigh() {
		return this.sampleWeigh;
	}

	public void setSampleWeigh(Double sampleWeigh) {
		this.sampleWeigh = sampleWeigh;
	}

	public Integer getFecundity() {
		return this.fecundity;
	}

	public void setFecundity(Integer fecundity) {
		this.fecundity = fecundity;
	}

	public Double getAbsFecundity() {
		return this.absFecundity;
	}

	public void setAbsFecundity(Double absFecundity) {
		this.absFecundity = absFecundity;
	}

	public Double getEggDiam() {
		return this.eggDiam;
	}

	public void setEggDiam(Double eggDiam) {
		this.eggDiam = eggDiam;
	}

	public Double getWetWeigh() {
		return this.wetWeigh;
	}

	public void setWetWeigh(Double wetWeigh) {
		this.wetWeigh = wetWeigh;
	}

	public Integer getPepDegree() {
		return this.pepDegree;
	}

	public void setPepDegree(Integer pepDegree) {
		this.pepDegree = pepDegree;
	}

	public Integer getIntestLeng() {
		return this.intestLeng;
	}

	public void setIntestLeng(Integer intestLeng) {
		this.intestLeng = intestLeng;
	}

	public String getAgeMateria() {
		return this.ageMateria;
	}

	public void setAgeMateria(String ageMateria) {
		this.ageMateria = ageMateria;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
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