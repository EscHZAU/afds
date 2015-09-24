package cn.hzau.edu.fishResearch.DAO.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Blob;
import java.util.List;

import javax.xml.transform.OutputKeys;

import org.apache.commons.logging.Log;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.google.common.base.FinalizablePhantomReference;

import cn.hzau.edu.fishResearch.DAO.IMonitHydroDAO;
import cn.hzau.edu.fishResearch.domain.BaseBen;
import cn.hzau.edu.fishResearch.domain.BaseZooplan;
import cn.hzau.edu.fishResearch.domain.MonitBen;
import cn.hzau.edu.fishResearch.domain.MonitPhy;
import cn.hzau.edu.fishResearch.domain.MonitZooplan;

/**
 * 
 * @author Eric
 * 
 * @param <typeMonitClass>
 * @param <PK>
 * 
 * @description:2014/07/14:DAO接口实现类，未能体现泛型的优势，方法有待抽象。
 * 解决方案参考：GenericsUtils类
 */

public class IMonitHydroDAOImpl<typeMonitClass,typeForInput,PK extends Serializable> implements IMonitHydroDAO<typeMonitClass,typeForInput,PK> {

	private Class<typeMonitClass> persistentBenClass;
	private Class<typeMonitClass> persistentPhyClass;
	private Class<typeMonitClass> persistentZooClass;
	private SessionFactory sFactory = null;
	public void setSessionFactory(SessionFactory sf){
		this.sFactory = sf;
	}
	public IMonitHydroDAOImpl(final Class<typeMonitClass> persistentBenClass,final Class<typeMonitClass> persistentPhyClass,final Class<typeMonitClass> persistentZooClass)
	{
		// TODO Auto-generated constructor stub
		this.persistentBenClass = persistentBenClass;
		this.persistentPhyClass = persistentPhyClass;
		this.persistentZooClass = persistentZooClass;
	}
	
	// get all data-show on queryMonitData
	public List<typeMonitClass> getAllBen()
	{
		 HibernateTemplate ht = new HibernateTemplate(sFactory);
		 List<typeMonitClass> getAllList = ht.loadAll(this.persistentBenClass);
		 return getAllList;
	}
	
	public List<typeMonitClass> getAllPhy()
	{
		 HibernateTemplate ht = new HibernateTemplate(sFactory);
		 List<typeMonitClass> getAllList = ht.loadAll(this.persistentPhyClass);
		 return getAllList;
	}
	
	public List<typeMonitClass> getAllZoo()
	{
		 HibernateTemplate ht = new HibernateTemplate(sFactory);
		 List<typeMonitClass> getAllList = ht.loadAll(this.persistentZooClass);
		 return getAllList;
	}
	
	//get one element by id 
	public typeMonitClass getBen(PK id)
	{
		HibernateTemplate ht = new HibernateTemplate(sFactory);
		typeMonitClass entity = (typeMonitClass)ht.get(this.persistentBenClass,id);
		
		return entity;
	}
	
	public boolean existsBen(PK id)
	{
		HibernateTemplate ht = new HibernateTemplate(sFactory);
		typeMonitClass entity = ht.get(this.persistentBenClass, id);
		return entity != null;
	}
	
	public typeMonitClass save(typeMonitClass object) 
	{
		HibernateTemplate ht = new HibernateTemplate(sFactory);
		return ht.merge(object);
	}
	
	public void remove(PK id) 
	{
		HibernateTemplate ht = new HibernateTemplate(sFactory);
		ht.delete(this.getBen(id));
		
	}
	
	public List<typeMonitClass> findBenByNamedQuery(final String queryName) 
	{

	      HibernateTemplate ht = new HibernateTemplate(sFactory);
	      List<typeMonitClass> listMonitData = ht.findByNamedParam("Select o from MonitBen o where o.benName=:BenName", "BenName", queryName);
	      return listMonitData;
	   }
	
	public List<typeMonitClass> findBenBySiteNameQuery(final String queryName) 
	{
		 
	      HibernateTemplate ht = new HibernateTemplate(sFactory);
	     /* List<typeMonitClass> listMonitData = ht.findByNamedParam("Select o from MonitBen o where o.monitSiteName=:monitSiteName", "monitSiteName", queryName);*/
	      List<typeMonitClass> listMonitData = ht.find("Select o from MonitBen o where o.monitSiteName like ?", "%"+queryName+"%");
	      return listMonitData;
	}
	
	public List<typeMonitClass> groupBySiteNameQuery(final String queryName) 
	{
		 
	      HibernateTemplate ht = new HibernateTemplate(sFactory);
	      List<typeMonitClass> listMonitData = ht.findByNamedParam("Select o from MonitBen o where o.monitSiteName=:monitSiteName AND o.quantity > 0", "monitSiteName", queryName);
	      return listMonitData;
	}
	
	/*public List<typeMonitClass> findDataByParam(final String hQLState,final typeForInput hQLValue)
	{
		HibernateTemplate ht = new HibernateTemplate(sFactory);
		List<typeMonitClass> listMonitData = ht.findByNamedParam(hQLState,"value",hQLValue);
		return listMonitData;
		
	}*/
	public List<typeMonitClass> findDataByParam(final String hQLState,final typeForInput hQLValue)
	{
		HibernateTemplate ht = new HibernateTemplate(sFactory);
		List<typeMonitClass> listMonitData = ht.findByNamedParam(hQLState,"value",hQLValue);	
		
		return listMonitData;
		
	}
	
	public List<typeMonitClass> findDataByParam(final String hQLState)
	{
		HibernateTemplate ht = new HibernateTemplate(sFactory);
		List<typeMonitClass> listMonitData = ht.find(hQLState);
		
		return listMonitData;
		
	}
	
	public boolean saveImgToDB(final String imgURL,BaseZooplan bioZooplan) {
		Blob picture = null;
		FileInputStream inputStream = null;
		
		File file = new File(imgURL);
		byte[] bFile = new byte[(int)file.length()];
		//输入流
			try {
				inputStream = new FileInputStream(file);
				inputStream.read(bFile);
				picture = Hibernate.createBlob(inputStream);
				bioZooplan.setPicture(picture);
			} 
			catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			} 	catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		
		
		HibernateTemplate ht = new HibernateTemplate(sFactory);
		ht.update(bioZooplan);
		
		return true;
		
		
	}
		
}
