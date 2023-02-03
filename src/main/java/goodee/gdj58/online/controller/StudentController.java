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
import goodee.gdj58.online.service.StudentService;
import goodee.gdj58.online.vo.Employee;
import goodee.gdj58.online.vo.Student;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private IdService idService;
	
	// 학생 비밀번호 변경 Get
	@GetMapping("/student/modifyStudentPw")
	public String modifyStudentPw() {
		
		return "student/modifyStudentPw";
		
	}
	
	// 학생 비밀번호 변경 Post
	@PostMapping("/student/modifyStudentPw")
	public String modifyStudentPw(HttpSession session, Model model
								, @RequestParam(value = "newPw") String newPw
								, @RequestParam(value = "oldPw", required = true) String oldPw) {	
								// required = true : null 값 불가 default 옵션
		
		Student loginStudent = (Student) session.getAttribute("loginStudent");
		
		int row = studentService.updateStudentPw(loginStudent.getStudentNo(), oldPw, newPw);

		if(row == 0) {
			// 변경 실패시
			model.addAttribute("errorMsg", "비밀번호를 변경할 수 없습니다.");
			return "student/modifyStudentPw";
			
		}
		
		return "redirect:/logout";
		
		
	}	
	
	// 학생 삭제 Get
	@GetMapping("employee/removeStudent")
	public String removeStudent(Model model
								, @RequestParam("studentNo") int studentNo) {
		
		int row = studentService.removeStudent(studentNo);
		if(row == 0) {
			// 삭제 실패하면
			model.addAttribute("errorMsg", "시스템 오류로 삭제 할 수 없습니다.");
			return "employee/student/studentList";
		}
		
		return "redirect:/employee/studentList";
		
	}
	
	// 학생 등록 Get
	@GetMapping("/employee/addStudent")
	public String addStudent() {
		
		return "employee/student/addStudent";
		
	}
	
	// 학생 등록 Post
	@PostMapping("/employee/addStudent")
	public String addStudent(Model model, Student student) {
		
		String idCheck = idService.getIdCheck(student.getStudentId());
		
		// idCheck null이 아니라면 가입 불가
		if(idCheck != null) {
			
			model.addAttribute("errorMsg", "사용할 수 없는 ID 입니다.");
			return "employee/student/addStudent";
			
		}
		
		int row = studentService.addStudent(student);
		if(row == 0) {
			model.addAttribute("errorMsg", "시스템 오류로 계정을 등록할 수 없습니다.");
			return "employee/student/addStudent";
		}
		
		return "redirect:/employee/studentList";
		
		
	}
	
	
	
	// 학생 목록
	@GetMapping("/employee/studentList")
	public String studentList(Model model
								, @RequestParam(value = "currentPage", defaultValue = "1") int currentPage
								, @RequestParam(value = "rowPerPage", defaultValue = "10") int rowPerPage
								, @RequestParam(value = "searchWord", defaultValue = "") String searchWord) {

		
		List<Student> list = studentService.getStudentList(currentPage, rowPerPage, searchWord);
		model.addAttribute("list", list);
		
		HashMap<String, Object> hm = studentService.getPage(currentPage, rowPerPage, searchWord);
		
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("searchWord", searchWord);
		model.addAttribute("previousPage", (int) hm.get("previousPage"));
		model.addAttribute("nextPage", (int) hm.get("nextPage"));
		model.addAttribute("lastPage", (int) hm.get("lastPage"));
		model.addAttribute("pageList", (ArrayList<Integer>) hm.get("pageList"));
		
		return "employee/student/studentList";
		
	}
	
}
