package bupt.ipoc.programmer.entity;

import org.springframework.stereotype.Component;


/**
 * 年级实体
 * @author hy
 *
 */

@Component
public class Grade {
	private long id;
	private String name;
	private String remark;//备注
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
