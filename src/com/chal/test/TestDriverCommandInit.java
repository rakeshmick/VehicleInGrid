package com.chal.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import com.chal.Direction;
import com.chal.MoveOperation;
import com.chal.VehicleLocation;


@RunWith(Parameterized.class)
public class TestDriverCommandInit {
	VehicleLocation carLocation ;
	MoveOperation move ;
	
	@Parameter
	public int horizontal ;
	@Parameter(value=1)
	public int vertical ;
	String face = "NORTH";
	@Before
	public void setUp() throws Exception {
		
		
		carLocation = new VehicleLocation();
		move = new MoveOperation(carLocation);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                 { 0, 0 }, { 1, 1 }, { 2, 1 }, { 3, 2 }, { 4, 3 }, { 4, 4 },  
           });
    }

	@Test
	public final void testINIT() {
			
		move.INIT(horizontal, vertical, face);
		assertEquals("not correct ", carLocation.getVertical(), vertical);
		assertEquals("not correct ", carLocation.getHorizontal(), horizontal);
		assertEquals("not correct ", carLocation.getFacingDirection(), Direction.NORTH);
	}
   
	

}
