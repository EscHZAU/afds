package cn.hzau.edu.fishResearch.domain;

/**
 * SyTableInfoId entity. @author MyEclipse Persistence Tools
 */

public class SyTableInfoId implements java.io.Serializable {

	// Fields

	private String �ӿ�;
	private String �����;
	private String ����;
	private String ���ı���;

	// Constructors

	/** default constructor */
	public SyTableInfoId() {
	}

	/** full constructor */
	public SyTableInfoId(String �ӿ�, String �����, String ����, String ���ı���) {
		this.�ӿ� = �ӿ�;
		this.����� = �����;
		this.���� = ����;
		this.���ı��� = ���ı���;
	}

	// Property accessors

	public String get�ӿ�() {
		return this.�ӿ�;
	}

	public void set�ӿ�(String �ӿ�) {
		this.�ӿ� = �ӿ�;
	}

	public String get�����() {
		return this.�����;
	}

	public void set�����(String �����) {
		this.����� = �����;
	}

	public String get����() {
		return this.����;
	}

	public void set����(String ����) {
		this.���� = ����;
	}

	public String get���ı���() {
		return this.���ı���;
	}

	public void set���ı���(String ���ı���) {
		this.���ı��� = ���ı���;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SyTableInfoId))
			return false;
		SyTableInfoId castOther = (SyTableInfoId) other;

		return ((this.get�ӿ�() == castOther.get�ӿ�()) || (this.get�ӿ�() != null
				&& castOther.get�ӿ�() != null && this.get�ӿ�().equals(
				castOther.get�ӿ�())))
				&& ((this.get�����() == castOther.get�����()) || (this.get�����() != null
						&& castOther.get�����() != null && this.get�����().equals(
						castOther.get�����())))
				&& ((this.get����() == castOther.get����()) || (this.get����() != null
						&& castOther.get����() != null && this.get����().equals(
						castOther.get����())))
				&& ((this.get���ı���() == castOther.get���ı���()) || (this.get���ı���() != null
						&& castOther.get���ı���() != null && this.get���ı���()
						.equals(castOther.get���ı���())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (get�ӿ�() == null ? 0 : this.get�ӿ�().hashCode());
		result = 37 * result
				+ (get�����() == null ? 0 : this.get�����().hashCode());
		result = 37 * result + (get����() == null ? 0 : this.get����().hashCode());
		result = 37 * result
				+ (get���ı���() == null ? 0 : this.get���ı���().hashCode());
		return result;
	}

}