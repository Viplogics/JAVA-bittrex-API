package bittrex;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class StringData {
	String version = "v1.1";
	String key = "<API-key>";
	String secret = "<secret key>";
	String bittrexApiUrl = "https://bittrex.com/api/" + version;

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
		bittrexApiUrl = "https://bittrex.com/api/" + version;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public StringData() {
		try {
			String currentDir = System.getProperty("user.dir");
			String _s_ = File.separator;
			Properties prop = new Properties();
			InputStream propFile = new FileInputStream(
					currentDir + _s_ + "bittrex-client" + _s_ + "bittrex-properties.txt");
			prop.load(propFile);
			this.setKey(prop.getProperty("apikey"));
			this.setSecret(prop.getProperty("apisecret"));
			this.setVersion(prop.getProperty("bittrex-apiversion"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String getAccountData(String apiCall, String params) {
		bittrex.Request r = new bittrex.Request();
		String result = null;
		try {
			if (params == null)
				result = r.apiSecretCall(key, secret, bittrexApiUrl + apiCall, "theNonce");
			else
				result = r.apiSecretCall(key, secret, bittrexApiUrl + apiCall, "theNonce" + params);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public String getPublicData(String apiCall, String params) {
		bittrex.Request r = new bittrex.Request();
		String result = null;
		try {
			if (params == null)
				result = r.apiPublicCall(bittrexApiUrl + apiCall);
			else
				result = r.apiPublicCall(bittrexApiUrl + apiCall + params);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public String getBalances() {
		return getAccountData("/account/getBalances", null);
	}

	public String getBalance(String currency) {
		return getAccountData("/account/getBalance", "&currency=" + currency);
	}

	public String getBalance(Currency c) {
		return getBalance(c.toString());
	}

	public String getOpenOrders() {
		return getAccountData("/market/getopenorders", null);
	}

	public String getOpenOrders(Currency c1, Currency c2) {
		return getAccountData("/market/getopenorders", "&market=" + c1.toString() + "-" + c2.toString());
	}

	public String getOpenOrders(String currency1, String currency2) {
		return getAccountData("/market/getopenorders", "&market=" + currency1 + "-" + currency2);
	}

	public String getOrder(String uuid) {
		return getAccountData("/account/getorder", "&uuid=" + uuid);
	}

	public String getOrderHistory() {
		return getAccountData("/account/getorderhistory", null);
	}

	public String getMarketSummary() {
		return this.getPublicData("/public/getmarketsummaries", null);
	}

	public String getMarketSummary(Currency c1, Currency c2) {
		return this.getPublicData("/public/getmarketsummary", "?market=" + c1.toString() + "-" + c2.toString());
	}

	public String getMarketSummary(String currencyPair) {
		return this.getPublicData("/public/getmarketsummary", "?market=" + currencyPair);
	}

	public String getTicker(String currencyPair) {
		return this.getPublicData("/public/getticker", "?market=" + currencyPair);
	}

	public String getTicker(Currency c1, Currency c2) {
		return this.getPublicData("/public/getticker", "?market=" + c1.toString() + "-" + c2.toString());
	}

	public String getMarkets() {
		return this.getPublicData("/public/getmarkets", null);
	}

	public String getCurrencies() {
		return this.getPublicData("/public/getcurrencies", null);
	}

	public String cancelOrder(String uuid) {
		return this.getAccountData("/market/cancel", "&uuid=" + uuid);
	}

	public String createBuyOrder(Currency c1, Currency c2, double quantity, double rate) {
		return this.getAccountData("/market/buylimit",
				"&market=" + c1.toString() + "-" + c2.toString() + "&quantity=" + quantity + "&rate=" + rate);
	}

	public String createSellOrder(Currency c1, Currency c2, double quantity, double rate) {
		return this.getAccountData("/market/selllimit",
				"&market=" + c1.toString() + "-" + c2.toString() + "&quantity=" + quantity + "&rate=" + rate);
	}

}
