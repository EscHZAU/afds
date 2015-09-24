package cn.hzau.edu.fishResearch.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Service;

import cn.hzau.edu.fishResearch.DAO.*;
import cn.hzau.edu.fishResearch.DAO.impl.*;
import cn.hzau.edu.fishResearch.domain.*;

@Service
public class MonitDataService {
	@Autowired
	private IMonitDataDAOImpl MD;
	

	
	public BaseMonitSite getMonitSiteById(int id) {
		/*ApplicationContext ctx = new FileSystemXmlApplicationContext("src/applicationContext-Common.xml");
		IMonitDataDAO MD=(IMonitDataDAOImpl) ctx.getBean("MonitDataDAOImpl");*/
		BaseMonitSite baseMonitSite = MD.FindMonitDataByid(id);
		return baseMonitSite;
		
	}
	public BaseMonitSite getMonitSiteByName(String name){
		BaseMonitSite baseMonitSite = MD.FindMonitDataByName(name);
		return baseMonitSite;
	}
	
	public List<BaseMonitSite> findAll() {
		BaseMonitSite baseMonitSite = new BaseMonitSite();
		List<BaseMonitSite> findAll = MD.findAll(baseMonitSite);
		return findAll;
	}

}
