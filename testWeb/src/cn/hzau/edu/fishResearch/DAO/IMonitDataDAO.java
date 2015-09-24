package cn.hzau.edu.fishResearch.DAO;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.google.common.base.FinalizablePhantomReference;

import cn.hzau.edu.fishResearch.domain.*;

/**
 * MonitData DAO(Data Access Object) with commons methods to CRUD POJOs.
 * 
 * @author EricLiu
 *
 */

@Repository
public interface IMonitDataDAO{

	public boolean InsertMonitdata(BaseMonitSite baseMonitSite);
	public boolean UpdateMonitdata(BaseMonitSite baseMonitSite);
	public boolean DeleteMonitdata(BaseMonitSite baseMonitSite);
	public List<BaseMonitSite> findAll(BaseMonitSite baseMonitSite);  
	public BaseMonitSite FindMonitDataByName(final String name);
	public BaseMonitSite FindMonitDataByid(final int id);
}

