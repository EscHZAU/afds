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
	
	//�����ļ�·��URL
	private static final String fileUpload_Dir = "/upload";
	private static final String fileUpload_SubIMGDir = "/img";
	private static final String ForResourcesLoad_Dir = "/resources";
	
	//�ϴ���Ŀ¼�б����ļ��������Ŀ
	private static final int maxNumForFile = 500;
	//�����ϴ��ļ���С
	private static final long maxSizeForFile = 1024*1024*2;
	//ϵͳĬ�Ͻ�����ʹ�õ���ʱ���ַ�����Ϊ�ļ����Ƶ�ʱ���ʽ
	private static final String subFolderFormat_Auto = "yyyyMMdd";
	//�����ʽ
	private static final String subFolderFormat_NOAuto = "yyyy-MM-dd";
	
	@RequestMapping(value = "/fileEditor",method = RequestMethod.GET)
	public String processUpload(ModelMap modelMap,HttpServletRequest request,HttpServletResponse response){
		processUploadPost(modelMap, request, response);
		
		return "NewFile";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void processUploadPost(ModelMap modelMap,HttpServletRequest request,HttpServletResponse response){
		//�ж��ύ�����Ƿ�����ļ�
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (!isMultipart) {
			return;
		}
		//��ȡ�ļ�Ŀ¼
		File folder = buildFolder(request);
		if(folder == null){
			return;
		}
		
		try {
			response.setContentType("text/html;charset=UTF-8");
			response.setHeader("Cache-Control", "no-cache");
			PrintWriter out = response.getWriter();
			//�ϴ��ļ��ķ��ص�ַ
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
					System.out.println("�ϴ��ļ��Ƿ���");
				}
				
				//��ȡ�ϴ��ļ����ļ���
				 String fileClientName = getFileName(file.getName());
				 
				 //�ļ���ʽ��׺�����磺JPG��JPEG��
				 //substring(String string,int Start_index):��ȡ��ĳ��ָ��λ��Start_index֮����������ַ���
	                String fileSuffix = StringUtils.substring(fileClientName,
	                        fileClientName.lastIndexOf(".") + 1);
	                
	                //�жϴ��ϴ��ļ��ĺ�׺�Ƿ������¸�ʽ����
	                //equalsIgnoreCase(String string1,String string2):�ж��ַ����Ƿ���ȣ����ִ�Сд��
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
	                   
	                    out.println("<script type=\"text/javascript\">alert('��ʽ���󣬽�֧��jpg|jpeg|bmp|gif|png|txt|doc|docx|xls|xlsx|csv|ppt|pptx|pdf|wps|et|dps��ʽ');</script>");
	                    out.flush();
	                    out.close();
	                    return;
	                }
	                
	                String fileServerName = generateFileName(folder, fileSuffix);
	                //�ͻ����Ѿ����ú���ͼƬ�����ܹ��ڷ�������ʶ��
	                File newFile = new File(folder,fileServerName);
	                file.write(newFile);
	                
	                fileUrl = ForResourcesLoad_Dir + fileUpload_Dir + fileUpload_SubIMGDir + "/" +folder.getName() +
	                		"/" + newFile.getName();
	                fileUrl = StringUtils.replace(fileUrl, "//", "/");
	                fileUrl = request.getContextPath() + fileUrl;
	                
	                //���ϴ�ͼƬ��URL���ظ�CKEditor
	                String callback = request.getParameter("CKEditorFuncNum");
	                out.println("<script type=\"text/javascript\">");
	                out.println("window.parent.CKEDITOR.tools.callFunction("
	                        + callback + ",'" + fileUrl + "',''" + ")");
	                out.println("</script>");
			}
			
			//******************ͼƬ�������ݿ��˵�Pircture�ֶ�***************
			BaseZooplan bioZooplan = bioZooInfoDAO.findBioInfoByFamilyStr("test","MonitZooplan");
			
			
			//*****************�˴�ʹ���˾���·�����д��Ľ�*****************
			String fileUrlString = "D:/software/java/tomcat-7.0/webapps"+fileUrl;
			monitZooDAO.saveImgToDB(fileUrlString, bioZooplan);
			//****************end*******************
			out.flush();
			out.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("�ϴ��ļ��쳣");
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
	 * ��ȡ�ļ���
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
	 * ����Ŀ¼
	 * @param request
	 * @return
	 */
	
	public File buildFolder(HttpServletRequest request){
		String realPath = request.getSession().getServletContext()
				.getRealPath(ForResourcesLoad_Dir);
		
		//һ��Ŀ¼
		File firstFolder = new File(realPath+fileUpload_Dir);
		if (!firstFolder.exists()) {
			if (firstFolder.mkdir()) {
				return null;
			}
		}
		
		//����Ŀ¼
		String folderdir = realPath + fileUpload_Dir + fileUpload_SubIMGDir;
				//�Ƿ���ڣ������������´���
		if (org.apache.commons.lang.StringUtils.isBlank(folderdir)) {
			System.out.println("·������"+folderdir);
			return null;	
		}
		File folder = new File(folderdir);
		if (!folder.exists()) {
			if (!folder.mkdir()) {
				System.out.println("���������ļ��г���");
				return null;
			}
			
		}
		
		//���һ����ʱ���ַ�������
		String[] files = folder.list();
		if (files != null && files.length > 0)
		{
			//���������ļ��У����ȡ�������ɵ��ļ���
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
			
			//�ж��ļ������Ƿ��Ѿ������������Ŀ��ͼƬ
			if(oldDate != null && index != -1)
			{
				File pointfloder = new File(folderdir + File.separator+files[index]);
				
				if (!pointfloder.exists()) 
					{
						if (!pointfloder.mkdir()) {
							System.out.println("���������ļ��г���");
							return null;
						}
					}
				//��������������������Ҫ���½���һ���ļ���
				String[] pointfloderFiles = pointfloder.list();
				if(pointfloderFiles != null && pointfloderFiles.length > maxNumForFile)
					{
						return buildNewFile(folderdir);
					
					}
				return pointfloder;
			}//end-if
			// ���ҵ�ǰ���ļ���ʧ�ܣ��½�һ��
			return buildNewFile(folderdir);
		
		}
		else {
			// ���������ļ��У��½�һ����ͨ��ϵͳ�״��ϴ�����������
			return buildNewFile(folderdir);
		}
	
	}//end-build-folder
	
	
	/**
	 * �����µ��ļ�
	 * @param path
	 * @return
	 */
	private File buildNewFile(String path){
		//�����������ļ������½�
		File newFile = buildFileBySysTime(path);
		if (newFile == null) {
			System.out.println("�����ļ�ʧ��");
		}
	
		return newFile;
	}
	
	
	/**
	 * ����ϵͳʱ�佨���µ��ļ�
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
