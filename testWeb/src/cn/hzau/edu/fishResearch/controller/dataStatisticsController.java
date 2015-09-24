package cn.hzau.edu.fishResearch.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import cn.hzau.edu.fishResearch.DAO.impl.IMonitHydroDAOImpl;
import cn.hzau.edu.fishResearch.domain.BaseMonitSite;
import cn.hzau.edu.fishResearch.domain.CatchFishObj;
import cn.hzau.edu.fishResearch.domain.MonitBen;
import cn.hzau.edu.fishResearch.domain.MonitPhy;
import cn.hzau.edu.fishResearch.domain.MonitZooplan;
import cn.hzau.edu.fishResearch.services.MonitDataService;

/**
 * For querying Monit_data
 * 
 * @author Eric
 *
 */


@Controller
@RequestMapping(value = "/statisticsChart")
public class dataStatisticsController{
	
	/**
	 * Get Monit_Data from some monit_Site
	 * 
	 * @param model
	 * @return queryMonitData.jsp
	 */
	@Autowired
	IMonitHydroDAOImpl<MonitBen, String, Integer> queryBen;
	@Autowired
	private MonitDataService monitDataService;
	
	
	/**
	 * Get all Monit_Data(monitSite/monitAquatic/monitBio)
	 * 
	 * @param model
	 * @return queryMonitData.jsp
	 */
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String getListAll(Model model){
		List<BaseMonitSite> findAll = monitDataService.findAll();
		
		model.addAttribute("allMonitSite",findAll);
	
			
		return "jsp/statisticsChart";
		
	}
	
	
	/**
	 * 单监测点生物组分 饼状图
	 */
	@RequestMapping(value = "/pieChart/{monitSiteName}",method = RequestMethod.GET)
	public @ResponseBody String getPieChartData(@PathVariable String monitSiteName,
			Model model,HttpServletRequest request,HttpServletResponse response
			) {
		
		String jsonMonitData = "";
		String paramSiteName = "";
		
		try {
			paramSiteName = URLDecoder.decode(monitSiteName, "utf-8");
			System.out.println(paramSiteName);
			//hQLBioName = URLDecoder.decode(bioStr, "utf-8");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		jsonMonitData = JSON.toJSONString(queryBen.groupBySiteNameQuery(paramSiteName));
		
		
		
		String jsonQueryDataEncode = "";
		
		try {
			jsonQueryDataEncode = URLEncoder.encode(jsonMonitData,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonQueryDataEncode;
		
	}
	//end of pieChart
	
	/**
	 * 多监测点数据对比
	 */
	/*@RequestMapping(value = "/stackedAreasChart/{monitSiteNameA}/{monitSiteNameB}",method = RequestMethod.GET)
	public  HashMap<String,List> getSAChartData(@PathVariable String monitSiteNameA,
			@PathVariable String monitSiteNameB,Model model,
			HttpServletRequest request,HttpServletResponse response
			) {*/
	@RequestMapping(value = "/stackedAreasChart/{monitSiteNameA}/{monitSiteNameB}",method = RequestMethod.GET)
	public @ResponseBody String getSAChartData(@PathVariable String monitSiteNameA,
			@PathVariable String monitSiteNameB,Model model,
			HttpServletRequest request,HttpServletResponse response) {
		
			String paramSiteName1 = "";
			String paramSiteName2 = "";
			try {
				String monitSiteName1 =monitSiteNameA;
				String monitSiteName2 = monitSiteNameB;
			
				paramSiteName1 = URLDecoder.decode(monitSiteName1, "utf-8");
				paramSiteName2 = URLDecoder.decode(monitSiteName2, "utf-8");
				//hQLBioName = URLDecoder.decode(bioStr, "utf-8");
				System.out.println(paramSiteName1+","+paramSiteName2);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		JSONObject jsonChartData = new JSONObject();
		
		jsonChartData.put("seriesA", queryBen.groupBySiteNameQuery(paramSiteName1));
		jsonChartData.put("seriesB", queryBen.groupBySiteNameQuery(paramSiteName2));
		
		String jsonChartDataToString = JSON.toJSONString(jsonChartData);
		
		/*HashMap<String,List> hashMap = new HashMap<String,List>();
		
		hashMap.put("seriesA", queryBenBySiteName.groupBySiteNameQuery(paramSiteName1));
		hashMap.put("seriesB", queryBenBySiteName.groupBySiteNameQuery(paramSiteName2));*/
		
		System.out.println(jsonChartDataToString);
		String jsonQueryDataEncode = "";
		
		try {
			jsonQueryDataEncode = URLEncoder.encode(jsonChartDataToString,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonQueryDataEncode;
	}
	
	/*
	 * 单监测点不同时间点的生物量/数量变化<折线图>
	 */
	@RequestMapping(value = "/lineChart/{bioName}",method = RequestMethod.GET)
	public @ResponseBody String getLineChartData(@PathVariable String bioName,
				 Model model,HttpServletRequest request,HttpServletResponse response){
		//First,accept the param(monitSiteName) from the page
		String bioName_String = "";;
		String JSON_String = "";
		
		try {
			bioName_String = URLDecoder.decode(bioName,"utf-8");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		//Second,execute the method in DAO implement-class with param
		//After that,get the return data and put the return data into JSONString
		JSON_String = JSON.toJSONString(queryBen.findBenByNamedQuery(bioName_String));
		//Then encode the JSONString to avoid messy code
		String jsonQueryDataEncode = "";
		
		try {
			jsonQueryDataEncode = URLEncoder.encode(JSON_String, "utf-8");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		//finally,post the JSONString to the URI
		return jsonQueryDataEncode;
		
	}
		
}