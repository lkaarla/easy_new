package br.com.easypizza.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.easypizza.dao.LoginDAO;
import br.com.easypizza.entidade.Login;
import br.com.easypizza.exception.EasyPizzaDataBaseException;
import br.com.easypizza.exception.EasyPizzaServiceException;
import br.com.easypizza.service.LoginService;
import  br.com.easypizza.vo.LoginVO;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired(required=true)
	private LoginDAO loginDao;
	
	
	@Override
	public void logar(LoginVO loginVO) throws EasyPizzaServiceException, EasyPizzaDataBaseException{ 
		Login loginAtual = loginDao.buscarLoginPorEmail(loginVO.getEmail());
		Login senhaLoginAtual = loginDao.buscarSenhaPorSenhaCad(loginVO.getSenha());
		if(loginAtual != null && senhaLoginAtual != null){
				System.out.println("Login realizado com sucesso!"); 
		}
	}
	
}