package utez.edu.mx.fichas_utez_backend.Modules.Country.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import utez.edu.mx.fichas_utez_backend.Modules.Country.Model.CountryRepository;
import utez.edu.mx.fichas_utez_backend.Modules.Country.Model.Country;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService {
    private final CountryRepository repository;

    public List<Country> findAll() {
        return repository.findAll();
    }
}

