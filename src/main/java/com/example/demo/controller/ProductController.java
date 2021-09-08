package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("product")

// we give the url of spring
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
	// CONTROLLER CALLED SERVICE LAYERED
	@Autowired
	ProductService productservice;
	
	@PostMapping
	public ResponseEntity<String> addProduct(@RequestBody Product product){
		ResponseEntity<String> responseentity = null;
		int productId = product.getProductId();
		String message = null;
		if(productservice.isProductExists(productId)) {
			message = "Product with productId"+productId+"already exist";
			responseentity = new ResponseEntity<String>(message,HttpStatus.CONFLICT);
			
		}
		else {
			productservice.addProduct(product);
			message = "Product with productId"+productId+"saved successfully";
			responseentity = new ResponseEntity<String>(message,HttpStatus.CREATED);
			
			
			
		}
		return responseentity;
	}
	
	// for fillterBy price method
	@GetMapping("filterProductByprice/{lowerPrice}/{upperPrice}")
	public List<Product>filterProductByPrice(@PathVariable("lowerPrice")int lowerPrice,@PathVariable("upperPrice")int upperPrice){
		return productservice.filterByPrice( lowerPrice,upperPrice);
	}
	
	@GetMapping
	public ResponseEntity<List<Product>>getProduct(){
		ResponseEntity<List<Product>> responseentity = null;
		List<Product>products = productservice.getAllProducts();
		if(products.size()==0) {
			responseentity = new ResponseEntity<List<Product>>(products,HttpStatus.NO_CONTENT);

			
		}else
		{
			responseentity = new ResponseEntity<List<Product>>(products,HttpStatus.OK);

			
		}
		

		return responseentity;
	}
	
	@GetMapping("{productId}")
	public ResponseEntity <Product> getProduct(@PathVariable("productId")int productId){
		System.out.println("All product is called"+ productId);
		ResponseEntity<Product> responseentity = null;
		Product product = new Product();
		if(productservice.isProductExists(productId)) {
			product = productservice.getProductById(productId);
			responseentity = new ResponseEntity <Product> (product,HttpStatus.FOUND);

			
		}else
		{
			responseentity = new ResponseEntity<Product>(product,HttpStatus.NO_CONTENT);

			
		}


		// hit the service layered
		return responseentity;
	}
	
	
//	@PostMapping
//	public String addProduct(@RequestBody Product product) {
//		System.out.println("add product called");
//		System.out.println(product);
//		productservice.addProduct(product);
//		return null;
	//}
	
	@PutMapping
	public ResponseEntity< String> updateProduct(@RequestBody Product product) {
		ResponseEntity<String> responseentity = null;
		int productId = product.getProductId();
		String message = null;
		if(productservice.isProductExists(productId)) {
		 productservice.updateProduct(product);
			message = "Product with productId"+productId+"Updated successfully";

			responseentity = new ResponseEntity <String> (message,HttpStatus.FOUND);

			
		}else
		{
			responseentity = new ResponseEntity<String>(message,HttpStatus.NO_CONTENT);

			
		}

		return responseentity;
	}
	
	@DeleteMapping("{productId}")
	public String deleteProduct(@PathVariable("productId") int pId) {
		System.out.println("delete product called"+pId);
		productservice.deleteProduct(pId);
		return " Product deleted succesfully";
	}
	@GetMapping("/searhByName/({productName}")
	public List<Product>getProductByName(@PathVariable("productName")String productName){
		System.out.println("getting a single product by name"+productName);
		return productservice.getProductByName(productName);
		
	}
	// find by quantity on hands
	@GetMapping("/searhByquantity/({quantityOnHand}")
	public List<Product>getQuantityOnHand(@PathVariable("quantityOnHand")String quantityOnHand){
		System.out.println("getting by quantity on hand"+quantityOnHand);
		return productservice.getProductByName(quantityOnHand);
		
	}
	
	@GetMapping("/searhByquantitygreater/({quantityOnHand}")
	public List<Product>getQuantityOnHandGreater(@PathVariable("quantityOnHand")String quantityOnHand){
		System.out.println("getting by quantity on hand greater"+quantityOnHand);
		return productservice.getProductByName(quantityOnHand);



}
	@GetMapping("/searhByquantityless/({quantityOnHand}")
	public List<Product>getQuantityOnHandLess(@PathVariable("quantityOnHand")String quantityOnHand){
		System.out.println("getting by quantity on hand greater"+quantityOnHand);
		return productservice.getProductByName(quantityOnHand);



}
}
