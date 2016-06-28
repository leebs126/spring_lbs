package com.spring.ex5;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

@Transactional(propagation=Propagation.REQUIRED)
public class TranService {
	private TranDao tranDao;
	public void setTranDao(TranDao tranDao){
		this.tranDao = tranDao;
	}
		
	public void addMember()  throws Exception{
		tranDao.insertMember();
	}
}
