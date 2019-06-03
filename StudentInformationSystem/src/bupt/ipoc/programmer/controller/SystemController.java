package bupt.ipoc.programmer.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import bupt.ipoc.programmer.entity.Student;
import bupt.ipoc.programmer.entity.User;
import bupt.ipoc.programmer.service.StudentService;
import bupt.ipoc.programmer.service.UserService;
import bupt.ipoc.programmer.util.CpachaUtil;


/**
 * 系统主页控制器
 * @author hy
 *
 */

@RequestMapping("/system")
@Controller
public class SystemController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value="/index")
	public ModelAndView index(ModelAndView model){
		model.setViewName("/system/index");
		return model;
	}
	
	/**
	 * 登陆页面
	 * @param model
	 * @return
	 */
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView login(ModelAndView model){
		System.out.println("来了来了");
		model.setViewName("/system/login");
		return model;
	}
	
	/**
	 * 登出页面
	 *
	 */
	@RequestMapping(value="/login_out",method=RequestMethod.GET)
	public String loginOut(HttpServletRequest req){
		req.getSession().removeAttribute("user");
		return "redirect:login";
	}
	
	
	/**
	 * 登陆表单提交
	 * @return
	 */
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> login(
			@RequestParam(value="username",required=true) String username,
			@RequestParam(value="password",required=true) String password,
			@RequestParam(value="vcode",required=true) String vcode,
			@RequestParam(value="type",required=true) String type,
			HttpServletRequest req
			){
		Map<String,String> ret = new HashMap<String,String>();
		
		if(StringUtils.isEmpty(username)){
			ret.put("type", "error");
			ret.put("msg", "用户名不能为空！");
			return ret;
		}
		
		if(StringUtils.isEmpty(password)){
			ret.put("type", "error");
			ret.put("msg", "密码不能为空！");
			return ret;
		}
		
		if(StringUtils.isEmpty(vcode)){
			ret.put("type", "error");
			ret.put("msg", "验证码不能为空！");
			return ret;
		}
		
		String loginCpacha = (String)req.getSession().getAttribute("loginCpacha");
		if(StringUtils.isEmpty(loginCpacha)){
			ret.put("type", "error");
			ret.put("msg", "长时间未操作，会话已失效，请刷新后重试！");
			return ret;
		}
		
		if(!vcode.toUpperCase().equals(loginCpacha.toUpperCase())){
			ret.put("type", "error");
			ret.put("msg", "验证码错误！");
			return ret;
		}
		
		if(StringUtils.isEmpty(type)){
			ret.put("type", "error");
			ret.put("msg", "请选择登陆身份！");
			return ret;
		}
		
		req.getSession().removeAttribute(loginCpacha);
		//从数据库中查询用户
		if(Integer.parseInt(type)==1){
			//管理员账号
			User user = userService.findByUserName(username);
			
			if(user==null){
				ret.put("type","error");
				ret.put("msg", "用户名不存在！");
				return ret;
			}
			if(!password.equals(user.getPassword())){
				ret.put("type","error");
				ret.put("msg", "密码错误！");
				return ret;
			}
			req.getSession().setAttribute("user", user);
		}
		if(Integer.parseInt(type)==2){
			//学生登录
			Student student = studentService.findByUserName(username);
			if(student==null){
				ret.put("type","error");
				ret.put("msg", "不存在该学生！");
				return ret;
			}
			if(!password.equals(student.getPassword())){
				ret.put("type","error");
				ret.put("msg", "密码错误！");
				return ret;
			}
			req.getSession().setAttribute("user", student);
		}
		
		req.getSession().setAttribute("userType", type);
		ret.put("type","success");
		ret.put("msg", "登陆成功！");
		return ret;
	}
	
	/**
	 * 显示认证码
	 * @param rep
	 * @param vl
	 * @param w
	 * @param h
	 * @param resp
	 */
	
	@RequestMapping(value="/get_cpacha",method=RequestMethod.GET)
	public void getCpacha(HttpServletRequest rep,
			@RequestParam(value="vl",defaultValue="4",required=false) Integer vl,
			@RequestParam(value="w",defaultValue="98",required=false) Integer w,
			@RequestParam(value="h",defaultValue="33",required=false) Integer h,
			HttpServletResponse resp){
		CpachaUtil cpachaUtil = new CpachaUtil(vl,w,h);
		String generatorVCode = cpachaUtil.generatorVCode();
		rep.getSession().setAttribute("loginCpacha", generatorVCode);
		BufferedImage generatorRotateVCodeImage = cpachaUtil.generatorRotateVCodeImage(generatorVCode, true);
		try {
			ImageIO.write(generatorRotateVCodeImage, "gif", resp.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
