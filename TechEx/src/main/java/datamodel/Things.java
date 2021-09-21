package datamodel;

public class Things {
	private int id;
	private String thing;
	
	public Things(int id, String thing) {
		this.id = id;
		this.thing = thing;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getThing() {
		return thing;
	}
	public void setThing(String thing) {
		this.thing = thing;
	}
}
