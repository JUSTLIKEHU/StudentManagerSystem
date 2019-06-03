package bupt.ipoc.programmer.interceptor;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 设置拦截器
 * @author hy
 *
 */

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp,
			Object arg2) throws Exception {
		String url = req.getRequestURI();
		//System.out.println("进入拦截器：url="+url);
		resp.setCharacterEncoding("utf-8");
			Object user = req.getSession().getAttribute("user");
		if(user==null){
			//表示未登录或者登录状态失效
			System.out.println("未登录或者登录失效，url= "+url);
			if("XMLHttpRequest".equals(req.getHeader("X-Requested-With"))){
				//ajax请求
				Map<String,String> ret = new HashMap<String,String>();
				ret.put("type", "error");
				ret.put("msg", "登录已失效，请重新登录！");
				resp.getWriter().write(JSONObject.fromObject(ret).toString());
				return false;
			}
	
			//登陆失败，重定向到登录页面
			resp.sendRedirect(req.getContextPath()+"/system/login");
			return false;
		}
		return true;
	}

}
