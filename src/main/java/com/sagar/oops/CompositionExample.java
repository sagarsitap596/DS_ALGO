package com.sagar.oops;

import java.util.List;

/**
 * Composition is a restricted form of Aggregation in which two entities (or you
 * can say classes) are highly dependent on each other. For e.g. library can
 * have no. of books on same or different subjects. So, If Library gets
 * destroyed then All books within that particular library will be destroyed.
 * i.e. book can not exist without library. That’s why it is composition.
 * 
 * Example : Linear class and TMCs class. If Linear is destroyed. All TMCs
 * within that Linear are destroyed.
 * 
 * one Linear.
 * 
 * @author sitapsha
 *
 */
public class CompositionExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}

// Bi directional
class Linear {
	private String linearId;
	private List<TMC> tmcs;
}

class TMC {
	private int code;
	private int length;
	private List<double[]> coordinates;
}
