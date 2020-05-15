package com.sagar.designpatterns;

/**
 * 
 * This is factory of fatories design pattern
 * 
 * Example :
 * 
 * CreditCardFactory ->[VisaFatory, MasterCardFactory] ->
 * [VisaGoldCreditCard,VisaPlatiniumCreditCard,MasterCardGoldCreditCard,MasterCardPlatiniumCreditCard]
 * 
 * @author sitapsha
 *
 */
public class AbstractFactoryExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

enum CreditCardFactoryType {
	VISA, MASTERCARD
}

enum CreditCardType {
	PLATINIUM, GOLD
}

abstract class CreditCardFactory {

	public static CreditCardFactory getCreditCardFactory(CreditCardFactoryType type) {
		switch (type) {
		case VISA:
			return new VisaFactory();
		case MASTERCARD:
			return new MasterCardFactory();
		default:
			return null;
		}
	}

	abstract public CreditCard getCreditCard(CreditCardType type);
}

class VisaFactory extends CreditCardFactory {

	@Override
	public CreditCard getCreditCard(CreditCardType type) {
		switch (type) {
		case GOLD:
			return new VisaGoldCreditCard();
		case PLATINIUM:
			return new VisaPlatiniumCreditCard();
		default:
			return null;
		}
	}

}

class MasterCardFactory extends CreditCardFactory {
	@Override
	public CreditCard getCreditCard(CreditCardType type) {
		switch (type) {
		case GOLD:
			return new MasterCardGoldCreditCard();
		case PLATINIUM:
			return new MasterCardPlatiniumCreditCard();
		default:
			return null;
		}
	}
}

interface CreditCard {
	double getBalance();
}

class VisaGoldCreditCard implements CreditCard {

	@Override
	public double getBalance() {
		return 0;
	}

}

class VisaPlatiniumCreditCard implements CreditCard {

	@Override
	public double getBalance() {
		return 0;
	}

}

class MasterCardGoldCreditCard implements CreditCard {

	@Override
	public double getBalance() {
		return 0;
	}

}

class MasterCardPlatiniumCreditCard implements CreditCard {

	@Override
	public double getBalance() {
		return 0;
	}

}
