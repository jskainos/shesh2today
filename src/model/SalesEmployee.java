/**
 * 
 */
package model;

/**
 * @author trainee
 *
 */
public class SalesEmployee extends Employee {
	
	private float commissionRate;
	private float totalSales;

	/**
	 * 
	 */
	public SalesEmployee() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name
	 * @param niNumber
	 * @param department
	 * @param dob
	 * @param address
	 * @param iban
	 * @param salary
	 */
	public SalesEmployee(String name, String niNumber, String department, String dob, String address, String iban,
			String salary) {
		super(name, niNumber, department, dob, address, iban, salary);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name
	 * @param dob
	 * @param niNumber
	 * @param department
	 */
	public SalesEmployee(String name, String dob, String niNumber, String department) {
		super(name, dob, niNumber, department);
		// TODO Auto-generated constructor stub
	}
	
	public SalesEmployee(String name, String dob, String niNumber, String department, float commissionRate, float totalSales) {
		super(name, dob, niNumber, department);
		this.commissionRate = commissionRate;
		this.totalSales = totalSales;
	}

	public float getCommissionRate() {
		return commissionRate;
	}

	public void setCommissionRate(float commissionRate) {
		this.commissionRate = commissionRate;
	}

	public float getTotalSales() {
		return totalSales;
	}

	public void setTotalSales(float totalSales) {
		this.totalSales = totalSales;
	}

}
