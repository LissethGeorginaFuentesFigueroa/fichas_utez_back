package utez.edu.mx.fichas_utez_backend.Modules.Disability.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import utez.edu.mx.fichas_utez_backend.Modules.Disability.Model.DisabilityRepository;
import utez.edu.mx.fichas_utez_backend.Modules.Disability.Model.Disability;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DisabilityService {

    private final DisabilityRepository repository;



    public List<Disability> findAll() {
        return repository.findAll();
    }

}

