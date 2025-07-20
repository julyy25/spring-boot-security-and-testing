package in.project.myproject.controller;

import in.project.myproject.modal.FirstModal;
import in.project.myproject.service.FirstService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/first")
@RequiredArgsConstructor
public class FirstController {
    private final FirstService firstService;

    @PostMapping("/create")
    public boolean create(@RequestBody @Valid FirstModal firstModal) {
        firstService.create(firstModal);
        return true;
    }

}
