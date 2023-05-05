package Auftrag3;

public class Buch {
	private String titel;
	private String autor;
	private double preis;
	
	public Buch(String titel, String autor, double preis) {
		this.titel = titel;
		this.autor = autor;
		this.preis = preis;
	}

	public String getTitel() {
		return titel;
	}

	public String getAutor() {
		return autor;
	}

	public double getPreis() {
		return preis;
	}
	
}
