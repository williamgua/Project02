import java.util.HashSet;
import java.util.Set;

public abstract class CSP {
	
	protected abstract Set<Variable> variables();
	protected abstract Set<Constraint> constraints();
	
//	public CSP() {
//		variables = new HashSet<>();
//		constraints = new HashSet<>();
//	}
	
}
