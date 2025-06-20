package utez.edu.mx.fichas_utez_backend.config;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import utez.edu.mx.fichas_utez_backend.Modules.Country.Model.Country;
import utez.edu.mx.fichas_utez_backend.Modules.CivilStatus.Model.CivilStatus;
import utez.edu.mx.fichas_utez_backend.Modules.Disability.Model.Disability;
import utez.edu.mx.fichas_utez_backend.Modules.HighSchool.Model.HighSchool;
import utez.edu.mx.fichas_utez_backend.Modules.IndigenousLanguage.Model.IndigenousLanguage;
import utez.edu.mx.fichas_utez_backend.Modules.Municipality.Model.Municipality;
import utez.edu.mx.fichas_utez_backend.Modules.Nationality.Model.Nationality;
import utez.edu.mx.fichas_utez_backend.Modules.NativeLanguage.Model.NativeLanguage;
import utez.edu.mx.fichas_utez_backend.Modules.State.Model.State;
import utez.edu.mx.fichas_utez_backend.Modules.SchoolCareer.Model.SchoolCareer;
import utez.edu.mx.fichas_utez_backend.Modules.MediaChannel.Model.MediaChannel;
import utez.edu.mx.fichas_utez_backend.Modules.HighSchoolType.Model.HighSchoolType;
import utez.edu.mx.fichas_utez_backend.Modules.Country.Model.CountryRepository;
import utez.edu.mx.fichas_utez_backend.Modules.CivilStatus.Model.CivilStatusRepository;
import utez.edu.mx.fichas_utez_backend.Modules.Disability.Model.DisabilityRepository;
import utez.edu.mx.fichas_utez_backend.Modules.IndigenousLanguage.Model.IndigenousLanguageRepository;
import utez.edu.mx.fichas_utez_backend.Modules.Municipality.Model.MunicipalityRepository;
import utez.edu.mx.fichas_utez_backend.Modules.Nationality.Model.NationalityRepository;
import utez.edu.mx.fichas_utez_backend.Modules.NativeLanguage.Model.NativeLanguageRepository;
import utez.edu.mx.fichas_utez_backend.Modules.SchoolCareer.Model.SchoolCareerRepository;
import utez.edu.mx.fichas_utez_backend.Modules.State.Model.StateRepository;
import utez.edu.mx.fichas_utez_backend.Modules.MediaChannel.Model.MediaChannelRepository;
import utez.edu.mx.fichas_utez_backend.Modules.HighSchoolType.Model.HighSchoolTypeRepository;
import utez.edu.mx.fichas_utez_backend.Modules.HighSchool.Model.HighSchoolRepository;

import java.io.InputStream;

@Configuration
public class DataInitializer {
    @Bean
    public CommandLineRunner initDatabase(
            NationalityRepository nationalityRepository,
            CountryRepository countryRepository,
            StateRepository stateRepository,
            MunicipalityRepository municipalityRepository,
            CivilStatusRepository civilStatusRepository,
            NativeLanguageRepository nativeLanguageRepository,
            DisabilityRepository disabilityRepository,
            IndigenousLanguageRepository indigenousLanguageRepository,
            SchoolCareerRepository schoolCareerRepository,
            MediaChannelRepository mediaChannelRepository,
            HighSchoolTypeRepository highSchoolTypeRepository,
            HighSchoolRepository highSchoolRepository
    ) {
        return args -> {
            if (nationalityRepository.count() == 0) {
                nationalityRepository.save(new Nationality( "Mexicano(a)"));
                nationalityRepository.save(new Nationality( "Extranjero(a)"));
            }
            if (countryRepository.count() == 0) {
                countryRepository.save(new Country("México"));
                countryRepository.save(new Country("Estados Unidos"));
                countryRepository.save(new Country("Canadá"));
                countryRepository.save(new Country("España"));
                countryRepository.save(new Country("Argentina"));
                countryRepository.save(new Country("Colombia"));
                countryRepository.save(new Country("Brasil"));
                countryRepository.save(new Country("Francia"));
                countryRepository.save(new Country("Italia"));
                countryRepository.save(new Country("Alemania"));
            }
            if (stateRepository.count() == 0) {
                Country mexico = countryRepository.findAll().stream().filter(c -> c.getName().equals("México")).findFirst().orElse(null);
                Country usa = countryRepository.findAll().stream().filter(c -> c.getName().equals("Estados Unidos")).findFirst().orElse(null);
                if (mexico != null) {
                    stateRepository.save(new State("Aguascalientes", mexico));
                    stateRepository.save(new State("Baja California", mexico));
                    stateRepository.save(new State("Baja California Sur", mexico));
                    stateRepository.save(new State("Campeche", mexico));
                    stateRepository.save(new State("Coahuila de Zaragoza", mexico));
                    stateRepository.save(new State("Colima", mexico));
                    stateRepository.save(new State("Chiapas", mexico));
                    stateRepository.save(new State("Chihuahua", mexico));
                    stateRepository.save(new State("Ciudad de México", mexico));
                    stateRepository.save(new State("Durango", mexico));
                    stateRepository.save(new State("Guanajuato", mexico));
                    stateRepository.save(new State("Guerrero", mexico));
                    stateRepository.save(new State("Hidalgo", mexico));
                    stateRepository.save(new State("Jalisco", mexico));
                    stateRepository.save(new State("México", mexico));
                    stateRepository.save(new State("Michoacán de Ocampo", mexico));
                    stateRepository.save(new State("Morelos", mexico));
                    stateRepository.save(new State("Nayarit", mexico));
                    stateRepository.save(new State("Nuevo León", mexico));
                    stateRepository.save(new State("Oaxaca", mexico));
                    stateRepository.save(new State("Puebla", mexico));
                    stateRepository.save(new State("Querétaro", mexico));
                    stateRepository.save(new State("Quintana Roo", mexico));
                    stateRepository.save(new State("San Luis Potosí", mexico));
                    stateRepository.save(new State("Sinaloa", mexico));
                    stateRepository.save(new State("Sonora", mexico));
                    stateRepository.save(new State("Tabasco", mexico));
                    stateRepository.save(new State("Tamaulipas", mexico));
                    stateRepository.save(new State("Tlaxcala", mexico));
                    stateRepository.save(new State("Veracruz de Ignacio de la Llave", mexico));
                    stateRepository.save(new State("Yucatán", mexico));
                    stateRepository.save(new State("Zacatecas", mexico));
                }
                if (usa != null)  {
                    stateRepository.save(new State( "California", usa));
                    stateRepository.save(new State( "Texas", usa));
                    stateRepository.save(new State( "Florida", usa));
                    stateRepository.save(new State( "Nueva York", usa));
                }
            }
            // Municipios de todos los estados de México desde JSON
            if (municipalityRepository.count() == 0) {
                ObjectMapper mapper = new ObjectMapper();
                InputStream is = getClass().getClassLoader().getResourceAsStream("municipios_mexico.json");
                if (is != null) {
                    JsonNode root = mapper.readTree(is);
                    for (JsonNode stateNode : root) {
                        String stateName = stateNode.get("state").asText();
                        State state = stateRepository.findAll().stream()
                                .filter(s -> s.getName().equalsIgnoreCase(stateName))
                                .findFirst().orElse(null);
                        if (state != null) {
                            for (JsonNode munNode : stateNode.get("municipalities")) {
                                String munName = munNode.asText();
                                municipalityRepository.save(new Municipality(munName, state));
                            }
                        }
                    }
                }
            }
            // Estados civiles
            if (civilStatusRepository.count() == 0) {
                civilStatusRepository.save(new CivilStatus("Soltero(a)"));
                civilStatusRepository.save(new CivilStatus("Casado(a)"));
                civilStatusRepository.save(new CivilStatus("Viudo(a)"));
                civilStatusRepository.save(new CivilStatus("Divorciado(a)"));
                civilStatusRepository.save(new CivilStatus("Unión libre"));
            }
            // Lenguas natales
            if (nativeLanguageRepository.count() == 0) {
                nativeLanguageRepository.save(new NativeLanguage("Alemán"));
                nativeLanguageRepository.save(new NativeLanguage("Árabe"));
                nativeLanguageRepository.save(new NativeLanguage("Catalán"));
                nativeLanguageRepository.save(new NativeLanguage("Chino cantonés"));
                nativeLanguageRepository.save(new NativeLanguage("Chino mandarín"));
                nativeLanguageRepository.save(new NativeLanguage("Coreano"));
                nativeLanguageRepository.save(new NativeLanguage("Español"));
                nativeLanguageRepository.save(new NativeLanguage("Flamenco"));
                nativeLanguageRepository.save(new NativeLanguage("Francés"));
                nativeLanguageRepository.save(new NativeLanguage("Gallego"));
                nativeLanguageRepository.save(new NativeLanguage("Griego"));
                nativeLanguageRepository.save(new NativeLanguage("Hebreo"));
                nativeLanguageRepository.save(new NativeLanguage("Holandés"));
                nativeLanguageRepository.save(new NativeLanguage("Inglés"));
                nativeLanguageRepository.save(new NativeLanguage("Italiano"));
                nativeLanguageRepository.save(new NativeLanguage("Japonés"));
                nativeLanguageRepository.save(new NativeLanguage("Portugués"));
                nativeLanguageRepository.save(new NativeLanguage("Ruso"));
                nativeLanguageRepository.save(new NativeLanguage("Sueco"));
                nativeLanguageRepository.save(new NativeLanguage("Vasco"));
            }
            // Discapacidades
            if (disabilityRepository.count() == 0) {
                disabilityRepository.save(new Disability("Física/Motriz"));
                disabilityRepository.save(new Disability("Intelectual"));
                disabilityRepository.save(new Disability("Múltiple"));
                disabilityRepository.save(new Disability("Auditiva Hipoacusia"));
                disabilityRepository.save(new Disability("Auditiva Sordera"));
                disabilityRepository.save(new Disability("Visual Baja Visión"));
                disabilityRepository.save(new Disability("Visual Ceguera"));
                disabilityRepository.save(new Disability("Discapacidad Psicosocial"));
            }
            // Lenguas indígenas
            if (indigenousLanguageRepository.count() == 0) {
                indigenousLanguageRepository.save(new IndigenousLanguage("Akateko"));
                indigenousLanguageRepository.save(new IndigenousLanguage("Amuzgo"));
                indigenousLanguageRepository.save(new IndigenousLanguage("Awakateko"));
                indigenousLanguageRepository.save(new IndigenousLanguage("Ayapaneco"));
                indigenousLanguageRepository.save(new IndigenousLanguage("Cora"));
                indigenousLanguageRepository.save(new IndigenousLanguage("Cucapá"));
                indigenousLanguageRepository.save(new IndigenousLanguage("Cuicateco"));
                indigenousLanguageRepository.save(new IndigenousLanguage("Chatino"));
                indigenousLanguageRepository.save(new IndigenousLanguage("Chichimeco jonaz"));
                indigenousLanguageRepository.save(new IndigenousLanguage("Chinanteco"));
                indigenousLanguageRepository.save(new IndigenousLanguage("Chocholteco"));
                indigenousLanguageRepository.save(new IndigenousLanguage("Chontal de Oaxaca"));
                indigenousLanguageRepository.save(new IndigenousLanguage("Chontal de Tabasco"));
                indigenousLanguageRepository.save(new IndigenousLanguage("Chuj"));
                indigenousLanguageRepository.save(new IndigenousLanguage("Ch���ol"));
                indigenousLanguageRepository.save(new IndigenousLanguage("Guarijío"));
                indigenousLanguageRepository.save(new IndigenousLanguage("Huasteco"));
                indigenousLanguageRepository.save(new IndigenousLanguage("Huave"));
                indigenousLanguageRepository.save(new IndigenousLanguage("Huichol"));
                indigenousLanguageRepository.save(new IndigenousLanguage("Ixcateco"));
                indigenousLanguageRepository.save(new IndigenousLanguage("Ixil"));
                indigenousLanguageRepository.save(new IndigenousLanguage("Jakalteko"));
                indigenousLanguageRepository.save(new IndigenousLanguage("Kaqchikel"));
                indigenousLanguageRepository.save(new IndigenousLanguage("Kickapoo"));
                indigenousLanguageRepository.save(new IndigenousLanguage("Kiliwa"));
                indigenousLanguageRepository.save(new IndigenousLanguage("Kumiai"));
                indigenousLanguageRepository.save(new IndigenousLanguage("Ku’ahl"));
                indigenousLanguageRepository.save(new IndigenousLanguage("K’iche’"));
                indigenousLanguageRepository.save(new IndigenousLanguage("Lacandón"));
                indigenousLanguageRepository.save(new IndigenousLanguage("Mam"));
                indigenousLanguageRepository.save(new IndigenousLanguage("Matlatzinca"));
                indigenousLanguageRepository.save(new IndigenousLanguage("Maya"));
                indigenousLanguageRepository.save(new IndigenousLanguage("Mayo"));
                indigenousLanguageRepository.save(new IndigenousLanguage("Mazahua"));
                indigenousLanguageRepository.save(new IndigenousLanguage("Mazateco"));
                indigenousLanguageRepository.save(new IndigenousLanguage("Mixe"));
                indigenousLanguageRepository.save(new IndigenousLanguage("Mixteco"));
                indigenousLanguageRepository.save(new IndigenousLanguage("Náhuatl"));
                indigenousLanguageRepository.save(new IndigenousLanguage("Oluteco"));
                indigenousLanguageRepository.save(new IndigenousLanguage("Otomí"));
                indigenousLanguageRepository.save(new IndigenousLanguage("Paipai"));
                indigenousLanguageRepository.save(new IndigenousLanguage("Pame"));
                indigenousLanguageRepository.save(new IndigenousLanguage("Pápago"));
                indigenousLanguageRepository.save(new IndigenousLanguage("Pima"));
                indigenousLanguageRepository.save(new IndigenousLanguage("Popoloca"));
                indigenousLanguageRepository.save(new IndigenousLanguage("Popoluca de la Sierra"));
                indigenousLanguageRepository.save(new IndigenousLanguage("Qato’k"));
                indigenousLanguageRepository.save(new IndigenousLanguage("Q’anjob’al"));
                indigenousLanguageRepository.save(new IndigenousLanguage("Q’eqchí’"));
                indigenousLanguageRepository.save(new IndigenousLanguage("Sayulteco"));
                indigenousLanguageRepository.save(new IndigenousLanguage("Seri"));
                indigenousLanguageRepository.save(new IndigenousLanguage("Tarahumara"));
                indigenousLanguageRepository.save(new IndigenousLanguage("Tarasco"));
                indigenousLanguageRepository.save(new IndigenousLanguage("Teko"));
                indigenousLanguageRepository.save(new IndigenousLanguage("Tepehua"));
                indigenousLanguageRepository.save(new IndigenousLanguage("Tepehuano del norte"));
                indigenousLanguageRepository.save(new IndigenousLanguage("Tepehuano del sur"));
                indigenousLanguageRepository.save(new IndigenousLanguage("Texistepequeño"));
                indigenousLanguageRepository.save(new IndigenousLanguage("Tojolabal"));
                indigenousLanguageRepository.save(new IndigenousLanguage("Totonaco"));
                indigenousLanguageRepository.save(new IndigenousLanguage("Triqui"));
                indigenousLanguageRepository.save(new IndigenousLanguage("Tlahuica"));
                indigenousLanguageRepository.save(new IndigenousLanguage("Tlapaneco"));
                indigenousLanguageRepository.save(new IndigenousLanguage("Tseltal"));
                indigenousLanguageRepository.save(new IndigenousLanguage("Tsotsil"));
                indigenousLanguageRepository.save(new IndigenousLanguage("Yaqui"));
                indigenousLanguageRepository.save(new IndigenousLanguage("Zapoteco"));
                indigenousLanguageRepository.save(new IndigenousLanguage("Zoque"));
            }
            // Carreras escolares
            if (schoolCareerRepository.count() == 0) {
                schoolCareerRepository.save(new SchoolCareer("Ing. Mecatrónica especialidad en Automatización"));
                schoolCareerRepository.save(new SchoolCareer("Lic. en Administración especialidad en Gestión del Capital Humano"));
                schoolCareerRepository.save(new SchoolCareer("Lic. en Diseño Digital y Producción Audiovisual especialidad en Diseño y Animación Digital"));
                schoolCareerRepository.save(new SchoolCareer("Ing. en Diseño Textil y Moda especialidad en Diseño y Moda Industrial en Producción"));
                schoolCareerRepository.save(new SchoolCareer("Lic. en Administración especialidad en Emprendimiento, Formulación y Evaluación de Proyectos"));
                schoolCareerRepository.save(new SchoolCareer("Ing. en Nanotecnología"));
                schoolCareerRepository.save(new SchoolCareer("Ing. Industrial especialidad en Procesos Productivos"));
                schoolCareerRepository.save(new SchoolCareer("Ing. en Tecnologías de la Información e Innovación Digital especialidad en Infraestructura de Redes Digitales"));
            }
            // Medios de difusión
            if (mediaChannelRepository.count() == 0) {
                mediaChannelRepository.save(new MediaChannel("Publicación en Instagram"));
                mediaChannelRepository.save(new MediaChannel("Visita guiada a la UTEZ"));
                mediaChannelRepository.save(new MediaChannel("Publicación en Facebook"));
                mediaChannelRepository.save(new MediaChannel("Feria de Universidades en mi plantel"));
                mediaChannelRepository.save(new MediaChannel("Mensaje por WhatsApp"));
                mediaChannelRepository.save(new MediaChannel("Módulo de atención en la UTEZ"));
                mediaChannelRepository.save(new MediaChannel("Enlace de redes sociales o página web (Compartido por familiar o amigo)"));
                mediaChannelRepository.save(new MediaChannel("Medios (T.V, Radio, Periódico)"));
                mediaChannelRepository.save(new MediaChannel("Familiar o amigo (Recomendación de viva voz)"));
                mediaChannelRepository.save(new MediaChannel("Plática en mi plantel"));
            }
            // Tipos de plantel de media superior
            if (highSchoolTypeRepository.count() == 0) {
                highSchoolTypeRepository.save(new HighSchoolType("Preparatoria Privada", null));
                highSchoolTypeRepository.save(new HighSchoolType("Preparatoria Federal por Cooperación", "PREFECO"));
                highSchoolTypeRepository.save(new HighSchoolType("Colegio Nacional de Educación Profesional Técnica", "CONALEP"));
                highSchoolTypeRepository.save(new HighSchoolType("Colegio de Estudios Científicos y Tecnológicos del Estado", "CECYTE"));
                highSchoolTypeRepository.save(new HighSchoolType("Preparatoria Pública", null));
                highSchoolTypeRepository.save(new HighSchoolType("Colegio de Bachilleres del Estado de México", "COBAEM"));
                highSchoolTypeRepository.save(new HighSchoolType("Centro de Bachillerato Tecnológico Agropecuario", "CBTA"));
                highSchoolTypeRepository.save(new HighSchoolType("Educación Media Superior a Distancia", "EMSAD"));
                highSchoolTypeRepository.save(new HighSchoolType("Preparatoria Abierta", null));
                highSchoolTypeRepository.save(new HighSchoolType("Preparatoria de la Universidad Autónoma del Estado de México", "Preparatoria UAEM"));
                highSchoolTypeRepository.save(new HighSchoolType("Centro de Estudios Tecnológicos Industrial y de Servicios", "CETIS"));
                highSchoolTypeRepository.save(new HighSchoolType("Centro de Bachillerato Tecnológico Industrial y de Servicios", "CBTIS"));
            }
            // Preparatorias de Cuernavaca
            if (highSchoolRepository.count() == 0) {
                HighSchoolType cbtis = highSchoolTypeRepository.findByAbrevation("CBTIS").orElse(null);
                HighSchoolType cetis = highSchoolTypeRepository.findByAbrevation("CETIS").orElse(null);
                HighSchoolType conalep = highSchoolTypeRepository.findByAbrevation("CONALEP").orElse(null);
                HighSchoolType cecyte = highSchoolTypeRepository.findByAbrevation("CECYTE").orElse(null);
                HighSchoolType prepaUaem = highSchoolTypeRepository.findByAbrevation("Preparatoria UAEM").orElse(null);

                highSchoolRepository.save(new HighSchool("CBTIS 166", cbtis));
                highSchoolRepository.save(new HighSchool("CETIS 44", cetis));
                highSchoolRepository.save(new HighSchool("CONALEP Cuernavaca", conalep));
                highSchoolRepository.save(new HighSchool("CECYTE Morelos Plantel Cuernavaca", cecyte));
                highSchoolRepository.save(new HighSchool("Preparatoria No. 1 UAEM", prepaUaem));
            }
        };
    }
}
