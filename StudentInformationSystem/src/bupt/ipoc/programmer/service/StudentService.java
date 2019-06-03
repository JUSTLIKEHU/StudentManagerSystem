package bupt.ipoc.programmer.service;

import java.util.List;
import java.util.Map;

import bupt.ipoc.programmer.entity.Student;

/**
 * ѧ��service
 * @author hy
 *
 */

public interface StudentService {

	public Student findByUserName(String username);
	
	public int add(Student student);
	
	public List<Student> findList(Map<String, Object> queryMap);
	
	public List<Student> findAll();
	
	public int getTotal(Map<String, Object> queryMap);
	
	public int edit(Student student);
	
	public int delete(String string);
}
