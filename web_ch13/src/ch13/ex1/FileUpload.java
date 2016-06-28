
package ch13.ex1;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/*@WebServlet("/fileUpload.do")*/
public class FileUpload extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response ) throws IOException{
		doHandle(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		doHandle(request,response);
	}
	
	public void doHandle(HttpServletRequest request, HttpServletResponse response) throws IOException{
		request.setCharacterEncoding("utf-8");
		
		try{
			String encoding="utf-8";
			//String tempDir = "C:\\file_repo";
			File currentDirPath =new File("C:\\file_repo");
			
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setRepository(currentDirPath );
			factory.setSizeThreshold(1024*1024);
			
			ServletFileUpload upload=new ServletFileUpload(factory);
			
			List<?> items = upload.parseRequest(request);
			for(int i=0; i < items.size();i++){
				FileItem fileItem = (FileItem) items.get(i);
				
				if(fileItem.isFormField()){
					System.out.println(fileItem.getFieldName()+ "=" +fileItem.getString(encoding));
				}else{
					
					System.out.println("파라미터명:"+fileItem.getFieldName());
					System.out.println("파일명:"+fileItem.getName());
					System.out.println("파일크기:"+fileItem.getSize( ) + "bytes");
					
					//업로드한 파일이 존재하는 경우
					if(fileItem.getSize() > 0){
						int idx = fileItem.getName().lastIndexOf("\\");
						if(idx ==-1){
							idx = fileItem.getName().lastIndexOf("/");
						}
						
						String fileName = fileItem.getName().substring(idx+1);
						try{
							File uploadFile = new  File(currentDirPath +"\\"+ fileName);
							fileItem.write(uploadFile);
						}catch(IOException e){
							e.printStackTrace();
						}
					}
				
				}
			
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
	

}





