package com.shop.common.file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.shop.goods.ImageFileVO;

@WebServlet("/file/uploadFile.do")
public class UpLoadController  extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response ) throws IOException{
		doHandle(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		doHandle(request,response);
	}
	
	public void doHandle(HttpServletRequest request, HttpServletResponse response) throws IOException{
		try{
			String goods_id = null;
			String tempDir = "C:\\file_repo";
			String encoding = "utf-8";
			File uploadFile = null;
			FileService service=new FileService();
			ArrayList<ImageFileVO> fileList=new ArrayList<ImageFileVO>();
			File currentDirPath =new File(tempDir);
			HashMap fileMap=new HashMap();
			
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setRepository(currentDirPath );
			factory.setSizeThreshold(1024*1024);
			
			ServletFileUpload upload=new ServletFileUpload(factory);
			List<?> items = upload.parseRequest(request);
			
			for(int i=0; i < items.size();i++){
				FileItem fileItem = (FileItem) items.get(i);
				ImageFileVO vo=new ImageFileVO();
				if(fileItem.isFormField()){
					goods_id=fileItem.getString(encoding);
					fileMap.put("goods_id", goods_id);
					tempDir+="\\"+goods_id;
					new  File(tempDir).mkdir();
				}else{
					String fileName=fileItem.getName();
					String fileType=fileItem.getFieldName();
					
					vo.setFileName(fileName);
					vo.setFileType(fileType);
					
					System.out.println(fileItem.getFieldName());
					System.out.println(fileItem.getName());
					System.out.println(fileItem.getSize( ) + "bytes");
					if(fileItem.getSize() > 0){
						int idx = fileItem.getName().lastIndexOf("\\");
						if(idx ==-1){
							idx = fileItem.getName().lastIndexOf("/");
						}
						
						String fName = fileItem.getName().substring(idx+1);
						request.setAttribute(fileItem.getFieldName(),fName);
						try{
							System.out.println("저장위치:"+tempDir+"\\"+fName);
							uploadFile = new  File(tempDir+"\\"+fName);
							
							fileItem.write(uploadFile);
							System.out.println("uploadfile");
						}catch(IOException e){
							e.printStackTrace();
						}
					}
					fileList.add(vo);
					fileMap.put("fileList", fileList);
				}
				
		
		   }
		   service.addFile(fileMap);
		   request.setAttribute("command", "list");
		   request.setAttribute("message", "add_new_goods");
		   RequestDispatcher dispatch = request.getRequestDispatcher("/main/main.do"); 
		   dispatch.forward(request, response);
	}catch(Exception e){
		e.printStackTrace();
	}
	
}
}
