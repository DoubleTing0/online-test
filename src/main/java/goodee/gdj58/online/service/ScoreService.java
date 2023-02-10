package goodee.gdj58.online.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import goodee.gdj58.online.mapper.ScoreMapper;

@Service
@Transactional
public class ScoreService {

	@Autowired
	private ScoreMapper scoreMapper;
	
	// 학생이 응시한 시험 점수 확인
	public List<Map<String, Object>> getScoreList(int studentNo) {
		
		return scoreMapper.selectScoreList(studentNo);
		
	}
	
	
}
