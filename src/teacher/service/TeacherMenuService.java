package teacher.service;


import common.RunnableAsMenu;
import teacher.TeacherRegistrationException;
import teacher.entity.Teacher;
import teacher.repo.TeacherRepo;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;


public class TeacherMenuService implements RunnableAsMenu {

    private final TeacherRepo repo=new TeacherRepo();
    @Override
    public void initialize() throws SQLException, ClassNotFoundException {
        System.out.println("Neche nefer muellim qeydiyyat edeceksiniz?");
        int count = new Scanner(System.in).nextInt();


        for (int i = 0; i < count; i++) {
            System.out.println("Qeydiyyat nomresi:" + (i + 1));
            repo.insert(requireAndCreate());
        }

        printAll();

    }


    @Override
    public void initializeNew(){

        System.out.println("Neche nefer yaratmaq isteyirsiniz?");
        int additionalCount = new Scanner(System.in).nextInt();

        for (int i = 0; i < additionalCount; i++) {
            repo.insert(requireAndCreate());
        }

    }

    @Override
    public void update() {

        try {
            System.out.println("Nechinci muellimi yenilemek isteyirsen?");
            int teacherId = new Scanner(System.in).nextInt();
            Teacher teacher=repo.findById(teacherId);

            System.out.println("Hansi xanani update etmek isteyirsen (name, surname, age,email, salary)");
            String updateField = new Scanner(System.in).nextLine().toLowerCase();
            if (updateField.equals("name")) {
                try {
                    System.out.println("Adini daxil edin:");
                    teacher.setName(new Scanner(System.in).nextLine());
                }catch (Exception e){

                    throw new TeacherRegistrationException("name daxil edilen zaman xeta bas verdi", e);
                }
            } else if (updateField.equals("surname")) {
                System.out.println("Soyadini daxil edin:");
                teacher.setSurname(new Scanner(System.in).nextLine());
            } else if (updateField.equals("age")) {
                System.out.println("Yashini daxil edin:");
                teacher.setAge(new Scanner(System.in).nextInt());
            }else if (updateField.equals("email")) {
                System.out.println("emailini daxil edin:");
                teacher.setSalary(new Scanner(System.in).nextDouble());
            }

            else if (updateField.equals("salary")) {
                System.out.println("Maashini daxil edin:");
                teacher.setSalary(new Scanner(System.in).nextDouble());
            } else {
                System.out.println("Duzgun xana adi daxil edin.");
            }
            repo.update(teacher);
        } catch (Exception e) {
            throw new TeacherRegistrationException("Muellimi yenileme zaman xeta bas verdi.", e);
        }


    }


    @Override
    public void delete() throws Exception {

            System.out.println("Nechinci muellimi silmek isteyirsen?");
            int muellimiSil = new Scanner(System.in).nextInt();
            Teacher teacher=new Teacher();
            teacher.setId(muellimiSil);
            repo.delete(teacher);

    }

    @Override
    public void printAll() throws SQLException, ClassNotFoundException {

        List<Teacher> teachers=repo.getList();
        System.out.println("Qeydiyyatdan kechen muellimler.");
        for (int i = 0; i < teachers.size(); i++) {

            System.out.println((i + 1) + "." + teachers.get(i));
        }
    }

    @Override
    public void find(){

        System.out.println("Axtarmaq istediyiniz muellimin adini ve ya soyadini daxil edin:");
        String text = new Scanner(System.in).nextLine();
        List<Teacher> teachers=repo.getList(text,text);
        for(Teacher teacher:teachers){
            System.out.println(teacher);

        }
    }

    private Teacher requireAndCreate() {
        Teacher teacher = new Teacher();

        System.out.println("Muellimin adini daxil edin:");
        teacher.setName(new Scanner(System.in).nextLine());

        System.out.println("Muellimin soyadini daxil edin:");
        teacher.setSurname(new Scanner(System.in).nextLine());

        System.out.println("Muellimin yashini daxil edin:");
        teacher.setAge(new Scanner(System.in).nextInt());

        System.out.println("Muellimin emailini daxil edin:");
        teacher.setEmail(new Scanner(System.in).nextLine());

        System.out.println("Muellimin maashini daxil edin:");
        teacher.setSalary(new Scanner(System.in).nextDouble());

        return teacher;
    }
}
