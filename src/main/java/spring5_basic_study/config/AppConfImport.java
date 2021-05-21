package spring5_basic_study.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import spring5_basic_study.spring.MemberDao;
import spring5_basic_study.spring.MemberPrinter;

@Configuration
@Import({AppConf2.class})
public class AppConfImport {
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	@Bean
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}
}
