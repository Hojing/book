package cn.liguohao.example.studentmanger.exception;

/**
 * @Description TODO 容量不够时提醒的异常
 * @Author liguohao
 * @Date 2020/9/29 0:05
 */
public class LackCapacityException extends RuntimeException {

    public LackCapacityException(String message) {
        super(message);
    }
}
