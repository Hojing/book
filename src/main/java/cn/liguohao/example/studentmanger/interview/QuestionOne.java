package cn.liguohao.example.studentmanger.interview;

/**
 * 题目：
 *      1. Given an array of ints = [6, 4, -3, 5, -2, -1, 0, 1, -9], implement a function
 *         to move all positive numbers to the left, and move all negative numbers to the right.
 *         Try your best to make its time complexity to O(n), and space complexity to O(1).
 * 分析：将正数左移，负数右移，
 * @Description TODO
 * @Author liguohao
 * @Date 2020/10/10 14:35
 */
public class QuestionOne {
    public static void main(String[] args) {
        // 数组
        int[] inputIntArr = {6, 4, -3, 5, -2, -1, 0, 1, -9};
        // 处理
        for (int i=0; i < inputIntArr.length; i++) {
            int temp;
            if(inputIntArr[i] >0) { //正数左移
                if(i!=0){ //不是数组第一位
                    temp = inputIntArr[i-1];
                    inputIntArr[i-1] = inputIntArr[i];
                    inputIntArr[i]=temp;
                }
            }else { //负数右移动
                if(i<(inputIntArr.length-1)){ //不是数组最后一位
                    temp = inputIntArr[i+1];
                    inputIntArr[i+1] = inputIntArr[i];
                    inputIntArr[i] = temp;
                }
            }
        }
        // 打印数组
        for(int i=0;i<inputIntArr.length;i++){
            System.out.print(inputIntArr[i]);
            if (i<(inputIntArr.length-1)){
                System.out.print(", ");
            }
        }
    }
}
