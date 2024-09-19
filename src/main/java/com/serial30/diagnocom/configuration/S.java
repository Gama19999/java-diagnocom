package com.serial30.diagnocom.configuration;

public abstract class S {

    public interface Configuration {
        String LOG_SECURITY_LOADED = "CONFIGURACIÓN DE SEGURIDAD TERMINADA";
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

    public interface Token {
        String HEADER_STRING = "Authorization";
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
}
