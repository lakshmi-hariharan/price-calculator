package com.lh.costanalysis;

import com.lh.costanalysis.dao.ExchangeRate;
import com.lh.costanalysis.dao.ExchangeRateRepo;
import com.lh.costanalysis.dao.Product;
import com.lh.costanalysis.dao.ProductJdbcRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class ProductApplication implements CommandLineRunner {

        private Logger logger = LoggerFactory.getLogger(this.getClass());
    
        @Autowired
        ProductJdbcRepository productRepository;
        @Autowired
        ExchangeRateRepo exchangeRateRepo;
    
        public static void main(String[] args) {
            SpringApplication.run(ProductApplication.class, args);
        }
    
        @Override
        public void run(String... args) throws Exception {
    
           // logger.info("Product id 10001 -> {}", productRepository.findById(1L));
          //  logger.info("Product id 10001 -> {}", productRepository.findById(1L));
            Product prod = productRepository.findById(1L);
            ExchangeRate rate = exchangeRateRepo.findById("EUR");
            logger.info("Final answer = " + prod.getItemCost() * rate.getCurrencyValue());
            
    
        }
}