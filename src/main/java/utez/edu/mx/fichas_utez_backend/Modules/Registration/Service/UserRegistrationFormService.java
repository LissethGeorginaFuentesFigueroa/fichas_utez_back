package utez.edu.mx.fichas_utez_backend.Modules.Registration.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import utez.edu.mx.fichas_utez_backend.Modules.Registration.Controller.DTO.UserRegistrationFormDto;
import utez.edu.mx.fichas_utez_backend.Modules.Registration.Model.UserRegistrationForm;
import utez.edu.mx.fichas_utez_backend.Modules.Registration.Model.UserRegistrationFormRepository;
import utez.edu.mx.fichas_utez_backend.Modules.SchoolCareer.Model.SchoolCareerRepository;
import utez.edu.mx.fichas_utez_backend.Modules.State.Model.StateRepository;
import utez.edu.mx.fichas_utez_backend.kernel.ErrorMessages;
import utez.edu.mx.fichas_utez_backend.kernel.ResponseApi;

import java.util.List;

@Service
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

    @Autowired
    public UserRegistrationFormService(UserRegistrationFormRepository repository,
                                       MunicipalityRepository municipalityRepository,
                                       StateRepository stateRepository,
                                       NationalityRepository nationalityRepository,
                                       CountryRepository countryRepository,
                                       CivilStatusRepository civilStatusRepository,
                                       NativeLanguageRepository nativeLanguageRepository,
                                       SchoolCareerRepository schoolCareerRepository,
                                       MediaChannelRepository mediaChannelRepository,
                                       HighSchoolTypeRepository highSchoolTypeRepository,
                                       HighSchoolRepository highSchoolRepository,
                                       IndigenousLanguageRepository indigenousLanguageRepository,
                                       DisabilityRepository disabilityRepository) {
        this.repository = repository;
        this.municipalityRepository = municipalityRepository;
        this.stateRepository = stateRepository;
        this.nationalityRepository = nationalityRepository;
        this.countryRepository = countryRepository;
        this.civilStatusRepository = civilStatusRepository;
        this.nativeLanguageRepository = nativeLanguageRepository;
        this.schoolCareerRepository = schoolCareerRepository;
        this.mediaChannelRepository = mediaChannelRepository;
        this.highSchoolTypeRepository = highSchoolTypeRepository;
        this.highSchoolRepository = highSchoolRepository;
        this.indigenousLanguageRepository = indigenousLanguageRepository;
        this.disabilityRepository = disabilityRepository;
    }

    @Transactional
    public ResponseApi<?> create(UserRegistrationFormDto form) {
        System.out.println(form);
        try {
            UserRegistrationForm registrationForm = new UserRegistrationForm();
            if(form.getFirstName()==null) return new ResponseApi<>(null, HttpStatus.BAD_REQUEST.value(), ErrorMessages.MISSING_NAME.toString());
            if(form.getLastName()==null) return new ResponseApi<>(null, HttpStatus.BAD_REQUEST.value(), ErrorMessages.MISSING_FIRST_LASTNAME.toString());


            if (!nationalityRepository.existsById(form.getNationalityId())) {
                return new ResponseApi<>(null, HttpStatus.BAD_REQUEST.value(), ErrorMessages.INVALID_NATIONALITY.toString() + " " + form.getNationalityId() );
            }
            if (!stateRepository.existsById(form.getBirthStateId())) {
                return new ResponseApi<>(null, HttpStatus.BAD_REQUEST.value(), ErrorMessages.INVALID_STATE.toString() + " " + form.getBirthStateId() );
            }

            registrationForm.setNationality(
                    nationalityRepository.findById(form.getNationalityId()).orElseThrow()
            );
            registrationForm.setBirthState(
                    stateRepository.findById(form.getBirthStateId()).orElseThrow()
            );
            registrationForm.setBirthMunicipality(
                    municipalityRepository.findById(form.getBirthMunicipalityId()).orElseThrow()
            );
            registrationForm.setBirthCountry(
                    countryRepository.findById(form.getBirthCountryId()).orElseThrow()
            );
            registrationForm.setCivilStatus(
                    civilStatusRepository.findById(form.getCivilStatusId()).orElseThrow()
            );
            registrationForm.setNativeLanguage(
                    nativeLanguageRepository.findById(form.getNativeLanguageId()).orElseThrow()
            );
            registrationForm.setAddressState(
                    stateRepository.findById(form.getAddressStateId()).orElseThrow()
            );
            registrationForm.setAddressMunicipality(
                    municipalityRepository.findById(form.getAddressMunicipalityId()).orElseThrow()
            );
            registrationForm.setCareer(
                    schoolCareerRepository.findById(form.getCareerId()).orElseThrow()
            );
            registrationForm.setMediaChannel(
                    mediaChannelRepository.findById(form.getMediaChannelId()).orElseThrow()
            );
            registrationForm.setHighSchoolType(
                    highSchoolTypeRepository.findById(form.getHighSchoolTypeId()).orElseThrow()
            );
            registrationForm.setHighSchoolState(
                    stateRepository.findById(form.getHighSchoolStateId()).orElseThrow()
            );
            registrationForm.setHighSchoolMunicipality(
                    municipalityRepository.findById(form.getHighSchoolMunicipalityId()).orElseThrow()
            );
            registrationForm.setHighSchool(
                    highSchoolRepository.findById(form.getHighSchoolId()).orElseThrow()
            );
            registrationForm.setSchoolCareer(
                    schoolCareerRepository.findById(form.getSchoolCareerId()).orElseThrow()
            );

            // --- Listas ManyToMany ---
            if (form.getIndigenousLanguageIds() != null)
                registrationForm.setIndigenousLanguages(
                        indigenousLanguageRepository.findAllById(form.getIndigenousLanguageIds())
                );

            if (form.getDisabilityIds() != null)
                registrationForm.setDisabilities(
                        disabilityRepository.findAllById(form.getDisabilityIds())
                );

            if (form.getParentsIndigenousLanguageIds() != null)
                registrationForm.setParentsIndigenousLanguages(
                        indigenousLanguageRepository.findAllById(form.getParentsIndigenousLanguageIds())
                );

            // --- Valores simples ---
            registrationForm.setFirstName(form.getFirstName());
            registrationForm.setLastName(form.getLastName());
            registrationForm.setMotherLastName(form.getMotherLastName());
            registrationForm.setCurp(form.getCurp());
            registrationForm.setBirthDate(form.getBirthDate());
            registrationForm.setGender(form.getGender());
            registrationForm.setBirthForeignState(form.getBirthForeignState());
            registrationForm.setBirthCity(form.getBirthCity());
            registrationForm.setHasChildren(form.getHasChildren());
            registrationForm.setStreet(form.getStreet());
            registrationForm.setExteriorNumber(form.getExteriorNumber());
            registrationForm.setInteriorNumber(form.getInteriorNumber());
            registrationForm.setNeighborhood(form.getNeighborhood());
            registrationForm.setAddressLocality(form.getAddressLocality());
            registrationForm.setPostalCode(form.getPostalCode());
            registrationForm.setEmail(form.getEmail());
            registrationForm.setLada(form.getLada());
            registrationForm.setHomePhone(form.getHomePhone());
            registrationForm.setMobilePhone(form.getMobilePhone());
            registrationForm.setFamilyMonthlyIncome(form.getFamilyMonthlyIncome());
            registrationForm.setWorks(form.getWorks());
            registrationForm.setWorkType(form.getWorkType());
            registrationForm.setWorkLada(form.getWorkLada());
            registrationForm.setWorkPhone(form.getWorkPhone());
            registrationForm.setMonthlyIncome(form.getMonthlyIncome());
            registrationForm.setCompanyName(form.getCompanyName());
            registrationForm.setJobPosition(form.getJobPosition());
            registrationForm.setOtherMediaChannel(form.getOtherMediaChannel());
            registrationForm.setUtezOption(form.getUtezOption());
            registrationForm.setOtherUtezOption(form.getOtherUtezOption());
            registrationForm.setOtherHighSchoolType(form.getOtherHighSchoolType());
            registrationForm.setHighSchoolName(form.getHighSchoolName());
            registrationForm.setHighSchoolCct(form.getHighSchoolCct());
            registrationForm.setAverage(form.getAverage());
            registrationForm.setHasScholarship(form.getHasScholarship());
            registrationForm.setScholarshipName(form.getScholarshipName());
            registrationForm.setPhone(form.getPhone());
            registrationForm.setAddress(form.getAddress());
            UserRegistrationForm newRegistrationForm = repository.save(registrationForm);
            return new ResponseApi<>( newRegistrationForm, HttpStatus.CREATED.value(), "Registro creado exitosamente");
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseApi<>(null, HttpStatus.BAD_REQUEST.value(), "Error al crear registro: " + e.getMessage());
        }

    }
}
