package fr.eni.javaee.module4.tp1.dal;

import java.util.List;

import fr.eni.javaee.module4.tp1.BusinessException;
import fr.eni.javaee.module4.tp1.bo.Aliment;

public interface AlimentDAO {


	public void insertAliment(Aliment aliment) throws BusinessException;
	
	public int getAlimentByLibelle(String libelle) throws BusinessException;

	public void setRepasAliment(int idRepas, int idAliment) throws BusinessException;

	public List<Aliment> getListeAlimentByIdRepas(int idRepas) throws BusinessException;	

}
