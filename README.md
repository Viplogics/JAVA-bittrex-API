# JAVA-bittrex-API
Java-Client for the Bittrex REST-API


Bittrex is a US-based leading trading platform for crypto-currencies created by security professionals. 
<br/>Check here the website: <a href="http://www.bittrex.com">BITTREX</a>

Bittrex provides a simple and powerful REST API to allow programatically to perform nearly all actions that can be done via  their web-interface. All requests use the application/json content type and go over https. 

There was no JAVA-client library yet, so I have written this one. You need to use your own JSON-Parser to extract the data for your purposes. I can provide a parser in future releases, if requested.
<br/><br/>
I am not associated  with bittrex, however. Use at your own risk...!
<br/><br/><br/>
Tips are appreciated:
<br/><br/>
BTC: 15SHLso9jMtVsLZ839EBTNaiyPp1jfA5q2<br/>
LTC: LWZFZLQSLNxpF6a56zyU33LkiKLHNpUoi8<br/>
ETH: 0xA6DdDf8B0176bE9f855C367d45002877331243cE<br/>

# Example-usage:

// Most important for usage is the class <b>bittrex.Data</b><br/>
<br/>// Currently the API-key and secret key are hardcoded in this class...:  you need to replace them with your own keys.
<br/><br/>
Data bittrexData = new Data();<br/>
String jsonBalance=bittrexData.getBalances();
//<br/>
//... then extract the data you want from the resulting JSON-String <br/>
//<br/><br/>
// Print out, just for testing: <br/>
System.out.println(bittrexData.getBalance("XMR"));<br/>
System.out.println(bittrexData.getBalance("LTC"));<br/>
System.out.println(bittrexData.getOpenOrders());<br/>
System.out.println(bittrexData.getOpenOrders("ETH", "BAT"));<br/>
System.out.println(bittrexData.getOpenOrders(Currency.ETH, Currency.BAT));<br/>
System.out.println(bittrexData.getOrder("fbfbd380-fb3e-49b8-9cc4-626fcdf9959b"));<br/>
System.out.println(bittrexData.getOrderHistory());<br/>
System.out.println(bittrexData.getMarketSummary());<br/>
System.out.println(bittrexData.getMarketSummary(Currency.BTC, Currency.XMR));<br/>
System.out.println(bittrexData.getTicker(Currency.BTC, Currency.XMR));<br/>
System.out.println(bittrexData.getTicker("BTC-XMR"));<br/>
System.out.println(bittrexData.getMarkets());<br/>
System.out.println(bittrexData.getCurrencies());<br/>
System.out.println(bittrexData.cancelOrder("fbfbd380-fb3e-49b8-9cc4-626fcdf9959b"));<br/>
System.out.println(bittrexData.createBuyOrder(Currency.ETH, Currency.BAT, 10, 0.00006));<br/>
System.out.println(bittrexData.createSellOrder(Currency.ETH, Currency.BAT, 10, 0.1));<br/>
