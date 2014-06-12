package com.sdbarletta.bcwga.client;

import com.sdbarletta.bcwga.shared.Contact;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.FormPanel.SubmitEvent;
import com.google.gwt.user.client.ui.FormPanel.SubmitHandler;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Image;

public class MyClubGolf implements EntryPoint {

	private static final String muniLink = "http://www.bouldercitygolf.com/sites/courses/layout.asp?id=848&page=47993";
	private static final String creekLink = "http://www.bouldercitygolf.com/sites/courses/layout.asp?id=848&page=47994";
	private static final String golfHomeLink = "http://www.bouldercitygolf.com/sites/courses/layout.asp?id=848&page=47957";
	private static final String membershipAppLink = "/docs/BCWGAMembershipApplication.pdf";
	private static final String calendarLink = "https://www.google.com/calendar/embed?src=bcwgainfo%40gmail.com&amp;ctz=America/Los_Angeles";

	public static Grid header = getHeader();
	public static FlowPanel footer = getFooter();

	private static CaptionPanel homePage = getHomePage();
	private static HTML calendarPage = getGoogleCalendar();
	//private static FlowPanel specialEventsPage = getSpecialEventsPage();
	private static FormPanel contactUsPage = getContactUsPage();
	public static TabPanel tabPanel = getTabPanel();
	
	private static TextBox contactUsPageFocus;
	
	/**
	 * Entry point method.
	 */
	public void onModuleLoad() {
		VerticalPanel thePage = new VerticalPanel();
		thePage.add(header);
		thePage.add(tabPanel);
		thePage.add(footer);
		thePage.setWidth("100%");
	
		RootPanel.get("thePage").add(thePage);
	}
	
	private static Boolean isChrome() {
		String browserVersion = getBrowserVersion();
		return (browserVersion.indexOf("Chrome") >= 0);
	}
	
	private static HTML getGoogleCalendar() {
		HTML cal = null;
		
		if(isChrome()) {
			cal = new HTML("<div style='text-align:center;'><iframe src='"+calendarLink+"' style='border: 1' width='1100' height='400' frameborder='1' ></iframe></div>");
		} else
			cal = new HTML("<h3>Loading Calendar ...</h3>");
		return cal;
	}
	
	private static CaptionPanel getHomePage() {
		// Set up Home page
		CaptionPanel page = new CaptionPanel("Welcome!");
		HTML homeHtml = new HTML("<br/><br/><p>Do you love to play golf, or are you interested in learning how to play golf in a friendly, welcoming environment? You've come to the right place!</p>"+
				"<p>Our ladies group plays every Tuesday at the <a href='"+muniLink+"'><b>Boulder City Municipal Golf Course</b></a>, tee-time 7:30am Spring/Summer/Fall and 8:30am Winter.</p>"+
				"<p>To get a membership application, click the 'Membership Application' tab. " +
				"To see upcoming events at the club, click the 'Calendar' tab. " +
				"<p>For all other questions, please click the 'Contact Us' tab.</p>"
				);
		page.add(homeHtml);
		page.setStyleName("page");
		page.setHeight(getTabPanelHeight());
		page.setWidth("97.5%");
		return page;
	}
	
	private static String getTabPanelHeight() {
		return (Window.getClientHeight() * .55)+"px";
	}

	private static FlowPanel getSpecialEventsPage() {
		// Set up Special Events page
		FlowPanel page = new FlowPanel();
		Image cal = new Image();
		cal.setResource(Resource.INSTANCE.specialEvents());
		page.add(cal);
		page.setHeight(getTabPanelHeight() + 20);
		page.setStyleName("page");
		
		return page;
	}

	private static Grid getHeader() {
		Grid h = new Grid(1,3);

		// Set up the images in the banner header
		Image muniImage = new Image();
		muniImage.setResource(Resource.INSTANCE.bcMuniLogo());
		Image creekImage = new Image();
		creekImage.setResource(Resource.INSTANCE.bcLogo());

		muniImage.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				Window.Location.assign(muniLink);
			}
		});

		creekImage.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				Window.Location.assign(creekLink);
			}
		});

		// Set up text in the banner header
		Label lbl = new Label();
		lbl.setText("BCWGA");
		lbl.setStyleName("titleBanner");
		Label subLbl = new Label();
		subLbl.setText("Boulder City Women's Golf Association");
		subLbl.setStyleName("subTitleBanner");
		VerticalPanel bannerPanel = new VerticalPanel();
		bannerPanel.add(lbl);
		bannerPanel.add(subLbl);

		// Add widgets to banner header
		h.setWidget(0,0,muniImage);
		h.setWidget(0,1,creekImage);
		h.setWidget(0,2,bannerPanel);
		h.getCellFormatter().setWidth(0,0, String.valueOf(muniImage.getWidth()));
		h.getCellFormatter().setWidth(0,1, String.valueOf(creekImage.getWidth()));
		h.setStyleName("header");

		return h;
	}

	private static FlowPanel getFooter() {
		FlowPanel f = new FlowPanel();

		// Set up footer
		Image footerImg = new Image();
		footerImg.setResource(Resource.INSTANCE.bcLogoFooter());
		f.add(footerImg);
		f.setStyleName("footer");
		
		footerImg.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				Window.Location.assign(golfHomeLink);
			}
		});
		
		return f;
	}

	private static String getRequiredFieldLabel(String label) {
		return "<div><span><span style='color:red;font-weight:bold'>*&nbsp;</span>"+label+"</span></div>";
	}

	private static FormPanel getContactUsPage() {
		final FormPanel f = new FormPanel();
		FlexTable g = new FlexTable();
		
		g.setWidget(0,0, new HTML());
		
		final TextBox firstName = new TextBox();
		contactUsPageFocus = firstName;
		firstName.setName("firstName");
		g.setWidget(1,0,new HTML(getRequiredFieldLabel("First Name")));
		g.setWidget(1,1,firstName);
		
		final TextBox lastName = new TextBox();
		lastName.setName("lastName");
		g.setWidget(1,2,new HTML(getRequiredFieldLabel("Last Name")));
		g.setWidget(1,3,lastName);
		
		final TextBox email = new TextBox();
		email.setName("email");
		g.setWidget(2,0,new HTML(getRequiredFieldLabel("Email")));
		g.setWidget(2,1,email);
		
		final TextBox phone = new TextBox();
		phone.setName("phone");
		g.setWidget(2,2,new Label("Phone"));
		g.setWidget(2,3,phone);
		
		final TextArea msg = new TextArea();
		msg.setName("msg");
		msg.setWidth("499px");
		g.setWidget(3,0,new HTML(getRequiredFieldLabel("Message")));
		g.getCellFormatter().setWidth(3,1, "500px");
		g.getFlexCellFormatter().setColSpan(3, 1, 3);
		g.setWidget(3,1,msg);
		
		final Button submitBtn = new Button("Submit");
		submitBtn.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				enableSubmitButton(submitBtn, false);
				f.submit();
			}});
		g.setWidget(4,3,submitBtn);
		g.setWidth("40%");
		g.setStyleName("page");
		f.addSubmitHandler(new SubmitHandler() {
			public void onSubmit(SubmitEvent event) {
				String errMsg = "Value(s) required for:\n\n";
				Boolean ok = true;
				if (firstName.getText().trim().length() == 0) {
					errMsg += "First Name\n";
					ok = false;
				}
				if (lastName.getText().trim().length() == 0) {
					errMsg += "Last Name\n";
					ok = false;
				}
				if (email.getText().trim().length() == 0) {
					errMsg += "Email\n";
					ok = false;
				}
				if (msg.getText().trim().length() == 0) {
					errMsg += "Message";
					ok = false;
				}

				if (!ok) {
					enableSubmitButton(submitBtn, true);
					Window.alert(errMsg);
				} else {
					Contact c = new Contact();
					c.setFirstName(firstName.getText().trim());
					c.setLastName(lastName.getText().trim());
					c.setEmail(email.getText().trim());
					c.setPhone(phone.getText().trim());
					c.setMsg(msg.getText().trim());
					EmailServiceAsync emailService = GWT.create(EmailService.class);
					
					emailService.sendEmail(c, new AsyncCallback<String>() {
						public void onFailure(Throwable caught) {
							enableSubmitButton(submitBtn, true);
							// Show the RPC error message to the user
							Window.alert(caught.getMessage());
						}

						public void onSuccess(String result) {
							enableSubmitButton(submitBtn, true);
							Window.alert(result);
						}
					});
				}

				event.cancel();
			}
		});
		
		f.add(g);
		f.setHeight(getTabPanelHeight());
		
		return f;
	}
	
	private static void enableSubmitButton(Button b, Boolean enabled) {
		b.setEnabled(enabled);
		if(enabled)
			b.setText("Submit");
		else
			b.setText("Submitting...");
	}

	private static TabPanel getTabPanel() {
		TabPanel tp = new TabPanel(); 

		// Set up tabs for each page
		tp.add(homePage, "Home");
		tp.add(new HTML("<h3>Loading Membership Application ...</h3>"), "Membership Application");
		tp.add(calendarPage, "Calendar");
		//tp.add(specialEventsPage, "Special Events");
		tp.add(contactUsPage, "Contact Us");

		tp.selectTab(0);
		tp.setStyleName("tabPanel");

		// Direct user to pdf when Membership Application tab is clicked
		tp.addSelectionHandler(new SelectionHandler<Integer>(){
			public void onSelection(SelectionEvent<Integer> event){
				int tabId = event.getSelectedItem();
				if(tabId == 0) {
					footer.setVisible(true);
				} else if(tabId == 1) {
					footer.setVisible(false);
					Window.Location.assign(membershipAppLink);
				} else if(tabId == 2) {
					if(!isChrome())
						Window.Location.assign(calendarLink);
					else
						footer.setVisible(false);
				} else if (tabId == 3) {
					footer.setVisible(false);
				} else if(tabId == 4) {
					footer.setVisible(true);
					contactUsPageFocus.setFocus(true);
				}
			}
		});

		return tp;
	}
	
	public static Boolean redirectToIncompatibleBrowserPage() {
		Boolean reroute = false;
		String name = getBrowserName();
		String version = getBrowserVersion();
		
		if(name.equals("Microsoft Internet Explorer") &&
		   version.indexOf("MSIE 9.0") < 0) {
			reroute = true;
		}
		return reroute;
	}
	
	/**
	 * Gets the navigator.appName.
	 *
	 * @return the window's navigator.appName.
	 */
	public static native String getBrowserName() /*-{
	  return $wnd.navigator.appName;
	}-*/;
	
	/**
	 * Gets the navigator.appName.
	 *
	 * @return the window's navigator.appName.
	 */
	public static native String getBrowserVersion() /*-{
	  return $wnd.navigator.appVersion;
	}-*/;

}