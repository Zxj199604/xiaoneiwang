package com.zxj.tool;


public class SendMailToSomeone {

	public static void main(String []args){
		
		SendMailToSomeone sts=new SendMailToSomeone();
		sts.send("张鑫杰", "你是个王八蛋", "782819517@qq.com",
				"zxj782819517@163.com", "zxj782819517", "smtp.163.com");
	}
	
	/**
	 * 发送电子邮件到指定的信箱
	 * @param title 邮件标题 
	 * @param mailbody 邮件内容【一个网页，表格ok】
	 * @param sendTo 发送给谁 hanshunping@tsinghua.org.cn
	 * @param from 从哪些发送 admin@sohu.com
	 * @param passwd 密码 123456
	 * @param sendStmp 发送邮件的smtp smtp.sohu.com [smtp.163.com] [smtp.sina.com]
	 */
	public Boolean send(String title,String mailbody,String sendTo,String from,String passwd,String sendStmp){
		
		//指明让那个smtp转发(搜狐)
		MysendMail themail = new MysendMail(sendStmp);
		
		//校验身份
		themail.setNeedAuth(true);
		
		//邮件标题
		if(themail.setSubject(title) == false) return false;
		//将要发送的 内容放入邮件体 
		if(themail.setBody(mailbody) == false) return false;
		
		//发送到哪里
		if(themail.setTo(sendTo) == false) return false;
		
		//谁发送的
		if(themail.setFrom(from) == false) return false;
	
	
//		if(themail.addFileAffix("C:\\Users\\lenovo\\Desktop\\需求分析规格说明书.wps") == false) return;
			
	//	if()
		//将在sohu网站上的邮件用户名和 密码 放入邮件体 
		themail.setNamePass("zxj782819517",passwd);
		
		//发送
		if(themail.sendout() == false) return false ;
		return true;
	}
}
