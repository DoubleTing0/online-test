package goodee.gdj58.online.mapper;

import org.apache.ibatis.annotations.Mapper;

import goodee.gdj58.online.vo.Score;

@Mapper
public interface ScoreMapper {

	
	// 점수 추가
	int insertScore(Score score);
	
}
