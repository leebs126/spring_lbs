package ch15.ex4;

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
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/*@WebServlet("/board.do")*/
public class BoardFrontController  extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		doHandle(request, response);	
	}	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		doHandle(request, response);	
	}
	
	public void doHandle(HttpServletRequest request, HttpServletResponse response) throws IOException{
		System.out.println("BoardFontController 호출");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String action = request.getParameter("action");
		String nextPage ="";
		WriteVO writeVO=null;
		BoardService service=null;
		try{
			System.out.println("action = " +action);
			ArrayList<WriteVO> listWrite =new ArrayList<WriteVO>();		
			writeVO=new WriteVO();
			service=new BoardService();
			
			if (action==null){  //최초요청 시				
				listWrite=service.listWrite();
				request.setAttribute("listWrite",listWrite);
				nextPage = "/ex4/listWrite.jsp";				
			}else if(action.equals("listWrite")){  			//목록보기
				listWrite=service.listWrite();
				request.setAttribute("listWrite",listWrite);
				nextPage = "/ex4/listWrite.jsp";			
			}else if(action.equals("viewWrite")){
				String msg_id = request.getParameter("msg_id");
				writeVO=service.viewWrite(msg_id);
				request.setAttribute("write",writeVO);
				nextPage = "/ex4/viewWrite.jsp";
			}else if(action.equals("reply.ui")){
				int group_id = Integer.parseInt(request.getParameter("group_id"));
				int parent_id = Integer.parseInt(request.getParameter("parent_id"));
				HttpSession session=request.getSession();
				session.setAttribute("group_id",new Integer(group_id));
				session.setAttribute("parent_id",new Integer(parent_id));
				nextPage = "/ex4/replyForm.jsp";
				
			}
			else if(action.equals("writeReply")){
				HttpSession session=request.getSession();
				int group_id=(Integer)session.getAttribute("group_id");
				int parent_id=(Integer)session.getAttribute("parent_id");
				
				String author = request.getParameter("author");	
				String email = request.getParameter("email");
				String title = request.getParameter("title");
				String content = request.getParameter("content");
				String passwd = request.getParameter("passwd");
				
				writeVO =new WriteVO();
				writeVO.setGroup_id(group_id);
				writeVO.setParent_id(parent_id);
				writeVO.setContent(content);
				writeVO.setAuthor(author);
				writeVO.setEmail( email);
				writeVO.setTitle( title);
				writeVO.setContent( content);
				writeVO.setPasswd( passwd);		
				
				service.writeReply(writeVO);
				request.setAttribute("message", "답글을 등록했습니다!!");
				nextPage = "board.do?action=listWrite";
				response.sendRedirect(nextPage);
				return ;
			}
			
			else if(action.equals("write.ui")){   //글쓰기 화면
				nextPage ="/ex4/writeForm.jsp";	
			}
			
			else if(action.equals("write.do")){
				HashMap<String,String> writeMap =processFile(request,response);
				String author=writeMap.get("author");	
				String email=writeMap.get("email");
				String title=writeMap.get("title");
				String content=writeMap.get("content");
				String passwd=writeMap.get("passwd");
				String imageFile=writeMap.get("imageFile");
									
				writeVO.setAuthor(author);
				writeVO.setEmail(email);
				writeVO.setTitle(title);
				writeVO.setContent(content);
				writeVO.setPasswd(passwd);
				writeVO.setImageFile(imageFile);
				
				service.writeBoard(writeVO);				
				nextPage = "board.do?action=listWrite";
				request.setAttribute("message", "new_write");
			}
			
			RequestDispatcher dis=  request.getRequestDispatcher(nextPage);			
			dis.forward(request, response);
			
			
		}catch(Exception e){
			e.printStackTrace();				
		}	
	}
	
	private HashMap<String,String>  processFile(HttpServletRequest request, HttpServletResponse response) throws Exception{
		HashMap<String,String> writeMap=new HashMap<String,String>();
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
				writeMap.put(fileItem.getFieldName(), fileItem.getString(encoding));
			}else{
				System.out.println("파라미터명:"+fileItem.getFieldName());
				System.out.println("파일명:"+fileItem.getName());
				System.out.println("파일크기:"+fileItem.getSize( ) + "bytes");
				writeMap.put(fileItem.getFieldName(), fileItem.getName());
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
		
		
		return writeMap;
	}
	
}