package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class test {
	@Test
	public void test_getRedirectUrl() throws Exception {
		StringTokenizer st;
		
		String url = "http://quotes.wsj.com/AAPL/historical-prices/download?MOD_VIEW=page&num_rows=300&startDate=01/01/2018&endDate=12/31/2018";
		String redictURL = getRedirectUrl(url);
		System.out.println(redictURL);
		URL u = new URL(redictURL);
		URLConnection connection = u.openConnection();
		InputStream inStream = connection.getInputStream();
		Scanner in = new Scanner(inStream);
		// display server response to console
		while (in.hasNextLine()){
		String inputLine = in.nextLine();
		st = new StringTokenizer(inputLine,",");
		String date  = st.nextToken();
		String open = st.nextToken();
		String high = st.nextToken();
		String low = st.nextToken();
		String close = st.nextToken();
		String volume = st.nextToken();
		
		System.out.println(date + ">" + open + ">" + high + ">" + low + ">" + close + ">" + volume);
		}
	}
	
    /**
     * 获取重定向地址
     * @param path
     * @return
     * @throws Exception
     */
	private String getRedirectUrl(String path) throws Exception {
		HttpURLConnection conn = (HttpURLConnection) new URL(path)
				.openConnection();
		conn.setInstanceFollowRedirects(false);
		conn.setConnectTimeout(5000);
		
        return conn.getHeaderField("Location");
	}
}
