package com.hibernate.dao;

import java.util.List;
import java.util.Scanner;
import com.hibernate.model.Ciudad;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		CiudadDAO ciudadDAO=new CiudadDAO();
		Ciudad cid = new Ciudad();
		int opc=1;
		do {
			ciudadDAO.mostrarMenu();
			opc=sc.nextInt();
			
			switch(opc) {
			case 1: 
				//pedir datos
				System.out.println("introduce el nombre de la ciudad:");
				String nom=sc.next();
				System.out.println("numero de habitantes: ");
				int num=sc.nextInt();
				
				//actualizar clase
				cid=new Ciudad(nom, num);
				
				//actualizar base de datos
				ciudadDAO.insertCiudad(cid);
				break;
			
			case 2: 
				//pedir datos
				System.out.println("introduce el codigo de la ciudad: ");
				int codigoBorr=sc.nextInt();
				
				//actualizar base de datos
				ciudadDAO.selectCiudadByCodigo(codigoBorr);
				ciudadDAO.deleteCiudad(codigoBorr);
				break;
				
			case 3:
				//Pedir
				System.out.println("introduce el codigo de la ciudad:");
				int codigoActu=sc.nextInt();
				System.out.println("introduce el nombre a cambiar: ");
				String nomActu=sc.next();
				
				//Seleccionar clase
				cid=ciudadDAO.selectCiudadByCodigo(codigoActu);
				
				//actualizar clase
				cid.setNombre(nomActu);
				
				//Actualizar base de datos
				ciudadDAO.updateCiudad(cid);
				break;
				
			case 4: 
				System.out.println("introduce el codigo de la ciudad:");
				int codigoActu2=sc.nextInt();
				System.out.println("introduce el nombre a cambiar: ");
				int numActu=sc.nextInt();
				
				//seleccionar clase
				cid=ciudadDAO.selectCiudadByCodigo(codigoActu2);
				
				//actualizar clase
				cid.setNumHabitantes(numActu);
				
				//actualizar base de datos
				ciudadDAO.updateCiudad(cid);
				break;
				
			case 5:
				List<Ciudad> ciudades=ciudadDAO.selectAllCiudades();
				ciudades.forEach(c->System.out.println(c.getNombre()+" --- "+c.getNumHabitantes()));
				break;
				
			case 6:
				System.out.println("introduce el codigo de la ciudad:");
				int codigoSee=sc.nextInt();
				
				//seleccionar clase
				cid=ciudadDAO.selectCiudadByCodigo(codigoSee);
				
				//mostrar contenido
				System.out.println("----");
				System.out.println("nombre: "+cid.getNombre()+", numero de habitantes: "+cid.getNumHabitantes());
				System.out.println("----");
				break;
			}
		}while(opc!=0);
		
		
		
	}

}
