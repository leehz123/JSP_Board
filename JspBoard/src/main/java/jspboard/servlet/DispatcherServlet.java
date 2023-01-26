package jspboard.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspboard.process.BoardProcess;
import jspboard.process.DeleteAuthenFormProcess;
import jspboard.process.DeleteAuthenProcess;
import jspboard.process.EditAuthenFormProcess;
import jspboard.process.EditAuthenProcess;
import jspboard.process.EditFormProcess;
import jspboard.process.EditUpdateProcess;
import jspboard.process.LoginFormProcess;
import jspboard.process.LoginProcess;
import jspboard.process.LogoutProcess;
import jspboard.process.PostProcess;
import jspboard.process.PostingFormProcess;
import jspboard.process.PostingProcess;
import jspboard.process.Process;
import jspboard.process.SearchProcess;
import jspboard.process.SignupFormProcess;
import jspboard.process.SignupProcess;

public class DispatcherServlet extends HttpServlet {
			
		private final static String REDIRECT = "redirect:";
		HashMap<String, Process> uri_mapping;;
	
		@Override
		public void init(ServletConfig config) throws ServletException {
			
			uri_mapping = new HashMap<>();
			
			uri_mapping.put("/signup_form", new SignupFormProcess());
			uri_mapping.put("/signup", new SignupProcess());
			
			uri_mapping.put("/login_form", new LoginFormProcess());
			uri_mapping.put("/login", new LoginProcess());
			
			uri_mapping.put("/logout", new LogoutProcess());
			
			uri_mapping.put("/board", new BoardProcess());
			
			uri_mapping.put("/edit_update", new EditUpdateProcess());
			uri_mapping.put("/edit_form", new EditFormProcess());
			uri_mapping.put("/edit_authen_form", new EditAuthenFormProcess());
			uri_mapping.put("/edit_authen", new EditAuthenProcess());
			
			uri_mapping.put("/delete_authen_form", new DeleteAuthenFormProcess());
			uri_mapping.put("/delete_authen", new DeleteAuthenProcess());
			
			uri_mapping.put("/posting_form", new PostingFormProcess());
			uri_mapping.put("/posting", new PostingProcess());
		
			
			uri_mapping.put("/post", new PostProcess());
			
			uri_mapping.put("/search", new SearchProcess());
			
		}
		
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			String uri = req.getRequestURI();
			System.out.println("컨텍패 : "+req.getContextPath());
			uri = uri.substring(req.getContextPath().length());
			Process process = uri_mapping.get(uri);
			//System.out.println("여기도? ");
			String nextPath;
			
			if(process != null) {
				nextPath = process.process(req, resp);//사용자가 입력한 uri에 해당하는 프로세스 처리되고 다음 주소값 리턴됨
				if(nextPath.startsWith(REDIRECT)) {
					resp.sendRedirect(nextPath.substring(REDIRECT.length()));
					return;
				}
			} else {
				nextPath = "/WEB-INF/views/errorpage/not_found.jsp";
			}
			//System.out.println(nextPath);
			req.getRequestDispatcher(nextPath).forward(req, resp);			
		}
}
