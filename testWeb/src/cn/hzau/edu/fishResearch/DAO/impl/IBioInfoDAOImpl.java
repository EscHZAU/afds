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
	//��species���ƻ�ȡ������Ϣ
	@Override
	public T findBioInfoBySpeciesStr(final String queryName,final String tableStr)
	{
		T bioBen;
		String tableType = new String();
		System.out.println(tableStr);
		
		HibernateTemplate ht = new HibernateTemplate(sFactory);
		
		//����SQL��ѯ���
		String hqlStatement = "Select o from "+tableStr+" o where o.species=:name";
		
		/*	�����ѯV1.0
		 * �Ե�������ĵ�����ѯ
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
	
	//��family���Ʋ�ѯ������Ϣ
	@Override
	public T findBioInfoByFamilyStr(final String queryName,final String tableStr)
	{
		T bioBen;
		String tableType = new String();
		System.out.println(tableStr);
		
		HibernateTemplate ht = new HibernateTemplate(sFactory);
		//��ȡ������������ȡ����������
		if (tableStr.equalsIgnoreCase("MonitBen") || tableStr.equalsIgnoreCase("MonitPhy")) {
			 tableType = "Base"+tableStr.substring(tableStr.length()-3);
		}
		else if (tableStr.equalsIgnoreCase("CatchFishObj")) {
			 tableType = "Base"+tableStr.substring(5,9);
		}
		else if(tableStr.equalsIgnoreCase("MonitZooplan")){
			 tableType = "Base"+tableStr.substring(tableStr.length()-7);
		}
		
		//����SQL��ѯ���
		String hqlStatement = "Select o from "+tableType+" o where o.family=:name";
		
		/*	�����ѯV1.0
		 * �Ե�������ĵ�����ѯ
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
		
		//����HQL��ѯ���
		String hqlStatement = "from BaseBen";
		//����HQL��乹���Ƿ�ɹ�
		System.out.println(hqlStatement);
		
		//����HQL�﷨��ɲ�ѯ
		List<T> benBioList = ht.find(hqlStatement);
		
		return benBioList;
	}
	
	@Override
	public List<T> getPhyBio() {
		
		HibernateTemplate ht = new HibernateTemplate(sFactory);
		
		//����HQL��ѯ���
		String hqlStatement = "from BasePhy";
		//����HQL��乹���Ƿ�ɹ�
		System.out.println(hqlStatement);
		
		//����HQL�﷨��ɲ�ѯ
		List<T> phyBioList = ht.find(hqlStatement);
		
		return phyBioList;
	}
	
	@Override
	public List<T> getZooBio() {
		
		HibernateTemplate ht = new HibernateTemplate(sFactory);
		
		//����HQL��ѯ���
		String hqlStatement = "from BaseZooplan";
		//����HQL��乹���Ƿ�ɹ�
		System.out.println(hqlStatement);
		
		//����HQL�﷨��ɲ�ѯ
		List<T> zooBioList = ht.find(hqlStatement);
		
		return zooBioList;
	}
	
	@Override
	public List<T> getFishBio() {
		
		HibernateTemplate ht = new HibernateTemplate(sFactory);
		
		//����HQL��ѯ���
		String hqlStatement = "from BaseFish";
		//����HQL��乹���Ƿ�ɹ�
		System.out.println(hqlStatement);
		
		//����HQL�﷨��ɲ�ѯ
		List<T> fishBioList = ht.find(hqlStatement);
		
		return fishBioList;
	}

	
	

}
