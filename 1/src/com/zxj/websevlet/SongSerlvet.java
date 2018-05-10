package com.zxj.websevlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.zxj.dao.PhotoDao;
import com.zxj.dao.RestoreDao;
import com.zxj.dao.SongDao;
import com.zxj.dao.SongTypeDao;
import com.zxj.dao.songResoreDao;
import com.zxj.form.PhotoForm;
import com.zxj.form.RestoreForm;
import com.zxj.form.SongForm;
import com.zxj.form.SongTypeForm;
import com.zxj.form.songRestoreForm;
import com.zxj.tool.Chinese;

public class SongSerlvet extends HttpServlet {
	public SongSerlvet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int method = Integer.parseInt(request.getParameter("method"));
		//�����û��ظ�����������
				if (method == 7) {
					this.HeadAddRestore(request, response);
				}
 
		//�������Ա�������ϴ�
		if(method==0){
			this.addSong(request, response);
		}
		if(method==4){
			this.addSong1(request, response);
		}
		//�������Ա������ɾ��
		if(method==3){
			this.deleteSong(request,response);
		}
		//�������Ա�����ظ���Ϣ
		if(method==6){
			this.deleteSongRestore(request,response);
		}
		//�������Ա�������ɾ��
		if (method == 1) {
			this.deleteSongType(request, response);
		}
		//�������Ա����������
		if(method==2){
			this.addSongType(request,response);
		}
		//�û���̨ɾ������������ص�����
		if(method==5){
			this.deleteSong1(request,response);
		}
		//�û���̨ɾ���Լ����������
		if(method==8){
			this.deleteSongRestore1(request,response);
		}
		
	}
	private void addSongType(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		SongTypeForm songTypeForm=new SongTypeForm();
		songTypeForm.setTypeName(Chinese.toChinese(request.getParameter("typeName")));
		SongTypeDao songTypeDao=new SongTypeDao();
		if(songTypeDao.operationSongType("���", songTypeForm)){
			out
			.print("<script language=javascript>alert('��Ӹ������ɹ��������²�ѯ��');window.location.href='back_songTypeSelect.jsp';</script>");
		}	else {
			out
			.print("<script language=javascript>alert('��Ӹ������ʧ�ܣ�');history.go(-1);</script>");
		}
	}
	private void deleteSongType(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		SongTypeForm songTypeForm=new SongTypeForm();
		songTypeForm.setId(Integer.valueOf(request.getParameter("id")));
		SongTypeDao songTypeDao=new SongTypeDao();
		if(songTypeDao.operationSongType("ɾ��", songTypeForm)){
			out
			.print("<script language=javascript>alert('ɾ���������ɹ��������²�ѯ��');window.location.href='back_songTypeSelect.jsp';</script>");
		}else{
			out
			.print("<script language=javascript>alert('����Ҫ��������ڵĸ���ɾ��,�ſ�ɾ�������');history.go(-1);</script>");	
		}
	}
	
	
	
	private void deleteSongRestore(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		songResoreDao songResoreDao=new songResoreDao();
		songRestoreForm  songRestoreForm=new songRestoreForm();
		songRestoreForm.setId(Integer.valueOf(request.getParameter("id")));
		if(songResoreDao.operationRestore("ɾ��", songRestoreForm)){
				out.print("<script language=javascript>alert('ɾ���ظ��ɹ��������²�ѯ��');window.location.href='back_songRestoreSelect.jsp?id="
							+ request.getParameter("idd") + "';</script>");
		} else {
			out.print("<script language=javascript>alert('ɾ���ظ�ʧ�ܣ�');history.go(-1);</script>");
		}
	}
		private void deleteSongRestore1(HttpServletRequest request, HttpServletResponse response) throws IOException {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			songResoreDao songResoreDao=new songResoreDao();
			songRestoreForm  songRestoreForm=new songRestoreForm();
			songRestoreForm.setId(Integer.valueOf(request.getParameter("id")));
			if(songResoreDao.operationRestore("ɾ��", songRestoreForm)){
					out.print("<script language=javascript>alert('ɾ���ظ��ɹ��������²�ѯ��');window.location.href='back_songRestoreSelect1.jsp'</script>");
			} else {
				out.print("<script language=javascript>alert('ɾ���ظ�ʧ�ܣ�');history.go(-1);</script>");
			}
		

	}
	
	
	
	
	
	private void deleteSong(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		SongDao songDao=new SongDao();
		Integer id = Integer.valueOf(request.getParameter("id"));
		songResoreDao songResoreDao=new songResoreDao();
		if(!songResoreDao.queryRestore(id).isEmpty()){
			out.print("<script language=javascript>alert('����ɾ��������������ۣ�');window.location.href='back_songSelect.jsp';</script>");
		}else{
				ServletContext application=request.getSession().getServletContext();
				String songDir = application.getRealPath("/");
				songDir=songDir+"/"+songDao.querySongForm(id)
				.getFileURL();
				java.io.File file = new java.io.File(songDir);
				SongForm songForm = new SongForm();
				songForm.setId(id);
				if(songDao.operationSong("ɾ��", songForm)){
					file.delete();
					out.print("<script language=javascript>alert('ɾ�������ɹ��������²�ѯ��');window.location.href='back_songSelect.jsp';</script>");
				} else {
					out.print("<script language=javascript>alert('�޸ĸ���ʧ�ܣ�');history.go(-1);</script>");
				}	
		}
	}
	
	private void deleteSong1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		SongDao songDao=new SongDao();
		Integer id = Integer.valueOf(request.getParameter("id"));
				ServletContext application=request.getSession().getServletContext();
				String songDir = application.getRealPath("/");
				songDir=songDir+"/"+songDao.querySongForm(id)
				.getFileURL();
				java.io.File file = new java.io.File(songDir);
				SongForm songForm = new SongForm();
				songForm.setId(id);
				if(songDao.operationSong("ɾ��1", songForm)){
					file.delete();
					out.print("<script language=javascript>alert('ɾ�����������۳ɹ��������²�ѯ��');window.location.href='back_songSelect1.jsp';</script>");
				} else {
					out.print("<script language=javascript>alert('�޸ĸ���ʧ�ܣ�');history.go(-1);</script>");
				}	
	}
	private void addSong(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		SongForm songForm=new SongForm();
		SongDao songDao=new SongDao();
		com.jspsmart.upload.SmartUpload su = new com.jspsmart.upload.SmartUpload();
		Integer maxID = 0;
		if (songDao.MaxQueryID() != null) {
			maxID = songDao.MaxQueryID();
		}
		String result = "�ϴ��ĸ�����ʽ�ʹ�С������,�ϴ�����ʧ��!";
		String type = null;
		String imageType[] = { "mp3", "wav", "wmv"};
		String filedir = "/music/";
		long maxsize = 20 * 1024 * 1024; // ����ÿ���ϴ��ļ��Ĵ�С��Ϊ20MB
		try {	
			su.initialize(this.getServletConfig(), request, response);
			su.setMaxFileSize(maxsize); // �����ϴ��ļ��Ĵ�С
			su.upload("utf-8"); // �ϴ��ļ�
			Files files = su.getFiles(); // ��ȡ���е��ϴ��ļ�
			for (int i = 0; i < files.getCount(); i++) {
				File singlefile = files.getFile(i);
				type = singlefile.getFileExt();
				for (int ii = 0; ii < imageType.length; ii++) {
					if (imageType[ii].equals(type)) {
						if (!singlefile.isMissing()) { // ���ѡ�����ļ�
							String songName= su.getRequest().getParameter("songName");
							String singer=su.getRequest().getParameter("singer");
							String specialName=su.getRequest().getParameter("specialName");
							String content=su.getRequest().getParameter("content");
							String format=singlefile.getFileExt();
							String hits=su.getRequest().getParameter("hits");
							String download=su.getRequest().getParameter("download");
							String upTime=su.getRequest().getParameter("upTime");
							String songType=su.getRequest().getParameter("songType");
							String accountId=su.getRequest().getParameter("accountId");
							filedir = filedir + maxID + "."
									+ singlefile.getFileExt();//�����·��
							songForm.setSongName(songName);
							songForm.setSinger(singer);
							songForm.setSpecialName(specialName);
							songForm.setContent(content);
							songForm.setFileURL("music/"+maxID + "."
									+ singlefile.getFileExt());
							songForm.setFormat(format);
							songForm.setHits(Integer.valueOf(hits));
							songForm.setDownload(Integer.valueOf(download));
							songForm.setUpTime(upTime);
							songForm.setSongType(Integer.valueOf(songType));
							songForm.setAccountId(accountId);
							if(songDao.operationSong("���", songForm)){
								singlefile.saveAs(filedir, File.SAVEAS_VIRTUAL);
								result = "�ϴ������ɹ�!";
							}
							
						}
					}
					
				}				
			}			
		} catch (Exception  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("result", result);
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("back_songAdd.jsp");
		requestDispatcher.forward(request, response);
		
	}
	private void addSong1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		SongForm songForm=new SongForm();
		SongDao songDao=new SongDao();
		com.jspsmart.upload.SmartUpload su = new com.jspsmart.upload.SmartUpload();
		Integer maxID = 0;
		if (songDao.MaxQueryID() != null) {
			maxID = songDao.MaxQueryID();
		}
		String result = "�ϴ��ĸ�����ʽ�ʹ�С������,�ϴ�����ʧ��!";
		String type = null;
		String imageType[] = { "mp3", "wav", "wmv"};
		String filedir = "/music/";
		long maxsize = 20 * 1024 * 1024; // ����ÿ���ϴ��ļ��Ĵ�С��Ϊ20MB
		try {	
			su.initialize(this.getServletConfig(), request, response);
			su.setMaxFileSize(maxsize); // �����ϴ��ļ��Ĵ�С
			su.upload("utf-8"); // �ϴ��ļ�
			Files files = su.getFiles(); // ��ȡ���е��ϴ��ļ�
			for (int i = 0; i < files.getCount(); i++) {
				File singlefile = files.getFile(i);
				type = singlefile.getFileExt();
				for (int ii = 0; ii < imageType.length; ii++) {
					if (imageType[ii].equals(type)) {
						if (!singlefile.isMissing()) { // ���ѡ�����ļ�
							String songName= su.getRequest().getParameter("songName");
							String singer=su.getRequest().getParameter("singer");
							String specialName=su.getRequest().getParameter("specialName");
							String content=su.getRequest().getParameter("content");
							String format=singlefile.getFileExt();
							String hits=su.getRequest().getParameter("hits");
							String download=su.getRequest().getParameter("download");
							String upTime=su.getRequest().getParameter("upTime");
							String songType=su.getRequest().getParameter("songType");
							String accountId=su.getRequest().getParameter("accountId");
							filedir = filedir + maxID + "."
									+ singlefile.getFileExt();//�����·��
							songForm.setSongName(songName);
							songForm.setSinger(singer);
							songForm.setSpecialName(specialName);
							songForm.setContent(content);
							songForm.setFileURL("music/"+maxID + "."
									+ singlefile.getFileExt());
							songForm.setFormat(format);
							songForm.setHits(Integer.valueOf(hits));
							songForm.setDownload(Integer.valueOf(download));
							songForm.setUpTime(upTime);
							songForm.setSongType(Integer.valueOf(songType));
							songForm.setAccountId(accountId);
							if(songDao.operationSong("���", songForm)){
								singlefile.saveAs(filedir, File.SAVEAS_VIRTUAL);
								result = "�ϴ������ɹ�!";
							}
							
						}
					}
					
				}				
			}			
		} catch (Exception  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("result", result);
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("back_songAdd1.jsp");
		requestDispatcher.forward(request, response);
		
	}
		//��ӻظ�
		public void HeadAddRestore(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			songResoreDao restoreDao = new songResoreDao();
			songRestoreForm restoreForm = new songRestoreForm();
			restoreForm.setSongId(Integer.valueOf(request.getParameter("songId")));
			restoreForm.setReAccount(request.getParameter("accountId"));
			restoreForm.setReTime(Chinese.toChinese(request.getParameter("reTime")));
			restoreForm.setReContent(Chinese.toChinese(request.getParameter("reContent")));
			if (restoreDao.operationRestore("���", restoreForm)) {
				out.print("<script language=javascript>alert('��ӻظ���Ϣ�ɹ��������²�ѯ��');window.location.href='head_SongForm.jsp?id="+request.getParameter("songId")+"';</script>");
			} else {
				out.print("<script language=javascript>alert('��ӻظ���Ϣʧ�ܣ�');history.go(-1);</script>");
			}
			
		}
	
	
	
	
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
