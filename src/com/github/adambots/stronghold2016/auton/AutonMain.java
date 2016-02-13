package com.github.adambots.stronghold2016.auton;

public class AutonMain {
	Auton_Barrier aB=new Auton_Barrier();
public AutonMain(){
	
}

/**
 * 
 * @param dBCI  array of chars from the drive station telling what category of barrier is in what spot on the field this is for auton barrier class
 * @param dBCNI tells which number of the category is in that position for auton barrier class
 * @param cPN current position after the positioning code is done for auton barrier class
 */
public AutonMain(char[] dBCI, int[] dBCNI,int cPN){
	aB.setInput(dBCI, dBCNI, cPN);
}
/**
 * 
 * @param dBCI  array of chars from the drive station telling what category of barrier is in what spot on the field this is for auton barrier class
 * @param dBCNI tells which number of the category is in that position for auton barrier class
 * @param cPN current position after the positioning code is done for auton barrier class
 */
public void setInput(char[] dBCI, int[] dBCNI,int cPN){
	aB.setInput(dBCI, dBCNI, cPN);
}
}
