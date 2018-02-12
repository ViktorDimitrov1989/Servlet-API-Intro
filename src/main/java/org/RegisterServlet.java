package org;
import org.softuni.utils.MyConnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{
    private Connection connection;

    public RegisterServlet(){
        this.connection = MyConnection.getConnection();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/register.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try {
            String query = "INSERT INTO users(username, password)" +
                    "VALUES(?, ?)";

            PreparedStatement prepStatement = this.connection.prepareStatement(query);

            prepStatement.setString(1, username);
            prepStatement.setString(2, password);

            prepStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        resp.sendRedirect(req.getContextPath() + "/login");
    }
}
