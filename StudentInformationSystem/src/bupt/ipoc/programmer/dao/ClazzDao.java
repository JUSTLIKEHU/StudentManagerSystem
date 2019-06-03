package bupt.ipoc.programmer.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import bupt.ipoc.programmer.entity.Clazz;


/**
 * �༶dao
 * @author hy
 *
 */
@Repository
public interface ClazzDao {
	
	public int add(Clazz clazz);
	
	public List<Clazz> findList(Map<String, Object> queryMap);
	
	public List<Clazz> findAll();
	
	public int getTotal(Map<String, Object> queryMap);
	
	public int edit(Clazz clazz);
	
	public int delete(String string);
}
