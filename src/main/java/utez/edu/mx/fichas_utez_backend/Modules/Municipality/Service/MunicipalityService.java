package utez.edu.mx.fichas_utez_backend.Modules.Municipality.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import utez.edu.mx.fichas_utez_backend.Modules.Municipality.Model.MunicipalityRepository;
import utez.edu.mx.fichas_utez_backend.Modules.Municipality.Model.Municipality;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MunicipalityService {
    private final MunicipalityRepository repository;

    public List<Municipality> findAll() {
        return repository.findAll();
    }

    public List<Municipality> findByStateId(Long stateId) {
        return repository.findByState_Id(stateId);
    }
}

