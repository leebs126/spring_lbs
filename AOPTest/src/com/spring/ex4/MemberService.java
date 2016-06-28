package com.spring.ex4;

import org.apache.commons.logging.Log;

public class MemberService {
	MemberDao memberDao;
	Log logger;
	TransactionManager txManager;
	SecurityService securityService;
	NotificationPolicy notiPolicy;
	EmailService emailService;
	
	public void upgradeLevel(List<MemberVO> memberList, int newLevel){
		//로깅기능
		if(logger.isDebug()){
			logger.debug("회원 등급 ",memberList,newLevel);
		}
		
		//보안 기능
		if(!securityService.checkAuthorityForModify(MemberVO)){
			if(!logger.isWarnEnabled()){
				logger.warn("보안 등급 위반:회원 정보 수정 권한 없음",new Date());
			}
			throw new SecurityException(MemberVO);
		}
		
		//트랙잰션 기능
		Transaction tx;
		try{
			tx=transactionServie.beginTransaction();
			for(MemberVO member: memberList){
				member.changeLevel(newLevel);
				memberDAO.updateMemnber(member);
			}
			tx=transactionServie.endTransaction();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	

}
