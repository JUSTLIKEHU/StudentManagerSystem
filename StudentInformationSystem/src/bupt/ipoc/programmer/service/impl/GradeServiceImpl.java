package bupt.ipoc.programmer.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bupt.ipoc.programmer.dao.GradeDao;
import bupt.ipoc.programmer.entity.Grade;
import bupt.ipoc.programmer.service.GradeService;


@Service
public class GradeServiceImpl implements GradeService {

	@Autowired
	private GradeDao gradeDao;
	
	@Override
	public int add(Grade grade) {
		return gradeDao.add(grade);
	}

	@Override
	public List<Grade> findList(Map<String, Object> queryMap) {
		return gradeDao.findList(queryMap);
	}

	@Override
	public int getTotal(Map<String, Object> queryMap) {
		return gradeDao.getTotal(queryMap);
	}

	@Override
	public int edit(Grade grade) {
		return gradeDao.edit(grade);
	}

	@Override
	public int delete(String string) {
		return gradeDao.delete(string);
		
	}

	@Override
	public List<Grade> findAll() {
		// TODO Auto-generated method stub
		return gradeDao.findAll();
	}

}
