package bupt.ipoc.programmer.util;

import java.util.Date;

public class StringUtil {
	
	public static String generateSn(String prefix,String suffix){
		return prefix+new Date().getTime()+suffix;
	}
	
}
