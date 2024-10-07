package ovh.serial30.diagnocom.services;

import ovh.serial30.diagnocom.exceptions.AuthDataException;
import ovh.serial30.diagnocom.exceptions.ServerException;
import ovh.serial30.diagnocom.pojos.request.UserRequest;
import ovh.serial30.diagnocom.pojos.request.UserUpdateRequest;
import ovh.serial30.diagnocom.pojos.response.UserResponse;
import ovh.serial30.diagnocom.pojos.response.UserToken;

public interface UserService {
    /**
     * Registra un usuario en la base de datos
     * @param userRequest Representacion de los datos de registro
     * @return Token de usuario
     */
    UserToken registerUser(UserRequest userRequest);

    /**
     * Inicia sesion para un usuario
     * @param userRequest Representacion de los datos de autenticacion del usuario
     * @return Token de usuario
     * @throws AuthDataException Si sucede algun error de autenticacion
     */
    UserToken loginUser(UserRequest userRequest) throws AuthDataException;

    /**
     * Obtiene la informacion del usuario que realiza la solicitud a la API
     * @return Representacion de los datos del usuario solicitado
     * @throws ServerException Si sucede algun error al consultar la informacion del usuario solicitado
     */
    UserResponse getUser() throws ServerException;

    /**
     * Actualiza los datos de usuario que realiza la solicitud a la API
     * @param userUpdateRequest Representacion de los datos del usuario a actualizar
     * @return Representacion de los datos actualizados del usuario solicitado
     * @throws AuthDataException Si la contraseña actual del usuario solicitado no es correcta
     */
    UserResponse updateUser(UserUpdateRequest userUpdateRequest) throws AuthDataException;
}
