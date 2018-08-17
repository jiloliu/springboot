package cn.net.dubboproviderdemo.model;




import java.io.Serializable;


//@Table(name = "user")
public class Person implements Serializable {

    //@Column(name = "id",type = MySqlTypeConstant.INT,length = 11,isKey = true)
    private Integer id;

    //@Column(name = "username",type = MySqlTypeConstant.VARCHAR,length = 11)
    private String	username;

    //@Column(name = "age",type = MySqlTypeConstant.INT,length = 11)
    private int age;

    //@Column(name = "sex",type = MySqlTypeConstant.VARCHAR,length = 11)
    private String  sex;

    public Person(Integer id, String username, int age, String sex) {
        this.id = id;
        this.username = username;
        this.age = age;
        this.sex = sex;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
