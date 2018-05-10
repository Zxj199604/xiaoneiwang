package com.zxj.websevlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.zxj.dao.*;
import com.zxj.form.*;
import com.zxj.tool.Chinese;

/**
 * Servlet implementation class ArticleServlet
 */
public class ArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int method = Integer.parseInt(request.getParameter("method"));
		//����������Ӵ���
		if(method==0){
			this.addArticleType(request, response);
		}
		//��������ɾ������
		if (method == 1) {
			this.deleteArticleType(request, response);
		}
		//�����̨���ӵ�������
		if(method==2){
			this.addArticle(request, response);
		}
		//��̨�����µ�ɾ��
		if(method==3){
			this.deleteArticle(request, response);
		}
		//�����޸Ľ��д���
		if(method==4){
			this.updateArticle(request, response);
		}
		//�����̨ɾ�����»ظ�����Ӧ����
		if(method == 6){
			this.deleteRestore(request, response);
		}
		//�����û��ظ����µ�����
		if (method == 7) {
			this.HeadAddRestore(request, response);
		}
		
		
		
		
		
		//�û����Լ������½���ɾ���ķ���
		if(method==8){
			this.deleteArticle1(request, response);
		}
		//�û����Լ������½������ӵķ���
		if(method==9){
			this.addArticle1(request, response);
		}
		//�û����Լ��ظ���Ϣ��ɾ��
		if(method==10){
			this.deleteRestore1(request,response);
		}
	}
	//��ӻظ�
	public void HeadAddRestore(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		RestoreDao restoreDao = new RestoreDao();
		RestoreForm restoreForm = new RestoreForm();
		restoreForm.setArticleId(Integer.valueOf(request.getParameter("articleId")));
		restoreForm.setReAccount(request.getParameter("accountId"));
		restoreForm.setReTitle(Chinese.toChinese(request.getParameter("reTitle")));
		restoreForm.setReContent(Chinese.toChinese(request.getParameter("reContent")));
		if (restoreDao.operationRestore("���", restoreForm)) {
			out.print("<script language=javascript>alert('��ӻظ���Ϣ�ɹ��������²�ѯ��');window.location.href='head_ArticleForm.jsp?id="+request.getParameter("articleId")+"';</script>");
		} else {
			out.print("<script language=javascript>alert('��ӻظ���Ϣʧ�ܣ�');history.go(-1);</script>");
		}
	
	}
	//��̨�����»ظ����ݽ���ɾ��
	public void deleteRestore(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		RestoreDao restoreDao = new RestoreDao();
		RestoreForm restoreForm = new RestoreForm();
		restoreForm.setId(Integer.valueOf(request.getParameter("id")));
	
		if (restoreDao.operationRestore("ɾ��", restoreForm)) {
			out
					.print("<script language=javascript>alert('ɾ���ظ��ɹ��������²�ѯ��');window.location.href='back_RestoreSelect.jsp?id="
							+ request.getParameter("idd") + "';</script>");
		} else {
			out
					.print("<script language=javascript>alert('ɾ���ظ�ʧ�ܣ�');history.go(-1);</script>");
		}

	}
	
	public void deleteRestore1(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		RestoreDao restoreDao = new RestoreDao();
		RestoreForm restoreForm = new RestoreForm();
		restoreForm.setId(Integer.valueOf(request.getParameter("id")));
		if (restoreDao.operationRestore("ɾ��", restoreForm)) {
			out
			.print("<script language=javascript>alert('ɾ���ظ��ɹ��������²�ѯ��');window.location.href='back_RestoreSelect1.jsp'</script>");
			} else {
				out
						.print("<script language=javascript>alert('ɾ���ظ�ʧ�ܣ�');history.go(-1);</script>");
			}
	}

	
	
	
	
	// ��̨�������
	public void addArticle(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ArticleForm articleForm = new ArticleForm();
		articleForm.setTypeId(Integer.valueOf(request.getParameter("typeId")));
		articleForm.setTitle(Chinese.toChinese(request.getParameter("title")));
		articleForm.setNumber(Integer.valueOf(request.getParameter("number")));
		articleForm.setContent(Chinese.toChinese(request
				.getParameter("content")));
		articleForm
				.setPhTime(Chinese.toChinese(request.getParameter("phTime")));
		articleForm.setAccountId(Chinese.toChinese(request.getParameter("accountId")));
		ArticleDao articleDao = new ArticleDao();
		String result = "�������ʧ�ܣ�";
		if (articleDao.operationArticle("���", articleForm)) {
			result = "������ӳɹ���";
		}
		request.setAttribute("result", result);
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("back_ArticleAdd.jsp");
		requestDispatcher.forward(request, response);
	}
	//��̨���µ�ɾ��
	public void deleteArticle(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int id =Integer.valueOf(request.getParameter("id"));
		RestoreDao restoreDao=new RestoreDao();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if(!restoreDao.queryRestore(id).isEmpty()){
			out.print("<script language=javascript>alert('����ɾ�������µ���ػظ�');window.location.href='back_ArticleSelect.jsp';</script>");
		}else{
					ArticleForm articleForm = new ArticleForm();
					articleForm.setId(Integer.valueOf(request.getParameter("id")));
					ArticleDao articleDao = new ArticleDao();
					if (articleDao.operationArticle("ɾ��", articleForm)) {
						out
								.print("<script language=javascript>alert('ɾ�����³ɹ��������²�ѯ��');window.location.href='back_ArticleSelect.jsp';</script>");
					} else {
						out
								.print("<script language=javascript>alert('ɾ������ʧ�ܣ�');history.go(-1);</script>");
					}
		}
	}
//��̨�޸����¸���
	public void updateArticle(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		ArticleForm articleForm = new ArticleForm();
		articleForm.setId(Integer.valueOf(request.getParameter("id")));
		articleForm.setTypeId(Integer.valueOf(request.getParameter("typeId")));
		articleForm.setTitle(Chinese.toChinese(request.getParameter("title")));
		articleForm.setContent(Chinese.toChinese(request
				.getParameter("content")));
		ArticleDao articleDao = new ArticleDao();
		if (articleDao.operationArticle("�޸�", articleForm)) {
			
			out
					.print("<script language=javascript>alert('�޸����³ɹ��������²�ѯ��');window.location.href='back_ArticleSelect.jsp';</script>");
		} else {
			out
					.print("<script language=javascript>alert('�޸�����ʧ�ܣ�');history.go(-1);</script>");
		}
	}
	// ��̨ɾ���������
		public void deleteArticleType(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			ArticleTypeForm ArticleTypeForm = new ArticleTypeForm();
			ArticleTypeForm.setId(Integer.valueOf(request.getParameter("id")));
			ArticleTypeDao articleTypeDao = new ArticleTypeDao();
			if (articleTypeDao.operationArticleType("ɾ��", ArticleTypeForm)) {
				out
						.print("<script language=javascript>alert('ɾ���������ɹ��������²�ѯ��');window.location.href='back_ArticleTypeSelect.jsp';</script>");
			} else {
				out
						.print("<script language=javascript>alert('����Ҫ��������ڵ�����ɾ��,�ſ�ɾ�������');history.go(-1);</script>");
			}

		}
		//��̨������µ����
		public void addArticleType(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			ArticleTypeForm ArticleTypeForm = new ArticleTypeForm();
			ArticleTypeForm.setTypeName(Chinese.toChinese(request
					.getParameter("typeName")));
			ArticleTypeForm.setDescription(Chinese.toChinese(request
					.getParameter("description")));
			ArticleTypeDao 	articleTypeDao = new ArticleTypeDao();
			if (articleTypeDao.operationArticleType("���", ArticleTypeForm)) {
				out
						.print("<script language=javascript>alert('����������ɹ��������²�ѯ��');window.location.href='back_ArticleTypeSelect.jsp';</script>");
			} else {
				out
						.print("<script language=javascript>alert('����������ʧ�ܣ�');history.go(-1);</script>");
			}

		}
		
		
		
		//�û�ɾ������
		public void deleteArticle1(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			ArticleForm articleForm = new ArticleForm();
			articleForm.setId(Integer.valueOf(request.getParameter("id")));
			ArticleDao articleDao = new ArticleDao();
			if (articleDao.operationArticle("ɾ��1", articleForm)) {
				out
						.print("<script language=javascript>alert('ɾ�����³ɹ��������²�ѯ��');window.location.href='back_ArticleSelect1.jsp';</script>");
			} else {
				out
						.print("<script language=javascript>alert('ɾ������ʧ�ܣ�');history.go(-1);</script>");
			}
		}
		
		// ��̨�������
		public void addArticle1(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			ArticleForm articleForm = new ArticleForm();
			articleForm.setTypeId(Integer.valueOf(request.getParameter("typeId")));
			articleForm.setTitle(Chinese.toChinese(request.getParameter("title")));
			articleForm.setNumber(Integer.valueOf(request.getParameter("number")));
			articleForm.setContent(Chinese.toChinese(request
					.getParameter("content")));
			articleForm
					.setPhTime(Chinese.toChinese(request.getParameter("phTime")));
			articleForm.setAccountId(Chinese.toChinese(request.getParameter("accountId")));
			ArticleDao articleDao = new ArticleDao();
			String result = "�������ʧ�ܣ�";
			if (articleDao.operationArticle("���", articleForm)) {
				result = "������ӳɹ���";
			}
			request.setAttribute("result", result);
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("back_ArticleAdd1.jsp");
			requestDispatcher.forward(request, response);
		}
		
		
		
		
		
		
		
		
		
		
		



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
