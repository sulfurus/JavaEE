package fr.eni.javaee.module2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletAvecParametreInitialisationAnnotation
 */
@WebServlet(urlPatterns = "/modules/module2/ServletAvecParametreInitialisationAnnotation", initParams = {
		@WebInitParam(name = "NOM_PARAMETRE", value = "VALEUR_PARAMETRE") })
public class ServletAvecParametreInitialisationAnnotation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String valeurParametre;

	@Override
	public void init() throws ServletException {
		this.valeurParametre = this.getInitParameter("NOM_PARAMETRE");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("NOM_PARAMETRE avec annotation: ").append(this.valeurParametre);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
