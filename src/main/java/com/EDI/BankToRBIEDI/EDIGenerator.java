package com.EDI.BankToRBIEDI;


import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import com.EDI.BankToRBIEDI.models.AccountDetails;
import com.EDI.BankToRBIEDI.models.Address;
import com.EDI.BankToRBIEDI.models.Applicant;
import com.EDI.BankToRBIEDI.models.Contact;
import com.EDI.BankToRBIEDI.models.Header;
import com.EDI.BankToRBIEDI.models.Registry;
import com.EDI.BankToRBIEDI.models.RootEDIMessage;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * Hello world!
 *
 */
public class EDIGenerator {
	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {

		RootEDIMessage edi = new RootEDIMessage();

		// header
		Header header = new Header();

		header.setBankCode("AXIS000987");
		header.setMessageId(UUID.randomUUID().toString());
		header.setTimeStampUTC(DateTimeFormatter.ISO_INSTANT.format(Instant.now()));
		edi.setHeader(header);

		// applicant
		Applicant applicant = new Applicant();

		applicant.setName("Jayabharath");
		applicant.setDob("2003-10-03");
		applicant.setGender("male");
		applicant.setPan("CPQUJ1234H");
		edi.setApplicant(applicant);

		// Contact
		Contact contact = new Contact();

		contact.setEmail("jaybharath@gmail.com");
		contact.setPhone("9876543210");
		edi.setContact(contact);

		// address
		Address address = new Address();

		address.setLine1("890 anna nagar");
		address.setCity("Chennai");
		address.setState("Tamil Nadu");
		address.setPincode("600001");
		edi.setAddress(address);

		// accountdetails
		AccountDetails accountDetails = new AccountDetails();
		
		accountDetails.setAccountNumber("102934982334");
		accountDetails.setAccountType("SAVINGS");
		accountDetails.setInitialDeposit(10000.00);
		edi.setAccountDetails(accountDetails);
		
		//registry
		Registry registry = new Registry();
		registry.setBranchCode("AXISCHEN123");
		registry.setKycStatus("VERIFIED");
		edi.setRegistry(registry);
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		
		File outputFile = new File("AXIS_to_Rbi_EDI.json");
		
		mapper.writeValue(outputFile,edi);
		
		System.out.println("JSON FIle Created Successfully "+outputFile.getAbsolutePath());

				

	}
}
