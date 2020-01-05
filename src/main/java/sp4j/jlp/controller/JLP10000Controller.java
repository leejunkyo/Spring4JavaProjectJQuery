package sp4j.jlp.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JLP10000Controller {
	@RequestMapping(value = "/jlp/loginPage.do")
	public ModelAndView loginPage(Map<String, Object> commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("/jlp/JLP10000");
		return mv;
	}
}
