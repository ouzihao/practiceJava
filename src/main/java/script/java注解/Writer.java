package script.java注解;



public class Writer {
    private int age;

    @JsonField("writeName")
    private String name;

    @JsonField
    private String bookName;

    public Writer(int age, String name, String bookName) {
        this.age = age;
        this.bookName = bookName;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Writer{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", bookName='" + bookName + '\'' +
                '}';
    }
}


class JsonFieldTest {
    public static void main(String[] args) throws IllegalAccessException {
        Writer cmower = new Writer(18,"沉默王二","Web全栈开发进阶之路");
        System.out.println(JsonSerializer.serialize(cmower));
    }
}
