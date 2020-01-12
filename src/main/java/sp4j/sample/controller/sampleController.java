package sp4j.sample.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class sampleController {
	@RequestMapping(value = "/sample/openSampleList.do")
	public ModelAndView loginPage(Map<String, Object> commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("/sample/boardList");
		return mv;
	}
}
