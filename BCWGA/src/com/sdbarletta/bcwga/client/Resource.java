package com.sdbarletta.bcwga.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public interface Resource extends ClientBundle {
	  public static final Resource INSTANCE =  GWT.create(Resource.class);

	  @Source("images/2012_Special_Events.png")
	  public ImageResource specialEvents();
	 
	  @Source("images/footer.jpg")
	  public ImageResource bcLogoFooter();
	  
	  @Source("images/BC_Logo.png")
	  public ImageResource bcLogo();
	  
	  @Source("images/BC_Muni_Logo.png")
	  public ImageResource bcMuniLogo();
}

