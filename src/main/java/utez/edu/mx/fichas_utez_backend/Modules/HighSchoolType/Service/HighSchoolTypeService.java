package utez.edu.mx.fichas_utez_backend.Modules.HighSchoolType.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utez.edu.mx.fichas_utez_backend.Modules.HighSchoolType.Model.HighSchoolTypeRepository;
import utez.edu.mx.fichas_utez_backend.Modules.HighSchoolType.Model.HighSchoolType;

import java.util.List;

@Service
public class HighSchoolTypeService {
    private final HighSchoolTypeRepository highSchoolTypeRepository;

    @Autowired
    public HighSchoolTypeService(HighSchoolTypeRepository highSchoolTypeRepository) {
        this.highSchoolTypeRepository = highSchoolTypeRepository;
    }

    public List<HighSchoolType> getAllHighSchoolTypes() {
        return highSchoolTypeRepository.findAll();
    }
}

