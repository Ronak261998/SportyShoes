package com.simplilearn.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.simplilearn.entity.Product;
import com.simplilearn.repository.ProductRepository;

@Controller
public class productController {
	@Autowired
	private ProductRepository pRepo;
	@GetMapping("/addProduct")
	public ModelAndView addProduct() {
		ModelAndView mav = new ModelAndView("addProduct");
		Product newProduct = new Product();
		mav.addObject("product", newProduct);
		return mav;
	}
	@PostMapping("/saveProduct")
	public String saveProduct(@ModelAttribute Product product) {
		pRepo.save(product);
		return "redirect:/allProducts";
	}
	@GetMapping("/allProducts")
	public ModelAndView getAllProducts() {
		ModelAndView mav = new ModelAndView("ProductList");
		List<Product> products = pRepo.findAll();
		mav.addObject("products", products);
		return mav;
	}
	@GetMapping("/updateProduct")
	public ModelAndView UpdateProduct(@RequestParam int id) {
		ModelAndView mav = new ModelAndView("addProduct");
		Product product = pRepo.findById(id).get();
		mav.addObject("product", product);
		return mav;
	}
	@GetMapping("/deleteProduct")
	public String DeleteProduct(@ModelAttribute Product product,@RequestParam int id) {
		pRepo.deleteById(id);
		return "redirect:/allProducts";
	}	
}
