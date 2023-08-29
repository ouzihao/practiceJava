package script.kryo序列化;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class KryoDemo {

    public static void main(String[] args) throws FileNotFoundException {
        Kryo kryo = new Kryo();
        kryo.register(KryoParam.class);

        KryoParam object = new KryoParam(12, "rami");

        Output output = new Output(new FileOutputStream("kryo.bin"));
        kryo.writeObject(output, object);
        output.close();

        Input input = new Input(new FileInputStream("kryo.bin"));
        KryoParam object2 = kryo.readObject(input, KryoParam.class);
        System.out.println(object2);
        input.close();

    }


}

class KryoParam {
    private String name;
    private int age;

    public KryoParam() {

    }

    public KryoParam(int age, String name) {
        this.age = age;
        this.name = name;
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

    @Override
    public String toString() {
        return "KryoParam{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
