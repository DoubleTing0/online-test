package goodee.gdj58.online.mapper;

import org.apache.ibatis.annotations.Mapper;

import goodee.gdj58.online.vo.Employee;
import goodee.gdj58.online.vo.Student;
import goodee.gdj58.online.vo.Teacher;

@Mapper
public interface LoginMapper {

	
	// 학생 로그인
	Student loginStudent(Student student);
	
	// 선생님 로그인
	Teacher loginTeacher(Teacher teacher);
	
	// 사원 로그인
	Employee loginEmp(Employee employee);
	
}
