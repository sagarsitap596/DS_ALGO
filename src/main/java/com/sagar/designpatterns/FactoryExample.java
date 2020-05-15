package com.sagar.designpatterns;

import java.util.List;

/**
 * This pattern is used when we want to create object based on the parameter.
 * This is mostly interface/abstract driven.
 * 
 * Example : Calender class
 * 
 * @author sitapsha
 *
 */
public class FactoryExample {

	public static void main(String[] args) {
		OperationalSupplier operationalSupplier = (OperationalSupplier) SupplierFactory
				.getSupplier(SupplierType.OPERATIONAL);
		PotentialSupplier potentialSupplier = (PotentialSupplier) SupplierFactory.getSupplier(SupplierType.POTENTIAL);

		System.out.println(operationalSupplier);
		System.out.println(potentialSupplier);
	}

}

enum SupplierType {
	POTENTIAL, OPERATIONAL;
}

class SupplierFactory {

	public static Supplier getSupplier(SupplierType type) {
		switch (type) {
		case OPERATIONAL:
			return new OperationalSupplier("0", "SUPPLIER");
		case POTENTIAL:
			return new PotentialSupplier("1", "COMPANY");
		default:
			return null;
		}
	}
}

abstract class Supplier {
	protected String name;
	protected String SupplierType;
	protected String companyType;
	protected List<String> contacts;
	protected List<String> addresses;

	public Supplier(String supplierType, String companyType) {
		super();
		SupplierType = supplierType;
		this.companyType = companyType;
	}
}

class PotentialSupplier extends Supplier {

	private List<String> interestedCompanies;

	public PotentialSupplier(String supplierType, String companyType) {
		super(supplierType, companyType);
	}

	@Override
	public String toString() {
		return "PotentialSupplier [interestedCompanies=" + interestedCompanies + ", name=" + name + ", SupplierType="
				+ SupplierType + ", companyType=" + companyType + ", contacts=" + contacts + ", addresses=" + addresses
				+ "]";
	}
}

class OperationalSupplier extends Supplier {

	private String taxId;
	private String bankAccountNumber;
	private List<String> operatingCompanies;

	public OperationalSupplier(String supplierType, String companyType) {
		super(supplierType, companyType);
	}

	@Override
	public String toString() {
		return "OperationalSupplier [taxId=" + taxId + ", bankAccountNumber=" + bankAccountNumber
				+ ", operatingCompanies=" + operatingCompanies + ", name=" + name + ", SupplierType=" + SupplierType
				+ ", companyType=" + companyType + ", contacts=" + contacts + ", addresses=" + addresses + "]";
	}

}
