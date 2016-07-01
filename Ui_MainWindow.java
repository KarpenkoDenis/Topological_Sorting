/********************************************************************************
 ** Form generated from reading ui file 'mainwindow.jui'
 **
 ** Created by: Qt User Interface Compiler version 4.8.6
 **
 ** WARNING! All changes made in this file will be lost when recompiling ui file!
 ********************************************************************************/
import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;
import javafx.scene.transform.Transform;


public class Ui_MainWindow implements com.trolltech.qt.QUiForm<QMainWindow>
{
    public QWidget centralWidget;
    public QPushButton step;
    public QPushButton clear;
    public QPushButton Next;
    public QTextBrowser textBrowser;
    public QTextBrowser Result;
    public QStatusBar statusBar;
    //
    public QMenu file;
    public QAction from_file;
    public QAction  save;
    public QMenu option;
    public QAction option_of_graph;
    public QMenuBar menubar;

    //public String answer;

    public static Ui_AddFileForm form = null;
    public static boolean write_file_exist = false;
    public static Ui_OptionForm option_form =null;
    public static QFile outFile;
    public static QTextStream out;

    public static boolean read_file_exist = false;
    public static QFile fromFile;
    public static QTextStream fromF;

    public static boolean visualisation = true;

    static QColor first = QColor.fromRgb(0, 0, 0, 255); // по умолчанию черный
    static QColor second = QColor.fromRgb(105, 105, 105, 255); // по умолчанию серый
    static QColor fird = QColor.fromRgb(240, 248, 255, 255); // по умолчанию белый
    static QColor fourth = QColor.fromRgb(0, 100, 0, 255);  // зелёный
    //

    public Ui_MainWindow() { super(); }
   // public ~Ui_MainWindow(){ outFile.close();}


    public void setupUi(QMainWindow MainWindow)
    {
        MainWindow.setObjectName("MainWindow");
        MainWindow.resize(new QSize(746, 500/*469*/).expandedTo(MainWindow.minimumSizeHint()));
        centralWidget = new QWidget(MainWindow);
        centralWidget.setObjectName("centralWidget");
        step = new QPushButton(centralWidget);
        step.setObjectName("step");
        step.setGeometry(new QRect(10, 30, 141, 23));
        step.setCheckable(false);
        step.setChecked(false);
        step.setFlat(false);
        clear = new QPushButton(centralWidget);
        clear.setObjectName("clear");
        clear.setGeometry(new QRect(10, 90, 141, 23));
        clear.setCheckable(false);
        clear.setChecked(false);
        clear.setFlat(false);
        Next = new QPushButton(centralWidget);
        Next.setObjectName("Next");
        Next.setGeometry(new QRect(10, 60, 141, 23));
        textBrowser = new QTextBrowser(centralWidget);
        textBrowser.setObjectName("textBrowser");
        textBrowser.setGeometry(new QRect(10, 120, 141, 192));
        Result = new QTextBrowser(centralWidget);
        Result.setObjectName("Result");
        Result.setGeometry(new QRect(10, 320, 141, 141));
        MainWindow.setCentralWidget(centralWidget);
        statusBar = new QStatusBar(MainWindow);
        statusBar.setObjectName("statusBar");


        //



        //
      //  menubar = QMenuBar.
        menubar = new QMenuBar(MainWindow);
        //файл:
        file = new QMenu(menubar);
        file.setObjectName("file");
        file = menubar.addMenu("Файл");
        from_file = new QAction(MainWindow);
        from_file.setObjectName("in_file"/*"Ввести граф из файла"*/);
        menubar.addAction(file.menuAction());

        file.addSeparator();
        file.addAction(from_file);

        save = new QAction(MainWindow);

        save.setObjectName("save");
        file.addAction(save);


        //найстройки:
        option = new QMenu(menubar);
        option.setObjectName("option");
        option = menubar.addMenu("Настойки");
        option_of_graph= new QAction(MainWindow);
        option.addAction(option_of_graph);
        option_of_graph.setObjectName("option_of_graph");


        menubar.setGeometry(new QRect(0, 0, 117, 23));


        //


        MainWindow.setStatusBar(statusBar);
        retranslateUi(MainWindow);


        //
        //.clicked.connect(Form, "close()");

      //  QDialogButtonBox.StandardButton.Close.
        //
        MainWindow.connectSlotsByName();
    } // setupUi

    void retranslateUi(QMainWindow MainWindow)
    {
        MainWindow.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "\u0422\u043e\u043f\u043e\u043b\u043e\u0433\u0438\u0447\u0435\u0441\u043a\u0430\u044f \u0421\u043e\u0440\u0442\u0438\u0440\u043e\u0432\u043a\u0430", null));
        step.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "\u0417\u0430\u043f\u0443\u0441\u0442\u0438\u0442\u044c \u0422\u043e\u043f.\u0421\u043e\u0440\u0442.", null));
        clear.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "\u041e\u0447\u0438\u0441\u0442\u0438\u0442\u044c \u0433\u0440\u0430\u0444", null));
        Next.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Next", null));
        file.setTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Файл", null));
        from_file.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow","Ввод из файла", null));
        save.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow","Вывод результата в файл", null));
        option_of_graph.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow","Найстройки графа", null));

    } // retranslateUi
    public void on_actionSave_clicked()
    {
       // this.textBrowser.append("save нажат");
        form = null;
        QWidget new_widget = new QWidget();
        form = new Ui_AddFileForm();
        form.setupUi(new_widget);
       // this.textBrowser.append(form.lineEdit.text());
        form.Ok.clicked.connect(this, "write_to_file()");
        new_widget.show();

        //form.show();
    }
    public void on_actionFrom_file_clicked()
    {
        //this.textBrowser.append("save нажат");

        form = null;
        QWidget new_widget = new QWidget();
        form = new Ui_AddFileForm();
        form.setupUi(new_widget);
        // this.textBrowser.append(form.lineEdit.text());
        form.Ok.clicked.connect(this, "read_from_file()");

        new_widget.show();
        //form.show();
    }
    public void on_actionOption_clicked()
    {
        //this.textBrowser.append("save нажат");

        QWidget new_widget = new QWidget();
        option_form = new Ui_OptionForm();
        option_form.setupUi(new_widget);
        option_form.buttonBox.clicked.connect(this, "vis()");
        new_widget.show();
        //form.show();
    }
    public void read_from_file()
    {

        if(read_file_exist)
        {
            fromFile.close();
            read_file_exist = false;
        }
        // this.textBrowser.append("Попытка найти файл с именем: " + form.inputString);
        fromFile = new QFile( form.inputString + ".txt" /*".//OutputInfo.txt"*/);
        if(!fromFile.open(QIODevice.OpenModeFlag.ReadOnly, QIODevice.OpenModeFlag.Text))
        {
            this.textBrowser.append("Файл с именем " + form.inputString + ".txt " + "не найден.");
            read_file_exist = false;

        }
        else
        {
            read_file_exist = true;
            this.textBrowser.append("Граф будет введён из файла: " + form.inputString + ".txt" );
            fromF = new QTextStream(fromFile);
            //outFile.w
            //out.writeString( "Hi! " + form.inputString);

        }
        // outFile.close();
    }
    public void write_to_file()
    {

        if(write_file_exist)
        {
            outFile.close();
            write_file_exist = false;
        }
       // this.textBrowser.append("Попытка найти файл с именем: " + form.inputString);
        outFile = new QFile(".//" + form.inputString + ".txt" /*".//OutputInfo.txt"*/);
        if(!outFile.open(QIODevice.OpenModeFlag.WriteOnly, QIODevice.OpenModeFlag.Text))
        {
            this.textBrowser.append("Файл с именем " + form.inputString + ".txt " + "не найден.");
            write_file_exist = false;

        }
        else
        {
            write_file_exist = true;
            this.textBrowser.append("Теперь все действия будут дублироваться в файл: " + form.inputString + ".txt" );
            out = new QTextStream(outFile);
            //outFile.w
            //out.writeString( "Hi! " + form.inputString);

        }
       // outFile.close();
    }
    public static void write_massage_to_file( String massege, boolean visualisation)
    {
        if(write_file_exist && visualisation) {
            out.writeString(massege);
            out.writeString("\n");
        }
    }
    public static void close_file()
    {
        if(write_file_exist)
        {
            outFile.close();
            write_file_exist = false;
        }
        if(read_file_exist)
        {
            fromFile.close();
            read_file_exist = false;
        }

    }
    public static void vis()
    {
        if(!option_form.first) {
            visualisation = option_form.checkBox.isChecked();
            if(option_form.Green_yellow.isChecked())
            {
                first = QColor.fromRgb(0, 100, 0, 255); //зелёный
                second = QColor.fromRgb(255,215,0/*238,0,0*/, 255); // красный
                fird = QColor.fromRgb(240, 248, 255, 255); // белый
            }
            else
            {
                first = QColor.fromRgb(0, 0, 0, 255); // черный
                second = QColor.fromRgb(105, 105, 105, 255); //серый
                fird = QColor.fromRgb(240, 248, 255, 255); //  белый
            }
        }
    }

    protected void closeEvent( QCloseEvent  e )
    {

        outFile.close();
        fromFile.close();
        e.accept();
        //e.ignore();
    }
}

