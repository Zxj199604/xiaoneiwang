package com.zxj.tool;

import java.util.*;

public class MyPagination {
	public List<Object> list=null;//�õ���ѯ������
	private int recordCount=0;//���м�����¼
	private int pagesize=0;//һҳ��ʾ����
	private int maxPage=0;//һ���м�ҳ
	
	//��ʼ����ҳ��Ϣ
		public List getInitPage(List list,int Page,int pagesize){
			List<Object> newList=new ArrayList<Object>();
			this.list=list;
			recordCount=list.size();
			this.pagesize=pagesize;
			this.maxPage=getMaxPage();
			try{
			for(int i=(Page-1)*pagesize;i<=Page*pagesize-1;i++){
				try{
					if(i>=recordCount){break;}
				}catch(Exception e){}
				newList.add((Object)list.get(i));
			}
			}catch(Exception e){
				e.printStackTrace();
			}
			return newList;
		}
		//��ȡָ��ҳ������
		public List<Object> getAppointPage(int Page){
			List<Object> newList=new ArrayList<Object>();
			try{
				for(int i=(Page-1)*pagesize;i<=Page*pagesize-1;i++){
					try{
						if(i>=recordCount){break;}
					}catch(Exception e){}
					newList.add((Object)list.get(i));
				}
				}catch(Exception e){
					e.printStackTrace();
				}
				return newList;
		}
		//һ���м�ҳ
		public int getMaxPage(){
			int maxPage=(recordCount%pagesize==0)?(recordCount/pagesize):(recordCount/pagesize+1);
			return maxPage;
		}
		//�õ���¼������
		public int getRecordSize(){
			return recordCount;
		}
		//��ȡ��ǰҳ�����Ե�һҳ�����һҳ���д���
		public int getPage(String str){
			System.out.println("STR:"+str+"&&&&"+recordCount);
			if(str==null){
				str="0";
			}
			int Page=Integer.parseInt(str);
			if(Page<1){
				Page=1;
			}else{
				if(((Page-1)*pagesize+1)>recordCount){
					Page=maxPage;
				}
			}
			return Page;
		}
		//����page��ʾ��һҳ��һҳ��ͼ�꣬�˷�������ȫ�����µĲ�ѯ
		public String printCtrl1(int Page){
			String strHtml="<table width='370'  border='0' cellspacing='0' cellpadding='0'><tr> <td height='24' align='right'>��ǰҳ����["+Page+"/"+maxPage+"]&nbsp;&nbsp;";
			try{
			if(Page>1){
				strHtml=strHtml+"<a href='?Page=1'>��һҳ</a>��";
				strHtml=strHtml+"&nbsp;&nbsp;<a href='?Page="+(Page-1)+"'>��һҳ</a>";
			}
			if(Page<maxPage){
				strHtml=strHtml+"&nbsp;&nbsp;<a href='?Page="+(Page+1)+"'>��һҳ</a>&nbsp;&nbsp;��<a href='?Page="+maxPage+"'>���һҳ&nbsp;</a>";
			}
			strHtml=strHtml+"</td> </tr>	</table>";
			}catch(Exception e){
				e.printStackTrace();
				
			}
			return strHtml;
		}
		//���в����ķ�ҳ����ظ����ǵ�һƪ���µĵ�һҳpage=1&id=1
		public String printCtrl2(int Page,String id){
			id="&id="+id;
			String strHtml="<table width='370'  border='0' cellspacing='0' cellpadding='0'><tr> <td height='24' align='right'>��ǰҳ����["+Page+"/"+maxPage+"]&nbsp;&nbsp;";
			try{
			if(Page>1){
				strHtml=strHtml+"<a href='?Page=1"+id+"'>��һҳ</a>��";
				strHtml=strHtml+"&nbsp;&nbsp;<a href='?Page="+(Page-1)+id+"'>��һҳ</a>";
			}
			if(Page<maxPage){
				strHtml=strHtml+"&nbsp;&nbsp;<a href='?Page="+(Page+1)+id+"'>��һҳ</a>&nbsp;&nbsp;��<a href='?Page="+maxPage+id+"'>���һҳ&nbsp;</a>";
			}
			strHtml=strHtml+"</td> </tr>	</table>";
			}catch(Exception e){
				e.printStackTrace();
				
			}
			return strHtml;
		}
		//���������͵Ĳ�ѯҪ���ϲ���&typeId=?
		public String printCtrl3(int Page,String typeId){
			typeId="&typeId="+typeId;
			String strHtml="<table width='370'  border='0' cellspacing='0' cellpadding='0'><tr> <td height='24' align='right'>��ǰҳ����["+Page+"/"+maxPage+"]&nbsp;&nbsp;";
			try{
			if(Page>1){
				strHtml=strHtml+"<a href='?Page=1"+typeId+"'>��һҳ</a>��";
				strHtml=strHtml+"&nbsp;&nbsp;<a href='?Page="+(Page-1)+typeId+"'>��һҳ</a>";
			}
			if(Page<maxPage){
				strHtml=strHtml+"&nbsp;&nbsp;<a href='?Page="+(Page+1)+typeId+"'>��һҳ</a>&nbsp;&nbsp;��<a href='?Page="+maxPage+typeId+"'>���һҳ&nbsp;</a>";
			}
			strHtml=strHtml+"</td> </tr>	</table>";
			}catch(Exception e){
				e.printStackTrace();
				
			}
			return strHtml;
		}
		
		//�������ݵĲ�ѯҪ������������
		public String printCtrl4(int Page,String leixin,String message){
			leixin="&leixin="+leixin;
			message="&message="+message;
			String strHtml="<table width='370'  border='0' cellspacing='0' cellpadding='0'><tr> <td height='24' align='right'>��ǰҳ����["+Page+"/"+maxPage+"]&nbsp;&nbsp;";
			try{
			if(Page>1){
				strHtml=strHtml+"<a href='?Page=1"+leixin+message+"'>��һҳ</a>��";
				strHtml=strHtml+"&nbsp;&nbsp;<a href='?Page="+(Page-1)+leixin+message+"'>��һҳ</a>";
			}
			if(Page<maxPage){
				strHtml=strHtml+"&nbsp;&nbsp;<a href='?Page="+(Page+1)+leixin+message+"'>��һҳ</a>&nbsp;&nbsp;��<a href='?Page="+maxPage+leixin+message+"'>���һҳ&nbsp;</a>";
			}
			strHtml=strHtml+"</td> </tr>	</table>";
			}catch(Exception e){
				e.printStackTrace();
				
			}
			return strHtml;
		}
		
		
}
