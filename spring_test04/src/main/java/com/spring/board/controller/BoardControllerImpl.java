
package com.spring.board.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.spring.board.service.BoardService;
import com.spring.board.vo.WriteBean;


@Controller("boardController")
@RequestMapping(value="/board")
public class BoardControllerImpl  extends MultiActionController implements BoardController{
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/listWrite.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView listWrite(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mav=new ModelAndView();
		String fileName=getFileName(request);
		mav.setViewName(fileName);
		String message=request.getParameter("message");
		String _chapter=request.getParameter("chapter");
		String _pageNum=request.getParameter("pageNum");
		int chapter=Integer.parseInt(((_chapter==null)? "1":_chapter) );
		int pageNum=Integer.parseInt(((_pageNum==null)? "1":_pageNum) );
		HashMap map=new HashMap();
		map.put("chapter", chapter);
		map.put("pageNum", pageNum);
		HashMap writeMap=boardService.listWrite(map);
		
		ArrayList<WriteBean> writeList=(ArrayList<WriteBean>)writeMap.get("writeList");
		int totWrite=(Integer)writeMap.get("totWrite");
		//totWrite=120;
		mav.addObject("message",message);
		mav.addObject("chapter",chapter);
		mav.addObject("pageNum",pageNum);
		mav.addObject("totWrite", totWrite);
		mav.addObject("writeList",writeList);
		
		return mav;
	}
	
	@RequestMapping(value="/addWrite.do" ,method=RequestMethod.POST)
	public ModelAndView addWrite(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		ModelAndView mav=new ModelAndView();
		HashMap<String,String> writeMap =processFile(request,response);
		WriteBean writeBean=new WriteBean();
		String author=writeMap.get("author");	
		String email=writeMap.get("email");
		String title=writeMap.get("title");
		String content=writeMap.get("content");
		String passwd=writeMap.get("passwd");
		String imageFile=writeMap.get("imageFile");
							
		writeBean.setAuthor(author);
		writeBean.setEmail(email);
		writeBean.setTitle(title);
		writeBean.setContent(content);
		writeBean.setPasswd(passwd);
		writeBean.setImageFile(imageFile);
		boardService.addWrite(writeBean);
		mav.addObject("message", "new_write");
		mav.setViewName("redirect:/board/listWrite.do");
		return mav;
	}
	
	@RequestMapping(value="/viewWrite.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public  ModelAndView viewWrite(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav=new ModelAndView();
		String fileName=getFileName(request);
		mav.setViewName(fileName);
		WriteBean writeBean=new WriteBean();
		String msg_id = request.getParameter("msg_id");
		writeBean=boardService.viewWrite(Integer.parseInt(msg_id));
		request.setAttribute("write",writeBean);
		return mav;
	}
	
	@RequestMapping(value="/removeWrite.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public  ModelAndView removeWrite(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav=new ModelAndView();
		WriteBean writeBean=new WriteBean();
		
		int msg_id = Integer.parseInt(request.getParameter("msg_id"));
		int group_id =Integer.parseInt(request.getParameter("group_id"));
		int parent_id =Integer.parseInt(request.getParameter("parent_id"));
		String imageFile =request.getParameter("imageFile");
		
		System.out.println(msg_id);
		writeBean.setMsg_id(msg_id);
		writeBean.setGroup_id(group_id);
		writeBean.setParent_id(parent_id);
		
		boardService.removeWrite(writeBean);
		deleteFile(imageFile);  
		mav.addObject("message", "delete_write");
		mav.setViewName("redirect:/board/listWrite.do");
		return mav;
	}
	@RequestMapping(value="/addReply.do" ,method={RequestMethod.POST,RequestMethod.GET})	
	public  ModelAndView addReply(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		ModelAndView mav=new ModelAndView();
		WriteBean writeBean=new WriteBean();
		HttpSession session=request.getSession();
		int group_id=(Integer)session.getAttribute("group_id");
		int parent_id=(Integer)session.getAttribute("parent_id");
		
		String author = request.getParameter("author");	
		String email = request.getParameter("email");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String passwd = request.getParameter("passwd");
		
		writeBean =new WriteBean();
		writeBean.setGroup_id(group_id);
		writeBean.setParent_id(parent_id);
		writeBean.setContent(content);
		writeBean.setAuthor(author);
		writeBean.setEmail(email);
		writeBean.setTitle(title);
		writeBean.setContent(content);
		writeBean.setPasswd(passwd);		
		boardService.addReply(writeBean);
		request.setAttribute("message", "reply_write");
		mav.setViewName("redirect:/board/listWrite.do");
		return mav;
	}
	
	@RequestMapping(value="/modWrite.do" ,method={RequestMethod.POST,RequestMethod.GET})	
	public  void modWrite(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		ModelAndView mav=new ModelAndView();
		WriteBean writeBean=new WriteBean();
		
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
		boolean isModSuccess =boardService.modWrite(writeMap);	
		
		PrintWriter writer = response.getWriter();		
		if(isModSuccess==true){
			writer.print("modify_success");	
		}else{
			writer.print("modify_fail");
		}
		return ;
	}
	
	@RequestMapping(value="/*.do" ,method={RequestMethod.POST,RequestMethod.GET})
	private  ModelAndView viewJSP(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String fileName=getFileName(request);
		if(fileName.equals("/board/replyForm")){
			int group_id = Integer.parseInt(request.getParameter("group_id"));
			int parent_id = Integer.parseInt(request.getParameter("parent_id"));
		    HttpSession session=request.getSession();
			session.setAttribute("group_id",new Integer(group_id));
			session.setAttribute("parent_id",new Integer(parent_id));
		}
		ModelAndView mav = new ModelAndView(fileName);
		return mav;
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
	
	private  String getFileName(HttpServletRequest request) throws Exception {
		String contextPath = request.getContextPath();
		String uri = (String)request.getAttribute("javax.servlet.include.request_uri");

		if(uri == null || uri.trim().equals("")) {
			uri = request.getRequestURI();
		}

		int begin = 0;
		if(!((contextPath == null) || ("".equals(contextPath)))) {
			begin = contextPath.length();
		}

		int end;
		if(uri.indexOf(";") != -1) {
			end = uri.indexOf(";");
		} else if(uri.indexOf("?") != -1) {
			end = uri.indexOf("?");
		} else {
			end = uri.length();
		}

		String fileName = uri.substring(begin, end);
		if(fileName.indexOf(".") != -1) {
		        fileName = fileName.substring(0, fileName.lastIndexOf("."));
		}
		return fileName;
	}
	
}