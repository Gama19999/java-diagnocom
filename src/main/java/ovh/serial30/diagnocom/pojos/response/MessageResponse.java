package ovh.serial30.diagnocom.pojos.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class MessageResponse {
    private int status = 200;
    private Object data;
    private Date timestamp = new Date();
}
