package bittrex;

import java.io.IOException;

public class Data {
	String version = "v1.1";
	String key = "<API-key>";
	String secret = "<secret key>";
	String bittrexApiUrl = "https://bittrex.com/api/" + version;

	public Data() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Data bittrexData = new Data();
		// System.out.println(bittrexData.getBalances());
		System.out.println(bittrexData.getBalance("XMR"));
		// System.out.println(bittrexData.getBalance("LTC"));
		// System.out.println(bittrexData.getOpenOrders());
		// System.out.println(bittrexData.getOpenOrders("ETH", "BAT"));

		// System.out.println(bittrexData.getOpenOrders(Currency.ETH, Currency.BAT));
		// System.out.println(bittrexData.getOrder("fbfbd380-fb3e-49b8-9cc4-626fcdf9959b"));
		// System.out.println(bittrexData.getOrderHistory());
		// System.out.println(bittrexData.getMarketSummary());
		// System.out.println(bittrexData.getMarketSummary(Currency.BTC, Currency.XMR));
		// System.out.println(bittrexData.getTicker(Currency.BTC, Currency.XMR));
		// System.out.println(bittrexData.getTicker("BTC-XMR"));
		// System.out.println(bittrexData.getMarkets());
		// System.out.println(bittrexData.getCurrencies());
		// System.out.println(bittrexData.cancelOrder("fbfbd380-fb3e-49b8-9cc4-626fcdf9959b"));
		//System.out.println(bittrexData.createBuyOrder(Currency.ETH, Currency.BAT, 10, 0.00006));
		System.out.println(bittrexData.createSellOrder(Currency.ETH, Currency.BAT, 10, 0.1));
	}

	private String getAccountData(String apiCall, String params) {
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

	private String getPublicData(String apiCall, String params) {
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
