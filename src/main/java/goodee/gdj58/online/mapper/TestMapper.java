package goodee.gdj58.online.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import goodee.gdj58.online.vo.Test;

@Mapper
public interface TestMapper {

	
	// 시험 한개 문제&보기 출력(선생님)
	List<Map<String, Object>> selectTestOne(Map<String, Object> paramMap);
	
	// 시험 목록
	List<Test> selectTestList(Map<String, Object> paramMap);
	
}
