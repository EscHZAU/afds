package cn.hzau.edu.fishResearch.domain;

/**
 * SySystemLog entity. @author MyEclipse Persistence Tools
 */

public class SySystemLog implements java.io.Serializable {

	// Fields

	private Integer id;
	private String userGuid;
	private String ip;
	private String computer;
	private String loginTime;
	private String logoutTime;

	// Constructors

	/** default constructor */
	public SySystemLog() {
	}

	/** minimal constructor */
	public SySystemLog(String userGuid, String ip) {
		this.userGuid = userGuid;
		this.ip = ip;
	}

	/** full constructor */
	public SySystemLog(String userGuid, String ip, String computer,
			String loginTime, String logoutTime) {
		this.userGuid = userGuid;
		this.ip = ip;
		this.computer = computer;
		this.loginTime = loginTime;
		this.logoutTime = logoutTime;
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

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getComputer() {
		return this.computer;
	}

	public void setComputer(String computer) {
		this.computer = computer;
	}

	public String getLoginTime() {
		return this.loginTime;
	}

	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}

	public String getLogoutTime() {
		return this.logoutTime;
	}

	public void setLogoutTime(String logoutTime) {
		this.logoutTime = logoutTime;
	}

}