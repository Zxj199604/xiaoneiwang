package com.zxj.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zxj.form.DiscussForm;
import com.zxj.form.PhotoForm;
import com.zxj.form.VideoForm;
import com.zxj.tool.JDBConnection;

public class VideoDao {
	private JDBConnection connection = null;

	public VideoDao() {
		connection = new JDBConnection();
	}
	//查询视频的所有信息
		public List queryVideo() {
			List list = new ArrayList();
			VideoForm form = null;
			String sql = "select * from tb_video order by id desc";
			try {
				ResultSet rs = connection.executeQuery(sql);
				while (rs.next()) {
					form = new VideoForm();
					form.setId(Integer.valueOf(rs.getString(1)));
					form.setVideoAddress(rs.getString(2));
					form.setVideoTite(rs.getString(3));
					form.setVideoIntroduction(rs.getString(4));
					form.setVideoTime(rs.getString(5));
					form.setAccountId(rs.getString(6));
					list.add(form);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
		}
		//根据用户的id查询视频的所有信息
		public List queryVideo(String accountId){
			List list =new ArrayList();
			VideoForm form=null;
			String sql = "select * from tb_video where accountId='"+accountId+"'order by id desc";
			try {
				ResultSet rs = connection.executeQuery(sql);
				while (rs.next()) {
					form = new VideoForm();
					form.setId(Integer.valueOf(rs.getString(1)));
					form.setVideoAddress(rs.getString(2));
					form.setVideoTite(rs.getString(3));
					form.setVideoIntroduction(rs.getString(4));
					form.setVideoTime(rs.getString(5));
					form.setAccountId(rs.getString(6));
					list.add(form);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
		}
		public Integer MaxQueryID() {
			Integer maxID = 0;
			String sql = "select max(id) as id from tb_video";
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
		//根据id查询整条视频信息
		public VideoForm queryVideo(Integer id) {
				VideoForm form = null;
			String sql = "select * from tb_video where id='"+id+"'";
			try {
				ResultSet rs = connection.executeQuery(sql);
				while (rs.next()) {
					form = new VideoForm();
					form.setId(Integer.valueOf(rs.getString(1)));
					form.setVideoAddress(rs.getString(2));
					form.setVideoTite(rs.getString(3));
					form.setVideoIntroduction(rs.getString(4));
					form.setVideoTime(rs.getString(5));
					form.setAccountId(rs.getString(6));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return form;
		}
		
		public boolean operationVideo(String operation, VideoForm videoForm) {
			boolean flag = false;
			String sql = null;
			if (operation.equals("删除"))
				sql = "delete from tb_video where id='" + videoForm.getId() + "'";
			if (operation.equals("添加"))
				sql = "insert into tb_video values ('0','"
						+ videoForm.getVideoAddress() + "','"
						+ videoForm.getVideoTite()+ "','"
						+videoForm.getVideoIntroduction()+"','"
						+ videoForm.getVideoTime()+"','" +videoForm.getAccountId()+"')";
			if (connection.executeUpdate(sql))
				flag = true;
			return flag;
		}

}
