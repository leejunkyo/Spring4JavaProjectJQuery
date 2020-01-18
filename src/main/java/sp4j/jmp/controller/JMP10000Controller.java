package sp4j.jmp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import sp4j.common.model.CommandMap;
import sp4j.jmp.service.JMP10000Service;
import sp4j.tbl.model.CUCUIF;
import sp4j.tbl.model.CUMNIF;

@Controller
public class JMP10000Controller {
	
	@Resource(name="jmp10000Service")
	private JMP10000Service jmp10000Service;
	
	@RequestMapping(value = "/jmp/openPage.do")
	public ModelAndView login(CommandMap commandMap,HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView("/main/main");
		HttpSession session = request.getSession();
		CUCUIF cucuif = (CUCUIF)session.getAttribute("loginVO");
		
		
		mv.addObject("cusId", cucuif.getCusId());
		mv.addObject("cusNm", cucuif.getCusNm());

		return mv;
	}
	@RequestMapping(value = "/jmp/menuList.do")
	public ModelAndView menuList(CommandMap commandMap,HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<CUMNIF> cumnifList = jmp10000Service.selectCUMNIFList(map);
		mv.addObject("cumnifList", cumnifList);
		return mv;
	}
}
