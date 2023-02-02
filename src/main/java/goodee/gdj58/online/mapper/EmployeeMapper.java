package goodee.gdj58.online.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import goodee.gdj58.online.vo.Employee;

@Mapper
public interface EmployeeMapper {

	// 사원 비밀번호 변경
	int updateEmployeePw(Map<String, Object> paramMap);
	
	// 사원 삭제
	int deleteEmployee(int empNo);
	
	// 사원 등록
	int insertEmployee(Employee employee);
	
	// 사원 목록
	List<Employee> selectEmployeeList(Map<String, Object> paramMap);
	
	// 사원 count
	int countEmployee(Map<String, Object> paramMap);
	
}

// 사실 하나의 파일에 추상메서드 와 쿼리가 같이 있지만 가독성을 위해 xml과 인터페이스로 나눈다. 

// public class EmployeeMapperClass implements EmployeeMapper {}  스프링이 자동으로 만드는 코드