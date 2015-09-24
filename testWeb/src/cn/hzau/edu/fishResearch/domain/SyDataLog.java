package cn.hzau.edu.fishResearch.domain;

import java.sql.Timestamp;

/**
 * SyDataLog entity. @author MyEclipse Persistence Tools
 */

public class SyDataLog implements java.io.Serializable {

	// Fields

	private Integer id;
	private String userGuid;
	private String work;
	private Timestamp workTime;
	private String tableName;
	private String tableNameCn;
	private Integer recordCount;

	// Constructors

	/** default constructor */
	public SyDataLog() {
	}

	/** full constructor */
	public SyDataLog(String userGuid, String work, Timestamp workTime,
			String tableName, String tableNameCn, Integer recordCount) {
		this.userGuid = userGuid;
		this.work = work;
		this.workTime = workTime;
		this.tableName = tableName;
		this.tableNameCn = tableNameCn;
		this.recordCount = recordCount;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserGuid() {
		return this.userGuid;
	}

	public void setUserGuid(String userGuid) {
		this.userGuid = userGuid;
	}

	public String getWork() {
		return this.work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public Timestamp getWorkTime() {
		return this.workTime;
	}

	public void setWorkTime(Timestamp workTime) {
		this.workTime = workTime;
	}

	public String getTableName() {
		return this.tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getTableNameCn() {
		return this.tableNameCn;
	}

	public void setTableNameCn(String tableNameCn) {
		this.tableNameCn = tableNameCn;
	}

	public Integer getRecordCount() {
		return this.recordCount;
	}

	public void setRecordCount(Integer recordCount) {
		this.recordCount = recordCount;
	}

}