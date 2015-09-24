package cn.hzau.edu.fishResearch.domain;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * ContamiFish entity. @author MyEclipse Persistence Tools
 */

public class ContamiFish implements java.io.Serializable {

	// Fields

	private Integer id;
	private BaseMonitSite baseMonitSite;
	private BaseFish baseFish;
	private String conGuid;
	private String monitPerson;
	private String envMeasureNo;
	private String fishName;
	private Integer totalLeng;
	private Integer bodyLeng;
	private Double bodyWeigh;
	private String sex;
	private Integer age;
	private String sectRive;
	private String monitSiteName;
	private Double eastLo;
	private Double northLa;
	private Timestamp monitDate;
	private String ownerUnit;
	private String ownerId;
	private Timestamp operateTime;
	private Integer dataState;
	private Set contamiAnalysises = new HashSet(0);

	// Constructors

	/** default constructor */
	public ContamiFish() {
	}

	/** minimal constructor */
	public ContamiFish(String conGuid, String monitPerson, String envMeasureNo,
			String fishName, Integer bodyLeng, Double bodyWeigh,
			String sectRive, String monitSiteName, Timestamp monitDate,
			String ownerId, Timestamp operateTime, Integer dataState) {
		this.conGuid = conGuid;
		this.monitPerson = monitPerson;
		this.envMeasureNo = envMeasureNo;
		this.fishName = fishName;
		this.bodyLeng = bodyLeng;
		this.bodyWeigh = bodyWeigh;
		this.sectRive = sectRive;
		this.monitSiteName = monitSiteName;
		this.monitDate = monitDate;
		this.ownerId = ownerId;
		this.operateTime = operateTime;
		this.dataState = dataState;
	}

	/** full constructor */
	public ContamiFish(BaseMonitSite baseMonitSite, BaseFish baseFish,
			String conGuid, String monitPerson, String envMeasureNo,
			String fishName, Integer totalLeng, Integer bodyLeng,
			Double bodyWeigh, String sex, Integer age, String sectRive,
			String monitSiteName, Double eastLo, Double northLa,
			Timestamp monitDate, String ownerUnit, String ownerId,
			Timestamp operateTime, Integer dataState, Set contamiAnalysises) {
		this.baseMonitSite = baseMonitSite;
		this.baseFish = baseFish;
		this.conGuid = conGuid;
		this.monitPerson = monitPerson;
		this.envMeasureNo = envMeasureNo;
		this.fishName = fishName;
		this.totalLeng = totalLeng;
		this.bodyLeng = bodyLeng;
		this.bodyWeigh = bodyWeigh;
		this.sex = sex;
		this.age = age;
		this.sectRive = sectRive;
		this.monitSiteName = monitSiteName;
		this.eastLo = eastLo;
		this.northLa = northLa;
		this.monitDate = monitDate;
		this.ownerUnit = ownerUnit;
		this.ownerId = ownerId;
		this.operateTime = operateTime;
		this.dataState = dataState;
		this.contamiAnalysises = contamiAnalysises;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BaseMonitSite getBaseMonitSite() {
		return this.baseMonitSite;
	}

	public void setBaseMonitSite(BaseMonitSite baseMonitSite) {
		this.baseMonitSite = baseMonitSite;
	}

	public BaseFish getBaseFish() {
		return this.baseFish;
	}

	public void setBaseFish(BaseFish baseFish) {
		this.baseFish = baseFish;
	}

	public String getConGuid() {
		return this.conGuid;
	}

	public void setConGuid(String conGuid) {
		this.conGuid = conGuid;
	}

	public String getMonitPerson() {
		return this.monitPerson;
	}

	public void setMonitPerson(String monitPerson) {
		this.monitPerson = monitPerson;
	}

	public String getEnvMeasureNo() {
		return this.envMeasureNo;
	}

	public void setEnvMeasureNo(String envMeasureNo) {
		this.envMeasureNo = envMeasureNo;
	}

	public String getFishName() {
		return this.fishName;
	}

	public void setFishName(String fishName) {
		this.fishName = fishName;
	}

	public Integer getTotalLeng() {
		return this.totalLeng;
	}

	public void setTotalLeng(Integer totalLeng) {
		this.totalLeng = totalLeng;
	}

	public Integer getBodyLeng() {
		return this.bodyLeng;
	}

	public void setBodyLeng(Integer bodyLeng) {
		this.bodyLeng = bodyLeng;
	}

	public Double getBodyWeigh() {
		return this.bodyWeigh;
	}

	public void setBodyWeigh(Double bodyWeigh) {
		this.bodyWeigh = bodyWeigh;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getSectRive() {
		return this.sectRive;
	}

	public void setSectRive(String sectRive) {
		this.sectRive = sectRive;
	}

	public String getMonitSiteName() {
		return this.monitSiteName;
	}

	public void setMonitSiteName(String monitSiteName) {
		this.monitSiteName = monitSiteName;
	}

	public Double getEastLo() {
		return this.eastLo;
	}

	public void setEastLo(Double eastLo) {
		this.eastLo = eastLo;
	}

	public Double getNorthLa() {
		return this.northLa;
	}

	public void setNorthLa(Double northLa) {
		this.northLa = northLa;
	}

	public Timestamp getMonitDate() {
		return this.monitDate;
	}

	public void setMonitDate(Timestamp monitDate) {
		this.monitDate = monitDate;
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

	public Set getContamiAnalysises() {
		return this.contamiAnalysises;
	}

	public void setContamiAnalysises(Set contamiAnalysises) {
		this.contamiAnalysises = contamiAnalysises;
	}

}