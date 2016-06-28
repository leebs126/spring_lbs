package ch15.ex4;

import java.util.ArrayList;


public class BoardService {
	BoardDao  dao=new BoardDao();
	public ArrayList<WriteVO> listWrite(){
		System.out.println("ListCommand »£√‚");
		BoardDao  dao = new BoardDao();
		ArrayList<WriteVO> list =  dao.listWrite();
        return list;
	}
	
	public void writeBoard(WriteVO writeVO){
		writeVO.setGroup_id(dao.getNewGroupId());
		writeVO.setMsg_id(dao.getNewMsgId());
		dao.writeBoard(writeVO);		
	}
	
	public WriteVO viewWrite(String msg_id) {
		WriteVO writeVO=null;
		writeVO=dao.viewWrite(msg_id);
		return writeVO;
	}
	
	public void writeReply(WriteVO writeVO) {
		writeVO.setMsg_id(dao.getNewMsgId());
		dao.writeReply(writeVO);
	}
}


