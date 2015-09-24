package cn.hzau.edu.fishResearch.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.inject.New;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.hzau.edu.fishResearch.DAO.impl.IBioInfoDAOImpl;
import cn.hzau.edu.fishResearch.DAO.impl.IMonitHydroDAOImpl;
import cn.hzau.edu.fishResearch.domain.BaseZooplan;
import cn.hzau.edu.fishResearch.domain.MonitZooplan;





@Controller
@RequestMapping(value="/NewFile")
public class fileUploadController {
	
	@Autowired
	private IMonitHydroDAOImpl<MonitZooplan,String,Long> monitZooDAO;
	@Autowired
	private IBioInfoDAOImpl<BaseZooplan, Long> bioZooInfoDAO;
	
	//定义文件路径URL
	private static final String fileUpload_Dir = "/upload";
	private static final String fileUpload_SubIMGDir = "/img";
	private static final String ForResourcesLoad_Dir = "/resources";
	
	//上传子目录中保存文件的最大数目
	private static final int maxNumForFile = 500;
	//控制上传文件大小
	private static final long maxSizeForFile = 1024*1024*2;
	//系统默认建立和使用的以时间字符串作为文件名称的时间格式
	private static final String subFolderFormat_Auto = "yyyyMMdd";
	//扩充格式
	private static final String subFolderFormat_NOAuto = "yyyy-MM-dd";
	
	@RequestMapping(value = "/fileEditor",method = RequestMethod.GET)
	public String processUpload(ModelMap modelMap,HttpServletRequest request,HttpServletResponse response){
		processUploadPost(modelMap, request, response);
		
		return "NewFile";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void processUploadPost(ModelMap modelMap,HttpServletRequest request,HttpServletResponse response){
		//判断提交请求是否包含文件
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (!isMultipart) {
			return;
		}
		//获取文件目录
		File folder = buildFolder(request);
		if(folder == null){
			return;
		}
		
		try {
			response.setContentType("text/html;charset=UTF-8");
			response.setHeader("Cache-Control", "no-cache");
			PrintWriter out = response.getWriter();
			//上传文件的返回地址
			String fileUrl = "";
			
			FileItemFactory factory = new DiskFileItemFactory();
			
			ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
			servletFileUpload.setFileSizeMax(maxSizeForFile);
			
			List<FileItem> fileItems = servletFileUpload.parseRequest(request);
			
			if (fileItems == null || fileItems.size() == 0) {
				return;
			}
			
			Iterator<FileItem> fileItemIndex = fileItems.iterator();
			if (fileItemIndex.hasNext()) {
				FileItem file = fileItemIndex.next();
				
				if (file.isFormField()) {
					System.out.println("上传文件非法！");
				}
				
				//获取上传文件的文件名
				 String fileClientName = getFileName(file.getName());
				 
				 //文件格式后缀，例如：JPG、JPEG等
				 //substring(String string,int Start_index):获取从某个指定位置Start_index之后的所有子字符串
	                String fileSuffix = StringUtils.substring(fileClientName,
	                        fileClientName.lastIndexOf(".") + 1);
	                
	                //判断待上传文件的后缀是否在以下格式以内
	                //equalsIgnoreCase(String string1,String string2):判断字符串是否相等（不分大小写）
	                if (!StringUtils.equalsIgnoreCase(fileSuffix, "jpg")
	                        && !StringUtils.equalsIgnoreCase(fileSuffix, "jpeg")
	                        && !StringUtils.equalsIgnoreCase(fileSuffix, "bmp")
	                        && !StringUtils.equalsIgnoreCase(fileSuffix, "gif")
	                        && !StringUtils.equalsIgnoreCase(fileSuffix, "png")
	                        && !StringUtils.equalsIgnoreCase(fileSuffix, "txt")
	                        && !StringUtils.equalsIgnoreCase(fileSuffix, "doc")
	                        && !StringUtils.equalsIgnoreCase(fileSuffix, "docx")
	                        && !StringUtils.equalsIgnoreCase(fileSuffix, "xls")
	                        && !StringUtils.equalsIgnoreCase(fileSuffix, "xlsx")
	                        && !StringUtils.equalsIgnoreCase(fileSuffix, "csv")
	                        && !StringUtils.equalsIgnoreCase(fileSuffix, "ppt")
	                        && !StringUtils.equalsIgnoreCase(fileSuffix, "pptx")
	                        && !StringUtils.equalsIgnoreCase(fileSuffix, "pdf")
	                        && !StringUtils.equalsIgnoreCase(fileSuffix, "wps")
	                        && !StringUtils.equalsIgnoreCase(fileSuffix, "et")
	                        && !StringUtils.equalsIgnoreCase(fileSuffix, "dps")) {
	                   
	                    out.println("<script type=\"text/javascript\">alert('格式错误，仅支持jpg|jpeg|bmp|gif|png|txt|doc|docx|xls|xlsx|csv|ppt|pptx|pdf|wps|et|dps格式');</script>");
	                    out.flush();
	                    out.close();
	                    return;
	                }
	                
	                String fileServerName = generateFileName(folder, fileSuffix);
	                //客户端已经设置好了图片名称能够在服务器内识别
	                File newFile = new File(folder,fileServerName);
	                file.write(newFile);
	                
	                fileUrl = ForResourcesLoad_Dir + fileUpload_Dir + fileUpload_SubIMGDir + "/" +folder.getName() +
	                		"/" + newFile.getName();
	                fileUrl = StringUtils.replace(fileUrl, "//", "/");
	                fileUrl = request.getContextPath() + fileUrl;
	                
	                //将上传图片的URL返回给CKEditor
	                String callback = request.getParameter("CKEditorFuncNum");
	                out.println("<script type=\"text/javascript\">");
	                out.println("window.parent.CKEDITOR.tools.callFunction("
	                        + callback + ",'" + fileUrl + "',''" + ")");
	                out.println("</script>");
			}
			
			//******************图片插入数据库了的Pircture字段***************
			BaseZooplan bioZooplan = bioZooInfoDAO.findBioInfoByFamilyStr("test","MonitZooplan");
			
			
			//*****************此处使用了绝对路径，有待改进*****************
			String fileUrlString = "D:/software/java/tomcat-7.0/webapps"+fileUrl;
			monitZooDAO.saveImgToDB(fileUrlString, bioZooplan);
			//****************end*******************
			out.flush();
			out.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("上传文件异常");
		}
		
			
		return;
		
	}
	
	private String generateFileName(File folder,String suffix){
		String fileName;File file;
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS");
		String base = format.format(date);
		fileName = base + "." + suffix;
		file = new File(fileName);
		int i = 1;
		while(file.exists()) {
			fileName = String.format("%s_%d.%s", base,i,suffix);
			i++;
		}
		return fileName;
	}
	
	/**
	 * 获取文件名
	 * @param str
	 * @return
	 */
	private String getFileName(String str) {
		int index = str.lastIndexOf("//");
		if (index != -1) {
			return str.substring(index);
		}
		else {
			return str;
		}
	}
	/**
	 * 创建目录
	 * @param request
	 * @return
	 */
	
	public File buildFolder(HttpServletRequest request){
		String realPath = request.getSession().getServletContext()
				.getRealPath(ForResourcesLoad_Dir);
		
		//一级目录
		File firstFolder = new File(realPath+fileUpload_Dir);
		if (!firstFolder.exists()) {
			if (firstFolder.mkdir()) {
				return null;
			}
		}
		
		//二级目录
		String folderdir = realPath + fileUpload_Dir + fileUpload_SubIMGDir;
				//是否存在，不存在则重新创建
		if (org.apache.commons.lang.StringUtils.isBlank(folderdir)) {
			System.out.println("路径错误"+folderdir);
			return null;	
		}
		File folder = new File(folderdir);
		if (!folder.exists()) {
			if (!folder.mkdir()) {
				System.out.println("创建二级文件夹出错");
				return null;
			}
			
		}
		
		//最后一级以时间字符串命名
		String[] files = folder.list();
		if (files != null && files.length > 0)
		{
			//若含有子文件夹，则获取最新生成的文件夹
			Date oldDate = null;
			int index = -1;
			for(int i = 0;i < files.length;i++){
				String fileName = files[i];
				try {
					Date thisDate = DateUtils.parseDate(fileName,new String[]{
							subFolderFormat_Auto,subFolderFormat_NOAuto	
					});
					if (oldDate == null) {
						oldDate = thisDate;
						index = i;
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}//end-for
			
			//判断文件夹下是否已经存在了最大数目的图片
			if(oldDate != null && index != -1)
			{
				File pointfloder = new File(folderdir + File.separator+files[index]);
				
				if (!pointfloder.exists()) 
					{
						if (!pointfloder.mkdir()) {
							System.out.println("创建三级文件夹出错");
							return null;
						}
					}
				//如果超过了最大容量，需要重新建立一个文件夹
				String[] pointfloderFiles = pointfloder.list();
				if(pointfloderFiles != null && pointfloderFiles.length > maxNumForFile)
					{
						return buildNewFile(folderdir);
					
					}
				return pointfloder;
			}//end-if
			// 查找当前子文件夹失败，新建一个
			return buildNewFile(folderdir);
		
		}
		else {
			// 不含有子文件夹，新建一个，通常系统首次上传会有这个情况
			return buildNewFile(folderdir);
		}
	
	}//end-build-folder
	
	
	/**
	 * 创建新的文件
	 * @param path
	 * @return
	 */
	private File buildNewFile(String path){
		//若不含有子文件，则新建
		File newFile = buildFileBySysTime(path);
		if (newFile == null) {
			System.out.println("创建文件失败");
		}
	
		return newFile;
	}
	
	
	/**
	 * 根据系统时间建立新的文件
	 * @param path
	 * @return
	 */
	private File buildFileBySysTime(String path) {
		DateFormat dFormat = new SimpleDateFormat(subFolderFormat_Auto);
		String fileName = dFormat.format(new Date());
		File file = new File(path+File.separator+fileName);
		if(!file.mkdir()){
			return null;
		}
		return file;
	}
	
	
}
