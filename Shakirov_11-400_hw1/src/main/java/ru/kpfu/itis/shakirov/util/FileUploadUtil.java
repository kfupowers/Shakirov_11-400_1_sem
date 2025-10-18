package ru.kpfu.itis.shakirov.util;

import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

public class FileUploadUtil {

    public static final String FILE_PREFIX = "C:/Users/Ra/IdeaProjects/Shakirov_400_hw1/Shakirov_11-400_hw1/src/main/webapp/tmp";
    public static final int DIRECTORIES_COUNT = 100;

    public static String upload(Part part) throws IOException {
        String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();

        File file = new File(FILE_PREFIX + File.separator
                + Math.abs(filename.hashCode() % DIRECTORIES_COUNT) + File.separator + filename);

        InputStream content = part.getInputStream();
        file.getParentFile().mkdirs();
        file.createNewFile();
        FileOutputStream outputStream = new FileOutputStream(file);
        byte[] buffer = new byte[content.available()];
        content.read(buffer);
        outputStream.write(buffer);
        outputStream.close();
        return "tmp/" + Math.abs(filename.hashCode() % DIRECTORIES_COUNT) + File.separator + filename;
    }
}
