package com.zxj.websevlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zxj.dao.FriendDao;
import com.zxj.form.FriendForm;
import com.zxj.tool.Chinese;

/**
 * Servlet implementation class FriendServlet
 */
public class FriendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FriendDao friendDao = null;

	private int method; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FriendServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		method = Integer.parseInt(request.getParameter("method"));
		if (method == 0) {
			this.addFriend(request, response);// ���������Ϣ
		}
		if (method == 1) {
			this.deleteFriend(request, response);// ɾ��������Ϣ
		}
		if (method == 2) {
			this.queryFriendForm(request, response); // �����ݿ�IDΪ��������ѯһ����Ϣ
		}
		if (method == 3) {
			this.updateFriend(request, response); // �����ݿ�IDΪ����������һ����Ϣ
		}
	}
	// ���������Ϣ
		public void addFriend(HttpServletRequest request,
				HttpServletResponse response) throws IOException, ServletException {
			friendDao = new FriendDao();
			FriendForm friendForm = new FriendForm();
			friendForm.setName(Chinese.toChinese(request.getParameter("name")));
			friendForm.setQQNumber(request.getParameter("QQNumber"));
			friendForm.setDescription(Chinese.toChinese(request
					.getParameter("description")));
			String result = "��Ӻ���ʧ�ܣ�";
			if (friendDao.addFriend(friendForm)) {
				result = "��Ӻ��ѳɹ���";
			}
			request.setAttribute("result", result);
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("back_FriendAdd.jsp");
			requestDispatcher.forward(request, response);

		}
		// ɾ��������Ϣ
		public void deleteFriend(HttpServletRequest request,
				HttpServletResponse response) throws IOException, ServletException {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			friendDao = new FriendDao();
			Integer id = Integer.valueOf(request.getParameter("id"));
			if (friendDao.deleteFriend(id)) {
				out.print("<script language=javascript>alert('ɾ����������Ϣ�ɹ��������½��в�ѯ��');window.location.href='back_FriendSelect.jsp';</script>");
			} else {
				out.print("<script language=javascript>alert('ɾ��������Ϣʧ�ܣ�');history.go(-1);</script>");
			}

		}
		// �����ݿ�IDΪ��������ѯһ����Ϣ
		public void queryFriendForm(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			friendDao = new FriendDao();
			request.setAttribute("form1", friendDao.queryFriendForm(request
					.getParameter("id")));

			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("back_FriendUpdate.jsp");
			requestDispatcher.forward(request, response);

		}
		// �����ݿ�IDΪ�������޸�һ����Ϣ
		public void updateFriend(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			friendDao = new FriendDao();
			FriendForm friendForm = new FriendForm();
			friendForm.setId(Integer.valueOf(request.getParameter("id")));
			friendForm.setName(Chinese.toChinese(request.getParameter("name")));
			friendForm.setQQNumber(request.getParameter("QQNumber"));
			friendForm.setDescription(Chinese.toChinese(request
					.getParameter("description")));
			if (friendDao.updateFriend(friendForm)) {
				out.print("<script language=javascript>alert('�޸Ĵ�������Ϣ�ɹ��������½��в�ѯ��');window.location.href='back_FriendSelect.jsp';</script>");
			} else {
				out.print("<script language=javascript>alert('�޸�������Ϣʧ�ܣ�');history.go(-1);</script>");
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
