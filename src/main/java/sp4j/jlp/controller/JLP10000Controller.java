package sp4j.jlp.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import sp4j.common.model.CommandMap;
import sp4j.jlp.service.JLP10000Service;
import sp4j.tbl.model.CUS_INFO;

@Controller
public class JLP10000Controller {
	
	@Resource(name="jlp10000Service")
	private JLP10000Service jlp10000Service;
	
	@RequestMapping(value = "/jlp/loginPage.do")
	public ModelAndView loginPage(CommandMap commandMap,HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView("/jlp/JLP10000");
/*		HttpSession session = request.getSession();
		mv.addObject("firstVisit", session.getAttribute("firstVisit"));*/
		return mv;
	}
	
	@RequestMapping(value = "/jlp/login.do")
	public ModelAndView login(CommandMap commandMap,HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView("/jlp/JLP10000");
		CUS_INFO cusInfo = jlp10000Service.selectCusInfo(commandMap.getMap());
		if(cusInfo==null){
			mv = new ModelAndView("/jlp/JLP10000");
			mv.addObject("result", "계정 정보가 일치하지 않습니다.");
		}else{
			mv = new ModelAndView("/jmp/JMP10000");
		}
		
		return mv;
	}
	@RequestMapping(value = "/jlp/join.do")
	public ModelAndView join(CommandMap commandMap) throws Exception {
		/**
		 * CommandMap>> param : id , pw 
		 * id, pw로 select
		 * 
		 * */
		ModelAndView mv = new ModelAndView("/jlp/JLP10000");
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("id",commandMap.getMap().get("id"));
		map.put("pw","");
		CUS_INFO cusInfo = jlp10000Service.selectCusInfo(map);
		/**
		 * 아이디 존재가 하지 않음*/
		if(cusInfo == null){
			map.put("pw",commandMap.getMap().get("pw"));
			map.put("userName","이은지");
			jlp10000Service.insertCusInfo(map);
		}else{
			mv.addObject("result", "이미 존재하는 아이디 입니다."); 
		}
		return mv;
	}
}
