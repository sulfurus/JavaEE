package fr.eni.javaee.module4.tp1.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.javaee.module4.tp1.BusinessException;
import fr.eni.javaee.module4.tp1.bll.RepasManager;
import fr.eni.javaee.module4.tp1.bo.Aliment;
import fr.eni.javaee.module4.tp1.bo.Repas;

/**
 * Servlet implementation class AjoutRepas
 */
@WebServlet("/AjoutRepas")
public class AjoutRepas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AjoutRepas() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/AjoutRepas.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RepasManager repasManager = new RepasManager();

		/**
		 * Récuperation des valeur du formulaire
		 */

		LocalDate date = LocalDate.parse(request.getParameter("date"));
		LocalTime heure = LocalTime.parse(request.getParameter("time"));
		List<Aliment> listeAliment = new ArrayList<Aliment>();
		String[] la;
		int idRepas = 0;
		Boolean isOk = true;
		try {
			idRepas = repasManager.ajouterRepas(new Repas(date, heure));
			la = request.getParameter("aliment").split(",");

			for (String libelleAliment : la) {

				listeAliment.add(new Aliment(libelleAliment.trim()));
			}

			repasManager.addListeAliment(idRepas, listeAliment);

		} catch (BusinessException e) {
			isOk = false;

		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/AjoutRepas.jsp");
		rd.forward(request, response);

	}

}
