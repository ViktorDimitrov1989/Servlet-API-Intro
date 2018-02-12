package org.softuni;
import org.softuni.utils.MyConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private Map<String, String> users = new HashMap<String, String>(){{
        put("Pesho", "123");
        put("Gosho", "123");
    }};

    private Connection connection;

    public LoginServlet(){
        this.connection = MyConnection.getConnection();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/login.jsp")
                .forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try {
            PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");

            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                int userId = rs.getInt("id");

                req.getSession().setAttribute("username", username);
                req.getSession().setAttribute("id", userId);


                resp.sendRedirect(req.getContextPath() + "/profile");
            }else{
                this.handleWrongLoginAttempt(req,resp, username);
            }


        } catch (SQLException e) {
            this.handleWrongLoginAttempt(req, resp, username);
            e.printStackTrace();
        }

    }

    private void handleWrongLoginAttempt(HttpServletRequest req, HttpServletResponse resp, String username) {
        try {
            req.setAttribute("error", "Invalid username or password");

            req.setAttribute("username", username);

            req.getRequestDispatcher("/WEB-INF/views/login.jsp")
                    .forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
