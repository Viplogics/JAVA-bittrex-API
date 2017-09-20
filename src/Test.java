package bittrex;

import javax.json.JsonObject;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		testJsonData();
	}

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
}
