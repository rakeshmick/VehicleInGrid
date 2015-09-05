package com.chal;

public class VehicleLocation {

	int horizontal;
	int vertical;
	Direction FacingDirection;
	
	public VehicleLocation() {
		 horizontal=0;
		 vertical=0;
		 FacingDirection =Direction.NORTH;
	}
	
	public int getHorizontal() {
		return horizontal;
	}
	public void setHorizontal(int horizontal) {
		this.horizontal = horizontal;
	}
	public int getVertical() {
		return vertical;
	}
	public void setVertical(int vertical) {
		this.vertical = vertical;
	}
	public Direction getFacingDirection() {
		return FacingDirection;
	}
	public void setFacingDirection(Direction facingDirection) {
		FacingDirection = facingDirection;
	}

}
