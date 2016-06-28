package com.spring.ex4.board.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.spring.ex4.board.vo.WriteBean;

public interface BoardDao {
	public ArrayList selectWriteList(HashMap map);
	public void insertWrite(WriteBean writeBean);
	public void deleteWrite(int msg_id);
	public WriteBean selectWrite(int msg_id);
	public void insertReply(WriteBean writeBean);
	public boolean updateWrite(HashMap<String,String> writeMap);
	

	public int getTotWrite();
	public ArrayList<WriteBean> getGroupIdList(int group_id);

}
