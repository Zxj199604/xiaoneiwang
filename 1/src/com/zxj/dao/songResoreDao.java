package com.zxj.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zxj.form.RestoreForm;
import com.zxj.form.songRestoreForm;
import com.zxj.tool.JDBConnection;
//音乐
public class songResoreDao {
	private JDBConnection connection = null;
	public songResoreDao() {
		connection = new JDBConnection();
	}
	//根据歌曲的id号查询回复记录
	public List queryRestore(Integer songId) {
		List list = new ArrayList();
		String sql = "select * from tb_songrestore where songId='" + songId
				+ "' order by id desc";
		songRestoreForm form=null;
		ResultSet rs = connection.executeQuery(sql);
		
		try {
			while (rs.next()) {
				form = new songRestoreForm();
				form.setId(rs.getInt(1));
				form.setSongId(rs.getInt(2));
				form.setReAccount(rs.getString(3));
				form.setReTime(rs.getString(4));
				form.setReContent(rs.getString(5));
				list.add(form);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return list;
	}
	//根据用户的id来查询歌曲的回复记录
	public List queryRestore(String reaccount){
		List list = new ArrayList();
		String sql="select * from tb_songrestore where reAccount='"+reaccount+
				"' order by id desc";
		songRestoreForm form=null;
		ResultSet rs = connection.executeQuery(sql);
		
		try {
			while (rs.next()) {
				form = new songRestoreForm();
				form.setId(rs.getInt(1));
				form.setSongId(rs.getInt(2));
				form.setReAccount(rs.getString(3));
				form.setReTime(rs.getString(4));
				form.setReContent(rs.getString(5));
				list.add(form);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return list;
	}
	public boolean operationRestore(String operation, songRestoreForm form) {
		boolean flag = false;
		String sql = "";
		if (operation.equals("添加"))
			sql = "insert into tb_songrestore values ('0','" + form.getSongId()
					+ "','" + form.getReAccount() + "','" + form.getReTime()
					+ "','" + form.getReContent() + "')";
		if (operation.equals("删除"))
			sql = "delete from tb_songrestore where id='" + form.getId() + "'";
		if (connection.executeUpdate(sql)) {
			flag = true;
		}
		return flag;
	}
	
	
	
	
	
	
	
	
}
