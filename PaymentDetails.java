public class PaymentDetails {
    private int jumlahMalam;
    private double hargaPerMalam;
    private Voucher voucher;
    private StatusPembayaran status;

    private static final double EXTRA_GUEST_CHARGE = 100000;
    private static final int MAX_STANDARD_GUESTS = 2;  // Extract magic number

    public PaymentDetails(int jumlahMalam, double hargaPerMalam,
            String kodeVoucher, boolean sudahDibayar, boolean statusAktif) {
        this.jumlahMalam = jumlahMalam;
        this.hargaPerMalam = hargaPerMalam;
        this.voucher = new Voucher(kodeVoucher);
        
        // Fix the status assignment logic
        if (!statusAktif) {
            this.status = StatusPembayaran.TIDAK_AKTIF;
        } else {
            this.status = sudahDibayar ? 
                StatusPembayaran.SUDAH_DIBAYAR : 
                StatusPembayaran.BELUM_DIBAYAR;
        }
    }

    public PaymentDetails(double hargaPerMalam, String kodeVoucher) {
        this.hargaPerMalam = hargaPerMalam;
        this.voucher = new Voucher(kodeVoucher);
        this.jumlahMalam = 1;
        this.status = StatusPembayaran.BELUM_DIBAYAR;
    }

    public double hitungTotal(int jumlahTamu) {
        if (!status.isAktif()) {
            return 0;
        }
        return hitungBiayaKamar() + 
               hitungBiayaTambahan(jumlahTamu) - 
               hitungDiskonVoucher();
    }

    private double hitungBiayaKamar() {
        return jumlahMalam * hargaPerMalam;
    }

    private double hitungBiayaTambahan(int jumlahTamu) {
        return jumlahTamu > MAX_STANDARD_GUESTS ? 
            (jumlahTamu - MAX_STANDARD_GUESTS) * EXTRA_GUEST_CHARGE : 0;
    }

    private double hitungDiskonVoucher() {
        return voucher.hitungDiskon();
    }

    // Essential getters and setters
    public double getHargaPerMalam() {
        return hargaPerMalam;
    }

    public String getKodeVoucher() {
        return voucher.getKode();
    }

    public boolean isSudahDibayar() {
        return status.isSudahDibayar();
    }

    public void setSudahDibayar(boolean sudahDibayar) {
        this.status = sudahDibayar ? 
            StatusPembayaran.SUDAH_DIBAYAR : 
            StatusPembayaran.BELUM_DIBAYAR;
    }
}