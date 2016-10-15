package com.demo.composite.client.bean;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

import com.demo.composite.model.Composite;

@Component
public class CompositeClientBean {

	public String createComposite(Composite composite, Exchange exchange) throws Exception {
		return "Created Composite with Reference Number: " + composite.getReferenceNumber();
	}

	public String deleteCompositeByReferenceNumber(String referenceNumber) throws Exception {
		return "Deleted Composite:" + referenceNumber;

	}

	public String getCompositeByReferenceNumber(String referenceNumber) throws Exception {
		return "Composite:" + referenceNumber;

	}

}
