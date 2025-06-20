package utez.edu.mx.fichas_utez_backend.Modules.Nationality.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import utez.edu.mx.fichas_utez_backend.Modules.Nationality.Model.NationalityRepository;
import utez.edu.mx.fichas_utez_backend.Modules.Nationality.Model.Nationality;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NationalityService {

    private final NationalityRepository repository;

    public List<Nationality> findAll() {
        return repository.findAll();
    }

}

