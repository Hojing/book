package cn.liguohao.design.pattern.adaptor;

/**
 * @Description TODO 适配器模式-适配器
 * @Author liguohao
 * @Date 2020/9/30 9:31
 */
public class Adaptor implements Target{
    private Adaptes adaptes;

    public Adaptor(Adaptes adaptes) {
        this.adaptes = adaptes;
    }

    @Override
    public void request() {
        before();
        adaptes.specificRequest();
        after();
    }

    private void before() {
        System.out.println("before...");
    }

    private void after() {
        System.out.println("after...");
    }
}
