package goodee.gdj58.online.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import goodee.gdj58.online.service.IdService;
import goodee.gdj58.online.service.TeacherService;
import goodee.gdj58.online.vo.Employee;
import goodee.gdj58.online.vo.Teacher;

@Controller
public class TeacherController {

	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private IdService idService;
	
	// 선생님 삭제 Get
	@GetMapping("/employee/removeTeacher")
	public String removeTeacher(Model model
								, @RequestParam("teacherNo") int teacherNo) {
		
		
		int row = teacherService.removeTeacher(teacherNo);
		
		if(row == 0) {
			model.addAttribute("errorMsg", "시스템 오류로 삭제 할 수 없습니다.");
			return "employee/teacher/teacherList";
		}
		
		return "redirect:/employee/teacherList";
		
	}
	
	// 선생님 등록 Get
	@GetMapping("/employee/addTeacher")
	public String addTeacher() {
		
		return "employee/teacher/addTeacher";
		
	}
	
	// 선생님 등록 Post
	@PostMapping("/employee/addTeacher")
	public String addTeacher(Model model, Teacher teacher) {
		
		String idCheck = idService.getIdCheck(teacher.getTeacherId());
		
		// idCheck -> null 아니면 사용 불가 
		if(idCheck != null) {
			
			model.addAttribute("errorMsg", "사용할 수 없는 ID 입니다.");
			return "employee/teacher/addTeacher";
			
		}
		
		int row = teacherService.addTeacher(teacher);
		if(row == 0) {
			
			model.addAttribute("errorMsg", "시스템 오류로 계정을 등록할 수 없습니다.");
			return "employee/teacher/addTeacher";
			
		}
		
		
		return "redirect:/employee/teacherList";
		
		
	}
	
	
	
	// 선생님 목록
	@GetMapping("/employee/teacherList")
	public String teacherList(Model model
								, @RequestParam(value = "currentPage", defaultValue = "1") int currentPage
								, @RequestParam(value = "rowPerPage", defaultValue = "10") int rowPerPage
								, @RequestParam(value = "searchWord", defaultValue = "") String searchWord) {
		
		List<Teacher> list = teacherService.getTeacherList(currentPage, rowPerPage, searchWord);
		model.addAttribute("list", list);
		
		HashMap<String, Object> hm = teacherService.getPage(currentPage, rowPerPage, searchWord);
		
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("searchWord", searchWord);
		model.addAttribute("previousPage", (int) hm.get("previousPage"));
		model.addAttribute("nextPage", (int) hm.get("nextPage"));
		model.addAttribute("lastPage", (int) hm.get("lastPage"));
		model.addAttribute("pageList", (ArrayList<Integer>) hm.get("pageList"));
		
		return "employee/teacher/teacherList";
		
	}
	
	
}
