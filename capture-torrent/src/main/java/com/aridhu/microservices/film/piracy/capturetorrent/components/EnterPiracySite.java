package com.aridhu.microservices.film.piracy.capturetorrent.components;

import java.util.List;
import java.util.ListIterator;

import org.springframework.stereotype.Component;

import com.aridhu.microservices.film.piracy.capturetorrent.service.Level1;
import com.aridhu.microservices.film.piracy.capturetorrent.service.Level2;
import com.aridhu.microservices.film.piracy.capturetorrent.service.Level3;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;

@Component
public class EnterPiracySite {
	
	public void lookforNewEntry() {
		String entryurl = "http://tamilrockers.com";
		System.out.println("Enter Piracy Site..." + entryurl);
		Level1 one = new Level1();
		List<HtmlAnchor> filteredOne = one.capture(entryurl);
		if(filteredOne != null) {
			ListIterator<HtmlAnchor> fit = filteredOne.listIterator();
			if(fit.hasNext()) {
				HtmlAnchor htmlAnchor = fit.next();
				System.out.println( String.format("Name : %s Url : %s", htmlAnchor.asText(), htmlAnchor.getHrefAttribute()));
				Level2 two = new Level2();
				List<HtmlAnchor> filteredTwo = two.capture(htmlAnchor.getHrefAttribute());
				if(filteredTwo != null) {
					ListIterator<HtmlAnchor> fit2 = filteredTwo.listIterator();
					while(fit2.hasNext()) {
						HtmlAnchor htmlAnchor2 = fit2.next();
						System.out.println( String.format("Name : %s Url : %s", htmlAnchor2.asText(), htmlAnchor2.getHrefAttribute()));
						Level3 three = new Level3();
						List<HtmlAnchor> filteredThree = three.capture(htmlAnchor2.getHrefAttribute());
					}
				}
			}
		}
	}

}
