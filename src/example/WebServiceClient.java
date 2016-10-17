package example;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import javax.xml.namespace.QName;

import javax.xml.ws.Service;


public class WebServiceClient {
	public static void main(String[] args) throws MalformedURLException{
		URL url = new URL("http://localhost:8080/MyWebService/WebServiceInterface?wsdl");
		QName qname = new QName("http://example/","WebService");
		Service service = Service.create(url, qname);
		WebServiceInterface callWebService = service.getPort(WebServiceInterface.class);
		System.out.println("Service output: \n"+callWebService.greet("WebServiceClient"));
		
		//System.out.println(args[0]+args[1]+args[2]);
		
		System.out.println("\nEnter amount of NZD:\n");
		Scanner input = new Scanner(System.in);
		if(input.hasNextDouble()){
			Double in = input.nextDouble();
			callWebService.convert(in);
			System.out.println("\nCurrency From NZD to USD:\n");
			System.out.println(callWebService.result());
		}
		
	}
}
