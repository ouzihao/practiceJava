package case_practice.动态代理CGLIB;

public class UserServiceImpl implements UserService{
    @Override
    public void doSomething() {
        System.out.println("Doing something...");
    }
}
