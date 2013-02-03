package com.sdbarletta.bcwga.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;

public class HandleOldIE implements EntryPoint{

	@Override
	public void onModuleLoad() {
		HTML msg = new HTML("<div ><p>Welcome to the Boulder Women's Golf Association website. You are visiting BCWGA using an older version of Internet Explorer.</p> " +
							"<p>To fully experience all that our website has to offer, please upgrade to <a href='http://windows.microsoft.com/en-US/internet-explorer/downloads/ie-9/worldwide-languages'>Internet Explorer 9</a> or try a different browser such as Firefox. An excellent free browser that we recommend is <a href='https://www.google.com/intl/en/chrome/browser/?&brand=CHHM&utm_campaign=en&utm_source=en-ha-na-us-gmail-et&utm_medium=et'>Google Chrome</a>.</p>" +
							"<p>In the meantime, if you have any questions about our club please email us at <a href='mailTo:bcwgainfo@gmail.com'>BCWGA Info</a>.</p>" +
							"<p>Thanks, we look forward to hearing from you!</p></div>");
		
		RootPanel.get("thePage").add(msg);
		
	}

}
