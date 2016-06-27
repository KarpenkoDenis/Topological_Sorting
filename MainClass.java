/**
 * Created by Flame on 27.06.2016.
 */

import com.trolltech.qt.gui.*;
import com.trolltech.qt.gui.QWidget;


public class MainClass extends QMainWindow{
    Ui_MainWindow MyWindow = new Ui_MainWindow();
    public static void main(String ... arg)
    {
        QApplication.initialize(arg);

        MainClass text = new MainClass();
        //MyWindow.show();


        QApplication.execStatic();
    }
    public MainClass()
    {
        MyWindow.setupUi(this);


        show();

    }
}
