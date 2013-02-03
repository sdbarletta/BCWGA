package com.sdbarletta.bcwga.server;

import com.sdbarletta.bcwga.client.EmailService;
import com.sdbarletta.bcwga.shared.Contact;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class EmailServiceImpl extends RemoteServiceServlet implements EmailService {

	public String sendEmail(Contact c) throws IllegalArgumentException {
		String result = null;
		Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);

        String msgBody = c.toString();

        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("sdbarletta@gmail.com", "BCWGA Admin"));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress("bcwgainfo@gmail.com", "BCWGA Info"));
            msg.setSubject("BCWGA Website: Info Requested by "+c.getName());
            msg.setText(msgBody);
            Transport.send(msg);
    
            result = "Thank you! A BCWGA member will be contacting you soon.";
        } catch (Exception e) {
            result = "Email send failed: "+e.getMessage();
        }
		return result;
	}
	
}
