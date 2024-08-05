package com.swabhav;

public interface IBoard {
	int getValue(Position position);

	boolean setValue(Position position, Integer value);
}
