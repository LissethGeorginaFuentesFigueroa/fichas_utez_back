package utez.edu.mx.fichas_utez_backend.Modules.HighSchool.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utez.edu.mx.fichas_utez_backend.Modules.HighSchool.Model.HighSchoolRepository;
import utez.edu.mx.fichas_utez_backend.Modules.HighSchool.Model.HighSchool;

import java.util.List;

@Service
public class HighSchoolService {
    private final HighSchoolRepository highSchoolRepository;

    @Autowired
    public HighSchoolService(HighSchoolRepository highSchoolRepository) {
        this.highSchoolRepository = highSchoolRepository;
    }

    public List<HighSchool> getAllHighSchools() {
        return highSchoolRepository.findAll();
    }
}

