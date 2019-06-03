package bupt.ipoc.programmer.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bupt.ipoc.programmer.dao.ClazzDao;
import bupt.ipoc.programmer.entity.Clazz;
import bupt.ipoc.programmer.service.ClazzService;


@Service
public class ClazzServiceImpl implements ClazzService {

	@Autowired
	private ClazzDao clazzDao;

	@Override
	public int add(Clazz clazz) {
		// TODO Auto-generated method stub
		return clazzDao.add(clazz);
	}

	@Override
	public List<Clazz> findList(Map<String, Object> queryMap) {
		// TODO Auto-generated method stub
		return clazzDao.findList(queryMap);
	}

	@Override
	public List<Clazz> findAll() {
		// TODO Auto-generated method stub
		return clazzDao.findAll();
	}

	@Override
	public int getTotal(Map<String, Object> queryMap) {
		// TODO Auto-generated method stub
		return clazzDao.getTotal(queryMap);
	}

	@Override
	public int edit(Clazz clazz) {
		// TODO Auto-generated method stub
		return clazzDao.edit(clazz);
	}

	@Override
	public int delete(String string) {
		// TODO Auto-generated method stub
		return clazzDao.delete(string);
	}
	
	

}
