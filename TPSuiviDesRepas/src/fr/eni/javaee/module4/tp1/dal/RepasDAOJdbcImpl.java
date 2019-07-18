package fr.eni.javaee.module4.tp1.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import fr.eni.javaee.module4.tp1.BusinessException;
import fr.eni.javaee.module4.tp1.bo.Aliment;
import fr.eni.javaee.module4.tp1.bo.Repas;

public class RepasDAOJdbcImpl implements RepasDAO {
	// Requete SQL pour la méthod Insert
	private static final String reqSql_Insert = "INSERT INTO Repas(date) VALUES(?)";
	// Requete SQL pour la méthod getListeAliment
	private static final String reqSql_getListeAliment = "SELECT id_Aliment,libelle FROM aliment where id_aliment "
			+ "in (select idaliment from repas_aliment where id_repas =?";
	// Requete SQL pour la méthod SelectALL
	private static final String reqSql_selectAll = "SELECT id_aliment FROM aliment where lower(libelle) = ?";

	@Override
	public void insert(Repas repas) throws BusinessException {
		if (repas == null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
			throw businessException;
		}

		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(reqSql_Insert, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setDate(1, (Date) repas.getDate());
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				repas.setId_repas(rs.getInt(1));
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
	public List<Repas> selectAll() throws BusinessException {
		List<Repas> listeRepas = null;
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(reqSql_selectAll);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				listeRepas.add(new Repas(rs.getInt(1), rs.getDate(2)));
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
		return listeRepas;
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Aliment> getListeAliment() throws BusinessException {
		List<Aliment> listeAliment = null;
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(reqSql_getListeAliment);
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
