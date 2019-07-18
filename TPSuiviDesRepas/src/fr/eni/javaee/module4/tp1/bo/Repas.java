package fr.eni.javaee.module4.tp1.bo;

import java.util.ArrayList;
import java.util.Date;

public class Repas {
	private int idRepas;
	private Date datetime;
	private ArrayList<Aliment> listAliment = new ArrayList<Aliment>();

	public ArrayList<Aliment> getListAliment() {
		return listAliment;
	}

	public void insertAliment(Aliment aliment) {
		listAliment.add(new Aliment(aliment.getLibelle()));
	}

	public int getId_repas() {
		return idRepas;
	}

	public void setId_repas(int idRepas) {
		this.idRepas = idRepas;
	}

	public Date getDate() {
		return datetime;
	}

	public void setDate(Date date) {
		this.datetime = date;
	}

	public Repas(int idRepas, Date date) {
		setId_repas(idRepas);
		setDate(date);
	}

	public Repas(Date date) {
		setDate(date);
	}

}
