package br.com.easypizza.dao;

import br.com.easypizza.entidade.TipoUsuario;
import br.com.easypizza.exception.EasyPizzaDataBaseException;

public interface TipoUsuarioDAO {
	
	public void incluir(TipoUsuario tipoUsuario) throws EasyPizzaDataBaseException;
	public void excluirPorId (int idTipoUsuario) throws EasyPizzaDataBaseException;
	public void excluir (TipoUsuario tipoUsuario) throws EasyPizzaDataBaseException;
	public void alterar(TipoUsuario tipoUsuario) throws EasyPizzaDataBaseException;
	public TipoUsuario buscarTipoUsuarioPorId(int id); 
 
}
