import...
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


@WebServlet(name = "registerServlet", urlPatterns = "/register.htm")
public class RegisterServlet extends HttpServlet {
    private String username;
    private String password;
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public void init() throws ServletException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        username = getServletConfig().getServletContext().getInitParameter("user");
        password = getServletConfig().getServletContext().getInitParameter("password");
        System.out.println(username);
        System.out.println(password);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        String sql = "select * from new_table where user=?";
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/person?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai", username, password);
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            rs = ps.executeQuery();
            if (rs.next()) {
                System.err.println("¸ÃÓÃ»§ÃûÒÑ´æÔÚ£¬ÇëÖØÐÂ×¢²á");
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();
                out.println("<!DOCTYPE HTML>");
                out.println("<HTML>");
                out.println("<HEAD><title>»¶Ó­×¢²á</title></HEAD>");
                out.println("<body>");
                out.println("<div align='center'>");
                out.println("<h2>×¢²áÊ§°Ü£¬ÇëÖØÐÂ×¢²á</h2>");
                out.println("<a href=\"Login/register.html\">·µ»ØÖØÐÂµÇÂ½</a>");
                out.println("</div>");
                out.println("</body>");
                out.println("</HTML>");

            } else {
                String s = "INSERT INTO new_table(user,password) value(?,?)";
                ps = con.prepareStatement(s);
                ps.setString(1, user);
                ps.setString(2, pass);
                int rs = ps.executeUpdate();
                if (rs > 0) {
                    System.err.println("×¢²á³É¹¦£¬ÇëµÇÂ¼");
                    response.setContentType("text/html;charset=UTF-8");
                    PrintWriter out = response.getWriter();
                    out.println("<!DOCTYPE HTML>");
                    out.println("<HTML>");
                    out.println("<HEAD><title>»¶Ó­µÇÂ¼</title></HEAD>");
                    out.println("<body>");
                    out.println("<div align='center'>");
                    out.println("<h2>×¢²á³É¹¦</h2>");
                    out.println("<a href=\"Login/login.jsp\">µÇÂ½</a>");
                    out.println("</div>");
                    out.println("</body>");
                    out.println("</HTML>");
                } else {
                    response.setContentType("text/html;charset=UTF-8");
                    PrintWriter out = response.getWriter();
                    out.println("<!DOCTYPE HTML>");
                    out.println("<HTML>");
                    out.println("<HEAD><title>»¶Ó­×¢²á</title></HEAD>");
                    out.println("<body>");
                    out.println("<div align='center'>");
                    out.println("<h2>×¢²áÊ§°Ü</h2>");
                    out.println("<a href=\"Login/register.jsp\">×¢²áÊ§°Ü£¬ÇëÖØÐÂ×¢²á</a>");
                    out.println("</div>");
                    out.println("</body>");
                    out.println("</HTML>");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
