package cn.hzau.edu.fishResearch.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.table.TableStringConverter;


import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import cn.hzau.edu.fishResearch.DAO.impl.IBioInfoDAOImpl;
import cn.hzau.edu.fishResearch.DAO.impl.IMonitHydroDAOImpl;
import cn.hzau.edu.fishResearch.domain.BaseBen;
import cn.hzau.edu.fishResearch.domain.BaseMonitSite;
import cn.hzau.edu.fishResearch.domain.BasePhy;
import cn.hzau.edu.fishResearch.domain.CatchFishObj;
import cn.hzau.edu.fishResearch.domain.MonitBen;
import cn.hzau.edu.fishResearch.domain.MonitPhy;
import cn.hzau.edu.fishResearch.domain.MonitZooplan;
import cn.hzau.edu.fishResearch.services.MonitDataService;
import cn.hzau.edu.fishResearch.services.fishCatchService;

/**
 * For testing the enviroment of Spring MVC
 * 
 * @author Eric
 *
 */

@Controller
@RequestMapping(value="/queryMonitData")
public class PersonalController{

	
	@Autowired
	private MonitDataService monitDataService;
	//MonitBen-Query-Services
	@Autowired
	private IMonitHydroDAOImpl<MonitBen,String,Integer> monitBenStr;
	@Autowired
	private IMonitHydroDAOImpl<MonitBen,Integer,Integer> monitBenInt;
	@Autowired
	private IMonitHydroDAOImpl<MonitBen,Double,Integer> monitBenDbl;
	
	//MonitPhy-Query-Services
	@Autowired
	private IMonitHydroDAOImpl<MonitPhy,String,Long> monitPhyStr;
	@Autowired
	private IMonitHydroDAOImpl<MonitPhy,Double,Long> monitPhyDbl;
	
	//MonitZooplan-Query-Services
	@Autowired
	private IMonitHydroDAOImpl<MonitZooplan,String,Long> monitZooplanStr;
	@Autowired
	private IMonitHydroDAOImpl<MonitZooplan,Double,Long> monitZooplanDbl;
	
	@Autowired
	private IBioInfoDAOImpl<BaseBen, Long> bioBenInfoService;
	@Autowired
	private IBioInfoDAOImpl<BasePhy, Long> bioPhyInfoService;
	
	@Autowired
	private fishCatchService fishCatchService;
	
	
	/**
	 * Get all Monit_Data(monitSite/monitAquatic/monitBio)
	 * 
	 * @param model
	 * @return queryMonitData.jsp
	 */
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String getListAll(Model model){
		List<BaseMonitSite> findAll = monitDataService.findAll();
		List<MonitBen> benList = monitBenStr.getAllBen();
		List<MonitPhy> phyList = monitPhyStr.getAllPhy();
		List<MonitZooplan> zooplanList = monitZooplanStr.getAllZoo();
		List<CatchFishObj> fishCatchList = fishCatchService.findAll();
		
		model.addAttribute("allMonitSite",findAll);
		model.addAttribute("benList",benList);
		model.addAttribute("phyList",phyList);
		model.addAttribute("zooplanList", zooplanList);
		model.addAttribute("fishCatchList",fishCatchList);
			
		return "queryMonitData";
		
	}
	
	/**
	 * select the bioInfo data from baseTable
	 * @param valueStr(bioName)
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */ 
	@RequestMapping(value="/query/{tableStr}/{valueStr}",method=RequestMethod.GET)
	public @ResponseBody
	String findBioInfo(@PathVariable String valueStr,@PathVariable String tableStr,
			Model model,HttpServletRequest request
			,HttpServletResponse response)
	{
		String jsonBioInfo = "";
		
		/*0427:BaseBen bioBaseBen = new BaseBen();*/
		
		
		String paramBioName = "";
		String paramTableName = "";
		
		try {
			paramBioName = URLDecoder.decode(valueStr, "utf-8");
			paramTableName = URLDecoder.decode(tableStr, "utf-8");
			//hQLBioName = URLDecoder.decode(bioStr, "utf-8");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		/*0427:bioBaseBen = bioBenInfoService.findBenBioInfoByNamed(hQLValue,hQLValue2);*/
		
		/*0427:String jsonBioBen = JSON.toJSONString(bioBaseBen);*/
		
		String jsonBioBen = JSON.toJSONString(bioBenInfoService.findBioInfoByFamilyStr(paramBioName,paramTableName));
		
		System.out.print(jsonBioBen);
		
		
		jsonBioInfo =  "[" + jsonBioBen +"]";
		
		//为防止前后端编码不一致，在发送前对数据进行UTF-8编码
		String jsonQueryDataEncode = "";
				
		try {
				jsonQueryDataEncode = URLEncoder.encode(jsonBioInfo,"UTF-8");
			} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		return jsonQueryDataEncode;
	}
	
	
	/**
	 * select the monitoring data from benTable
	 * @param stringQuery
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */ 
	@RequestMapping(value="/query/{tableStr}/{fieldStr}/{connStr}/{valueStr}",method=RequestMethod.GET)
	public @ResponseBody 
	String findMonitData(@PathVariable String tableStr,
			@PathVariable String fieldStr,@PathVariable String connStr,@PathVariable String valueStr,
			Model model,HttpServletRequest request
			,HttpServletResponse response)
	{
		String jsonMonitData = "";
		//Integer hQLIntValue = 0;
		Double hQLDoubleValue = 0.0;
		//String consoleMessage = "";
		
		List<MonitBen> queryBens =new ArrayList<MonitBen>();
		List<MonitPhy> queryPhies = new ArrayList<MonitPhy>();
		BaseBen bioBaseBen = new BaseBen();
		/*0429：BasePhy bioBasePhy = new BasePhy();*/
		
		
		//URL解码，JS中的请求在发送之前已经被转码
		String hQLTable = "";String hQLField = "";String hQLConn = "";String hQLValue = "";
		try {
			hQLTable = URLDecoder.decode(tableStr, "utf-8");
			hQLField = URLDecoder.decode(fieldStr, "utf-8");
			hQLConn = URLDecoder.decode(connStr, "utf-8");
			hQLValue = URLDecoder.decode(valueStr, "utf-8");
			//hQLBioName = URLDecoder.decode(bioStr, "utf-8");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		String hQLState = "Select o from "+hQLTable+" o where 1=1 and o."+ hQLField + hQLConn +":value";
		String hQLStateConditions = "Select o from "+hQLTable+" o where 1=1 and o." + hQLValue;
		
		//String hQLState = "Select o from "+hQLTable+" o where o."+ hQLField + hQLConn + ":value";
		
		
		//根据查询关键字返回底栖的监测数据和生物信息	
		if (hQLTable.equalsIgnoreCase("MonitBen")) {
			
				queryBens = monitBenStr.findDataByParam(hQLStateConditions);
			
			/*if (hQLField.equalsIgnoreCase("quantity")||hQLField.equalsIgnoreCase("id")) {
				
				if(NumberUtils.isNumber(hQLValue)){
					hQLIntValue =Integer.valueOf(hQLValue);
					System.out.println(hQLIntValue);
					queryBens = monitBenInt.findDataByParam(hQLState, hQLIntValue);
					consoleMessage = "查询成功！";
				}
				else {
					consoleMessage = "WARN:Please input the right type!";
					//queryBens = monitBenStr.getAllBen();
				}

			}
			else if (hQLField.equalsIgnoreCase("biomass")) {
				System.out.println(hQLDoubleValue);
				hQLDoubleValue = Double.valueOf(hQLValue);
				queryBens = monitBenDbl.findDataByParam(hQLState,hQLDoubleValue);
			}
			else {
				queryBens = monitBenStr.findDataByParam(hQLState, hQLValue);
				bioBaseBen = bioBenInfoService.findBenBioInfoByNamed(hQLValue);
			}*/
			
			
			
			//编辑JSON格式字符串，将两种类型的数据放在同一JSON字符串中发送
			String jsonBioBen = JSON.toJSONString(bioBaseBen);
			String jsonQueryBens = JSON.toJSONString(queryBens);
				jsonQueryBens = jsonQueryBens.substring(0, jsonQueryBens.length()-1);
			
				jsonMonitData = jsonQueryBens+","+jsonBioBen+"]";
			
		}
		else if(hQLTable.equalsIgnoreCase("MonitPhy")){
			//0429：数据规范
			if (hQLField.equalsIgnoreCase("quantity")||hQLField.equalsIgnoreCase("biomass")){
				hQLDoubleValue = Double.valueOf(hQLValue);
				System.out.println(hQLDoubleValue);
				queryPhies = monitPhyDbl.findDataByParam(hQLState,hQLDoubleValue);
			}
			
			
			else if(hQLField.equalsIgnoreCase("phyName")){
				queryPhies = monitPhyStr.findDataByParam(hQLState, hQLValue);
				/*0429：bioBasePhy = bioPhyInfoService.findPhyBioInfoByNamed(hQLValue);*/
			}
			else {
				queryPhies = monitPhyStr.findDataByParam(hQLState, hQLValue);
			}
			
			
			
			//编辑JSON格式字符串，将两种类型的数据放在同一JSON字符串中发送
			/*0429：String jsonBioPhy = JSON.toJSONString(bioBasePhy);*/
			String jsonQueryPhies = JSON.toJSONString(queryPhies);
			
			/*0429:jsonQueryPhies = jsonQueryPhies.substring(0, jsonQueryPhies.length()-1);
			
			jsonMonitData = jsonQueryPhies+","+jsonBioPhy+"]";*/
			
		}
		else if (hQLTable.equalsIgnoreCase("MonitZooplan")) {
			
		}
		
		else if (hQLTable.equalsIgnoreCase("CatchFishObj")) {
			
		}
		
		
		/*queryBens = monitBenService.findDataByParam(hQLState, hQLValue);
		bioBaseBen = bioBenInfoService.findBenBioInfoByNamed(hQLValue);*/
		
		
			System.out.println("hQLState:"+hQLState.toString());
			System.out.println("phyLength:"+queryPhies.size()+",BenLength:"+queryBens.size());
			
			//System.out.println(jsonQueryBens);
			System.out.println(jsonMonitData);
		
		//编辑JSON格式字符串，将两种类型的数据放在同一JSON字符串中发送
	/*	String jsonBioBen = JSON.toJSONString(bioBaseBen);
		String jsonQueryBens = JSON.toJSONString(queryBens);
			jsonQueryBens = jsonQueryBens.substring(0, jsonQueryBens.length()-1);
		
		String jsonBenReturn = jsonQueryBens+","+jsonBioBen+"]";
		
			System.out.println(jsonQueryBens);
			System.out.println(jsonBenReturn);*/
		
		//为防止前后端编码不一致，在发送前对数据进行UTF-8编码
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
