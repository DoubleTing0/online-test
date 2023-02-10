package goodee.gdj58.online.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import goodee.gdj58.online.service.ScoreService;
import goodee.gdj58.online.vo.Student;

@Controller
public class ScoreController {

	@Autowired
	private ScoreService scoreService;
	
	// 학생이 응시한 시험 점수 확인
	@GetMapping("/student/score/scoreList")
	public String scoreList(HttpSession session, Model model) {
		
		Student loginStudent = (Student) session.getAttribute("loginStudent");
		
		List<Map<String, Object>> list = scoreService.getScoreList(loginStudent.getStudentNo());
		
		model.addAttribute("scoreList", list);
		
		return "student/score/scoreList";
		
	}
	
	
}
