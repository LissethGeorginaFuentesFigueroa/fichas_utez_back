package utez.edu.mx.fichas_utez_backend.Modules.Registration.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import utez.edu.mx.fichas_utez_backend.Modules.CivilStatus.Model.CivilStatus;
import utez.edu.mx.fichas_utez_backend.Modules.Country.Model.Country;
import utez.edu.mx.fichas_utez_backend.Modules.Disability.Model.Disability;
import utez.edu.mx.fichas_utez_backend.Modules.HighSchool.Model.HighSchool;
import utez.edu.mx.fichas_utez_backend.Modules.HighSchoolType.Model.HighSchoolType;
import utez.edu.mx.fichas_utez_backend.Modules.IndigenousLanguage.Model.IndigenousLanguage;
import utez.edu.mx.fichas_utez_backend.Modules.MediaChannel.Model.MediaChannel;
import utez.edu.mx.fichas_utez_backend.Modules.Municipality.Model.Municipality;
import utez.edu.mx.fichas_utez_backend.Modules.Nationality.Model.Nationality;
import utez.edu.mx.fichas_utez_backend.Modules.NativeLanguage.Model.NativeLanguage;
import utez.edu.mx.fichas_utez_backend.Modules.SchoolCareer.Model.SchoolCareer;
import utez.edu.mx.fichas_utez_backend.Modules.State.Model.State;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "user_registration_forms")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String motherLastName;

    @Column(nullable = false)
    private String curp;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(nullable = false)
    private String gender;

    @ManyToOne(optional = false)
    @JoinColumn(name = "nationality_id")
    private Nationality nationality;

    @ManyToOne(optional = false)
    @JoinColumn(name = "birth_state_id")
    private State birthState;

    @ManyToOne(optional = false)
    @JoinColumn(name = "birth_municipality_id")
    private Municipality birthMunicipality;

    @ManyToOne(optional = false)
    @JoinColumn(name = "birth_country_id")
    private Country birthCountry;

    @Column
    private String birthForeignState;

    @Column
    private String birthCity;

    @ManyToOne(optional = false)
    @JoinColumn(name = "civil_status_id")
    private CivilStatus civilStatus;

    @ManyToOne(optional = false)
    @JoinColumn(name = "native_language_id")
    private NativeLanguage nativeLanguage;

    @Column
    private Boolean hasChildren;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String exteriorNumber;

    @Column
    private String interiorNumber;

    @Column(nullable = false)
    private String neighborhood;

    @ManyToOne(optional = false)
    @JoinColumn(name = "address_state_id")
    private State addressState;

    @ManyToOne(optional = false)
    @JoinColumn(name = "address_municipality_id")
    private Municipality addressMunicipality;

    @Column
    private String addressLocality;

    @Column(nullable = false)
    private String postalCode;

    @Column(nullable = true)
    private String email;

    @Column(nullable = false)
    private String lada;

    @Column
    private String homePhone;

    @Column(nullable = false)
    private String mobilePhone;

    @Column
    private Double familyMonthlyIncome;

    @Column
    private Boolean works;

    @Column
    private String workType;

    @Column
    private String workLada;

    @Column
    private String workPhone;

    @Column
    private Double monthlyIncome;

    @Column
    private String companyName;

    @Column
    private String jobPosition;

    @ManyToOne(optional = false)
    @JoinColumn(name = "career_id")
    private SchoolCareer career;

    @ManyToOne(optional = false)
    @JoinColumn(name = "media_channel_id")
    private MediaChannel mediaChannel;

    @Column
    private String otherMediaChannel;

    @Column
    private String utezOption;

    @Column
    private String otherUtezOption;

    @ManyToOne(optional = false)
    @JoinColumn(name = "high_school_type_id")
    private HighSchoolType highSchoolType;

    @Column
    private String otherHighSchoolType;

    @Column(nullable = false)
    private String highSchoolName;

    @Column(nullable = false)
    private String highSchoolCct;

    @ManyToOne(optional = false)
    @JoinColumn(name = "high_school_state_id")
    private State highSchoolState;

    @ManyToOne(optional = false)
    @JoinColumn(name = "high_school_municipality_id")
    private Municipality highSchoolMunicipality;

    @Column(nullable = false)
    private Double average;

    @Column
    private Boolean hasScholarship;

    @Column
    private String scholarshipName;

    @ManyToMany
    @JoinTable(
        name = "user_registration_form_indigenous_languages",
        joinColumns = @JoinColumn(name = "user_registration_form_id"),
        inverseJoinColumns = @JoinColumn(name = "indigenous_language_id")
    )
    private List<IndigenousLanguage> indigenousLanguages;

    @ManyToMany
    @JoinTable(
        name = "user_registration_form_disabilities",
        joinColumns = @JoinColumn(name = "user_registration_form_id"),
        inverseJoinColumns = @JoinColumn(name = "disability_id")
    )
    private List<Disability> disabilities;

    @ManyToOne(optional = false)
    @JoinColumn(name = "high_school_id")
    private HighSchool highSchool;

    @ManyToOne(optional = false)
    @JoinColumn(name = "school_career_id")
    private SchoolCareer schoolCareer;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String address;

    @ManyToMany
    @JoinTable(
        name = "user_registration_form_parents_indigenous_languages",
        joinColumns = @JoinColumn(name = "user_registration_form_id"),
        inverseJoinColumns = @JoinColumn(name = "indigenous_language_id")
    )
    private List<IndigenousLanguage> parentsIndigenousLanguages;
}
