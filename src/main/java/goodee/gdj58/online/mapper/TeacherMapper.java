package goodee.gdj58.online.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import goodee.gdj58.online.vo.Teacher;

@Mapper
public interface TeacherMapper {


	
	// 선생님 삭제
	int deleteTeacher(int teacherNo);
	
	// 선생님 등록
	int insertTeacher(Teacher teacher);
	
	// 선생님 목록
	List<Teacher> selectTeacherList(Map<String, Object> paramaMap);
	
	// 선생님 count
	int countTeacher();
	
	
	
}