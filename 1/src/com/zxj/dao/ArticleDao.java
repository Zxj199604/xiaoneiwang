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
//�������µ����ͺ���tb_article���в�ѯ������Ϣ
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
	//�������µ����ͺź��û���id��tb_article���в�ѯ������Ϣ
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
	//�������µ�id��ѯ���µ�����
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
	

	
	//�������µ�id�Ų�ѯ��ƪ���µĻ�����Ϣ
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
		//�Ķ�����Ҫ����һ��
		this.operationArticle("����", articleForm);
		return articleForm;
	}
	//Ҫ�����µ����ݽ��в����ĸ�������
	public boolean operationArticle(String operation, ArticleForm form){
		boolean flag = false;
		String sql = null;
		if (operation.equals("���"))
			sql = "insert into tb_article values ('0','" + form.getTypeId() + "','"
					+ form.getTitle() + "','" + form.getContent() + "','"
					+ form.getPhTime() + "','" + form.getNumber() +"','"+form.getAccountId()+ "')";
		if (operation.equals("�޸�"))
			sql = "update tb_article set typeID='" + form.getTypeId()
					+ "',title='" + form.getTitle() + "',content='"
					+ form.getContent() + "' where id='" + form.getId() + "'";
		if (operation.equals("ɾ��"))
			sql = "delete from tb_article where id='" + form.getId() + "'";
		if(operation.equals("ɾ��1")){
			sql = "delete from tb_article where id='" + form.getId() + "'";
			String sql1="delete from tb_restore where articleId= '"+form.getId()+"'";
			if(connection.executeUpdate(sql1)){
			}
		}
		if (operation.equals("����"))
			sql = "update tb_article set number=number+1 where id='"
					+ form.getId() + "'";
		if (connection.executeUpdate(sql)) {
			flag = true;
		}
		return flag;
	}

	
}
