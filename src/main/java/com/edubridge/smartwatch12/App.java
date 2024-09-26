package com.edubridge.smartwatch12;

import java.util.List;
import java.util.Scanner;

import com.edubridge.smartwatch12.model.Smartwatch;
import com.edubridge.smartwatch12.service.SmartwatchService;

public class App{
	public static void main(String[] args) {
		SmartwatchService service=new SmartwatchService();
		Scanner in= new Scanner(System.in);
		while(true) {
			System.out.println("my Smartwatch application");
			System.out.println("++++++++++++++++++++++++++++");
			System.out.println("1.Add Smartwatch");
			System.out.println("2.View Smartwatch");
			System.out.println("3.Update Smartwatch");
			System.out.println("4.Delete One Smartwatch");
			System.out.println("5.Delete All Smartwatch");
			System.out.println("6.Search Smartwatch");
			System.out.println("0.Exit");
			System.out.println("please choose option: ");
			int option= in.nextInt();
			
			switch(option) {
			case 1:
				System.out.println("add Smartwatch details");
				System.out.println("--------------");
				
				System.out.println("Enter Id: ");
				int id=in.nextInt();
				
				System.out.println("Enter Name: ");
				String name=in.next();
				
				System.out.println("Enter Brand: ");
				String brand=in.next();
				
				System.out.println("Enter Colour: ");
				String colour=in.next();
				
				System.out.println("Enter Price: ");
				Float price=in.nextFloat();
				
				
				Smartwatch newSmartwatch = new Smartwatch();
				newSmartwatch.setId(id);
				newSmartwatch.setName(name);
				newSmartwatch.setBrand(brand);
				newSmartwatch.setColour(colour);
				newSmartwatch.setPrice(price);
			
				int status = service.addSmartwatch(newSmartwatch);
				if(status >=1) {
					System.out.println("New Smartwatch added successfully!");
				}else {
					System.out.println("Something is wrong");
				}
				break;
			case 2:
				System.out.println("display all Smartwatches");
				System.out.println("---------------");
				List<Smartwatch> Smartwatches= service.getAllSmartwatches();
				for(Smartwatch s: Smartwatches) {
					System.out.println(s.getId()+"\t"+s.getName()+"\t"+s.getBrand()+"\t"+s.getColour()+"\t"+s.getPrice()+"\t");
				}	
				break;
			case 3:
				 System.out.println("Update Smartwatch");
                 System.out.print("Enter Id of the Smartwatch to update: ");
                 int updateId = in.nextInt();

                 System.out.println("Enter new details for the Smartwatch:");
                 Smartwatch updatedSmartwatch = new Smartwatch();
                 updatedSmartwatch.setId(updateId);
                 System.out.print("Enter Name: ");
                 updatedSmartwatch.setName(in.next());
                 System.out.print("Enter Brand: ");
                 updatedSmartwatch.setBrand(in.next());
                 System.out.print("Enter Colour: ");
                 updatedSmartwatch.setColour(in.next());
                 System.out.print("Enter Price: ");
                 updatedSmartwatch.setPrice(in.nextFloat());

                 int updateStatus = service.updateSmartwatch(updatedSmartwatch);
                 if (updateStatus >= 1) {
                     System.out.println("Smartwatch updated successfully!");
                 } else {
                     System.out.println("Smartwatch not found.");
                 }
                 break;
			  case 4:
                  System.out.print("Enter Name of the Smartwatch to delete: ");
                  String deleteName = in.nextLine();
                  service.deleteSmartwatch(deleteName);
                  System.out.println("Smartwatch deleted successfully!");
                  break;

              case 5:
                  service.deleteAllSmartwatches();
                  System.out.println("All Smartwatches deleted successfully!");
                  break;

              case 6:
                  System.out.print("Enter Name of the Smartwatch to search: ");
                  String searchName = in.nextLine();
                  Smartwatch foundSmartwatch = service.getSmartwatchByName(searchName);
                  if (foundSmartwatch != null) {
                      System.out.println("Smartwatch found: " + foundSmartwatch.getId() + "\t" + foundSmartwatch.getName() + "\t" + foundSmartwatch.getBrand() + "\t" + foundSmartwatch.getColour() + "\t" + foundSmartwatch.getPrice());
                  } else {
                      System.out.println("Smartwatch not found.");
                  }
                  break;
			case 0:
				System.out.println("bye!!!");
				System.exit(0);
			default:
				System.out.println("invalid option selected!");
				break;
			}
		}
	}
}
    