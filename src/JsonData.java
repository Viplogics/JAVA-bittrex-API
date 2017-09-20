package bittrex;

import javax.json.JsonObject;

public class JsonData {
	bittrex.StringData sData ;
	
	public JsonData() {
		sData = new bittrex.StringData();
	}

	private String getAccountData(String apiCall, String params) {
		return sData.getAccountData(apiCall, params);
	}

	private String getPublicData(String apiCall, String params) {		
		return sData.getPublicData(apiCall, params);
	}

	public JsonObject getBalances() {
		return JSONParser.getObject(getAccountData("/account/getBalances", null));
	}

	public JsonObject getBalance(String currency) {
		return JSONParser.getObject(getAccountData("/account/getBalance", "&currency=" + currency));
	}

	public JsonObject getBalance(Currency c) {
		return getBalance(c.toString());
	}

	public JsonObject getOpenOrders() {
		return JSONParser.getObject(getAccountData("/market/getopenorders", null));
	}

	public JsonObject getOpenOrders(Currency c1, Currency c2) {
		return JSONParser
				.getObject(getAccountData("/market/getopenorders", "&market=" + c1.toString() + "-" + c2.toString()));
	}

	public JsonObject getOpenOrders(String currency1, String currency2) {
		return JSONParser.getObject(getAccountData("/market/getopenorders", "&market=" + currency1 + "-" + currency2));
	}

	public JsonObject getOrder(String uuid) {
		return JSONParser.getObject(getAccountData("/account/getorder", "&uuid=" + uuid));
	}

	public JsonObject getOrderHistory() {
		return JSONParser.getObject(getAccountData("/account/getorderhistory", null));
	}

	public JsonObject getMarketSummary() {
		return JSONParser.getObject(this.getPublicData("/public/getmarketsummaries", null));
	}

	public JsonObject getMarketSummary(Currency c1, Currency c2) {
		return JSONParser.getObject(
				this.getPublicData("/public/getmarketsummary", "?market=" + c1.toString() + "-" + c2.toString()));
	}

	public JsonObject getMarketSummary(String currencyPair) {
		return JSONParser.getObject(this.getPublicData("/public/getmarketsummary", "?market=" + currencyPair));
	}

	public JsonObject getTicker(String currencyPair) {
		return JSONParser.getObject(this.getPublicData("/public/getticker", "?market=" + currencyPair));
	}

	public JsonObject getTicker(Currency c1, Currency c2) {
		return JSONParser
				.getObject(this.getPublicData("/public/getticker", "?market=" + c1.toString() + "-" + c2.toString()));
	}

	public JsonObject getMarkets() {
		return JSONParser.getObject(this.getPublicData("/public/getmarkets", null));
	}

	public JsonObject getCurrencies() {
		return JSONParser.getObject(this.getPublicData("/public/getcurrencies", null));
	}

	public JsonObject cancelOrder(String uuid) {
		return JSONParser.getObject(this.getAccountData("/market/cancel", "&uuid=" + uuid));
	}

	public JsonObject createBuyOrder(Currency c1, Currency c2, double quantity, double rate) {
		return JSONParser.getObject(this.getAccountData("/market/buylimit",
				"&market=" + c1.toString() + "-" + c2.toString() + "&quantity=" + quantity + "&rate=" + rate));
	}

	public JsonObject createSellOrder(Currency c1, Currency c2, double quantity, double rate) {
		return JSONParser.getObject(this.getAccountData("/market/selllimit",
				"&market=" + c1.toString() + "-" + c2.toString() + "&quantity=" + quantity + "&rate=" + rate));
	}

}
