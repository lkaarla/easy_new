package br.com.easypizza.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_usuario")
public class TipoUsuario {
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_tipo_usuario")
	private int idTipoUsuario;
    
    @Column(name = "desc_tipo_usuario")
	private String descrUsuario;
	
	
	public int getIdTipoUsuario() {
		return idTipoUsuario;
	}
	public String getDescrUsuario() {
		return descrUsuario;
	}
	public void setDescrUsuario(String descrUsuario) {
		this.descrUsuario = descrUsuario;
	}
	public void setIdTipoUsuario(int idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}
		
	

}
