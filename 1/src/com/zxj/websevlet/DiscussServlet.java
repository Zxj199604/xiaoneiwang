package com.zxj.websevlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zxj.dao.DiscussDao;
import com.zxj.form.DiscussForm;
import com.zxj.tool.Chinese;

/**
 * Servlet implementation class DiscussServlet
 */
public class DiscussServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int method;

	private DiscussDao disussDao = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DiscussServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.method = Integer.parseInt(request.getParameter("method"));
		if (method == 0) {
			this.addDisuss(request, response);// 后台，添加公告内容
		}
		if (method == 1) {
			this.deleteDisuss(request, response);// 后台， 删除公告内容
		}
		if (method == 2) {
			this.updateDisuss(request, response);//	后台， 修改公告内容
		}
	}
	// 后台，添加评论内容
			public void addDisuss(HttpServletRequest request,
					HttpServletResponse response) throws ServletException, IOException {
				response.setContentType("text/html;charset=utf-8");
				DiscussForm disussForm = new DiscussForm();
				disussDao = new DiscussDao();
				disussForm.setDiscussTitle(Chinese.toChinese(request
						.getParameter("discussTitle")));
				disussForm.setDiscussContent(Chinese.toChinese(request
						.getParameter("discussContent")));
				disussForm.setDiscussTime(Chinese.toChinese(request
						.getParameter("discussTime")));
				String result = "添加公告失败！";
				if (disussDao.operationDiscuss("添加", disussForm)) {
					result = "添加公告成功！";
				}
				request.setAttribute("result", result);
				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("back_DiscussAdd.jsp");
				requestDispatcher.forward(request, response);

			}
			//后台， 删除评论内容
			public void deleteDisuss(HttpServletRequest request,
					HttpServletResponse response) throws ServletException, IOException {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				DiscussForm disussForm = new DiscussForm();
				disussDao = new DiscussDao();
				disussForm.setId(Integer.valueOf(request.getParameter("id")));
				if (disussDao.operationDiscuss("删除", disussForm)) {
					out
							.print("<script language=javascript>alert('删除公告信息成功！');window.location.href='back_DiscussSelect.jsp';</script>");
				} else {
					out
							.print("<script language=javascript>alert('删除公告信息失败！');history.go(-1);</script>");
				}
			}
		//	后台， 修改评论内容
			public void updateDisuss(HttpServletRequest request,
					HttpServletResponse response) throws ServletException, IOException {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				DiscussForm disussForm = new DiscussForm();
				disussDao = new DiscussDao();
				disussForm.setId(Integer.valueOf(request.getParameter("id")));
				disussForm.setDiscussTitle(Chinese.toChinese(request
						.getParameter("discussTitle")));
				disussForm.setDiscussContent(Chinese.toChinese(request
						.getParameter("discussContent")));
				if (disussDao.operationDiscuss("修改", disussForm)) {
					out
							.print("<script language=javascript>alert('修改公告信息成功！');window.location.href='back_DiscussSelect.jsp';</script>");
				} else {
					out
							.print("<script language=javascript>alert('修改公告信息失败！');history.go(-1);</script>");
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
