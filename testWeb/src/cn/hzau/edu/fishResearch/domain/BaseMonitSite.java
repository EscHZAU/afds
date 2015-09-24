package cn.hzau.edu.fishResearch.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * BaseMonitSite entity. @author MyEclipse Persistence Tools
 */

public class BaseMonitSite implements java.io.Serializable {

	// Fields

	private Integer id;
	private BaseMonitPersonel baseMonitPersonel;
	private String name;
	private String sectRive;
	private Double beEastLo1;
	private Double beNorthLa1;
	private Double beEastLo2;
	private Double beNorthLa2;
	private Double endEastLo1;
	private Double endNorthLa1;
	private Double endEastLo2;
	private Double endNorthLa2;
	private Integer fisherboat;
	private String remark;
	private Set monitPhies = new HashSet(0);
	private Set monitZooplans = new HashSet(0);
	private Set genColonyResears = new HashSet(0);
	private Set earlyWatchs = new HashSet(0);
	private Set genSampleInfos = new HashSet(0);
	private Set contamiFishs = new HashSet(0);
	private Set monitBens = new HashSet(0);
	private Set catchFishObjs = new HashSet(0);

	// Constructors

	/** default constructor */
	public BaseMonitSite() {
	}

	/** minimal constructor */
	public BaseMonitSite(String name, String sectRive,Double beEastLo1, Double beNorthLa1,
			Double beEastLo2, Double beNorthLa2, Double endEastLo1,
			Double endNorthLa1, Double endEastLo2, Double endNorthLa2,
			Integer fisherboat, String remark) {
		this.name = name;
		this.sectRive = sectRive;
		this.beEastLo1 = beEastLo1;
		this.beNorthLa1 = beNorthLa1;
		this.beEastLo2 = beEastLo2;
		this.beNorthLa2 = beNorthLa2;
		this.endEastLo1 = endEastLo1;
		this.endNorthLa1 = endNorthLa1;
		this.endEastLo2 = endEastLo2;
		this.endNorthLa2 = endNorthLa2;
		this.fisherboat = fisherboat;
		this.remark = remark;
	}

	/** full constructor */
	public BaseMonitSite(BaseMonitPersonel baseMonitPersonel, String name,
			String sectRive, Double beEastLo1, Double beNorthLa1,
			Double beEastLo2, Double beNorthLa2, Double endEastLo1,
			Double endNorthLa1, Double endEastLo2, Double endNorthLa2,
			Integer fisherboat, String remark, Set monitPhies,
			Set monitZooplans, Set genColonyResears, Set earlyWatchs,
			Set genSampleInfos, Set contamiFishs, Set monitBens,
			Set catchFishObjs) {
		this.baseMonitPersonel = baseMonitPersonel;
		this.name = name;
		this.sectRive = sectRive;
		this.beEastLo1 = beEastLo1;
		this.beNorthLa1 = beNorthLa1;
		this.beEastLo2 = beEastLo2;
		this.beNorthLa2 = beNorthLa2;
		this.endEastLo1 = endEastLo1;
		this.endNorthLa1 = endNorthLa1;
		this.endEastLo2 = endEastLo2;
		this.endNorthLa2 = endNorthLa2;
		this.fisherboat = fisherboat;
		this.remark = remark;
		this.monitPhies = monitPhies;
		this.monitZooplans = monitZooplans;
		this.genColonyResears = genColonyResears;
		this.earlyWatchs = earlyWatchs;
		this.genSampleInfos = genSampleInfos;
		this.contamiFishs = contamiFishs;
		this.monitBens = monitBens;
		this.catchFishObjs = catchFishObjs;
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSectRive() {
		return this.sectRive;
	}

	public void setSectRive(String sectRive) {
		this.sectRive = sectRive;
	}

	public Double getBeEastLo1() {
		return this.beEastLo1;
	}

	public void setBeEastLo1(Double beEastLo1) {
		this.beEastLo1 = beEastLo1;
	}

	public Double getBeNorthLa1() {
		return this.beNorthLa1;
	}

	public void setBeNorthLa1(Double beNorthLa1) {
		this.beNorthLa1 = beNorthLa1;
	}

	public Double getBeEastLo2() {
		return this.beEastLo2;
	}

	public void setBeEastLo2(Double beEastLo2) {
		this.beEastLo2 = beEastLo2;
	}

	public Double getBeNorthLa2() {
		return this.beNorthLa2;
	}

	public void setBeNorthLa2(Double beNorthLa2) {
		this.beNorthLa2 = beNorthLa2;
	}

	public Double getEndEastLo1() {
		return this.endEastLo1;
	}

	public void setEndEastLo1(Double endEastLo1) {
		this.endEastLo1 = endEastLo1;
	}

	public Double getEndNorthLa1() {
		return this.endNorthLa1;
	}

	public void setEndNorthLa1(Double endNorthLa1) {
		this.endNorthLa1 = endNorthLa1;
	}

	public Double getEndEastLo2() {
		return this.endEastLo2;
	}

	public void setEndEastLo2(Double endEastLo2) {
		this.endEastLo2 = endEastLo2;
	}

	public Double getEndNorthLa2() {
		return this.endNorthLa2;
	}

	public void setEndNorthLa2(Double endNorthLa2) {
		this.endNorthLa2 = endNorthLa2;
	}

	public Integer getFisherboat() {
		return this.fisherboat;
	}

	public void setFisherboat(Integer fisherboat) {
		this.fisherboat = fisherboat;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Set getMonitPhies() {
		return this.monitPhies;
	}

	public void setMonitPhies(Set monitPhies) {
		this.monitPhies = monitPhies;
	}

	public Set getMonitZooplans() {
		return this.monitZooplans;
	}

	public void setMonitZooplans(Set monitZooplans) {
		this.monitZooplans = monitZooplans;
	}

	public Set getGenColonyResears() {
		return this.genColonyResears;
	}

	public void setGenColonyResears(Set genColonyResears) {
		this.genColonyResears = genColonyResears;
	}

	public Set getEarlyWatchs() {
		return this.earlyWatchs;
	}

	public void setEarlyWatchs(Set earlyWatchs) {
		this.earlyWatchs = earlyWatchs;
	}

	public Set getGenSampleInfos() {
		return this.genSampleInfos;
	}

	public void setGenSampleInfos(Set genSampleInfos) {
		this.genSampleInfos = genSampleInfos;
	}

	public Set getContamiFishs() {
		return this.contamiFishs;
	}

	public void setContamiFishs(Set contamiFishs) {
		this.contamiFishs = contamiFishs;
	}

	public Set getMonitBens() {
		return this.monitBens;
	}

	public void setMonitBens(Set monitBens) {
		this.monitBens = monitBens;
	}

	public Set getCatchFishObjs() {
		return this.catchFishObjs;
	}

	public void setCatchFishObjs(Set catchFishObjs) {
		this.catchFishObjs = catchFishObjs;
	}

}