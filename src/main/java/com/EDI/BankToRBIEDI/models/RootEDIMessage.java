package com.EDI.BankToRBIEDI.models;

import lombok.Data;

@Data
public class RootEDIMessage {
	private Header header;
    private Applicant applicant;
    private Contact contact;
    private Address address;
    private AccountDetails accountDetails;
    private Registry registry;
}
