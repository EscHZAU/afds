package cn.hzau.edu.fishResearch.DAO.impl;

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

import cn.hzau.edu.fishResearch.DAO.ICatchFishDAO;
import cn.hzau.edu.fishResearch.domain.BaseMonitSite;
import cn.hzau.edu.fishResearch.domain.CatchFishObj;


@Repository
public class ICatchFishDAOImpl implements ICatchFishDAO
{
	
	private SessionFactory sFactory = null;
	public void setSessionFactory(SessionFactory sf){
		this.sFactory = sf;
	}
	
	@Override
	public boolean InsertFishdata(CatchFishObj fishObj){
		HibernateTemplate ht = new HibernateTemplate(sFactory);
		//ht.save(newMB);
		ht.merge(fishObj);
		return true;	
	}
	
	@Override
	public boolean UpdateFishdata(CatchFishObj fishObj){
		HibernateTemplate ht = new HibernateTemplate(sFactory);
		ht.update(fishObj);
		return true;
	}
	
	@Override
	public boolean DeleteFishdata(CatchFishObj fishObj){
		HibernateTemplate ht = new HibernateTemplate(sFactory);
		ht.delete(fishObj);
		return true;	
	}
	
	@Override
	public List<CatchFishObj> findAll(CatchFishObj fishObj){
		HibernateTemplate ht = new HibernateTemplate(sFactory);
		return ht.loadAll(CatchFishObj.class);
	}
	
	
	@Override
	public CatchFishObj FindFishObjByName(final String name){
		 HibernateTemplate ht = new HibernateTemplate(sFactory);
	      
	      HibernateCallback hcb = new HibernateCallback()
	      {
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException 
				{
				// TODO Auto-generated method stub
				Query q = session.createQuery("Select o from CatchFishObj o where o.fishName=:name");
				q.setString("name", name);
				List<CatchFishObj> list = q.list();
				
				Iterator its = list.iterator();
				
				CatchFishObj fishObj = (CatchFishObj)its.next();
				return fishObj;
			    }
		    };
		    CatchFishObj fishObj = ht.execute(hcb);
		    return fishObj;	   
		
		}
	
	@Override
	public CatchFishObj FindFishObjByid(final int id){
		CatchFishObj fishObj;
	      HibernateTemplate ht = new HibernateTemplate(sFactory);
	      
	      HibernateCallback hcb = new HibernateCallback()
	      {
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException 
				{
				// TODO Auto-generated method stub
				
				Query q = session.createQuery("Select o from CatchFishObj o where o.id=:id");
				q.setInteger("id", id);
				List<CatchFishObj> list = q.list();
				Iterator its = list.iterator();
				
				CatchFishObj fishObj = (CatchFishObj)its.next();
				return fishObj;
				
			    }
		    };
		    fishObj = ht.execute(hcb);
		    return fishObj;	   
	}

}
