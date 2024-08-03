package com.swabhav;

public interface IPosition extends Cloneable {
	int getX();

	int getY();

	IPosition setX(int x);

	IPosition setY(int y);

	IPosition clone();
}
