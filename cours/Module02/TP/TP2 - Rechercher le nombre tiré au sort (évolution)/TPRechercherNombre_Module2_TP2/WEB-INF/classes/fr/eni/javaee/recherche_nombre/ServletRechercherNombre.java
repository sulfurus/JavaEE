package fr.eni.javaee.recherche_nombre;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

/**
 * Servlet implementation class ServletRechercherNombre
 */
/*
@WebServlet(
		urlPatterns="/ServletRechercherNombre",
		initParams= {
						@WebInitParam(name="BORNE_MIN",value="10"),
						@WebInitParam(name="BORNE_MAX",value="15")
					}
		)
*/
public class ServletRechercherNombre extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private int nombreATrouver;
	private boolean win;
	private int borneMin=0;
	private int borneMax=10;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRechercherNombre() {
        super();
        //Impossibilité de lire le fichier web.xml
    }
    
    @Override
    public void init() throws ServletException {
    	if(this.getInitParameter("BORNE_MIN")!=null &&
    			!this.getInitParameter("BORNE_MIN").equals(""))
    	{
    		String valeurLue=this.getInitParameter("BORNE_MIN");
			if(StringUtils.isNumeric(valeurLue))
			{
				this.borneMin=Integer.parseInt(valeurLue);
			}
    	}
    	
    	if(this.getInitParameter("BORNE_MAX")!=null &&
    			!this.getInitParameter("BORNE_MAX").equals(""))
    	{
    		String valeurLue=this.getInitParameter("BORNE_MAX");
			if(StringUtils.isNumeric(valeurLue))
			{
				this.borneMax=Integer.parseInt(valeurLue);
			}
    	}
			
    	//On recherche entre 0 inclus et la différence max-min+1 (car valeur max exclue)
    	//On ajoute ensuite borneMin pour arriver dans la plage ([borneMin;borneMax])
    	this.nombreATrouver=new Random().nextInt(this.borneMax-this.borneMin+1)+this.borneMin;
    	this.win=false;
    	System.out.println(this.nombreATrouver);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Récupérer la valeur
		String nombreSaisie = request.getParameter("nombre");
		if(nombreSaisie.equals(String.valueOf(this.nombreATrouver)) && !this.win)
		{
			response.sendRedirect("succes.html");
			this.win=true;
		}
		else
		{
			response.sendRedirect("echec.html");
		}
	}

}















