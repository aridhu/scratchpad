package com.aridhu.microservices.film.piracy;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.apache.commons.io.FileUtils;
import org.asynchttpclient.AsyncCompletionHandler;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.Dsl;
import org.asynchttpclient.HttpResponseBodyPart;
import org.asynchttpclient.Response;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.turn.ttorrent.client.SimpleClient;
import com.turn.ttorrent.common.TorrentMetadata;
import com.turn.ttorrent.common.TorrentParser;
import com.turn.ttorrent.tracker.TrackedTorrent;
import com.turn.ttorrent.tracker.Tracker;

public class Level4 {

	public static void main(String[] args) {
		try {
			Tracker tracker = new Tracker(6969);
			FilenameFilter filter = new FilenameFilter() {
				  public boolean accept(File dir, String name) {
					  System.out.println(name);
				    return name.endsWith(".torrent");
				  }
				};

				for (File f : new File("/Users/balasankar/Downloads/tamilrockers").listFiles(filter)) {
				  tracker.announce(TrackedTorrent.load(f));
				}
				tracker.setAcceptForeignTorrents(true);
				tracker.start(true);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			    
	}

	
}
