package com.simulator;

import com.simulator.table.TableSimulator;

public class SimulatorTest {
	
	/**
	 * 
	 * @param args
	 * Here we are taking input from command 4,4,2,2
	 * @getSizeCurrentLocationInputIf gets input 
	 * If input is other than 4,4,2,2 then output will be [-1,-1]
	 * then we are taking input for command
	 */
	public static void main(String[] args) {
		
		TableSimulator tableSimulator = new TableSimulator();
		String sizeCurrentLocationInput = tableSimulator.getSizeCurrentLocationInput();
		tableSimulator.setSizeCurrentLocation(sizeCurrentLocationInput);
		String commandInputs = tableSimulator.getCommandInputs();
		tableSimulator.simulate(commandInputs);
	}
}
