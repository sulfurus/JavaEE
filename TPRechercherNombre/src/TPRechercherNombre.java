
import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TPRechercherNombre
 */
@WebServlet(urlPatterns = { "/TPRechercherNombre" }, initParams = { @WebInitParam(name = "MIN_RANDOM", value = "50"),
		@WebInitParam(name = "MAX_RANDOM", value = "100") })
public class TPRechercherNombre extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int minRandom;
	private int maxRandom;
	String nombre = null;

	@Override
	public void init() throws ServletException {
		this.minRandom = Integer.parseInt(this.getInitParameter("MIN_RANDOM"));
		this.maxRandom =  Integer.parseInt(this.getInitParameter("MAX_RANDOM"));

	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TPRechercherNombre() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return : void Set nombre(int) avec un random 0-10
	 */
	private void setNombre() {
		Random random = new Random();
		System.out.printf("On relance une partie avec les bornes min(%s) et max(%s)\n", minRandom, maxRandom);
		nombre = String.valueOf(minRandom + random.nextInt(maxRandom - minRandom));
		/* nombre = String.valueOf(Math.round((Math.random() * 10))); */
		System.out.printf("Le nouveau nombre à trouver est : %s\n", nombre);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		setNombre();
		response.sendRedirect("/TPRechercherNombre/html/Formulaire.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nombreReponse = (String) request.getParameter("nombre");
		if (nombre == null) {
			setNombre();
		}
		if (nombreReponse != null && !nombreReponse.isEmpty()) {
			if (nombreReponse.equals(String.valueOf(nombre))) {
				System.out.printf("Vous avez proposez : %s , Victoire !!! Le chiffre à trouver est %s\n", nombreReponse,
						nombre);
				response.sendRedirect("/TPRechercherNombre/html/Victoire.html");
			} else {
				System.out.printf("Vous avez proposez : %s , mais le chiffre à trouver est %s\n", nombreReponse, nombre);
				response.sendRedirect("/TPRechercherNombre/html/Echec.html");
			}
		} else {
			System.err.println("Votre saisie est vide");
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

		}

	}

}
