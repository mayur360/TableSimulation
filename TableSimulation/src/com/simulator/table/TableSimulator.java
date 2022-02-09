package com.simulator.table;

import java.util.Scanner;

import com.simulator.controls.SimulatorControls;
import com.simulator.controls.io.SimulatorIO;
import com.simulator.details.SimulatorDetails;

public class TableSimulator implements SimulatorDetails, SimulatorIO, SimulatorControls {

	private int width;
	private int height;
	private int currentWidth;
	private int currentHeight;
	private int headWidth;
	private int headHeight;
	
	public TableSimulator() {
		
	}

	public TableSimulator(int width, int height) {
		setSize(width, height);
	}

	/**
	 * Implementation to move forwards
	 * based on current direction
	 */
	@Override
	public void moveForward() {
		if (currentWidth == headWidth && currentHeight != headHeight && currentHeight > headHeight) {
			headHeight--;
			currentHeight--;
		} else if (currentWidth == headWidth && currentHeight != headHeight && currentHeight < headHeight) {
			headHeight++;
			currentHeight++;
		} else if (currentWidth != headWidth && currentHeight == headHeight && currentWidth > headWidth) {
			headWidth--;
			currentWidth--;
		} else if (currentWidth != headWidth && currentHeight == headHeight && currentWidth < headWidth) {
			headWidth++;
			currentWidth++;
		}
	}

	/**
	 * Implementation to move backwards
	 * based on current direction
	 */
	@Override
	public void moveBackwards() {
		if (currentWidth == headWidth && currentHeight != headHeight && currentHeight > headHeight) {
			headHeight++;
			currentHeight++;
		} else if (currentWidth == headWidth && currentHeight != headHeight && currentHeight < headHeight) {
			headHeight--;
			currentHeight--;
		} else if (currentWidth != headWidth && currentHeight == headHeight && currentWidth > headWidth) {
			headWidth++;
			currentWidth++;
		} else if (currentWidth != headWidth && currentHeight == headHeight && currentWidth < headWidth) {
			headWidth--;
			currentWidth--;
		}
	}

	/**
	 * Implementation to rotate clockwise
	 * based on current direction
	 */
	@Override
	public void rotateClockwise() {
		if (currentWidth == headWidth && currentHeight != headHeight && currentHeight > headHeight) {
			headWidth++;
			headHeight++;
		} else if (currentWidth == headWidth && currentHeight != headHeight && currentHeight < headHeight) {
			headWidth--;
			headHeight--;
		} else if (currentWidth != headWidth && currentHeight == headHeight && currentWidth > headWidth) {
			headWidth++;
			headHeight--;
		} else if (currentWidth != headWidth && currentHeight == headHeight && currentWidth < headWidth) {
			headWidth--;
			headHeight++;
		}
	}

	/**
	 * Implementation to move counter clockwise
	 * based on current direction
	 */
	@Override
	public void rotateCounterClockwise() {
		if (currentWidth == headWidth && currentHeight != headHeight && currentHeight > headHeight) {
			headWidth--;
			headHeight++;
		} else if (currentWidth == headWidth && currentHeight != headHeight && currentHeight < headHeight) {
			headWidth++;
			headHeight--;
		} else if (currentWidth != headWidth && currentHeight == headHeight && currentWidth > headWidth) {
			headWidth++;
			headHeight++;
		} else if (currentWidth != headWidth && currentHeight == headHeight && currentWidth < headWidth) {
			headWidth--;
			headHeight--;
		}
	}

	@Override
	public String getShapeType() {
		return "Table";
	}

	@Override
	public void setSize(int width, int height) {
		setWidth(width);
		setHeight(height);
	}

	@Override
	public void setInitialLocation(int width, int height) {
		setCurrentWidth(width);
		setCurrentHeight(height);
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public void setWidth(int pWidth) {
		width = pWidth;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public void setHeight(int pHeight) {
		height = pHeight;
	}

	@Override
	public int getCurrentWidth() {
		return currentWidth;
	}

	@Override
	public int getCurrentHeight() {
		return currentHeight;
	}

	@Override
	public void setCurrentWidth(int pCurrentWidth) {
		currentWidth = pCurrentWidth;
	}

	@Override
	public void setCurrentHeight(int pCurrentHeight) {
		currentHeight = pCurrentHeight;
	}

	@Override
	public void printCurrentLocation() {
		printCurrentLocation(false);
	}

	@Override
	public int getHeadWidth() {
		return headWidth;
	}

	@Override
	public void setHeadWidth(int headWidth) {
		this.headWidth = headWidth;
	}

	public int getHeadHeight() {
		return headHeight;
	}

	public void setHeadHeight(int headHeight) {
		this.headHeight = headHeight;
	}

	@Override
	public void printCurrentLocation(boolean hasException) {
		if (hasException || (currentWidth >= width || currentWidth < 0 || currentHeight >= height || currentHeight < 0)) {
			currentWidth = -1;
			currentHeight = -1;
		}
		//System.out.println("["+ headWidth + "," + headHeight + "]");
		System.out.println("["+ currentWidth + "," + currentHeight + "]");
	}

	/**
	 * Processing given commands
	 */
	@Override
	public void simulate(String input) {
		if (input != null) {
			if (input.contains(" ")) {
				input = input.replace(" ", "");
			}
			String[] inputs = input.split(",");
			if (inputs != null) {
				for (int inputCount = 0; inputCount < inputs.length; inputCount++) {
					String command = inputs[inputCount];
					int intCommand = 100;
					try {
						intCommand = Integer.parseInt(command);
					} catch (NumberFormatException nfe) {
						printCurrentLocation(true);
						return;
					}
					if (intCommand == 1) {
						moveForward();
					} else if (intCommand == 2) {
						moveBackwards();
					} else if (intCommand == 3) {
						rotateClockwise();
					} else if (intCommand == 4) {
						rotateCounterClockwise();
					} else if (intCommand == 0) {
						printCurrentLocation();
						return;
					}
					//printCurrentLocation();
				}
			}
		} else {
			setBadCurrentLocation();
		}
	}

	private void setBadCurrentLocation() {
		currentWidth = -1;
		currentHeight = -1;
	}

	/**
	 * getting input for size of table and current position
	 */
	@Override
	public String getSizeCurrentLocationInput() {
		//System.out.print("Provide Size and Location : ");
		Scanner sc= new Scanner(System.in);
		return sc.nextLine();
	}

	/**
	 * Getting input for commands
	 */
	@Override
	public String getCommandInputs() {
		//System.out.print("Provide Command inputs    : ");
		Scanner sc= new Scanner(System.in);
		return sc.nextLine();
	}

	/**
	 * checking if initial input for table size
	 * and current position is correct or not
	 * if input is other than 4,4,2,2 then program will terminate 
	 */
	@Override
	public void setSizeCurrentLocation(String input) {
		if (input != null) {
			if (input.contains(" ")) {
				input = input.replace(" ", "");
			}
			String[] inputs = input.split(",");
			if (inputs.length > 4) {
				printCurrentLocation();
				System.exit(0);
			}
			for (int inputCount = 0; inputCount < inputs.length; inputCount++) {
				String strInput = inputs[inputCount];
				try {
					int intInput = Integer.parseInt(strInput);
					if (inputCount == 0) {
						if(intInput != 4) {
							printCurrentLocation(true);
							System.exit(0);
						}
						setWidth(intInput);
					} else if (inputCount == 1) {
						if(intInput != 4) {
							printCurrentLocation(true);
							System.exit(0);
						}
						setHeight(intInput);
					} else if (inputCount == 2) {
						if(intInput != 2) {
							printCurrentLocation(true);
							System.exit(0);
						}
						setCurrentWidth(intInput);
						setHeadWidth(intInput);
					} else if (inputCount == 3) {
						if(intInput != 2) {
							printCurrentLocation(true);
							System.exit(0);
						}
						setCurrentHeight(intInput);
						setHeadHeight(getCurrentHeight() - 1);
					}
				} catch (NumberFormatException nfe) {
					printCurrentLocation();
					System.exit(0);
				}
			}
		}
	}
}
