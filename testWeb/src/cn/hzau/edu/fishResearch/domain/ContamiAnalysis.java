package cn.hzau.edu.fishResearch.domain;

import java.sql.Timestamp;

/**
 * ContamiAnalysis entity. @author MyEclipse Persistence Tools
 */

public class ContamiAnalysis implements java.io.Serializable {

	// Fields

	private Integer id;
	private ContamiFish contamiFish;
	private BaseIndexMethod baseIndexMethod;
	private String conGuid;
	private String monitPerson;
	private String envMeasureNo;
	private String tissue;
	private Double cu;
	private String cuMethod;
	private Double zn;
	private String znMethod;
	private Double pb;
	private String pbMethod;
	private Double cd;
	private String cdMethod;
	private Double hg;
	private String hgMethod;
	private Double as1;
	private String as1method;
	private String ownerUnit;
	private String ownerId;
	private Timestamp operateTime;
	private Integer dataState;

	// Constructors

	/** default constructor */
	public ContamiAnalysis() {
	}

	/** minimal constructor */
	public ContamiAnalysis(String conGuid, String monitPerson,
			String envMeasureNo, String tissue, String ownerId,
			Timestamp operateTime, Integer dataState) {
		this.conGuid = conGuid;
		this.monitPerson = monitPerson;
		this.envMeasureNo = envMeasureNo;
		this.tissue = tissue;
		this.ownerId = ownerId;
		this.operateTime = operateTime;
		this.dataState = dataState;
	}

	/** full constructor */
	public ContamiAnalysis(ContamiFish contamiFish,
			BaseIndexMethod baseIndexMethod, String conGuid,
			String monitPerson, String envMeasureNo, String tissue, Double cu,
			String cuMethod, Double zn, String znMethod, Double pb,
			String pbMethod, Double cd, String cdMethod, Double hg,
			String hgMethod, Double as1, String as1method, String ownerUnit,
			String ownerId, Timestamp operateTime, Integer dataState) {
		this.contamiFish = contamiFish;
		this.baseIndexMethod = baseIndexMethod;
		this.conGuid = conGuid;
		this.monitPerson = monitPerson;
		this.envMeasureNo = envMeasureNo;
		this.tissue = tissue;
		this.cu = cu;
		this.cuMethod = cuMethod;
		this.zn = zn;
		this.znMethod = znMethod;
		this.pb = pb;
		this.pbMethod = pbMethod;
		this.cd = cd;
		this.cdMethod = cdMethod;
		this.hg = hg;
		this.hgMethod = hgMethod;
		this.as1 = as1;
		this.as1method = as1method;
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

	public ContamiFish getContamiFish() {
		return this.contamiFish;
	}

	public void setContamiFish(ContamiFish contamiFish) {
		this.contamiFish = contamiFish;
	}

	public BaseIndexMethod getBaseIndexMethod() {
		return this.baseIndexMethod;
	}

	public void setBaseIndexMethod(BaseIndexMethod baseIndexMethod) {
		this.baseIndexMethod = baseIndexMethod;
	}

	public String getConGuid() {
		return this.conGuid;
	}

	public void setConGuid(String conGuid) {
		this.conGuid = conGuid;
	}

	public String getMonitPerson() {
		return this.monitPerson;
	}

	public void setMonitPerson(String monitPerson) {
		this.monitPerson = monitPerson;
	}

	public String getEnvMeasureNo() {
		return this.envMeasureNo;
	}

	public void setEnvMeasureNo(String envMeasureNo) {
		this.envMeasureNo = envMeasureNo;
	}

	public String getTissue() {
		return this.tissue;
	}

	public void setTissue(String tissue) {
		this.tissue = tissue;
	}

	public Double getCu() {
		return this.cu;
	}

	public void setCu(Double cu) {
		this.cu = cu;
	}

	public String getCuMethod() {
		return this.cuMethod;
	}

	public void setCuMethod(String cuMethod) {
		this.cuMethod = cuMethod;
	}

	public Double getZn() {
		return this.zn;
	}

	public void setZn(Double zn) {
		this.zn = zn;
	}

	public String getZnMethod() {
		return this.znMethod;
	}

	public void setZnMethod(String znMethod) {
		this.znMethod = znMethod;
	}

	public Double getPb() {
		return this.pb;
	}

	public void setPb(Double pb) {
		this.pb = pb;
	}

	public String getPbMethod() {
		return this.pbMethod;
	}

	public void setPbMethod(String pbMethod) {
		this.pbMethod = pbMethod;
	}

	public Double getCd() {
		return this.cd;
	}

	public void setCd(Double cd) {
		this.cd = cd;
	}

	public String getCdMethod() {
		return this.cdMethod;
	}

	public void setCdMethod(String cdMethod) {
		this.cdMethod = cdMethod;
	}

	public Double getHg() {
		return this.hg;
	}

	public void setHg(Double hg) {
		this.hg = hg;
	}

	public String getHgMethod() {
		return this.hgMethod;
	}

	public void setHgMethod(String hgMethod) {
		this.hgMethod = hgMethod;
	}

	public Double getAs1() {
		return this.as1;
	}

	public void setAs1(Double as1) {
		this.as1 = as1;
	}

	public String getAs1method() {
		return this.as1method;
	}

	public void setAs1method(String as1method) {
		this.as1method = as1method;
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