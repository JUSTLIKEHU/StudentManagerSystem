package bupt.ipoc.programmer.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import bupt.ipoc.programmer.entity.Grade;

/**
 * �꼶dao
 * @author hy
 *
 */
@Repository
public interface GradeDao {
	
	public int add(Grade grade);
	
	public List<Grade> findList(Map<String, Object> queryMap);
	
	public int getTotal(Map<String, Object> queryMap);
	
	public List<Grade> findAll();
	
	public int edit(Grade grade);
	
	public int delete(String string);
}
