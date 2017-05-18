package imcs.hibernate.util;

import java.io.Serializable;
import java.util.List;

import org.hibernate.transform.ResultTransformer;

import imcs.hibernate.beans.SalaryCount;

public class SalaryCountResultTransformer implements Serializable, ResultTransformer {
	
	private static final long serialVersionUID = 1L;

	public Object transformTuple(Object[] paramArrayOfObject, String[] paramArrayOfString) {
		SalaryCount salaryCount = new SalaryCount();
		
		salaryCount.setSalary((Double)paramArrayOfObject[0]);
		salaryCount.setCount((Long)paramArrayOfObject[1]);
		
		
		return salaryCount;
	}

	public List transformList(List paramList) {
		return paramList;
	}

}
