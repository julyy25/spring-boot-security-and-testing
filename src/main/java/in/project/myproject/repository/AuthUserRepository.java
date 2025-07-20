package in.project.myproject.repository;

import in.project.myproject.modal.AuthUserModal;
import in.project.myproject.modal.FirstModal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AuthUserRepository extends JpaRepository<AuthUserModal, String> {
    @Query(value = "SELECT * FROM authuser WHERE username=:username and password=:password", nativeQuery = true)
    AuthUserModal findByUsernameAndPassword(String username, String password);

    @Query(value = "SELECT * FROM authuser WHERE username=:username", nativeQuery = true)
    AuthUserModal findByUsername(String username);
}
