package br.com.easypizza.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {
	
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("easypizza");

	public static EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}
	

}
