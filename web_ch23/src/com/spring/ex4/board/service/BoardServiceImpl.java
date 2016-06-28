package com.spring.ex4.board.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.ex4.board.dao.BoardDao;
import com.spring.ex4.board.vo.WriteBean;

@Service("boardService")
public class BoardServiceImpl  implements BoardService{
	@Autowired
	BoardDao boardDao;
	public HashMap  listWrite(HashMap map){
		HashMap writeMap =new HashMap();
		ArrayList<WriteBean> writeList =  boardDao.selectWriteList(map);
		int totWrite=boardDao.getTotWrite();
		writeMap.put("writeList",writeList);
		writeMap.put("totWrite",totWrite);
        return writeMap;
	}
	
	public void addWrite(WriteBean writeBean){
		boardDao.insertWrite(writeBean);		
	}
	
	public WriteBean viewWrite(int msg_id) {
		WriteBean writebean=boardDao.selectWrite(msg_id);
		return writebean;
	}
	
	public void removeWrite(WriteBean writeBean){
		int pre_msg_id=writeBean.getMsg_id();
		int group_id=writeBean.getGroup_id();
		int parent_id=writeBean.getParent_id();
		ArrayList<WriteBean> writeList=boardDao.getGroupIdList(group_id);
		
		if(parent_id==0){ //부모글을 삭제하는 경우
			for(int i=0; i<writeList.size();i++){
				WriteBean vo=(WriteBean)writeList.get(i);
				pre_msg_id=vo.getMsg_id();
				boardDao.deleteWrite(pre_msg_id);
			}
		}else{
			int write_id=pre_msg_id;
			
			for(int i=0; i<writeList.size();i++){
				WriteBean vo=(WriteBean)writeList.get(i);
				
				write_id=vo.getMsg_id();
				if(write_id<pre_msg_id)
					continue;
				
				parent_id=vo.getParent_id();
				
				if(pre_msg_id==write_id){
					boardDao.deleteWrite(pre_msg_id);
				}else if(pre_msg_id==parent_id){
					boardDao.deleteWrite(write_id);
				}
				pre_msg_id=write_id;
			}
		}
	}
	public void addReply(WriteBean writeBean){
		boardDao.insertReply(writeBean);
	}
	public boolean modWrite(HashMap<String,String> writeMap){
		boolean isModSuccess=boardDao.updateWrite(writeMap);
		return isModSuccess;
		
	}
	
}


