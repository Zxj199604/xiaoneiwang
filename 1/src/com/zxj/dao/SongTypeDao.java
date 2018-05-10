package com.zxj.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.zxj.form.SongTypeForm;
import com.zxj.tool.JDBConnection;
public class SongTypeDao {
	private JDBConnection connection = null;

	public SongTypeDao() {
		connection = new JDBConnection();
	}
	
	public List querySongType() {
		List list = new ArrayList();
		SongTypeForm form = null;
		String sql = "select * from tb_songType";
		ResultSet rs = connection.executeQuery(sql);
		try {
			while (rs.next()) {
				form = new SongTypeForm();
				form.setId(rs.getInt(1));
				form.setTypeName(rs.getString(2));
				list.add(form);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//根据歌曲的id得到歌曲的类别名字
		public String querySongTypeName(Integer id) {
			String typeName = null;
			String sql = "select * from tb_songtype where id='" + id + "'";
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
		public boolean operationSongType(String operation,SongTypeForm form){
			boolean flag=false;
			String sql=null;
			
			if(operation.equals("添加"))
				sql="insert into tb_songType values('0','"+form.getTypeName()+"')";
			if(operation.equals("删除")){
				String sql1="select * from tb_song where songType='"+form.getId()+"'";
			ResultSet rSet=connection.executeQuery(sql1);
			try {
				if(rSet.next()){
					return false;
				}else{
				sql = "delete from tb_songtype where id='" + form.getId() + "'";
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			if(connection.executeUpdate(sql)){
				flag=true;
			}
			return flag;	
		}
		
}
