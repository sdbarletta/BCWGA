package com.sdbarletta.bcwga.client;

import com.sdbarletta.bcwga.shared.Contact;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface EmailServiceAsync {
	void sendEmail(Contact c, AsyncCallback<String> callback) throws IllegalArgumentException;
}
