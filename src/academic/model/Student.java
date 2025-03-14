package academic.model;

/**
 * @author 12S23012 - Genesis Tombak Panjaitan
 * @author 12S23016 - Frank Niroy Siahaan
 */
public class Student {
    private final String nim;
    private final String nama;
    private final String tahun;
    private final String prodi;

    public Student(String _nim, String _nama, String _tahun, String _prodi) {
        this.nim = _nim;
        this.nama = _nama;
        this.tahun = _tahun;
        this.prodi = _prodi;
    }

    public String getnim() {
        return this.nim;
    }

    public String getnama () {
        return this.nama;
    }

    public String gettahun() {
        return this.tahun;
    }

    public String getprodi () {
        return this.prodi;
    }
 
    @Override
    public String toString() {
        return this.nim + "|" + this.nama + "|" + this.tahun + "|" + this.prodi;
    }
}