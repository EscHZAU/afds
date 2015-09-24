package cn.hzau.edu.fishResearch.DAO.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.hzau.edu.fishResearch.DAO.IUserAccountDAO;

import cn.hzau.edu.fishResearch.domain.SyUserInfo;


public class IUserAccountDAOImpl<SyUserInfo> implements IUserAccountDAO<SyUserInfo>{
	
	
	private List<SyUserInfo> userInfoList = null;
	
	private SessionFactory sFactory = null;
	public void setSessionFactory(SessionFactory sf){
		this.sFactory = sf;
	}
	
	public IUserAccountDAOImpl(final SyUserInfo userInfo)
	{
		// TODO Auto-generated constructor stub
		
	}
	
	@Override
	public List<SyUserInfo> readByAccount(String userName,String password){
		String hqlString = "from SyUserInfo u where u.userName=? and u.passWord=?";
		
		HibernateTemplate ht = new HibernateTemplate(sFactory);
		userInfoList = ht.find(hqlString, new String[]{userName,password});
		
		return userInfoList;
	}
	
	
	/*@Override
	public SyUserInfo readById(int id) {
		SyUserInfo userInfo = new SyUserInfo();
		userInfo.setId(1);
		userInfo.setUserName("hello");
		userInfo.setPassWord("world");
		
		return userInfo;
	}*/

}
