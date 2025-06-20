package utez.edu.mx.fichas_utez_backend.Modules.State.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import utez.edu.mx.fichas_utez_backend.Modules.State.Model.StateRepository;
import utez.edu.mx.fichas_utez_backend.Modules.State.Model.State;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StateService {
    private final StateRepository repository;

    public List<State> findAll() {
        return repository.findAll();
    }

    public List<State> findByCountryId(Long countryId) {
        return repository.findByCountry_Id(countryId);
    }
}
