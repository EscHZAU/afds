package cn.hzau.edu.fishResearch.DAO.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.hzau.edu.fishResearch.DAO.IBioInfoDAO;
import cn.hzau.edu.fishResearch.domain.BaseBen;
import cn.hzau.edu.fishResearch.domain.BaseMonitSite;
import cn.hzau.edu.fishResearch.domain.CatchFishObj;

@Repository
public class IBioInfoDAOImpl<T,PK extends Serializable> implements IBioInfoDAO<T, Serializable>{
	
	/*private Class<T> persistentBenClass;
	private Class<T> persistentFishClass;
	private Class<T> persistentPhyClass;
	private Class<T> persistentZooplanClass;*/
	
	private SessionFactory sFactory = null;
	public void setSessionFactory(SessionFactory sf){
		this.sFactory = sf;
	}
	
	public IBioInfoDAOImpl(final Class<T> persistentBenClass,final Class<T> persistentFishClass,
			final Class<T> persistenPhyClass,final Class<T> persistenZoolanClass
			) {
		// TODO Auto-generated constructor stub
		/*this.persistentBenClass = persistentBenClass;
		this.persistentFishClass = persistentFishClass;
		this.persistentPhyClass = persistenPhyClass;
		this.persistentZooplanClass = persistenZoolanClass;
*/
	}
	//从species名称获取生物信息
	@Override
	public T findBioInfoBySpeciesStr(final String queryName,final String tableStr)
	{
		T bioBen;
		String tableType = new String();
		System.out.println(tableStr);
		
		HibernateTemplate ht = new HibernateTemplate(sFactory);
		
		//构造SQL查询语句
		String hqlStatement = "Select o from "+tableStr+" o where o.species=:name";
		
		/*	生物查询V1.0
		 * 对底栖生物的单独查询
		 * String hqlStatementOld = "Select o from "+persistentBenClass.getName()+" o where o.family=:name";
		List<T> benBioList = ht.findByNamedParam(
			"Select o from "+persistentBenClass.getName()+" o where o.family=:name","name", queryName);*/
		
		System.out.println(hqlStatement);

		List<T> benBioList = ht.findByNamedParam(
				hqlStatement,"name",queryName);
		
		
		if (!benBioList.isEmpty()) {
			bioBen = benBioList.get(0);
		}
		else{
			bioBen = null;
		}
		
		return bioBen;
	}
	
	//从family名称查询生物信息
	@Override
	public T findBioInfoByFamilyStr(final String queryName,final String tableStr)
	{
		T bioBen;
		String tableType = new String();
		System.out.println(tableStr);
		
		HibernateTemplate ht = new HibernateTemplate(sFactory);
		//获取参数，即待读取的生物类型
		if (tableStr.equalsIgnoreCase("MonitBen") || tableStr.equalsIgnoreCase("MonitPhy")) {
			 tableType = "Base"+tableStr.substring(tableStr.length()-3);
		}
		else if (tableStr.equalsIgnoreCase("CatchFishObj")) {
			 tableType = "Base"+tableStr.substring(5,9);
		}
		else if(tableStr.equalsIgnoreCase("MonitZooplan")){
			 tableType = "Base"+tableStr.substring(tableStr.length()-7);
		}
		
		//构造SQL查询语句
		String hqlStatement = "Select o from "+tableType+" o where o.family=:name";
		
		/*	生物查询V1.0
		 * 对底栖生物的单独查询
		 * String hqlStatementOld = "Select o from "+persistentBenClass.getName()+" o where o.family=:name";
		List<T> benBioList = ht.findByNamedParam(
			"Select o from "+persistentBenClass.getName()+" o where o.family=:name","name", queryName);*/
		
		System.out.println(hqlStatement);

		List<T> benBioList = ht.findByNamedParam(
				hqlStatement,"name",queryName);
		
		
		if (!benBioList.isEmpty()) {
			bioBen = benBioList.get(0);
		}
		else{
			bioBen = null;
		}
		
		return bioBen;
	}
	
	@Override
	public List<T> getBenBio() {
		
		HibernateTemplate ht = new HibernateTemplate(sFactory);
		
		//构造HQL查询语句
		String hqlStatement = "from BaseBen";
		//测试HQL语句构造是否成功
		System.out.println(hqlStatement);
		
		//利用HQL语法完成查询
		List<T> benBioList = ht.find(hqlStatement);
		
		return benBioList;
	}
	
	@Override
	public List<T> getPhyBio() {
		
		HibernateTemplate ht = new HibernateTemplate(sFactory);
		
		//构造HQL查询语句
		String hqlStatement = "from BasePhy";
		//测试HQL语句构造是否成功
		System.out.println(hqlStatement);
		
		//利用HQL语法完成查询
		List<T> phyBioList = ht.find(hqlStatement);
		
		return phyBioList;
	}
	
	@Override
	public List<T> getZooBio() {
		
		HibernateTemplate ht = new HibernateTemplate(sFactory);
		
		//构造HQL查询语句
		String hqlStatement = "from BaseZooplan";
		//测试HQL语句构造是否成功
		System.out.println(hqlStatement);
		
		//利用HQL语法完成查询
		List<T> zooBioList = ht.find(hqlStatement);
		
		return zooBioList;
	}
	
	@Override
	public List<T> getFishBio() {
		
		HibernateTemplate ht = new HibernateTemplate(sFactory);
		
		//构造HQL查询语句
		String hqlStatement = "from BaseFish";
		//测试HQL语句构造是否成功
		System.out.println(hqlStatement);
		
		//利用HQL语法完成查询
		List<T> fishBioList = ht.find(hqlStatement);
		
		return fishBioList;
	}

	
	

}
