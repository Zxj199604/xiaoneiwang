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
		//文章类别的添加处理
		if(method==0){
			this.addArticleType(request, response);
		}
		//文章类别的删除处理
		if (method == 1) {
			this.deleteArticleType(request, response);
		}
		//处理后台增加的新文章
		if(method==2){
			this.addArticle(request, response);
		}
		//后台对文章的删除
		if(method==3){
			this.deleteArticle(request, response);
		}
		//文章修改进行处理
		if(method==4){
			this.updateArticle(request, response);
		}
		//处理后台删除文章回复的相应处理
		if(method == 6){
			this.deleteRestore(request, response);
		}
		//处理用户回复文章的内容
		if (method == 7) {
			this.HeadAddRestore(request, response);
		}
		
		
		
		
		
		//用户对自己的文章进行删除的方法
		if(method==8){
			this.deleteArticle1(request, response);
		}
		//用户对自己的文章进行增加的方法
		if(method==9){
			this.addArticle1(request, response);
		}
		//用户对自己回复信息的删除
		if(method==10){
			this.deleteRestore1(request,response);
		}
	}
	//添加回复
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
		if (restoreDao.operationRestore("添加", restoreForm)) {
			out.print("<script language=javascript>alert('添加回复信息成功，请重新查询！');window.location.href='head_ArticleForm.jsp?id="+request.getParameter("articleId")+"';</script>");
		} else {
			out.print("<script language=javascript>alert('添加回复信息失败！');history.go(-1);</script>");
		}
	
	}
	//后台对文章回复内容进行删除
	public void deleteRestore(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		RestoreDao restoreDao = new RestoreDao();
		RestoreForm restoreForm = new RestoreForm();
		restoreForm.setId(Integer.valueOf(request.getParameter("id")));
	
		if (restoreDao.operationRestore("删除", restoreForm)) {
			out
					.print("<script language=javascript>alert('删除回复成功，请重新查询！');window.location.href='back_RestoreSelect.jsp?id="
							+ request.getParameter("idd") + "';</script>");
		} else {
			out
					.print("<script language=javascript>alert('删除回复失败！');history.go(-1);</script>");
		}

	}
	
	public void deleteRestore1(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		RestoreDao restoreDao = new RestoreDao();
		RestoreForm restoreForm = new RestoreForm();
		restoreForm.setId(Integer.valueOf(request.getParameter("id")));
		if (restoreDao.operationRestore("删除", restoreForm)) {
			out
			.print("<script language=javascript>alert('删除回复成功，请重新查询！');window.location.href='back_RestoreSelect1.jsp'</script>");
			} else {
				out
						.print("<script language=javascript>alert('删除回复失败！');history.go(-1);</script>");
			}
	}

	
	
	
	
	// 后台添加文章
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
		String result = "文章添加失败！";
		if (articleDao.operationArticle("添加", articleForm)) {
			result = "文章添加成功！";
		}
		request.setAttribute("result", result);
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("back_ArticleAdd.jsp");
		requestDispatcher.forward(request, response);
	}
	//后台文章的删除
	public void deleteArticle(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int id =Integer.valueOf(request.getParameter("id"));
		RestoreDao restoreDao=new RestoreDao();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if(!restoreDao.queryRestore(id).isEmpty()){
			out.print("<script language=javascript>alert('请先删除此文章的相关回复');window.location.href='back_ArticleSelect.jsp';</script>");
		}else{
					ArticleForm articleForm = new ArticleForm();
					articleForm.setId(Integer.valueOf(request.getParameter("id")));
					ArticleDao articleDao = new ArticleDao();
					if (articleDao.operationArticle("删除", articleForm)) {
						out
								.print("<script language=javascript>alert('删除文章成功，请重新查询！');window.location.href='back_ArticleSelect.jsp';</script>");
					} else {
						out
								.print("<script language=javascript>alert('删除文章失败！');history.go(-1);</script>");
					}
		}
	}
//后台修改文章更新
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
		if (articleDao.operationArticle("修改", articleForm)) {
			
			out
					.print("<script language=javascript>alert('修改文章成功，请重新查询！');window.location.href='back_ArticleSelect.jsp';</script>");
		} else {
			out
					.print("<script language=javascript>alert('修改文章失败！');history.go(-1);</script>");
		}
	}
	// 后台删除文章类别
		public void deleteArticleType(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			ArticleTypeForm ArticleTypeForm = new ArticleTypeForm();
			ArticleTypeForm.setId(Integer.valueOf(request.getParameter("id")));
			ArticleTypeDao articleTypeDao = new ArticleTypeDao();
			if (articleTypeDao.operationArticleType("删除", ArticleTypeForm)) {
				out
						.print("<script language=javascript>alert('删除文章类别成功，请重新查询！');window.location.href='back_ArticleTypeSelect.jsp';</script>");
			} else {
				out
						.print("<script language=javascript>alert('您需要将类别所在的文章删除,才可删除此类别！');history.go(-1);</script>");
			}

		}
		//后台添加文章的类别
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
			if (articleTypeDao.operationArticleType("添加", ArticleTypeForm)) {
				out
						.print("<script language=javascript>alert('添加文章类别成功，请重新查询！');window.location.href='back_ArticleTypeSelect.jsp';</script>");
			} else {
				out
						.print("<script language=javascript>alert('添加文章类别失败！');history.go(-1);</script>");
			}

		}
		
		
		
		//用户删除文章
		public void deleteArticle1(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			ArticleForm articleForm = new ArticleForm();
			articleForm.setId(Integer.valueOf(request.getParameter("id")));
			ArticleDao articleDao = new ArticleDao();
			if (articleDao.operationArticle("删除1", articleForm)) {
				out
						.print("<script language=javascript>alert('删除文章成功，请重新查询！');window.location.href='back_ArticleSelect1.jsp';</script>");
			} else {
				out
						.print("<script language=javascript>alert('删除文章失败！');history.go(-1);</script>");
			}
		}
		
		// 后台添加文章
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
			String result = "文章添加失败！";
			if (articleDao.operationArticle("添加", articleForm)) {
				result = "文章添加成功！";
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
