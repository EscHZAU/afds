package cn.hzau.edu.fishResearch.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.alibaba.fastjson.JSON;

import cn.hzau.edu.fishResearch.DAO.impl.IBioInfoDAOImpl;
import cn.hzau.edu.fishResearch.DAO.impl.IMonitHydroDAOImpl;
import cn.hzau.edu.fishResearch.domain.CatchFishObj;
import cn.hzau.edu.fishResearch.domain.MonitBen;
import cn.hzau.edu.fishResearch.domain.MonitPhy;
import cn.hzau.edu.fishResearch.domain.MonitZooplan;

/**
 * For querying Monit_data
 * 
 * @author Eric
 *
 */
@Controller
@RequestMapping(value = "/queryMonitData")
public class dataQueryController{
	
	/**
	 * Get Monit_Data from some monit_Site
	 * 
	 * @param model
	 * @return queryMonitData.jsp
	 */
	@Autowired
	IMonitHydroDAOImpl<MonitBen, String, Integer> queryBenBySiteName;
	
	/**
	 * test for monitSiteQuery
	 */
	@RequestMapping(value = "/query/{monitSiteName}",method = RequestMethod.GET)
	public @ResponseBody String getMonitDataByMonitSite(@PathVariable String monitSiteName,
			Model model,HttpServletRequest request,HttpServletResponse response
			) {
		
		String jsonMonitData = "";
		String paramSiteName = "";
		
		try {
			paramSiteName = URLDecoder.decode(monitSiteName, "utf-8");
			//hQLBioName = URLDecoder.decode(bioStr, "utf-8");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		jsonMonitData = JSON.toJSONString(queryBenBySiteName.findBenBySiteNameQuery(paramSiteName));
		
		
		
		String jsonQueryDataEncode = "";
		
		try {
			jsonQueryDataEncode = URLEncoder.encode(jsonMonitData,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonQueryDataEncode;
		
	}
	//end of testing
	
	
	/**
	 * 初始化选中Tab页中表格的数据内容(以Ben为例)
	 * @param monitSiteName
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/index/{tableName}",method = RequestMethod.GET)
	public @ResponseBody String initTableSelected(@PathVariable String tableName,
			Model model,HttpServletRequest request,HttpServletResponse response
			) {
		
		String jsonMonitData = "";
		String paramTabName = "";
		
		/**
		 *List<MonitBen> benList = monitBenStr.getAllBen();
		 *<MonitPhy> phyList = monitPhyStr.getAllPhy();
		 *List<MonitZooplan> zooplanList = monitZooplanStr.getAllZoo();
		 *List<CatchFishObj> fishCatchList = fishCatchService.findAll();
		 */
		
		try {
			paramTabName = URLDecoder.decode(tableName, "utf-8");
			//hQLBioName = URLDecoder.decode(bioStr, "utf-8");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		//未实现普遍性，仅以底栖生物初始化数据为例
		jsonMonitData = JSON.toJSONString(queryBenBySiteName.getAllBen());
		
		
		
		String jsonQueryDataEncode = "";
		
		try {
			jsonQueryDataEncode = URLEncoder.encode(jsonMonitData,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonQueryDataEncode;
		
	}
	
	
	
	
}