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
                System.err.println("���û����Ѵ��ڣ�������ע��");
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();
                out.println("<!DOCTYPE HTML>");
                out.println("<HTML>");
                out.println("<HEAD><title>��ӭע��</title></HEAD>");
                out.println("<body>");
                out.println("<div align='center'>");
                out.println("<h2>ע��ʧ�ܣ�������ע��</h2>");
                out.println("<a href=\"Login/register.html\">�������µ�½</a>");
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
                    System.err.println("ע��ɹ������¼");
                    response.setContentType("text/html;charset=UTF-8");
                    PrintWriter out = response.getWriter();
                    out.println("<!DOCTYPE HTML>");
                    out.println("<HTML>");
                    out.println("<HEAD><title>��ӭ��¼</title></HEAD>");
                    out.println("<body>");
                    out.println("<div align='center'>");
                    out.println("<h2>ע��ɹ�</h2>");
                    out.println("<a href=\"Login/login.jsp\">��½</a>");
                    out.println("</div>");
                    out.println("</body>");
                    out.println("</HTML>");
                } else {
                    response.setContentType("text/html;charset=UTF-8");
                    PrintWriter out = response.getWriter();
                    out.println("<!DOCTYPE HTML>");
                    out.println("<HTML>");
                    out.println("<HEAD><title>��ӭע��</title></HEAD>");
                    out.println("<body>");
                    out.println("<div align='center'>");
                    out.println("<h2>ע��ʧ��</h2>");
                    out.println("<a href=\"Login/register.jsp\">ע��ʧ�ܣ�������ע��</a>");
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
