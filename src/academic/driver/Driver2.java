package academic.driver;

import academic.model.Course;
import academic.model.Enrollment;
import academic.model.Lecturer;
import academic.model.Student;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @autor 12S23012 - Genesis Tombak Panjaitan
 * @autor 12S23016 - Frank Niroy Siahaan
 */
public class Driver2 {
    public static void main(String[] _args) {
        //arraylist course
        ArrayList<Course> course = new ArrayList<>();
        //arraylist student
        ArrayList<Student> student = new ArrayList<>();
        //arraylist enroll
        ArrayList<Enrollment> enrol = new ArrayList<>();
        //arraylist lecturer
        ArrayList<Lecturer> lecturer = new ArrayList<>();
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

        //objek enrollgrade
        String ids_;
        String nims_;
        String year_;
        String sems_;
        String grade_;

        //objek details
        String nims1;

        boolean courseprinted = false;
        boolean studentprinted = false;

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
                System.out.println(output1 + output);

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
            } else if (temp1.equals("enrollment-grade")) {
                ids_ = hasil[1];
                nims_ = hasil[2];
                year_ = hasil[3];
                sems_ = hasil[4];
                grade_ = hasil[5];

                for (Enrollment s : enrol) {
                    if (s.getids().contains(ids_) && s.getnims().contains(nims_)) {
                        s.setgrade(grade_);
                    }
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

            } else if (temp1.equals("student-details")) {
                String output = "";
                Boolean cekstudent = false;
                Boolean printed = false;
                Double index = 0.0;
                Double total = 0.0;
                Double jumlah = 0.0;
                Double jumlahs = 0.0;
                int jumlah1 = 0;
                nims1 = hasil[1];
                
                for (Student p : student) {
                    total = 0.0;
                    jumlah1 = 0;
                    if (p.getnim().contains(nims1)) {
                        for (Enrollment l : enrol) {
                            if (l.getnims().contains(nims1)) {
                                switch (l.getgrade()) {
                                    case "A":
                                        index = 4.0;
                                        break;
                                    case "AB":
                                        index = 3.5;
                                        break;
                                    case "B":
                                        index = 3.0;
                                        break;
                                    case "BC":
                                        index = 2.5;
                                        break;
                                    case "C":
                                        index = 2.0;
                                        break;
                                    case "D":
                                        index = 1.5;
                                        break;
                                    case "E":
                                        index = 1.0;
                                        break;
                                    default:
                                        index = 0.0;
                                        break;
                                }
                                for (Course a : course) {
                                    if (l.getids().contains(a.getid())) {
                                        jumlah = jumlah.valueOf(a.getsks());
                                        jumlahs = jumlahs + jumlah;
                                        total = total + (jumlah * index);
                                    }
                                }
                            }
                        }

                        jumlah1 = jumlahs.intValue();

                        for (Student z : student) {
                            if (z.getnim().contains(nims1)) {
                                output = z.toString() + "|" + String.format("%.2f", total / jumlahs) + "|" + jumlah1;
                            }
                        }
                        for (Student c : student) {
                            if (c.getnim().contains(nims1)) {
                                cekstudent = true;
                            }

                            if (cekstudent && !printed) {
                                System.out.println(output);
                                printed = true;
                            }
                        }
                    }
                }

            }
        }

        for (Lecturer p : lecturer) {
            System.out.println(p.toString());
        }

        for (Course c : course) {
            System.out.println(c.toString());
        }

        for (Student j : student) {
            System.out.println(j.toString());
        }

        for (Enrollment k : enrol) {
            System.out.println(k.toString());
        }

        input.close();
    }

}