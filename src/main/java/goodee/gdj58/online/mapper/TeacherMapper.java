package goodee.gdj58.online.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import goodee.gdj58.online.vo.Teacher;

@Mapper
public interface TeacherMapper {

	
	// hashmap test
	List<Map<String, Object>> getHashMap();
	
	
	// 선생님 비밀번호 변경
	int updateTeacherPw(Map<String, Object> paramMap);
	
	// 선생님 삭제
	int deleteTeacher(int teacherNo);
	
	// 선생님 등록
	int insertTeacher(Teacher teacher);
	
	// 선생님 목록
	List<Teacher> selectTeacherList(Map<String, Object> paramMap);
	
	// 선생님 count
	int countTeacher(Map<String, Object> paramMap);
	
	
	
}
