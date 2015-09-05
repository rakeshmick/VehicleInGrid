package com.chal.test;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import com.chal.Commands;
import com.chal.Direction;
import com.chal.Driver;
import com.chal.MoveOperation;
import com.chal.VehicleLocation;

@RunWith(Parameterized.class)
public class TestDriverCommands {
	VehicleLocation carLocation ;
	MoveOperation move ;
	
	Commands command;
	Driver dr;
	
	

	

	@Parameter
	public Commands calledCommand ;
	@Parameter(value=1)
	public String userChoice;
	

	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                {Commands.TURN_LEFT,"TURN_LEFT" },{ Commands.TURN_RIGHT,"TURN_RIGHT" }, { Commands.GPS_REPORT,"GPS_REPORT"},
                {Commands.END,"END"},
           });
    }


	
	@Test
	public void testCommands(){
		//this function verifies function calls based on user command
        dr= new Driver();
		MoveOperation move = mock(MoveOperation.class);
		carLocation=new VehicleLocation();
		carLocation.setVertical(0);
		carLocation.setHorizontal(0);
		carLocation.setFacingDirection(Direction.NORTH);
		dr.controller(calledCommand, userChoice, move);		
		if(userChoice.equals("TURN_LEFT")){
			verify(move, times(1)).turn_left();}
		else if(userChoice.equals("TURN_RIGHT")){
			verify(move, times(1)).turn_right();	
		}
		else if(userChoice.equals("END")){
			verify(move, times(0)).report();	
		}
	}
	
}
