package team.eight.florist.util;

import org.apache.shiro.crypto.hash.Md5Hash;

public class Md5Utils {
    public static String encryption(String username,String password){
        //可以自己编写加密算法 这里使用shiro框架提供的加密算法
        //第一个参数是加密对象，第二个参数是盐值，第三个参数是散列次数
        Md5Hash md5Hash = new Md5Hash(password,username,1000);
        return md5Hash.toString();
    }

    public static void main(String[] args) {
        String pwd = encryption("sea", "9999");
        System.out.println(pwd);
    }
}
