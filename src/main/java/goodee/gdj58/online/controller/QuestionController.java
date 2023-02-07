package goodee.gdj58.online.controller;



import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import goodee.gdj58.online.service.QuestionService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
	// 문제 추가
	@PostMapping("/teacher/question/addQuestion")
	public String addQuestion(@RequestParam("testNo") int testNo
								, @RequestParam("questionIdx") int questionIdx
								, @RequestParam("questionTitle") String questionTitle
								, @RequestParam("exampleTitle1") String exampleTitle1
								, @RequestParam("answer1") String answer1
								, @RequestParam("exampleTitle2") String exampleTitle2
								, @RequestParam("answer2") String answer2
								, @RequestParam("exampleTitle3") String exampleTitle3
								, @RequestParam("answer3") String answer3
								, @RequestParam("exampleTitle4") String exampleTitle4
								, @RequestParam("answer4") String answer4) {
		
		log.debug("\u001B[31m" + testNo + " <-- testNo");
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("testNo", testNo);
		paramMap.put("questionIdx", questionIdx);
		paramMap.put("questionTitle", questionTitle);
		
		paramMap.put("exampleTitle1", exampleTitle1);
		paramMap.put("answer1", answer1);
		
		paramMap.put("exampleTitle2", exampleTitle2);
		paramMap.put("answer2", answer2);
		
		paramMap.put("exampleTitle3", exampleTitle3);
		paramMap.put("answer3", answer3);
		
		paramMap.put("exampleTitle4", exampleTitle4);
		paramMap.put("answer4", answer4);
		
		int row = questionService.addQuestion(paramMap);
		
		
		
		
		return "redirect:/teacher/test/testOne?testNo=" + testNo;
		
	}
	
	
}
