package bupt.ipoc.programmer.service;

import java.util.List;
import java.util.Map;

import bupt.ipoc.programmer.entity.Grade;

public interface GradeService {

	
	public int add(Grade grade);
	
	public List<Grade> findList(Map<String, Object> queryMap);
	
	public List<Grade> findAll();
	
	public int getTotal(Map<String, Object> queryMap);
	
	public int edit(Grade grade);
	
	public int delete(String string);
}
