package goodee.gdj58.online.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import goodee.gdj58.online.service.TestService;
import goodee.gdj58.online.vo.Test;

@Controller
public class TestController {

	@Autowired
	private TestService testService;
	
	// 시험 한개 문제&보기 출력(선생님)
	@GetMapping("/teacher/test/testOne")
	public String testOne(Model model
							, @RequestParam("testNo") int testNo) {
		
		List<Map<String, Object>> list = testService.getTestOne(testNo);
		
		model.addAttribute("testOneList", list);
		
		return "teacher/test/testOne";
		
		
	}
	
	// 시험 목록
	@GetMapping("/teacher/test/testList")
	public String testList(Model model) {
		
		List<Test> list = testService.getTestList();
		
		model.addAttribute("testList", list);
		
		return "teacher/test/testList";
		
	}
	
}
