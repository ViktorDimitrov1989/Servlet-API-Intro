package org;

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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/users")
public class UserServlet extends HttpServlet{

    private Connection connection;

    public UserServlet(){
       this.connection = MyConnection.getConnection();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        List<String> users = new ArrayList<String>();

        try {
            PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM users");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                users.add(rs.getString("username"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.setAttribute("users", users);
        req.getRequestDispatcher("/WEB-INF/views/users.jsp")
            .forward(req, resp);

    }



}
