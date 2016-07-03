/********************************************************************************
 ** Form generated from reading ui file 'mainwindow.jui'
 **
 ** Created by: Qt User Interface Compiler version 4.8.6
 **
 ** WARNING! All changes made in this file will be lost when recompiling ui file!
 ********************************************************************************/
import com.trolltech.qt.QSignalEmitter;
import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;
import java.util.Random;
import java.math.*;
import javafx.scene.transform.Transform;
import sun.font.TrueTypeFont;
import sun.misc.Signal;



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
    public QAction generate;
    public QMenu option;
    public QAction option_of_graph;
    public QMenuBar menubar;

    //public String answer;

    public static Ui_AddFileForm form = new Ui_AddFileForm()/*null*/;
    public static Ui_GenerateForm generate_form = new Ui_GenerateForm();
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

    public static Tree save_tree = new Tree();
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

        generate = new QAction(MainWindow);
        generate.setObjectName("generate");
        file.addAction(generate);


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
        generate.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow","Сгенерировать граф", null));

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
    public void on_actionGenerate_clicked()
    {
        // this.textBrowser.append("save нажат");
        generate_form = null;
        QWidget new_widget = new QWidget();
        generate_form = new Ui_GenerateForm();
        generate_form.setupUi(new_widget);
        // this.textBrowser.append(form.lineEdit.text());
        generate_form.Ok.clicked.connect(this, "generate_new_tree()");
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
            update_tree();
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
            QSignalEmitter.Signal1<Boolean> answer;
            write_file_exist = true;
            this.textBrowser.append("Теперь все действия будут дублироваться в файл: " + form.inputString + ".txt" );
            out = new QTextStream(outFile);
            //outFile.w
            //out.writeString( "Hi! " + form.inputString);
            //return QSignalEmitter.signalSender().s;
          //  return QSignalEmitter.AbstractSignal;

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



    public boolean update_tree()
    {
        if(!read_file_exist)
        {
            return false;
        }
        save_tree.RTopSort.clear();
        save_tree.vertices.clear();
        String all_information;
        all_information = fromF.readAll();
        textBrowser.append(all_information);

        //  String curr_elem = new String();
        // добавление узлов графа
        int save_int=0;
        for(int i=save_int; i<all_information.length(); i++)
        {
            if(all_information.charAt(i) != ' ')
            {
                if(all_information.charAt(i) == '{')
                {
                    save_int = i+1;
                    break;
                }else
                {
                    save_tree.RTopSort.clear();
                    save_tree.vertices.clear();
                    textBrowser.append("В файле присутствует неверный синтаксис. Нет открывающей фигурной скобки: " +all_information.charAt(i));
                    fromFile.close();
                    read_file_exist=false;
                    return false;
                }
            }
        }
        int curr_elem =0;
        for(int i=save_int; i<all_information.length(); i++)  // добавление вершин
        {
            save_int = i+1;
            if(all_information.charAt(i) != ' ')
            {
                if(Character.isDigit(all_information.charAt(i)))
                {
                    curr_elem = curr_elem*10 +all_information.charAt(i)-'0';

                }else
                if(all_information.charAt(i) == ',' || all_information.charAt(i) == '}')
                {
                    if(curr_elem!=0)
                    {
                        save_tree.addVertex(curr_elem);
                        curr_elem = 0;
                        if(all_information.charAt(i) == '}')
                        {
                            break;
                        }
                    }else
                    {
                        save_tree.RTopSort.clear();
                        save_tree.vertices.clear();
                        textBrowser.append("В файле присутствует неверный синтаксис. Нет цифры перед: " +all_information.charAt(i));
                        fromFile.close();
                        read_file_exist=false;
                        return false;
                    }
                }
                else
                {

                    save_tree.RTopSort.clear();
                    save_tree.vertices.clear();
                    if(all_information.charAt(i) != ',')
                    textBrowser.append("В файле присутствует неверный синтаксис. Тут должна быть закрывающая фигураня скобка или заяптая: " +all_information.charAt(i));
                    fromFile.close();
                    read_file_exist=false;
                    return false;
                }
            }
        }
        for(int i=save_int; i<all_information.length(); i++)  // добавление вершин
        {
            while(i<all_information.length() && all_information.charAt(i) ==' ')
            {
                i++;
            }
            if(i<all_information.length() && all_information.charAt(i) == '(')
            {
                i++;
                while(all_information.charAt(i) == ' ') i++;
                if(!Character.isDigit(all_information.charAt(i)))
                {
                    save_tree.RTopSort.clear();
                    save_tree.vertices.clear();
                    textBrowser.append("В файле присутствует неверный синтаксис. Не цифра: " +all_information.charAt(i));
                    fromFile.close();
                    read_file_exist=false;
                    return false;
                }
                int from=0;
                while(i<all_information.length() && Character.isDigit(all_information.charAt(i)))
                {
                    from = from*10 +all_information.charAt(i)-'0';
                    i++;
                    while(all_information.charAt(i) == ' ') i++;
                }
                while(all_information.charAt(i) == ' ') i++;
                if(i>all_information.length() ||all_information.charAt(i) !=',')
                {
                    save_tree.RTopSort.clear();
                    save_tree.vertices.clear();
                    if(all_information.charAt(i) !=',')
                    textBrowser.append("В файле присутствует неверный синтаксис. Нет запятой: " +all_information.charAt(i));
                    else
                        textBrowser.append("В файле присутствует неверный синтаксис. Нет запятой. ");
                    fromFile.close();
                    read_file_exist=false;
                    return false;
                }
                i++;
                while(all_information.charAt(i) == ' ') i++;
                int to=0;
                while(i<all_information.length() && Character.isDigit(all_information.charAt(i)))
                {
                    to = to*10 +all_information.charAt(i)-'0';
                    i++;
                    while(all_information.charAt(i) == ' ') i++;
                }
                if(i>all_information.length() ||all_information.charAt(i) !=')')
                {
                    save_tree.RTopSort.clear();
                    save_tree.vertices.clear();
                    textBrowser.append("В файле присутствует неверный синтаксис. Запись рёбер должна заканчиваться закрывающй скобкой: " +all_information.charAt(i));
                    fromFile.close();
                    read_file_exist=false;
                    return false;
                }
                /// добавление ребра

                /*for (int j = 0; j < u.edg.size(); j++)
                    if (u.edg.get(j).v == v) return;
                u.edg.add(new Edge(v));*/
                /**textBrowser.append("Все вершины дерева: ");
                for (int k = 0; k < save_tree.vertices.size(); k++)
                {
                    textBrowser.append(Integer.toString(save_tree.vertices.get(k).name));
                }*/

                Vertex vertex_from = null;
                for (int k = 0; k < save_tree.vertices.size(); k++)
                    if (save_tree.vertices.get(k).name == from) {
                        vertex_from = save_tree.vertices.get(k);
                    }
                if(vertex_from == null)  // если в дереве нет вершины, с которой хотят соединить путь
                {
                    save_tree.RTopSort.clear();
                    save_tree.vertices.clear();
                    textBrowser.append("В файле присутствует неверный синтаксис. Данная вершина не найдена: " +from);
                    fromFile.close();
                    read_file_exist=false;
                    return false;
                }
                Vertex vertex_to = null;
                for (int k = 0; k < save_tree.vertices.size(); k++)
                    if (save_tree.vertices.get(k).name == to) {
                        vertex_to = save_tree.vertices.get(k);
                    }
                if(vertex_to == null)  // если в дереве нет вершины, с которой хотят соединить путь
                {
                    save_tree.RTopSort.clear();
                    save_tree.vertices.clear();
                    textBrowser.append("В файле присутствует неверный синтаксис. Данная вершина не найдена: " +to);                    fromFile.close();
                    read_file_exist=false;
                    return false;
                }
                vertex_from.edg.add(new Edge(vertex_to));
                ///

            }else
            {
                save_tree.RTopSort.clear();
                save_tree.vertices.clear();
                textBrowser.append("В файле присутствует неверный синтаксис. Запись рёбер должна начинаться с открывающей скобки: " +all_information.charAt(i));
                fromFile.close();
                read_file_exist=false;
                return false;
            }
        }
        textBrowser.append("Дерево было считано.");
        return true;
    }
    private int abs(int i)
    {
        if(i>0) return i;
        else return -i;
    }
    private double abs(double i)
    {
        if(i>0) return i;
        else return -i;
    }
    public void generate_new_tree()
    {
        // int curr_ele
        //save_tree.addVertex(curr_elem);
        do {
            save_tree.RTopSort.clear();
            save_tree.vertices.clear();
            for(int i=0;i<save_tree.vertices.size();i++) {
                save_tree.vertices.get(i).color = 'w';
                for (int j = 0; j < save_tree.vertices.get(i).edg.size(); j++) {
                    save_tree.vertices.get(i).edg.get(j).used = false;
                    save_tree.vertices.get(i).edg.get(j).type = 'n';
                }
            }
            // обычная случайная генерация:
            Random random_int = new Random();
            if(!generate_form.round_painting.isChecked())
            {
                for (int k = 1; k <= abs(generate_form.count_of_top.value()); k++) {
                    save_tree.addVertex(k);
                }
            }else {

                // генерация по кругу:
                double Radious = 60 * ((double) generate_form.count_of_top.value()) / (2 * 3.14); // чтобы параметр был равен кол-ву вершин(тогда расстояние между вершинами равно 1)


                int Start = 200;
                double x = 0;
                double y = 0;
                for (int k = 0; k < abs(generate_form.count_of_top.value()); k++) {
                    x = Radious * Math.cos(Math.toRadians((k * 360) / generate_form.count_of_top.value()));
                    y = Radious * Math.sin(Math.toRadians((k * 360) / generate_form.count_of_top.value()));
                    save_tree.addVertex(Start + (int) x, Start + (int) y, k + 1);
                    //textBrowser.append(k + ") " + x + " " + y);
                    textBrowser.append(k + ") " + x + " " + y);
                    textBrowser.append("Угол: " + (k * 180) / generate_form.count_of_top.value());

                }
            }



            int count = 0;
            while (count < generate_form.count_of_edges.value()) {
                int from = 1 + (abs(random_int.nextInt()) % (generate_form.count_of_top.value()));
                int to = 1 + (abs(random_int.nextInt()) % (generate_form.count_of_top.value()));
                if (save_tree.add_edge(from, to))
                    count++;
                if(generate_form.without_cycle.isChecked() && save_tree.have_cycle() /*save_tree.have_cycle()*/)
                {
                    textBrowser.append(" Есть цикл. Удаляем ребро между " + Integer.toString(from) + " и "+ Integer.toString(to));
                    save_tree.dellete_edge(from,to);
                    count--;
                }
                else
                {
                    if(generate_form.without_cycle.isChecked())
                      textBrowser.append(" Цикла нет. Добавлено ребро " + Integer.toString(from) + " и "+ Integer.toString(to));
                }
            }
         /*   if(generate_form.without_cycle.isChecked())
              textBrowser.append("Должно быть без цикла");
             else
                textBrowser.append("Возможен цикл");

            if(save_tree.have_cycle())
                textBrowser.append(" и цикл есть.");
            else
                textBrowser.append(" и цикла нет.");*/

        }while(generate_form.without_cycle.isCheckable() && save_tree.have_cycle());

        textBrowser.append("Граф сгенерирован.");
        for(int i=0;i<save_tree.vertices.size();i++) {
            save_tree.vertices.get(i).color = 'w';
            for (int j = 0; j < save_tree.vertices.get(i).edg.size(); j++) {
                save_tree.vertices.get(i).edg.get(j).used = false;
                save_tree.vertices.get(i).edg.get(j).type = 'n';
            }
        }
        step.setEnabled(true);
        clear.setEnabled(true);

        // распознование, является ли дерево цикличным или нет
    }
}

