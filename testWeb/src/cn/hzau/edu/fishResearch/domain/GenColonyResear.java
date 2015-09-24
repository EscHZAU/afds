package cn.hzau.edu.fishResearch.domain;

import java.sql.Timestamp;

/**
 * GenColonyResear entity. @author MyEclipse Persistence Tools
 */

public class GenColonyResear implements java.io.Serializable {

	// Fields

	private Integer id;
	private GenPrim genPrim;
	private BaseMonitSite baseMonitSite;
	private String fishName;
	private String year;
	private String location;
	private Integer sampleNum;
	private String description;
	private String dtype;
	private Integer numSimple;
	private Integer totalNum;
	private String diversitySimple;
	private String diversityNucle;
	private Integer numAllele;
	private String obserHeter;
	private String expectHeter;
	private String ownerUnit;
	private String ownerId;
	private Timestamp operateTime;
	private Integer dataState;

	// Constructors

	/** default constructor */
	public GenColonyResear() {
	}

	/** minimal constructor */
	public GenColonyResear(String fishName, String year, String location,
			Integer sampleNum, String dtype, String ownerId,
			Timestamp operateTime, Integer dataState) {
		this.fishName = fishName;
		this.year = year;
		this.location = location;
		this.sampleNum = sampleNum;
		this.dtype = dtype;
		this.ownerId = ownerId;
		this.operateTime = operateTime;
		this.dataState = dataState;
	}

	/** full constructor */
	public GenColonyResear(GenPrim genPrim, BaseMonitSite baseMonitSite,
			String fishName, String year, String location, Integer sampleNum,
			String description, String dtype, Integer numSimple,
			Integer totalNum, String diversitySimple, String diversityNucle,
			Integer numAllele, String obserHeter, String expectHeter,
			String ownerUnit, String ownerId, Timestamp operateTime,
			Integer dataState) {
		this.genPrim = genPrim;
		this.baseMonitSite = baseMonitSite;
		this.fishName = fishName;
		this.year = year;
		this.location = location;
		this.sampleNum = sampleNum;
		this.description = description;
		this.dtype = dtype;
		this.numSimple = numSimple;
		this.totalNum = totalNum;
		this.diversitySimple = diversitySimple;
		this.diversityNucle = diversityNucle;
		this.numAllele = numAllele;
		this.obserHeter = obserHeter;
		this.expectHeter = expectHeter;
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

	public String getFishName() {
		return this.fishName;
	}

	public void setFishName(String fishName) {
		this.fishName = fishName;
	}

	public String getYear() {
		return this.year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getSampleNum() {
		return this.sampleNum;
	}

	public void setSampleNum(Integer sampleNum) {
		this.sampleNum = sampleNum;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDtype() {
		return this.dtype;
	}

	public void setDtype(String dtype) {
		this.dtype = dtype;
	}

	public Integer getNumSimple() {
		return this.numSimple;
	}

	public void setNumSimple(Integer numSimple) {
		this.numSimple = numSimple;
	}

	public Integer getTotalNum() {
		return this.totalNum;
	}

	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}

	public String getDiversitySimple() {
		return this.diversitySimple;
	}

	public void setDiversitySimple(String diversitySimple) {
		this.diversitySimple = diversitySimple;
	}

	public String getDiversityNucle() {
		return this.diversityNucle;
	}

	public void setDiversityNucle(String diversityNucle) {
		this.diversityNucle = diversityNucle;
	}

	public Integer getNumAllele() {
		return this.numAllele;
	}

	public void setNumAllele(Integer numAllele) {
		this.numAllele = numAllele;
	}

	public String getObserHeter() {
		return this.obserHeter;
	}

	public void setObserHeter(String obserHeter) {
		this.obserHeter = obserHeter;
	}

	public String getExpectHeter() {
		return this.expectHeter;
	}

	public void setExpectHeter(String expectHeter) {
		this.expectHeter = expectHeter;
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