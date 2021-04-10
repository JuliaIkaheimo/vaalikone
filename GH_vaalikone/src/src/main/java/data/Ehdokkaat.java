package data;

public class Ehdokkaat {
	private int ehdokas_id;
	private String etunimi;
	private String sukunimi;
	private String puolue;
	public Ehdokkaat(String ehdokas_id, String etunimi, String sukunimi, String puolue) {
		// TODO Auto-generated constructor stub
		setEhdokas_id(ehdokas_id);
		this.etunimi=etunimi;
		this.sukunimi=sukunimi;
		this.puolue=puolue;

	}
	public Ehdokkaat() {
		// TODO Auto-generated constructor stub
	}
	public int getEhdokas_id() {
		return ehdokas_id;
	}
	public void setEhdokas_id(int ehdokas_id) {
		this.ehdokas_id = ehdokas_id;
	}
	public void setEhdokas_id(String ehdokas_id) {
		try {
			this.ehdokas_id = Integer.parseInt(ehdokas_id);
		}
		catch(NumberFormatException | NullPointerException e) {
			//Do nothing - the value of id won't be changed
		}
	}
	public String getEtunimi() {
		return etunimi;
	}
	public void setEtunimi(String etunimi) {
		this.etunimi = etunimi;
	}
	public String getSukunimi() {
		return sukunimi;
	}
	public void setSukunimi(String sukunimi) {
		this.sukunimi = sukunimi;
	}
	public String getPuolue() {
		return puolue;
	}
	public void setPuolue(String puolue) {
		this.puolue= puolue;
	}
}
