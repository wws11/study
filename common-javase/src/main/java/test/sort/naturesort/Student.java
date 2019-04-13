package test.sort.naturesort;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/4/11 20:46
 */
public class Student  implements  Comparable {

    private   String  name;
    private   int age;
    private   int sex;

    public    Student(String name,int age)
    {
        this.name = name;

        this.age = age;

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }

    @Override
    public int compareTo(Object o) {
      if(!(o instanceof Student )){
          throw new  RuntimeException("不是学生对象");
      }
      Student student=(Student)o;
      if(this.age>student.age){
          return  1;
      } else  if (this.age==student.age){
          this.name.compareTo(student.name);
      }
        return -1;
    }

}
