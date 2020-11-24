package cn.liguohao.example.studentmanger;

import javax.swing.*;
import java.util.Scanner;

/**
 * @Description TODO
 * @Author liguohao
 * @Date 2020/9/29 0:42
 */
public class ManagerApplication  {
    public static void main(String[] args) {
        Students students = new Students();
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        while (isRunning){
            System.out.println("----学生管理系统----");
            System.out.println("1 添加学生");
            System.out.println("2 更新学生");
            System.out.println("3 查询学生");
            System.out.println("4 删除学生");
            System.out.println("5 退出程序");
            System.out.println("请输入对应数字：");
            String cmd = scanner.nextLine();

            try {
                switch (cmd){
                    case "1":
                        // 添加学生
                        Student newStudent = new Student();
                        System.out.println("请输入学生ID：");
                        newStudent.setId(Integer.valueOf(scanner.nextLine()));
                        System.out.println("请输入学生姓名：");
                        newStudent.setName(scanner.nextLine());
                        System.out.println("请输入学生年龄：");
                        newStudent.setAge(Integer.valueOf(scanner.nextLine()));
                        students.add(newStudent);
                        System.out.println("添加学生成功");
                        break;
                    case "2":
                        // 更新学生
                        Student updateStudent = new Student();
                        System.out.println("请输入学生ID：");
                        updateStudent.setId(Integer.valueOf(scanner.nextLine()));
                        System.out.println("请输入学生姓名：");
                        updateStudent.setName(scanner.nextLine());
                        System.out.println("请输入学生年龄：");
                        updateStudent.setAge(Integer.valueOf(scanner.nextLine()));
                        students.update(updateStudent);
                        System.out.println("更新学生成功");
                        break;
                    case "3":
                        // 查询学生
                        students.searchAllAndPrint();
                        break;
                    case "4":
                        // 删除学生
                        System.out.println("请输入学生ID：");
                        students.remove(Integer.valueOf(scanner.nextLine()));
                        System.out.println("删除学生成功");
                        break;
                    case "5":
                        // 退出程序
                        isRunning = false;
                        break;
                    default:
                        throw new IllegalArgumentException("请输入正确的数字");
                }
            } catch (RuntimeException e) {
                //e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }

        // 释放自由
        scanner.close();

    }





}
