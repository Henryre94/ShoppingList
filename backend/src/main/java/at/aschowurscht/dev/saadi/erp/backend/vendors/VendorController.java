package at.aschowurscht.dev.saadi.erp.backend.vendors;

import at.aschowurscht.dev.saadi.erp.backend.products.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendors")
@CrossOrigin
@RequiredArgsConstructor
public class VendorController {
    final
    VendorService vendorService;

    @PostMapping()
    public void createVendor(@RequestBody Vendor vendor) {
        vendorService.createVendor(vendor);
    }

    @GetMapping("/{venId}")
    public Vendor getVendorById(@PathVariable int venId) {
        return vendorService.getVendorById(venId);
    }

    @GetMapping("/{venId}/products")
    public List<Product> getAllProductsFromVendor(@PathVariable int venId) {
        return vendorService.getAllProductsFromVendor(venId);
    }

    @GetMapping()
    public List<Vendor> getAllVendors() {
        return vendorService.getAllVendors();
    }

    @PutMapping()
    public void updateVendor(@RequestBody Vendor vendor) {
        vendorService.updateVendor(vendor);
    }

    @DeleteMapping("/{venId}")
    public void deleteVendor(@PathVariable int venId) {
        vendorService.deleteVendor(venId);
    }
}