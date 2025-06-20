package utez.edu.mx.fichas_utez_backend.Modules.CivilStatus.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utez.edu.mx.fichas_utez_backend.Modules.CivilStatus.Model.CivilStatus;
import utez.edu.mx.fichas_utez_backend.Modules.CivilStatus.Model.CivilStatusRepository;

import java.util.List;

@Service
public class CivilStatusService {
    private final CivilStatusRepository civilStatusRepository;

    @Autowired
    public CivilStatusService(CivilStatusRepository civilStatusRepository) {
        this.civilStatusRepository = civilStatusRepository;
    }

    public List<CivilStatus> getAllCivilStatus() {
        return civilStatusRepository.findAll();
    }
}

