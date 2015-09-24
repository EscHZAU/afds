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
	
	
	
	
	//��ʼ������������¼����ҳ�棬��ѯ������Ӧ�Ļ���������(Base_)���г����п�ѡ����������
	@RequestMapping(value = "/index",method = RequestMethod.GET)
	public String getAllByType(Model model, HttpServletRequest request, HttpServletResponse response){
		
		
		model.addAttribute("benBioDirectory",queryBioInfo.getBenBio());
		model.addAttribute("phyBioDirectory",queryBioInfo.getPhyBio());
		model.addAttribute("zooBioDirectory",queryBioInfo.getZooBio());
		model.addAttribute("fishBioDirectory",queryBioInfo.getFishBio());
		
		return "jsp/classifyBioQuery";
	}
	
	
	//��������Ĺؼ��ֲ�ѯ������Ϣ 
	@RequestMapping(value = "/{tableSelected}/{keyWord}",method = RequestMethod.GET)
	public @ResponseBody String queryBySpecies(@PathVariable String tableSelected, @PathVariable String keyWord,Model model,
					HttpServletRequest request, HttpServletResponse response){
		
		
		//��ҳ��˽���·����������������н���
		//��Ϊ�˱�֤�������룬�ڷ��Ͳ�����ʱ���ȡ��ͳһ����ķ�ʽ�����͵������Ҫͳһ���룩
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
		
		//����DAO�ӿ�ʵ�����б�д�ķ������Դ��ݵ��������˵��ַ���Ϊ����
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
