import java.util.HashSet;

public class GlobalData {
    public static int poin = 0; // Mulai dari nol
    public static HashSet<String> artefakDibeli = new HashSet<>();
    public static HashSet<String> levelTerselesaikan = new HashSet<>();

    // Harga tetap
    private static final int HARGA_KERIS = 98;
    private static final int HARGA_MAHKOTA = 210;
    private static final int HARGA_WAYANG = 1200;
    private static final int HARGA_CANDI = 15000;

    
    // Menyelesaikan level
    public static void selesaikanLevel(String namaLevel) {
        if (namaLevel == null || namaLevel.trim().isEmpty()) return;
        levelTerselesaikan.add(namaLevel.trim());
        FileManager.simpanData();
    }

    // Cek semua artefak sudah dibeli
    public static boolean semuaArtefakDibeli() {
        return artefakDibeli.contains("keris") &&
               artefakDibeli.contains("mahkota") &&
               artefakDibeli.contains("wayang") &&
               artefakDibeli.contains("candi");
    }

    // Tambah poin
    public static void tambahPoin(int jumlah) {
        if (jumlah <= 0) return;
        poin += jumlah;
        FileManager.simpanData();
    }

    // Beli artefak
    public static boolean beliArtefak(String nama) {
        if (nama == null || nama.trim().isEmpty()) {
            System.out.println("Nama artefak tidak boleh kosong!");
            return false;
        }

        nama = nama.trim().toLowerCase();

        if (artefakDibeli.contains(nama)) {
            System.out.println("Artefak '" + nama + "' sudah dibeli!");
            return false;
        }

        int harga = getHargaArtefak(nama);
        if (harga == -1) {
            System.out.println("Artefak '" + nama + "' tidak dikenal!");
            return false;
        }

        if (poin < harga) {
            System.out.println("Poin tidak cukup untuk membeli '" + nama + "'. Dibutuhkan: " + harga + ", tersedia: " + poin);
            return false;
        }

        poin -= harga;
        artefakDibeli.add(nama);
        FileManager.simpanData();
        System.out.println("Berhasil membeli '" + nama + "'.");
        return true;
    }

    // Harga artefak berdasarkan nama
    private static int getHargaArtefak(String nama) {
        switch (nama) {
            case "keris": return HARGA_KERIS;
            case "mahkota": return HARGA_MAHKOTA;
            case "wayang": return HARGA_WAYANG;
            case "candi": return HARGA_CANDI;
            default: return -1;
        }
    }

    // Reset semua data ke awal
    public static void reset() {
        poin = 0;
        artefakDibeli.clear();
        levelTerselesaikan.clear();
        FileManager.simpanData();
    }
}
