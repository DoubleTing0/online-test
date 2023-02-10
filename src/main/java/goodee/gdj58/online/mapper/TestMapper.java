package goodee.gdj58.online.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import goodee.gdj58.online.vo.Test;

@Mapper
public interface TestMapper {

	// 학생 응시가능한 시험 목록
	List<Test> selectStudentTestList(int studentNo);
	
	// 시험 수정
	int updateTest(Test test);
	
	// 시험 한개 보기(testTitle 보기)
	Test selectTestTitle(int testNo);
	
	// 시험 등록
	int insertTest(Test test);
	
	// 시험 한개 문제&보기 출력
	List<Map<String, Object>> selectTestOne(Map<String, Object> paramMap);
	
	// 시험 목록
	List<Test> selectTestList(Map<String, Object> paramMap);
	
}
