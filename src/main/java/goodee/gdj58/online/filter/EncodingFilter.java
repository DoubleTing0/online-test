package goodee.gdj58.online.filter;

import java.io.IOException;	
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebFilter("/*")
public class EncodingFilter extends HttpFilter implements Filter {
    
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		log.debug("\u001B[31m" + "EncodingFilter 실행");
		
		request.setCharacterEncoding("UTF-8");
		
		chain.doFilter(request, response);
		
		
	}


}
