package com.zxj.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.zxj.form.DiscussForm;
import com.zxj.tool.JDBConnection;

public class DiscussDao {
	private JDBConnection connection = null;

	public DiscussDao() {
		connection = new JDBConnection();
	}
//查询公告的所有信息
	public List queryDiscuss() {
		List list = new ArrayList();
		DiscussForm form = null;
		String sql = "select * from tb_discuss order by id desc";
		try {
			ResultSet rs = connection.executeQuery(sql);
			while (rs.next()) {
				form = new DiscussForm();
				form.setId(Integer.valueOf(rs.getString(1)));
				form.setDiscussTitle(rs.getString(2));
				form.setDiscussContent(rs.getString(3));
				form.setDiscussTime(rs.getString(4));
				list.add(form);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
//根据公告的id到查询这条公告的详细信息分装到相应的Form类中
	public DiscussForm queryDiscuss(Integer id) {
		DiscussForm form = null;
		String sql = "select * from tb_discuss where id='"+id+"'";
		try {
			ResultSet rs = connection.executeQuery(sql);
			while (rs.next()) {
				form = new DiscussForm();
				form.setId(Integer.valueOf(rs.getString(1)));
				form.setDiscussTitle(rs.getString(2));
				form.setDiscussContent(rs.getString(3));
				form.setDiscussTime(rs.getString(4));
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return form;
	}
	public boolean operationDiscuss(String operation, DiscussForm disussForm) {
		boolean flag = false;
		String sql = null;
		if (operation.equals("删除"))
			sql = "delete from tb_discuss where id='" + disussForm.getId()
					+ "'";
		if (operation.equals("添加"))
			sql = "insert into tb_discuss values ('0','"
					+ disussForm.getDiscussTitle() + "','"
					+ disussForm.getDiscussContent() + "','"
					+ disussForm.getDiscussTime() + "')";
		if (operation.equals("修改"))
			sql = "update tb_discuss set discussTitle='"
					+ disussForm.getDiscussTitle() + "',discussContent='"
					+ disussForm.getDiscussContent() + "' where id='"
					+ disussForm.getId() + "'";
		
		
		if (connection.executeUpdate(sql))
			flag = true;
		return flag;
	}
}
