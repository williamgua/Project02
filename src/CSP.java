import java.util.HashSet;
import java.util.Set;

public abstract class CSP {
	
	private Set<Variable> variables;
	private Set<Constraint> constraints;
	
	public CSP() {
		variables = new HashSet<>();
		constraints = new HashSet<>();
	}
	
}
