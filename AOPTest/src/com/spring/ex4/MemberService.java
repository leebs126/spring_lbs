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
		//�α���
		if(logger.isDebug()){
			logger.debug("ȸ�� ��� ",memberList,newLevel);
		}
		
		//���� ���
		if(!securityService.checkAuthorityForModify(MemberVO)){
			if(!logger.isWarnEnabled()){
				logger.warn("���� ��� ����:ȸ�� ���� ���� ���� ����",new Date());
			}
			throw new SecurityException(MemberVO);
		}
		
		//Ʈ����� ���
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
