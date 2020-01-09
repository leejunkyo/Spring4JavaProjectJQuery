package sp4j.jmp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import sp4j.common.model.CommandMap;

@Controller
public class JMP10000Controller {
	
	@RequestMapping(value = "/jmp/openPage.do")
	public ModelAndView login(CommandMap commandMap,HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView("/main/main");
		
		return mv;
	}
}
