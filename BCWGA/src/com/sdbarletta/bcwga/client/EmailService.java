package com.sdbarletta.bcwga.client;

import com.sdbarletta.bcwga.shared.Contact;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("contactus")
public interface EmailService extends RemoteService {
	String sendEmail(Contact c) throws IllegalArgumentException;
}
