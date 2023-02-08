package goodee.gdj58.online.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import goodee.gdj58.online.mapper.PaperMapper;
import goodee.gdj58.online.mapper.QuestionMapper;
import goodee.gdj58.online.mapper.ScoreMapper;
import goodee.gdj58.online.vo.Paper;
import goodee.gdj58.online.vo.Score;

@Service
@Transactional
public class PaperService {
	
	@Autowired
	private PaperMapper paperMapper;
	
	@Autowired
	private QuestionMapper questionMapper;
	
	@Autowired
	private ScoreMapper scoreMapper;
	
	// 학생이 제출한 답 추가 & 채점 후 점수 등록
	public int addAndCheckPaper(Map<String, Object> paramMap) {
		
		int resultRow = 0;
		int resultRowP = 0;
		int resultRowS = 0;
		
		int testNo = (int) paramMap.get("testNo");
		int studentNo = (int) paramMap.get("studentNo");
		
		// 학생이 제출한 답안
		List<String> paperList = (List<String>) paramMap.get("paperList");
		
		List<String> answerList = paperMapper.selectAnswerList(testNo);
		
		// 해당 시험의 questionNo 리스트
		List<Integer> questionNoList = questionMapper.selectQuestionNoList(testNo);
		
		// 제출한 답 DB에 추가
		for(int i=0; i<paperList.size()/4; i+=1) {
			
			for(int j=0; j<4; j+=1) {
				
				if(paperList.get(j + (i * 4)).equals("정답")) {
					
					Paper p = new Paper();
					p.setStudentNo(studentNo);
					p.setQuestionNo(questionNoList.get(i));
					p.setAnswer(j+1);
					
					resultRowP = paperMapper.insertPaper(p);
				}
			}
		}
		
		int count = 0;	// 맞힌 문제 개수
		int check = 0;	// 보기 4개중 같은 정답/오답을 쓴 횟수
		
		// 채점
		// paperList와 answerList가 4개씩 동일하면 count
		for(int i=0; i<paperList.size(); i+=1) {
			
			if(paperList.get(i).equals(answerList.get(i))) {
				check += 1;
			}
			
			if((i + 1) % 4 == 0) {	// 4개 비교했을 때
				if(check == 4) {	// 4개 모두 같다면
					count += 1;	// 맞춘 문제 개수 카운트
				}
				check = 0;	// check 초기화
			}
			
		}
		
		// 최종 점수
		int score = count * (100 / (answerList.size() / 4)) ;
		
		Score resultScore = new Score();
		resultScore.setTestNo(testNo);
		resultScore.setStudentNo(studentNo);
		resultScore.setScore(score);
		
		// score DB에 저장
		resultRowS = scoreMapper.insertScore(resultScore);
		
		if(resultRowP == 1 && resultRowS == 1) {
			
			resultRow = 1;
			
		}
		
		return resultRow;
		
	}
	
	

}
