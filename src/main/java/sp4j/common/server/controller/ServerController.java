package sp4j.common.server.controller;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import sp4j.common.model.CommandMap;
import sp4j.common.server.service.ServerService;

@Controller
public class ServerController {
	
	@Resource(name="serverService")
	private ServerService serverService;
	
	@Value("#{config['server']}")
	String server;
	
	@RequestMapping(value = "/server/firstVisit.do")
	public ModelAndView loginPage(CommandMap commandMap, HttpServletRequest request) throws Exception {
		
		System.err.println(server);
		HttpSession session = request.getSession();
		
		session.setAttribute("firstVisit", "N");
		ModelAndView mv = new ModelAndView("/jlp/JLP10000");
		return mv;
	}
	

 
}
