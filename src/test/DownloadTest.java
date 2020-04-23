package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class DownloadTest {
	
	public static void main(String[] args) {
		try {
			String url = "http://quotes.wsj.com/AAPL/historical-prices/download?MOD_VIEW=page&num_rows=300&startDate=01/01/2018&endDate=12/31/2018";
			URL u = new URL(url);
			BufferedReader in = new BufferedReader(
			new InputStreamReader(u.openStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
			System.out.println(inputLine);
			}
			in.close();

		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
}
