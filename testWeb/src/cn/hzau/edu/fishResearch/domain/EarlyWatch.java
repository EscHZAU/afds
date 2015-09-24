package cn.hzau.edu.fishResearch.domain;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * EarlyWatch entity. @author MyEclipse Persistence Tools
 */

public class EarlyWatch implements java.io.Serializable {

	// Fields

	private Integer id;
	private BaseMonitPersonel baseMonitPersonel;
	private BaseMonitSite baseMonitSite;
	private String earGuid;
	private String monitPerson;
	private String moniteNo;
	private String sectRive;
	private String monitSiteName;
	private String lineName;
	private Timestamp monitDate;
	private Double eastLo;
	private Double northLa;
	private Timestamp monitTime;
	private Timestamp beginTime;
	private Timestamp endTime;
	private Integer persistTime;
	private Integer numEgg;
	private Integer numPre;
	private String netModel;
	private Double areaNetMou;
	private Double dipNetMou;
	private Double veloNetMou;
	private Double factAreaNetMou;
	private Integer offDistan;
	private String sampWlay;
	private String ownerUnit;
	private String ownerId;
	private Timestamp operateTime;
	private Integer dataState;
	private Set earlySurveyStates = new HashSet(0);

	// Constructors

	/** default constructor */
	public EarlyWatch() {
	}

	/** minimal constructor */
	public EarlyWatch(String earGuid, String monitPerson, String moniteNo,
			String sectRive, String monitSiteName, String lineName,
			Timestamp monitDate, Timestamp monitTime, Timestamp beginTime,
			Timestamp endTime, Integer persistTime, Integer numEgg,
			Integer numPre, String netModel, Double areaNetMou,
			Double dipNetMou, Double veloNetMou, String ownerId,
			Timestamp operateTime, Integer dataState) {
		this.earGuid = earGuid;
		this.monitPerson = monitPerson;
		this.moniteNo = moniteNo;
		this.sectRive = sectRive;
		this.monitSiteName = monitSiteName;
		this.lineName = lineName;
		this.monitDate = monitDate;
		this.monitTime = monitTime;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.persistTime = persistTime;
		this.numEgg = numEgg;
		this.numPre = numPre;
		this.netModel = netModel;
		this.areaNetMou = areaNetMou;
		this.dipNetMou = dipNetMou;
		this.veloNetMou = veloNetMou;
		this.ownerId = ownerId;
		this.operateTime = operateTime;
		this.dataState = dataState;
	}

	/** full constructor */
	public EarlyWatch(BaseMonitPersonel baseMonitPersonel,
			BaseMonitSite baseMonitSite, String earGuid, String monitPerson,
			String moniteNo, String sectRive, String monitSiteName,
			String lineName, Timestamp monitDate, Double eastLo,
			Double northLa, Timestamp monitTime, Timestamp beginTime,
			Timestamp endTime, Integer persistTime, Integer numEgg,
			Integer numPre, String netModel, Double areaNetMou,
			Double dipNetMou, Double veloNetMou, Double factAreaNetMou,
			Integer offDistan, String sampWlay, String ownerUnit,
			String ownerId, Timestamp operateTime, Integer dataState,
			Set earlySurveyStates) {
		this.baseMonitPersonel = baseMonitPersonel;
		this.baseMonitSite = baseMonitSite;
		this.earGuid = earGuid;
		this.monitPerson = monitPerson;
		this.moniteNo = moniteNo;
		this.sectRive = sectRive;
		this.monitSiteName = monitSiteName;
		this.lineName = lineName;
		this.monitDate = monitDate;
		this.eastLo = eastLo;
		this.northLa = northLa;
		this.monitTime = monitTime;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.persistTime = persistTime;
		this.numEgg = numEgg;
		this.numPre = numPre;
		this.netModel = netModel;
		this.areaNetMou = areaNetMou;
		this.dipNetMou = dipNetMou;
		this.veloNetMou = veloNetMou;
		this.factAreaNetMou = factAreaNetMou;
		this.offDistan = offDistan;
		this.sampWlay = sampWlay;
		this.ownerUnit = ownerUnit;
		this.ownerId = ownerId;
		this.operateTime = operateTime;
		this.dataState = dataState;
		this.earlySurveyStates = earlySurveyStates;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BaseMonitPersonel getBaseMonitPersonel() {
		return this.baseMonitPersonel;
	}

	public void setBaseMonitPersonel(BaseMonitPersonel baseMonitPersonel) {
		this.baseMonitPersonel = baseMonitPersonel;
	}

	public BaseMonitSite getBaseMonitSite() {
		return this.baseMonitSite;
	}

	public void setBaseMonitSite(BaseMonitSite baseMonitSite) {
		this.baseMonitSite = baseMonitSite;
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

	public String getLineName() {
		return this.lineName;
	}

	public void setLineName(String lineName) {
		this.lineName = lineName;
	}

	public Timestamp getMonitDate() {
		return this.monitDate;
	}

	public void setMonitDate(Timestamp monitDate) {
		this.monitDate = monitDate;
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

	public Timestamp getMonitTime() {
		return this.monitTime;
	}

	public void setMonitTime(Timestamp monitTime) {
		this.monitTime = monitTime;
	}

	public Timestamp getBeginTime() {
		return this.beginTime;
	}

	public void setBeginTime(Timestamp beginTime) {
		this.beginTime = beginTime;
	}

	public Timestamp getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public Integer getPersistTime() {
		return this.persistTime;
	}

	public void setPersistTime(Integer persistTime) {
		this.persistTime = persistTime;
	}

	public Integer getNumEgg() {
		return this.numEgg;
	}

	public void setNumEgg(Integer numEgg) {
		this.numEgg = numEgg;
	}

	public Integer getNumPre() {
		return this.numPre;
	}

	public void setNumPre(Integer numPre) {
		this.numPre = numPre;
	}

	public String getNetModel() {
		return this.netModel;
	}

	public void setNetModel(String netModel) {
		this.netModel = netModel;
	}

	public Double getAreaNetMou() {
		return this.areaNetMou;
	}

	public void setAreaNetMou(Double areaNetMou) {
		this.areaNetMou = areaNetMou;
	}

	public Double getDipNetMou() {
		return this.dipNetMou;
	}

	public void setDipNetMou(Double dipNetMou) {
		this.dipNetMou = dipNetMou;
	}

	public Double getVeloNetMou() {
		return this.veloNetMou;
	}

	public void setVeloNetMou(Double veloNetMou) {
		this.veloNetMou = veloNetMou;
	}

	public Double getFactAreaNetMou() {
		return this.factAreaNetMou;
	}

	public void setFactAreaNetMou(Double factAreaNetMou) {
		this.factAreaNetMou = factAreaNetMou;
	}

	public Integer getOffDistan() {
		return this.offDistan;
	}

	public void setOffDistan(Integer offDistan) {
		this.offDistan = offDistan;
	}

	public String getSampWlay() {
		return this.sampWlay;
	}

	public void setSampWlay(String sampWlay) {
		this.sampWlay = sampWlay;
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

	public Set getEarlySurveyStates() {
		return this.earlySurveyStates;
	}

	public void setEarlySurveyStates(Set earlySurveyStates) {
		this.earlySurveyStates = earlySurveyStates;
	}

}