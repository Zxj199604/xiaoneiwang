package com.zxj.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zxj.form.PhotoForm;
import com.zxj.tool.JDBConnection;

public class PhotoDao {
	private JDBConnection connection = null;

	public PhotoDao() {
		connection = new JDBConnection();
	}
	//��ѯ���е���Ƭ��¼
	public List queryPhoto() {
		List list = new ArrayList();
		PhotoForm form = null;
		String sql = "select * from tb_photo order by id desc";
		ResultSet rs = connection.executeQuery(sql);
		try {
			while (rs.next()) {
				form = new PhotoForm();
				form.setId(Integer.valueOf(rs.getString(1)));
				form.setPhotoAddress(rs.getString(2));
				form.setPhotoDescription(rs.getString(3));
				form.setPhtoTime(rs.getString(4));
				form.setAccountId(rs.getString(5));
				list.add(form);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//�����û���id��ѯͼƬ��¼
	public List queryPhoto(String accountId){
		List list = new ArrayList();
		PhotoForm form = null;
		String sql = "select * from tb_photo where accountId='"+accountId+"'order by id desc";
		ResultSet rs = connection.executeQuery(sql);
		try {
			while (rs.next()) {
				form = new PhotoForm();
				form.setId(Integer.valueOf(rs.getString(1)));
				form.setPhotoAddress(rs.getString(2));
				form.setPhotoDescription(rs.getString(3));
				form.setPhtoTime(rs.getString(4));
				form.setAccountId(rs.getString(5));
				list.add(form);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	
	public Integer MaxQueryID() {
		Integer maxID = 0;
		String sql = "select max(id) as id from tb_photo";
		ResultSet rs = connection.executeQuery(sql);
		try {
			while (rs.next()) {
				maxID = rs.getInt("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maxID;

	}
	//����ͼƬ��ID �õ���Ӧ�ı���Ϣ
	public PhotoForm queryPhoto(Integer id) {
		PhotoForm form = null;
		String sql = "select * from tb_photo where id='" + id + "'";
		ResultSet rs = connection.executeQuery(sql);
		try {
			while (rs.next()) {
				form = new PhotoForm();
				form.setId(Integer.valueOf(rs.getString(1)));
				form.setPhotoAddress(rs.getString(2));
				form.setPhotoDescription(rs.getString(3));
				form.setPhtoTime(rs.getString(4));
				form.setAccountId(rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return form;
	}
	public boolean operationPhoto(String operation, PhotoForm photoForm) {
		boolean flag = false;
		String sql = null;
		if (operation.equals("ɾ��"))
			sql = "delete from tb_photo where id='" + photoForm.getId() + "'";
		if (operation.equals("���"))
			sql = "insert into tb_photo values ('0','"
					+ photoForm.getPhotoAddress() + "','"
					+ photoForm.getPhotoDescription() + "','"
					+ photoForm.getPhtoTime() + "','"+photoForm.getAccountId()+ "')";

		if (connection.executeUpdate(sql))
			flag = true;
		return flag;
	}
}
