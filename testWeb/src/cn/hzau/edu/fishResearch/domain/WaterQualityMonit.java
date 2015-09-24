package cn.hzau.edu.fishResearch.domain;

import java.sql.Timestamp;

/**
 * WaterQualityMonit entity. @author MyEclipse Persistence Tools
 */

public class WaterQualityMonit implements java.io.Serializable {

	// Fields

	private Integer id;
	private String monitPerson;
	private String monitSiteName;
	private Double eastLo;
	private Double northLa;
	private String locat;
	private Double waterDep;
	private Timestamp monitDate;
	private Timestamp monitTime;
	private Double waterTemper;
	private String waterTemperMethod;
	private Double ph;
	private Double do_;
	private String domethod;
	private Integer suspenSolid;
	private String suspenSolidMethod;
	private Double tn;
	private String tnmethod;
	private Double tp;
	private String tpmethod;
	private Double nh3n;
	private String nh3nmethod;
	private Double no3n;
	private String no3nmethod;
	private Double no2n;
	private String no2nmethod;
	private Double cyanide;
	private String cyanideMethod;
	private Double fluoride;
	private String fluorideMethod;
	private Double sulfide;
	private String sulfideMethod;
	private Double codmn;
	private String codmnMethod;
	private Double cod;
	private String codmethod;
	private Double bod5;
	private String bod5method;
	private Double cu;
	private String cuMethod;
	private Double zn;
	private String znMethod;
	private Double pb;
	private String pbMethod;
	private Double cd;
	private String cdMethod;
	private Double hg;
	private String hgMethod;
	private Double as1;
	private String as1method;
	private Double cr6;
	private String cr6method;
	private Double ca;
	private String caMethod;
	private Double mg;
	private String mgMethod;
	private Double nonionAmmonia;
	private String nonionAmmoniaMethod;
	private Double volatilePhenols;
	private String volatilePhenolsMethod;
	private Double petroleum;
	private String petroleumMethod;
	private Double chla;
	private String chlaMethod;
	private Integer ds;
	private String dsmethod;
	private Double totalHardness;
	private String totalHardnessMethod;
	private String ownerUnit;
	private String ownerId;
	private Timestamp operateTime;
	private Integer dataState;

	// Constructors

	/** default constructor */
	public WaterQualityMonit() {
	}

	/** minimal constructor */
	public WaterQualityMonit(String monitPerson, String monitSiteName,
			Timestamp monitDate, Timestamp monitTime, String ownerId,
			Timestamp operateTime, Integer dataState) {
		this.monitPerson = monitPerson;
		this.monitSiteName = monitSiteName;
		this.monitDate = monitDate;
		this.monitTime = monitTime;
		this.ownerId = ownerId;
		this.operateTime = operateTime;
		this.dataState = dataState;
	}

	/** full constructor */
	public WaterQualityMonit(String monitPerson, String monitSiteName,
			Double eastLo, Double northLa, String locat, Double waterDep,
			Timestamp monitDate, Timestamp monitTime, Double waterTemper,
			String waterTemperMethod, Double ph, Double do_, String domethod,
			Integer suspenSolid, String suspenSolidMethod, Double tn,
			String tnmethod, Double tp, String tpmethod, Double nh3n,
			String nh3nmethod, Double no3n, String no3nmethod, Double no2n,
			String no2nmethod, Double cyanide, String cyanideMethod,
			Double fluoride, String fluorideMethod, Double sulfide,
			String sulfideMethod, Double codmn, String codmnMethod, Double cod,
			String codmethod, Double bod5, String bod5method, Double cu,
			String cuMethod, Double zn, String znMethod, Double pb,
			String pbMethod, Double cd, String cdMethod, Double hg,
			String hgMethod, Double as1, String as1method, Double cr6,
			String cr6method, Double ca, String caMethod, Double mg,
			String mgMethod, Double nonionAmmonia, String nonionAmmoniaMethod,
			Double volatilePhenols, String volatilePhenolsMethod,
			Double petroleum, String petroleumMethod, Double chla,
			String chlaMethod, Integer ds, String dsmethod,
			Double totalHardness, String totalHardnessMethod, String ownerUnit,
			String ownerId, Timestamp operateTime, Integer dataState) {
		this.monitPerson = monitPerson;
		this.monitSiteName = monitSiteName;
		this.eastLo = eastLo;
		this.northLa = northLa;
		this.locat = locat;
		this.waterDep = waterDep;
		this.monitDate = monitDate;
		this.monitTime = monitTime;
		this.waterTemper = waterTemper;
		this.waterTemperMethod = waterTemperMethod;
		this.ph = ph;
		this.do_ = do_;
		this.domethod = domethod;
		this.suspenSolid = suspenSolid;
		this.suspenSolidMethod = suspenSolidMethod;
		this.tn = tn;
		this.tnmethod = tnmethod;
		this.tp = tp;
		this.tpmethod = tpmethod;
		this.nh3n = nh3n;
		this.nh3nmethod = nh3nmethod;
		this.no3n = no3n;
		this.no3nmethod = no3nmethod;
		this.no2n = no2n;
		this.no2nmethod = no2nmethod;
		this.cyanide = cyanide;
		this.cyanideMethod = cyanideMethod;
		this.fluoride = fluoride;
		this.fluorideMethod = fluorideMethod;
		this.sulfide = sulfide;
		this.sulfideMethod = sulfideMethod;
		this.codmn = codmn;
		this.codmnMethod = codmnMethod;
		this.cod = cod;
		this.codmethod = codmethod;
		this.bod5 = bod5;
		this.bod5method = bod5method;
		this.cu = cu;
		this.cuMethod = cuMethod;
		this.zn = zn;
		this.znMethod = znMethod;
		this.pb = pb;
		this.pbMethod = pbMethod;
		this.cd = cd;
		this.cdMethod = cdMethod;
		this.hg = hg;
		this.hgMethod = hgMethod;
		this.as1 = as1;
		this.as1method = as1method;
		this.cr6 = cr6;
		this.cr6method = cr6method;
		this.ca = ca;
		this.caMethod = caMethod;
		this.mg = mg;
		this.mgMethod = mgMethod;
		this.nonionAmmonia = nonionAmmonia;
		this.nonionAmmoniaMethod = nonionAmmoniaMethod;
		this.volatilePhenols = volatilePhenols;
		this.volatilePhenolsMethod = volatilePhenolsMethod;
		this.petroleum = petroleum;
		this.petroleumMethod = petroleumMethod;
		this.chla = chla;
		this.chlaMethod = chlaMethod;
		this.ds = ds;
		this.dsmethod = dsmethod;
		this.totalHardness = totalHardness;
		this.totalHardnessMethod = totalHardnessMethod;
		this.ownerUnit = ownerUnit;
		this.ownerId = ownerId;
		this.operateTime = operateTime;
		this.dataState = dataState;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getLocat() {
		return this.locat;
	}

	public void setLocat(String locat) {
		this.locat = locat;
	}

	public Double getWaterDep() {
		return this.waterDep;
	}

	public void setWaterDep(Double waterDep) {
		this.waterDep = waterDep;
	}

	public Timestamp getMonitDate() {
		return this.monitDate;
	}

	public void setMonitDate(Timestamp monitDate) {
		this.monitDate = monitDate;
	}

	public Timestamp getMonitTime() {
		return this.monitTime;
	}

	public void setMonitTime(Timestamp monitTime) {
		this.monitTime = monitTime;
	}

	public Double getWaterTemper() {
		return this.waterTemper;
	}

	public void setWaterTemper(Double waterTemper) {
		this.waterTemper = waterTemper;
	}

	public String getWaterTemperMethod() {
		return this.waterTemperMethod;
	}

	public void setWaterTemperMethod(String waterTemperMethod) {
		this.waterTemperMethod = waterTemperMethod;
	}

	public Double getPh() {
		return this.ph;
	}

	public void setPh(Double ph) {
		this.ph = ph;
	}

	public Double getDo_() {
		return this.do_;
	}

	public void setDo_(Double do_) {
		this.do_ = do_;
	}

	public String getDomethod() {
		return this.domethod;
	}

	public void setDomethod(String domethod) {
		this.domethod = domethod;
	}

	public Integer getSuspenSolid() {
		return this.suspenSolid;
	}

	public void setSuspenSolid(Integer suspenSolid) {
		this.suspenSolid = suspenSolid;
	}

	public String getSuspenSolidMethod() {
		return this.suspenSolidMethod;
	}

	public void setSuspenSolidMethod(String suspenSolidMethod) {
		this.suspenSolidMethod = suspenSolidMethod;
	}

	public Double getTn() {
		return this.tn;
	}

	public void setTn(Double tn) {
		this.tn = tn;
	}

	public String getTnmethod() {
		return this.tnmethod;
	}

	public void setTnmethod(String tnmethod) {
		this.tnmethod = tnmethod;
	}

	public Double getTp() {
		return this.tp;
	}

	public void setTp(Double tp) {
		this.tp = tp;
	}

	public String getTpmethod() {
		return this.tpmethod;
	}

	public void setTpmethod(String tpmethod) {
		this.tpmethod = tpmethod;
	}

	public Double getNh3n() {
		return this.nh3n;
	}

	public void setNh3n(Double nh3n) {
		this.nh3n = nh3n;
	}

	public String getNh3nmethod() {
		return this.nh3nmethod;
	}

	public void setNh3nmethod(String nh3nmethod) {
		this.nh3nmethod = nh3nmethod;
	}

	public Double getNo3n() {
		return this.no3n;
	}

	public void setNo3n(Double no3n) {
		this.no3n = no3n;
	}

	public String getNo3nmethod() {
		return this.no3nmethod;
	}

	public void setNo3nmethod(String no3nmethod) {
		this.no3nmethod = no3nmethod;
	}

	public Double getNo2n() {
		return this.no2n;
	}

	public void setNo2n(Double no2n) {
		this.no2n = no2n;
	}

	public String getNo2nmethod() {
		return this.no2nmethod;
	}

	public void setNo2nmethod(String no2nmethod) {
		this.no2nmethod = no2nmethod;
	}

	public Double getCyanide() {
		return this.cyanide;
	}

	public void setCyanide(Double cyanide) {
		this.cyanide = cyanide;
	}

	public String getCyanideMethod() {
		return this.cyanideMethod;
	}

	public void setCyanideMethod(String cyanideMethod) {
		this.cyanideMethod = cyanideMethod;
	}

	public Double getFluoride() {
		return this.fluoride;
	}

	public void setFluoride(Double fluoride) {
		this.fluoride = fluoride;
	}

	public String getFluorideMethod() {
		return this.fluorideMethod;
	}

	public void setFluorideMethod(String fluorideMethod) {
		this.fluorideMethod = fluorideMethod;
	}

	public Double getSulfide() {
		return this.sulfide;
	}

	public void setSulfide(Double sulfide) {
		this.sulfide = sulfide;
	}

	public String getSulfideMethod() {
		return this.sulfideMethod;
	}

	public void setSulfideMethod(String sulfideMethod) {
		this.sulfideMethod = sulfideMethod;
	}

	public Double getCodmn() {
		return this.codmn;
	}

	public void setCodmn(Double codmn) {
		this.codmn = codmn;
	}

	public String getCodmnMethod() {
		return this.codmnMethod;
	}

	public void setCodmnMethod(String codmnMethod) {
		this.codmnMethod = codmnMethod;
	}

	public Double getCod() {
		return this.cod;
	}

	public void setCod(Double cod) {
		this.cod = cod;
	}

	public String getCodmethod() {
		return this.codmethod;
	}

	public void setCodmethod(String codmethod) {
		this.codmethod = codmethod;
	}

	public Double getBod5() {
		return this.bod5;
	}

	public void setBod5(Double bod5) {
		this.bod5 = bod5;
	}

	public String getBod5method() {
		return this.bod5method;
	}

	public void setBod5method(String bod5method) {
		this.bod5method = bod5method;
	}

	public Double getCu() {
		return this.cu;
	}

	public void setCu(Double cu) {
		this.cu = cu;
	}

	public String getCuMethod() {
		return this.cuMethod;
	}

	public void setCuMethod(String cuMethod) {
		this.cuMethod = cuMethod;
	}

	public Double getZn() {
		return this.zn;
	}

	public void setZn(Double zn) {
		this.zn = zn;
	}

	public String getZnMethod() {
		return this.znMethod;
	}

	public void setZnMethod(String znMethod) {
		this.znMethod = znMethod;
	}

	public Double getPb() {
		return this.pb;
	}

	public void setPb(Double pb) {
		this.pb = pb;
	}

	public String getPbMethod() {
		return this.pbMethod;
	}

	public void setPbMethod(String pbMethod) {
		this.pbMethod = pbMethod;
	}

	public Double getCd() {
		return this.cd;
	}

	public void setCd(Double cd) {
		this.cd = cd;
	}

	public String getCdMethod() {
		return this.cdMethod;
	}

	public void setCdMethod(String cdMethod) {
		this.cdMethod = cdMethod;
	}

	public Double getHg() {
		return this.hg;
	}

	public void setHg(Double hg) {
		this.hg = hg;
	}

	public String getHgMethod() {
		return this.hgMethod;
	}

	public void setHgMethod(String hgMethod) {
		this.hgMethod = hgMethod;
	}

	public Double getAs1() {
		return this.as1;
	}

	public void setAs1(Double as1) {
		this.as1 = as1;
	}

	public String getAs1method() {
		return this.as1method;
	}

	public void setAs1method(String as1method) {
		this.as1method = as1method;
	}

	public Double getCr6() {
		return this.cr6;
	}

	public void setCr6(Double cr6) {
		this.cr6 = cr6;
	}

	public String getCr6method() {
		return this.cr6method;
	}

	public void setCr6method(String cr6method) {
		this.cr6method = cr6method;
	}

	public Double getCa() {
		return this.ca;
	}

	public void setCa(Double ca) {
		this.ca = ca;
	}

	public String getCaMethod() {
		return this.caMethod;
	}

	public void setCaMethod(String caMethod) {
		this.caMethod = caMethod;
	}

	public Double getMg() {
		return this.mg;
	}

	public void setMg(Double mg) {
		this.mg = mg;
	}

	public String getMgMethod() {
		return this.mgMethod;
	}

	public void setMgMethod(String mgMethod) {
		this.mgMethod = mgMethod;
	}

	public Double getNonionAmmonia() {
		return this.nonionAmmonia;
	}

	public void setNonionAmmonia(Double nonionAmmonia) {
		this.nonionAmmonia = nonionAmmonia;
	}

	public String getNonionAmmoniaMethod() {
		return this.nonionAmmoniaMethod;
	}

	public void setNonionAmmoniaMethod(String nonionAmmoniaMethod) {
		this.nonionAmmoniaMethod = nonionAmmoniaMethod;
	}

	public Double getVolatilePhenols() {
		return this.volatilePhenols;
	}

	public void setVolatilePhenols(Double volatilePhenols) {
		this.volatilePhenols = volatilePhenols;
	}

	public String getVolatilePhenolsMethod() {
		return this.volatilePhenolsMethod;
	}

	public void setVolatilePhenolsMethod(String volatilePhenolsMethod) {
		this.volatilePhenolsMethod = volatilePhenolsMethod;
	}

	public Double getPetroleum() {
		return this.petroleum;
	}

	public void setPetroleum(Double petroleum) {
		this.petroleum = petroleum;
	}

	public String getPetroleumMethod() {
		return this.petroleumMethod;
	}

	public void setPetroleumMethod(String petroleumMethod) {
		this.petroleumMethod = petroleumMethod;
	}

	public Double getChla() {
		return this.chla;
	}

	public void setChla(Double chla) {
		this.chla = chla;
	}

	public String getChlaMethod() {
		return this.chlaMethod;
	}

	public void setChlaMethod(String chlaMethod) {
		this.chlaMethod = chlaMethod;
	}

	public Integer getDs() {
		return this.ds;
	}

	public void setDs(Integer ds) {
		this.ds = ds;
	}

	public String getDsmethod() {
		return this.dsmethod;
	}

	public void setDsmethod(String dsmethod) {
		this.dsmethod = dsmethod;
	}

	public Double getTotalHardness() {
		return this.totalHardness;
	}

	public void setTotalHardness(Double totalHardness) {
		this.totalHardness = totalHardness;
	}

	public String getTotalHardnessMethod() {
		return this.totalHardnessMethod;
	}

	public void setTotalHardnessMethod(String totalHardnessMethod) {
		this.totalHardnessMethod = totalHardnessMethod;
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

}