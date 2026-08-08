package inventory_service.controller;

import inventory_service.model.Inventory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @GetMapping("/health")
    public String health() {
        return "{\"service\":\"inventory-service\",\"status\":\"UP\"}";
    }

    @GetMapping("/{productId}")
    public Inventory getInventory(@PathVariable Long productId) {

        if (productId == 1001) {
            return new Inventory(
                    1001L,
                    "Laptop",
                    50,
                    true
            );
        }

        if (productId == 1002) {
            return new Inventory(
                    1002L,
                    "Keyboard",
                    100,
                    true
            );
        }

        return new Inventory(
                productId,
                "Unknown Product",
                0,
                false
        );
    }
}