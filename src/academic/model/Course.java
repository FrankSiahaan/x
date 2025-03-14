package academic.model;

/**
 * @author 12S23012 - Genesis Tombak Panjaitan
 * @author 12S23016 - Frank Niroy Siahaan
 */
public class Course {
    private final String id;
    private final String matkul;
    private final String sks;
    private final String nilai;

    public Course(String _id, String _matkul, String _sks, String _nilai) {
        this.id = _id;
        this.matkul = _matkul;
        this.sks = _sks;
        this.nilai = _nilai;
    }

    public String getid() {
        return this.id;
    }

    public String getmatkul() {
        return this.matkul;
    }

    public String getsks() {
        return this.sks;
    }

    public String getnilai() {
        return this.nilai;
    }

    @Override
    public String toString() {
        return this.id + "|" + this.matkul + "|" + this.sks + "|" + this.nilai;
    }
}