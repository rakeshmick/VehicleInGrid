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
public class TestMoveOperationsForward {
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
	public int horizontal ;
	@Parameter(value=1)
	public int vertical ;	
	@Parameter(value=2)
	public Direction direction;
	@Parameter(value=3)
	public int verticalExpected;
	@Parameter(value=4)
	public int horizontalExpected;
	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                { 0, 0, Direction.NORTH, 1,0 },{ 1, 1, Direction.SOUTH, 0,1 }, { 2, 1, Direction.EAST,1, 3 }, { 3, 2 , Direction.WEST,2,2},  
           });
    }

	@Test
	public final void testForward() {
		 carLocation.setHorizontal(horizontal);
		 carLocation.setVertical(vertical);
		 carLocation.setFacingDirection(direction);
		 move.forward();
		 Assert.assertEquals("Wrong move", verticalExpected, carLocation.getVertical());
		 Assert.assertEquals("Wrong move", horizontalExpected,carLocation.getHorizontal());
	}
	
}
