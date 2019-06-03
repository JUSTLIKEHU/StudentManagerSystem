package bupt.ipoc.programmer.service;

import java.util.List;
import java.util.Map;

import bupt.ipoc.programmer.entity.Clazz;

public interface ClazzService {

	
	public int add(Clazz clazz);
	
	public List<Clazz> findList(Map<String, Object> queryMap);
	
	public List<Clazz> findAll();
	
	public int getTotal(Map<String, Object> queryMap);
	
	public int edit(Clazz clazz);
	
	public int delete(String string);
}
