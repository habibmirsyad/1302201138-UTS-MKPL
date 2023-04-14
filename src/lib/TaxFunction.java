package lib;

public class TaxFunction {

	
	/*
	 * Fungsi untuk menghitung jumlah pajak penghasilan pegawai yang harus dibayarkan setahun.
	 * 
	 * Pajak dihitung sebagai 5% dari penghasilan bersih tahunan (gaji dan pemasukan bulanan lainnya dikalikan jumlah bulan bekerja dikurangi pemotongan) dikurangi penghasilan tidak kena pajak.
	 * 
	 * Jika pegawai belum menikah dan belum punya anak maka penghasilan tidak kena pajaknya adalah Rp 54.000.000.
	 * Jika pegawai sudah menikah maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000.
	 * Jika pegawai sudah memiliki anak maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000 per anak sampai anak ketiga.
	 * 
	 */
	
	
	public static int calculateTax(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible, boolean isMarried, int numberOfChildren) {
		// Regular = potongan pajak belum menikah dan belum punya anak
                // Married = potongan pajak sudah menikah (Married)
                // Child = potongan pajak punya 1 anak (Child)
                
                int regular = 54000000;
                int married = 4500000;
                int child = 1500000;
                        
                        
		int tax = (int) Math.round(0.05 * (((monthlySalary + otherMonthlyIncome) * numberOfMonthWorking) - deductible - regular));
		
		if (numberOfMonthWorking > 12) {
			System.err.println("More than 12 month working per year");
		}
		
                numberOfChildren = Math.min(numberOfChildren, 3);
		
		if (isMarried) {
			tax = (int) (tax + married + (numberOfChildren * child));
                }
                
		if (tax < 0) {
			return 0;
		}else {
			return tax;
		}
			 
	}
	
}
