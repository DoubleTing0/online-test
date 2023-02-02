package goodee.gdj58.online.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import goodee.gdj58.online.service.LoginService;
import goodee.gdj58.online.vo.Employee;
import goodee.gdj58.online.vo.Student;
import goodee.gdj58.online.vo.Teacher;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	
	
	// 학생 로그인 Post
	@PostMapping("/loginStudent")
	public String loginStudent(HttpSession session, Student student) {
		
		Student resultStudent = loginService.loginStudent(student);
		
		session.setAttribute("loginStudent", resultStudent);
		
		return "login";
	}
	
	// 선생님 로그인 Post
	@PostMapping("/loginTeacher")
	public String loginTeacher(HttpSession session, Teacher teacher) {
		
		Teacher resultTeacher = loginService.loginTeacher(teacher);
		
		session.setAttribute("loginTeacher", resultTeacher);
		
		return "login";
	}
	
	// 사원 로그인 Post
	@PostMapping("/loginEmp")
	public String loginEmp(HttpSession session, Employee emp) {
		
		Employee resultEmp = loginService.loginEmp(emp);

		session.setAttribute("loginEmp", resultEmp);
		
		return "login";
	}
	
	// 로그아웃 Get
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		return "redirect:/login";
		
	}
	
	// 로그인 Get
	@GetMapping("/login")
	public String login() {
		
		return "login";
	}
	
	// 로그인 Post
	@PostMapping("login")
	public String login(Model model, @RequestParam(value = "user", defaultValue = "employee") String user) {
		
		model.addAttribute("user", user);
		
		return "login";
		
	}
	
}
