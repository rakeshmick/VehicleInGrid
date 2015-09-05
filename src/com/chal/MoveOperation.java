package com.chal;



public class MoveOperation {

	VehicleLocation vlocation;
	//Direction direction;

	public MoveOperation(VehicleLocation carLocation) {
		this.vlocation=carLocation;
	}
	
	//Initialize the vehicle location before doing any navigation
	public void INIT(int x, int y, String face){
		// verify the initial location before setting it inside  the  grid
		if((x<=GridConstants.Max)&&(x>=GridConstants.Min)&&(y<=GridConstants.Max)&&(y>=GridConstants.Min)){
			System.out.println("Valid location, proceeding with initialization");
			vlocation.setVertical(y);
			vlocation.setHorizontal(x);
			vlocation.setFacingDirection(Direction.valueOf(face));
			System.out.println("\nDirection initialized to: "+vlocation.getFacingDirection().toString());
		}
		else {
			System.out.println("\n Invalid command please retry with proper format");
		}
	

	}

	public void forward() {
        // this  function will verify the facing direction and grid boundaries before doing any navigation step

		if  (vlocation.FacingDirection.toString().equals("NORTH")){
			if((vlocation.getVertical()<GridConstants.Max)&&(vlocation.getVertical()>=GridConstants.Min))	
			{vlocation.setVertical(vlocation.vertical+1);
			System.out.println("vertical= "+vlocation.getVertical());}
			else{
				System.out.println("Unable to move forward as the current position is in the edge of the grid");  
			}
		}
		else if (vlocation.FacingDirection.toString().equals("SOUTH")) {
			if((vlocation.getVertical()>GridConstants.Min) &&(vlocation.getVertical()<GridConstants.Max)) {

				vlocation.setVertical(vlocation.vertical-1);		}
			else
			{System.out.println("Unable to move forward as the current position is in the edge of the grid");
			}
		}
		else if (vlocation.FacingDirection.toString().equals("EAST")){
			if(vlocation.getHorizontal()>=GridConstants.Min&&vlocation.getHorizontal()<GridConstants.Max)  
			{vlocation.setHorizontal(vlocation.horizontal+1);}
			else
			{System.out.println("Unable to move forward as the current position is in the edge of the grid");
			}

		}
		else if (vlocation.FacingDirection.toString().equals("WEST")){

			if(vlocation.getHorizontal()<5&&vlocation.getHorizontal()>=1)
			{	vlocation.setHorizontal(vlocation.horizontal-1);}
			else
			{System.out.println("Unable to move forward as the current position is in the edge of the grid");
			}
		}
	}
	public void turn_left() {
		
		Direction direct= vlocation.FacingDirection;
		int val=direct.getDirectionCode();
		System.out.println("the direction code got is := "+val);

		if(val==GridConstants.DirectionMin){
			vlocation.setFacingDirection(Direction.values()[3]);
		}
		else if (val>GridConstants.DirectionMin||val<=GridConstants.DirectionMax) {//&&?
			vlocation.setFacingDirection(Direction.values()[val-1]);
		}
		System.out.println(vlocation.getFacingDirection());

	}
	public void turn_right() {


		Direction direct= vlocation.getFacingDirection();
		int val=direct.getDirectionCode();
		System.out.println("the direction code got is := "+val);

		if(val==GridConstants.DirectionMax){
			vlocation.setFacingDirection(Direction.values()[GridConstants.DirectionMin]);
		}
		else {
			vlocation.setFacingDirection(Direction.values()[val+1]);

		}
		System.out.println(vlocation.getFacingDirection());


	}
	public void report() {

		System.out.println("\n \n THE CURRENT LOCATION IS: GRID ("+vlocation.getHorizontal()+","+vlocation.getVertical()+ ")  FACING :"+vlocation.getFacingDirection());

	}
}
