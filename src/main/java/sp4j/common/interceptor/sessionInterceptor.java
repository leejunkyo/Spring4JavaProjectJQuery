package sp4j.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class sessionInterceptor extends HandlerInterceptorAdapter {
	protected Log log = LogFactory.getLog(sessionInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		
		if (!"/jlp/loginPage.do".equals(request.getRequestURI().toString()) &&
				!"/jlp/login.do".equals(request.getRequestURI().toString()) &&
				!"/jlp/join.do".equals(request.getRequestURI().toString()) &&
				!"/server/firstVisit.do".equals(request.getRequestURI().toString()) 
				
		) {
			if (session.getAttribute("loginVO") == null) {
				log.debug(
						"====================================           만료된 세션             =================================================");
				response.sendRedirect("/jlp/loginPage.do");
				return false;

			}
			;
		}

		if (log.isDebugEnabled()) {
			log.debug(
					"======================================          START         ======================================");
			log.debug(" Request URI \t:  " + request.getRequestURI());
		}

		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug(
					"======================================           END          ======================================\n");
		}
	}
}