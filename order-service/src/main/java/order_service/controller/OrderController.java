package order_service.controller;

import order_service.model.InventoryResponse;
import order_service.model.Order;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final RestClient restClient;
    private final String inventoryServiceUrl;
    private final AtomicLong orderCounter = new AtomicLong(1000);

    public OrderController(
            RestClient restClient,
            @Value("${inventory.service.url}") String inventoryServiceUrl) {

        this.restClient = restClient;
        this.inventoryServiceUrl = inventoryServiceUrl;
    }

    @GetMapping("/health")
    public String health() {
        return "{\"service\":\"order-service\",\"status\":\"UP\"}";
    }

    @PostMapping
    public Order createOrder(
            @RequestParam Long productId,
            @RequestParam int quantity) {

        InventoryResponse inventory = restClient.get()
                .uri(inventoryServiceUrl + "/inventory/" + productId)
                .retrieve()
                .body(InventoryResponse.class);

        Long orderId = orderCounter.incrementAndGet();

        if (inventory != null
                && inventory.isAvailable()
                && inventory.getAvailableQuantity() >= quantity) {

            return new Order(
                    orderId,
                    productId,
                    quantity,
                    "CONFIRMED"
            );
        }

        return new Order(
                orderId,
                productId,
                quantity,
                "REJECTED"
        );
    }
}