package bupt.ipoc.programmer.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import bupt.ipoc.programmer.entity.Student;


/**
 * ѧ��dao
 * @author hy
 *
 */
@Repository
public interface StudentDao {
	
	public Student findByUserName(String username);
	
	public int add(Student student);
	
	public List<Student> findList(Map<String, Object> queryMap);
	
	public List<Student> findAll();
	
	public int getTotal(Map<String, Object> queryMap);
	
	public int edit(Student student);
	
	public int delete(String string);
}
