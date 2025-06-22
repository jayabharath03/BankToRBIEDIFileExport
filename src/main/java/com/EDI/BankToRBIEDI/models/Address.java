package com.EDI.BankToRBIEDI.models;

import lombok.Data;

@Data
public class Address {
	private String line1;
	private String city;
	private String state;
	private String pincode;
}
