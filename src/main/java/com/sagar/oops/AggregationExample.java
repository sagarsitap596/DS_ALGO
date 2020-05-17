package com.sagar.oops;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * Aggregation is a special form of association which is a unidirectional one
 * way relationship between classes (or entities), for e.g. Wallet and Money
 * classes. Wallet has Money but money doesn’t need to have Wallet necessarily
 * so its a one directional relationship. In this relationship both the entries
 * can survive if other one ends. In our example if Wallet class is not present,
 * it does not mean that the Money class cannot exist.
 * 
 * Example : Incident class and TMC class. Incident has TMC information. But
 * both class can exit without each other. Which means there can be incident
 * without TMC information. Same TMC info can be use in CongetionIncident class.
 * 
 * 
 * @author sitapsha
 *
 */
public class AggregationExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
// Uni directional

class Money {
	Map<Integer, Integer> denominationMap = new HashMap<>();
}

class Wallet {
	private Money money;
	private String trainTicket;
	private String busPass;
	private List<String> otherDocuments;
}
