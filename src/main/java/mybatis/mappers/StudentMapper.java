package mybatis.mappers;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import mybatis.model.Student;
import org.springframework.stereotype.Component;

@Component
public interface StudentMapper {

    @Insert("INSERT INTO student(userName, password, firstName,"
            + "lastName, dateOfBirth, emailAddress) VALUES"
            + "(#{userName},#{password}, #{firstName}, #{lastName},"
            + "#{dateOfBirth}, #{emailAddress})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    void insertStudent(Student student);

    @Select("SELECT USERNAME as userName, PASSWORD as password, "
            + "FIRSTNAME as firstName, LASTNAME as lastName, "
            + "DATEOFBIRTH as dateOfBirth, EMAILADDRESS as emailAddress "
            + "FROM student WHERE userName = #{userName}")
    Student getStudentByUserName(String userName);

}