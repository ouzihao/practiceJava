package script.hutool;

import cn.hutool.core.img.ImgUtil;
import cn.hutool.core.util.ReflectUtil;

import java.awt.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectDemo {

    private int id;

    public ReflectDemo() {}

    public ReflectDemo(int id) {
        this.id = id;
    }

    public void print() {
        System.out.println("ni_hao");
    }


    public static void main(String[] args) throws IllegalAccessException {
        //构架对象
        ReflectDemo reflectDemo = ReflectUtil.newInstance(ReflectDemo.class);

        //获取构造方法
        Constructor[] constructors = ReflectUtil.getConstructors(ReflectDemo.class);
        for (Constructor constructor : constructors) {
            System.out.println(constructor.getName());
        }

        //获取字段
        Field field = ReflectUtil.getField(ReflectDemo.class, "id");
        field.setInt(reflectDemo, 10);
        System.out.println(ReflectUtil.getFieldValue(reflectDemo, field));

        //获取所有方法
        Method[] methods = ReflectUtil.getMethods(ReflectDemo.class);
        for (Method m : methods) {
            System.out.println(m.getName());
        }
        //获取指定方法
        Method method = ReflectUtil.getMethod(ReflectDemo.class, "print");
        System.out.println(method.getName());

        ReflectUtil.invoke(reflectDemo, "print");

    }


}
