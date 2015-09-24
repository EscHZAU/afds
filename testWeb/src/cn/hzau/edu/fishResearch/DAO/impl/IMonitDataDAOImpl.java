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


import cn.hzau.edu.fishResearch.DAO.IMonitDataDAO;
import cn.hzau.edu.fishResearch.domain.*;

/**
 * @Name:IMonitSiteDAOImpl
 * @Author:EricLiu
 * @Date:04/22/2014
 * @Version:1.0
 */

@Repository
public class IMonitDataDAOImpl implements IMonitDataDAO
{
	private SessionFactory sFactory = null;
	public void setSessionFactory(SessionFactory sf){
		this.sFactory = sf;
	}
	
    
	@Override
	//Add a new data:
	public boolean InsertMonitdata(BaseMonitSite baseMonitSite) {
		HibernateTemplate ht = new HibernateTemplate(sFactory);
		//ht.save(newMB);
		ht.merge(baseMonitSite);
		return true;	
	}
	@Override
	//Delete a data
	public boolean DeleteMonitdata(BaseMonitSite baseMonitSite) {
		HibernateTemplate ht = new HibernateTemplate(sFactory);
		ht.delete(baseMonitSite);
		return true;	
	}
	@Override
	//Update a data 
	public boolean UpdateMonitdata(BaseMonitSite baseMonitSite) {
		HibernateTemplate ht = new HibernateTemplate(sFactory);
		ht.update(baseMonitSite);
		return true;
	}
	
	public List<BaseMonitSite> findAll(BaseMonitSite baseMonitSite) {
		HibernateTemplate ht = new HibernateTemplate(sFactory);
		return ht.loadAll(BaseMonitSite.class);
			
	}
	
	@Override
	//Query monitData by id
	  public BaseMonitSite FindMonitDataByid(final int id)
		{
	      BaseMonitSite baseMonitSite;
	      HibernateTemplate ht = new HibernateTemplate(sFactory);
	      
	      HibernateCallback hcb = new HibernateCallback()
	      {
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException 
				{
				// TODO Auto-generated method stub
				//BaseMonitSite baseMonitSite;
				Query q = session.createQuery("Select o from BaseMonitSite o where o.id=:id");
				q.setInteger("id", id);
				List<BaseMonitSite> list = q.list();
				Iterator its = list.iterator();
				
				BaseMonitSite baseMonitSite = (BaseMonitSite)its.next();
				return baseMonitSite;
				
			    }
		    };
		    baseMonitSite = ht.execute(hcb);
		    return baseMonitSite;	   
	   }
	
	@Override
	//Query monitData by name 
    public BaseMonitSite FindMonitDataByName(final String name)
	{
      
      HibernateTemplate ht = new HibernateTemplate(sFactory);
      
      HibernateCallback hcb = new HibernateCallback()
      {
		@Override
		public Object doInHibernate(Session session) throws HibernateException,
				SQLException 
			{
			// TODO Auto-generated method stub
			Query q = session.createQuery("Select o from BaseMonitSite o where o.name=:name");
			q.setString("name", name);
			List<BaseMonitSite> list = q.list();
			
			Iterator its = list.iterator();
			
			BaseMonitSite baseMonitSite = (BaseMonitSite)its.next();
			return baseMonitSite;
		    }
	    };
	    BaseMonitSite baseMonitSite = ht.execute(hcb);
	    return baseMonitSite;	   
   }
  
	
}

