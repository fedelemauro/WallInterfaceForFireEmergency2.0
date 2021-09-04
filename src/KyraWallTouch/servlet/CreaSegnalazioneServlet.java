package KyraWallTouch.servlet;

import KyraWallTouch.model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/CreaSegnalazione")
public class CreaSegnalazioneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String descrizione = request.getParameter("Segnalazione");
        String latitudine= request.getParameter("Latitudine");
        String longitudine= request.getParameter("Longitudine");
        String citta= request.getParameter("Citta");
        String provincia =request.getParameter("Provincia");
        String via =request.getParameter("Via");
        String numcivico =request.getParameter("Civico");
        String cap=request.getParameter("Cap");
        String data=request.getParameter("Data");


        SegnalazioneDAO segnalazioneDAO= new SegnalazioneDAO();
        CodiciMeteoDAO codiciMeteoDAO = new CodiciMeteoDAO();
        CoordinateDAO coordinateDAO = new CoordinateDAO();
        AgenteDAO agenteDAO = new AgenteDAO();
        List<Agente> agenti = agenteDAO.doRetrieveAll();
        Agente agente = agenteDAO.doRetrieveById(1);
        Segnalazione segnalazione = new Segnalazione();
        segnalazione.setDescrizione(descrizione);
        segnalazione.setLatitudine(latitudine);
        segnalazione.setLongitudine(longitudine);
        segnalazione.setCitta(citta);
        segnalazione.setProvincia(provincia);
        segnalazione.setVia(via);
        segnalazione.setNumcivico(numcivico);
        segnalazione.setCap(cap);
        segnalazione.setData(data);
        segnalazione.setCodiceMeteo(codiciMeteoDAO.doRetrieveByComune(citta));

        String lat= coordinateDAO.doRetrieveByComune(segnalazione).getLatitudine();
        String lng= coordinateDAO.doRetrieveByComune(segnalazione).getLongitudine();
        segnalazione.setLongitudine(lng);
        segnalazione.setLatitudine(lat);

        segnalazioneDAO.doSave(segnalazione);

        request.setAttribute("segnalazione", segnalazione);
        request.setAttribute("agenti", agenti);
        request.setAttribute("agente", agente);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("segnalazione.jsp");
        requestDispatcher.forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
