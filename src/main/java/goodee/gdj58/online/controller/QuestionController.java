package goodee.gdj58.online.controller;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import goodee.gdj58.online.service.QuestionService;
import goodee.gdj58.online.vo.Example;
import goodee.gdj58.online.vo.Question;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
	// 문제&보기 1세트 삭제
	@GetMapping("/teacher/question/removeQuestion")
	public String removeQuestion(@RequestParam("testNo") int testNo
								, @RequestParam("questionNo") int questionNo
								, @RequestParam("exampleNo1") int exampleNo1
								, @RequestParam("exampleNo2") int exampleNo2
								, @RequestParam("exampleNo3") int exampleNo3
								, @RequestParam("exampleNo4") int exampleNo4) {
		
		questionService.removeQuestion(questionNo, exampleNo1, exampleNo2, exampleNo3, exampleNo4);

		return "redirect:/teacher/test/testOne?testNo=" + testNo;
		
	}
	
	
	// 문제&보기 1세트 수정
	@PostMapping("/teacher/question/modifyQuestion")
	public String modifyQuestion(@RequestParam("questionNo") int questionNo
								, @RequestParam("testNo") int testNo
								, @RequestParam("questionIdx") int questionIdx
								, @RequestParam("questionTitle") String questionTitle
								, @RequestParam("exampleNo1") int exampleNo1
								, @RequestParam("exampleTitle1") String exampleTitle1
								, @RequestParam("answer1") String answer1
								, @RequestParam("exampleNo2") int exampleNo2
								, @RequestParam("exampleTitle2") String exampleTitle2
								, @RequestParam("answer2") String answer2
								, @RequestParam("exampleNo3") int exampleNo3
								, @RequestParam("exampleTitle3") String exampleTitle3
								, @RequestParam("answer3") String answer3
								, @RequestParam("exampleNo4") int exampleNo4
								, @RequestParam("exampleTitle4") String exampleTitle4
								, @RequestParam("answer4") String answer4) {
		
		Question q = new Question();
		q.setQuestionNo(questionNo);
		q.setQuestionIdx(questionIdx);
		q.setQuestionTitle(questionTitle);
		
		Example e1 = new Example();
		e1.setExampleNo(exampleNo1);
		e1.setExampleTitle(exampleTitle1);
		e1.setAnswer(answer1);
		
		Example e2 = new Example();
		e2.setExampleNo(exampleNo2);
		e2.setExampleTitle(exampleTitle2);
		e2.setAnswer(answer2);
		
		Example e3 = new Example();
		e3.setExampleNo(exampleNo3);
		e3.setExampleTitle(exampleTitle3);
		e3.setAnswer(answer3);
		
		Example e4 = new Example();
		e4.setExampleNo(exampleNo4);
		e4.setExampleTitle(exampleTitle4);
		e4.setAnswer(answer4);
		
		List<Example> exampleList = new ArrayList<Example>();
		exampleList.add(e1);
		exampleList.add(e2);
		exampleList.add(e3);
		exampleList.add(e4);
		
		int row = questionService.modifyQuestion(q, exampleList);
		
		return "redirect:/teacher/test/testOne?testNo=" + testNo;
		
	}
	
	// 문제&보기 1세트 출력
	@GetMapping("teacher/question/modifyQuestion")
	public String questionOne(Model model
								, @RequestParam("questionNo") int questionNo
								, @RequestParam("exampleNo1") int exampleNo1
								, @RequestParam("exampleNo2") int exampleNo2
								, @RequestParam("exampleNo3") int exampleNo3
								, @RequestParam("exampleNo4") int exampleNo4) {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("questionNo", questionNo);
		
		paramMap.put("exampleNo1", exampleNo1);
		paramMap.put("exampleNo2", exampleNo2);
		paramMap.put("exampleNo3", exampleNo3);
		paramMap.put("exampleNo4", exampleNo4);
		
		Map<String, Object> map = questionService.selectQuestionOne(paramMap);
		
		model.addAttribute("questionNo", questionNo);
		model.addAttribute("testNo", ((Question) map.get("question")).getTestNo());
		model.addAttribute("questionIdx", ((Question) map.get("question")).getQuestionIdx());
		model.addAttribute("questionTitle", ((Question) map.get("question")).getQuestionTitle());
		
		model.addAttribute("exampleNo1", exampleNo1);
		model.addAttribute("exampleTitle1", ((Example) map.get("example1")).getExampleTitle());
		model.addAttribute("answer1", ((Example) map.get("example1")).getAnswer());
		
		model.addAttribute("exampleNo2", exampleNo2);
		model.addAttribute("exampleTitle2", ((Example) map.get("example2")).getExampleTitle());
		model.addAttribute("answer2", ((Example) map.get("example2")).getAnswer());
		
		model.addAttribute("exampleNo3", exampleNo3);
		model.addAttribute("exampleTitle3", ((Example) map.get("example3")).getExampleTitle());
		model.addAttribute("answer3", ((Example) map.get("example3")).getAnswer());
		
		model.addAttribute("exampleNo4", exampleNo4);
		model.addAttribute("exampleTitle4", ((Example) map.get("example4")).getExampleTitle());
		model.addAttribute("answer4", ((Example) map.get("example4")).getAnswer());
		
		
		return "teacher/question/modifyQuestion";
		
	}
	
	// 문제&보기 추가
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
		
		log.debug("\u001B[31m" + row + " <-- row");
		
		
		return "redirect:/teacher/test/testOne?testNo=" + testNo;
		
	}
	
	
}
