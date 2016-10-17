package example;

import javax.jws.WebService;

@WebService(
			endpointInterface = "example.WebServiceInterface",
			portName = "webservicePort",
			serviceName = "WebService")
public class WebServiceImpl implements WebServiceInterface{
	
	private Double result;
	private Double amount;
	
	@Override
	public String greet(String clientName) {
		return "Hi, "+clientName+", this is WebService!";
	}

	@Override
	public void convert(Double amount) {
		this.amount = amount;
		this.result = amount*0.7;
	}

	@Override
	public String result() {
		return amount+" NZD = "+result+" USD.";
	}

}
