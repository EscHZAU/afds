package cn.hzau.edu.fishResearch.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hzau.edu.fishResearch.DAO.ICatchFishDAO;
import cn.hzau.edu.fishResearch.domain.CatchFishObj;

@Service
public class fishCatchService {
	
	@Autowired
	ICatchFishDAO catchFishDAO;
	public List<CatchFishObj> findAll() {
		CatchFishObj fishObj = new CatchFishObj();
		List<CatchFishObj> catchFishObjs = catchFishDAO.findAll(fishObj);
		return catchFishObjs;
	}

}
