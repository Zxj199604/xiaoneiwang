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
import com.zxj.dao.VideoDao;
import com.zxj.form.PhotoForm;
import com.zxj.form.VideoForm;


/**
 * Servlet implementation class VideoSerlvet
 */
public class VideoSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int method;
	private VideoDao videoDao = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VideoSerlvet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.method = Integer.parseInt(request.getParameter("method"));
		if (method == 0) {
			this.addVideo(request, response); // 上传视频
		}
		if (method == 1) {
			this.deleteVideo(request, response); // 删除视频
		}
		if(method==2){
			this.addVideo1(request, response);
		}
		if(method==3){
			this.deleteVideo1(request, response);
		}
	}
	public void deleteVideo1(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		videoDao = new VideoDao();
		Integer id = Integer.valueOf(request.getParameter("id"));
		ServletContext application=request.getSession().getServletContext();
		String videoDir = application.getRealPath("/");
		videoDir=videoDir+"/"+videoDao.queryVideo(id)
		.getVideoAddress();
		java.io.File file = new java.io.File(videoDir);
		VideoForm videoForm = new VideoForm();
		videoForm.setId(id);
		if (videoDao.operationVideo("删除", videoForm)) {
			file.delete();
			out.print("<script language=javascript>alert('删除视频成功，请重新查询！');window.location.href='back_VideoSelect1.jsp';</script>");
		} else {
			out.print("<script language=javascript>alert('删除视频失败！');history.go(-1);</script>");
		}
	}
	// 删除视频
				public void deleteVideo(HttpServletRequest request,
						HttpServletResponse response) throws ServletException, IOException {
					response.setContentType("text/html;charset=utf-8");
					PrintWriter out = response.getWriter();
					videoDao = new VideoDao();
					Integer id = Integer.valueOf(request.getParameter("id"));
					ServletContext application=request.getSession().getServletContext();
					String videoDir = application.getRealPath("/");
					videoDir=videoDir+"/"+videoDao.queryVideo(id)
					.getVideoAddress();
					java.io.File file = new java.io.File(videoDir);
					VideoForm videoForm = new VideoForm();
					videoForm.setId(id);
					if (videoDao.operationVideo("删除", videoForm)) {
						file.delete();
						out.print("<script language=javascript>alert('删除视频成功，请重新查询！');window.location.href='back_VideoSelect.jsp';</script>");
					} else {
						out.print("<script language=javascript>alert('删除视频失败！');history.go(-1);</script>");
					}

				}
	public void addVideo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		videoDao = new VideoDao();
		VideoForm videoForm = new VideoForm();
		com.jspsmart.upload.SmartUpload su = new com.jspsmart.upload.SmartUpload();

		Integer maxID = 0;
		if (videoDao.MaxQueryID() != null) {
			maxID = videoDao.MaxQueryID();
		}
		String result = "上传的视频格式和大小有问题,上传视频失败!";
		String type = null;
		String imageType[] = { "mp4"};
		String filedir = "/video/";
		long maxsize = 128* 1024 * 1024; // 设置每个上传文件的大小，为128m
		try {
			su.initialize(this.getServletConfig(), request, response);
			su.setMaxFileSize(maxsize); // 限制上传文件的大小
			su.upload("utf-8"); // 上传文件
			Files files = su.getFiles(); // 获取所有的上传文件
			for (int i = 0; i < files.getCount(); i++) { // 逐个获取上传的文件
				File singlefile = files.getFile(i);
				type = singlefile.getFileExt();

				for (int ii = 0; ii < imageType.length; ii++) {
					if (imageType[ii].equals(type)) {
						if (!singlefile.isMissing()) { // 如果选择了文件
							String videoTite = su.getRequest().getParameter(
									"videoTite");
							String videoIntroduction = su.getRequest()
									.getParameter("videoIntroduction");
							String videoTime = su.getRequest()
									.getParameter("videoTime");
							String accountId=su.getRequest().getParameter("accountId");
							videoForm.setVideoTime(videoTime);
							videoForm.setVideoTite(videoTite);
							videoForm.setVideoIntroduction(videoIntroduction);
							videoForm.setAccountId(accountId);
							filedir = filedir + maxID + "."
									+ singlefile.getFileExt();
							videoForm.setVideoAddress("video/"+maxID + "."
									+ singlefile.getFileExt());
							if (videoDao.operationVideo("添加", videoForm)) {
								singlefile.saveAs(filedir, File.SAVEAS_VIRTUAL);//指示组件将文件保存到以Web应用程序根目录为文件根目录的目录下
								result = "上传视频成功!";
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("result", result);
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("back_VideoInsert.jsp");
		requestDispatcher.forward(request, response);
	}
	public void addVideo1(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		videoDao = new VideoDao();
		VideoForm videoForm = new VideoForm();
		com.jspsmart.upload.SmartUpload su = new com.jspsmart.upload.SmartUpload();

		Integer maxID = 0;
		if (videoDao.MaxQueryID() != null) {
			maxID = videoDao.MaxQueryID();
		}
		String result = "上传的视频格式和大小有问题,上传照片失败!";
		String type = null;
		String imageType[] = { "mp4"};
		String filedir = "/video/";
		long maxsize = 128* 1024 * 1024; // 设置每个上传文件的大小，为128m
		try {
			su.initialize(this.getServletConfig(), request, response);
			su.setMaxFileSize(maxsize); // 限制上传文件的大小
			su.upload("utf-8"); // 上传文件
			Files files = su.getFiles(); // 获取所有的上传文件
			for (int i = 0; i < files.getCount(); i++) { // 逐个获取上传的文件
				File singlefile = files.getFile(i);
				type = singlefile.getFileExt();

				for (int ii = 0; ii < imageType.length; ii++) {
					if (imageType[ii].equals(type)) {
						if (!singlefile.isMissing()) { // 如果选择了文件
							String videoTite = su.getRequest().getParameter(
									"videoTite");
							String videoIntroduction = su.getRequest()
									.getParameter("videoIntroduction");
							String videoTime = su.getRequest()
									.getParameter("videoTime");
							String accountId=su.getRequest().getParameter("accountId");
							videoForm.setVideoTime(videoTime);
							videoForm.setVideoTite(videoTite);
							videoForm.setVideoIntroduction(videoIntroduction);
							videoForm.setAccountId(accountId);
							filedir = filedir + maxID + "."
									+ singlefile.getFileExt();
							videoForm.setVideoAddress("video/"+maxID + "."
									+ singlefile.getFileExt());
							if (videoDao.operationVideo("添加", videoForm)) {
								singlefile.saveAs(filedir, File.SAVEAS_VIRTUAL);//指示组件将文件保存到以Web应用程序根目录为文件根目录的目录下
								result = "上传视频成功!";
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("result", result);
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("back_VideoInsert1.jsp");
		requestDispatcher.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
