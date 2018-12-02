package com.aridhu.microservices.film.piracy;

import java.util.ArrayList;
import java.util.List;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class Level2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<HtmlAnchor> capture(String entryurl) {
		List<HtmlAnchor> filtereditems = null;
		WebClient client = new WebClient();  
		client.getOptions().setCssEnabled(false);  
		client.getOptions().setJavaScriptEnabled(false);  
		try {  
		  HtmlPage page = client.getPage(entryurl);
		 // System.out.println(page);
		  List<HtmlAnchor> items = (List<HtmlAnchor>) page.getAnchors();  
		  if(items.isEmpty()){  
		    System.out.println("No items found !");
		  }else{
			  filtereditems = new ArrayList();
			  for(HtmlAnchor itemAnchor : items){  
			    String itemName = itemAnchor.asText();
			    String itemUrl = itemAnchor.getHrefAttribute() ;
			    if(itemName.contains("2.0")) {
			    	System.out.println( itemName);
			    	System.out.println( itemUrl);
			    	filtereditems.add(itemAnchor);
			    }
					    
			  }
		  }
		}catch(Exception e){
		  e.printStackTrace();
		}
		return filtereditems;
		
	}

}
