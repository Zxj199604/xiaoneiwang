package com.zxj.tool;


public class SendMailToSomeone {

	public static void main(String []args){
		
		SendMailToSomeone sts=new SendMailToSomeone();
		sts.send("���ν�", "���Ǹ����˵�", "782819517@qq.com",
				"zxj782819517@163.com", "zxj782819517", "smtp.163.com");
	}
	
	/**
	 * ���͵����ʼ���ָ��������
	 * @param title �ʼ����� 
	 * @param mailbody �ʼ����ݡ�һ����ҳ�����ok��
	 * @param sendTo ���͸�˭ hanshunping@tsinghua.org.cn
	 * @param from ����Щ���� admin@sohu.com
	 * @param passwd ���� 123456
	 * @param sendStmp �����ʼ���smtp smtp.sohu.com [smtp.163.com] [smtp.sina.com]
	 */
	public Boolean send(String title,String mailbody,String sendTo,String from,String passwd,String sendStmp){
		
		//ָ�����Ǹ�smtpת��(�Ѻ�)
		MysendMail themail = new MysendMail(sendStmp);
		
		//У�����
		themail.setNeedAuth(true);
		
		//�ʼ�����
		if(themail.setSubject(title) == false) return false;
		//��Ҫ���͵� ���ݷ����ʼ��� 
		if(themail.setBody(mailbody) == false) return false;
		
		//���͵�����
		if(themail.setTo(sendTo) == false) return false;
		
		//˭���͵�
		if(themail.setFrom(from) == false) return false;
	
	
//		if(themail.addFileAffix("C:\\Users\\lenovo\\Desktop\\����������˵����.wps") == false) return;
			
	//	if()
		//����sohu��վ�ϵ��ʼ��û����� ���� �����ʼ��� 
		themail.setNamePass("zxj782819517",passwd);
		
		//����
		if(themail.sendout() == false) return false ;
		return true;
	}
}
