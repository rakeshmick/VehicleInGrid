package com.chal.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.chal.Commands;
import com.chal.Direction;
import com.chal.Driver;
import com.chal.MoveOperation;
import com.chal.VehicleLocation;

public class TestDriverSimpletests {

	Driver dr;
	String userChoice;
	Commands command;
	VehicleLocation carLocation;
	MoveOperation move;

	@Before
	public void setUp() throws Exception {
		dr= new Driver();
		command= Commands.INIT;
		carLocation= new VehicleLocation();
		move = new MoveOperation(carLocation);
	}

	@Test
	public void testInitializeLocation(){

		userChoice = "INIT 0 0 NORTH";
		command = Commands.INIT;
		dr.controller(command, userChoice, move);
		Assert.assertEquals(carLocation.getFacingDirection(),Direction.NORTH);
		Assert.assertEquals(command.toString(),"INIT");
		
	}



	@Test(expected=IllegalArgumentException.class)
	public void testInitializeLocationNegativeCase(){
		userChoice = "INIT 0 0 NARCH";
		command = Commands.INIT;
		dr.controller(command, userChoice, move);
		Assert.assertEquals(carLocation.getFacingDirection(),Direction.NORTH);
	}


	@Test(expected=AssertionError.class)
	public void testInitializeLocationNegativeCaseTwo(){
		userChoice = "INIT 0 0 SOUTH";
		command = Commands.INIT;
		dr.controller(command, userChoice, move);
		Assert.assertEquals(carLocation.getFacingDirection(),Direction.NORTH);
	}

	@Test
	public void testInitializeLocationNegativeCase1(){

		userChoice = "FORWARD 0 0 NORTH";
		command = Commands.INIT;
		dr.controller(command, userChoice, move);
		Assert.assertEquals(carLocation.getFacingDirection(),Direction.NORTH);
	}
	@Test
	public void testForwardCommand(){

		userChoice = "FORWARD";
		command = Commands.FORWARD;
		carLocation.setVertical(0);
		carLocation.setHorizontal(0);
		carLocation.setFacingDirection(Direction.NORTH);
		dr.controller(command, userChoice, move);
		Assert.assertEquals(carLocation.getVertical(),1);
	}


}
