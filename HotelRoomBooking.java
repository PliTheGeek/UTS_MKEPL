

public class HotelRoomBooking {
    private BookingDetails bookingDetails;
    private PaymentDetails paymentDetails;
    private BookingStatus status;

    public enum BookingStatus {
        ACTIVE, INACTIVE
    }

    private HotelRoomBooking(Builder builder) {
        this.bookingDetails = builder.bookingDetails;
        this.paymentDetails = builder.paymentDetails;
        this.status = builder.status;
    }

    public static class Builder {
        private BookingDetails bookingDetails;
        private PaymentDetails paymentDetails;
        private BookingStatus status = BookingStatus.ACTIVE;

        public Builder bookingDetails(BookingDetails details) {
            this.bookingDetails = details;
            return this;
        }

        public Builder paymentDetails(PaymentDetails details) {
            this.paymentDetails = details;
            return this;
        }

        public Builder status(BookingStatus status) {
            this.status = status;
            return this;
        }

        public HotelRoomBooking build() {
            validateState();
            return new HotelRoomBooking(this);
        }

        private void validateState() {
            if (bookingDetails == null || paymentDetails == null) {
                throw new IllegalStateException("Booking and payment details are required");
            }
        }
    }

    public void cetakDetailPemesanan() {
        System.out.println("===== DETAIL PEMESANAN KAMAR =====");
        // Print booking details
        System.out.println("Nama Pemesan : " + bookingDetails.getNamaPemesan());
        System.out.println("Jenis Kamar  : " + bookingDetails.getJenisKamar());
        System.out.println("Jumlah Tamu  : " + bookingDetails.getJumlahTamu());
        
        // Print payment details
        System.out.println("Harga/Malam  : Rp " + paymentDetails.getHargaPerMalam());
        System.out.println("Kode Voucher : " + paymentDetails.getKodeVoucher());
        System.out.println("Status Bayar : " + (paymentDetails.isSudahDibayar() ? "Sudah Dibayar" : "Belum Dibayar"));
        
        // Print booking status and totals
        System.out.println("Status Aktif : " + status);
        System.out.println("Total Biaya  : Rp " + hitungTotalBiaya());
        System.out.println("Tipe Tamu    : " + klasifikasiTamu());
        System.out.println("===================================");
    }

    public double hitungTotalBiaya() {
        return status == BookingStatus.ACTIVE ? 
            paymentDetails.hitungTotal(bookingDetails.getJumlahTamu()) : 0;
    }

    public String klasifikasiTamu() {
        int jumlahTamu = bookingDetails.getJumlahTamu();
        switch (jumlahTamu) {
            case 1:
                return "Individu";
            case 2:
                return "Pasangan";
            default:
                return "Keluarga";
        }
    }

    // Essential getters
    public BookingDetails getBookingDetails() {
        return bookingDetails;
    }

    public PaymentDetails getPaymentDetails() {
        return paymentDetails;
    }

    public BookingStatus getStatus() {
        return status;
    }
}
