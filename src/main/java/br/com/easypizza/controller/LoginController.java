package br.com.easypizza.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.easypizza.service.LoginService;
import br.com.easypizza.vo.LoginVO;

@Controller("loginMBean")
@Scope("session")
public class LoginController {
	
	private LoginService loginService;
	private LoginVO loginAtual;
	
	@Autowired
	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}
	
	@PostConstruct
	public void init(){
		loginAtual = new LoginVO();
	}
	
	public String logar(){
		loginService.logar(loginAtual);
		return "";
	}

	public LoginVO getLoginAtual() {
		return loginAtual;
	}

	public void setLoginAtual(LoginVO loginAtual) {
		this.loginAtual = loginAtual;
	}
	
	

}
