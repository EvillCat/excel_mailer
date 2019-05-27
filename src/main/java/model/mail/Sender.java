package model.mail;

import java.util.List;
import java.util.Properties;

public interface Sender {

    /**
     * @param sendProperties depends on implementation.
     * @param receivers depends on implementation.
     * @throws Exception throws when there is send error.
     */
    void send(Properties sendProperties, List<String> receivers) throws Exception;
}
