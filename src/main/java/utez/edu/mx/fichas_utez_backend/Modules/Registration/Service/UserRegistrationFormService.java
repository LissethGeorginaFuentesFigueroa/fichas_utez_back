package utez.edu.mx.fichas_utez_backend.Modules.Registration.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.fichas_utez_backend.Modules.CivilStatus.Model.CivilStatusRepository;
import utez.edu.mx.fichas_utez_backend.Modules.Country.Model.CountryRepository;
import utez.edu.mx.fichas_utez_backend.Modules.Disability.Model.DisabilityRepository;
import utez.edu.mx.fichas_utez_backend.Modules.HighSchool.Model.HighSchoolRepository;
import utez.edu.mx.fichas_utez_backend.Modules.HighSchoolType.Model.HighSchoolTypeRepository;
import utez.edu.mx.fichas_utez_backend.Modules.IndigenousLanguage.Model.IndigenousLanguageRepository;
import utez.edu.mx.fichas_utez_backend.Modules.MediaChannel.Model.MediaChannelRepository;
import utez.edu.mx.fichas_utez_backend.Modules.Municipality.Model.MunicipalityRepository;
import utez.edu.mx.fichas_utez_backend.Modules.Nationality.Model.NationalityRepository;
import utez.edu.mx.fichas_utez_backend.Modules.NativeLanguage.Model.NativeLanguageRepository;
import utez.edu.mx.fichas_utez_backend.Modules.Registration.Controller.dto.UserRegistrationFormRequest;
import utez.edu.mx.fichas_utez_backend.Modules.Registration.Model.UserRegistrationFormRepository;
import utez.edu.mx.fichas_utez_backend.Modules.SchoolCareer.Model.SchoolCareerRepository;
import utez.edu.mx.fichas_utez_backend.Modules.State.Model.StateRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserRegistrationFormService {

    private final UserRegistrationFormRepository repository;
    private final MunicipalityRepository municipalityRepository;
    private final StateRepository stateRepository;
    private final NationalityRepository nationalityRepository;
    private final CountryRepository countryRepository;
    private final CivilStatusRepository civilStatusRepository;
    private final NativeLanguageRepository nativeLanguageRepository;
    private final SchoolCareerRepository schoolCareerRepository;
    private final MediaChannelRepository mediaChannelRepository;
    private final HighSchoolTypeRepository highSchoolTypeRepository;
    private final HighSchoolRepository highSchoolRepository;
    private final IndigenousLanguageRepository indigenousLanguageRepository;
    private final DisabilityRepository disabilityRepository;


    @Transactional
    public Boolean create(UserRegistrationFormRequest form) {
            log.info("ini.UserRegistrationFormService.create -> Validando datos de la ficha de registro {}", form);
            return true;
    }
}
