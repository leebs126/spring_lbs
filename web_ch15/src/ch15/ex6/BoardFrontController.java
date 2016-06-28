
package ch15.ex6;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet("/board.do")
public class BoardFrontController  extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		doHandle(request, response);	
	}	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		doHandle(request, response);	
	}
	
	public void doHandle(HttpServletRequest request, HttpServletResponse response) throws IOException{
		System.out.println("FontController 호출");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String action = request.getParameter("action");
		String nextPage ="";
		WriteVO writeVO=null;
		BoardService service=null;
		HttpSession session=null;
		try{
			System.out.println("action = " +action);
			ArrayList<WriteVO> listWrite =new ArrayList<WriteVO>();		
			writeVO=new WriteVO();
			service=new BoardService();
			
			if (action==null){  //최초요청 시
				String _chapter=request.getParameter("chapter");
				String _pageNum=request.getParameter("pageNum");
				int chapter=Integer.parseInt(((_chapter==null)? "1":_chapter) );
				int pageNum=Integer.parseInt(((_pageNum==null)? "1":_pageNum) );
				HashMap map=new HashMap();
				map.put("chapter", chapter);
				map.put("pageNum", pageNum);
				HashMap writeMap=service.listWrite(map);
				listWrite=(ArrayList)writeMap.get("listWrite");
				int totWrite=(Integer)writeMap.get("totWrite");
				totWrite=120;
				request.setAttribute("chapter", chapter);
				request.setAttribute("pageNum", pageNum);
				request.setAttribute("totWrite", totWrite);
				request.setAttribute("listWrite",listWrite);
				nextPage = "/ex6/listWrite.jsp";				
			}else if(action.equals("listWrite")){  
				String _chapter=request.getParameter("chapter");
				String _pageNum=request.getParameter("pageNum");
				int chapter=Integer.parseInt(((_chapter==null)? "1":_chapter) );
				int pageNum=Integer.parseInt(((_pageNum==null)? "1":_pageNum) );
				HashMap map=new HashMap();
				map.put("chapter", chapter);
				map.put("pageNum", pageNum);
				HashMap writeMap=service.listWrite(map);
				listWrite=(ArrayList)writeMap.get("listWrite");
				int totWrite=(Integer)writeMap.get("totWrite");
				
				request.setAttribute("chapter", chapter);
				request.setAttribute("pageNum", pageNum);
				request.setAttribute("totWrite", totWrite);
				request.setAttribute("listWrite",listWrite);
				nextPage = "/ex6/listWrite.jsp";			
			}else if(action.equals("viewWrite")){
				String msg_id = request.getParameter("msg_id");
				writeVO=service.viewWrite(msg_id);
				request.setAttribute("write",writeVO);
				nextPage = "/ex6/viewWrite.jsp";
			}else if(action.equals("reply.ui")){
				int group_id = Integer.parseInt(request.getParameter("group_id"));
				int parent_id = Integer.parseInt(request.getParameter("parent_id"));
			    session=request.getSession();
				session.setAttribute("group_id",new Integer(group_id));
				session.setAttribute("parent_id",new Integer(parent_id));
				nextPage = "/ex6/replyForm.jsp";
				
			}else if(action.equals("writeReply")){
				 session=request.getSession();
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
				writeVO.setEmail(email);
				writeVO.setTitle(title);
				writeVO.setContent(content);
				writeVO.setPasswd(passwd);		
				service.writeReply(writeVO);
				request.setAttribute("message", "reply_write");
				nextPage = "board.do?action=listWrite";
			}
			
			else if(action.equals("write.ui")){   //글쓰기 화면
				nextPage ="/ex6/writeForm.jsp";	
			}else if(action.equals("write")){
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
				request.setAttribute("message", "new_write");
				nextPage = "board.do?action=listWrite";
			}else if(action.equals("modWrite")){
				HashMap<String,String> writeMap =new HashMap<String,String>();
				String msg_id = request.getParameter("msg_id");	
				String param = request.getParameter("param");	
				
				if(param.equals("imageFile")){  //이미지 파일을 수정하는 경우
					String preImageFile = request.getParameter("preImageFile");
					deleteFile(preImageFile);  //기존 파일을 지운후 다른 파일을 저장한다.
					writeMap=processFile(request,response);
					writeMap.put("msg_id",msg_id);
				}else{
					String value = request.getParameter("value");
					System.out.println("msg_id:"+msg_id);
					System.out.println(param+","+value);
					writeMap.put("msg_id",msg_id);
					writeMap.put(param, value);
					
				}
				boolean isModSuccess =service.modWrite(writeMap);	
				
				PrintWriter writer = response.getWriter();		
				if(isModSuccess==true){
					writer.print("글을 수정 했습니다.");	
				}else{
					writer.print("다시 수정해 주세요.");
				}
				
				return ;
			}else if(action.equals("delWrite")){
				int msg_id = Integer.parseInt(request.getParameter("msg_id"));
				int group_id =Integer.parseInt(request.getParameter("group_id"));
				int parent_id =Integer.parseInt(request.getParameter("parent_id"));
				String imageFile =request.getParameter("imageFile");
				
				System.out.println(msg_id);
				writeVO.setMsg_id(msg_id);
				writeVO.setGroup_id(group_id);
				writeVO.setParent_id(parent_id);
				
				service.delWrite(writeVO);
				deleteFile(imageFile);  //삭제된 글 이미지파일을 삭제한다.
				request.setAttribute("message", "delete_write");
				nextPage = "board.do?action=listWrite";
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
	
	private void deleteFile(String fileName) {
		File file =new File("C:\\file_repo\\"+fileName);
		try{
			file.delete();
		}catch(Exception e){
			e.printStackTrace();
		}
	}	
	
}