package com.aridhu.microservices.film.piracy.capturetorrent.service;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
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

public class Level3 {

	public static void main(String[] args) {
		
		byte[] data;
		try {
			data = FileUtils.readFileToByteArray(new File("/Users/balasankar/Downloads/tamilrockers/piracy1.torrent"));
			TorrentMetadata torrentMetadata = new TorrentParser().parse(data);
			System.out.println(torrentMetadata.getAnnounce());
			List<List<String>> announceList = torrentMetadata.getAnnounceList();
			ListIterator<List<String>> ait = announceList.listIterator();
			while(ait.hasNext()) {
				List<String> announce = ait.next();
				System.out.println(announce);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}

	public List<HtmlAnchor> capture(String entryurl) {
		List<HtmlAnchor> filtereditems = null;
		URL url;
		try {
			url = new URL(entryurl);
			AsyncHttpClient client = Dsl.asyncHttpClient();
			final FileOutputStream stream = new FileOutputStream("/Users/balasankar/Downloads/tamilrockers/piracy1.torrent");
			client.prepareGet(entryurl).execute(new AsyncCompletionHandler<FileOutputStream>() {
				 
			    @Override
			    public State onBodyPartReceived(HttpResponseBodyPart bodyPart) 
			      throws Exception {
			        stream.getChannel().write(bodyPart.getBodyByteBuffer());
			        return State.CONTINUE;
			    }
			 
			    @Override
			    public FileOutputStream onCompleted(Response response) 
			      throws Exception {
			        return stream;
			    }
			});
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return filtereditems;
		
	}

}
