package bupt.ipoc.programmer.service;

import java.util.List;
import java.util.Map;

import bupt.ipoc.programmer.entity.User;


public interface UserService {
	
	public User findByUserName(String username);
	
	public int add(User user);
	
	public List<User> findList(Map<String, Object> queryMap);
	
	public int getTotal(Map<String, Object> queryMap);
	
	public int edit(User user);
	
	public int delete(String string);
}
