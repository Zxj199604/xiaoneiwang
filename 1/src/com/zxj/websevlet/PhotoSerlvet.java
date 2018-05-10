package com.zxj.websevlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.zxj.dao.PhotoDao;
import com.zxj.form.PhotoForm;

/**
 * Servlet implementation class PhotoSerlvet
 */
public class PhotoSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private int method;
	private PhotoDao photoDao = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PhotoSerlvet() {
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
			this.addPhoto(request, response); // �ϴ�ͼƬ
		}
		if (method == 1) {
			this.deletePhoto(request, response); // ɾ��ͼƬ
		}
		//�û������ϴ�ͼƬ
		if(method==2){
			this.addPhoto1(request, response);
		}
		//�û�����ͼƬ��ɾ��
		if(method==3){
			this.deletePhoto1(request, response);
		}
	}
	public void deletePhoto1(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		photoDao = new PhotoDao();
		Integer id = Integer.valueOf(request.getParameter("id"));
		ServletContext application=request.getSession().getServletContext();
		String photoDir = application.getRealPath("/");
		photoDir=photoDir+"/"+photoDao.queryPhoto(id)
		.getPhotoAddress();
		
		System.out.println(photoDir);
		java.io.File file = new java.io.File(photoDir);
		PhotoForm photoForm = new PhotoForm();
		photoForm.setId(id);
		if (photoDao.operationPhoto("ɾ��", photoForm)) {
			file.delete();
			out.print("<script language=javascript>alert('ɾ��ͼƬ�ɹ��������²�ѯ��');window.location.href='back_PhotoSelect1.jsp';</script>");
		} else {
			out.print("<script language=javascript>alert('�޸�ͼƬʧ�ܣ�');history.go(-1);</script>");
		}
	}
	// ɾ��ͼƬ
			public void deletePhoto(HttpServletRequest request,
					HttpServletResponse response) throws ServletException, IOException {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				photoDao = new PhotoDao();
				Integer id = Integer.valueOf(request.getParameter("id"));
				ServletContext application=request.getSession().getServletContext();
				String photoDir = application.getRealPath("/");
				photoDir=photoDir+"/"+photoDao.queryPhoto(id)
				.getPhotoAddress();
				
				System.out.println(photoDir);
				java.io.File file = new java.io.File(photoDir);
				PhotoForm photoForm = new PhotoForm();
				photoForm.setId(id);
				if (photoDao.operationPhoto("ɾ��", photoForm)) {
					file.delete();
					out.print("<script language=javascript>alert('ɾ��ͼƬ�ɹ��������²�ѯ��');window.location.href='back_PhotoSelect.jsp';</script>");
				} else {
					out.print("<script language=javascript>alert('�޸�ͼƬʧ�ܣ�');history.go(-1);</script>");
				}
			}
	public void addPhoto(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		photoDao = new PhotoDao();
		PhotoForm photoForm = new PhotoForm();
		com.jspsmart.upload.SmartUpload su = new com.jspsmart.upload.SmartUpload();

		Integer maxID = 0;
		if (photoDao.MaxQueryID() != null) {
			maxID = photoDao.MaxQueryID();
		}
		String result = "�ϴ�����Ƭ��ʽ�ʹ�С������,�ϴ���Ƭʧ��!";
		String type = null;
		String imageType[] = { "JPG", "jpg", "gif", "bmp", "BMP"};
		String filedir = "/file/";
		long maxsize = 7 * 1024 * 1024; // ����ÿ���ϴ��ļ��Ĵ�С��Ϊ7MB
		try {
			su.initialize(this.getServletConfig(), request, response);
			su.setMaxFileSize(maxsize); // �����ϴ��ļ��Ĵ�С
			su.upload("utf-8"); // �ϴ��ļ�
			Files files = su.getFiles(); // ��ȡ���е��ϴ��ļ�
			for (int i = 0; i < files.getCount(); i++) { // �����ȡ�ϴ����ļ�
				File singlefile = files.getFile(i);
				type = singlefile.getFileExt();

				for (int ii = 0; ii < imageType.length; ii++) {
					if (imageType[ii].equals(type)) {
						if (!singlefile.isMissing()) { // ���ѡ�����ļ�
							String photoTime = su.getRequest().getParameter(
									"phtoTime");
							String photoDescription = su.getRequest()
									.getParameter("photoDescription");
							String accountId=su.getRequest().getParameter("accountId");
							photoForm.setPhtoTime(photoTime);
							photoForm.setPhotoDescription(photoDescription);
							photoForm.setAccountId(accountId);
							filedir = filedir + maxID + "."
									+ singlefile.getFileExt();
							photoForm.setPhotoAddress("file/"+maxID + "."
									+ singlefile.getFileExt());
							if (photoDao.operationPhoto("���", photoForm)) {
								singlefile.saveAs(filedir, File.SAVEAS_VIRTUAL);
								result = "�ϴ���Ƭ�ɹ�!";
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
				.getRequestDispatcher("back_PhotoInsert.jsp");
		requestDispatcher.forward(request, response);
	}
	public void addPhoto1(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		photoDao = new PhotoDao();
		PhotoForm photoForm = new PhotoForm();
		com.jspsmart.upload.SmartUpload su = new com.jspsmart.upload.SmartUpload();

		Integer maxID = 0;
		if (photoDao.MaxQueryID() != null) {
			maxID = photoDao.MaxQueryID();
		}
		String result = "�ϴ�����Ƭ��ʽ�ʹ�С������,�ϴ���Ƭʧ��!";
		String type = null;
		String imageType[] = { "JPG", "jpg", "gif", "bmp", "BMP"};
		String filedir = "/file/";
		long maxsize = 7 * 1024 * 1024; // ����ÿ���ϴ��ļ��Ĵ�С��Ϊ7MB
		try {
			su.initialize(this.getServletConfig(), request, response);
			su.setMaxFileSize(maxsize); // �����ϴ��ļ��Ĵ�С
			su.upload("utf-8"); // �ϴ��ļ�
			Files files = su.getFiles(); // ��ȡ���е��ϴ��ļ�
			for (int i = 0; i < files.getCount(); i++) { // �����ȡ�ϴ����ļ�
				File singlefile = files.getFile(i);
				type = singlefile.getFileExt();

				for (int ii = 0; ii < imageType.length; ii++) {
					if (imageType[ii].equals(type)) {
						if (!singlefile.isMissing()) { // ���ѡ�����ļ�
							String photoTime = su.getRequest().getParameter(
									"phtoTime");
							String photoDescription = su.getRequest()
									.getParameter("photoDescription");
							String accountId=su.getRequest().getParameter("accountId");
							photoForm.setPhtoTime(photoTime);
							photoForm.setPhotoDescription(photoDescription);
							photoForm.setAccountId(accountId);
							filedir = filedir + maxID + "."
									+ singlefile.getFileExt();
							photoForm.setPhotoAddress("file/"+maxID + "."
									+ singlefile.getFileExt());
							if (photoDao.operationPhoto("���", photoForm)) {
								singlefile.saveAs(filedir, File.SAVEAS_VIRTUAL);
								result = "�ϴ���Ƭ�ɹ�!";
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
				.getRequestDispatcher("back_PhotoInsert1.jsp");
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
