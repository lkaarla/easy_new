package br.com.easypizza.service;

import br.com.easypizza.exception.EasyPizzaDataBaseException;
import br.com.easypizza.exception.EasyPizzaServiceException;
import br.com.easypizza.vo.LoginVO;


public interface LoginService {

	public void logar(LoginVO loginVO)  throws EasyPizzaServiceException, EasyPizzaDataBaseException;
}
