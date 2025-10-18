package ru.kpfu.itis.shakirov.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import ru.kpfu.itis.shakirov.util.FileUploadUtil;
import javax.servlet.http.Part;
import java.io.IOException;

import ru.kpfu.itis.shakirov.service.impl.UserServiceImpl;

@WebServlet(name = "SignUp", urlPatterns = "/sign_up")
@MultipartConfig(
        maxFileSize = 5 * 1024 * 1024,
        maxRequestSize = 10 * 1024 * 1024
)
public class SignUpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("sign_up.ftl");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // registration
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String lastname = req.getParameter("lastname");
        Part part = req.getPart("file");

        String path = FileUploadUtil.upload(part);
        if (new UserServiceImpl().signUp(login, password, name, lastname, path)) {
            resp.sendRedirect("login");

        } else {
            resp.sendRedirect("bad_sing_up.ftl");
        }
    }
}
