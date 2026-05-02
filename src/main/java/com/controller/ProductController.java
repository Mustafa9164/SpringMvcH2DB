package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.Product;
import com.repo.ProductRepo;

@Controller
public class ProductController {
	
	@Autowired
	private ProductRepo productRepo;
	
	@GetMapping("/")
	public String loadForm(Model model) {
		init(model);
		return "index";
	}
	
	@GetMapping("/products")
	public String handleProducts(@ModelAttribute("p") Product p,Model model) {
		model.addAttribute("products",productRepo.findAll());
		return "data";
	}

	private void init(Model model) {
		model.addAttribute("p", new Product());
	}
	
	@PostMapping("/product")
	public String handleSave(@ModelAttribute("p") Product p,Model model) {
		
		Product product = productRepo.save(p);
		if(product.getPid() != null) {
			model.addAttribute("msg","Product Saved");
		}
		
		return "index";
	}
	
	@GetMapping("/edit")
	public String handleEditProduct(@RequestParam Integer pid,Model model) {
		Optional<Product> findById = productRepo.findById(pid);
		if(findById.isPresent()) {
			Product product = findById.get();
			 model.addAttribute("p", product); 
		}
		return "index";
	}
	
	@GetMapping("/delete")
	public String handleDeleteProduct(@RequestParam Integer pid,Model model) {
		
		productRepo.deleteById(pid);
		 model.addAttribute("msg", "Product deleted successfully!"); 
		 init(model);
		return "index";
	}

}
