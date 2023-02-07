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
	
	// 시험 한개 문제&보기 출력(선생님)
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
