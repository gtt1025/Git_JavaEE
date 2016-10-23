package library.service.back;

import library.domain.operator.Operator;

public interface OperatorUtilFacade {
	public Operator operatorLogin(Operator operator);

	public boolean editPassword(Operator operator);


}
