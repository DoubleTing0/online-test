package goodee.gdj58.online.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import goodee.gdj58.online.vo.Paper;

@Mapper
public interface PaperMapper {

	
	// 학생이 본 시험의 정답 가져오기
	List<String> selectAnswerList(int testNo);
	
	// 학생이 본 시험 답 저장
	int insertPaper(Paper paper);
		
		
		
	
	
}
