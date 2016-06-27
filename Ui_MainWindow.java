import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_MainWindow implements com.trolltech.qt.QUiForm<QMainWindow>
{
    public QWidget centralWidget;
    public QPushButton step;
    public QPushButton clear;
    public QPushButton Next;
    public QTextBrowser textBrowser;
    public QTextBrowser Result;
    public QStatusBar statusBar;

    public Ui_MainWindow() { super(); }

    public void setupUi(QMainWindow MainWindow)
    {
        MainWindow.setObjectName("MainWindow");
        MainWindow.resize(new QSize(746, 469).expandedTo(MainWindow.minimumSizeHint()));
        centralWidget = new QWidget(MainWindow);
        centralWidget.setObjectName("centralWidget");
        step = new QPushButton(centralWidget);
        step.setObjectName("step");
        step.setGeometry(new QRect(10, 10, 141, 23));
        step.setCheckable(false);
        step.setChecked(false);
        step.setFlat(false);
        clear = new QPushButton(centralWidget);
        clear.setObjectName("clear");
        clear.setGeometry(new QRect(10, 70, 141, 23));
        clear.setCheckable(false);
        clear.setChecked(false);
        clear.setFlat(false);
        Next = new QPushButton(centralWidget);
        Next.setObjectName("Next");
        Next.setGeometry(new QRect(10, 40, 141, 23));
        textBrowser = new QTextBrowser(centralWidget);
        textBrowser.setObjectName("textBrowser");
        textBrowser.setGeometry(new QRect(10, 100, 141, 192));
        Result = new QTextBrowser(centralWidget);
        Result.setObjectName("Result");
        Result.setGeometry(new QRect(10, 300, 141, 141));
        MainWindow.setCentralWidget(centralWidget);
        statusBar = new QStatusBar(MainWindow);
        statusBar.setObjectName("statusBar");
        MainWindow.setStatusBar(statusBar);
        retranslateUi(MainWindow);

        MainWindow.connectSlotsByName();
    } // setupUi

    void retranslateUi(QMainWindow MainWindow)
    {
        MainWindow.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "\u0422\u043e\u043f\u043e\u043b\u043e\u0433\u0438\u0447\u0435\u0441\u043a\u0430\u044f \u0421\u043e\u0440\u0442\u0438\u0440\u043e\u0432\u043a\u0430", null));
        step.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "\u0417\u0430\u043f\u0443\u0441\u0442\u0438\u0442\u044c \u0422\u043e\u043f.\u0421\u043e\u0440\u0442.", null));
        clear.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "\u041e\u0447\u0438\u0441\u0442\u0438\u0442\u044c \u0433\u0440\u0430\u0444", null));
        Next.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Next", null));
    } // retranslateUi

}

