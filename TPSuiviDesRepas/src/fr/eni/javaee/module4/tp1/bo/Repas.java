package fr.eni.javaee.module4.tp1.bo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Repas {
	private int idRepas;
	private LocalDate date;
	private LocalTime heure;
	private ArrayList<Aliment> listAliment = new ArrayList<Aliment>();

	public ArrayList<Aliment> getListAliment() {
		return listAliment;
	}

	public Repas(int idRepas, LocalDate date, LocalTime heure) {
		setDate(date);
		setHeure(heure);
		setId_repas(idRepas);

	}

	public Repas(LocalDate date, LocalTime heure) {
		setDate(date);
		setHeure(heure);
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

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Repas(int idRepas, LocalDate date) {
		setId_repas(idRepas);
		setDate(date);
	}

	public LocalTime getHeure() {
		return heure;
	}

	public void setHeure(LocalTime heure) {
		this.heure = heure;
	}

}
