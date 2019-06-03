package bupt.ipoc.programmer.interceptor;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * ����������
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
		//System.out.println("������������url="+url);
		resp.setCharacterEncoding("utf-8");
			Object user = req.getSession().getAttribute("user");
		if(user==null){
			//��ʾδ��¼���ߵ�¼״̬ʧЧ
			System.out.println("δ��¼���ߵ�¼ʧЧ��url= "+url);
			if("XMLHttpRequest".equals(req.getHeader("X-Requested-With"))){
				//ajax����
				Map<String,String> ret = new HashMap<String,String>();
				ret.put("type", "error");
				ret.put("msg", "��¼��ʧЧ�������µ�¼��");
				resp.getWriter().write(JSONObject.fromObject(ret).toString());
				return false;
			}
	
			//��½ʧ�ܣ��ض��򵽵�¼ҳ��
			resp.sendRedirect(req.getContextPath()+"/system/login");
			return false;
		}
		return true;
	}

}
