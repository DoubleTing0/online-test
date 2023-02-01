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
	
	// 학생 삭제 Get
	@GetMapping("student/removeStudent")
	public String removeStudent(HttpSession session, Model model
								, @RequestParam("studentNo") int studentNo) {
		
		Employee loginEmp = (Employee) session.getAttribute("loginEmp");
		if(loginEmp == null) {
			return "redirect:/employee/loginEmp";
		}
		
		int row = studentService.removeStudent(studentNo);
		if(row == 0) {
			// 삭제 실패하면
			model.addAttribute("errorMsg", "시스템 오류로 삭제 할 수 없습니다.");
			return "student/studentList";
		}
		
		return "redirect:/student/studentList";
		
	}
	
	// 학생 등록 Get
	@GetMapping("/student/addStudent")
	public String addStudent(HttpSession session) {
		
		Employee loginEmp = (Employee) session.getAttribute("loginEmp");
		if(loginEmp == null) {
			return "redirect:/employee/loginEmp";
		}
		
		return "student/addStudent";
		
	}
	
	// 학생 등록 Post
	@PostMapping("/student/addStudent")
	public String addStudent(HttpSession session, Model model, Student student) {
		
		Employee loginEmp = (Employee) session.getAttribute("loginEmp");
		if(loginEmp == null) {
			return "redirect:/employee/loginEmp";
		}
		
		String idCheck = idService.getIdCheck(student.getStudentId());
		
		// idCheck null이 아니라면 가입 불가
		if(idCheck != null) {
			
			model.addAttribute("errorMsg", "사용할 수 없는 ID 입니다.");
			return "student/addStudent";
			
		}
		
		int row = studentService.addStudent(student);
		if(row == 0) {
			model.addAttribute("errorMsg", "시스템 오류로 계정을 등록할 수 없습니다.");
			return "student/addStudent";
		}
		
		return "redirect:/student/studentList";
		
		
	}
	
	
	
	// 학생 목록
	@GetMapping("/student/studentList")
	public String studentList(HttpSession session, Model model
								, @RequestParam(value = "currentPage", defaultValue = "1") int currentPage
								, @RequestParam(value = "rowPerPage", defaultValue = "10") int rowPerPage) {

		Employee loginEmp = (Employee) session.getAttribute("loginEmp");
		if(loginEmp == null) {
			return "redirect:/employee/loginEmp";
		}
		
		List<Student> list = studentService.getStudentList(currentPage, rowPerPage);
		model.addAttribute("list", list);
		
		HashMap<String, Object> hm = studentService.getPage(currentPage, rowPerPage);
		
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("previousPage", (int) hm.get("previousPage"));
		model.addAttribute("nextPage", (int) hm.get("nextPage"));
		model.addAttribute("lastPage", (int) hm.get("lastPage"));
		model.addAttribute("pageList", (ArrayList<Integer>) hm.get("pageList"));
		
		return "student/studentList";
		
	}
	
}