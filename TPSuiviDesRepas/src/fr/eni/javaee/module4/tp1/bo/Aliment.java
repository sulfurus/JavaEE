package fr.eni.javaee.module4.tp1.bo;

public class Aliment {

	private int id_aliment;
	private String libelle;
	
	public int getId_aliment() {
		return id_aliment;
	}

	public void setId_aliment(int id_aliment) {
		this.id_aliment = id_aliment;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Aliment(int id_aliment, String libelle) {
		setLibelle(libelle);
		setId_aliment(id_aliment);
	}

	public Aliment(String libelle) {
		setLibelle(libelle);
	}

}
