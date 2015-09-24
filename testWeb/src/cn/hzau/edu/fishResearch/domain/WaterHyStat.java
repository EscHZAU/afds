package cn.hzau.edu.fishResearch.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * WaterHyStat entity. @author MyEclipse Persistence Tools
 */

public class WaterHyStat implements java.io.Serializable {

	// Fields

	private Integer id;
	private String statCode;
	private String name;
	private String basin;
	private String adminArea;
	private String sectRive;
	private Double eastLo;
	private Double northLa;
	private Set waterHyDatas = new HashSet(0);

	// Constructors

	/** default constructor */
	public WaterHyStat() {
	}

	/** minimal constructor */
	public WaterHyStat(String statCode, String name, String sectRive) {
		this.statCode = statCode;
		this.name = name;
		this.sectRive = sectRive;
	}

	/** full constructor */
	public WaterHyStat(String statCode, String name, String basin,
			String adminArea, String sectRive, Double eastLo, Double northLa,
			Set waterHyDatas) {
		this.statCode = statCode;
		this.name = name;
		this.basin = basin;
		this.adminArea = adminArea;
		this.sectRive = sectRive;
		this.eastLo = eastLo;
		this.northLa = northLa;
		this.waterHyDatas = waterHyDatas;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatCode() {
		return this.statCode;
	}

	public void setStatCode(String statCode) {
		this.statCode = statCode;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBasin() {
		return this.basin;
	}

	public void setBasin(String basin) {
		this.basin = basin;
	}

	public String getAdminArea() {
		return this.adminArea;
	}

	public void setAdminArea(String adminArea) {
		this.adminArea = adminArea;
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

	public Set getWaterHyDatas() {
		return this.waterHyDatas;
	}

	public void setWaterHyDatas(Set waterHyDatas) {
		this.waterHyDatas = waterHyDatas;
	}

}