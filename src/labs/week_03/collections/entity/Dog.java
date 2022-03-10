package labs.week_03.collections.entity;

public class Dog implements Comparable<Dog>
{
    private String name;
    private Integer age;

    public Dog(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public int compareTo(Dog o) {
        if(this.age == o.age)
        {
            return this.name.compareTo(o.name);
        }
        return this.age - o.age;
    }

    @Override
    public String toString()
    {
        return this.name + ": " + String.valueOf(this.age);
    }
}
