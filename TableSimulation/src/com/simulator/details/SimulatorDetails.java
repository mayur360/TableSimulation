package com.simulator.details;

public interface SimulatorDetails {

	String getShapeType();

	void setSize(int width, int height);

	int getWidth();

	void setWidth(int width);

	int getHeight();

	void setHeight(int height);

	int getCurrentWidth();

	void setCurrentWidth(int currentWidth);

	int getCurrentHeight();

	void setCurrentHeight(int height);

	void setInitialLocation(int width, int height);

	void printCurrentLocation();
	
	void printCurrentLocation(boolean hasException);

	void simulate(String inputs);
	
	void setSizeCurrentLocation(String input);

	void setHeadWidth(int headWidth);

	int getHeadWidth();
}
