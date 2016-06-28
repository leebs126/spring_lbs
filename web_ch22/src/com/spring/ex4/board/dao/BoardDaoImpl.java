/*
ÆÄÀÏ¸í:BoardDAO2.java

*/

package com.spring.ex4.board.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.ex4.board.vo.WriteBean;

@Repository("boardDao")
public class BoardDaoImpl implements BoardDao{
	@Autowired
   private SqlSession sqlSession;
	public ArrayList selectWriteList(HashMap map){
		ArrayList<WriteBean> writeList=(ArrayList<WriteBean>) sqlSession.selectList("mapper.board.selectWriteList",map);
		return writeList;
	}
	
	
	public   int getTotWrite(){
	   int totWrite=(Integer)sqlSession.selectOne("mapper.board.getTotWrite");
	   return totWrite;
	}
	
	public void insertWrite(WriteBean writeBean){
	   writeBean.setGroup_id(getNewGroupId());
	   writeBean.setMsg_id(getNewMsgId());
	   sqlSession.insert("mapper.board.insertWrite",writeBean);
	}
	public WriteBean selectWrite(int msg_id){
		WriteBean writeBean=(WriteBean)sqlSession.selectOne("mapper.board.selectWrite",msg_id);
		return writeBean;
	}
	
	public void deleteWrite(int msg_id) {
		sqlSession.delete("mapper.board.deleteWrite",msg_id);
	}
	
	public ArrayList<WriteBean> getGroupIdList(int group_id){
		ArrayList<WriteBean> writeList=(ArrayList<WriteBean>) sqlSession.selectList("mapper.board.getGroupIdList",group_id);
		return writeList;
	}
	
	public void insertReply(WriteBean writeBean){
		writeBean.setMsg_id(getNewMsgId());
		 sqlSession.insert("mapper.board.insertReply",writeBean);
	}
	
	public boolean updateWrite(HashMap<String,String> writeMap){
		int result=sqlSession.update("mapper.board.updateWrite",writeMap);
		if(result!=0)
			return true;
		else 
			return false;
	}
	
	private int getNewMsgId(){
		int msg_id=(Integer)sqlSession.selectOne("mapper.board.getNewMsgId");
		return msg_id;	
	}
	
	private   int getNewGroupId(){
		int group_id=(Integer)sqlSession.selectOne("mapper.board.getNewGroupId");
		return group_id;
	}
	
}
