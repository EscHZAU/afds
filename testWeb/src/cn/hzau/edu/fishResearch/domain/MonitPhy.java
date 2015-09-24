package cn.hzau.edu.fishResearch.domain;

import java.sql.Timestamp;

/**
 * MonitPhy entity. @author MyEclipse Persistence Tools
 */

public class MonitPhy implements java.io.Serializable {

	// Fields

	private Integer id;
	private BasePhy basePhy;
	private BaseMonitSite baseMonitSite;
	private String monitPerson;
	private String phyName;
	private String sectRive;
	private String monitSiteName;
	private Double eastLo;
	private Double northLa;
	private Timestamp monitDate;
	private Timestamp monitTime;
	private String locat;
	private Double waterDep;
	private Double quantity;
	private Double biomass;
	private Integer transparen;
	private String ownerUnit;
	private String ownerId;
	private Timestamp operateTime;
	private Integer dataState;

	// Constructors

	/** default constructor */
	public MonitPhy() {
	}

	/** minimal constructor */
	public MonitPhy(String monitPerson, String phyName, String sectRive,
			String monitSiteName, String ownerId, Integer dataState) {
		this.monitPerson = monitPerson;
		this.phyName = phyName;
		this.sectRive = sectRive;
		this.monitSiteName = monitSiteName;
		this.ownerId = ownerId;
		this.dataState = dataState;
	}

	/** full constructor */
	public MonitPhy(BasePhy basePhy, BaseMonitSite baseMonitSite,
			String monitPerson, String phyName, String sectRive,
			String monitSiteName, Double eastLo, Double northLa,
			Timestamp monitDate, Timestamp monitTime, String locat,
			Double waterDep, Double quantity, Double biomass,
			Integer transparen, String ownerUnit, String ownerId,
			Timestamp operateTime, Integer dataState) {
		this.basePhy = basePhy;
		this.baseMonitSite = baseMonitSite;
		this.monitPerson = monitPerson;
		this.phyName = phyName;
		this.sectRive = sectRive;
		this.monitSiteName = monitSiteName;
		this.eastLo = eastLo;
		this.northLa = northLa;
		this.monitDate = monitDate;
		this.monitTime = monitTime;
		this.locat = locat;
		this.waterDep = waterDep;
		this.quantity = quantity;
		this.biomass = biomass;
		this.transparen = transparen;
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

	public BasePhy getBasePhy() {
		return this.basePhy;
	}

	public void setBasePhy(BasePhy basePhy) {
		this.basePhy = basePhy;
	}

	public BaseMonitSite getBaseMonitSite() {
		return this.baseMonitSite;
	}

	public void setBaseMonitSite(BaseMonitSite baseMonitSite) {
		this.baseMonitSite = baseMonitSite;
	}

	public String getMonitPerson() {
		return this.monitPerson;
	}

	public void setMonitPerson(String monitPerson) {
		this.monitPerson = monitPerson;
	}

	public String getPhyName() {
		return this.phyName;
	}

	public void setPhyName(String phyName) {
		this.phyName = phyName;
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

	public Timestamp getMonitTime() {
		return this.monitTime;
	}

	public void setMonitTime(Timestamp monitTime) {
		this.monitTime = monitTime;
	}

	public String getLocat() {
		return this.locat;
	}

	public void setLocat(String locat) {
		this.locat = locat;
	}

	public Double getWaterDep() {
		return this.waterDep;
	}

	public void setWaterDep(Double waterDep) {
		this.waterDep = waterDep;
	}

	public Double getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Double getBiomass() {
		return this.biomass;
	}

	public void setBiomass(Double biomass) {
		this.biomass = biomass;
	}

	public Integer getTransparen() {
		return this.transparen;
	}

	public void setTransparen(Integer transparen) {
		this.transparen = transparen;
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