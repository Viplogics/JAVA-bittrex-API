# JAVA-bittrex-API
Java-Client for the Bittrex REST-API


Bittrex is a US-based leading trading platform for crypto-currencies created by security professionals. 

It provides a simple and powerful REST API to allow programatically to perform nearly all actions that can be done via  the bittrex web-interface. All requests use the application/json content type and go over https. The base url is https://bittrex.com/api/{version}/.

There was no JAVA-client library yet, so I have written this one. You need to use your own JSON-Parser to extract the data for your purposes. I can provide a parser in future releases, if requested.

Use at your own risk...!

Tips are appreciated:

BTC: 15SHLso9jMtVsLZ839EBTNaiyPp1jfA5q2
LTC: LWZFZLQSLNxpF6a56zyU33LkiKLHNpUoi8
ETH: 0xA6DdDf8B0176bE9f855C367d45002877331243cE

#Example-usage:

// Most important class for usage is the class bittrex.Data:

Data bittrexData = new Data();
String jsonBalance=bittrexData.getBalances();
// ... then extract the data you want from the resulting JSON-String 

// Print out, just to test: 
System.out.println(bittrexData.getBalanbittrexDatae("XMR"));
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
