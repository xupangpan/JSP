import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


@WebServlet(name = "login", urlPatterns = {"/login.htm"})
public class login extends HttpServlet {
    private String username;
    private String password;
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public void init() throws ServletException {
        //¶ÁÈ¡ÅäÖÃÎÄ¼þÀïÃæµÄÐÅÏ¢
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
        String sql = "select * from new_table where user=? and pass =?";
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai", username, password);
            ps = con.prepareStatement(sql);
            ps.setString(1,user);
            ps.setString(2,pass);
            rs = ps.executeQuery();
            if(rs.next())
            {
                System.err.println("µÇÂ¼³É¹¦");
                response.setContentType("textml;charset=UTF-8");
                PrintWriter out=response.getWriter();
                out.println("<!DOCTYPE HTML>");
                out.println("<HTML>");
                out.println("<HEAD><title>»¶Ó­µÇÂ½</title></HEAD>");
                out.println("<body>");
                out.println("<div align='center'>");
                out.println("<h2>µÇÂ½³É¹¦</h2>");
                out.println("</div>");
                out.println("</body>");
                out.println("</HTML>");

            }else{
                System.err.println("µÇÂ¼Ê§°Ü£¬ÇëÖØÐÂµÇÂ¼");
                response.setContentType("textml;charset=UTF-8");
                PrintWriter out=response.getWriter();
                out.println("<!DOCTYPE HTML>");
                out.println("<HTML>");
                out.println("<HEAD><title>»¶Ó­µÇÂ½</title></HEAD>");
                out.println("<body>");
                out.println("<div align='center'>");
                out.println("<h2>µÇÂ½Ê§°Ü£¬ÇëÖØÐÂµÇÂ½</h2>");
                out.println("</div>");
                out.println("</body>");
                out.println("</HTML>");
                //response.sendRedirect("Login/login.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }
}
