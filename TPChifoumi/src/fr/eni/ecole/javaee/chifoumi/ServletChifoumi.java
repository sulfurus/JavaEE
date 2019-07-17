package fr.eni.ecole.javaee.chifoumi;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletChifoumi
 */
@WebServlet("/ServletChifoumi")
public class ServletChifoumi extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int nbChoixPrg;
	String choixPossible[] = { "Pierre", "Ciseaux", "Feuille" };

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletChifoumi() {
		super();
		// TODO Auto-generated constructor stub
	}

	private void setChoixPrg() {
		Random random = new Random();
		nbChoixPrg = random.nextInt(choixPossible.length);
		System.out.printf("Le choix d l'ordinateur est : %s\n", nbChoixPrg);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * RequestDispatcher rd =
		 * request.getRequestDispatcher("/WEB-INF/joueurChifoumi.jsp");
		 */
		RequestDispatcher rd = this.getServletContext().getNamedDispatcher("jouerChifoumi");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String choixJoueur = (String) request.getParameter("choix");
		System.out.println(choixJoueur);
		setChoixPrg();
		String reponse = null;
		if (choixPossible[nbChoixPrg].equals(choixJoueur)) {
			reponse = "Egalité";
		} else {
			if (choixPossible[(nbChoixPrg == 2) ? 0 : nbChoixPrg + 1].equals(choixJoueur)) {
				reponse = "Tu à perdu";
			}
			if (choixPossible[(nbChoixPrg == 0) ? 2 : nbChoixPrg - 1].equals(choixJoueur)) {
				reponse = "Tu à gagné";
			}
		}
		reponse += ", tu à choisi " + choixJoueur + ", l'ordinateur à choisi " + choixPossible[nbChoixPrg];

		System.out.println(reponse);
		request.setAttribute("resp", reponse);
		request.setAttribute("joueur", choixJoueur);
		request.setAttribute("prg", choixPossible[nbChoixPrg]);

		RequestDispatcher rd = this.getServletContext().getNamedDispatcher("resultatChifoumi");
		rd.forward(request, response);

	}

}
