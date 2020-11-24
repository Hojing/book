package cn.liguohao.example.studentmanger;

import cn.liguohao.example.studentmanger.exception.ElementNotExistException;
import cn.liguohao.example.studentmanger.exception.EmptyElementException;
import cn.liguohao.example.studentmanger.exception.LackCapacityException;

/**
 * @Description TODO 学生数据，用数组存储
 * @Author liguohao
 * @Date 2020/9/28 23:44
 */
public class Students {
    /**
     * 学生数据
     */
    private Student[] students;

    /**
     * 学生数
     */
    private Integer size = 0;

    /**
     * 默认容量
     */
    private final Integer DEFAULT_CAPACITY = 10;

    public Students() {
        students = new Student[DEFAULT_CAPACITY];
        init();
    }

    /**
     * 初始化添加张三
     */
    private void init() {
        students[size++] = new Student(1, "张三", 23);
    }

    public void add(Student student){
        // 检查容量
        ensureExplicitCapacity(size+1);

        // 检查空对象
        if(null == student) throw new EmptyElementException("不支持添加空元素。");

        // 添加元素后将大小加一
        students[size++] = student;
    }

    /**
     * 确保容量足够
     * @param index 新加入的索引位置
     */
    private void ensureExplicitCapacity(int index) {
        if(index<0 || index < size){
            throw new IllegalArgumentException("索引不合法");
        }else if(index > students.length){
            throw new LackCapacityException("容量不够，目前未实现动态扩容。只支持10个学生。");
        }
    }

    /**
     * 更新学生信息
     * @param student
     */
    public void update(Student student){
        // 检查空对象
        if(null == student) throw new EmptyElementException("不支持更新空元素。");
        // 原对象
        Student arrStudent = null;
        Integer arrIndex = -1;

        // 获取原对象
        for(int index=0;index< size;index++){
            Student tempStudent = students[index];
            if(tempStudent.getId() == student.getId()) {
                arrStudent = tempStudent;
                arrIndex = index;
            }
        }

        // 检查对象是否存在
        if(null == arrStudent || arrIndex==-1)  throw new ElementNotExistException("ID为"+student.getId()+"学生不存在");

        // 更新对象
        if(null != student.getName() || !"".equals(student.getName())) arrStudent.setName(student.getName());
        if(null != student.getAge()) arrStudent.setAge(student.getAge());

        // 持久化更改到数组
        students[arrIndex] = arrStudent;

    }

    /**
     * @return 学生数组
     */
    public Student[] toArray(){
        return students.clone();
    }

    /**
     * 查询并打印学生信息
     */
    public void searchAllAndPrint(){
        Student[] students = toArray();
        System.out.println("--------学生信息--------");
        for (int index=0;index< size;index++) {
            Student student = students[index];
            System.out.print("ID："+student.getId()+"\t");
            System.out.print("姓名："+student.getName()+"\t");
            System.out.print("年龄："+student.getAge()+"\n");
        }
    }

    /**
     * 通过ID删除学生
     * @param studentId
     */
    public void remove(Integer studentId){
        // 检查ID合法性
        if(studentId<=0) throw new IllegalArgumentException("学生ID不合法");


        // 原对象
        Student arrStudent = null;
        Integer arrIndex = -1;

        // 获取原对象
        for(int index=0;index< size;index++){
            Student tempStudent = students[index];
            if(tempStudent.getId() == studentId) {
                arrStudent = tempStudent;
                arrIndex = index;
            }
        }

        // 检查对象是否存在
        if(null == arrStudent || arrIndex==-1)  throw new ElementNotExistException("ID为"+studentId+"学生不存在");

        // 删除指定索引元素
        removeElementByIndex(arrIndex);

    }

    /**
     * 删除指定位置元素，并遍历数组，将null的右边元素左移
     * @param arrIndex
     */
    private void removeElementByIndex(Integer arrIndex) {
        students[arrIndex] = null;
        leftElement();
    }

    /**
     * 去掉null，左移数组，保障元素中间没有null
     */
    private void leftElement() {
        for(int index=0;index<size;index++){
            int leftEmenentsNum = size - index -1;
            Student student = students[index];
            if(null == student){ // 有空对象就左移
                System.arraycopy(students,index+1,students,index,leftEmenentsNum);
                students[--size] = null; //将size-1,并将最后一个置空；
            }
        }
    }

}
