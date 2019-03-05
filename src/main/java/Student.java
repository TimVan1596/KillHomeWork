import com.alibaba.fastjson.JSON;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <h3>KillHomeWork</h3>
 * <p>学生类</p>
 *
 * @author : TimVan
 * @date : 2019-03-05 08:15
 **/
public class Student {
    /**
     * currentId = 当前游标的id
     */
    private static int currentId = 1;

    private int id;
    private String name;
    private String no;

    public Student(String name, String no) {
        this.name = name;
        this.no = no;

        this.id = currentId;
        currentId++;
    }

    public Student(int id, String name, String no) {
        this.id = id;
        this.name = name;
        this.no = no;
    }


    /**
     * 导出学生数据到Json文件
     */
    public static void stusToJson() {
        List<Student> list = new ArrayList<Student>();
        list.add(new Student("小明", "316202061007"));


        //学生总数
        int count = list.size();

        //构建用于保存的Json
        Map<String, Object> stuJson = new HashMap<String, Object>();
        stuJson.put("count", count);
        stuJson.put("data", list);

        File file = new File("data.json");

        try {
            if (!file.exists()) {
                boolean isCreateNewFile =  file.createNewFile();
            }

            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(JSON.toJSONString(stuJson));

            bw.flush();
            fw.flush();

            //关闭文件流
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        stusToJson();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }
}
