package ru.kpfu.itis.shakirov.servlet;

import ru.kpfu.itis.shakirov.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/ajax/sign_up_check")
public class AjaxSignUpServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        String login = req.getParameter("login");

        if (new UserServiceImpl().getByLogin(login)) {
            resp.getWriter().write("User with this login already exists!");
        }
    }
}
