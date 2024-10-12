package com.digiAuth;

import java.util.Scanner;

import com.digiAuth.Document.Document;
import com.digiAuth.authenticate.Authenticate;
import com.digiAuth.service.DocService;

public class Main {
	
	public static void main(String[] args) {
		
		Authenticate auth = new Authenticate();
		DocService docService = new DocService();
		
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		
		while(flag) {
			
			System.out.println("\n1. Register");
			System.out.println("2. Login");
			System.out.println("3. Logout");
			System.out.println("Enter Your Choice");
			
			int choice = Integer.parseInt(sc.nextLine());
			
			switch(choice) {
			
				case 1: {
					System.out.println("\nEnter Username");
					String username = sc.nextLine();
					
					System.out.println("Enter Password");
					String password = sc.nextLine();
					
					if(auth.register(username, password)) {
						System.out.println("Registration Successful");
					} else {
						System.out.println("Existing User");
					}
					break;
					
				}
				
				case 2: {
					System.out.println("\nEnter Username");
					String username = sc.nextLine();
					
					System.out.println("Enter Password");
					String password = sc.nextLine();
					
					if(auth.login(username, password)) {
						System.out.println("Login Successful");
						userMenu(sc,username,docService);
					} else {
						System.out.println("Invalid User");
					
					}
					break;
				}
				
				case 3: {
					System.out.println("Exiting....\n");
					flag = false;
					break;
				}
				
			}
		}
		
	}
	
	public static void userMenu(Scanner sc, String username, DocService docService) {
		
		boolean flag2 = true;
		while(flag2) {
			
			System.out.println("\nDocument Menu");
			System.out.println("1. Add Document");
			System.out.println("2. View Documents");
			System.out.println("3. Exit");
			
			int option = Integer.parseInt(sc.nextLine());
			
			switch(option) {
				
				case 1: {
					System.out.println("Enter Document Name");
					String docName = sc.nextLine();
					
					System.out.println("Enter Document Id");
					int docId = Integer.parseInt(sc.nextLine());
					
					docService.addDocument(username, new Document(docName,docId));
					System.out.println("Document Added Successfully");
					break;
				}
				
				case 2: {
					
					System.out.println("Your Documents");
					for(Document doc: docService.getAllDocuments(username)) {
						
						System.out.println("Document Name: " + doc.getDocName() + "\nDocument Id: " + doc.getDocID());
						
					}
					
					docService.getAllDocuments(username);
					break;
				}
				
				case 3: {
					System.out.println("Exiting from menu....");
					flag2 = false;
					break;
				}
			
			}
			
		}
		
	}
	
}
