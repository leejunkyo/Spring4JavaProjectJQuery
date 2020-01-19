package sp4j.jcp.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import sp4j.common.model.CommandMap;
import sp4j.common.utility.sha256Util;
import sp4j.jcp.service.JCP10000Service;
import sp4j.tbl.model.CUCUIF;

@Controller
public class JCP10100Controller {
	@Resource(name="jcp10000Service")
	private JCP10000Service jcp10000Service;
	
	@RequestMapping(value = "/jcp/jcp10100/openPage.do")
	public ModelAndView loginPage(CommandMap commandMap,HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView("/jcp/JCP10100");
		return mv;
	}
	
	@RequestMapping(value = "/jcp/jcp10100/join.do")
	public ModelAndView join(CommandMap commandMap) throws Exception {
		
		ModelAndView mv = new ModelAndView("jsonView");
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("cusId",commandMap.getMap().get("cusId"));
		map.put("cusPwd","");
		map.put("cusNm",commandMap.getMap().get("cusNm"));
		CUCUIF cusInfo = jcp10000Service.selectCusInfo(map);
		
		if(cusInfo == null){
			map.put("cusPwd",sha256Util.sha256Create(commandMap.getMap().get("cusPwd").toString()));
			mv.addObject("result", "0000"); 
			jcp10000Service.insertCusInfo(map);
			
		}else{
			mv.addObject("result", "1111"); 
		}
		
		return mv;
	}
	
}
