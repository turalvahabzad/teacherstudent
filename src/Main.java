
import comman.Db;
import file.FileUtility;
import teacher.entity.Teacher;
import teacher.service.TeacherService;

public class Main {
private static final int STUDENT_DELETE=1;
private static final int STUDENT_UPDATE=2;

    public static void main(String[] args) throws Exception {
try {
    Object o = FileUtility.readObject("teachers.obj");
    Teacher[] teachers = (Teacher[]) o;
    Db.teachers = teachers;
}
catch (Exception ignored){

        }
        TeacherService service=new TeacherService();
service.showMenu();





    }

      }




