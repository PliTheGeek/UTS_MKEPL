public class Voucher {
    private String kodeVoucher;
    private static final double VOUCHER_DISCOUNT = 50000;

    public Voucher(String kodeVoucher) {
        this.kodeVoucher = kodeVoucher;
    }

    public double hitungDiskon() {
        return isValid() ? VOUCHER_DISCOUNT : 0;
    }

    private boolean isValid() {
        return kodeVoucher != null && kodeVoucher.length() > 3;
    }

    public String getKode() {
        return kodeVoucher;
    }
}