package cn.hzau.edu.fishResearch.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * BaseMonitPersonel entity. @author MyEclipse Persistence Tools
 */

public class BaseMonitPersonel implements java.io.Serializable {

	// Fields

	private Integer id;
	private BaseMonitUnit baseMonitUnit;
	private String monitPerson;
	private String auditor;
	private String monitUnitName;
	private Set earlyWatchs = new HashSet(0);
	private Set catchFishObjs = new HashSet(0);
	private Set baseMonitSites = new HashSet(0);

	// Constructors

	/** default constructor */
	public BaseMonitPersonel() {
	}

	/** minimal constructor */
	public BaseMonitPersonel(BaseMonitUnit baseMonitUnit, String monitPerson,
			String monitUnitName) {
		this.baseMonitUnit = baseMonitUnit;
		this.monitPerson = monitPerson;
		this.monitUnitName = monitUnitName;
	}

	/** full constructor */
	public BaseMonitPersonel(BaseMonitUnit baseMonitUnit, String monitPerson,
			String auditor, String monitUnitName, Set earlyWatchs,
			Set catchFishObjs, Set baseMonitSites) {
		this.baseMonitUnit = baseMonitUnit;
		this.monitPerson = monitPerson;
		this.auditor = auditor;
		this.monitUnitName = monitUnitName;
		this.earlyWatchs = earlyWatchs;
		this.catchFishObjs = catchFishObjs;
		this.baseMonitSites = baseMonitSites;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BaseMonitUnit getBaseMonitUnit() {
		return this.baseMonitUnit;
	}

	public void setBaseMonitUnit(BaseMonitUnit baseMonitUnit) {
		this.baseMonitUnit = baseMonitUnit;
	}

	public String getMonitPerson() {
		return this.monitPerson;
	}

	public void setMonitPerson(String monitPerson) {
		this.monitPerson = monitPerson;
	}

	public String getAuditor() {
		return this.auditor;
	}

	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}

	public String getMonitUnitName() {
		return this.monitUnitName;
	}

	public void setMonitUnitName(String monitUnitName) {
		this.monitUnitName = monitUnitName;
	}

	public Set getEarlyWatchs() {
		return this.earlyWatchs;
	}

	public void setEarlyWatchs(Set earlyWatchs) {
		this.earlyWatchs = earlyWatchs;
	}

	public Set getCatchFishObjs() {
		return this.catchFishObjs;
	}

	public void setCatchFishObjs(Set catchFishObjs) {
		this.catchFishObjs = catchFishObjs;
	}

	public Set getBaseMonitSites() {
		return this.baseMonitSites;
	}

	public void setBaseMonitSites(Set baseMonitSites) {
		this.baseMonitSites = baseMonitSites;
	}

}