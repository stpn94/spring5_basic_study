package spring5_basic_study.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring5_basic_study.spring.MemberDao;
import spring5_basic_study.spring.MemberPrinter;

@Configuration
public class AppConf1 {

	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	@Bean
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}
	
}
