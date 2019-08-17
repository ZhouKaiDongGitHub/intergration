package cn.kzhou.webservice;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    @Override
    public void saveUser(User user) {
        System.out.println("用户保存成功:" + user);
    }

    @Override
    public void delUser(int id) {
        System.out.println("ID为 " + id + " 的用户删除成功");
    }

    @Override
    public void updateUser(User user) {
        System.out.println("用户更新成功:" + user);
    }

    @Override
    public List<User> findAllUsers() {
        List<User> list = new ArrayList<>();
        list.add(new User(1, "zhangsan", 11));
        list.add(new User(2, "lisi", 22));
        return list;
    }

    @Override
    public User findUserByID(int id) {
        return new User(1, "zhangsan", 11);
    }
}
