package library.service.back;

import library.dao.operator.OperatorDAO;
import library.domain.operator.Operator;

public class OperatorUtilFacadeImpl implements OperatorUtilFacade {
	private OperatorDAO operatorDAO;

	public OperatorDAO getOperatorDAO() {
		return operatorDAO;
	}

	public void setOperatorDAO(OperatorDAO operatorDAO) {
		this.operatorDAO = operatorDAO;
	}

	// 管理员登录
	public Operator operatorLogin(Operator operator) {

		if (operatorDAO.findByProperty("name", operator.getName()).size() != 0
				&& operatorDAO.findByProperty("name", operator.getName())
						.get(0).getPassword().equals(operator.getPassword())) {
			return operatorDAO.findByProperty("name", operator.getName())
					.get(0);
		}
		return null;
	}

	// 管理员修改密码
	public boolean editPassword(Operator operator) {

		try {
			Operator o = operatorDAO.findById(operator.getId());
			o.setPassword(operator.getPassword());
			operatorDAO.merge(o);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
