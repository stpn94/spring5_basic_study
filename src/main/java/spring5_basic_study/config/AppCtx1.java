package spring5_basic_study.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import spring5_basic_study.spring.MemberDao;
import spring5_basic_study.spring.MemberPrinter;

@Configuration
public class AppCtx1 {
	
	@Autowired
	private MemberDao meberDao;
	@Autowired
	private MemberPrinter memberPrinter;
	
	
	
//	@Bean
//	public MemberDao memberDao() {
//		return new MemberDao();
//	}
//	@Bean
//	public MemberPrinter memberPrinter() {
//		return new MemberPrinter();
//	}
}
