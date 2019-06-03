package bupt.ipoc.programmer.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bupt.ipoc.programmer.dao.StudentDao;
import bupt.ipoc.programmer.entity.Student;
import bupt.ipoc.programmer.service.StudentService;


@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;
	
	@Override
	public int add(Student student) {
		// TODO Auto-generated method stub
		return studentDao.add(student);
	}

	@Override
	public List<Student> findList(Map<String, Object> queryMap) {
		// TODO Auto-generated method stub
		return studentDao.findList(queryMap);
	}

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return studentDao.findAll();
	}

	@Override
	public int getTotal(Map<String, Object> queryMap) {
		// TODO Auto-generated method stub
		return studentDao.getTotal(queryMap);
	}

	@Override
	public int edit(Student student) {
		// TODO Auto-generated method stub
		return studentDao.edit(student);
	}

	@Override
	public int delete(String string) {
		// TODO Auto-generated method stub
		return studentDao.delete(string);
	}

	@Override
	public Student findByUserName(String username) {
		// TODO Auto-generated method stub
		return studentDao.findByUserName(username);
	}

}
