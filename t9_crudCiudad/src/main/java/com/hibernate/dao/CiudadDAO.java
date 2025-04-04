package com.hibernate.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.ciudad.model.Ciudad;
import com.ciudad.util.CiudadUtil;

public class CiudadDAO {

	public static void mostrarMenu() {
		System.out.println("Elige una operación a realizar:");
		System.out.println("1) Insertar nueva ciudad");
		System.out.println("2) Borrar ciudad a partir del código");
		System.out.println("3) Actualizar  el nombre dado el código");
		System.out.println("4) Actualizar habitantes");
		System.out.println("5) Ver todas las ciudades");
		System.out.println("6) Ver datos de la ciudad con el código");

	}
	
	
	
	
	//1
	public void insertCiudad (Ciudad c) {
		Transaction transaction=null;
		try(Session session=CiudadUtil.getSessionFactory().openSession()){
			transaction=session.beginTransaction();
			//añade la ciudad
			session.persist(c);
			transaction.commit();
		}catch(Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
		}
	}//insert ciudad
	
	//2
	public void deleteCiudad(int codigo) {
		Transaction transaction = null;
		Ciudad c=null;
		try (Session session=CiudadUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			c=session.get(Ciudad.class, codigo);
			//elimina la ciudad seleccionada
			session.remove(c);
			transaction.commit();
		}catch(Exception e) {
			if (transaction !=null) {
				transaction.rollback();
			}
		}
	}//delete ciudad
	
	//3 y 4
	public void updateCiudad(Ciudad c) {
		Transaction transaction=null;
		try(Session session=CiudadUtil.getSessionFactory().openSession()){
			transaction=session.beginTransaction();
			//actualiza los cambios
			session.merge(c);
			transaction.commit();
		}catch (Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
		}
	}//update ciudad
	
	
	
	//5
	public List<Ciudad> selectAllCiudades(){
		Transaction transaction=null;
		List<Ciudad> ciudades=null;
		try(Session session=CiudadUtil.getSessionFactory().openSession()){
			transaction=session.beginTransaction();
			ciudades=session.createQuery("FROM ciudad", Ciudad.class).getResultList();
			transaction.commit();
		}catch(Exception e) {
			if(transaction!= null) {
				transaction.rollback();
			}
		}
		return ciudades;
	}
	
	//6 y para hacer los que se ubican por id
	public Ciudad selectCiudadByCodigo(int codigo) {
		Transaction transaction =null;
		Ciudad c=null;
		try(Session session=CiudadUtil.getSessionFactory().openSession()){
			transaction=session.beginTransaction();
			c=session.get(Ciudad.class, codigo);
			transaction.commit();
		}catch(Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
		}
		return c;
	}//seleccion simple
	
	
}//class
