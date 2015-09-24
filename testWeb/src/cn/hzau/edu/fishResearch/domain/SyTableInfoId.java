package cn.hzau.edu.fishResearch.domain;

/**
 * SyTableInfoId entity. @author MyEclipse Persistence Tools
 */

public class SyTableInfoId implements java.io.Serializable {

	// Fields

	private String 子库;
	private String 表序号;
	private String 表名;
	private String 中文表名;

	// Constructors

	/** default constructor */
	public SyTableInfoId() {
	}

	/** full constructor */
	public SyTableInfoId(String 子库, String 表序号, String 表名, String 中文表名) {
		this.子库 = 子库;
		this.表序号 = 表序号;
		this.表名 = 表名;
		this.中文表名 = 中文表名;
	}

	// Property accessors

	public String get子库() {
		return this.子库;
	}

	public void set子库(String 子库) {
		this.子库 = 子库;
	}

	public String get表序号() {
		return this.表序号;
	}

	public void set表序号(String 表序号) {
		this.表序号 = 表序号;
	}

	public String get表名() {
		return this.表名;
	}

	public void set表名(String 表名) {
		this.表名 = 表名;
	}

	public String get中文表名() {
		return this.中文表名;
	}

	public void set中文表名(String 中文表名) {
		this.中文表名 = 中文表名;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SyTableInfoId))
			return false;
		SyTableInfoId castOther = (SyTableInfoId) other;

		return ((this.get子库() == castOther.get子库()) || (this.get子库() != null
				&& castOther.get子库() != null && this.get子库().equals(
				castOther.get子库())))
				&& ((this.get表序号() == castOther.get表序号()) || (this.get表序号() != null
						&& castOther.get表序号() != null && this.get表序号().equals(
						castOther.get表序号())))
				&& ((this.get表名() == castOther.get表名()) || (this.get表名() != null
						&& castOther.get表名() != null && this.get表名().equals(
						castOther.get表名())))
				&& ((this.get中文表名() == castOther.get中文表名()) || (this.get中文表名() != null
						&& castOther.get中文表名() != null && this.get中文表名()
						.equals(castOther.get中文表名())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (get子库() == null ? 0 : this.get子库().hashCode());
		result = 37 * result
				+ (get表序号() == null ? 0 : this.get表序号().hashCode());
		result = 37 * result + (get表名() == null ? 0 : this.get表名().hashCode());
		result = 37 * result
				+ (get中文表名() == null ? 0 : this.get中文表名().hashCode());
		return result;
	}

}