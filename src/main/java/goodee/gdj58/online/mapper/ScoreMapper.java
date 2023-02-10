package goodee.gdj58.online.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import goodee.gdj58.online.vo.Score;

@Mapper
public interface ScoreMapper {

	// 학생이 응시한 시험 점수 확인
	List<Map<String, Object>> selectScoreList(int studentNo);
	
	// 점수 추가
	int insertScore(Score score);
	
}
