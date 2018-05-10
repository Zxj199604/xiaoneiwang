package com.zxj.dao;


import java.sql.ResultSet;
import java.sql.SQLException;

import com.zxj.form.VotedForm;
import com.zxj.tool.JDBConnection;

public class VotedDao {
	private JDBConnection connection = null;
	private VotedForm votedForm = null;
	public VotedDao() {
		connection = new JDBConnection();
	}
	// 添加已经投过票的人的信息
			public boolean addvoteds(VotedForm form) {
				boolean flag = false;
				String sql = "insert into tb_voted values ('0'"+",'" + form.getAccountId()
						+ "','" + form.getVoteid()+ "')";
				if (connection.executeUpdate(sql)) {
					flag = true;
				}
				return flag;
			}
			
			//用户名为条件查找，查找一组数据
			public VotedForm getVotedForm(String accountId){
				String sql="select * from tb_voted where accountId='"+accountId+"'";
				ResultSet rs=connection.executeQuery(sql);
				try {
					while (rs.next()) {
						votedForm = new VotedForm();
						votedForm.setId(Integer.valueOf(rs.getString(1)));
						votedForm.setAccountId(rs.getString(2));
						votedForm.setVoteid(rs.getString(3));
					}
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return votedForm;
				
			}
}
