package com.zxj.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zxj.form.ConsumerForm;
import com.zxj.tool.JDBConnection;

public class ConsumerDao {
	private JDBConnection connection = null;
	private ConsumerForm consumerForm = null;
	public ConsumerDao() {
		connection = new JDBConnection();
	}
	
	//更新用户更改的信息
	public boolean front_updateConsumerForm(ConsumerForm form){
		boolean flag = false;
		String sql = "update tb_consumer set account='" + form.getAccount()
				+ "',password='" + form.getPassword() + "',name='"
				+ form.getName() + "',sex='" + form.getSex() + "',QQNumber='"
				+ form.getQQNumber() + "',mainPage='" + form.getPhoneNumber()
				+ "',interest='" + form.getInterest() + "',eMail='"
				+ form.getEMail() + "' where id='" + form.getId() + "'";
		if (connection.executeUpdate(sql)) {
			flag = true;
		}
		return flag;
	}
	
	
	
	
	
	
	
	// 添加用户信息
		public boolean addConsumerForm(ConsumerForm form) {
			boolean flag = false;
			String sql = "insert into tb_consumer values ('0'"+",'" + form.getAccount()
					+ "','" + form.getPassword() +"','"+0+ "','" + form.getName() + "','"
					+ form.getSex() + "','" + form.getQQNumber() + "','"
					+ form.getPhoneNumber() + "','" + form.getPhoneNumber() + "','"
					+ form.getEMail() + "','" + form.getManageLevel() + "')";

			if (connection.executeUpdate(sql)) {
				flag = true;
			}
			return flag;
		}
		//根据用户的id查询用户的姓名用于显示回复人
		public String getConsumerForm(Integer id) {
			String sql = "select * from tb_consumer where id='" + id
					+ "'";
			String name="";
			try {
				ResultSet rs = connection.executeQuery(sql);
				while (rs.next()) {
					name=rs.getString("name");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return name;
		}
	//	根据用户的id查询用户所有信息用于显示回复人
		public ConsumerForm getConsumerForm1(Integer id) {
			String sql = "select * from tb_consumer where id='" + id
					+ "'";
			ResultSet rs = connection.executeQuery(sql);
			try {
				while (rs.next()) {
					consumerForm = new ConsumerForm();
					consumerForm.setId(Integer.valueOf(rs.getString(1)));
					consumerForm.setAccount(rs.getString(2));
					consumerForm.setPassword(rs.getString(3));
					consumerForm.setPicture(rs.getString(4));
					consumerForm.setName(rs.getString(5));
					consumerForm.setSex(rs.getString(6));
					consumerForm.setQQNumber(rs.getString(7));
					consumerForm.setPhoneNumber(rs.getString(8));
					consumerForm.setInterest(rs.getString(9));
					consumerForm.setEMail(rs.getString(10));
					consumerForm.setManageLevel(rs.getString(11));
				}
			}
				
				catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return consumerForm;
		}
				
		
	//用户名为条件查找，查找一组数据
	public ConsumerForm getConsumerForm(String account){
		String sql="select * from tb_consumer where account='"+account+"'";
		ResultSet rs=connection.executeQuery(sql);
		try {
			while (rs.next()) {
				consumerForm = new ConsumerForm();
				consumerForm.setId(Integer.valueOf(rs.getString(1)));
				consumerForm.setAccount(rs.getString(2));
				consumerForm.setPassword(rs.getString(3));
				consumerForm.setPicture(rs.getString(4));
				consumerForm.setName(rs.getString(5));
				consumerForm.setSex(rs.getString(6));
				consumerForm.setQQNumber(rs.getString(7));
				consumerForm.setPhoneNumber(rs.getString(8));
				consumerForm.setInterest(rs.getString(9));
				consumerForm.setEMail(rs.getString(10));
				consumerForm.setManageLevel(rs.getString(11));
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return consumerForm;
		
	}
	//// 根据用户等级查询所有的数据
	public List getConsumerList(String manageLevel) {
		List list = new ArrayList();
		String sql = "select * from tb_consumer where manageLevel='"
				+ manageLevel + "'";
		try {
			ResultSet rs = connection.executeQuery(sql);
			while (rs.next()) {
				consumerForm = new ConsumerForm();
				consumerForm.setId(Integer.valueOf(rs.getString(1)));
				consumerForm.setAccount(rs.getString(2));
				consumerForm.setPassword(rs.getString(3));
				consumerForm.setPicture(rs.getString(4));
				consumerForm.setName(rs.getString(5));
				consumerForm.setSex(rs.getString(6));
				consumerForm.setQQNumber(rs.getString(7));
				consumerForm.setPhoneNumber(rs.getString(8));
				consumerForm.setInterest(rs.getString(9));
				consumerForm.setEMail(rs.getString(10));
				consumerForm.setManageLevel(rs.getString(11));
				list.add(consumerForm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	// 后台删除用户信息
		public boolean deleteConsumerForm(String account) {
			boolean flag = false;
			String sql = "delete from tb_consumer where account='" + account + "'";
			if (connection.executeUpdate(sql)) {
				flag = true;
			}
			return flag;
		}

		// 更新用户操作
		public boolean updateConsumerForm(ConsumerForm form) {
			boolean flag = false;
			String sql = "update tb_consumer set account='" + form.getAccount()
					+ "',password='" + form.getPassword() + "',name='"
					+ form.getName() + "',sex='" + form.getSex() + "',QQNumber='"
					+ form.getQQNumber() + "',phoneNumber='" + form.getPhoneNumber()
					+ "',interest='" + form.getInterest() + "',eMail='"
					+ form.getEMail() + "' where id='"
					+ form.getId() + "'";
			if (connection.executeUpdate(sql)) {
				flag = true;
			}
			return flag;
		}

}
