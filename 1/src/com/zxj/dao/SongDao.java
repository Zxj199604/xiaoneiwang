package com.zxj.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zxj.form.ArticleForm;
import com.zxj.form.SongForm;
import com.zxj.tool.Chinese;
import com.zxj.tool.JDBConnection;

public class SongDao {
	private JDBConnection connection = null;
	private SongForm songForm=null;
	public SongDao() {
		connection = new JDBConnection();
	}
	//���������ļ������ͺ���tb_song���в�ѯ������Ϣ
		public List querySong(Integer typeId) {
			List list = new ArrayList();
			String sql = null;
			if (typeId == null)
				sql = "select * from tb_song";
			else
				sql = "select * from tb_song where songType='" + typeId
						+ "' order by id desc";
			ResultSet rs = connection.executeQuery(sql);
			try {
				while (rs.next()) {
					songForm = new SongForm();
					songForm.setId(rs.getInt(1));
					songForm.setSongName(rs.getString(2));
					songForm.setSinger(rs.getString(3));
					songForm.setSpecialName(rs.getString(4));
					songForm.setContent(rs.getString(5));
					songForm.setFileURL(rs.getString(6));
					songForm.setFormat(rs.getString(7));
					songForm.setHits(rs.getInt(8));
					songForm.setDownload(rs.getInt(9));
					songForm.setUpTime(rs.getString(10));
					songForm.setSongType(rs.getInt(11));
					songForm.setAccountId(rs.getString(12));
					list.add(songForm);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
		}
		//�������ֵ����ͺź��û���id����ѯ��������Ϣ
		public List querySong1(Integer typeId,Integer accountId) {
			List list = new ArrayList();
			String sql = null;
			if (typeId == null)
				sql = "select * from tb_song where accountId='"+accountId+"'"+"order by id desc";
			else
				sql = "select * from tb_song where songType='" + typeId
						+ "'and accountId='"+accountId+"'"+" order by id desc";
			ResultSet rs = connection.executeQuery(sql);
			try {
				while (rs.next()) {
					songForm = new SongForm();
					songForm.setId(rs.getInt(1));
					songForm.setSongName(rs.getString(2));
					songForm.setSinger(rs.getString(3));
					songForm.setSpecialName(rs.getString(4));
					songForm.setContent(rs.getString(5));
					songForm.setFileURL(rs.getString(6));
					songForm.setFormat(rs.getString(7));
					songForm.setHits(rs.getInt(8));
					songForm.setDownload(rs.getInt(9));
					songForm.setUpTime(rs.getString(10));
					songForm.setSongType(rs.getInt(11));
					songForm.setAccountId(rs.getString(12));
					list.add(songForm);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
		}
		//���ݸ�����id��ѯ����������
		public String selectsongName(Integer id){
			String sql="select * from tb_song where id='"+id+"'";
			String name="";
			try {
				ResultSet rs = connection.executeQuery(sql);
				while (rs.next()) {
					name=rs.getString("songName");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return name;
		}
		
		
		//���ݸ�����id�Ų�ѯ��ƪ�����Ļ�����Ϣ
		public SongForm querySongForm(Integer id){
			String sql = "select * from tb_song where id='" + id + "'";
			ResultSet rs = connection.executeQuery(sql);
			try {
				while (rs.next()) {
					songForm = new SongForm();
					songForm.setId(rs.getInt(1));
					songForm.setSongName(rs.getString(2));
					songForm.setSinger(rs.getString(3));
					songForm.setSpecialName(rs.getString(4));
					songForm.setContent(rs.getString(5));
					songForm.setFileURL(rs.getString(6));
					songForm.setFormat(rs.getString(7));
					songForm.setHits(rs.getInt(8));
					songForm.setDownload(rs.getInt(9));
					songForm.setUpTime(rs.getString(10));
					songForm.setSongType(rs.getInt(11));
					songForm.setAccountId(rs.getString(12));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return songForm;
}
		
		
		
		public Integer MaxQueryID() {
			Integer maxID = 0;
			String sql = "select max(id) as id from tb_song";
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
		
		//���ݲ�ͬ�Ĳ�ѯ��ʽ���и����Ĳ�ѯ
		public List manyquresong(String leixin,String message){
			List list = new ArrayList();
			String sql="";
			String messages=Chinese.toChinese(message);
			if (message.equals(""))
			{	sql = "select * from tb_song";}
			else{
				if(leixin.equals("songName")){
				sql="select * from tb_song where songName like  '%"+messages+"%'";
				}else if(leixin.equals("specialName")){
					sql="select * from tb_song where specialName like  '%"+messages+"%'";
				}else{
					sql="select * from tb_song where singer like  '%"+messages+"%'";
				}
			}
			ResultSet rs = connection.executeQuery(sql);
			System.out.println(sql);
			try {
				while (rs.next()) {
					songForm = new SongForm();
					songForm.setId(rs.getInt(1));
					songForm.setSongName(rs.getString(2));
					songForm.setSinger(rs.getString(3));
					songForm.setSpecialName(rs.getString(4));
					songForm.setContent(rs.getString(5));
					songForm.setFileURL(rs.getString(6));
					songForm.setFormat(rs.getString(7));
					songForm.setHits(rs.getInt(8));
					songForm.setDownload(rs.getInt(9));
					songForm.setUpTime(rs.getString(10));
					songForm.setSongType(rs.getInt(11));
					songForm.setAccountId(rs.getString(12));
					list.add(songForm);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
		}
		//����������������������
		public void optionsong(String tag, String id){
			String sql="";
			if(tag.equals("����")){
				sql="update tb_song set download=download+1 where id='"+id+"'";
			}else if(tag.equals("����")){
				sql="update tb_song set hits=hits+1 where id='"+id+"'";
			}
			connection.executeUpdate(sql);	
		}
		
		
		public boolean operationSong(String operation,SongForm songForm){
			boolean flag = false;
			String sql = null;
			if (operation.equals("ɾ��"))
				sql = "delete from tb_song where id='" + songForm.getId() + "'";
			if(operation.equals("ɾ��1")){
				sql = "delete from tb_song where id='" + songForm.getId() + "'";
				String sql1="delete from tb_songrestore where songId= '"+songForm.getId()+"'";
				if(connection.executeUpdate(sql1)){
				}
			}
			if (operation.equals("���"))
				sql = "insert into tb_song values ('0','"
						+ songForm.getSongName() + "','"
						+ songForm.getSinger() + "','"
						+ songForm.getSpecialName() + "','"+songForm.getContent()+"','"+ songForm.getFileURL()+					
						"','"+songForm.getFormat()+"','"+songForm.getHits()+"','"+songForm.getDownload()+"','"+songForm.getUpTime()+"','"+
						songForm.getSongType()+"','"+songForm.getAccountId()+"')";	
			if (connection.executeUpdate(sql))
				flag = true;
				return flag;		
		}
}
