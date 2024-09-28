package ovh.serial30.diagnocom.configuration;

public abstract class Const {

    public interface Logs {
        String SECURITY_LOADED = "CONFIGURACIÓN DE SEGURIDAD TERMINADA";
        String FACT_NOT_INFERRED = "No se puede inferir un resultado acertado";
        String ACCESS_DENIED = "Acceso al resurso denegado!";
        String INVALID_TOKEN = "Token de usuario inválido!";
        String USER_NOT_FOUND = "Usuario no encontrado!";
        String WRONG_PASSWORD = "Contraseña actual incorrecta!";
        String VALID_TEMP = "Compruebe la temperatura ingresada!";
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
    }

    public interface BRB {
        String SI = "si";
        String NO = "no";
        String afeccion = "afeccion";
        String enfermedad = "enfermedad";
        String TEMP_INI = "37.0";
        String TEMP_36 = "35.99";
        String TEMP_37 = "37.01";
        String TEMP_37_5 = "37.49";

        interface Number {
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
        }

        interface Symptoms {
            String afeccionCabeza = "afeccionCabeza";
            String afeccionRespiratoria = "afeccionRespiratoria";
            String afeccionDigestiva = "afeccionDigestiva";
            String afeccionInterna ="afeccionInterna";
            String afeccionUrinaria = "afeccionUrinaria";
            String afeccionPiel = "afeccionPiel";
            String dolorCabeza = "dolorCabeza";
            String presionArterialAlta = "presionArterialAlta";
            String temperatura = "temperatura";
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
            String D_ENCEFALICO = "Diagnóstico Encefálico";
            String D_RESPIRATORIO = "Diagnóstico Respiratorio";
            String D_DIGESTIVO = "Diagnóstico Digestivo";
            String D_INTERNO = "Diagnóstico Interno";
            String D_URINARIO = "Diagnóstico Urinario";
            String D_CUTANEO = "Diagnóstico Cutáneo";
            String MIGRANIA = "Migraña";
            String INF_OIDO = "Infección de oido";
            String GRIPE_COMUN = "Gripe común";
            String BRONQUITIS = "Bronquitis";
            String TOS_FLEMA = "Tos con flema";
            String SINUSITIS = "Sinusitis";
            String INFLUENZA = "Influenza";
            String SINUSITIS_BAC = "Sinusitis bacteriana";
            String NEUMONIA = "Neumonía";
            String FIBROSIS_PUL = "Fibrosis pulmonar";
            String BRONQUIOLOTIS = "Bronquiolitis";
            String INF_ESTOMAGO = "Infección de estómago";
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
