package goodee.gdj58.online.mapper;

import org.apache.ibatis.annotations.Mapper;

import goodee.gdj58.online.vo.Question;

@Mapper
public interface QuestionMapper {
	
	// 문제 삭제
	int deleteQuestion(int questionNo);
	
	// 문제 수정
	int updateQuestion(Question question);
	
	// 문제 한개 출력
	Question selectQuestionOne(int questionNo);
	
	// 추가한 문제의 questionNo 가져오기
	int selectQuestionNo(Question question);
	
	// 문제 추가
	int insertQuestion(Question question);
	
}
