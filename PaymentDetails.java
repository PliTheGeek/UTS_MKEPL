public class PaymentDetails {
    private int jumlahMalam;
    private double hargaPerMalam;
    private String kodeVoucher;
    private boolean sudahDibayar;
    private boolean statusAktif;

    // Constants
    private static final double EXTRA_GUEST_CHARGE = 100000;
    private static final double VOUCHER_DISCOUNT = 50000;

    // Constructor
    public PaymentDetails(int jumlahMalam, double hargaPerMalam,
            String kodeVoucher, boolean sudahDibayar, boolean statusAktif) {
        this.jumlahMalam = jumlahMalam;
        this.hargaPerMalam = hargaPerMalam;
        this.kodeVoucher = kodeVoucher;
        this.sudahDibayar = sudahDibayar;
        this.statusAktif = statusAktif;
    }

    // Business logic
    public double calculateTotal(int numberOfGuests) {
        if (!statusAktif)
            return 0;

        double total = jumlahMalam * hargaPerMalam;
        total += calculateExtraGuestCharge(numberOfGuests);
        total -= calculateVoucherDiscount();

        return total;
    }

    private double calculateExtraGuestCharge(int numberOfGuests) {
        return numberOfGuests > 2 ? (numberOfGuests - 2) * EXTRA_GUEST_CHARGE : 0;
    }

    private double calculateVoucherDiscount() {
        return (kodeVoucher != null && kodeVoucher.length() > 3) ? VOUCHER_DISCOUNT : 0;
    }

    // Getters and Setters
    public int getJumlahMalam() {
        return jumlahMalam;
    }

    public void setJumlahMalam(int jumlahMalam) {
        this.jumlahMalam = jumlahMalam;
    }

    public double getHargaPerMalam() {
        return hargaPerMalam;
    }

    public void setHargaPerMalam(double hargaPerMalam) {
        this.hargaPerMalam = hargaPerMalam;
    }

    public String getKodeVoucher() {
        return kodeVoucher;
    }

    public void setKodeVoucher(String kodeVoucher) {
        this.kodeVoucher = kodeVoucher;
    }

    public boolean isSudahDibayar() {
        return sudahDibayar;
    }

    public void setSudahDibayar(boolean sudahDibayar) {
        this.sudahDibayar = sudahDibayar;
    }

    public boolean isStatusAktif() {
        return statusAktif;
    }

    public void setStatusAktif(boolean statusAktif) {
        this.statusAktif = statusAktif;
    }
}