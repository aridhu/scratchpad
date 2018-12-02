package com.aridhu.microservices.film.piracy.capturetorrent.service;

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

public class Level5 {

	public static void main(String[] args) {
		try {
			// First, instantiate the Client object.
			SimpleClient client = new SimpleClient();

			// This is the interface the client will listen on (you might need something
			// else than localhost here because other peers cannot connect to localhost).
			InetAddress address = InetAddress.getLocalHost();

			//Start download. Thread is blocked here
			  client.downloadTorrent("/Users/balasankar/Downloads/tamilrockers/piracy1.torrent",
			          "/Users/balasankar/Downloads/tamilrockers/output",
			          address);
			  //download finished
			
			//If you don't want to seed the torrent you can stop client
			client.stop();
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			    
	}

	
}
