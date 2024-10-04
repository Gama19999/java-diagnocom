package ovh.serial30.diagnocom.configuration;

/**
 * Clase que concentra las cadenas de texto como constantes
 */
public abstract class Const {

    public interface Logs {
        String SECURITY_LOADED = "CONFIGURACIÓN DE SEGURIDAD TERMINADA";
        String FACT_NOT_INFERRED = "No se puede inferir un resultado acertado";
        String ACCESS_DENIED = "Acceso al resurso denegado!";
        String INVALID_TOKEN = "Token de usuario inválido!";
        String USER_NOT_FOUND = "Usuario no encontrado!";
        String WRONG_PASSWORD = "Contraseña actual incorrecta!";
    }

    public interface Routes {
        String ALL = "/**";
        String HOME = "/home";
        String STATUS = "/status";
        String AUTH = "/auth";
        String REGISTER = "/register";
        String LOGIN = "/login";
        String USER = "/user";
        String BRB = "/brb";
        String FORWARD = "/forward";
    }

    public interface Headers {
        String TOKEN = "Authorization";
    }

    public interface Entities {
        String TABLE_USERS = "users";
        String JPQL_USERS = "USERS";
        String USER_ID = "user_id";
        String USERNAME = "username";
        String PASSWORD = "password";
        String CURRENT_PASSWORD = "currentPassword";
        String NEW_PASSWORD = "newPassword";
        String EMAIL = "email";
        String CREATED_AT = "created_at";
        String LAST_LOGIN = "last_login";
        String TABLE_RESULTS = "results";
        String JPQL_RESULTS = "RESULTS";
        String RESULT_ID = "result_id";
        String CONTENT = "content";
    }

    public interface BRB {
        interface Values {
            String SI = "si";
            String NO = "no";
            String CHAINING = "chaining";
            String THIRD = "third";
            String TEMP_35_9 = "35.9";
            String TEMP_36 = "36.0";
            String TEMP_37 = "37.0";
            String TEMP_37_5 = "37.5";
            String TEMP_37_6 = "37.6";
        }

        interface RuleId {
            String R1 = "R1";
            String R2 = "R2";
            String R3 = "R3";
            String R4 = "R4";
            String R5 = "R5";
            String R6 = "R6";
            String R7 = "R7";
            String R8 = "R8";
            String R9 = "R9";
            String R10 = "R10";
            String R11 = "R11";
            String R12 = "R12";
            String R13 = "R13";
            String R14 = "R14";
            String R15 = "R15";
            String R16 = "R16";
            String R17 = "R17";
            String R18 = "R18";
            String R19 = "R19";
            String R20 = "R20";
            String R21 = "R21";
            String R22 = "R22";
            String R23 = "R23";
            String R24 = "R24";
            String R25 = "R25";
            String R26 = "R26";
            String R27 = "R27";
            String R28 = "R28";
            String R29 = "R29";
            String R30 = "R30";
        }

        interface VarName {
            String grados = "grados";
            String locCabeza = "locCabeza";
            String locRespiratoria = "locRespiratoria";
            String locDigestiva = "locDigestiva";
            String locInterna ="locInterna";
            String locUrinaria = "locUrinaria";
            String locCutanea = "locCutanea";
            String dolorCabeza = "dolorCabeza";
            String presionArterialAlta = "presionArterialAlta";
            String zumbidoOidos = "zumbidoOidos";
            String nauseas = "nauseas";
            String dolorGarganta = "dolorGarganta";
            String dolorOido = "dolorOido";
            String tos = "tos";
            String estornudos = "estornudos";
            String dolorArticulaciones = "dolorArticulaciones";
            String dolorEspalda = "dolorEspalda";
            String dolorPecho = "dolorPecho";
            String escurrimientoNasal = "escurrimientoNasal";
            String fatiga = "fatiga";
            String congestionNasal = "congestionNasal";
            String dolorCorporal = "dolorCorporal";
            String dificultadRespiratoria = "dificultadRespiratoria";
            String dolorAbdominal = "dolorAbdominal";
            String evacuacionesConstantes = "evacuacionesConstantes";
            String acidezEstomacal = "acidezEstomacal";
            String vomito = "vomito";
            String hemorragiaRectal = "hemorragiaRectal";
            String diarrea = "diarrea";
            String evacuacionesConDolor = "evacuacionesConDolor";
            String dolorAlOrinar = "dolorAlOrinar";
            String sangradoAlOrinar = "sangradoAlOrinar";
            String pielEnrogecida = "pielEnrogecida";
            String inflamacionZona = "inflamacionZona";
            String altaSensibilidadZona = "altaSensibilidadZona";
        }

        interface Facts {
            String TEMPERATURA = "temperatura";
            String LOCALIZACION = "localizacion";
            String ENFERMEDAD = "enfermedad";
            String HIPOTERMIA = "Hipotermia";
            String TEMP_NORMAL = "Normal";
            String FIEBRE = "Fiebre";
            String LOC_CABEZA = "cabeza";
            String LOC_RESPIRATORIA = "respiratoria";
            String LOC_DIGESTIVA = "digestiva";
            String LOC_INTERNA = "interna";
            String LOC_URINARIA = "urinaria";
            String LOC_CUTANEA = "cutánea";
            String MIGRANIA = "Migraña";
            String INF_OIDO = "Infección de oido";
            String GRIPE_COMUN = "Gripe común";
            String BRONQUITIS = "Bronquitis";
            String SINUSITIS = "Sinusitis";
            String INFLUENZA = "Influenza";
            String SINUSITIS_BAC = "Sinusitis bacteriana";
            String NEUMONIA = "Neumonía";
            String FIBROSIS_PUL = "Fibrosis pulmonar";
            String BRONQUIOLOTIS = "Bronquiolitis";
            String INF_ESTOMACAL = "Infección estomacal";
            String ESTRENIMIENTO = "Estreñimiento";
            String INDIGESTION = "Indigestión";
            String GASTRITIS = "Gastritis";
            String COLITIS = "Colitis";
            String APENDICITIS = "Apendicitis";
            String ESOFAGITIS = "Esofagitis";
            String PANCREATITIS = "Pancreatitis";
            String ANEMIA = "Anemia";
            String INF_URINARIA = "Infección urinaria";
            String INF_PIEL = "Infección de la piel";
        }
    }
}
