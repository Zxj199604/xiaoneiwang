package com.zxj.dao;
//���»ظ���Ĵ���
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zxj.form.RestoreForm;
import com.zxj.tool.JDBConnection;
public class RestoreDao {
	private JDBConnection connection = null;
	public RestoreDao() {
		connection = new JDBConnection();
	}
	//�����û���id����ѯ�ظ���¼
	public List queryRestore1(String reaccount){
		List list = new ArrayList();
		String sql="select * from tb_restore where reAccount='"+reaccount+
				"' order by id desc";
		RestoreForm form = null;
		ResultSet rs = connection.executeQuery(sql);
		try {
			while (rs.next()) {
				form = new RestoreForm();
				form.setId(rs.getInt(1));
				form.setArticleId(rs.getInt(2));
				form.setReAccount(rs.getString(3));
				form.setReTitle(rs.getString(4));
				form.setReContent(rs.getString(5));
				list.add(form);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//�������µ�id�Ų�ѯ�ظ���¼
	public List queryRestore(Integer articleId) {
		List list = new ArrayList();
		String sql = "select * from tb_restore where articleId='" + articleId
				+ "' order by id desc";
		RestoreForm form = null;
		ResultSet rs = connection.executeQuery(sql);
		try {
			while (rs.next()) {
				form = new RestoreForm();
				form.setId(rs.getInt(1));
				form.setArticleId(rs.getInt(2));
				form.setReAccount(rs.getString(3));
				form.setReTitle(rs.getString(4));
				form.setReContent(rs.getString(5));
				list.add(form);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}
	public boolean operationRestore(String operation, RestoreForm form) {
		boolean flag = false;
		String sql = "";
		if (operation.equals("���"))
			sql = "insert into tb_restore values ('0','" + form.getArticleId()
					+ "','" + form.getReAccount() + "','" + form.getReTitle()
					+ "','" + form.getReContent() + "')";
		if (operation.equals("ɾ��"))
			sql = "delete from tb_restore where id='" + form.getId() + "'";
		if (connection.executeUpdate(sql)) {
			flag = true;
		}
		return flag;
	}

}
