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
import fr.eni.javaee.module4.tp1.bll.AlimentManager;
import fr.eni.javaee.module4.tp1.bll.RepasManager;
import fr.eni.javaee.module4.tp1.bo.Aliment;
import fr.eni.javaee.module4.tp1.bo.Repas;

/**
 * Servlet implementation class VisuRepas
 */
@WebServlet("/VisuRepas")
public class VisuRepas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VisuRepas() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {

		super.init();
		RepasManager repasManager = new RepasManager();
		AlimentManager alimentManager = new AlimentManager();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RepasManager repasManager = new RepasManager();
		AlimentManager alimentManager = new AlimentManager();
		List<Repas> listeRepas = new ArrayList<Repas>();
		try {
			listeRepas = repasManager.getListeRepas();
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (!listeRepas.isEmpty()) {
			request.setAttribute("listeRepas", listeRepas);
		}
		
		/**
		 * Récuperation de l'id de Repas a afficher en detail
		 */
		int idRepas = 0;
		List<Aliment> listeAliment = new ArrayList<Aliment>();
		try {
			idRepas = Integer.parseInt(request.getParameter("detail"));
			listeAliment = repasManager.getListeAlimentByIdRepas(idRepas);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			request.setAttribute("listeAliment", listeAliment);
			request.setAttribute("idRepas", idRepas);
			RequestDispatcher rd = request.getRequestDispatcher("/VisuRepasJSP");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
