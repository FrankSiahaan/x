package academic.driver;

import academic.model.Course;
import academic.model.Enrollment;
import academic.model.Lecturer;
import academic.model.Student;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author 12S23012 - Genesis Tombak Panjaitan
 * @author 12S23016 - Frank Niroy Siahaan
 */
public class Driver1 {

    public static void main(String[] _args) {
        //arraylist course
        ArrayList<Course> course = new ArrayList<>();
        //arraylist student
        ArrayList<Student> student = new ArrayList<>();
        //arraylist enroll
        ArrayList<Enrollment> enrol = new ArrayList<>();
        //arraylist lecturer
        ArrayList<Lecturer> lecturer = new ArrayList<>();
        String lecturerss[] = new String[100];
        Scanner input = new Scanner(System.in);
        String temp;
        String temp1;

        //objek course
        String id;
        String matkul;
        String sks;
        String nilai;
        String dosens;

        //objek student
        String nim;
        String nama;
        String tahun;
        String prodi;

        //objek enroll
        String ids;
        String nims;
        String year;
        String sems;
        String grade = "None";

        //objek lecturer
        String nidn;
        String nama_dosen;
        String inisial;
        String email;
        String prodi_dosen;

        boolean courseprinted = false;
        boolean studentprinted = false;

        int z = 0;
        while (true) {
            temp = input.nextLine();
            if (temp.equals("---")) {
                break;
            }
            String[] hasil = temp.split("#");
            temp1 = hasil[0];
            //pengecekan ke course
            if (temp1.equals("course-add")) {
                id = hasil[1];
                matkul = hasil[2];
                sks = hasil[3];
                nilai = hasil[4];
                dosens = hasil[5];
                String output = "";
                String output1 = "";
                String[] inisialdosen = dosens.split(",");
                for (int i = 0; i < inisialdosen.length; i++) {
                    for (Lecturer lecturers : lecturer) {
                        if (inisialdosen[i].contains(lecturers.getinisial())) {
                            output1 = id + "|" + matkul + "|" + sks + "|" + nilai + "|";
                            output = output + lecturers.getinisial() + " " + "(" + lecturers.getemail() + ")";

                            if (i < inisialdosen.length - 1) {
                                output = output + ";";
                            }
                        }
                    }
                }
                lecturerss[z] = output1 + output;
                z++;

                course.add(new Course(id, matkul, sks, nilai));

                //pengecekan ke student
            } else if (temp1.equals("student-add")) {
                nim = hasil[1];
                nama = hasil[2];
                tahun = hasil[3];
                prodi = hasil[4];
                student.add(new Student(nim, nama, tahun, prodi));
                //pengecekan ke enrol
            } else if (temp1.equals("enrollment-add")) {
                ids = hasil[1];
                nims = hasil[2];
                year = hasil[3];
                sems = hasil[4];

                boolean courseada = false;
                boolean studentada = false;

                for (Course courses : course) {
                    if (ids.contains(courses.getid())) {
                        courseada = true;
                    }
                }

                for (Student students : student) {
                    if (nims.contains(students.getnim())) {
                        studentada = true;
                    }
                }

                if (!studentada && !studentprinted) {
                    System.out.println("invalid student|" + nims);
                    studentprinted = true;
                }

                if (!courseada && !courseprinted) {
                    System.out.println("invalid course|" + ids);
                    courseprinted = true;
                }

                if (studentada && courseada) {
                    enrol.add(new Enrollment(ids, nims, year, sems, grade));
                }
            } else if (temp1.equals("lecturer-add")) {
                nidn = hasil[1];
                nama_dosen = hasil[2];
                inisial = hasil[3];
                email = hasil[4];
                prodi_dosen = hasil[5];

                boolean dosen_ada = false;
                for (Lecturer lecturers : lecturer) {
                    if (nidn.contains(lecturers.getnidn())) {
                        dosen_ada = true;
                    }
                }

                if (!dosen_ada) {
                    lecturer.add(new Lecturer(nidn, nama_dosen, inisial, email, prodi_dosen));
                }

            }
        }

        for (Lecturer p : lecturer) {
            System.out.println(p.toString());
        }

        for (int i = 0; i < z; i++) {
            System.out.println(lecturerss[i]);
        }

        for (Student j : student) {
            System.out.println(j.toString());
        }

        for (Enrollment k : enrol) {
            System.out.println(k.toString() + "|None");
        }

        input.close();
    }

}