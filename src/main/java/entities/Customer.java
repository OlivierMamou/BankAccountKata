package entities;

import java.util.UUID;

public class Customer {

	private UUID customerId;
	private String familyName;
	private String firstName;
	private String address;

	public Customer(String familyName, String firstName, String address) {
		this.customerId = UUID.randomUUID();
		this.familyName = familyName;
		this.firstName = firstName;
		this.address = address;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public UUID getId() {
		return customerId;
	}

	public void setId(UUID id) {
		this.customerId = id;
	}

}
