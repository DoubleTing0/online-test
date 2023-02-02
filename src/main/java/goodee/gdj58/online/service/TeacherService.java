package goodee.gdj58.online.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import goodee.gdj58.online.mapper.TeacherMapper;
import goodee.gdj58.online.util.Page;
import goodee.gdj58.online.vo.Teacher;

@Service
@Transactional
public class TeacherService {

	@Autowired
	private TeacherMapper teacherMapper;
	
	// 선생님 삭제
	public int removeTeacher(int teacherNo) {
		
		return teacherMapper.deleteTeacher(teacherNo);
		
	}
	
	
	// 선생님 등록
	public int addTeacher(Teacher teacher) {
		
		return teacherMapper.insertTeacher(teacher);
		
	}
	
	
	// 선생님 목록
	public List<Teacher> getTeacherList(int currentPage, int rowPerPage, String searchWord) {
		
		int beginRow = Page.getBeginRow(currentPage, rowPerPage);
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("beginRow", beginRow);
		paramMap.put("rowPerPage", rowPerPage);
		paramMap.put("searchWord", searchWord);
		
		return teacherMapper.selectTeacherList(paramMap);
		
	}
	
	// 선생님 Page
	public HashMap<String, Object> getPage(int currentPage, int rowPerPage, String searchWord) {
		
		int pageLength = 10;
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("searchWord", searchWord);
		
		int count = teacherMapper.countTeacher(paramMap);
		
		int previousPage = Page.getPreviousPage(currentPage, pageLength);
		int nextPage = Page.getNextPage(currentPage, pageLength);
		int lastPage = Page.getLastPage(count, rowPerPage);
		ArrayList<Integer> pageList = Page.getPageList(currentPage, pageLength);
		
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("previousPage", previousPage);
		hm.put("nextPage", nextPage);
		hm.put("lastPage", lastPage);
		hm.put("pageList", pageList);
		
		return hm;
		
	}
	
	
	
	
}
