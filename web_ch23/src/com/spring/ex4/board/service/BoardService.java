package com.spring.ex4.board.service;

import java.util.HashMap;

import com.spring.ex4.board.vo.WriteBean;

public interface BoardService {
	public HashMap  listWrite(HashMap map);
	public void addWrite(WriteBean writeBean);
	public void removeWrite(WriteBean writeBean);
	public WriteBean viewWrite(int msg_id);
	public void addReply(WriteBean writeBean);
	
	public boolean modWrite(HashMap<String,String> writeMap);
	
	
}
