package cn.hzau.edu.fishResearch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;

import cn.hzau.edu.fishResearch.DAO.impl.IUserAccountDAOImpl;
import cn.hzau.edu.fishResearch.domain.SyUserInfo;

/**
 * For the users' login
 * @author Ericliu
 *
 */

@Controller
@RequestMapping("/jsp/login.do")
public class userLoginController {
	
	@Autowired
	private IUserAccountDAOImpl userAccountDAOImpl;
	
	/**
	 * 初始化表单
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView initForm(ModelMap model){
		SyUserInfo userInfo = new SyUserInfo();//用于转换到form表单的对象
		
		return new ModelAndView("login").addObject(userInfo);
	}
	
	
	/**
	 * login-testing
	 * 
	 * @param userInfo
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String login(@ModelAttribute("userInfo") SyUserInfo userInfo) {
		
		List<SyUserInfo> user = userAccountDAOImpl.readByAccount("admin", "123");
		
		if (user.size() != 0) {
			System.out.println("yes,welcome to the afds");
			return "yes,please";
		}
		else {
			System.out.println("sorry,please login again");
			return "sorry";
		}
	}
	
	

}
