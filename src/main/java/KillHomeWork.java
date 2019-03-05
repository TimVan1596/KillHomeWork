import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.*;

/**
 * <h3>KillHomeWork</h3>
 * <p>主程序</p>
 *
 * @author : TimVan
 * @date : 2019-03-05 08:12
 **/
public class KillHomeWork {
    /**
     * stuNum = 学生总数
     * srcJson = 读取的文件名
     * */
    private static int stuNum = 60;
    private static JSONObject jsonObject;

    public static void setSrcJson(String srcJson) {
        KillHomeWork.srcJson = srcJson;
    }

    private static String srcJson = "java1.json";


    /**
     * 从students.json载入STU_NUM
     * */
    private static JSONObject loadStuNum(){
        JSONObject jsonObject =null;

        try {
            File file = new File(srcJson);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            StringBuilder sb = new StringBuilder();
            String cache = "0";
            while(true){
                cache = br.readLine();

                if(cache != null){
                    sb.append(cache);
                }
                else{
                    break;
                }
            }
            //读取students.json文件到jsonObject
            jsonObject = JSON.parseObject(sb.toString());

            br.close();
            fr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return jsonObject;
    }

    public static String getString() {
        jsonObject = loadStuNum();
        stuNum = jsonObject.getInteger("count");

//        for (int i = 0; i<3; i++) {
//            try {
//                Thread.sleep(1000);
//                java.lang.System.out.println((3-i)+"秒后计算结果");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

        //生成两位同学的id
        int stu1Id = (int)(Math.random()*(stuNum));
        int stu2Id = (int)(Math.random()*(stuNum));
        while (stu2Id == stu1Id){
            stu2Id = (int)(Math.random()*(stuNum));
        }

        JSONArray data  = jsonObject.getJSONArray("data");
        JSONObject stu1Json  = data.getJSONObject(stu1Id);
        JSONObject stu2Json  = data.getJSONObject(stu2Id);


        String stu1Name = stu1Json.getString("name");
        String stu2Name = stu2Json.getString("name");

        StringBuilder sb = new StringBuilder((stu1Id+1)+"  -  "+stu1Name);
        sb.append("\n"+(stu2Id+1)+"  -  "+stu2Name);

        return sb.toString();
    }
}
