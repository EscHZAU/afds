package cn.hzau.edu.fishResearch.domain;

import java.sql.Timestamp;

/**
 * EarlyWaterQualit entity. @author MyEclipse Persistence Tools
 */

public class EarlyWaterQualit implements java.io.Serializable {

	// Fields

	private Integer id;
	private EarlySurveyState earlySurveyState;
	private BaseIndexMethod baseIndexMethod;
	private String earGuid;
	private String monitPerson;
	private String monitSiteName;
	private String lineName;
	private String statName;
	private Timestamp monitDate;
	private Double waterTemp;
	private Double ph;
	private Double dissOxyg;
	private String dissOxygMethod;
	private Double conductivi;
	private String conductiviMethod;
	private Integer transparen;
	private String transparenMethod;
	private String ownerUnit;
	private String ownerId;
	private Timestamp operateTime;
	private Integer dataState;

	// Constructors

	/** default constructor */
	public EarlyWaterQualit() {
	}

	/** minimal constructor */
	public EarlyWaterQualit(String earGuid, String monitPerson,
			String monitSiteName, String lineName, String statName,
			Timestamp monitDate, Double ph, Double dissOxyg, Double conductivi,
			Integer transparen, String transparenMethod, String ownerId,
			Timestamp operateTime, Integer dataState) {
		this.earGuid = earGuid;
		this.monitPerson = monitPerson;
		this.monitSiteName = monitSiteName;
		this.lineName = lineName;
		this.statName = statName;
		this.monitDate = monitDate;
		this.ph = ph;
		this.dissOxyg = dissOxyg;
		this.conductivi = conductivi;
		this.transparen = transparen;
		this.transparenMethod = transparenMethod;
		this.ownerId = ownerId;
		this.operateTime = operateTime;
		this.dataState = dataState;
	}

	/** full constructor */
	public EarlyWaterQualit(EarlySurveyState earlySurveyState,
			BaseIndexMethod baseIndexMethod, String earGuid,
			String monitPerson, String monitSiteName, String lineName,
			String statName, Timestamp monitDate, Double waterTemp, Double ph,
			Double dissOxyg, String dissOxygMethod, Double conductivi,
			String conductiviMethod, Integer transparen,
			String transparenMethod, String ownerUnit, String ownerId,
			Timestamp operateTime, Integer dataState) {
		this.earlySurveyState = earlySurveyState;
		this.baseIndexMethod = baseIndexMethod;
		this.earGuid = earGuid;
		this.monitPerson = monitPerson;
		this.monitSiteName = monitSiteName;
		this.lineName = lineName;
		this.statName = statName;
		this.monitDate = monitDate;
		this.waterTemp = waterTemp;
		this.ph = ph;
		this.dissOxyg = dissOxyg;
		this.dissOxygMethod = dissOxygMethod;
		this.conductivi = conductivi;
		this.conductiviMethod = conductiviMethod;
		this.transparen = transparen;
		this.transparenMethod = transparenMethod;
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

	public BaseIndexMethod getBaseIndexMethod() {
		return this.baseIndexMethod;
	}

	public void setBaseIndexMethod(BaseIndexMethod baseIndexMethod) {
		this.baseIndexMethod = baseIndexMethod;
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

	public String getStatName() {
		return this.statName;
	}

	public void setStatName(String statName) {
		this.statName = statName;
	}

	public Timestamp getMonitDate() {
		return this.monitDate;
	}

	public void setMonitDate(Timestamp monitDate) {
		this.monitDate = monitDate;
	}

	public Double getWaterTemp() {
		return this.waterTemp;
	}

	public void setWaterTemp(Double waterTemp) {
		this.waterTemp = waterTemp;
	}

	public Double getPh() {
		return this.ph;
	}

	public void setPh(Double ph) {
		this.ph = ph;
	}

	public Double getDissOxyg() {
		return this.dissOxyg;
	}

	public void setDissOxyg(Double dissOxyg) {
		this.dissOxyg = dissOxyg;
	}

	public String getDissOxygMethod() {
		return this.dissOxygMethod;
	}

	public void setDissOxygMethod(String dissOxygMethod) {
		this.dissOxygMethod = dissOxygMethod;
	}

	public Double getConductivi() {
		return this.conductivi;
	}

	public void setConductivi(Double conductivi) {
		this.conductivi = conductivi;
	}

	public String getConductiviMethod() {
		return this.conductiviMethod;
	}

	public void setConductiviMethod(String conductiviMethod) {
		this.conductiviMethod = conductiviMethod;
	}

	public Integer getTransparen() {
		return this.transparen;
	}

	public void setTransparen(Integer transparen) {
		this.transparen = transparen;
	}

	public String getTransparenMethod() {
		return this.transparenMethod;
	}

	public void setTransparenMethod(String transparenMethod) {
		this.transparenMethod = transparenMethod;
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