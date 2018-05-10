package com.zxj.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.zxj.form.ArticleForm;
import com.zxj.tool.JDBConnection;

public class ArticleDao {
	private JDBConnection connection = null;
	private ArticleForm articleForm = null;
	public ArticleDao() {
		connection = new JDBConnection();
	}
//根据文章的类型号在tb_article表中查询文章信息
	public List queryArticle(Integer typeId) {
		List list = new ArrayList();
		String sql = null;
		if (typeId == null)
			sql = "select * from tb_article order by id desc";
		else
			sql = "select * from tb_article where typeID='" + typeId
					+ "' order by id desc";
		ResultSet rs = connection.executeQuery(sql);
		try {
			while (rs.next()) {
				articleForm = new ArticleForm();
				articleForm.setId(rs.getInt(1));
				articleForm.setTypeId(rs.getInt(2));
				articleForm.setTitle(rs.getString(3));
				articleForm.setContent(rs.getString(4));
				articleForm.setPhTime(rs.getString(5));
				articleForm.setNumber(rs.getInt(6));
				articleForm.setAccountId(rs.getString(7));
				list.add(articleForm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//根据文章的类型号和用户的id在tb_article表中查询文章信息
	public List queryArticle1(Integer typeId,Integer accountId) {
		List list = new ArrayList();
		String sql = null;
		if (typeId == null)
			sql = "select * from tb_article where accountId='"+accountId+"'"+"order by id desc";
		else
			sql = "select * from tb_article where typeID='" + typeId
					+ "'and accountId='"+accountId+"'"+" order by id desc";
		ResultSet rs = connection.executeQuery(sql);
		try {
			while (rs.next()) {
				articleForm = new ArticleForm();
				articleForm.setId(rs.getInt(1));
				articleForm.setTypeId(rs.getInt(2));
				articleForm.setTitle(rs.getString(3));
				articleForm.setContent(rs.getString(4));
				articleForm.setPhTime(rs.getString(5));
				articleForm.setNumber(rs.getInt(6));
				articleForm.setAccountId(rs.getString(7));
				list.add(articleForm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//根据文章的id查询文章的名字
	public String selectArticleName(Integer id){
		String sql="select * from tb_article where id='"+id+"'";
		String name="";
		try {
			ResultSet rs = connection.executeQuery(sql);
			while (rs.next()) {
				name=rs.getString("title");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return name;
	}
	

	
	//根据文章的id号查询这篇文章的基本信息
	public ArticleForm queryArticleForm(Integer id){
		String sql = "select * from tb_article where id='" + id + "'";
		ResultSet rs = connection.executeQuery(sql);
		try {
			while (rs.next()) {
				articleForm = new ArticleForm();
				articleForm.setId(rs.getInt(1));
				articleForm.setTypeId(rs.getInt(2));
				articleForm.setTitle(rs.getString(3));
				articleForm.setContent(rs.getString(4));
				articleForm.setPhTime(rs.getString(5));
				articleForm.setNumber(rs.getInt(6));
				articleForm.setAccountId(rs.getString(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//阅读量需要增加一次
		this.operationArticle("增加", articleForm);
		return articleForm;
	}
	//要对文章的内容进行操作的辅助方法
	public boolean operationArticle(String operation, ArticleForm form){
		boolean flag = false;
		String sql = null;
		if (operation.equals("添加"))
			sql = "insert into tb_article values ('0','" + form.getTypeId() + "','"
					+ form.getTitle() + "','" + form.getContent() + "','"
					+ form.getPhTime() + "','" + form.getNumber() +"','"+form.getAccountId()+ "')";
		if (operation.equals("修改"))
			sql = "update tb_article set typeID='" + form.getTypeId()
					+ "',title='" + form.getTitle() + "',content='"
					+ form.getContent() + "' where id='" + form.getId() + "'";
		if (operation.equals("删除"))
			sql = "delete from tb_article where id='" + form.getId() + "'";
		if(operation.equals("删除1")){
			sql = "delete from tb_article where id='" + form.getId() + "'";
			String sql1="delete from tb_restore where articleId= '"+form.getId()+"'";
			if(connection.executeUpdate(sql1)){
			}
		}
		if (operation.equals("增加"))
			sql = "update tb_article set number=number+1 where id='"
					+ form.getId() + "'";
		if (connection.executeUpdate(sql)) {
			flag = true;
		}
		return flag;
	}

	
}
