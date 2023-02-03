package goodee.gdj58.online.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebFilter("/student/*")
public class StudentLoginFilter extends HttpFilter implements Filter {
       
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

    	log.debug("\u001B[31m" + "StudentLoginFilter 실행");
    	
    	if(request instanceof HttpServletRequest) {
    		// ServletRequest request 가 HttpServletRequest로 형변환이 가능할때
    		// 웹 브라우저에서 요청이 들어올 때로 해석
    		
    		HttpServletRequest req = (HttpServletRequest) request;
    		
    		HttpSession session =  req.getSession();
    		if(session.getAttribute("loginStudent") == null) {
    			// 이미 상위 if에서 웹 요청 검사 했기에 여기선 안해도 됨.
    			
    			((HttpServletResponse) response).sendRedirect(req.getContextPath() + "/login");
    			
    			return;
    			
    		}
    		
    	} else {
    		
    		log.debug("웹브라우저 요청만 허용합니다.");
    		
    		
    	}		
		
		chain.doFilter(request, response);
		
		
		
	}


}
