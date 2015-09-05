package com.chal;

public enum Direction {
	NORTH(0), EAST(1), SOUTH(2), WEST(3) ;	

	int directionCode;
	Direction(int directionCode){
		this.directionCode=directionCode;
	}
	public int getDirectionCode(){
		return this.directionCode;
	}
}
