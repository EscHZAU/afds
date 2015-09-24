package cn.hzau.edu.fishResearch.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.hzau.edu.fishResearch.domain.BaseMonitSite;
import cn.hzau.edu.fishResearch.domain.CatchFishObj;

/**
 * CatchFish DAO(Data Access Object) with commons methods to CRUD POJOs.
 * 
 * @author Eric
 *
 */

@Repository
public interface ICatchFishDAO {
	public boolean InsertFishdata(CatchFishObj fishObj);
	public boolean UpdateFishdata(CatchFishObj fishObj);
	public boolean DeleteFishdata(CatchFishObj fishObj);
	public List<CatchFishObj> findAll(CatchFishObj fishObj);  
	public CatchFishObj FindFishObjByName(final String name);
	public CatchFishObj FindFishObjByid(final int id); 
}
