package utez.edu.mx.fichas_utez_backend.Modules.SchoolCareer.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utez.edu.mx.fichas_utez_backend.Modules.SchoolCareer.Model.SchoolCareerRepository;
import utez.edu.mx.fichas_utez_backend.Modules.SchoolCareer.Model.SchoolCareer;

import java.util.List;

@Service
public class SchoolCareerService {
    private final SchoolCareerRepository schoolCareerRepository;

    @Autowired
    public SchoolCareerService(SchoolCareerRepository schoolCareerRepository) {
        this.schoolCareerRepository = schoolCareerRepository;
    }

    public List<SchoolCareer> getAllSchoolCareers() {
        return schoolCareerRepository.findAll();
    }
}

