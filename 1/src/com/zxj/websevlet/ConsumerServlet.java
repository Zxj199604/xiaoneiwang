package com.zxj.websevlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zxj.dao.ConsumerDao;
import com.zxj.form.ConsumerForm;
import com.zxj.tool.Chinese;
import com.zxj.tool.SendMailToSomeone;

/**
 * Servlet implementation class ConsumerServlet
 */
public class ConsumerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int method;
	private ConsumerDao consumerDao = null;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsumerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		method=Integer.parseInt(request.getParameter("method"));
		if(method==0){
			//用户的登录验证操作
			checkConsumer(request, response);
		}
		if(method==1){
			//用户的注册
			registerConsumer(request, response);
		}
		if (method == 2) {
			queryConsumerForm(request, response);// 后台操作中，对一个普通用户进行查询
		}
		
		if (method == 3) {
			deleteConsumerForm(request, response);// 后台操作中，管理员对用户进行删除操作
		}

		if (method == 5) {
			updateConsumerHostForm(request, response); // 后台操作中，对个人信息的修改操作
		}
		//更改用户信息处理
		if(method==6){
			front_updateConsumerForm(request, response); // 前台操作中，用户对登录用进行修改
		}
		//用户用邮箱就行密码的找回
		if(method==7){
			this.findPassword(request, response);
		}
	}
	private void findPassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String account=request.getParameter("account");
		String email=request.getParameter("email");
		consumerDao =new	ConsumerDao();
		ConsumerForm consumerForm = consumerDao.getConsumerForm(account);
		if(consumerForm==null){
			out.print("<script language=javascript>alert('用户名不存在！');history.go(-1);</script>");
		}else if(!consumerForm.getEMail().equals(email)){
			out.print("<script language=javascript>alert('不是账户绑定的邮箱！');history.go(-1);</script>");
		}else{
			SendMailToSomeone someone=new SendMailToSomeone();
			if(someone.send("尊敬的"+consumerForm.getName(),"您的密码是:"+consumerForm.getPassword(),consumerForm.getEMail(), "zxj782819517@163.com", "zxj782819517", "smtp.163.com")){
				out
				.print("<script language=javascript>alert('密码已发送到你邮箱，请重新登录！');window.location.href='dealwith.jsp?sign=2';</script>");
			}else {
				out
				.print("<script language=javascript>alert('发送邮件失败，请重新发送！');history.go(-1);</script>");
			}
		
		}
	}

		// 前台操作中，用户对登录用进行修改
		public void front_updateConsumerForm(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			ConsumerForm form=new ConsumerForm();
			consumerDao = new ConsumerDao();
			form.setId(Integer.valueOf(request.getParameter("id")));
			form.setAccount(Chinese.toChinese(request.getParameter("account")));
			form.setPassword(Chinese.toChinese(request.getParameter("password")));
			form.setName(Chinese.toChinese(request.getParameter("name")));
			form.setSex(Chinese.toChinese(request.getParameter("sex")));
			form.setQQNumber(request.getParameter("QQnumber"));
			form.setPhoneNumber(request.getParameter("phonenumber"));
			form.setInterest(Chinese.toChinese(request.getParameter("interest")));
			form.setEMail(request.getParameter("eMail"));
			
			if (consumerDao.front_updateConsumerForm(form)) {
				out
				.print("<script language=javascript>alert('修改成功，请重新登录！');window.location.href='dealwith.jsp?sign=2';</script>");
			}else {
				out.print("<script language=javascript>alert('修改信息失败！');history.go(-1);</script>");
	}
			
		}
	
	
	
	// 用户登录操作
			public void checkConsumer(HttpServletRequest request,
					HttpServletResponse response) throws ServletException, IOException{
				request.setCharacterEncoding("utf-8");
				String account = request.getParameter("email");
				String password=request.getParameter("pwd");
				consumerDao =new	ConsumerDao();
				ConsumerForm consumerForm = consumerDao.getConsumerForm(account);
				if(consumerForm==null){
					request.setAttribute("information", "您输入的用户名不存在，请重新输入！");
				}else if(!consumerForm.getPassword().equals(password)){
					request.setAttribute("information", "您输入的登录密码有误，请重新输入！");
				}else{
					//登录成功，把用户的基本信息存入form中；
					request.setAttribute("form", consumerForm);
				}
				 request.getRequestDispatcher("dealwith.jsp").forward(request, response);
			}
			//用户注册操作
			public void registerConsumer(HttpServletRequest request,
					HttpServletResponse response) throws ServletException, IOException{
				request.setCharacterEncoding("utf-8");
				ConsumerForm form = new ConsumerForm();
				consumerDao = new ConsumerDao();
				form.setAccount(Chinese.toChinese(request.getParameter("account")));
				form.setPassword(Chinese.toChinese(request.getParameter("password")));
				form.setName(Chinese.toChinese(request.getParameter("name")));
				form.setSex(Chinese.toChinese(request.getParameter("sex")));
				form.setQQNumber(request.getParameter("QQnumber"));
				form.setPhoneNumber(request.getParameter("phonenumber"));
				form.setInterest(Chinese.toChinese(request.getParameter("interest")));
				form.setEMail(request.getParameter("eMail"));
				form.setManageLevel("普通");
				String result = "fail";
		//		System.out.println(form.getAccount());
				if (consumerDao.getConsumerForm(form.getAccount()) == null){
		//			System.out.println(form.getAccount());
					if (consumerDao.addConsumerForm(form)){
						request.setAttribute("form", consumerDao.getConsumerForm(form
								.getAccount()));
						result = "success";
					}
				}
				request.setAttribute("result", result);
				request.getRequestDispatcher("dealwith.jsp").forward(request, response);
			}
			// 后台操作中，对用户进行删除操作
			public void deleteConsumerForm(HttpServletRequest request,
					HttpServletResponse response) throws ServletException, IOException {
				response.setContentType("text/html;charset=utf-8");
				String account = Chinese.toChinese(request.getParameter("account"));
				consumerDao = new ConsumerDao();
				PrintWriter out = response.getWriter();
				if (consumerDao.deleteConsumerForm(account)) {
					out
							.print("<script language=javascript>alert('删除此用户成功，请重新进行查询！');window.location.href='back_consumerSelect.jsp';</script>");
				} else {
					out
							.print("<script language=javascript>alert('删除用户信息失败！');history.go(-1);</script>");
				}
			
			}
			// 后台操作中，对一个普通用户进行查询
			public void queryConsumerForm(HttpServletRequest request,
					HttpServletResponse response) throws ServletException, IOException {
				consumerDao = new ConsumerDao();
				String account = Chinese.toChinese(request.getParameter("account"));
				request.setAttribute("form2", consumerDao.getConsumerForm(account));
				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("back_consumerSelectForm.jsp");
				requestDispatcher.forward(request, response);
			}
			// 后台操作中，对个人信息的修改操作
			public void updateConsumerHostForm(HttpServletRequest request,
					HttpServletResponse response) throws ServletException, IOException {
				request.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				ConsumerForm form = new ConsumerForm();
				consumerDao = new ConsumerDao();
				form.setAccount(Chinese.toChinese(request.getParameter("account")));
				form.setPassword(Chinese.toChinese(request.getParameter("password")));
				form.setName(Chinese.toChinese(request.getParameter("name")));
				form.setSex(Chinese.toChinese(request.getParameter("sex")));
				form.setQQNumber(request.getParameter("QQnumber"));
				form.setPhoneNumber(request.getParameter("phoneNumber"));
				form.setInterest(Chinese.toChinese(request.getParameter("interest")));
				form.setEMail(request.getParameter("eMail"));
				form.setId(Integer.valueOf(request.getParameter("id")));
				if (consumerDao.updateConsumerForm(form)) {
					out
					.print("<script language=javascript>alert('修改成功，请重新登录！');window.location.href='/1/dealwith.jsp?sign=2';</script>");
				}else {
					out.print("<script language=javascript>alert('修改信息失败！');history.go(-1);</script>");
				}
			}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
