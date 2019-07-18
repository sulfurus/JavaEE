package fr.eni.javaee.module4.tp1.dal;

public abstract class DAOFactory {
	
	public static RepasDAO getRepasDAO() {
		return new RepasDAOJdbcImpl();
	}

	public static AlimentDAO getAlimentDAO() {

		return new AlimentDAOJdbcImpl();
	}
}
