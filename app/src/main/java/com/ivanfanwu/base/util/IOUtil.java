package com.ivanfanwu.base.util;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by ivanfanwu on 2017/8/5.
 */

public class IOUtil {

    private IOUtil() {
        throw new AssertionError();
    }


    /**
     * Close closable object and wrap {@link IOException} with {@link RuntimeException}
     * @param closeable closeable object
     */
    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                throw new RuntimeException("IOException occurred. ", e);
            }
        }
    }

    /**
     * Close closable and hide possible {@link IOException}
     * @param closeable closeable object
     */
    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                // Ignored
            }
        }
    }

}
