package cn.hzau.edu.fishResearch.domain;

/**
 * SySystemCode entity. @author MyEclipse Persistence Tools
 */

public class SySystemCode implements java.io.Serializable {

	// Fields

	private Integer id;
	private String tableName;
	private String fieldName;
	private String fieldNameCn;
	private Integer code;
	private String text;

	// Constructors

	/** default constructor */
	public SySystemCode() {
	}

	/** full constructor */
	public SySystemCode(String tableName, String fieldName, String fieldNameCn,
			Integer code, String text) {
		this.tableName = tableName;
		this.fieldName = fieldName;
		this.fieldNameCn = fieldNameCn;
		this.code = code;
		this.text = text;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTableName() {
		return this.tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getFieldName() {
		return this.fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldNameCn() {
		return this.fieldNameCn;
	}

	public void setFieldNameCn(String fieldNameCn) {
		this.fieldNameCn = fieldNameCn;
	}

	public Integer getCode() {
		return this.code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

}