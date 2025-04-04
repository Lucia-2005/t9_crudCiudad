package com.hibernate.dao;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		CiudadDAO ciudadDAO=new CiudadDAO();
		
		ciudadDAO.mostrarMenu();
		int opc=sc.nextInt();
		
		switch(opc) {
		case 1: 
			System.out.println();
		}
		
		
	}

}
