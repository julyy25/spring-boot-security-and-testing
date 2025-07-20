package in.project.myproject.repository;

import in.project.myproject.modal.FirstModal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FirstRepository extends JpaRepository<FirstModal, Long> {
}
