package com.zxj.tool;

import java.util.*;

public class MyPagination {
	public List<Object> list=null;//得到查询的数据
	private int recordCount=0;//共有几条记录
	private int pagesize=0;//一页显示几条
	private int maxPage=0;//一共有几页
	
	//初始化分页信息
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
		//获取指定页的数据
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
		//一共有几页
		public int getMaxPage(){
			int maxPage=(recordCount%pagesize==0)?(recordCount/pagesize):(recordCount/pagesize+1);
			return maxPage;
		}
		//得到记录总条数
		public int getRecordSize(){
			return recordCount;
		}
		//获取当前页数，对第一页和最后一页进行处理
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
		//根据page显示上一页下一页的图标，此方法用于全体文章的查询
		public String printCtrl1(int Page){
			String strHtml="<table width='370'  border='0' cellspacing='0' cellpadding='0'><tr> <td height='24' align='right'>当前页数：["+Page+"/"+maxPage+"]&nbsp;&nbsp;";
			try{
			if(Page>1){
				strHtml=strHtml+"<a href='?Page=1'>第一页</a>　";
				strHtml=strHtml+"&nbsp;&nbsp;<a href='?Page="+(Page-1)+"'>上一页</a>";
			}
			if(Page<maxPage){
				strHtml=strHtml+"&nbsp;&nbsp;<a href='?Page="+(Page+1)+"'>下一页</a>&nbsp;&nbsp;　<a href='?Page="+maxPage+"'>最后一页&nbsp;</a>";
			}
			strHtml=strHtml+"</td> </tr>	</table>";
			}catch(Exception e){
				e.printStackTrace();
				
			}
			return strHtml;
		}
		//带有参数的分页，如回复的是第一篇文章的第一页page=1&id=1
		public String printCtrl2(int Page,String id){
			id="&id="+id;
			String strHtml="<table width='370'  border='0' cellspacing='0' cellpadding='0'><tr> <td height='24' align='right'>当前页数：["+Page+"/"+maxPage+"]&nbsp;&nbsp;";
			try{
			if(Page>1){
				strHtml=strHtml+"<a href='?Page=1"+id+"'>第一页</a>　";
				strHtml=strHtml+"&nbsp;&nbsp;<a href='?Page="+(Page-1)+id+"'>上一页</a>";
			}
			if(Page<maxPage){
				strHtml=strHtml+"&nbsp;&nbsp;<a href='?Page="+(Page+1)+id+"'>下一页</a>&nbsp;&nbsp;　<a href='?Page="+maxPage+id+"'>最后一页&nbsp;</a>";
			}
			strHtml=strHtml+"</td> </tr>	</table>";
			}catch(Exception e){
				e.printStackTrace();
				
			}
			return strHtml;
		}
		//对文章类型的查询要带上参数&typeId=?
		public String printCtrl3(int Page,String typeId){
			typeId="&typeId="+typeId;
			String strHtml="<table width='370'  border='0' cellspacing='0' cellpadding='0'><tr> <td height='24' align='right'>当前页数：["+Page+"/"+maxPage+"]&nbsp;&nbsp;";
			try{
			if(Page>1){
				strHtml=strHtml+"<a href='?Page=1"+typeId+"'>第一页</a>　";
				strHtml=strHtml+"&nbsp;&nbsp;<a href='?Page="+(Page-1)+typeId+"'>上一页</a>";
			}
			if(Page<maxPage){
				strHtml=strHtml+"&nbsp;&nbsp;<a href='?Page="+(Page+1)+typeId+"'>下一页</a>&nbsp;&nbsp;　<a href='?Page="+maxPage+typeId+"'>最后一页&nbsp;</a>";
			}
			strHtml=strHtml+"</td> </tr>	</table>";
			}catch(Exception e){
				e.printStackTrace();
				
			}
			return strHtml;
		}
		
		//根据内容的查询要带上两个参数
		public String printCtrl4(int Page,String leixin,String message){
			leixin="&leixin="+leixin;
			message="&message="+message;
			String strHtml="<table width='370'  border='0' cellspacing='0' cellpadding='0'><tr> <td height='24' align='right'>当前页数：["+Page+"/"+maxPage+"]&nbsp;&nbsp;";
			try{
			if(Page>1){
				strHtml=strHtml+"<a href='?Page=1"+leixin+message+"'>第一页</a>　";
				strHtml=strHtml+"&nbsp;&nbsp;<a href='?Page="+(Page-1)+leixin+message+"'>上一页</a>";
			}
			if(Page<maxPage){
				strHtml=strHtml+"&nbsp;&nbsp;<a href='?Page="+(Page+1)+leixin+message+"'>下一页</a>&nbsp;&nbsp;　<a href='?Page="+maxPage+leixin+message+"'>最后一页&nbsp;</a>";
			}
			strHtml=strHtml+"</td> </tr>	</table>";
			}catch(Exception e){
				e.printStackTrace();
				
			}
			return strHtml;
		}
		
		
}
