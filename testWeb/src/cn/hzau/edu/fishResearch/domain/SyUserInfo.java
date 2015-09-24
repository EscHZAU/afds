package cn.hzau.edu.fishResearch.domain;

/**
 * SyUserInfo entity. @author MyEclipse Persistence Tools
 */

public class SyUserInfo implements java.io.Serializable {

	// Fields

	private Integer id;
	private BaseMonitUnit baseMonitUnit;
	private SyUserGroup syUserGroup;
	private String userGuid;
	private String groupName;
	private String monitUnitName;
	private String userName;
	private String passWord;
	private String telephone;
	private String email;
	private String description;
	private String active;

	// Constructors

	/** default constructor */
	public SyUserInfo() {
	}

	/** minimal constructor */
	public SyUserInfo(String userGuid, String groupName, String monitUnitName,
			String userName) {
		this.userGuid = userGuid;
		this.groupName = groupName;
		this.monitUnitName = monitUnitName;
		this.userName = userName;
	}

	/** full constructor */
	public SyUserInfo(BaseMonitUnit baseMonitUnit, SyUserGroup syUserGroup,
			String userGuid, String groupName, String monitUnitName,
			String userName, String passWord, String telephone, String email,
			String description, String active) {
		this.baseMonitUnit = baseMonitUnit;
		this.syUserGroup = syUserGroup;
		this.userGuid = userGuid;
		this.groupName = groupName;
		this.monitUnitName = monitUnitName;
		this.userName = userName;
		this.passWord = passWord;
		this.telephone = telephone;
		this.email = email;
		this.description = description;
		this.active = active;
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

	public SyUserGroup getSyUserGroup() {
		return this.syUserGroup;
	}

	public void setSyUserGroup(SyUserGroup syUserGroup) {
		this.syUserGroup = syUserGroup;
	}

	public String getUserGuid() {
		return this.userGuid;
	}

	public void setUserGuid(String userGuid) {
		this.userGuid = userGuid;
	}

	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getMonitUnitName() {
		return this.monitUnitName;
	}

	public void setMonitUnitName(String monitUnitName) {
		this.monitUnitName = monitUnitName;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return this.passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getActive() {
		return this.active;
	}

	public void setActive(String active) {
		this.active = active;
	}

}