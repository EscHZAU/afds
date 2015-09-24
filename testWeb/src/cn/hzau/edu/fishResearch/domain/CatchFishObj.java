package cn.hzau.edu.fishResearch.domain;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * CatchFishObj entity. @author MyEclipse Persistence Tools
 */

public class CatchFishObj implements java.io.Serializable {

	// Fields

	private Integer id;
	private CatchFishingGear catchFishingGear;
	private BaseMonitPersonel baseMonitPersonel;
	private BaseMonitSite baseMonitSite;
	private BaseFish baseFish;
	private String catGuid;
	private String monitPerson;
	private String monitSiteName;
	private String sectRive;
	private Timestamp monitDate;
	private Double eastLo;
	private Double northLa;
	private String boat;
	private Timestamp beginTime;
	private Timestamp endTime;
	private Integer persistTime;
	private String operationTime;
	private String netTimes;
	private String fishName;
	private String measureNo;
	private Integer totalLeng;
	private Integer bodyLeng;
	private Double bodyWeigh;
	private String moleculeSample;
	private Integer quantity;
	private String remark;
	private String ownerUnit;
	private String ownerId;
	private Timestamp operateTime;
	private Integer dataState;
	private Set catchBiologs = new HashSet(0);

	// Constructors

	/** default constructor */
	public CatchFishObj() {
	}

	/** minimal constructor */
	public CatchFishObj(String catGuid, String monitPerson,
			String monitSiteName, String sectRive, Timestamp monitDate,
			Timestamp beginTime, Timestamp endTime, Integer persistTime,
			String fishName, String measureNo, String ownerId,
			Timestamp operateTime, Integer dataState) {
		this.catGuid = catGuid;
		this.monitPerson = monitPerson;
		this.monitSiteName = monitSiteName;
		this.sectRive = sectRive;
		this.monitDate = monitDate;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.persistTime = persistTime;
		this.fishName = fishName;
		this.measureNo = measureNo;
		this.ownerId = ownerId;
		this.operateTime = operateTime;
		this.dataState = dataState;
	}

	/** full constructor */
	public CatchFishObj(CatchFishingGear catchFishingGear,
			BaseMonitPersonel baseMonitPersonel, BaseMonitSite baseMonitSite,
			BaseFish baseFish, String catGuid, String monitPerson,
			String monitSiteName, String sectRive, Timestamp monitDate,
			Double eastLo, Double northLa, String boat, Timestamp beginTime,
			Timestamp endTime, Integer persistTime, String operationTime,
			String netTimes, String fishName, String measureNo,
			Integer totalLeng, Integer bodyLeng, Double bodyWeigh,
			String moleculeSample, Integer quantity, String remark,
			String ownerUnit, String ownerId, Timestamp operateTime,
			Integer dataState, Set catchBiologs) {
		this.catchFishingGear = catchFishingGear;
		this.baseMonitPersonel = baseMonitPersonel;
		this.baseMonitSite = baseMonitSite;
		this.baseFish = baseFish;
		this.catGuid = catGuid;
		this.monitPerson = monitPerson;
		this.monitSiteName = monitSiteName;
		this.sectRive = sectRive;
		this.monitDate = monitDate;
		this.eastLo = eastLo;
		this.northLa = northLa;
		this.boat = boat;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.persistTime = persistTime;
		this.operationTime = operationTime;
		this.netTimes = netTimes;
		this.fishName = fishName;
		this.measureNo = measureNo;
		this.totalLeng = totalLeng;
		this.bodyLeng = bodyLeng;
		this.bodyWeigh = bodyWeigh;
		this.moleculeSample = moleculeSample;
		this.quantity = quantity;
		this.remark = remark;
		this.ownerUnit = ownerUnit;
		this.ownerId = ownerId;
		this.operateTime = operateTime;
		this.dataState = dataState;
		this.catchBiologs = catchBiologs;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CatchFishingGear getCatchFishingGear() {
		return this.catchFishingGear;
	}

	public void setCatchFishingGear(CatchFishingGear catchFishingGear) {
		this.catchFishingGear = catchFishingGear;
	}

	public BaseMonitPersonel getBaseMonitPersonel() {
		return this.baseMonitPersonel;
	}

	public void setBaseMonitPersonel(BaseMonitPersonel baseMonitPersonel) {
		this.baseMonitPersonel = baseMonitPersonel;
	}

	public BaseMonitSite getBaseMonitSite() {
		return this.baseMonitSite;
	}

	public void setBaseMonitSite(BaseMonitSite baseMonitSite) {
		this.baseMonitSite = baseMonitSite;
	}

	public BaseFish getBaseFish() {
		return this.baseFish;
	}

	public void setBaseFish(BaseFish baseFish) {
		this.baseFish = baseFish;
	}

	public String getCatGuid() {
		return this.catGuid;
	}

	public void setCatGuid(String catGuid) {
		this.catGuid = catGuid;
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

	public String getSectRive() {
		return this.sectRive;
	}

	public void setSectRive(String sectRive) {
		this.sectRive = sectRive;
	}

	public Timestamp getMonitDate() {
		return this.monitDate;
	}

	public void setMonitDate(Timestamp monitDate) {
		this.monitDate = monitDate;
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

	public String getBoat() {
		return this.boat;
	}

	public void setBoat(String boat) {
		this.boat = boat;
	}

	public Timestamp getBeginTime() {
		return this.beginTime;
	}

	public void setBeginTime(Timestamp beginTime) {
		this.beginTime = beginTime;
	}

	public Timestamp getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public Integer getPersistTime() {
		return this.persistTime;
	}

	public void setPersistTime(Integer persistTime) {
		this.persistTime = persistTime;
	}

	public String getOperationTime() {
		return this.operationTime;
	}

	public void setOperationTime(String operationTime) {
		this.operationTime = operationTime;
	}

	public String getNetTimes() {
		return this.netTimes;
	}

	public void setNetTimes(String netTimes) {
		this.netTimes = netTimes;
	}

	public String getFishName() {
		return this.fishName;
	}

	public void setFishName(String fishName) {
		this.fishName = fishName;
	}

	public String getMeasureNo() {
		return this.measureNo;
	}

	public void setMeasureNo(String measureNo) {
		this.measureNo = measureNo;
	}

	public Integer getTotalLeng() {
		return this.totalLeng;
	}

	public void setTotalLeng(Integer totalLeng) {
		this.totalLeng = totalLeng;
	}

	public Integer getBodyLeng() {
		return this.bodyLeng;
	}

	public void setBodyLeng(Integer bodyLeng) {
		this.bodyLeng = bodyLeng;
	}

	public Double getBodyWeigh() {
		return this.bodyWeigh;
	}

	public void setBodyWeigh(Double bodyWeigh) {
		this.bodyWeigh = bodyWeigh;
	}

	public String getMoleculeSample() {
		return this.moleculeSample;
	}

	public void setMoleculeSample(String moleculeSample) {
		this.moleculeSample = moleculeSample;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public Set getCatchBiologs() {
		return this.catchBiologs;
	}

	public void setCatchBiologs(Set catchBiologs) {
		this.catchBiologs = catchBiologs;
	}

}