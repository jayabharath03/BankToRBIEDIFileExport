package com.EDI.BankToRBIEDI.models;

import lombok.Data;

@Data
public class AccountDetails {
	private String accountNumber;
	private String accountType;
	private double initialDeposit;
	
}
