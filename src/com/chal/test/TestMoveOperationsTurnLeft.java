package com.chal.test;

import static org.junit.Assert.*;

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
public class TestMoveOperationsTurnLeft {
	VehicleLocation carLocation ;
	MoveOperation move ;
	
	@Before
	public void setUp() throws Exception {		
		carLocation = new VehicleLocation();
		move = new MoveOperation(carLocation);
	}

	@Parameter
	public Direction currentDirection ;
	@Parameter(value=1)
	public Direction xpectedDirection;

	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                { Direction.NORTH, Direction.WEST },{ Direction.SOUTH, Direction.EAST }, {  Direction.EAST,Direction.NORTH}, { Direction.WEST,Direction.SOUTH},  
           });
    }

	@Test
	public final void testLeft() {
		 carLocation.setFacingDirection(currentDirection);
		 move.turn_left();
		 Assert.assertEquals("Wrong Turn", xpectedDirection,carLocation.getFacingDirection());
		
	}
	
}
