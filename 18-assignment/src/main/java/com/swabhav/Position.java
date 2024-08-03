package com.swabhav;

public class Position implements IPosition{
    private int x;
    private int y;

    // Constructor
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Getters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public Position setX(int x) {
		this.x = x;
		return this;
	}

	public Position setY(int y) {
		this.y = y;
		return this;
	}

	public Position clone() {
    	return new Position(x, y);
    }
    
	@Override
	public String toString() {
		return "( " + this.x + " " + this.y + " )";
	}
    
}
