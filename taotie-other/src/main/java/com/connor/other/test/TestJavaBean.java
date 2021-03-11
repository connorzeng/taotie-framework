package com.connor.other.test;

import com.connor.other.test.dto.UserDTO;

import java.util.Map;
import java.util.Set;

/**
 * 测试java的引用
 */
public class TestJavaBean {

    UserDTO userDTO;

    public TestJavaBean() {
        init();
    }

    public static void main(String[] args) {
        TestJavaBean bean = new TestJavaBean();


        Thread one = new Thread(() -> {
            UserDTO userDTOOne = bean.getUserDTO();

            while (true) {
                //System.out.println("one:" + userDTOOne);
                sleepWell();
            }
        });
        one.start();


        Thread two = new Thread(() -> {
            UserDTO userDTOTwo = bean.getUserDTO();

            while (true) {
                //System.out.println("two:" + userDTOTwo);
                sleepWell();

                // 1.3.将对象设置为null, 其他两个线程不生效
                //userDTOTwo = null;

                // 1.4.在其中一个线程更改userDTO, 其他两个线程均生效
                //userDTOTwo.setName("connor");
            }
        });
        two.start();

        Thread three = new Thread(() -> {
            Map<String, String> params = bean.getUserDTO().getParams();
            Set<Map.Entry<String, String>> entries = params.entrySet();
            while (true) {
//                params.forEach((k, v) -> {
//                    System.out.println(k + ":" + v);
//                    sleepWell();
//                });

                for (Map.Entry<String, String> entry : entries) {
                    System.out.println(entry.getKey() + ":" + entry.getValue());
                    sleepWell();
                }
            }
        });
        three.start();

        while (true) {
            sleepWell(100);
            //System.out.println("main:" + bean.getUserDTO());
            //sleepWell();

            // 1.1.主函数将对象设置为null, 其他两个线程不生效
            //bean.setUserDTO(null);

            // 1.2.主函数将userDTO的属性尽兴更改, 其他两个线程均生效
            //bean.getUserDTO().setName("connor");

            // 2.0.将map里面的值进行更改,其他两个线程均生效
            // bean.getUserDTO().getParams().put("num3","125");

            // 2.1.将map里面的值进行更改,其他两个线程均生效
            bean.getUserDTO().getParams().remove("num2");
        }
    }


    public static void sleepWell(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void sleepWell() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private void init() {
        userDTO = new UserDTO();
        userDTO.setAge("0");
        userDTO.setName("ZERO");
        userDTO.getParams().put("num1", "123");
        userDTO.getParams().put("num2", "124");
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }
}
