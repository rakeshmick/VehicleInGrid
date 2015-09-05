package com.chal.test;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


import com.chal.Commands;
import com.chal.Driver;
import com.chal.MoveOperation;
import com.chal.VehicleLocation;


public class TestDriverExpectedMessage {
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
	@After
	public void TearDown() throws Exception {
	 	dr= null;
    	command= null;
    	carLocation= null;
    	move = null;
	}
	
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	@Test
	public void testExceptionMessageInitializeBoundary(){
		expectedEx.expect(AssertionError.class);
		userChoice = "INIT 5 0 NORTH";
	    expectedEx.expectMessage("expected:<5> but was:<0>");
	    dr.controller(command, userChoice, move);
     	Assert.assertEquals(5, carLocation.getVertical());
	//	Assert.assertEquals(carLocation.getVertical(), 5);
	}
	
	
	@Test
	public void testExceptionMessageInitializeBoundaryThree(){
		expectedEx.expect(AssertionError.class);
		userChoice = "INIT 0 5 NORTH";
	    expectedEx.expectMessage("expected:<5> but was:<0>");
	   
	    dr.controller(command, userChoice, move);
     	Assert.assertEquals(5,carLocation.getHorizontal());
	
	}
	
	@Test
	public void testExceptionMessageForward(){
		expectedEx.expect(AssertionError.class);
		command=Commands.FORWARD;
		userChoice = "FORWARD";
	    expectedEx.expectMessage("expected:<5> but was:<0>");
	   
	    dr.controller(command, userChoice, move);
     	Assert.assertEquals(5,carLocation.getHorizontal());
	
	}

	

}
