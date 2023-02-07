package goodee.gdj58.online.mapper;

import org.apache.ibatis.annotations.Mapper;

import goodee.gdj58.online.vo.Example;

@Mapper
public interface ExampleMapper {
	
	// 보기 삭제
	int deleteExample(int exampleNo);
	
	// 보기 수정
	int updateExample(Example example);
	
	// 보기 한개 출력
	Example selectExampleOne(int exampleNo);
	
	// 보기 추가
	int insertExample(Example example);
	
}
