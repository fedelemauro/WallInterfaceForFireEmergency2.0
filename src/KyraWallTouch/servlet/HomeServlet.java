package KyraWallTouch.servlet;

import KyraWallTouch.model.Segnalazione;
import KyraWallTouch.model.SegnalazioneDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeServlet", urlPatterns="", loadOnStartup=1)
public class HomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final SegnalazioneDAO segnalazioneDAO = new SegnalazioneDAO();

    @Override
    public void init() throws ServletException {
        super.init();
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Segnalazione> segnalazioni = segnalazioneDAO.doRetrieveAll();
        request.setAttribute("segnalazioni", segnalazioni);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request, response);
    }
}
