package cn.hzau.edu.fishResearch.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * BaseIndexMethod entity. @author MyEclipse Persistence Tools
 */

public class BaseIndexMethod implements java.io.Serializable {

	// Fields

	private Integer id;
	private String methodType;
	private String name;
	private String keyInstrument;
	private String methodDescription;
	private String unit;
	private String methodSource;
	private Set contamiAnalysises = new HashSet(0);
	private Set earlyWaterQualits = new HashSet(0);

	// Constructors

	/** default constructor */
	public BaseIndexMethod() {
	}

	/** minimal constructor */
	public BaseIndexMethod(String methodType, String name) {
		this.methodType = methodType;
		this.name = name;
	}

	/** full constructor */
	public BaseIndexMethod(String methodType, String name,
			String keyInstrument, String methodDescription, String unit,
			String methodSource, Set contamiAnalysises, Set earlyWaterQualits) {
		this.methodType = methodType;
		this.name = name;
		this.keyInstrument = keyInstrument;
		this.methodDescription = methodDescription;
		this.unit = unit;
		this.methodSource = methodSource;
		this.contamiAnalysises = contamiAnalysises;
		this.earlyWaterQualits = earlyWaterQualits;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMethodType() {
		return this.methodType;
	}

	public void setMethodType(String methodType) {
		this.methodType = methodType;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKeyInstrument() {
		return this.keyInstrument;
	}

	public void setKeyInstrument(String keyInstrument) {
		this.keyInstrument = keyInstrument;
	}

	public String getMethodDescription() {
		return this.methodDescription;
	}

	public void setMethodDescription(String methodDescription) {
		this.methodDescription = methodDescription;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getMethodSource() {
		return this.methodSource;
	}

	public void setMethodSource(String methodSource) {
		this.methodSource = methodSource;
	}

	public Set getContamiAnalysises() {
		return this.contamiAnalysises;
	}

	public void setContamiAnalysises(Set contamiAnalysises) {
		this.contamiAnalysises = contamiAnalysises;
	}

	public Set getEarlyWaterQualits() {
		return this.earlyWaterQualits;
	}

	public void setEarlyWaterQualits(Set earlyWaterQualits) {
		this.earlyWaterQualits = earlyWaterQualits;
	}

}