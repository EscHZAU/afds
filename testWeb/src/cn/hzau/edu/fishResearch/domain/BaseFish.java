package cn.hzau.edu.fishResearch.domain;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * BaseFish entity. @author MyEclipse Persistence Tools
 */

public class BaseFish implements java.io.Serializable {

	// Fields

	private Integer id;
	private String species;
	private String commname;
	private String latinSpecies;
	private String subspecies;
	private String latinSubspecies;
	private String genus;
	private String latinGenus;
	private String subgenus;
	private String latinSubgenus;
	private String superfamily;
	private String latinSuperfamily;
	private String family;
	private String latinFamily;
	private String subfamily;
	private String latinSubfamily;
	private String superoder;
	private String latinSuperoder;
	private String order1;
	private String latinOrder;
	private String suborder;
	private String latinSuborder;
	private String superclass;
	private String latinSuperclass;
	private String class1;
	private String latinClass;
	private String subclass;
	private String latinSubclass;
	private String phylum;
	private String latinPhylum;
	private String subphylum;
	private String latinSubphylum;
	private String lifehabit;
	private String statusResource;
	private String distribution;
	private String picture;
	private String remark;
	private String dataProvider;
	private Timestamp updateTime;
	private String endemismYangtze;
	private Set earlyBiologs = new HashSet(0);
	private Set catchFishObjs = new HashSet(0);
	private Set catchBiologs = new HashSet(0);
	private Set contamiFishs = new HashSet(0);
	private Set genMolecuMakers = new HashSet(0);

	// Constructors

	/** default constructor */
	public BaseFish() {
	}

	/** minimal constructor */
	public BaseFish(String species) {
		this.species = species;
	}

	/** full constructor */
	public BaseFish(String species, String commname, String latinSpecies,
			String subspecies, String latinSubspecies, String genus,
			String latinGenus, String subgenus, String latinSubgenus,
			String superfamily, String latinSuperfamily, String family,
			String latinFamily, String subfamily, String latinSubfamily,
			String superoder, String latinSuperoder, String order1,
			String latinOrder, String suborder, String latinSuborder,
			String superclass, String latinSuperclass, String class1,
			String latinClass, String subclass, String latinSubclass,
			String phylum, String latinPhylum, String subphylum,
			String latinSubphylum, String lifehabit, String statusResource,
			String distribution, String picture, String remark,
			String dataProvider, Timestamp updateTime, String endemismYangtze,
			Set earlyBiologs, Set catchFishObjs, Set catchBiologs,
			Set contamiFishs, Set genMolecuMakers) {
		this.species = species;
		this.commname = commname;
		this.latinSpecies = latinSpecies;
		this.subspecies = subspecies;
		this.latinSubspecies = latinSubspecies;
		this.genus = genus;
		this.latinGenus = latinGenus;
		this.subgenus = subgenus;
		this.latinSubgenus = latinSubgenus;
		this.superfamily = superfamily;
		this.latinSuperfamily = latinSuperfamily;
		this.family = family;
		this.latinFamily = latinFamily;
		this.subfamily = subfamily;
		this.latinSubfamily = latinSubfamily;
		this.superoder = superoder;
		this.latinSuperoder = latinSuperoder;
		this.order1 = order1;
		this.latinOrder = latinOrder;
		this.suborder = suborder;
		this.latinSuborder = latinSuborder;
		this.superclass = superclass;
		this.latinSuperclass = latinSuperclass;
		this.class1 = class1;
		this.latinClass = latinClass;
		this.subclass = subclass;
		this.latinSubclass = latinSubclass;
		this.phylum = phylum;
		this.latinPhylum = latinPhylum;
		this.subphylum = subphylum;
		this.latinSubphylum = latinSubphylum;
		this.lifehabit = lifehabit;
		this.statusResource = statusResource;
		this.distribution = distribution;
		this.picture = picture;
		this.remark = remark;
		this.dataProvider = dataProvider;
		this.updateTime = updateTime;
		this.endemismYangtze = endemismYangtze;
		this.earlyBiologs = earlyBiologs;
		this.catchFishObjs = catchFishObjs;
		this.catchBiologs = catchBiologs;
		this.contamiFishs = contamiFishs;
		this.genMolecuMakers = genMolecuMakers;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSpecies() {
		return this.species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getCommname() {
		return this.commname;
	}

	public void setCommname(String commname) {
		this.commname = commname;
	}

	public String getLatinSpecies() {
		return this.latinSpecies;
	}

	public void setLatinSpecies(String latinSpecies) {
		this.latinSpecies = latinSpecies;
	}

	public String getSubspecies() {
		return this.subspecies;
	}

	public void setSubspecies(String subspecies) {
		this.subspecies = subspecies;
	}

	public String getLatinSubspecies() {
		return this.latinSubspecies;
	}

	public void setLatinSubspecies(String latinSubspecies) {
		this.latinSubspecies = latinSubspecies;
	}

	public String getGenus() {
		return this.genus;
	}

	public void setGenus(String genus) {
		this.genus = genus;
	}

	public String getLatinGenus() {
		return this.latinGenus;
	}

	public void setLatinGenus(String latinGenus) {
		this.latinGenus = latinGenus;
	}

	public String getSubgenus() {
		return this.subgenus;
	}

	public void setSubgenus(String subgenus) {
		this.subgenus = subgenus;
	}

	public String getLatinSubgenus() {
		return this.latinSubgenus;
	}

	public void setLatinSubgenus(String latinSubgenus) {
		this.latinSubgenus = latinSubgenus;
	}

	public String getSuperfamily() {
		return this.superfamily;
	}

	public void setSuperfamily(String superfamily) {
		this.superfamily = superfamily;
	}

	public String getLatinSuperfamily() {
		return this.latinSuperfamily;
	}

	public void setLatinSuperfamily(String latinSuperfamily) {
		this.latinSuperfamily = latinSuperfamily;
	}

	public String getFamily() {
		return this.family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String getLatinFamily() {
		return this.latinFamily;
	}

	public void setLatinFamily(String latinFamily) {
		this.latinFamily = latinFamily;
	}

	public String getSubfamily() {
		return this.subfamily;
	}

	public void setSubfamily(String subfamily) {
		this.subfamily = subfamily;
	}

	public String getLatinSubfamily() {
		return this.latinSubfamily;
	}

	public void setLatinSubfamily(String latinSubfamily) {
		this.latinSubfamily = latinSubfamily;
	}

	public String getSuperoder() {
		return this.superoder;
	}

	public void setSuperoder(String superoder) {
		this.superoder = superoder;
	}

	public String getLatinSuperoder() {
		return this.latinSuperoder;
	}

	public void setLatinSuperoder(String latinSuperoder) {
		this.latinSuperoder = latinSuperoder;
	}

	public String getOrder1() {
		return this.order1;
	}

	public void setOrder1(String order1) {
		this.order1 = order1;
	}

	public String getLatinOrder() {
		return this.latinOrder;
	}

	public void setLatinOrder(String latinOrder) {
		this.latinOrder = latinOrder;
	}

	public String getSuborder() {
		return this.suborder;
	}

	public void setSuborder(String suborder) {
		this.suborder = suborder;
	}

	public String getLatinSuborder() {
		return this.latinSuborder;
	}

	public void setLatinSuborder(String latinSuborder) {
		this.latinSuborder = latinSuborder;
	}

	public String getSuperclass() {
		return this.superclass;
	}

	public void setSuperclass(String superclass) {
		this.superclass = superclass;
	}

	public String getLatinSuperclass() {
		return this.latinSuperclass;
	}

	public void setLatinSuperclass(String latinSuperclass) {
		this.latinSuperclass = latinSuperclass;
	}

	public String getClass1() {
		return this.class1;
	}

	public void setClass1(String class1) {
		this.class1 = class1;
	}

	public String getLatinClass() {
		return this.latinClass;
	}

	public void setLatinClass(String latinClass) {
		this.latinClass = latinClass;
	}

	public String getSubclass() {
		return this.subclass;
	}

	public void setSubclass(String subclass) {
		this.subclass = subclass;
	}

	public String getLatinSubclass() {
		return this.latinSubclass;
	}

	public void setLatinSubclass(String latinSubclass) {
		this.latinSubclass = latinSubclass;
	}

	public String getPhylum() {
		return this.phylum;
	}

	public void setPhylum(String phylum) {
		this.phylum = phylum;
	}

	public String getLatinPhylum() {
		return this.latinPhylum;
	}

	public void setLatinPhylum(String latinPhylum) {
		this.latinPhylum = latinPhylum;
	}

	public String getSubphylum() {
		return this.subphylum;
	}

	public void setSubphylum(String subphylum) {
		this.subphylum = subphylum;
	}

	public String getLatinSubphylum() {
		return this.latinSubphylum;
	}

	public void setLatinSubphylum(String latinSubphylum) {
		this.latinSubphylum = latinSubphylum;
	}

	public String getLifehabit() {
		return this.lifehabit;
	}

	public void setLifehabit(String lifehabit) {
		this.lifehabit = lifehabit;
	}

	public String getStatusResource() {
		return this.statusResource;
	}

	public void setStatusResource(String statusResource) {
		this.statusResource = statusResource;
	}

	public String getDistribution() {
		return this.distribution;
	}

	public void setDistribution(String distribution) {
		this.distribution = distribution;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getDataProvider() {
		return this.dataProvider;
	}

	public void setDataProvider(String dataProvider) {
		this.dataProvider = dataProvider;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public String getEndemismYangtze() {
		return this.endemismYangtze;
	}

	public void setEndemismYangtze(String endemismYangtze) {
		this.endemismYangtze = endemismYangtze;
	}

	public Set getEarlyBiologs() {
		return this.earlyBiologs;
	}

	public void setEarlyBiologs(Set earlyBiologs) {
		this.earlyBiologs = earlyBiologs;
	}

	public Set getCatchFishObjs() {
		return this.catchFishObjs;
	}

	public void setCatchFishObjs(Set catchFishObjs) {
		this.catchFishObjs = catchFishObjs;
	}

	public Set getCatchBiologs() {
		return this.catchBiologs;
	}

	public void setCatchBiologs(Set catchBiologs) {
		this.catchBiologs = catchBiologs;
	}

	public Set getContamiFishs() {
		return this.contamiFishs;
	}

	public void setContamiFishs(Set contamiFishs) {
		this.contamiFishs = contamiFishs;
	}

	public Set getGenMolecuMakers() {
		return this.genMolecuMakers;
	}

	public void setGenMolecuMakers(Set genMolecuMakers) {
		this.genMolecuMakers = genMolecuMakers;
	}

}