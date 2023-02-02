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

import goodee.gdj58.online.service.EmployeeService;
import goodee.gdj58.online.service.IdService;
import goodee.gdj58.online.vo.Employee;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private IdService idService;
	
	// employee 비밀번호 변경 Get
	@GetMapping("/employee/modifyEmpPw")
	public String modifyEmpPw() {
		
		return "employee/modifyEmpPw";
		
	}
	
	// employee 비밀번호 변경 Post
	@PostMapping("/employee/modifyEmpPw")
	public String modifyEmpPw(HttpSession session, Model model
								, @RequestParam(value = "newPw") String newPw
								, @RequestParam(value = "oldPw", required = true) String oldPw) {	
								// required = true : null 값 불가 default 옵션
		
		Employee loginEmp = (Employee) session.getAttribute("loginEmp");
		
		int row = employeeService.updateEmployeePw(loginEmp.getEmpNo(), oldPw, newPw);

		if(row == 0) {
			// 변경 실패시
			model.addAttribute("errorMsg", "비밀번호를 변경할 수 없습니다.");
			return "employee/modifyEmpPw";
			
		}
		
		return "redirect:/logout";
		
		
	}
	
	// 삭제 Get
	@GetMapping("/employee/removeEmp")
	public String removeEmp(@RequestParam("empNo") int empNo) {
		
		employeeService.removeEmployee(empNo);
		
		return "redirect:/employee/empList";
		
	}
	
	// 사원 등록 GET
	@GetMapping("/employee/addEmp")
	public String addEmp() {
		
		return "employee/addEmp";	// forwarding
		
	}
	
	// 매개변수가 달라서 오버로딩
	// 사원 등록 POST
	@PostMapping("/employee/addEmp")
	public String addEmp(Model model, Employee employee) {
		// 여기 매개변수는 form에서 받아오는 정보와 같은 vo를 넣어야한다.(커맨드객체)
		// 없다면 form vo를 새로 만들면 된다. 이게 깔끔함.
		
		String idCheck = idService.getIdCheck(employee.getEmpId());
		
		if(idCheck != null) {
			System.out.println(idCheck + " <-- idCheck");
			model.addAttribute("errorMsg", "사용할 수 없는 ID 입니다.");
			return "employee/addEmp";
			
		}
		
		
		// row == 1  --> 성공
		int row = employeeService.addEmployee(employee);
		
		if(row == 0) {
			
			model.addAttribute("errorMsg", "시스템 오류로 계정을 등록할 수 없습니다.");
			return "employee/addEmp";
			
		}
		
		
		return "redirect:/employee/empList";
		// view 이름이 redirect: 으로 시작하면 forwarding 이 아닌 sendRedirect
	}
	
	
	
	
	// 리스트
	@GetMapping("/employee/empList")
	public String empList(Model model
							, @RequestParam(value = "currentPage", defaultValue = "1") int currentPage
							, @RequestParam(value = "rowPerPage", defaultValue = "10") int rowPerPage
							, @RequestParam(value = "searchWord", defaultValue ="") String searchWord) { 
								// @RequestParam(x) int y
								// int y = request.getParameter("x";)
		
		log.debug("\u001B[31m" + currentPage + " <-- currentPage");
		log.debug("\u001B[31m" + rowPerPage + " <-- rowPerPage");
		log.debug("\u001B[31m" + searchWord + " <-- searchWord");
		
		List<Employee> list = employeeService.getEmployeeList(currentPage, rowPerPage, searchWord);
		
		// request.setAttribute("list", list); 동일한 역할을 한다.
		model.addAttribute("list", list);
		
		HashMap<String, Object> hm = employeeService.getPage(currentPage, rowPerPage, searchWord);
		
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("searchWord", searchWord);
		model.addAttribute("previousPage", (int) hm.get("previousPage"));
		model.addAttribute("nextPage", (int) hm.get("nextPage"));
		model.addAttribute("lastPage", (int) hm.get("lastPage"));
		model.addAttribute("pageList", (ArrayList<Integer>) hm.get("pageList"));
				
		return "employee/empList";
	}
	
	
	
}
