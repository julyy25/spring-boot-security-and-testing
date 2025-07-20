package in.project.myproject.modal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "authuser")
public class AuthUserModal {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uid;

    @NotBlank
    @Column(unique = true)
    private String username;

    @NotBlank
    private String password;
}
