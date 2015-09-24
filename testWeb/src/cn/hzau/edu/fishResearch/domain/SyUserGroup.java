package cn.hzau.edu.fishResearch.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * SyUserGroup entity. @author MyEclipse Persistence Tools
 */

public class SyUserGroup implements java.io.Serializable {

	// Fields

	private Integer id;
	private String groupName;
	private String description;
	private Set syUserInfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public SyUserGroup() {
	}

	/** minimal constructor */
	public SyUserGroup(String groupName) {
		this.groupName = groupName;
	}

	/** full constructor */
	public SyUserGroup(String groupName, String description, Set syUserInfos) {
		this.groupName = groupName;
		this.description = description;
		this.syUserInfos = syUserInfos;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set getSyUserInfos() {
		return this.syUserInfos;
	}

	public void setSyUserInfos(Set syUserInfos) {
		this.syUserInfos = syUserInfos;
	}

}