package utez.edu.mx.fichas_utez_backend.Modules.Registration.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.fichas_utez_backend.Modules.CivilStatus.Model.CivilStatus;
import utez.edu.mx.fichas_utez_backend.Modules.CivilStatus.Model.CivilStatusRepository;
import utez.edu.mx.fichas_utez_backend.Modules.Country.Model.Country;
import utez.edu.mx.fichas_utez_backend.Modules.Country.Model.CountryRepository;
import utez.edu.mx.fichas_utez_backend.Modules.Disability.Model.Disability;
import utez.edu.mx.fichas_utez_backend.Modules.Disability.Model.DisabilityRepository;
import utez.edu.mx.fichas_utez_backend.Modules.HighSchool.Model.HighSchool;
import utez.edu.mx.fichas_utez_backend.Modules.HighSchool.Model.HighSchoolRepository;
import utez.edu.mx.fichas_utez_backend.Modules.HighSchoolType.Model.HighSchoolType;
import utez.edu.mx.fichas_utez_backend.Modules.HighSchoolType.Model.HighSchoolTypeRepository;
import utez.edu.mx.fichas_utez_backend.Modules.IndigenousLanguage.Model.IndigenousLanguage;
import utez.edu.mx.fichas_utez_backend.Modules.IndigenousLanguage.Model.IndigenousLanguageRepository;
import utez.edu.mx.fichas_utez_backend.Modules.MediaChannel.Model.MediaChannel;
import utez.edu.mx.fichas_utez_backend.Modules.MediaChannel.Model.MediaChannelRepository;
import utez.edu.mx.fichas_utez_backend.Modules.Municipality.Model.Municipality;
import utez.edu.mx.fichas_utez_backend.Modules.Municipality.Model.MunicipalityRepository;
import utez.edu.mx.fichas_utez_backend.Modules.Nationality.Model.Nationality;
import utez.edu.mx.fichas_utez_backend.Modules.Nationality.Model.NationalityRepository;
import utez.edu.mx.fichas_utez_backend.Modules.NativeLanguage.Model.NativeLanguage;
import utez.edu.mx.fichas_utez_backend.Modules.NativeLanguage.Model.NativeLanguageRepository;
import utez.edu.mx.fichas_utez_backend.Modules.Registration.Controller.dto.UserRegistrationFormRequest;
import utez.edu.mx.fichas_utez_backend.Modules.Registration.Model.UserRegistrationForm;
import utez.edu.mx.fichas_utez_backend.Modules.Registration.Model.UserRegistrationFormRepository;
import utez.edu.mx.fichas_utez_backend.Modules.SchoolCareer.Model.SchoolCareer;
import utez.edu.mx.fichas_utez_backend.Modules.SchoolCareer.Model.SchoolCareerRepository;
import utez.edu.mx.fichas_utez_backend.Modules.State.Model.State;
import utez.edu.mx.fichas_utez_backend.Modules.State.Model.StateRepository;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserRegistrationFormService {

    private final UserRegistrationFormRepository repositorySchoolCard;
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
    public Boolean create(UserRegistrationFormRequest userRegisterDto) {
        log.info("ini.UserRegistrationFormService.create -> Creando ficha de registro");
        UserRegistrationForm userRegistrationForm = new UserRegistrationForm();

        /*Personal Data*/
        log.info("process.UserRegistrationFormService.create -> Procesando datos personales {}", userRegisterDto.personalData());
        userRegistrationForm.setFullname(userRegisterDto.personalData().name());
        userRegistrationForm.setFirstSurname(userRegisterDto.personalData().firstSurname());
        userRegistrationForm.setSecondSurname(userRegisterDto.personalData().secondSurname());
        userRegistrationForm.setCurp(userRegisterDto.personalData().curp());
        userRegistrationForm.setBirthDate(userRegisterDto.personalData().birthDate());
        userRegistrationForm.setGender(userRegisterDto.personalData().gender());

        Nationality userNationality = nationalityRepository.findById(userRegisterDto.personalData().nationalityId())
                .orElseThrow(() -> new IllegalArgumentException("Nacionalidad no encontrada"));
        userRegistrationForm.setNationality(userNationality);

        Country userCountry = countryRepository.findById(userRegisterDto.personalData().countryId())
                .orElseThrow(() -> new IllegalArgumentException("País no encontrado"));
        userRegistrationForm.setBirthCountry(userCountry);

        State userBirthState = stateRepository.findById(userRegisterDto.personalData().birthStateId())
                .orElseThrow(() -> new IllegalArgumentException("Estado de nacimiento no encontrado"));
        userRegistrationForm.setBirthState(userBirthState);

        userRegistrationForm.setBirthCity(userRegisterDto.personalData().birthCity());

        CivilStatus userCivilStatus = civilStatusRepository.findById(userRegisterDto.personalData().maritalStatusId())
                .orElseThrow(() -> new IllegalArgumentException("Estado civil no encontrado"));
        userRegistrationForm.setCivilStatus(userCivilStatus);

        NativeLanguage userNativeLanguage = nativeLanguageRepository.findById(userRegisterDto.personalData().nativeLanguageId())
                .orElseThrow(() -> new IllegalArgumentException("Lengua nativa no encontrada"));
        userRegistrationForm.setNativeLanguage(userNativeLanguage);
        userRegistrationForm.setHasChildren(userRegisterDto.personalData().hasChildren());
        userRegistrationForm.setEmail(userRegisterDto.personalData().email());


        /*Address*/
        log.info("process.UserRegistrationFormService.create -> Procesando domicilio {}", userRegisterDto.address());
        userRegistrationForm.setStreet(userRegisterDto.address().street());
        userRegistrationForm.setExteriorNumber(userRegisterDto.address().exteriorNumber());
        userRegistrationForm.setInteriorNumber(userRegisterDto.address().interiorNumber());
        userRegistrationForm.setNeighborhood(userRegisterDto.address().neighborhood());
        userRegistrationForm.setAddressLocality(userRegisterDto.address().locality());
        State addressState = stateRepository.findById(userRegisterDto.address().stateId())
                .orElseThrow(() -> new IllegalArgumentException("Estado de domicilio no encontrado"));
        userRegistrationForm.setAddressState(addressState);
        Municipality addressMunicipality = municipalityRepository.findById(userRegisterDto.address().municipalityId())
                .orElseThrow(() -> new IllegalArgumentException("Municipio de domicilio no encontrado"));
        userRegistrationForm.setAddressMunicipality(addressMunicipality);
        userRegistrationForm.setPostalCode(userRegisterDto.address().postalCode());

        /* Complementary Info */
        log.info("process.UserRegistrationFormService.create -> Procesando información complementaria {}", userRegisterDto.complementaryInfo());
        if (userRegisterDto.complementaryInfo().disabilityIds() != null) {
            List<Disability> disabilities = disabilityRepository.findAllById(userRegisterDto.complementaryInfo().disabilityIds());
            userRegistrationForm.setDisabilities(disabilities);
        }
        if (userRegisterDto.complementaryInfo().indigenousLanguageIds() != null) {
            List<IndigenousLanguage> indigenousLanguages = indigenousLanguageRepository.findAllById(userRegisterDto.complementaryInfo().indigenousLanguageIds());
            userRegistrationForm.setIndigenousLanguages(indigenousLanguages);
        }
        if (userRegisterDto.complementaryInfo().parentsIndigenousLanguageIds() != null) {
            List<IndigenousLanguage> parentsIndigenousLanguages = indigenousLanguageRepository.findAllById(userRegisterDto.complementaryInfo().parentsIndigenousLanguageIds());
            userRegistrationForm.setParentsIndigenousLanguages(parentsIndigenousLanguages);
        }

        /* Employment Info */
        log.info("process.UserRegistrationFormService.create -> Procesando información laboral {}", userRegisterDto.workIncomeInfo());
        userRegistrationForm.setFamilyMonthlyIncome(userRegisterDto.workIncomeInfo().familyMonthlyIncome() );
        userRegistrationForm.setWorks(userRegisterDto.workIncomeInfo().isCurrentlyEmployed());
        userRegistrationForm.setWorkType(userRegisterDto.workIncomeInfo().employmentType());
        userRegistrationForm.setWorkLada(userRegisterDto.workIncomeInfo().companyLada());
        userRegistrationForm.setWorkPhone(userRegisterDto.workIncomeInfo().companyPhoneNumber());
        userRegistrationForm.setMonthlyIncome(userRegisterDto.workIncomeInfo().monthlyIncome());
        userRegistrationForm.setCompanyName(userRegisterDto.workIncomeInfo().companyName());
        userRegistrationForm.setJobPosition(userRegisterDto.workIncomeInfo().jobPosition());
        userRegistrationForm.setWorkSchedule(userRegisterDto.workIncomeInfo().workSchedule());


        /* CARRERA */
        log.info("process.UserRegistrationFormService.create -> Procesando información de carrera {}", userRegisterDto.academicCareer());
        SchoolCareer schoolCareer = schoolCareerRepository.findById(userRegisterDto.academicCareer().careerId())
                .orElseThrow(() -> new IllegalArgumentException("Carrera académica no encontrada"));
        userRegistrationForm.setCareer(schoolCareer);

        if (userRegisterDto.academicCareer().mediaChannelId() != null ) {
            MediaChannel mediaChannel = mediaChannelRepository.findById(userRegisterDto.academicCareer().mediaChannelId())
                    .orElseThrow(() -> new IllegalArgumentException("Medio de enterado no encontrado"));
            userRegistrationForm.setMediaChannel(mediaChannel);
        }else{
            userRegistrationForm.setOtherMediaChannel(userRegisterDto.academicCareer().otherMediaChannel());
        }

        userRegistrationForm.setUtezFirstOption(userRegisterDto.academicCareer().isFirstOption());

        /* ACADEMIC BACKGROUND */
        log.info("process.UserRegistrationFormService.create -> Procesando información de bachillerato {}", userRegisterDto.highSchoolBackground());
        HighSchoolType highSchoolType = highSchoolTypeRepository.findById(userRegisterDto.highSchoolBackground().highSchoolTypeId())
                .orElseThrow(() -> new IllegalArgumentException("Tipo de bachillerato no encontrado"));
        userRegistrationForm.setHighSchoolType(highSchoolType);

        userRegistrationForm.setHighSchoolName(userRegisterDto.highSchoolBackground().highSchoolName());
        userRegistrationForm.setHighSchoolCct(userRegisterDto.highSchoolBackground().cct());
        State highSchoolState = stateRepository.findById(userRegisterDto.highSchoolBackground().stateId())
                .orElseThrow(() -> new IllegalArgumentException("Estado de bachillerato no encontrado"));
        userRegistrationForm.setHighSchoolState(highSchoolState);
        Municipality highSchoolMunicipality = municipalityRepository.findById(userRegisterDto.highSchoolBackground().municipalityId())
                .orElseThrow(() -> new IllegalArgumentException("Municipio de bachillerato no encontrado"));
        userRegistrationForm.setHighSchoolMunicipality(highSchoolMunicipality);
        userRegistrationForm.setAverage(userRegisterDto.highSchoolBackground().average());

        if (userRegisterDto.highSchoolBackground().hasScholarship()) {
            userRegistrationForm.setHasScholarship(true);
            userRegistrationForm.setScholarshipName(userRegisterDto.highSchoolBackground().scholarshipName());
        }

        UserRegistrationForm saved = repositorySchoolCard.save(userRegistrationForm);
        log.info("fin.UserRegistrationFormService.create -> Ficha de registro creada con ID: {}", saved);
        return saved.getId() != null;
    }
}
