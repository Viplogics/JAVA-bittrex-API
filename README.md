# JAVA-bittrex-API
Java-Client for the Bittrex REST-API


Bittrex is a US-based leading trading platform for crypto-currencies created by security professionals. 
<br/>Check here the website: <a href="http://www.bittrex.com">BITTREX</a>

Bittrex provides a simple and powerful REST API to allow programatically to perform nearly all actions that can be done via  their web-interface. All requests use the application/json content type and go over https. 


<br/><br/>
I am not associated  with bittrex, however. Use at your own risk...!
<br/><br/><br/>
Tips are appreciated:
<br/><br/>
BTC: 15SHLso9jMtVsLZ839EBTNaiyPp1jfA5q2<br/>
LTC: LWZFZLQSLNxpF6a56zyU33LkiKLHNpUoi8<br/>
ETH: 0xA6DdDf8B0176bE9f855C367d45002877331243cE<br/>

# Example-usage:

// Most important for usage are the clasess <b>bittrex.StringData</b> and <b>bittrex.JsonData</b><br/>
<br/>
// The  API-key, the secret key and the REST-API-version need to be set in a properties-file situated in<br/>
// ./bittrex-client/bittrex-properties.txt".</br>
// Usage-examples are included in the class Test:<br/>
<br/>
<br/>

public static void testStringData() {
		StringData bittrexData = new StringData();
		System.out.println(bittrexData.getBalances());
		System.out.println(bittrexData.getBalance("XMR"));
		System.out.println(bittrexData.getBalance("LTC"));
		System.out.println(bittrexData.getOpenOrders());
		System.out.println(bittrexData.getOpenOrders("ETH", "BAT"));
		System.out.println(bittrexData.getOpenOrders(Currency.ETH, Currency.BAT));
		System.out.println(bittrexData.getOrder("fbfbd380-fb3e-49b8-9cc4-626fcdf9959b"));
		System.out.println(bittrexData.getOrderHistory());
		System.out.println(bittrexData.getMarketSummary());
		System.out.println(bittrexData.getMarketSummary(Currency.BTC, Currency.XMR));
		System.out.println(bittrexData.getTicker(Currency.BTC, Currency.XMR));
		System.out.println(bittrexData.getTicker("BTC-XMR"));
		System.out.println(bittrexData.getMarkets());
		System.out.println(bittrexData.getCurrencies());
		System.out.println(bittrexData.cancelOrder("fbfbd380-fb3e-49b8-9cc4-626fcdf9959b"));
		System.out.println(bittrexData.createBuyOrder(Currency.ETH, Currency.BAT, 10, 0.00006));
		System.out.println(bittrexData.createSellOrder(Currency.ETH, Currency.BAT, 10, 0.1));
	}

	public static void testJsonData() {
		// Get Wallet-address and balance of BITCOIN:
		JsonData bittrexData = new JsonData();
		JsonObject bitcoinBalance = bittrexData.getBalance("BTC").getJsonObject("result");
		String wallet = JSONParser.getStringValue(bitcoinBalance, "CryptoAddress");
		double balanceValue = JSONParser.getDoubleValue(bitcoinBalance, "Balance");
		double balancePending = JSONParser.getDoubleValue(bitcoinBalance, "Pending");
		System.out.println("Wallet:\t\t" + wallet);
		System.out.println("Balance:\t" + balanceValue);
		System.out.println("Pending:\t" + balancePending);		
	}
