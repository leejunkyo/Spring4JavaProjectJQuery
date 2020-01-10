package sp4j.jmp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import sp4j.common.model.CommandMap;
import sp4j.tbl.model.CUCUIF;

@Controller
public class JMP10000Controller {
	
	@RequestMapping(value = "/jmp/openPage.do")
	public ModelAndView login(CommandMap commandMap,HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView("/main/main");
		HttpSession session = request.getSession();
		CUCUIF cucuif = (CUCUIF)session.getAttribute("loginVO");
		mv.addObject("cusId", cucuif.getCusId());
		mv.addObject("cusNm", cucuif.getCusNm());
		return mv;
	}
}
