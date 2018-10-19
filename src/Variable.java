import java.util.Set;

public class Variable {
	
	private String name;
	private Set<Object> domain;
	
	//constructor
	public Variable(String name, Set<Object> domain) {
		this.name = name;
		this.domain = domain;
	}
	
	//Setters and Getters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Object> getDomain() {
		return domain;
	}
	public void setDomain(Set<Object> domain) {
		this.domain = domain;
	}



	
}
