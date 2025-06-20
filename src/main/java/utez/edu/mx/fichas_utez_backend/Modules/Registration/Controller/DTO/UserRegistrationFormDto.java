package utez.edu.mx.fichas_utez_backend.Modules.Registration.Controller.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationFormDto {
    private String firstName;
    private String lastName;
    private String motherLastName;
    private String curp;
    private LocalDate birthDate;
    private String gender;
    private Long nationalityId;
    private Long birthStateId;
    private Long birthMunicipalityId;
    private Long birthCountryId;
    private String birthForeignState;
    private String birthCity;
    private Long civilStatusId;
    private Long nativeLanguageId;
    private Boolean hasChildren;
    private String street;
    private String exteriorNumber;
    private String interiorNumber;
    private String neighborhood;
    private Long addressStateId;
    private Long addressMunicipalityId;
    private String addressLocality;
    private String postalCode;
    private String email;
    private String lada;
    private String homePhone;
    private String mobilePhone;
    private Double familyMonthlyIncome;
    private Boolean works;
    private String workType;
    private String workLada;
    private String workPhone;
    private Double monthlyIncome;
    private String companyName;
    private String jobPosition;
    private Long careerId;
    private Long mediaChannelId;
    private String otherMediaChannel;
    private String utezOption;
    private String otherUtezOption;
    private Long highSchoolTypeId;
    private String otherHighSchoolType;
    private String highSchoolName;
    private String highSchoolCct;
    private Long highSchoolStateId;
    private Long highSchoolMunicipalityId;
    private Double average;
    private Boolean hasScholarship;
    private String scholarshipName;
    private List<Long> indigenousLanguageIds;
    private List<Long> disabilityIds;
    private Long highSchoolId;
    private Long schoolCareerId;
    private String phone;
    private String address;
    private List<Long> parentsIndigenousLanguageIds;
}