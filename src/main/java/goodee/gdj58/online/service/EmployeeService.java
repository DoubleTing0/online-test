package goodee.gdj58.online.service;

import java.util.ArrayList;
import java.util.HashMap;	
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import goodee.gdj58.online.mapper.EmployeeMapper;
import goodee.gdj58.online.util.Page;
import goodee.gdj58.online.vo.Employee;

@Service
@Transactional	// 트랜젝션을 DB가 아닌 스프링에서 처리한다.(commit, rollback 처리했던게 트랜젝션)
public class EmployeeService {
	// DI = new Employeemapper()
	@Autowired
	private EmployeeMapper employeeMapper;
	
	public int updateEmployeePw(int empNo, String oldPw, String newPw) {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("empNo", empNo);
		paramMap.put("oldPw", oldPw);
		paramMap.put("newPw", newPw);
		
		return employeeMapper.updateEmployeePw(paramMap);
		
	}
	
	
	public Employee login(Employee emp) {
		return employeeMapper.login(emp);
	}
	
	public int removeEmployee(int empNo) {
		return employeeMapper.deleteEmployee(empNo);
	}
	
	public int addEmployee(Employee employee) {
		
		return employeeMapper.insertEmployee(employee);
		
	}
	
	
	// 디펜던시 인젝션 : 스프링이 전체를 스캔해서 employeeMapper 찾아 bean 객체를 이용해 매칭시켜줌
	// Autowired 애노테이션 없으면 employeeMapper 가 null 이 되고, 메서드 호출하면 nullPointException 발생.
	public List<Employee> getEmployeeList(int currentPage, int rowPerPage) {
	
		int beginRow = Page.getBeginRow(currentPage, rowPerPage);
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("beginRow", beginRow);
		paramMap.put("rowPerPage", rowPerPage);
		
		return employeeMapper.selectEmployeeList(paramMap);
		
	}
	
	// 사원 page
	public HashMap<String, Object> getPage(int currentPage, int rowPerPage) {
		
		int pageLength = 10;
		
		int count = employeeMapper.countEmployee();
		
		int previousPage = Page.getPreviousPage(currentPage, pageLength);
		int nextPage = Page.getNextPage(currentPage, pageLength);
		int lastPage = Page.getLastPage(count, rowPerPage);
		ArrayList<Integer> pageList = Page.getPageList(currentPage, pageLength);
		
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("previousPage", previousPage);
		hm.put("nextPage", nextPage);
		hm.put("lastPage", lastPage);
		hm.put("pageList", pageList);
		
		return hm;
		
	}	
	
	
	
	
}
