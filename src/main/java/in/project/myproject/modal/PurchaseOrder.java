package in.project.myproject.modal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PurchaseOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotBlank
    @Column(unique = true)
    private String uid;

    @NotBlank(message = "Must not be blank")
    @Size(min = 3, max = 100)
    private String productName;

    @NotBlank(message = "Must not be blank")
    @Size(min = 3, max = 10)
    private String productId;

    @NotBlank
    private String unit;

    private int quantity;
    private double unitPrice;

}
