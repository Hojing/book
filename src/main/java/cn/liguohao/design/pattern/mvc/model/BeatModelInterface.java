package cn.liguohao.design.pattern.mvc.model;

import cn.liguohao.design.pattern.mvc.observer.Observer;

/**
 * @Description TODO
 * @Author liguohao
 * @Date 2020/10/5 15:47
 */
public interface BeatModelInterface {

    void initialize();

    void on();

    void off();

    void setBPM(int bpm);

    int getBPM();

    public void registerBeatObserver(Observer observer);

    public void registerBPMObserver(Observer observer);

    public void removeBeatObserver(Observer observer);

    public  void removeBPMObserver(Observer observer);
}
