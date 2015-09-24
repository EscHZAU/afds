package cn.hzau.edu.fishResearch.controller;

import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import cn.hzau.edu.fishResearch.DAO.impl.IBioInfoDAOImpl;
import cn.hzau.edu.fishResearch.domain.BaseBen;
import cn.hzau.edu.fishResearch.domain.MonitBen;

/**
 * For querying bio_Information
 * @author Eric
 *
 */
@Controller
@RequestMapping(value = "/classifyBioQuery")
public class bioQueryController{
	/**
	 * Get biological information
	 */
	@Autowired
	IBioInfoDAOImpl<BaseBen, Integer> queryBioInfo;
	
	
	
	
	//初始化调查生物名录检索页面，查询遍历相应的基础生物表格(Base_)，列出所有可选的物种种类
	@RequestMapping(value = "/index",method = RequestMethod.GET)
	public String getAllByType(Model model, HttpServletRequest request, HttpServletResponse response){
		
		
		model.addAttribute("benBioDirectory",queryBioInfo.getBenBio());
		model.addAttribute("phyBioDirectory",queryBioInfo.getPhyBio());
		model.addAttribute("zooBioDirectory",queryBioInfo.getZooBio());
		model.addAttribute("fishBioDirectory",queryBioInfo.getFishBio());
		
		return "jsp/classifyBioQuery";
	}
	
	
	//根据输入的关键字查询生物信息 
	@RequestMapping(value = "/{tableSelected}/{keyWord}",method = RequestMethod.GET)
	public @ResponseBody String queryBySpecies(@PathVariable String tableSelected, @PathVariable String keyWord,Model model,
					HttpServletRequest request, HttpServletResponse response){
		
		
		//从页面端接受路径参数，并将其进行解码
		//（为了保证避免乱码，在发送参数的时候采取了统一编码的方式，发送到后端需要统一解码）
		String queryType = "";
		String queryKeyWord = "";
		String jsonBioInfo = "";
		
		try {
			queryType = URLDecoder.decode(tableSelected,"utf-8");
			queryKeyWord = URLDecoder.decode(keyWord,"utf-8");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		//调用DAO接口实现类中编写的方法，以传递到服务器端的字符串为参数
		String jsonBioBen = JSON.toJSONString(queryBioInfo.findBioInfoBySpeciesStr(queryKeyWord,queryType));
		
		jsonBioInfo =  "[" + jsonBioBen +"]";
		
		System.out.println(jsonBioInfo);
		
		String jsonBioBenEncode = "";
		
		try {
			jsonBioBenEncode = URLEncoder.encode(jsonBioInfo,"UTF-8");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return	jsonBioBenEncode;		
	}

	@RequestMapping(value="/bioQueryInfo", method=RequestMethod.GET)
	public  String generatebioInfo(Model model, HttpServletRequest request, HttpServletResponse response){
		

		return "jsp/bioQueryInfo";
	}

}
