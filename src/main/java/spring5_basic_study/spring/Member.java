package spring5_basic_study.spring;

import java.time.LocalDateTime;

public class Member {

	private Long id;
	private String email;
	private String password;
	private String name;
	private LocalDateTime registerDateTime;

	public Member(String email, String password, String name, LocalDateTime regDateTime) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.registerDateTime = regDateTime;
	}

	void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public LocalDateTime getRegisterDateTime() {
		return registerDateTime;
	}

	// 암호 변경
	public void changePassword(String oldPassword, String newPassword) {
		if (!password.equals(oldPassword))
			// 만약 암호가 이전암호와 같지 않을때 WrongIdPassword예외를 던진다.
			throw new WrongIdPasswordException();
		//맞으면 새로운 암호가 등록이 된다.
		this.password = newPassword;
	}

}
