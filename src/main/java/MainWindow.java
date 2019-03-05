import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * <h3>KillHomeWork</h3>
 * <p></p>
 *
 * @author : TimVan
 * @date : 2019-03-05 10:44
 **/
public class MainWindow {
    private JPanel operator;
    private JTextArea dashBoardtextArea;
    private JButton okButton;
    private JLabel statusBar;
    private JPanel buttonPanel;
    private JPanel showPanel;
    private JPanel selectPanel;
    private JComboBox ClassComboBox;
    private JLabel ClassTip;

    public MainWindow() {
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                dashBoardtextArea.setText(KillHomeWork.getString());
            }
        });

        ClassComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                //获取用户选择的班级
                String classString = (String) ClassComboBox.getSelectedItem();
                if (classString.equals("Java1班")){
                    KillHomeWork.setSrcJson("java1.json");
                }
                else if (classString.equals("Java2班")){
                    KillHomeWork.setSrcJson("java2.json");

                }
                else{
                    KillHomeWork.setSrcJson("java3.json");

                }


            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("MainWindow");
        MainWindow mainWindow = new MainWindow();

        //增加下拉框
        mainWindow.ClassComboBox.addItem("Java1班");
        mainWindow.ClassComboBox.addItem("Java2班");
        mainWindow.ClassComboBox.addItem("Java3班");

        frame.setContentPane(mainWindow.operator);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("点名神器");

        //获得窗口高、宽
        int windowWidth = frame.getWidth();
        int windowHeight = frame.getHeight();
        //定义工具包
        Toolkit kit = Toolkit.getDefaultToolkit();
        //获取屏幕的尺寸
        Dimension screenSize = kit.getScreenSize();
        //获取屏幕的宽、高
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        //设置窗口居中显示
        frame.setLocation(screenWidth/2-windowWidth/2-300, screenHeight/2-windowHeight/2-200);

        //使用Toolkit设置图标
        Toolkit tk = Toolkit.getDefaultToolkit();
        Image image = tk.createImage("icon.png");
        frame.setIconImage(image);

        frame.pack();
        frame.setVisible(true);
    }
}
