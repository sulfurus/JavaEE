package fr.eni.javaee.module4.tp1.dal;

import java.util.List;

import fr.eni.javaee.module4.tp1.BusinessException;
import fr.eni.javaee.module4.tp1.bo.Aliment;
import fr.eni.javaee.module4.tp1.bo.Repas;

public interface RepasDAO {

	
	
	public void insert(Repas repas) throws BusinessException;

	public List<Repas> selectAll() throws BusinessException;



	public List<Aliment> getListeAliment() throws BusinessException;
	

}
