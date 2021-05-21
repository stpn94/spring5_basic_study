package spring5_basic_study.config;

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
public class AppCtx4GetBean {
	private MemberPrinter printer = new MemberPrinter();
	
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao());
	}
	
	@Bean
	public ChangePasswordService changePwdSvc() {
		ChangePasswordService pwdSvc = new ChangePasswordService();
		pwdSvc.setMemberDao(memberDao());
		return pwdSvc;
	}
	
	@Bean
	public MemberListPrinter listPrinter() {
		return new MemberListPrinter(memberDao(), printer);
	}
	
	@Bean
	public MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
		infoPrinter.setMemberDao(memberDao());
		infoPrinter.setPrinter(printer);
		return infoPrinter;
	}
	
	@Bean
	public VersionPrinter versionPrinter() {
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(5);
		versionPrinter.setMinorVersion(0);
		return versionPrinter;
	}
	
	@Bean
	public VersionPrinter oldVersionPrinter() {
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(4);
		versionPrinter.setMinorVersion(3);
		return versionPrinter;
	}

}
