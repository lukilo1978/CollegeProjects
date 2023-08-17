package ProjectJava;

public class Player {
	
	String name;
	String symbol;
	
	public Player(String name, String symbol){
		
		this.name = name;
		this.symbol = symbol;
		
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		
		this.name = name;
	}
	
	public String getSymbol() {
		
		return symbol;
	}
	
	public void seSymbol(String symbol) {
		
		this.symbol = symbol;
	}

}
