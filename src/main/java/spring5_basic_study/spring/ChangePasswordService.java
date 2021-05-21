package spring5_basic_study.spring;
//암호 변경 기능
public class ChangePasswordService {
	
	private MemberDao memberDao;
	
	//암호 변경
	public void changePassword(String email, String oldPwd, String newPwd) {
		Member member = memberDao.selectByEmail(email);
		//만약 멤버가 null이면 멤버못찾음 예외
		if (member == null)
			throw new MemberNotFoundException();
		//찾으면 changePassword실행
		member.changePassword(oldPwd, newPwd);
		
		memberDao.update(member);
	}

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

}
