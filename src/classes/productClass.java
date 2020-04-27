package classes;

import java.util.ArrayList;
import java.util.List;
import services.productService;

public class productClass {
	
	private productService productService;
	
	public productClass(productService productService) {
		this.productService = productService;
	}
	
	public List<String> retrieveProduct(String prod) {
		List<String> filteredIdeas = new ArrayList<String>();
		List<String> allIdeas = productService.retrieveProduct(prod);
		for (String idea : allIdeas) {
			if (idea.contains("Book")) {
				filteredIdeas.add(idea);
			}
		}
		return filteredIdeas;
	}

}
