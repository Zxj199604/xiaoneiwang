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
			//�û��ĵ�¼��֤����
			checkConsumer(request, response);
		}
		if(method==1){
			//�û���ע��
			registerConsumer(request, response);
		}
		if (method == 2) {
			queryConsumerForm(request, response);// ��̨�����У���һ����ͨ�û����в�ѯ
		}
		
		if (method == 3) {
			deleteConsumerForm(request, response);// ��̨�����У�����Ա���û�����ɾ������
		}

		if (method == 5) {
			updateConsumerHostForm(request, response); // ��̨�����У��Ը�����Ϣ���޸Ĳ���
		}
		//�����û���Ϣ����
		if(method==6){
			front_updateConsumerForm(request, response); // ǰ̨�����У��û��Ե�¼�ý����޸�
		}
		//�û����������������һ�
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
			out.print("<script language=javascript>alert('�û��������ڣ�');history.go(-1);</script>");
		}else if(!consumerForm.getEMail().equals(email)){
			out.print("<script language=javascript>alert('�����˻��󶨵����䣡');history.go(-1);</script>");
		}else{
			SendMailToSomeone someone=new SendMailToSomeone();
			if(someone.send("�𾴵�"+consumerForm.getName(),"����������:"+consumerForm.getPassword(),consumerForm.getEMail(), "zxj782819517@163.com", "zxj782819517", "smtp.163.com")){
				out
				.print("<script language=javascript>alert('�����ѷ��͵������䣬�����µ�¼��');window.location.href='dealwith.jsp?sign=2';</script>");
			}else {
				out
				.print("<script language=javascript>alert('�����ʼ�ʧ�ܣ������·��ͣ�');history.go(-1);</script>");
			}
		
		}
	}

		// ǰ̨�����У��û��Ե�¼�ý����޸�
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
				.print("<script language=javascript>alert('�޸ĳɹ��������µ�¼��');window.location.href='dealwith.jsp?sign=2';</script>");
			}else {
				out.print("<script language=javascript>alert('�޸���Ϣʧ�ܣ�');history.go(-1);</script>");
	}
			
		}
	
	
	
	// �û���¼����
			public void checkConsumer(HttpServletRequest request,
					HttpServletResponse response) throws ServletException, IOException{
				request.setCharacterEncoding("utf-8");
				String account = request.getParameter("email");
				String password=request.getParameter("pwd");
				consumerDao =new	ConsumerDao();
				ConsumerForm consumerForm = consumerDao.getConsumerForm(account);
				if(consumerForm==null){
					request.setAttribute("information", "��������û��������ڣ����������룡");
				}else if(!consumerForm.getPassword().equals(password)){
					request.setAttribute("information", "������ĵ�¼�����������������룡");
				}else{
					//��¼�ɹ������û��Ļ�����Ϣ����form�У�
					request.setAttribute("form", consumerForm);
				}
				 request.getRequestDispatcher("dealwith.jsp").forward(request, response);
			}
			//�û�ע�����
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
				form.setManageLevel("��ͨ");
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
			// ��̨�����У����û�����ɾ������
			public void deleteConsumerForm(HttpServletRequest request,
					HttpServletResponse response) throws ServletException, IOException {
				response.setContentType("text/html;charset=utf-8");
				String account = Chinese.toChinese(request.getParameter("account"));
				consumerDao = new ConsumerDao();
				PrintWriter out = response.getWriter();
				if (consumerDao.deleteConsumerForm(account)) {
					out
							.print("<script language=javascript>alert('ɾ�����û��ɹ��������½��в�ѯ��');window.location.href='back_consumerSelect.jsp';</script>");
				} else {
					out
							.print("<script language=javascript>alert('ɾ���û���Ϣʧ�ܣ�');history.go(-1);</script>");
				}
			
			}
			// ��̨�����У���һ����ͨ�û����в�ѯ
			public void queryConsumerForm(HttpServletRequest request,
					HttpServletResponse response) throws ServletException, IOException {
				consumerDao = new ConsumerDao();
				String account = Chinese.toChinese(request.getParameter("account"));
				request.setAttribute("form2", consumerDao.getConsumerForm(account));
				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("back_consumerSelectForm.jsp");
				requestDispatcher.forward(request, response);
			}
			// ��̨�����У��Ը�����Ϣ���޸Ĳ���
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
					.print("<script language=javascript>alert('�޸ĳɹ��������µ�¼��');window.location.href='/1/dealwith.jsp?sign=2';</script>");
				}else {
					out.print("<script language=javascript>alert('�޸���Ϣʧ�ܣ�');history.go(-1);</script>");
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
