package cn.hzau.edu.fishResearch.domain;

import java.sql.Timestamp;

/**
 * WaterHyData entity. @author MyEclipse Persistence Tools
 */

public class WaterHyData implements java.io.Serializable {

	// Fields

	private Integer id;
	private WaterHyStat waterHyStat;
	private String statName;
	private Timestamp monitDate;
	private Timestamp monitTime;
	private Double waterLev;
	private String levRisAdown;
	private Integer waterFlo;
	private Double alarmWaterLev;

	// Constructors

	/** default constructor */
	public WaterHyData() {
	}

	/** minimal constructor */
	public WaterHyData(String statName, Timestamp monitDate,
			Timestamp monitTime, Double waterLev, String levRisAdown,
			Integer waterFlo, Double alarmWaterLev) {
		this.statName = statName;
		this.monitDate = monitDate;
		this.monitTime = monitTime;
		this.waterLev = waterLev;
		this.levRisAdown = levRisAdown;
		this.waterFlo = waterFlo;
		this.alarmWaterLev = alarmWaterLev;
	}

	/** full constructor */
	public WaterHyData(WaterHyStat waterHyStat, String statName,
			Timestamp monitDate, Timestamp monitTime, Double waterLev,
			String levRisAdown, Integer waterFlo, Double alarmWaterLev) {
		this.waterHyStat = waterHyStat;
		this.statName = statName;
		this.monitDate = monitDate;
		this.monitTime = monitTime;
		this.waterLev = waterLev;
		this.levRisAdown = levRisAdown;
		this.waterFlo = waterFlo;
		this.alarmWaterLev = alarmWaterLev;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public WaterHyStat getWaterHyStat() {
		return this.waterHyStat;
	}

	public void setWaterHyStat(WaterHyStat waterHyStat) {
		this.waterHyStat = waterHyStat;
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

	public Timestamp getMonitTime() {
		return this.monitTime;
	}

	public void setMonitTime(Timestamp monitTime) {
		this.monitTime = monitTime;
	}

	public Double getWaterLev() {
		return this.waterLev;
	}

	public void setWaterLev(Double waterLev) {
		this.waterLev = waterLev;
	}

	public String getLevRisAdown() {
		return this.levRisAdown;
	}

	public void setLevRisAdown(String levRisAdown) {
		this.levRisAdown = levRisAdown;
	}

	public Integer getWaterFlo() {
		return this.waterFlo;
	}

	public void setWaterFlo(Integer waterFlo) {
		this.waterFlo = waterFlo;
	}

	public Double getAlarmWaterLev() {
		return this.alarmWaterLev;
	}

	public void setAlarmWaterLev(Double alarmWaterLev) {
		this.alarmWaterLev = alarmWaterLev;
	}

}