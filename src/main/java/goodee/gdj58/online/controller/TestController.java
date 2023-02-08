package goodee.gdj58.online.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import goodee.gdj58.online.service.TestService;
import goodee.gdj58.online.vo.Test;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class TestController {

	@Autowired
	private TestService testService;
	
	// 시험지 한개 문제&보기 출력(학생)
	@GetMapping("/student/test/testOne")
	public String studentTestOne(Model model
							, @RequestParam("testNo") int testNo) {
		
		List<Map<String, Object>> list = testService.getTestOne(testNo);
		
		model.addAttribute("testNo", testNo);
		
		model.addAttribute("testOneList", list);
		
		log.debug("\u001B[31m" + list.toString() + " <-- list");		
		
		return "student/test/testOne";
		
		
	} 
	
	// 학생 응시가능한 시험 목록
	@GetMapping("/student/test/testList")
	public String studentTestList(Model model) {
		
		List<Test> list = testService.getStudentTestList();
		
		model.addAttribute("testList", list);
		
		return "student/test/testList";
		
	}
	
	// 시험 수정 Post
	@PostMapping("/teacher/test/modifyTest")
	public String modifyTest(@RequestParam("testNo") int testNo
							, @RequestParam("testTitle") String testTitle) {
		
		Test test = new Test();
		test.setTestNo(testNo);
		test.setTestTitle(testTitle);
		
		int row = testService.modifyTest(test);
		
		return "redirect:/teacher/test/testList";
		
	}
	
	// 시험 수정 Get
	@GetMapping("/teacher/test/modifyTest")
	public String modifyTest(Model model
							, @RequestParam("testNo") int testNo) {
		
		Test test = testService.getTestTitle(testNo);
		
		log.debug("\u001B[31m" + test.toString() + " <-- test");
		
		model.addAttribute("test", test);
		
		return "teacher/test/modifyTest";
		
	}
	
	// 시험 등록
	@GetMapping("/teacher/test/addTest")
	public String addTest() {
		
		return "teacher/test/addTest";
		
	}
	
	@PostMapping("/teacher/test/addTest")
	public String addTest(@RequestParam("testTitle") String testTitle) {
		
		Test test = new Test();
		test.setTestTitle(testTitle);
		
		testService.addTest(test);
		
		return "redirect:/teacher/test/testList";
		
	}
	
	// 시험 한개 문제&보기 출력(선생님)
	@GetMapping("/teacher/test/testOne")
	public String testOne(Model model
							, @RequestParam("testNo") int testNo) {
		
		List<Map<String, Object>> list = testService.getTestOne(testNo);
		
		model.addAttribute("testNo", testNo);
		
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
