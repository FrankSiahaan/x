package academic.model;

/**
 * @author 12S23012 - Genesis Tombak Panjaitan
 * @author 12S23016 - Frank Niroy Siahaan
 */

public class Lecturer {
    private final String nidn;
    private final String nama_dosen;
    private final String inisial;
    private final String email;
    private final String prodi_dosen;

    public Lecturer(String _nidn, String _nama_dosen, String _inisial, String _email, String _prodi_dosen){
        this.nidn = _nidn;
        this.nama_dosen = _nama_dosen;
        this.inisial = _inisial;
        this.email = _email;
        this.prodi_dosen = _prodi_dosen;
    }

    public String getnidn() {
        return this.nidn;
    }

    public String getnama_dosen() {
        return this.nama_dosen;
    }

    public String getinisial() {
        return this.inisial;
    }

    public String getemail() {
        return this.email;
    }

    public String getprodi_dosen() {
        return this.prodi_dosen;
    }

    @Override
    public String toString() {
        return this.nidn + "|" + this.nama_dosen + "|" + this.inisial + "|" + this.email + "|" + this.prodi_dosen;
    }
}
