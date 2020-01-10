package sp4j.jcp.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import sp4j.common.model.CommandMap;
import sp4j.jcp.service.JCP10000Service;
import sp4j.tbl.model.CUCUIF;

@Controller
public class JCP10000Controller {
	
	@Resource(name="jcp10000Service")
	private JCP10000Service jcp10000Service;
	
	@RequestMapping(value = "/jcp/loginPage.do")
	public ModelAndView loginPage(CommandMap commandMap,HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView("/jcp/JCP10000");
/*		HttpSession session = request.getSession();
		mv.addObject("firstVisit", session.getAttribute("firstVisit"));*/
		return mv;
	}
	
	@RequestMapping(value = "/jcp/login.do")
	public ModelAndView login(CommandMap commandMap,HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView("/jcp/JCP10000");
		
		CUCUIF cusInfo = jcp10000Service.selectCusInfo(commandMap.getMap());
		if(cusInfo==null){
			mv.addObject("result", "아이디 비밀번호를 정확히 입력하세요.");
		}else{
			HttpSession session = request.getSession();
			session.setAttribute("loginVO", cusInfo);
			response.sendRedirect("/jmp/openPage.do");
		}
		
		return mv;
	}
	@RequestMapping(value = "/jcp/join.do")
	public ModelAndView join(CommandMap commandMap) throws Exception {
		
		ModelAndView mv = new ModelAndView("/jcp/JCP10000");
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("cusId",commandMap.getMap().get("cusId"));
		map.put("cusPwd","");
		CUCUIF cusInfo = jcp10000Service.selectCusInfo(map);
		
		if(cusInfo == null){
			map.put("cusPwd",commandMap.getMap().get("cusPwd"));
			map.put("cusNm","앙응디이만지고싶다");
			mv.addObject("result", "가입이 완료되었습니다."); 
			jcp10000Service.insertCusInfo(map);
		}else{
			mv.addObject("result", "중복된 아이디가 존재합니다."); 
		}
		return mv;
	}
	@RequestMapping(value = "/jcp/logOut.do")
	public ModelAndView logOut(CommandMap commandMap,HttpServletRequest request, HttpServletResponse response) throws Exception {
			ModelAndView mv = new ModelAndView("/jcp/JCP10000");
			HttpSession session = request.getSession();
			session.setAttribute("loginVO", null);
		
		return mv;
	}
}
