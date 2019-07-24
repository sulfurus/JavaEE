package fr.eni.javee.module5.tp;

import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class accueil
 */
@WebServlet("/accueil")
public class accueil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public accueil() {
		super();
		// TODO Auto-generated constructor stub

	}

	@Override
	public void init() throws ServletException {
		super.init();

		Map<String, String> mapColor = Stream
				.of(new String[][] { { "Jaune", "#FFFF00" }, { "Noir", "#00000" }, { "Vert", "#00FF00" },
						{ "Rouge", "#FF0000" }, { "Vert de mer", "MediumSeaGreen" }, { "Gris", "grey" },
						{ "Cyan", "darkcyan" }, { "Pourpre", "purple" }, })
				.collect(Collectors.toMap(data -> data[0], data -> data[1]));

		ServletContext application = this.getServletContext();
		application.setAttribute("mapColor", mapColor);

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Cookie[] cookies = request.getCookies();
		Cookie nbRequeteCookie = new Cookie("nbRequete", "0");
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("nbRequete")) {

				nbRequeteCookie = new Cookie("nbRequete", ((cookie.getValue() != null) ? cookie.getValue() : "0"));
				request.setAttribute("nbRequete", (cookie.getValue() != null) ? cookie.getValue() : "0");
			}
		}
		response.addCookie(nbRequeteCookie);
		RequestDispatcher rd = this.getServletContext().getNamedDispatcher("accueilJSP");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Cookie[] cookies = request.getCookies();

		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("nbRequete")) {
					String oldVal = cookie.getValue();
					int newIntVal = Integer.valueOf(oldVal) + 1;
					String newVal = String.valueOf(newIntVal);
					cookie.setValue(newVal);
					response.addCookie(cookie);
					request.setAttribute("nbRequete", newVal);
					System.out.println(newVal);
				}
			}
		}

		String colorCode = request.getParameter("color");
		session.setAttribute("colorCode", colorCode);
		RequestDispatcher rd = this.getServletContext().getNamedDispatcher("accueilJSP");
		rd.forward(request, response);

	}

}
