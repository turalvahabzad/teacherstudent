package teacher.service;

import comman.Db;
import comman.MyService;
import comman.MyServiceInterface;
import comman.RunnableasMenu;
import teacher.entity.Teacher;

import java.util.Scanner;

public class TeacherService extends RunnableasMenu implements MyServiceInterface {


    public void showMenu() {
        System.out.println("Hansi emeliyyati etmek isteyirsiz?:");
        System.out.println("0.muellimi ilk defe yaratmaq \n" +
                "1. yenisini yaratmaq \n" +
                "2.yenilemek \n" +
                "3.silmek \n" +
                "4.axtarmaq \n" +
                "5.hamisini gormek \n");
        int action = new Scanner(System.in).nextInt();


        if(action==1){
            Db.teachers= Initialinew(Db.teachers);
        }

        else if(action==0){
            Db.teachers= initialize();
        }
        else if (action == 3) {
            delete(Db.teachers);
        }

        else if (action == 5) {
            printAll(Db.teachers);
        }

        else if (action == 4) {
            find(Db.teachers);
        }
        else if(action==2){
            update(Db.teachers);
        }
    }
    @Override
    public void find(Teacher[]teachers) {

        System.out.println("muellimin adini ve ya soyadini daxil edin");
        String text = new Scanner(System.in).nextLine();
        for (int i = 0; i < teachers.length; i++) {
            Teacher s = teachers[i];
            if(s==null) continue;
            if ( (s.getName().equals(text) || s.getSurname().equals(text))) {
                System.out.println(s);
            }
        }
    }

    @Override
    public void delete(Teacher[]teachers) {

        System.out.println("necenci muellimi silmek isteyirsiz");
        int a = new Scanner(System.in).nextInt();
        if (a > 0 && a <= teachers.length) {
            teachers[a - 1] = null;
        } else {
            System.out.println("Duzgun qeydiyyat nomresi daxil edin.");
        }

    }

    @Override
    public void update(Teacher[]teachers) {
        System.out.println("Necenci muellimi update elemek isteyirsen?");
        int updatedIndex=new Scanner(System.in).nextInt();
        Teacher teacher=teachers[updatedIndex-1];
        System.out.println("hansi xanani deyismek isteyirsen? ad, soyad, yas");

        String updatedField=new Scanner(System.in).nextLine();
        if(updatedField.equals("name")){
            System.out.println("adini daxil edin");
            teacher.setName(new  Scanner(System.in).nextLine());

        }else if(updatedField.equals("surname")){
            System.out.println("soyadini daxil edin");
            teacher.setSurname(new  Scanner(System.in).nextLine());

        }
        else if(updatedField.equals("age")){
            System.out.println("yasini daxil edin");
            teacher.setAge(new  Scanner(System.in).nextInt());

        }
    }

    @Override
    public Teacher[] Initialinew(Teacher[]oldTeachers) {
        System.out.println("Nece muellim daxil edeceksiniz?");
        int additionalCount = new Scanner(System.in).nextInt();
        Teacher[] newTeachers=new Teacher[oldTeachers.length+additionalCount];

        for (int i = 0; i < oldTeachers.length; i++) {
            newTeachers [i]=oldTeachers[i];
        }
        for(int i=oldTeachers.length;i<newTeachers.length;i++){
            newTeachers[i]=requireAndCreate();

        }

        return newTeachers;
    }

    @Override
    public Teacher[] initialize() {

        System.out.println("Nece muellim daxil edeceksiniz?");
        int count = new Scanner(System.in).nextInt();
        Teacher[] teachers = new Teacher[count];

        for (int i = 0; i < count; i++) {
            System.out.println("Qeydiyyat nomresi " + (i + 1));


            teachers[i]=requireAndCreate();
        }
        printAll(teachers);
        return teachers;
    }

    @Override
    public Teacher requireAndCreate(){
        Teacher teacher = new Teacher();

        System.out.println("Muellimin adini daxil edin:");
        teacher.setName(new Scanner(System.in).nextLine());

        System.out.println("Muellimin soyadini daxil edin:");
        teacher.setSurname(new Scanner(System.in).nextLine());

        System.out.println("Muellimin yasini daxil edin:");
        teacher.setAge(new Scanner(System.in).nextInt());


        return teacher;

    }

    @Override
    public void printAll(Teacher[] teachers){

        System.out.println("Qeydiyyatdan kecen muellimler");
        for (int i = 0; i < teachers.length; i++) {
            if(teachers[i]==null)continue;
            System.out.println(teachers[i]);
        }
    }
}
