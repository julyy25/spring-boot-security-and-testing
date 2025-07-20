package in.project.myproject.controller;

import in.project.myproject.modal.PurchaseOrder;
import in.project.myproject.service.PurchaseOrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/purchase")
public class PurchaseOrderController {
    private final PurchaseOrderService purchaseOrderService;


    @GetMapping("/all")
    public List<PurchaseOrder> getAllPurchaseOrders() {
        return purchaseOrderService.getAllPurchaseOrders();
    }

    @GetMapping("/create-v1")
    public String createPurchaseOrderV1() {
        return purchaseOrderService.createPurchaseOrderV1();
    }


    // We should use POST while creating records
    @PostMapping("/create-v2")
    public String createPurchaseOrderV2() {
        return purchaseOrderService.createPurchaseOrderV2();
    }

    @PostMapping("/create-v3")
    public ResponseEntity<?> createPurchaseOrderV3(@RequestBody @Valid PurchaseOrder purchaseOrder) {
        String purchaseOrderV3 = purchaseOrderService.createPurchaseOrderV3(purchaseOrder);
        return ResponseEntity.ok(purchaseOrderV3);
    }

}
