package com.zxj.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.zxj.form.VoteForm;
import com.zxj.tool.*;

public class VoteDao {
	private JDBConnection connection = null;
	public VoteDao() {
		connection = new JDBConnection();
	}
	
	//根据不同的要对投票表格进行相应的操作
	public boolean operationVote(String operation, VoteForm voteForm) {
		boolean flag = false;
		String sql = null;
		if (operation.equals("删除"))
			sql = "delete from tb_vote where id='" + voteForm.getId() + "'";
		if (operation.equals("添加"))
			sql = "insert into tb_vote values('0','" + voteForm.getVoteName()
					+ "','" + voteForm.getVoteNumber() + "')";
		if (operation.equals("投票"))
			sql = "update tb_vote set voteNumber=voteNumber+1 where id='"
					+ voteForm.getId() + "'";
		if (connection.executeUpdate(sql))
			flag = true;
		return flag;
	}
	
//取出投票的所有信息	
	public List queryVoteList() {
		List list = new ArrayList();
		String sql = "select * from tb_vote";
		ResultSet rs = connection.executeQuery(sql);
		VoteForm form = null;
		try {
			while (rs.next()) {
				form = new VoteForm();
				form.setId(Integer.valueOf(rs.getString(1)));
				form.setVoteName(rs.getString(2));
				form.setVoteNumber(Integer.valueOf(rs.getString(3)));
				list.add(form);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}
	//修改投票内容后，删除tb_voted表中的内容清空
	public boolean deletevoted(){
		String sql = "truncate  tb_voted";
		boolean flag = false;
		if(connection.executeUpdate(sql)){
			flag = true;
		}
		return flag;
	}
}
