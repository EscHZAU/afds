package cn.hzau.edu.fishResearch.domain;

import java.sql.Timestamp;

/**
 * MonitBen entity. @author MyEclipse Persistence Tools
 */

public class MonitBen implements java.io.Serializable {

	// Fields

	private Integer id;
	private BaseBen baseBen;
	private BaseMonitSite baseMonitSite;
	private String monitPerson;
	private String benName;
	private String sectRive;
	private Double eastLo;
	private Double northLa;
	private String monitSiteName;
	private Timestamp monitDate;
	private Timestamp monitTime;
	private String locat;
	private Integer quantity;
	private Double biomass;
	private Integer transparen;
	private String ownerUnit;
	private String ownerId;
	private Timestamp operateTime;
	private Integer dataState;

	// Constructors

	/** default constructor */
	public MonitBen() {
	}

	/** minimal constructor */
	public MonitBen(String monitPerson, String benName, String sectRive,
			String monitSiteName, String ownerId, Integer dataState) {
		this.monitPerson = monitPerson;
		this.benName = benName;
		this.sectRive = sectRive;
		this.monitSiteName = monitSiteName;
		this.ownerId = ownerId;
		this.dataState = dataState;
	}

	/** full constructor */
	public MonitBen(BaseBen baseBen, BaseMonitSite baseMonitSite,
			String monitPerson, String benName, String sectRive, Double eastLo,
			Double northLa, String monitSiteName, Timestamp monitDate,
			Timestamp monitTime, String locat, Integer quantity,
			Double biomass, Integer transparen, String ownerUnit,
			String ownerId, Timestamp operateTime, Integer dataState) {
		this.baseBen = baseBen;
		this.baseMonitSite = baseMonitSite;
		this.monitPerson = monitPerson;
		this.benName = benName;
		this.sectRive = sectRive;
		this.eastLo = eastLo;
		this.northLa = northLa;
		this.monitSiteName = monitSiteName;
		this.monitDate = monitDate;
		this.monitTime = monitTime;
		this.locat = locat;
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

	public BaseBen getBaseBen() {
		return this.baseBen;
	}

	public void setBaseBen(BaseBen baseBen) {
		this.baseBen = baseBen;
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

	public String getBenName() {
		return this.benName;
	}

	public void setBenName(String benName) {
		this.benName = benName;
	}

	public String getSectRive() {
		return this.sectRive;
	}

	public void setSectRive(String sectRive) {
		this.sectRive = sectRive;
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

	public String getMonitSiteName() {
		return this.monitSiteName;
	}

	public void setMonitSiteName(String monitSiteName) {
		this.monitSiteName = monitSiteName;
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

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
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