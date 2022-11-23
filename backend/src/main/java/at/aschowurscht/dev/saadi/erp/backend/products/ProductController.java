package at.aschowurscht.dev.saadi.erp.backend.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    ProductService productService;
    @CrossOrigin
    @PostMapping("/{venId}")
    public void post(@RequestBody Product product, @PathVariable int venId){
        productService.post(product,venId);
    }
    @CrossOrigin
    @PostMapping("/{proId}/pubs/{pubId}")
    public void post(@PathVariable int proId, @PathVariable int pubId){
        productService.post(proId,pubId);
    }
    @CrossOrigin
    @GetMapping("/{proId}")
    public Product getById(@PathVariable int proId){
        return productService.getById(proId);
    }

    @CrossOrigin
    @GetMapping()
    public List<Product> get(){
        List<Product> productList = productService.get();

        return productList;
    }
    @CrossOrigin
    @PutMapping()
    public void put(@RequestBody Product product){
        productService.put(product);
    }
    @CrossOrigin
    @DeleteMapping("/{proId}")
    public void delete(@PathVariable int proId) {productService.delete(proId);}

}
