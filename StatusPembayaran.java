public enum StatusPembayaran {
    BELUM_DIBAYAR,
    SUDAH_DIBAYAR,
    AKTIF,
    TIDAK_AKTIF,
    DIBATALKAN;

    public boolean isSudahDibayar() {
        return this == SUDAH_DIBAYAR;
    }

    public boolean isAktif() {
        return this != DIBATALKAN;
    }
}