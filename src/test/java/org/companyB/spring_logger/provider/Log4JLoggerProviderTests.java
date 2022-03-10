package org.companyB.spring_logger.provider;


import org.junit.jupiter.api.Test;

import static org.companyB.spring_logger.provider.impl.Log4jLoggerProvider.get;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by Charles Burrell (deltafront@gmail.com).
 *
 * @author Charles Burrell (deltafront@gmail.com)
 * @since 1.0
 */
public class Log4JLoggerProviderTests {

    @Test
    public void testProvides(){
        final Object logger = get().logger("this");
        assertNotNull(logger);
        assertTrue(logger instanceof org.apache.logging.log4j.Logger);
    }
}
