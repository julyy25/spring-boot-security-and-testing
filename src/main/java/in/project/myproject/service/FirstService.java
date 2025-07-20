package in.project.myproject.service;

import in.project.myproject.modal.FirstModal;
import in.project.myproject.repository.FirstRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class FirstService {
    private final FirstRepository firstRepository;

    public boolean create(FirstModal firstModal) {
        log.info("{}", firstModal);
        firstRepository.save(firstModal);
        return true;
    }
}
