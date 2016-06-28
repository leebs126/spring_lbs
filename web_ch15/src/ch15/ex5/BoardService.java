package ch15.ex5;

import java.util.ArrayList;
import java.util.HashMap;


public class BoardService {
	BoardDao  dao=new BoardDao();
	public ArrayList<WriteVO> listWrite(WriteVO writeVO){
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
	
	public boolean modWrite(HashMap<String,String> writeMap){
		boolean isModSuccess=dao.modWrite(writeMap);
		return isModSuccess;
	}
	
	public void delWrite(WriteVO writeVO){
		int pre_msg_id=writeVO.getMsg_id();
		int group_id=writeVO.getGroup_id();
		int parent_id=writeVO.getParent_id();
		ArrayList<WriteVO> writeList=dao.groupIdList(group_id);
		
		if(parent_id==0){ //부모글을 삭제하는 경우
			for(int i=0; i<writeList.size();i++){
				WriteVO vo=(WriteVO)writeList.get(i);
				pre_msg_id=vo.getMsg_id();
				dao.delWrite(pre_msg_id);
			}
		}else{
			int write_id=pre_msg_id;
			
			for(int i=0; i<writeList.size();i++){
				WriteVO vo=(WriteVO)writeList.get(i);
				
				write_id=vo.getMsg_id();
				if(write_id<pre_msg_id)
					continue;
				
				parent_id=vo.getParent_id();
				
				if(pre_msg_id==write_id){
					dao.delWrite(pre_msg_id);
					//continue;
				}else if(pre_msg_id==parent_id){
					dao.delWrite(write_id);
				}
				pre_msg_id=write_id;
			}
		}
	}
}


