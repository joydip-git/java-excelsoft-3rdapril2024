
public class SalesInfo implements Comparable<SalesInfo> {
	private int salesReportId;
	private Month month;
	private double salesAmount;
	private int unitSold;

	public SalesInfo() {
	}

	public SalesInfo(Month month, double salesAmount, int unitSold, int salesReportId) {
		this.month = month;
		this.salesAmount = salesAmount;
		this.unitSold = unitSold;
		this.salesReportId = salesReportId;
	}

	public Month getMonth() {
		return month;
	}

	public void setMonth(Month month) {
		this.month = month;
	}

	public double getSalesAmount() {
		return salesAmount;
	}

	public void setSalesAmount(double salesAmount) {
		this.salesAmount = salesAmount;
	}

	public int getUnitSold() {
		return unitSold;
	}

	public void setUnitSold(int unitSold) {
		this.unitSold = unitSold;
	}

	public int getSalesReportId() {
		return salesReportId;
	}

	public void setSalesReportId(int salesReportId) {
		this.salesReportId = salesReportId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		return month.hashCode() * prime;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		SalesInfo other = (SalesInfo) obj;

		return this.month.equals(other.month);
	}

	@Override
	public String toString() {
		return "Month: " + month + ", Amount: " + salesAmount + ", units sold: " + unitSold;
	}

	@Override
	public int compareTo(SalesInfo o) {
		if (this == o)
			return 0;

		return this.month.compareTo(o.month);
	}
}
