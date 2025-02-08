package io.github.chindeaytb.updatermain;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class UpdaterMain {

    public static void main(String[] args) throws InterruptedException, IOException {

        File libautoupdate_folder = new File(".autoupdates");
        libautoupdate_folder.getParentFile().mkdirs();
        for (int i = 2; i < args.length; i++) {
            switch (args[i].intern()) {
                case "delete":
                    File file = unlockedFile(args[++i]);
                    if (!file.delete()) {
                        System.out.println("Failed to delete " + file);
                    }
                    break;
                case "move":
                    File from = unlockedFile(args[++i]);
                    File to = unlockedFile(args[++i]);
                    Files.move(from.toPath(), to.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    break;
                default:
                    System.exit(1);
            }
        }
    }

    public static File unlockedFile(String name) throws InterruptedException {
        File file = new File(name);
        while (file.exists() && !file.renameTo(file)) {
            Thread.sleep(1000L);
        }
        file.getParentFile().mkdirs();
        return file;
    }
}
