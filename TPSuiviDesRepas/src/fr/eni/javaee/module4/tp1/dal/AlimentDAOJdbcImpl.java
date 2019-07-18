package fr.eni.javaee.module4.tp1.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import fr.eni.javaee.module4.tp1.BusinessException;
import fr.eni.javaee.module4.tp1.bo.Aliment;

public class AlimentDAOJdbcImpl implements AlimentDAO {
	// Requete SQL pour la méthod Insert
	private static final String reqSql_Insert = "INSERT INTO Aliment(libelle) VALUES(?)";
	// Requete SQL pour la méthod getListeAlimentByIdRepas
	private static final String reqSql_getListeAlimentByIdRepas = "SELECT id_Aliment,libelle FROM aliment where id_aliment "
			+ "in (select idaliment from repas_aliment where id_repas =?";
	// Requete SQL pour la méthod getAlimentByLibelle
	private static final String reqSql_getAlimentByLibelle = "SELECT TOP 1 id_aliment FROM aliment where lower(libelle) = ?";
	// Requete SQL pour la méthod Insert setRepasAliment
	private static final String reqSql_setRepasAliment = "INSERT INTO repas_aliment (id_aliment,id_repas) VALUES(?,?)";

	@Override
	public void insertAliment(Aliment aliment) throws BusinessException {
		if (aliment == null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
			throw businessException;
		}

		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(reqSql_Insert, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, aliment.getLibelle());
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				aliment.setId_aliment(rs.getInt(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			if (e.getMessage().contains("CK_AVIS_note")) {
				businessException.ajouterErreur(CodesResultatDAL.INSERT_AVIS_NOTE_ECHEC);
			} else {
				businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
			}
			throw businessException;
		}

	}

	@Override
	public int getAlimentByLibelle(String libelle) throws BusinessException {
		int idAliment = -1;
		if (libelle == null || libelle.trim().isEmpty()) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
			throw businessException;
		}
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(reqSql_getAlimentByLibelle);
			pstmt.setString(1, libelle.toLowerCase());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				idAliment= rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			if (e.getMessage().contains("CK_AVIS_note")) {
				businessException.ajouterErreur(CodesResultatDAL.INSERT_AVIS_NOTE_ECHEC);
			} else {
				businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
			}
			throw businessException;
		}
		return idAliment;
	}

	@Override
	public void setRepasAliment(int idRepas, int idAliment) throws BusinessException {
	
		if (idRepas <= 0 || idAliment <= 0 ) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
			throw businessException;
		}
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(reqSql_setRepasAliment);			
			
			pstmt.setInt(1, idAliment);
			pstmt.setInt(2, idRepas);
			pstmt.executeUpdate();		
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			if (e.getMessage().contains("CK_AVIS_note")) {
				businessException.ajouterErreur(CodesResultatDAL.INSERT_AVIS_NOTE_ECHEC);
			} else {
				businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
			}
			throw businessException;
		}
		
		

	}

	@Override
	public List<Aliment> getListeAlimentByIdRepas(int idRepas) throws BusinessException {
		List<Aliment> listeAliment = null;
		if (idRepas <= 0) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
			throw businessException;
		}
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(reqSql_getListeAlimentByIdRepas);
			pstmt.setString(1, String.valueOf(idRepas));
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				listeAliment.add(new Aliment(rs.getInt(1), rs.getString(2)));
			}
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			if (e.getMessage().contains("CK_AVIS_note")) {
				businessException.ajouterErreur(CodesResultatDAL.INSERT_AVIS_NOTE_ECHEC);
			} else {
				businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
			}
			throw businessException;
		}
		return listeAliment;
	}

}
