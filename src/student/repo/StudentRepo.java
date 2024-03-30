package student.repo;

import common.CommonRepo;
import common.MyDatabase;
import student.entity.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepo implements CommonRepo<Student> {
    @Override
    public List<Student> getList(){
        List<Student>result=new ArrayList<>();

        try(Connection connection= MyDatabase.connect()){
            Statement statement=connection.createStatement();
            ResultSet resultSet= statement.executeQuery("select * from student");
            while (resultSet.next()){
                Student student=new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setSurname(resultSet.getString("surname"));
                student.setEmail(resultSet.getString("email"));
                student.setAge(resultSet.getInt("age"));
                student.setUniversity(resultSet.getString("university"));

                result.add(student);

            }

        }
        catch(Exception ex){

ex.printStackTrace();
        }
        return result;
    }

    @Override
    public void update(Student obj)  {

        try (Connection connection=MyDatabase.connect()){
connection.setAutoCommit(false);
            PreparedStatement statement=connection.prepareStatement("update student set name=?,surname=? email=?, " +
                    "age=?"+" university=?"+"where id=?");

            statement.setString(1,obj.getName());
            statement.setString(2, obj.getSurname());
            statement.setString(3, obj.getEmail());
            statement.setInt(4, obj.getAge());
            statement.setString(5, obj.getUniversity());
            statement.setInt(6, obj.getId());
       statement.execute();
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void delete(Student obj) {
        try(Connection connection=MyDatabase.connect()) {
            PreparedStatement statement=connection.prepareStatement("delete from student where id=?");
            statement.setInt(1, obj.getId());
            statement.execute();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void insert(Student obj) {
try (Connection connection=MyDatabase.connect()){

    PreparedStatement statement=connection.prepareStatement("insert into student(name, surname,email,age,university)"
            +"values(?,?,?,?,?)");

    statement.setString(1,obj.getName());
    statement.setString(2, obj.getSurname());
    statement.setString(3, obj.getEmail());
    statement.setInt(4, obj.getAge());
    statement.setString(5, obj.getUniversity());
statement.execute();
} catch (Exception ex) {
    ex.printStackTrace();
}
    }

    @Override
    public Student findById(int id) {

        try(Connection connection=MyDatabase.connect()){
            PreparedStatement statement=connection.prepareStatement("select * from student where id=?");
            statement.setInt(1,id);
            ResultSet resultSet= statement.executeQuery();
            if(resultSet.next()){

                Student student=new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setSurname(resultSet.getString("surname"));
                student.setEmail(resultSet.getString("email"));
                student.setAge(resultSet.getInt("age"));
                student.setUniversity(resultSet.getString("university"));

                return student;
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
return null;
    }

    @Override
    public List<Student> getList(String name, String surname) {
        List<Student>result=new ArrayList<>();

        try(Connection connection= MyDatabase.connect()){
            PreparedStatement statement=connection.prepareStatement("select *"+
                    "from student where name=? or surname=?");
            statement.setString(1, name);
            statement.setString(2,surname);
            ResultSet resultSet= statement.executeQuery();
            while (resultSet.next()){
                Student student=new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setSurname(resultSet.getString("surname"));
                student.setEmail(resultSet.getString("email"));
                student.setAge(resultSet.getInt("age"));
                student.setUniversity(resultSet.getString("university"));

                result.add(student);
            }

        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
