package goodee.gdj58.online.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import goodee.gdj58.online.mapper.LoginMapper;
import goodee.gdj58.online.vo.Employee;
import goodee.gdj58.online.vo.Student;
import goodee.gdj58.online.vo.Teacher;

@Service
@Transactional
public class LoginService {

	@Autowired
	private LoginMapper loginMapper;
	
	// 학생 로그인
	public Student loginStudent(Student student) {
		return loginMapper.loginStudent(student);
	}
	
	// 선생님 로그인
	public Teacher loginTeacher(Teacher teacher) {
		return loginMapper.loginTeacher(teacher);
	}
	
	// 사원 로그인
	public Employee loginEmp(Employee emp) {
		return loginMapper.loginEmp(emp);
	}
	
}
