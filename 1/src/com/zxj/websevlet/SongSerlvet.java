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
		//处理用户回复歌曲的内容
				if (method == 7) {
					this.HeadAddRestore(request, response);
				}
 
		//处理管理员歌曲的上传
		if(method==0){
			this.addSong(request, response);
		}
		if(method==4){
			this.addSong1(request, response);
		}
		//处理管理员歌曲的删除
		if(method==3){
			this.deleteSong(request,response);
		}
		//处理管理员歌曲回复信息
		if(method==6){
			this.deleteSongRestore(request,response);
		}
		//处理管理员歌曲类别删除
		if (method == 1) {
			this.deleteSongType(request, response);
		}
		//处理管理员歌曲类别添加
		if(method==2){
			this.addSongType(request,response);
		}
		//用户后台删除歌曲及其相关的评估
		if(method==5){
			this.deleteSong1(request,response);
		}
		//用户后台删除自己的相关评论
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
		if(songTypeDao.operationSongType("添加", songTypeForm)){
			out
			.print("<script language=javascript>alert('添加歌曲类别成功，请重新查询！');window.location.href='back_songTypeSelect.jsp';</script>");
		}	else {
			out
			.print("<script language=javascript>alert('添加歌曲类别失败！');history.go(-1);</script>");
		}
	}
	private void deleteSongType(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		SongTypeForm songTypeForm=new SongTypeForm();
		songTypeForm.setId(Integer.valueOf(request.getParameter("id")));
		SongTypeDao songTypeDao=new SongTypeDao();
		if(songTypeDao.operationSongType("删除", songTypeForm)){
			out
			.print("<script language=javascript>alert('删除歌曲类别成功，请重新查询！');window.location.href='back_songTypeSelect.jsp';</script>");
		}else{
			out
			.print("<script language=javascript>alert('您需要将类别所在的歌曲删除,才可删除此类别！');history.go(-1);</script>");	
		}
	}
	
	
	
	private void deleteSongRestore(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		songResoreDao songResoreDao=new songResoreDao();
		songRestoreForm  songRestoreForm=new songRestoreForm();
		songRestoreForm.setId(Integer.valueOf(request.getParameter("id")));
		if(songResoreDao.operationRestore("删除", songRestoreForm)){
				out.print("<script language=javascript>alert('删除回复成功，请重新查询！');window.location.href='back_songRestoreSelect.jsp?id="
							+ request.getParameter("idd") + "';</script>");
		} else {
			out.print("<script language=javascript>alert('删除回复失败！');history.go(-1);</script>");
		}
	}
		private void deleteSongRestore1(HttpServletRequest request, HttpServletResponse response) throws IOException {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			songResoreDao songResoreDao=new songResoreDao();
			songRestoreForm  songRestoreForm=new songRestoreForm();
			songRestoreForm.setId(Integer.valueOf(request.getParameter("id")));
			if(songResoreDao.operationRestore("删除", songRestoreForm)){
					out.print("<script language=javascript>alert('删除回复成功，请重新查询！');window.location.href='back_songRestoreSelect1.jsp'</script>");
			} else {
				out.print("<script language=javascript>alert('删除回复失败！');history.go(-1);</script>");
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
			out.print("<script language=javascript>alert('请先删除歌曲的想关评论！');window.location.href='back_songSelect.jsp';</script>");
		}else{
				ServletContext application=request.getSession().getServletContext();
				String songDir = application.getRealPath("/");
				songDir=songDir+"/"+songDao.querySongForm(id)
				.getFileURL();
				java.io.File file = new java.io.File(songDir);
				SongForm songForm = new SongForm();
				songForm.setId(id);
				if(songDao.operationSong("删除", songForm)){
					file.delete();
					out.print("<script language=javascript>alert('删除歌曲成功，请重新查询！');window.location.href='back_songSelect.jsp';</script>");
				} else {
					out.print("<script language=javascript>alert('修改歌曲失败！');history.go(-1);</script>");
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
				if(songDao.operationSong("删除1", songForm)){
					file.delete();
					out.print("<script language=javascript>alert('删除歌曲和评论成功，请重新查询！');window.location.href='back_songSelect1.jsp';</script>");
				} else {
					out.print("<script language=javascript>alert('修改歌曲失败！');history.go(-1);</script>");
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
		String result = "上传的歌曲格式和大小有问题,上传音乐失败!";
		String type = null;
		String imageType[] = { "mp3", "wav", "wmv"};
		String filedir = "/music/";
		long maxsize = 20 * 1024 * 1024; // 设置每个上传文件的大小，为20MB
		try {	
			su.initialize(this.getServletConfig(), request, response);
			su.setMaxFileSize(maxsize); // 限制上传文件的大小
			su.upload("utf-8"); // 上传文件
			Files files = su.getFiles(); // 获取所有的上传文件
			for (int i = 0; i < files.getCount(); i++) {
				File singlefile = files.getFile(i);
				type = singlefile.getFileExt();
				for (int ii = 0; ii < imageType.length; ii++) {
					if (imageType[ii].equals(type)) {
						if (!singlefile.isMissing()) { // 如果选择了文件
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
									+ singlefile.getFileExt();//保存的路径
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
							if(songDao.operationSong("添加", songForm)){
								singlefile.saveAs(filedir, File.SAVEAS_VIRTUAL);
								result = "上传歌曲成功!";
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
		String result = "上传的歌曲格式和大小有问题,上传音乐失败!";
		String type = null;
		String imageType[] = { "mp3", "wav", "wmv"};
		String filedir = "/music/";
		long maxsize = 20 * 1024 * 1024; // 设置每个上传文件的大小，为20MB
		try {	
			su.initialize(this.getServletConfig(), request, response);
			su.setMaxFileSize(maxsize); // 限制上传文件的大小
			su.upload("utf-8"); // 上传文件
			Files files = su.getFiles(); // 获取所有的上传文件
			for (int i = 0; i < files.getCount(); i++) {
				File singlefile = files.getFile(i);
				type = singlefile.getFileExt();
				for (int ii = 0; ii < imageType.length; ii++) {
					if (imageType[ii].equals(type)) {
						if (!singlefile.isMissing()) { // 如果选择了文件
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
									+ singlefile.getFileExt();//保存的路径
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
							if(songDao.operationSong("添加", songForm)){
								singlefile.saveAs(filedir, File.SAVEAS_VIRTUAL);
								result = "上传歌曲成功!";
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
		//添加回复
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
			if (restoreDao.operationRestore("添加", restoreForm)) {
				out.print("<script language=javascript>alert('添加回复信息成功，请重新查询！');window.location.href='head_SongForm.jsp?id="+request.getParameter("songId")+"';</script>");
			} else {
				out.print("<script language=javascript>alert('添加回复信息失败！');history.go(-1);</script>");
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
