package goodee.gdj58.online.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import goodee.gdj58.online.mapper.TestMapper;
import goodee.gdj58.online.vo.Test;

@Service
@Transactional
public class TestService {

	@Autowired
	private TestMapper testMapper;
	
	// 학생 응시가능한 시험 목록
	public List<Test> getStudentTestList() {
		
		return testMapper.selectStudentTestList();		
		
	}
	
	// 시험 수정
	public int modifyTest(Test test) {
		
		return testMapper.updateTest(test);
		
	}
	
	// 시험 1개 보기(testTitle)
	public Test getTestTitle(int testNo) {
		
		return testMapper.selectTestTitle(testNo);
		
	}
	
	// 시험 등록
	public int addTest(Test test) {
		
		return testMapper.insertTest(test);
		
	}
	
	// 시험 한개 문제&보기 출력
	public List<Map<String, Object>> getTestOne(int testNo) {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("testNo", testNo);
		
		return testMapper.selectTestOne(paramMap);
		
	}
	
	// 시험 목록
	public List<Test> getTestList() {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		return testMapper.selectTestList(paramMap);
		
	}
	
}
