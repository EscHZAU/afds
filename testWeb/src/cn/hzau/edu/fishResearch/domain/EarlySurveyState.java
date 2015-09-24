package cn.hzau.edu.fishResearch.domain;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * EarlySurveyState entity. @author MyEclipse Persistence Tools
 */

public class EarlySurveyState implements java.io.Serializable {

	// Fields

	private Integer id;
	private EarlyWatch earlyWatch;
	private String earGuid;
	private String monitPerson;
	private String monitSiteName;
	private String lineName;
	private Timestamp monitDate;
	private String locat;
	private Double eastLo;
	private Double northLa;
	private String sampWlay;
	private String levRisAdown;
	private Double waterLev;
	private Double waterDep;
	private String netModel;
	private Double areaNetMou;
	private Double dipNetMou;
	private Double veloNetMou;
	private Double factAreaNetMou;
	private String ownerUnit;
	private String ownerId;
	private Timestamp operateTime;
	private Integer dataState;
	private Set earlyBiologs = new HashSet(0);
	private Set earlyWaterQualits = new HashSet(0);

	// Constructors

	/** default constructor */
	public EarlySurveyState() {
	}

	/** minimal constructor */
	public EarlySurveyState(String earGuid, String monitPerson,
			String monitSiteName, String lineName, Timestamp monitDate,
			String sampWlay, String levRisAdown, String netModel,
			Double areaNetMou, Double dipNetMou, Double veloNetMou,
			Double factAreaNetMou, String ownerId, Timestamp operateTime,
			Integer dataState) {
		this.earGuid = earGuid;
		this.monitPerson = monitPerson;
		this.monitSiteName = monitSiteName;
		this.lineName = lineName;
		this.monitDate = monitDate;
		this.sampWlay = sampWlay;
		this.levRisAdown = levRisAdown;
		this.netModel = netModel;
		this.areaNetMou = areaNetMou;
		this.dipNetMou = dipNetMou;
		this.veloNetMou = veloNetMou;
		this.factAreaNetMou = factAreaNetMou;
		this.ownerId = ownerId;
		this.operateTime = operateTime;
		this.dataState = dataState;
	}

	/** full constructor */
	public EarlySurveyState(EarlyWatch earlyWatch, String earGuid,
			String monitPerson, String monitSiteName, String lineName,
			Timestamp monitDate, String locat, Double eastLo, Double northLa,
			String sampWlay, String levRisAdown, Double waterLev,
			Double waterDep, String netModel, Double areaNetMou,
			Double dipNetMou, Double veloNetMou, Double factAreaNetMou,
			String ownerUnit, String ownerId, Timestamp operateTime,
			Integer dataState, Set earlyBiologs, Set earlyWaterQualits) {
		this.earlyWatch = earlyWatch;
		this.earGuid = earGuid;
		this.monitPerson = monitPerson;
		this.monitSiteName = monitSiteName;
		this.lineName = lineName;
		this.monitDate = monitDate;
		this.locat = locat;
		this.eastLo = eastLo;
		this.northLa = northLa;
		this.sampWlay = sampWlay;
		this.levRisAdown = levRisAdown;
		this.waterLev = waterLev;
		this.waterDep = waterDep;
		this.netModel = netModel;
		this.areaNetMou = areaNetMou;
		this.dipNetMou = dipNetMou;
		this.veloNetMou = veloNetMou;
		this.factAreaNetMou = factAreaNetMou;
		this.ownerUnit = ownerUnit;
		this.ownerId = ownerId;
		this.operateTime = operateTime;
		this.dataState = dataState;
		this.earlyBiologs = earlyBiologs;
		this.earlyWaterQualits = earlyWaterQualits;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EarlyWatch getEarlyWatch() {
		return this.earlyWatch;
	}

	public void setEarlyWatch(EarlyWatch earlyWatch) {
		this.earlyWatch = earlyWatch;
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

	public Timestamp getMonitDate() {
		return this.monitDate;
	}

	public void setMonitDate(Timestamp monitDate) {
		this.monitDate = monitDate;
	}

	public String getLocat() {
		return this.locat;
	}

	public void setLocat(String locat) {
		this.locat = locat;
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

	public String getSampWlay() {
		return this.sampWlay;
	}

	public void setSampWlay(String sampWlay) {
		this.sampWlay = sampWlay;
	}

	public String getLevRisAdown() {
		return this.levRisAdown;
	}

	public void setLevRisAdown(String levRisAdown) {
		this.levRisAdown = levRisAdown;
	}

	public Double getWaterLev() {
		return this.waterLev;
	}

	public void setWaterLev(Double waterLev) {
		this.waterLev = waterLev;
	}

	public Double getWaterDep() {
		return this.waterDep;
	}

	public void setWaterDep(Double waterDep) {
		this.waterDep = waterDep;
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

	public Set getEarlyBiologs() {
		return this.earlyBiologs;
	}

	public void setEarlyBiologs(Set earlyBiologs) {
		this.earlyBiologs = earlyBiologs;
	}

	public Set getEarlyWaterQualits() {
		return this.earlyWaterQualits;
	}

	public void setEarlyWaterQualits(Set earlyWaterQualits) {
		this.earlyWaterQualits = earlyWaterQualits;
	}

}