package ru.kpfu.itis.shakirov.filter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

public class FileUploadServlet extends HttpServlet {

    public static final String FILE_PREFIX = "/tmp";
    public static final int DIRECTORIES_COUNT = 100;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part part = req.getPart("file");
        String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();

        File file = new File(FILE_PREFIX + File.separator + filename.hashCode() % DIRECTORIES_COUNT +File.separator + filename);

        InputStream content = part.getInputStream();
        file.getParentFile().mkdirs();
        file.createNewFile();
        FileOutputStream outputStream = new FileOutputStream(file);
        byte[] buffer = new byte[content.available()];
        content.read(buffer);
        outputStream.write(buffer);
        outputStream.close();
    }
}
