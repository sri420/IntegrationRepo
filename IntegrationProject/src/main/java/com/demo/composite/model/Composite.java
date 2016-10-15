
package com.demo.composite.model;

public class Composite {

	String referenceNumber;
	String description;
	


	public String getDescription() {
		return description;
	}

	public String getReferenceNumber() {
		return referenceNumber;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	@Override
	public String toString() {
		return "Composite [referenceNumber=" + referenceNumber + ", description=" + description + "]";
	}

}
