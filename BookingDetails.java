import java.util.Date;

public class BookingDetails {
    private String namaPemesan;
    private String nomorKTP;
    private String nomorTelepon;
    private String email;
    private String jenisKelamin;
    private String jenisKamar;
    private int jumlahTamu;
    private Date tanggalCheckin;
    private Date tanggalCheckout;

    // Constructor
    public BookingDetails(String namaPemesan, String nomorKTP, String nomorTelepon,
            String email, String jenisKelamin, String jenisKamar,
            int jumlahTamu, Date tanggalCheckin, Date tanggalCheckout) {
        this.namaPemesan = namaPemesan;
        this.nomorKTP = nomorKTP;
        this.nomorTelepon = nomorTelepon;
        this.email = email;
        this.jenisKelamin = jenisKelamin;
        this.jenisKamar = jenisKamar;
        this.jumlahTamu = jumlahTamu;
        this.tanggalCheckin = tanggalCheckin;
        this.tanggalCheckout = tanggalCheckout;
    }

    // Getters and Setters
    public String getNamaPemesan() {
        return namaPemesan;
    }

    public void setNamaPemesan(String namaPemesan) {
        this.namaPemesan = namaPemesan;
    }

    public String getNomorKTP() {
        return nomorKTP;
    }

    public void setNomorKTP(String nomorKTP) {
        this.nomorKTP = nomorKTP;
    }

    public String getNomorTelepon() {
        return nomorTelepon;
    }

    public void setNomorTelepon(String nomorTelepon) {
        this.nomorTelepon = nomorTelepon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getJenisKamar() {
        return jenisKamar;
    }

    public void setJenisKamar(String jenisKamar) {
        this.jenisKamar = jenisKamar;
    }

    public int getJumlahTamu() {
        return jumlahTamu;
    }

    public void setJumlahTamu(int jumlahTamu) {
        this.jumlahTamu = jumlahTamu;
    }

    public Date getTanggalCheckin() {
        return tanggalCheckin;
    }

    public void setTanggalCheckin(Date tanggalCheckin) {
        this.tanggalCheckin = tanggalCheckin;
    }

    public Date getTanggalCheckout() {
        return tanggalCheckout;
    }

    public void setTanggalCheckout(Date tanggalCheckout) {
        this.tanggalCheckout = tanggalCheckout;
    }
}