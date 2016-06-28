package com.spring.ex3;

public class MemberServiceImpl  implements MemberService{
	private MemberDao memberDAO;

	public void setMemberDAO(MemberDao memberDAO) {
		this.memberDAO = memberDAO;
	}

	public void getMemberInfo() {
		memberDAO.selectMemberInfo();
		
	}
}


