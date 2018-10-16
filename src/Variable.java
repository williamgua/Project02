import java.util.Set;

public class Variable {
	
	private String name;
	private Set<?> domain;
	
	public Variable(String name, Set<?> domain) {
		this.name = name;
		this.domain = domain;
	}
	
}
