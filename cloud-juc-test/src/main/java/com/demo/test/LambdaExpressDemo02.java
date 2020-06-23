package com.demo.test;

@FunctionalInterface
interface Foo
{
//    void sayhello();
    int add(int x,int y);
    default int mul(int x,int y)
    {
        return x + y;
    }
    static  int div(int x, int y)
    {
        return x/y;
    }
}
/*
 * @author  xiehongyu
 * @date  2020/6/23 19:56
 * @Email:salong0503@aliyun.com
 * 1.拷贝小括号  写死右箭头   落地大括号
 * 2.@FunctionalInterface   (当只有一个方法时默认会加上这个注解，超过时会认为是普通的接口)
 * 3.default  可以有多个
 * 4.static
 */
public class LambdaExpressDemo02
{
    public static void main(String[] args)
    {
        /*Foo test = new Foo() {
            @Override
            public void sayhello() {
                System.out.println("******hello 1205");
            }
        };
        test.sayhello();*/
//        Foo foo = () ->{ System.out.println("*********hello 1205"); };
//        foo.sayhello();
        Foo foo = (int x ,int y) ->{
            System.out.println("come in add mthod");
            return x + y;
        };
        foo.add(10,15);
    }
}
