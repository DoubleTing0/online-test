package goodee.gdj58.online.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import goodee.gdj58.online.vo.Student;

@Mapper
public interface StudentMapper {
	
	// 학생 삭제
	int deleteStudent(int studetnNo);

	// 학생 등록
	int insertStudent(Student student);
	
	// 학생 목록
	List<Student> selectStudentList(Map<String, Object> paramMap);
	
	// 학생 count
	int countStudent();
	
}
