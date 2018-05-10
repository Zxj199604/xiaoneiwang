package com.zxj.websevlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zxj.dao.VoteDao;
import com.zxj.form.VoteForm;
import com.zxj.tool.Chinese;

/**
 * Servlet implementation class VoteServlet
 */
public class VoteServlet extends HttpServlet {
	private VoteDao voteDao = null;

	private int method;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoteServlet() {
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
			this.addVote(request, response);
		}
		if(method==1){
			this.deleteVote(request, response);
		}
	}
	// ��̨�����ͶƱ����
		public void addVote(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			VoteForm voteForm = new VoteForm();
			voteDao = new VoteDao();
			voteForm.setVoteName(Chinese
					.toChinese(request.getParameter("voteName")));
			voteForm.setVoteNumber(0);
			String result = "���ͶƱ����ʧ��!";
			if (voteDao.operationVote("���", voteForm)) {
				result = "���ͶƱ���ݳɹ�!";
				if(voteDao.deletevoted()){
					result=result+"�û����²���ͶƱ";
				}
			}
			request.setAttribute("result", result);
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("back_VoteAdd.jsp");
			requestDispatcher.forward(request, response);
		}
		// ��̨-ɾ��ͶƱ����
		public void deleteVote(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			VoteForm voteForm = new VoteForm();
			voteDao = new VoteDao();
			voteForm.setId(Integer.valueOf(request.getParameter("id")));
			if (voteDao.operationVote("ɾ��", voteForm)) {
				if(voteDao.deletevoted())
				out.print("<script language=javascript>alert('ɾ����ͶƱ���ݳɹ��������½��в�ѯ��');window.location.href='back_VoteSelect.jsp';</script>");
			} else {
				out.print("<script language=javascript>alert('ɾ����ͶƱ����ʧ�ܣ�');history.go(-1);</script>");
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
