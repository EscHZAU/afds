package cn.hzau.edu.fishResearch.domain;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * CatchFishingGear entity. @author MyEclipse Persistence Tools
 */

public class CatchFishingGear implements java.io.Serializable {

	// Fields

	private Integer id;
	private String catGuid;
	private String monitPerson;
	private String measureNo;
	private String fishGearType;
	private String fishGearName;
	private Integer netLong;
	private Double netHigh;
	private Double mesh;
	private String photo;
	private String ownerUnit;
	private String ownerId;
	private Timestamp operateTime;
	private Integer dataState;
	private Set catchFishObjs = new HashSet(0);

	// Constructors

	/** default constructor */
	public CatchFishingGear() {
	}

	/** minimal constructor */
	public CatchFishingGear(String catGuid, String monitPerson,
			String fishGearType, String fishGearName, String ownerId,
			Timestamp operateTime, Integer dataState) {
		this.catGuid = catGuid;
		this.monitPerson = monitPerson;
		this.fishGearType = fishGearType;
		this.fishGearName = fishGearName;
		this.ownerId = ownerId;
		this.operateTime = operateTime;
		this.dataState = dataState;
	}

	/** full constructor */
	public CatchFishingGear(String catGuid, String monitPerson,
			String measureNo, String fishGearType, String fishGearName,
			Integer netLong, Double netHigh, Double mesh, String photo,
			String ownerUnit, String ownerId, Timestamp operateTime,
			Integer dataState, Set catchFishObjs) {
		this.catGuid = catGuid;
		this.monitPerson = monitPerson;
		this.measureNo = measureNo;
		this.fishGearType = fishGearType;
		this.fishGearName = fishGearName;
		this.netLong = netLong;
		this.netHigh = netHigh;
		this.mesh = mesh;
		this.photo = photo;
		this.ownerUnit = ownerUnit;
		this.ownerId = ownerId;
		this.operateTime = operateTime;
		this.dataState = dataState;
		this.catchFishObjs = catchFishObjs;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getMeasureNo() {
		return this.measureNo;
	}

	public void setMeasureNo(String measureNo) {
		this.measureNo = measureNo;
	}

	public String getFishGearType() {
		return this.fishGearType;
	}

	public void setFishGearType(String fishGearType) {
		this.fishGearType = fishGearType;
	}

	public String getFishGearName() {
		return this.fishGearName;
	}

	public void setFishGearName(String fishGearName) {
		this.fishGearName = fishGearName;
	}

	public Integer getNetLong() {
		return this.netLong;
	}

	public void setNetLong(Integer netLong) {
		this.netLong = netLong;
	}

	public Double getNetHigh() {
		return this.netHigh;
	}

	public void setNetHigh(Double netHigh) {
		this.netHigh = netHigh;
	}

	public Double getMesh() {
		return this.mesh;
	}

	public void setMesh(Double mesh) {
		this.mesh = mesh;
	}

	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
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

	public Set getCatchFishObjs() {
		return this.catchFishObjs;
	}

	public void setCatchFishObjs(Set catchFishObjs) {
		this.catchFishObjs = catchFishObjs;
	}

}