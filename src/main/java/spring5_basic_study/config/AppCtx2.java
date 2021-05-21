package spring5_basic_study.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring5_basic_study.spring.ChangePasswordService;
import spring5_basic_study.spring.MemberDao;
import spring5_basic_study.spring.MemberInfoPrinter;
import spring5_basic_study.spring.MemberListPrinter;
import spring5_basic_study.spring.MemberPrinter;
import spring5_basic_study.spring.MemberRegisterService;
import spring5_basic_study.spring.VersionPrinter;

@Configuration
public class AppCtx2 {
	//AppConf1로 갔다
//	@Bean
//	public MemberDao memberDao() {
//		return new MemberDao();
//	}
	//AppConf1로 갔는 놈들 대신 ▽▽써준다
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private MemberPrinter memberPrinter;

	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao);
	}

	@Bean
	public ChangePasswordService changePwdSvc() {
		ChangePasswordService pwdSvc = new ChangePasswordService();
		pwdSvc.setMemberDao(memberDao);
		return pwdSvc;
	}

//	@Bean
//	public SelectService memberSelSvc() {
//		SelectService selSvc = new SelectService(memberDao());
//		return selSvc;
//	}
	
	//AppConf1로 갔다
//	@Bean
//	public MemberPrinter memberPrinter() {
//		return new MemberPrinter();
//	}

	@Bean
	public MemberListPrinter listPrinter() {
		return new MemberListPrinter(memberDao, memberPrinter);
	}
	
	@Bean
	public MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter infoPrinter=new MemberInfoPrinter();
//		infoPrinter.setMemberDao(memberDao);
//		infoPrinter.setPrinter(memberPrinter);
		//세터 메서드를 사용해서 의존 주입을 하지 않아도 스프링 컨테이너가 @Autowired를 붙인 필드에 자동으로 해당 타입의 빈 객체를 주입한다.
		return infoPrinter;
	}
	@Bean
	public VersionPrinter versionPrinter() {
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(5);
		versionPrinter.setMinorVersion(0);
		return versionPrinter;
	}
}
