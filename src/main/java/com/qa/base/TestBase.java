package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class TestBase {
	
	public int RESPONSE_STATUS_CODE_200 = 200;
	public int RESPONSE_STATUS_CODE_500 = 500;
	public int RESPONSE_STATUS_CODE_400 = 400;
	public int RESPONSE_STATUS_CODE_401 = 401;
	public int RESPONSE_STATUS_CODE_201 = 201;
	public int RESPONSE_STATUS_CODE_204 = 204;

	public Properties prop;
		
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public HashMap<String, String> headersConfiguration() {
		HashMap<String, String> headerMap = new HashMap<String, String>();
		headerMap.put("Content-Type", "application/json");
		headerMap.put("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJQRGo5X1FaMl9pQmFCR0ROaDR1aWdTZWU0ckpOWWpKZ2gyZmNEcTVYLVRJIn0.eyJqdGkiOiI1ZTNlNGFkNi04NmYyLTQ5YzAtYjRiMi02MzBmY2E4YTU5YzYiLCJleHAiOjE1NDQ4Njc4NjksIm5iZiI6MCwiaWF0IjoxNTQ0NDM1ODY5LCJpc3MiOiJodHRwOi8vc3RhZ2UuYXV0aC5mZXJubGluay5jb20vYXV0aC9yZWFsbXMvZGVtb19hY2NvdW50IiwiYXVkIjoiY29uc29sZSIsInN1YiI6IjFlM2MyNGI4LTcwMDMtNDVhYi1hMWYzLTIzMGZmYjk0MTI2NCIsInR5cCI6IkJlYXJlciIsImF6cCI6ImNvbnNvbGUiLCJub25jZSI6ImUzYjU1ZTQ1LWRiZWItNDQzYi1iZGY5LTA5ZTM1ZTA4ZDc5NSIsImF1dGhfdGltZSI6MTU0NDQzNTg2Niwic2Vzc2lvbl9zdGF0ZSI6Ijk2OThiMzAwLTU1MWUtNGQ3My05NTVkLWRmNGZmOGFhMWQzZSIsImFjciI6IjEiLCJhbGxvd2VkLW9yaWdpbnMiOlsiKiJdLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsidW1hX2F1dGhvcml6YXRpb24iXX0sInJlc291cmNlX2FjY2VzcyI6eyJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50IiwibWFuYWdlLWFjY291bnQtbGlua3MiLCJ2aWV3LXByb2ZpbGUiXX19LCJuYW1lIjoiU2hhbm11Z2FtIFkiLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJzaGFubXVnYW0ueUBxYXBpdG9sLmNvbSIsImdpdmVuX25hbWUiOiJTaGFubXVnYW0iLCJmYW1pbHlfbmFtZSI6IlkiLCJlbWFpbCI6InNoYW5tdWdhbS55QHFhcGl0b2wuY29tIn0.OnfxD60B8-aZBwJ_Lh2SSK89CErLM2ojYkRxB54rFXk-Ocvkhipv6nrGHsr5Gwl-ux0_T0QvuAD0dbJHZaQ4bQl1XLDP7zBOvV8SgC38fU6AWQGu6mbT6tTGTB5TRBxhdDaazsIljXL3Bfptx2URHPgpkpr-G7YR5u0jgd-dXvKNdfzJJ3i9RafqFuW5DHnhv8CztEmbG_GtpgxAdEJ-Z2Wyn5rE-FVqLA23vveTyoXbFGQPrsxfw78eKLmhsP-G_7AypkHnpZe8FsRW7z0PcQqmWqx8cr-_4yE54uClglq4oatmMtXlFQyi8ylXS2XpNkyMar_9oYys8LbG-4c5Yw");
		headerMap.put("x-realm-name", "demo_account");	
		return headerMap;
	}
	
	public String getURL(String BaseURL,String pageURL) {
		String url = BaseURL + pageURL;
		return url;
	}
}
