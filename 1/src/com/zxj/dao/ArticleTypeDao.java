package com.zxj.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.zxj.form.ArticleTypeForm;
import com.zxj.tool.JDBConnection;

public class ArticleTypeDao {
	private JDBConnection connection = null;

	public ArticleTypeDao() {
		connection = new JDBConnection();
	}
	public List queryArticleType() {
		List list = new ArrayList();
		ArticleTypeForm form = null;
		String sql = "select * from tb_articleType";
		ResultSet rs = connection.executeQuery(sql);
		try {
			while (rs.next()) {
				form = new ArticleTypeForm();
				form.setId(rs.getInt(1));
				form.setTypeName(rs.getString(2));
				form.setDescription(rs.getString(3));
				list.add(form);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//根据文章的id得到文章的类别名字
	public String queryArticleTypeName(Integer id) {
		String typeName = null;
		String sql = "select * from tb_articleType where id='" + id + "'";
		ResultSet rs = connection.executeQuery(sql);
		try {
			while (rs.next()) {
				typeName = rs.getString("typeName");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return typeName;
	}
	public boolean operationArticleType(String operation, ArticleTypeForm form)  {
		boolean flag = false;
		String sql = null;
		if (operation.equals("添加"))
			sql = "insert into tb_articleType values ('0','" + form.getTypeName()
					+ "','" + form.getDescription() + "')";
		if (operation.equals("删除")){
			String sql1="select * from tb_article where typeID='"+form.getId()+"'";
			ResultSet rSet=connection.executeQuery(sql1);
			try {
				if(rSet.next()){
					return false;
				}else{
				sql = "delete from tb_articleType where id='" + form.getId() + "'";
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (connection.executeUpdate(sql)) {
			flag = true;
		}
		return flag;
	}
}
