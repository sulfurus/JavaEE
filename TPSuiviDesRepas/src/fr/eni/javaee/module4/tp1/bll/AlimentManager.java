package fr.eni.javaee.module4.tp1.bll;

import java.util.List;

import fr.eni.javaee.module4.tp1.BusinessException;
import fr.eni.javaee.module4.tp1.bo.Aliment;
import fr.eni.javaee.module4.tp1.dal.AlimentDAO;
import fr.eni.javaee.module4.tp1.dal.DAOFactory;

public class AlimentManager {

	private AlimentDAO alimentDAO;

	public AlimentManager() {
		this.alimentDAO = DAOFactory.getAlimentDAO();
	}

	public void insert(Aliment aliment) throws BusinessException {
		int idAliment = alimentDAO.getAlimentByLibelle(aliment.getLibelle());
		if (idAliment < 0) {
			alimentDAO.insertAliment(aliment);
		}
	}

	public List<Aliment> selectByIdRepas(int idRepas) throws BusinessException {
		List<Aliment> listeAliment = null;
		listeAliment = alimentDAO.getListeAlimentByIdRepas(idRepas);
		return listeAliment;
	}

}
