package io.github.chindeaytb;

import java.io.File;
import java.util.Locale;

public class ModsDirectory {

    public static final String MOD_DIR;

    static {
        String os = System.getProperty("os.name").toLowerCase(Locale.ROOT);
        if (os.contains("win")) {
            MOD_DIR = System.getenv("APPDATA") + File.separator + ".minecraft" + File.separator + "mods";
        } else {
            MOD_DIR = System.getProperty("user.home") + File.separator + ".minecraft" + File.separator + "mods";
        }
    }
}
