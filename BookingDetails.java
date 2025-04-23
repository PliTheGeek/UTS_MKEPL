import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class BookingDetails {
    private static final int MILLISECONDS_PER_DAY = 1000 * 60 * 60 * 24;
    private static final int MIN_KTP_LENGTH = 16;
    private static final int MIN_PHONE_LENGTH = 10;
    
    private final String namaPemesan;
    private final String nomorKTP;
    private final String nomorTelepon;
    private final String email;
    private final JenisKelamin jenisKelamin;
    private final JenisKamar jenisKamar;
    private final int jumlahTamu;
    private final LocalDate tanggalCheckin;
    private final LocalDate tanggalCheckout;

    private BookingDetails(Builder builder) {
        this.namaPemesan = builder.namaPemesan;
        this.nomorKTP = builder.nomorKTP;
        this.nomorTelepon = builder.nomorTelepon;
        this.email = builder.email;
        this.jenisKelamin = builder.jenisKelamin;
        this.jenisKamar = builder.jenisKamar;
        this.jumlahTamu = builder.jumlahTamu;
        this.tanggalCheckin = builder.tanggalCheckin;
        this.tanggalCheckout = builder.tanggalCheckout;
        validateBooking();
    }

    private void validateBooking() {
        if (tanggalCheckout.isBefore(tanggalCheckin)) {
            throw new IllegalArgumentException("Checkout date cannot be before checkin date");
        }
        if (jumlahTamu <= 0) {
            throw new IllegalArgumentException("Number of guests must be positive");
        }
    }

    public static class Builder {
        private String namaPemesan;
        private String nomorKTP;
        private String nomorTelepon;
        private String email;
        private JenisKelamin jenisKelamin;
        private JenisKamar jenisKamar;
        private int jumlahTamu;
        private LocalDate tanggalCheckin;
        private LocalDate tanggalCheckout;

        public Builder namaPemesan(String namaPemesan) {
            if (namaPemesan == null || namaPemesan.trim().isEmpty()) {
                throw new IllegalArgumentException("Name cannot be empty");
            }
            this.namaPemesan = namaPemesan;
            return this;
        }

        public Builder nomorKTP(String nomorKTP) {
            if (nomorKTP == null || nomorKTP.length() < MIN_KTP_LENGTH) {
                throw new IllegalArgumentException("Invalid KTP number");
            }
            this.nomorKTP = nomorKTP;
            return this;
        }

        // ... other builder methods with validation ...

        public BookingDetails build() {
            validateBuilderState();
            return new BookingDetails(this);
        }

        private void validateBuilderState() {
            if (tanggalCheckin == null || tanggalCheckout == null) {
                throw new IllegalStateException("Dates cannot be null");
            }
            // Add other validations
        }
    }

    // Essential enums
    public enum JenisKelamin {
        PRIA, WANITA
    }

    public enum JenisKamar {
        STANDARD, DELUXE, SUITE
    }

    // Getters only - make class immutable
    public String getNamaPemesan() {
        return namaPemesan;
    }

    // ... other getters ...

    // Business logic methods
    public long calculateDurationOfStay() {
        return ChronoUnit.DAYS.between(tanggalCheckin, tanggalCheckout);
    }
}