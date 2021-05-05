package io.rahul.inventory.controller;

import io.rahul.inventory.domain.Product;
import io.rahul.inventory.contracts.ProductDTO;
import io.rahul.inventory.application.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {


    @Autowired
    ProductService productService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDTO> getProducts(){
        List<Product> products = productService.getProducts();
        List<ProductDTO> productDTOS = products.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        System.out.println(productDTOS);
        return productDTOS;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ProductDTO> save(@Valid @RequestBody Product product){
        Product newProduct = productService.save(product);
        ProductDTO productDTO = this.convertToDto(newProduct);
        return new ResponseEntity<>(productDTO, HttpStatus.CREATED);
    }

    private ProductDTO convertToDto(Product product) {
        ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
        productDTO.setQuantity(product.getInventory().getQuantity());
        return productDTO;
    }


}
