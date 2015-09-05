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
public class TestMoveOperationsTurnRight {
	VehicleLocation carLocation ;
	MoveOperation move ;
	
	@Before
	public void setUp() throws Exception {		
		carLocation = new VehicleLocation();
		move = new MoveOperation(carLocation);
	}

	@After
	public void tearDown() throws Exception {
	}


	@Parameter
	public Direction currentDirection ;
	@Parameter(value=1)
	public Direction xpectedDirection;

	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                { Direction.NORTH, Direction.EAST },{ Direction.SOUTH, Direction.WEST }, {  Direction.EAST,Direction.SOUTH}, { Direction.WEST,Direction.NORTH},  
           });
    }

	@Test
	public final void testLeft() {
		 carLocation.setFacingDirection(currentDirection);
		 move.turn_right();
		 Assert.assertEquals("Wrong Turn", xpectedDirection,carLocation.getFacingDirection());
		
	}
	
}
