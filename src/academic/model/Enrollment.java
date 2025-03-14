package academic.model;

/**
 * @author 12S23012 - Genesis Tombak Panjaitan
 * @author 12S23016 - Frank Niroy Siahaan
 */
public class Enrollment {
    private final String ids;
    private final String nims;
    private final String year;
    private final String sems;
    private String grade;

    public Enrollment(String _ids, String _nims, String _year, String _sems, String _grade) {
        this.ids = _ids;
        this.nims = _nims;
        this.year = _year;
        this.sems = _sems;
        this.grade = _grade;
    }

    public String getids() {
        return this.ids;
    }

    public String getnims() {
        return this.nims;
    }

    public String getyear() {
        return this.year;
    }

    public String getsems() {
        return this.sems;
    }

    public String getgrade() {
        return this.grade;
    }

    public void setgrade(String _grade) {
        this.grade = _grade;
    }

    @Override
    public String toString() {
        return this.ids + "|" + this.nims + "|" + this.year + "|" + this.sems + "|" + this.grade;
    }



}