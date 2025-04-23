import java.util.Date;

public class HotelRoomBooking {
    private BookingDetails bookingDetails;
    private PaymentDetails paymentDetails;
    private boolean statusAktif;

    // Keep the first constructor as it's already correctly using the new structure
    public HotelRoomBooking(String namaPemesan, String nomorKTP, String nomorTelepon, 
            String email, String jenisKelamin, String jenisKamar,
            int jumlahTamu, Date tanggalCheckin, Date tanggalCheckout,
            double hargaPerMalam, String kodeVoucher) {
        
        this.bookingDetails = new BookingDetails(namaPemesan, nomorKTP, nomorTelepon,
                email, jenisKelamin, jenisKamar, jumlahTamu, 
                tanggalCheckin, tanggalCheckout);
        
        this.paymentDetails = new PaymentDetails(hargaPerMalam, kodeVoucher);
        this.statusAktif = true;
    }

    // Update second constructor to use the new structure
    public HotelRoomBooking(String namaPemesan, String nomorKTP, String nomorTelepon, 
            String email, String jenisKelamin, String jenisKamar,
            int jumlahTamu, Date tanggalCheckin, Date tanggalCheckout,
            double hargaPerMalam, String kodeVoucher, boolean statusAktif, 
            boolean sudahDibayar) {
        
        this.bookingDetails = new BookingDetails(namaPemesan, nomorKTP, nomorTelepon,
                email, jenisKelamin, jenisKamar, jumlahTamu, 
                tanggalCheckin, tanggalCheckout);
        
        this.paymentDetails = new PaymentDetails(hargaPerMalam, kodeVoucher);
        this.paymentDetails.setSudahDibayar(sudahDibayar);
        this.statusAktif = statusAktif;
    }

    public void cetakDetailPemesanan() {
        System.out.println("===== DETAIL PEMESANAN KAMAR =====");
        System.out.println("Nama Pemesan : " + bookingDetails.getNamaPemesan());
        System.out.println("Jenis Kelamin: " + bookingDetails.getJenisKelamin());
        System.out.println("No. KTP      : " + bookingDetails.getNomorKTP());
        System.out.println("Telepon      : " + bookingDetails.getNomorTelepon());
        System.out.println("Email        : " + bookingDetails.getEmail());
        System.out.println("Jenis Kamar  : " + bookingDetails.getJenisKamar());
        System.out.println("Jumlah Tamu  : " + bookingDetails.getJumlahTamu());
        System.out.println("Harga/Malam  : " + paymentDetails.getHargaPerMalam());
        System.out.println("Check-in     : " + bookingDetails.getTanggalCheckin());
        System.out.println("Check-out    : " + bookingDetails.getTanggalCheckout());
        System.out.println("Status Aktif : " + statusAktif);
        System.out.println("Voucher      : " + paymentDetails.getKodeVoucher());
        System.out.println("Sudah Dibayar: " + paymentDetails.isSudahDibayar());
        System.out.println("Total Biaya  : Rp " + hitungTotalBiaya());
        System.out.println("Tipe Tamu    : " + klasifikasiTamu());
        System.out.println("===================================");
    }

    public void redeemVoucher(String kode) {
        paymentDetails.setKodeVoucher(kode);
    }

    public double hitungTotalBiaya() {
        if (!statusAktif) {
            return 0;
        }
        return paymentDetails.hitungTotal(bookingDetails.getJumlahTamu());
    }

    public String klasifikasiTamu() {
        int jumlahTamu = bookingDetails.getJumlahTamu();
        if (jumlahTamu == 1) return "Individu";
        if (jumlahTamu == 2) return "Pasangan";
        return "Keluarga";
    }

    // Essential getters and setters
    public boolean isStatusAktif() {
        return statusAktif;
    }

    public void setStatusAktif(boolean statusAktif) {
        this.statusAktif = statusAktif;
    }

    public BookingDetails getBookingDetails() {
        return bookingDetails;
    }

    public PaymentDetails getPaymentDetails() {
        return paymentDetails;
    }
}
