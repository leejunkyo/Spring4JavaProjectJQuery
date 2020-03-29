package sp4j.jsm.contoller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import sp4j.common.model.CommandMap;
import sp4j.jsm.service.JSM10110Service;

@Controller
public class JSM10110Controller {	
	
	@Resource(name="jsm10110Service")
	private JSM10110Service jsm10110Service;
	
	@RequestMapping(value = "/jsm/jsm10110/openPage.do")
	public ModelAndView jsm10110OpenPage(CommandMap commandMap,HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView("/jsm/jsm10110");  
		
		return mv;
	}
	
	@RequestMapping(value = "/jsm/jsm10110/jsm10110List.do")
	public ModelAndView jsm10110List(CommandMap commandMap,HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		
		List<Map<String,Object>> jsm10110List = jsm10110Service.chatList(commandMap.getMap());
		
		mv.addObject("jsm10110List", jsm10110List);
		return mv;
	}
	
	
}

