package data;

public class Kysymykset {
	private int kysymys_id;
	private String kysymys;
	public Kysymykset(String kysymys_id, String kysymys) {
		// TODO Auto-generated constructor stub
		setId(kysymys_id);
		this.kysymys=kysymys;

	}
	public Kysymykset() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return kysymys_id;
	}
	public void setId(int kysymys_id) {
		this.kysymys_id = kysymys_id;
	}
	public void setId(String kysymys_id) {
		try {
			this.kysymys_id = Integer.parseInt(kysymys_id);
		}
		catch(NumberFormatException | NullPointerException e) {
			//Do nothing - the value of id won't be changed
		}
	}
	public String getKysymys() {
		return kysymys;
	}
	public void setKysymys(String kysymys) {
		this.kysymys = kysymys;
	}

}