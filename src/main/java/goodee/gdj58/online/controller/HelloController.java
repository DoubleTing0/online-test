package goodee.gdj58.online.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HelloController {
	
	@GetMapping("/test")
	public String test() {
		
		System.out.println("test...");
		
		return "test";	// 뷰 이름
	}
	
	
	@RequestMapping(value="/test2")	
	public String test2() {		// get post 두개의 방식 모두 사용할 땐 사용한다.
		
		System.out.println("test2...");
		
		return "test";	// 뷰 이름
	}
	
	@GetMapping("/test3")
	public void test3() {	// return 타입이 void 면 메서드 이름이 뷰이름이 된다.
		
		System.out.println("test3...");
		
	}
	
	@GetMapping("/test4")
	public ModelAndView test4() {
		
		System.out.println("test4...");
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("test");		// 뷰 이름
		
		return mv;
		
	}
	
	@GetMapping("/test5")
	public String test5() {
		
		return "test";
		
	}
	
	@PostMapping("/test5")
	public String test5(@RequestParam("checkbox") String[] arr) {
		
		log.debug("\u001B[31m" + arr + " <-- arr");
		
		for(String s : arr) {
			log.debug("\u001B[31m" + s + " <-- s"); 
					
		}
		
		
		return "test";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
