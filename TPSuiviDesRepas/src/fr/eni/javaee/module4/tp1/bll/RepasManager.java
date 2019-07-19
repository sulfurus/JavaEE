package fr.eni.javaee.module4.tp1.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.javaee.module4.tp1.BusinessException;
import fr.eni.javaee.module4.tp1.bo.Aliment;
import fr.eni.javaee.module4.tp1.bo.Repas;
import fr.eni.javaee.module4.tp1.dal.AlimentDAO;
import fr.eni.javaee.module4.tp1.dal.DAOFactory;
import fr.eni.javaee.module4.tp1.dal.RepasDAO;

public class RepasManager {

	private RepasDAO repasDAO;
	private AlimentDAO alimentDAO = DAOFactory.getAlimentDAO();
	private AlimentManager alimentManager = new AlimentManager();

	public RepasManager() {
		this.repasDAO = DAOFactory.getRepasDAO();
	}

	public int ajouterRepas(Repas repas) throws BusinessException {
		repasDAO.insert(repas);
	
		return repas.getId_repas();
	}

	public void addListeAliment(int idRepas, List<Aliment> listeAliment) throws BusinessException {
		for (Aliment aliment : listeAliment) {
			alimentManager.insert(aliment);
			alimentDAO.setRepasAliment(idRepas, aliment.getId_aliment());
		}
	}

	public List<Aliment> getListeAlimentByIdRepas(int idRepas) throws BusinessException {
		List<Aliment> listeAliment = new ArrayList<Aliment>();
		listeAliment = alimentDAO.getListeAlimentByIdRepas(idRepas);
		return listeAliment;
	}

	public List<Repas> getListeRepas() throws BusinessException {
		List<Repas> listeRepas = new ArrayList<Repas>();
		listeRepas = repasDAO.selectAll();
		return listeRepas;
	}
}
