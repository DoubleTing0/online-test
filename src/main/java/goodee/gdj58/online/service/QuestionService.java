package goodee.gdj58.online.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import goodee.gdj58.online.mapper.ExampleMapper;
import goodee.gdj58.online.mapper.QuestionMapper;
import goodee.gdj58.online.vo.Example;
import goodee.gdj58.online.vo.Question;

@Service
@Transactional
public class QuestionService {
	
	@Autowired
	private QuestionMapper questionMapper;
	
	@Autowired
	private ExampleMapper exampleMapper;
	
	// 문제 추가
	public int addQuestion(Map<String, Object> paramMap) {
		
		int resultRowQ = 0;
		int resultRowE = 0;
		int resultRow = 0;
		
		// 문제
		Question q = new Question();
		q.setTestNo((int) paramMap.get("testNo"));
		q.setQuestionIdx((int) paramMap.get("questionIdx"));
		q.setQuestionTitle((String) paramMap.get("questionTitle"));
		
		// 문제 추가
		resultRowQ = questionMapper.insertQuestion(q);
		
		// 추가한 문제의 questionNo 가져오기
		int questionNo = questionMapper.selectQuestionNo(q);
		
		Example e1 = new Example();
		e1.setQuestionNo(questionNo);
		e1.setExampleIdx(1);
		e1.setExampleTitle((String) paramMap.get("exampleTitle1"));
		e1.setAnswer((String) paramMap.get("answer1"));
		
		Example e2 = new Example();
		e2.setQuestionNo(questionNo);
		e2.setExampleIdx(2);
		e2.setExampleTitle((String) paramMap.get("exampleTitle2"));
		e2.setAnswer((String) paramMap.get("answer2"));
		
		Example e3 = new Example();
		e3.setQuestionNo(questionNo);
		e3.setExampleIdx(3);
		e3.setExampleTitle((String) paramMap.get("exampleTitle3"));
		e3.setAnswer((String) paramMap.get("answer3"));
		
		Example e4 = new Example();
		e4.setQuestionNo(questionNo);
		e4.setExampleIdx(4);
		e4.setExampleTitle((String) paramMap.get("exampleTitle4"));
		e4.setAnswer((String) paramMap.get("answer4"));
		
		// 보기 추가
			
		resultRowE = exampleMapper.insertExample(e1); 
		resultRowE += exampleMapper.insertExample(e2); 
		resultRowE += exampleMapper.insertExample(e3); 
		resultRowE += exampleMapper.insertExample(e4);
		
		if(resultRowQ == 1 && resultRowE == 4) {
			resultRow = 1;
		}
		
		return resultRow;
		
	}
	

}
