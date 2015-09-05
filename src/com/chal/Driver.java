package com.chal;

import java.util.Scanner;

public class Driver {




	public static void main(String[] args) {
		Scanner reader;
		Commands command;
		
		String userChoice = null;
		VehicleLocation carLocation;
		Driver dr= new Driver();
		
		reader = new Scanner(System.in); 
		
		carLocation=new VehicleLocation(); 
		MoveOperation move = new MoveOperation(carLocation);
		

		while(!"END".equals(userChoice)){
		try{	
			System.out.println("\n \nWelcome to Control Centre");		
			System.out.println("This is the control panel of your car");
			System.out.println("you can control the car with the following commands");
			System.out.println("1. INIT <x> <y> <direction>  for starting position(always start with this command)  ");
			System.out.println("2. FORWARD to move one grid postion forward");
			System.out.println("3. TURN_LEFT to turn your car left ");
			System.out.println("4. TURN_RIGHT to turn your car right");
			System.out.println("5. GPS_REPORT to see the current status");
			System.out.println("6. END to stop \n \n");
			userChoice=reader.nextLine();
			
			
			if(userChoice.toString().startsWith("INIT")){				
				command=Commands.INIT;
			}
			else{
			command=Commands.valueOf(userChoice.toString());
			}
			
		
		//move.report();
			
			dr.controller(command, userChoice, move);
			
		System.out.println("\n Watiting for next command.. \n");

	
	} catch( IllegalArgumentException e ){
		
		System.out.println("Invalid entry try again \n");
		
		}catch(NullPointerException e){
			System.out.println("Invalid entry try again \n");
		}
	}
	}
	
	public void controller(Commands command, String userChoice, MoveOperation move){
		switch(command){
		case INIT:     	String[] arr=userChoice.split(" ");
						int horizontalDirection=Integer.parseInt(arr[1]);
						int verticalDirection=Integer.parseInt(arr[2]);
						String face=arr[3];
						System.out.println("Entered direction command is :="+horizontalDirection+","+verticalDirection+","+face);
						move.INIT(horizontalDirection, verticalDirection, face);
						break;
		case FORWARD:	move.forward();
					    break;
		case TURN_LEFT: move.turn_left();
						break;
		case TURN_RIGHT:move.turn_right();
						break;
		case GPS_REPORT:move.report();	
						break;
		case END:		System.out.println("Good bye, Happy driving :)");
						break;

		default:        System.out.println("Invalid direction entered \n");
						break;
		}
	}
}
