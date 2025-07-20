package in.project.myproject.service;

import in.project.myproject.modal.PurchaseOrder;
import in.project.myproject.repository.PurchaseOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PurchaseOrderService {
    private final PurchaseOrderRepository purchaseOrderRepository;

    public List<PurchaseOrder> getAllPurchaseOrders() {
        return purchaseOrderRepository.findAll();
    }


    public String createPurchaseOrderV1() {
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.setProductId("R001");
        purchaseOrder.setProductName("Rice");
        purchaseOrder.setQuantity(1);
        purchaseOrder.setUnitPrice(100.0);
        purchaseOrder.setUid(UUID.randomUUID().toString());

        purchaseOrderRepository.save(purchaseOrder);
        return "OK";
    }


    public String createPurchaseOrderV2() {
        // method chaining. :: declartive pattern :: builder pattern
        PurchaseOrder purchaseOrder = PurchaseOrder.builder()
                .productName("ATTA")
                .productId("A001")
                .unit("KG")
                .quantity(5)
                .unitPrice(100)
                .uid(UUID.randomUUID().toString())
                .build();

        purchaseOrderRepository.save(purchaseOrder);
        return "OK";
    }


    public String createPurchaseOrderV3(PurchaseOrder purchaseOrder) {
        purchaseOrderRepository.save(purchaseOrder);
        return "OK";
    }

}
