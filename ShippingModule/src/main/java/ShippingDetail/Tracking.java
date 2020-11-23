package ShippingDetail;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.apache.commons.lang.ArrayUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.net.HttpHeaders;

import org.json.JSONException;
import org.json.JSONObject;

@SpringBootApplication
@RestController
@EnableAutoConfiguration
@RequestMapping("tracking")
public class Tracking {

	ArrayList<BarcodeModel> barcodes = new ArrayList<BarcodeModel>();

	public Tracking() {

	}

	@RequestMapping(value = "/getItems", method = RequestMethod.POST)
	public ResponseEntity<String> getItems(@RequestBody ArrayList<BarcodeModel> items) {
		List<String> barcodes = new ArrayList<String>();
		for (BarcodeModel i : items) {
			barcodes.add(i.getBarcode());
		}
		return connectToThaiPostApi(barcodes);
	}

	@RequestMapping(value = "/getItem", method = RequestMethod.POST)
	public ResponseEntity<String> getItem(@RequestBody BarcodeModel barcode) {
		List<String> barcodes = new ArrayList<String>();
		barcodes.add(barcode.getBarcode());
		return  new ResponseEntity(connectToThaiPostApi(barcodes), HttpStatus.OK);
	}

	private ResponseEntity<String> connectToThaiPostApi(List<String> barcodes) {
		String targetURL = "https://trackapi.thailandpost.co.th/post/api/v1/track";
		String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJzZWN1cmUtYXBpIiwiYXVkIjoic2VjdXJlLWFwcCIsInN1YiI6IkF1dGhvcml6YXRpb24iLCJleHAiOjE2MDg1Mjc0OTIsInJvbCI6WyJST0xFX1VTRVIiXSwiZCpzaWciOnsicCI6InpXNzB4IiwicyI6bnVsbCwidSI6IjExZGFkZmMyODE2Nzg0OGM4MzAyNTRhMDRiODZhZjU3IiwiZiI6InhzeiM5In19.33x5AjCNY4cT0Q6jQH0lYEPTDyIXmNssIRx5cntpxTkjrxrCw5sHrLicN2J1N66CBjQfFy8KzO7DLxYQGaY_cw";

		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost post = new HttpPost(targetURL);

		StringEntity params = null;
		String strBarcodes = "{\"status\":\"all\",\"language\":\"TH\",\"barcode\":[";

		for (String str : barcodes) {
			strBarcodes = strBarcodes + "\"" + str + "\",";
		}
		strBarcodes = strBarcodes.substring(0, strBarcodes.length() - 1) + "]}";

		try {
			params = new StringEntity(strBarcodes);
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		CloseableHttpResponse response = null;
		try {
			post.setEntity(params);
			post.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");
			post.addHeader("Authorization", "Token " + token);
			response = httpClient.execute(post);
			StatusLine statusLine = response.getStatusLine();
			System.out.println(statusLine.getStatusCode() + " " + statusLine.getReasonPhrase());
			String responseBody = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
			System.out.println("Response body: " + responseBody);

			// System.out.println(response.getStatusLine());
//            in = new Scanner(entity.getContent());
//            while (in.hasNext())
//            {
//                System.out.println(in.next());
//
//            }
//            EntityUtils.consume(entity);

			return new ResponseEntity(responseBody, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				response.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);

	}

	public static void main(String[] args) {
		SpringApplication.run(Tracking.class, args);

	}
}
