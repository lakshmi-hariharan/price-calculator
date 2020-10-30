package com.lh.costanalysis;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import com.lh.costanalysis.dao.ExchangeRate;
import com.lh.costanalysis.dao.ExchangeRateRepo;
import com.lh.costanalysis.dao.Product;
import com.lh.costanalysis.dao.ProductJdbcRepository;
import com.lh.costanalysis.dao.ProductValueInput;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class CostAnalysisResource {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    ProductJdbcRepository productRepository;
    
    @Autowired
    ExchangeRateRepo exchangeRateRepo;


    @CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/calculateAmount")
	public Double calculate(@RequestBody ProductValueInput input ) {
        Product prod = productRepository.findById(input.getItemID());
        ExchangeRate rate = exchangeRateRepo.findById(input.getCurrencyAlpha());
        double cost = calculateAmount(prod, rate);
        logger.info("Cost of product " + prod  +  " in currency " 
            + input.getCurrencyAlpha() + " = " + cost);
        return cost;
    }

    private double calculateAmount(Product prod, ExchangeRate rate) {
        double cost = prod.getItemCost() * rate.getCurrencyValue();
        return cost;
    }

    @CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/product")
	public boolean calculate(Long itemID, String itemName, Double itemCost) {
        productRepository.insert(new Product(itemID, itemName, itemCost));
        return true;
    }


    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/product")
    public List<Product> getProducts() {
        List<Product> prods = productRepository.findAll();
        return prods;
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/currency")
    public List<ExchangeRate> getExchangeRates() {
        List<ExchangeRate> rates = exchangeRateRepo.findAll();
        return rates; 
    }
  
}