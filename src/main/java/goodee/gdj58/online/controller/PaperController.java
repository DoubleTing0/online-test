package goodee.gdj58.online.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import goodee.gdj58.online.service.PaperService;
import goodee.gdj58.online.vo.Student;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class PaperController {

	@Autowired
	private PaperService paperService;
	
	// 학생 답안 제출 시 추가
	@PostMapping("/student/paper/addPaper")
	public String addPaper(HttpSession session 
							, @RequestParam("testNo") int testNo
							, @RequestParam("checkbox") List<String> paperList) {
		/*
		for(String s : paperList) {
			
			log.debug("\u001B[31m" + s + " <-- arr");
		}
		*/
		
		Student loginStudent = (Student) session.getAttribute("loginStudent");
		log.debug("\u001B[31m" + loginStudent.toString() + " <-- testNo");
		
		Map<String, Object> hm = new HashMap<String, Object>();
		hm.put("testNo", testNo);
		hm.put("studentNo", loginStudent.getStudentNo());
		hm.put("paperList", paperList);
		
		// 제출한 답안 등록 및 채점
		int row = paperService.addAndCheckPaper(hm);
		
		
		
		
		
			
		return "redirect:/login";
		
	}
	
	
}
