package fr.eni.javaee.module4.tp1.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import fr.eni.javaee.module4.tp1.BusinessException;
import fr.eni.javaee.module4.tp1.bo.Aliment;
import fr.eni.javaee.module4.tp1.bo.Repas;

public class RepasDAOJdbcImpl implements RepasDAO {
	// Requete SQL pour la méthod Insert
	private static final String reqSql_Insert = "INSERT INTO Repas(date,heure) VALUES(?,?)";
	// Requete SQL pour la méthod getListeAliment
	private static final String reqSql_getListeAliment = "SELECT id_Aliment,libelle FROM aliment where id_aliment "
			+ "in (select idaliment from repas_aliment where id_repas =?";
	// Requete SQL pour la méthod SelectALL
	private static final String reqSql_selectAll = "SELECT id_repas,date,heure FROM repas order by date,heure";

	@Override
	public void insert(Repas repas) throws BusinessException {
		if (repas == null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
			throw businessException;
		}

		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(reqSql_Insert, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setDate(1, java.sql.Date.valueOf(repas.getDate()));
			pstmt.setTime(2, java.sql.Time.valueOf(repas.getHeure()));
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
		List<Repas> listeRepas = new ArrayList<Repas>();
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(reqSql_selectAll);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				listeRepas.add(new Repas(rs.getInt(1), rs.getDate(2).toLocalDate(), rs.getTime(3).toLocalTime()));
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
	public List<Aliment> getListeAliment() throws BusinessException {
		List<Aliment> listeAliment = new ArrayList<Aliment>();
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(reqSql_getListeAliment);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
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
