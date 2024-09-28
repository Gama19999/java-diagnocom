package ovh.serial30.diagnocom.pojos.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter @Setter
public class IncomingData {
    private Map<String, String> object;
}
