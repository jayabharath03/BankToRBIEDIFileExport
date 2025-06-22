package com.EDI.BankToRBIEDI.models;

import lombok.Data;

@Data
public class Header {
	
	private String bankCode;
	private String messageId;
	private String timeStampUTC;
	
}
