import com.trolltech.qt.core.QCoreApplication;
import com.trolltech.qt.core.QPointF;
import com.trolltech.qt.core.QRect;
import com.trolltech.qt.core.Qt;
import com.trolltech.qt.gui.*;
import java.util.ArrayList;
import java.util.Random;

class Vertex// Класс вершина
{
    int x, y;
    char color;//Цвет ( 'g' - серый , 'b' - черный, 'w' - белый )
    int name; // номер вершины
    ArrayList<Edge> edg= new ArrayList<Edge>(); //Список ребер из вершины
    Vertex(int x,int y,int name) // конструктор
    {
        this.x=x;
        this.y=y;
        this.color= 'w';   //Вначале у всех цвет - белый
        this.name=name;    // Записали номер вершины
    }
};

class Edge // Класс ребро
{
    Vertex v; // В какую вершину оно идет
    char type; // 'n'- не использованное , 'd' - древесное , 'u' - направленное вперед , 'b' - направленное назад , 'p' - поперечное
    boolean used; // Ходили ли мы через него
    Edge(Vertex v) // Конструктор
    {
        this.type='n';
        this.v = v;
        this.used=false;
    }
};

class Tree //Класс деерво
{
    static char White='w'; //Введем константные цвета
    static char Black='b';
    static char Gray='g';
    static int MAX_VERTICES=1000;
    ArrayList<Vertex> vertices= new ArrayList<Vertex>();  // Список вершин
    ArrayList<Vertex> RTopSort= new ArrayList<Vertex>();     //Нужный список вершин, записанный в обратном порядке
    static Random random_integer = new Random();
    void removeVertex(Vertex v)
    {
        for (int i = 0; i < vertices.size(); i++)
        {
            for(int j=0;j<vertices.get(i).edg.size();j++)
            {
                if(vertices.get(i).edg.get(j).v==v)
                {
                    vertices.get(i).edg.remove(j);
                    j--;
                }
            }
        }
        v.edg.clear();
        int i;
        for(i=0;i<vertices.size();i++)
            if(vertices.get(i)==v) break;
        vertices.remove(i);
    }
    public boolean add_edge(int from, int to)
    {
        Vertex vertex_from = null;
        for (int k = 0; k < vertices.size(); k++)
            if (vertices.get(k).name == from) {
                vertex_from = vertices.get(k);
            }
        if(vertex_from == null)  // если в дереве нет вершины, с которой хотят соединить путь
        {
            return false;
        }
        Vertex vertex_to = null;
        for (int k = 0; k <vertices.size(); k++)
            if (vertices.get(k).name == to) {
                vertex_to = vertices.get(k);
            }
        if(vertex_to == null)  // если в дереве нет вершины, с которой хотят соединить путь
        {
            return false;
        }

        vertex_from.edg.add(new Edge(vertex_to));
        return true;
    }
    void addVertex(int x, int y) {
        int name = 1;
        while (name <= MAX_VERTICES) {
            boolean contain = false;
            for (int j = 0; j < vertices.size(); j++)
                if (vertices.get(j).name == name) contain = true;
            if (!contain) break;
            name++;
        }
        vertices.add(new Vertex(x, y, name));
    }
    void addVertex(int name) {
        //  int name = 1;


        for (int j = 0; j < vertices.size(); j++)
            if (vertices.get(j).name == name) return;  // такая вершина уже содержится
        int x = 50 + (abs(random_integer.nextInt()) % 330) ;
        int y = 50 + (abs(random_integer.nextInt()) % 330) ;
        vertices.add(new Vertex(x, y, name));

    }
    void addVertex( int x, int y, int name) {
        //  int name = 1;


        for (int j = 0; j < vertices.size(); j++)
            if (vertices.get(j).name == name) return;  // такая вершина уже содержится
        vertices.add(new Vertex(x, y, name));

    }
    private int abs(int g) {
        if(g>0) return g; else return -g;
    }
    public boolean have_cycle()
    {
     //   if(RTopSort.size()>0) RTopSort.clear(); //Очистим список вершин
       // RTopSort.clear(); //Очистим список вершин

        for (int i=0; i<vertices.size(); i++)
        {
            if((vertices.get(i).color==White)) //Если вершина не пройдена
            {
                if(!dfs1(vertices.get(i))) {
                    for (int j = 0; j<vertices.size(); j++)
                    {
                        vertices.get(j).color=White;
                    }
                    return true; // запускаем поиск в глубину
                }
  //              if(!Ch) return true;
            }
        }
        for (int j = 0; j<vertices.size(); j++)
        {
            vertices.get(j).color=White;
        }
        return false;
    }
    public boolean dfs1(Vertex cur) //Поиск в глубину
    {
        if(cur.color == Gray) return false;
        cur.color=Gray; //Красим вершину в серый
        for (int i = 0; i<cur.edg.size(); i++)
        {
            if (!(cur.edg.get(i).v.color==Black))
            {
                if(!dfs1(cur.edg.get(i).v)) return false;//переходим к след. вершине
            }
        }
        cur.color=Black;
        return true;
    }
      void dellete_edge(int from, int to)
    {

     //   System.out.println("Попытка удалить " + from + "  " +to);
        Vertex curr_vert= null;
        for (int j = 0; j < vertices.size(); j++)
            if (vertices.get(j).name == from) {
                curr_vert = vertices.get(j);
                break;
            }
        if(curr_vert!=null)
        {
            Vertex to_vert=null;
            int index=0;
            for (int j = 0; j < curr_vert.edg.size(); j++) {
                if (curr_vert.edg.get(j).v.name == to) {
                 //   System.out.println("Сравниваем " + vertices.get(j).name +" " + to);
                    to_vert = curr_vert.edg.get(j).v;
                    index = j;
                    break;
                }
            }
            if(to_vert == null) {
                return;
            }
            curr_vert.edg.remove(index);
        }
       // vertices.add(new Vertex(x, y, name));
    }


};

public class MainClass extends QMainWindow
{

    static Ui_MainWindow MyWindow = new Ui_MainWindow();
    static Ui_AddFileForm AddFileForm = new Ui_AddFileForm();
    static char White='w'; //Введем константные цвета
    static char Black='b';
    static char Gray='g';
    /*static QColor first = QColor.fromRgb(0, 0, 0, 255); // по умолчанию белый
    static QColor second = QColor.fromRgb(105, 105, 105, 255); // по умолчанию серый
    static QColor fird = QColor.fromRgb(240, 248, 255, 255); // по умолчанию черный*/

    static Tree tree=MyWindow.save_tree; //Создадим дерево

    static int TREE_FIELD_X = 170;
    static int TREE_FIELD_Y = 20;
    static int arrowWidth=15;
    static int arrowHeight=15;
    static int TREE_VERTEXES_RADIUS = 15;
    int TREE_FIELD_WIDTH = 600;
    int TREE_FIELD_HEIGHT = 400;

    ArrayList<Vertex> selected= new ArrayList<Vertex>();
    boolean processing;
    boolean dragging;
    static boolean k;
    boolean algorithm; // отслеживает, запущен ли агоритм сортировки
    Vertex draggable;





    public MainClass()
    {
        algorithm =false;
        MyWindow.setupUi(this);
        MyWindow.save.triggered.connect(MyWindow, "on_actionSave_clicked()");
        MyWindow.from_file.triggered.connect(MyWindow, "on_actionFrom_file_clicked()");
        MyWindow.option.triggered.connect(MyWindow, "on_actionOption_clicked()");
        MyWindow.generate.triggered.connect(MyWindow, "on_actionGenerate_clicked()");
       // MyWindow.write_to_file.

      //  MyWindow.write_massage_to_file("Вывод в файл.", true);
        //  MyWindow.read_from_file.connect(this, "update_tree()");
        // MyWindow.Ok.clicked.connect(Form, "close()");
        // if(MyWindow.form!=null) MyWindow.form.Ok.clicked.connect(this, "update_tree()");
       /*  if(MyWindow.form.Ok.isChecked())
        {
                 MyWindow.textBrowser.append("Нажата.");

        }*/
     //   MyWindow.form.Ok.clicked.connect(this, "update_tree()");
        //MyWindow.form.Ok.clicked.
       /* if(MyWindow.read_file_exist)
        {
            update_tree();
        }*/
        //   AddFileForm.setupUi();
        // AddFileForm.setupUi(new QWidget());
        //MyWindow.option_of_graph.triggered.connect(AddFileForm,);

        // AddFileForm.execStatic();
        show();
    }

    public static void main(String ... arg)
    {
        QApplication.initialize(arg);
        //

        //
        MainClass text = new MainClass();

        QApplication.execStatic();
    }

    public void paintEvent(QPaintEvent e)
    {
        if(!algorithm)
        {
            QPainter p = new QPainter(this);
            p.setRenderHint(QPainter.RenderHint.Antialiasing, true);
            p.setBrush(new QBrush(QColor.fromRgb(220, 220, 220, 255)));
            p.drawRect(TREE_FIELD_X, TREE_FIELD_Y, TREE_FIELD_WIDTH, TREE_FIELD_HEIGHT);

            for (int i = 0; i < tree.vertices.size(); i++) {
                QPen pen = new QPen();
                pen.setBrush(new QBrush(QColor.fromRgb(0, 0, 0, 255)));
                pen.setWidth(1);
                p.setPen(pen);
                for (int j = 0; j < tree.vertices.get(i).edg.size(); j++) {
                    QPointF p0 = new QPointF(TREE_FIELD_X + tree.vertices.get(i).x, TREE_FIELD_Y + tree.vertices.get(i).y);
                    QPointF p1 = new QPointF(TREE_FIELD_X + tree.vertices.get(i).edg.get(j).v.x, TREE_FIELD_Y + tree.vertices.get(i).edg.get(j).v.y);
                    pen.setBrush(new QBrush(QColor.fromRgb(0, 0, 0, 255)));
                    p.drawLine(p0, p1);

                    double dx, dy;
                    int m;
                    if (p1.x() > p0.x()) {
                        dx = p1.x() - p0.x();
                        dy = p1.y() - p0.y();
                        m = 1;
                    } else {
                        dx = -p1.x() + p0.x();
                        dy = -p1.y() + p0.y();
                        m = -1;
                    }
                    double angle = dy / dx;
                    angle = Math.atan(angle);

                    QPointF p5 = new QPointF(p1.x() - m * (TREE_VERTEXES_RADIUS) * Math.cos(angle), p1.y() - m * (TREE_VERTEXES_RADIUS) * Math.sin(angle));
                    QPointF p2 = new QPointF(p1.x() - m * (arrowHeight + TREE_VERTEXES_RADIUS) * Math.cos(angle), p1.y() - m * (arrowHeight + TREE_VERTEXES_RADIUS) * Math.sin(angle));
                    angle = Math.atan(((-1) * dx) / dy);
                    QPointF p3 = new QPointF(p2.x() - (arrowWidth / 2) * Math.cos(angle), p2.y() - (arrowWidth / 2) * Math.sin(angle));

                    QPointF p4 = new QPointF(p2.x() + (arrowWidth / 2) * Math.cos(angle), p2.y() + (arrowWidth / 2) * Math.sin(angle));
                    QPolygonF arrow = new QPolygonF();
                    arrow.add(p5);
                    arrow.add(p3);
                    arrow.add(p4);
                    p.drawConvexPolygon(arrow);
                    pen.setBrush(new QBrush(QColor.fromRgb(0, 0, 0, 255)));
                    pen.setWidth(1);
                    p.setPen(pen);
                }
            }
            for (int i = 0; i < tree.vertices.size(); i++) {
                QRect rect = new QRect(TREE_FIELD_X + tree.vertices.get(i).x - TREE_VERTEXES_RADIUS,
                        TREE_FIELD_Y + tree.vertices.get(i).y - TREE_VERTEXES_RADIUS,
                        TREE_VERTEXES_RADIUS * 2, TREE_VERTEXES_RADIUS * 2);
                if (selected.contains(tree.vertices.get(i)))
                    p.setBrush(new QBrush(QColor.fromRgb(180, 230, 90, 255)));
                else
                    p.setBrush(new QBrush(QColor.fromRgb(160, 230, 255, 255)));
                p.drawEllipse(rect);
                p.drawText(rect, 4, Integer.toString(tree.vertices.get(i).name));     //
            }
            p.end();
        }else
        {
            QPainter p = new QPainter(this);
            p.setRenderHint(QPainter.RenderHint.Antialiasing, true);
            p.setBrush(new QBrush(QColor.fromRgb(220, 220, 220, 255)));
            p.drawRect(TREE_FIELD_X, TREE_FIELD_Y, TREE_FIELD_WIDTH, TREE_FIELD_HEIGHT);

            for (int i = 0; i < tree.vertices.size(); i++) {
                QPen pen = new QPen();
                pen.setBrush(new QBrush(QColor.fromRgb(0, 0, 0, 255)));
                pen.setWidth(1);
                p.setPen(pen);
                for (int j = 0; j < tree.vertices.get(i).edg.size(); j++) {

                    QPointF p0 = new QPointF(TREE_FIELD_X + tree.vertices.get(i).x, TREE_FIELD_Y + tree.vertices.get(i).y);
                    QPointF p1 = new QPointF(TREE_FIELD_X + tree.vertices.get(i).edg.get(j).v.x, TREE_FIELD_Y + tree.vertices.get(i).edg.get(j).v.y);
                    if(tree.vertices.get(i).edg.get(j).type=='d') // древесное - толстое
                    {
                        pen.setWidth(4);
                        p.setPen(pen);
                    }
                    if(tree.vertices.get(i).edg.get(j).type=='u') // направленное вперед - зеленое
                    {
                        pen.setBrush(new QBrush(QColor.green));
                        p.setPen(pen);
                    }
                    if(tree.vertices.get(i).edg.get(j).type=='b') // направленное назад - красное
                    {
                        pen.setBrush(new QBrush(QColor.red));
                        p.setPen(pen);
                    }
                    if(tree.vertices.get(i).edg.get(j).type=='p') // поперечное - серое
                    {
                        pen.setBrush(new QBrush(QColor.magenta));
                        p.setPen(pen);
                    }
                    p.drawLine(p0, p1);

                    double dx, dy;
                    int m;
                    if (p1.x() > p0.x()) {
                        dx = p1.x() - p0.x();
                        dy = p1.y() - p0.y();
                        m = 1;
                    } else {
                        dx = -p1.x() + p0.x();
                        dy = -p1.y() + p0.y();
                        m = -1;
                    }
                    double angle = dy / dx;
                    angle = Math.atan(angle);

                    QPointF p5 = new QPointF(p1.x() - m * (TREE_VERTEXES_RADIUS) * Math.cos(angle), p1.y() - m * (TREE_VERTEXES_RADIUS) * Math.sin(angle));
                    QPointF p2 = new QPointF(p1.x() - m * (arrowHeight + TREE_VERTEXES_RADIUS) * Math.cos(angle), p1.y() - m * (arrowHeight + TREE_VERTEXES_RADIUS) * Math.sin(angle));
                    angle = Math.atan(((-1) * dx) / dy);
                    QPointF p3 = new QPointF(p2.x() - (arrowWidth / 2) * Math.cos(angle), p2.y() - (arrowWidth / 2) * Math.sin(angle));

                    QPointF p4 = new QPointF(p2.x() + (arrowWidth / 2) * Math.cos(angle), p2.y() + (arrowWidth / 2) * Math.sin(angle));
                    QPolygonF arrow = new QPolygonF();
                    arrow.add(p5);
                    arrow.add(p3);
                    arrow.add(p4);
                    p.drawConvexPolygon(arrow);
                    pen.setBrush(new QBrush(QColor.fromRgb(0, 0, 0, 255)));
                    pen.setWidth(1);
                    p.setPen(pen);
                }
            }
            for (int i = 0; i < tree.vertices.size(); i++) {
                QRect rect = new QRect(TREE_FIELD_X + tree.vertices.get(i).x - TREE_VERTEXES_RADIUS,
                        TREE_FIELD_Y + tree.vertices.get(i).y - TREE_VERTEXES_RADIUS,
                        TREE_VERTEXES_RADIUS * 2, TREE_VERTEXES_RADIUS * 2);
                if (tree.vertices.get(i).color == White) {
                    p.setBrush(new QBrush(MyWindow.fird));
                }
                else {
                    if (tree.vertices.get(i).color == Gray) {
                        p.setBrush(new QBrush(MyWindow.second));
                    }
                    else if (tree.vertices.get(i).color == Black) {
                        p.setBrush(new QBrush(MyWindow.first));
                    }
                }
                p.drawEllipse(rect);


                if(tree.vertices.get(i).color == Black) {  // возвращаем цвет линий черным
                    QPen pen = new QPen();
                    pen.setBrush(new QBrush(MyWindow.fird/*QColor.fromRgb(240, 248, 255, 255)*/));// цвет линий задаётся белым, чтобы номер вершины был виден, таже при закрашенной в черный вершине
                    pen.setWidth(1);
                    p.setPen(pen);
                    p.drawText(rect, 4, Integer.toString(tree.vertices.get(i).name));
                    // QPen pen = new QPen();
                    pen.setBrush(new QBrush(QColor.fromRgb(0,0,0, 255)));
                    //pen.setBrush(new QBrush(MyWindow.first));
                    pen.setWidth(1);
                    p.setPen(pen);
                }else p.drawText(rect, 4, Integer.toString(tree.vertices.get(i).name));
            }
            p.end();
        }
    }
    public void mousePressEvent(QMouseEvent e)
    {
        if (processing) return;
        //обработка нажатия правой кнопки мыши
        Vertex z;
        if (e.button() == Qt.MouseButton.RightButton)
        {
            for (int i = 0; i < tree.vertices.size(); i++)
                //если курсор указывает на вершину
                if ((Math.abs(tree.vertices.get(i).x + TREE_FIELD_X - e.x()) <= TREE_VERTEXES_RADIUS * 2) &&
                        (Math.abs(tree.vertices.get(i).y + TREE_FIELD_Y - e.y()) <= TREE_VERTEXES_RADIUS * 2))
                {
                    //удаление вершины из списка выбранных и из списка вершин
                    z=tree.vertices.get(i);
                    for(int j=0;j<selected.size();j++)
                        if(selected.get(j)==z) selected.remove(j);
                    tree.removeVertex(z);
                    repaint();
                    return;
                }
            //добавление ребер (в случае, если курсор не указывает на вершину)
            if(selected.size()==2)
            {
                Vertex u=selected.get(0);
                Vertex v=selected.get(1);
                for (int j = 0; j < u.edg.size(); j++)
                    if (u.edg.get(j).v == v) return;
                u.edg.add(new Edge(v));
            }
        }
        repaint();
    }

    public void mouseMoveEvent(QMouseEvent e)
    {
        if (processing) return;
        //обработка начала перемещения вершины
        for (int i = 0; i < tree.vertices.size(); i++) {
            if (dragging == true) break;
            //если курсор указывает на вершину
            if ((Math.abs(tree.vertices.get(i).x + TREE_FIELD_X - e.x()) <= TREE_VERTEXES_RADIUS * 2) &&
                    (Math.abs(tree.vertices.get(i).y + TREE_FIELD_Y - e.y()) <= TREE_VERTEXES_RADIUS * 2)) {

                dragging = true;
                draggable = tree.vertices.get(i);
                break;
            }
        }
        //обработка процесса перемещения вершины
        if (dragging)
        {
            //изменение координат
            draggable.x = e.x() - TREE_FIELD_X;
            draggable.y = e.y() - TREE_FIELD_Y;

            //поправка на границы
            if (e.x() > TREE_FIELD_X + TREE_FIELD_WIDTH - TREE_VERTEXES_RADIUS)
                draggable.x = TREE_FIELD_WIDTH - TREE_VERTEXES_RADIUS;
            if (e.x() < TREE_FIELD_X + TREE_VERTEXES_RADIUS)
                draggable.x = TREE_VERTEXES_RADIUS;
            if (e.y() > TREE_FIELD_Y + TREE_FIELD_HEIGHT - TREE_VERTEXES_RADIUS)
                draggable.y = TREE_FIELD_HEIGHT - TREE_VERTEXES_RADIUS;
            if (e.y() < TREE_FIELD_Y + TREE_VERTEXES_RADIUS)
                draggable.y = TREE_VERTEXES_RADIUS;
            repaint();
        }
    }

    public void mouseReleaseEvent(QMouseEvent e)
    {
        if (processing) return;
        //обработка окончания перетаскивания
        if (dragging)
        {
            dragging = false;
            draggable = null;
            repaint();
            return;
        }

        //обработка нажатия левой кнопки мыши
        if (e.button() == Qt.MouseButton.LeftButton)
        {
            //проверка на границы
            if ((e.x() < TREE_FIELD_X + TREE_VERTEXES_RADIUS) ||
                    (e.x() > TREE_FIELD_X + TREE_FIELD_WIDTH - TREE_VERTEXES_RADIUS) ||
                    (e.y() < TREE_FIELD_Y + TREE_VERTEXES_RADIUS) ||
                    (e.y() > TREE_FIELD_Y + TREE_FIELD_HEIGHT - TREE_VERTEXES_RADIUS))
                return;

            for (int i = 0; i < tree.vertices.size(); i++)

                //если курсор указывает на вершину
                if ((Math.abs(tree.vertices.get(i).x + TREE_FIELD_X - e.x()) <= TREE_VERTEXES_RADIUS * 2) &&
                        (Math.abs(tree.vertices.get(i).y + TREE_FIELD_Y - e.y()) <= TREE_VERTEXES_RADIUS * 2))
                {
                    //добавление/удаление из списка выбранных
                    if (selected.contains(tree.vertices.get(i)))
                        selected.remove(selected.indexOf(tree.vertices.get(i)));
                    else
                    {
                        if(selected.size()<2)
                        {
                            selected.add(tree.vertices.get(i));
                        }
                        else
                        {
                            selected.remove(selected.indexOf(selected.get(selected.size()-1)));
                            selected.add(tree.vertices.get(i));
                        }
                    }
                    repaint();
                    return;
                }
            //добавление вершины (в случае, если курсор не указывает на вершину)
            tree.addVertex(e.x() - TREE_FIELD_X, e.y() - TREE_FIELD_Y);
        }
        repaint();
    }

    public void keyPressEvent(QKeyEvent e)
    {
        if (processing) return;
        //удаление ребер, связывающих выбранные вершины, по нажатию пробе
        if (e.key() ==Qt.Key.Key_Backspace.value())
        {
            if(selected.size()==2)
            {
                for(int i=0;i<selected.get(0).edg.size();i++)
                    if(selected.get(0).edg.get(i).v==selected.get(1)) selected.get(0).edg.remove(i);
            }
        }
        repaint();
    }

    public void resizeEvent(QResizeEvent e)
    {
        TREE_FIELD_WIDTH = e.size().width() - TREE_FIELD_X - 20;
        TREE_FIELD_HEIGHT = e.size().height() - TREE_FIELD_Y - 20;
    }

    void Wait()
    {
        if(MyWindow.visualisation) {
            MyWindow.Next.setEnabled(true);
            while (!k) {
                QCoreApplication.processEvents();
            }
            k = false;
            MyWindow.Next.setEnabled(false);
        }
    }
    static boolean Ch=true;
    public void dfs1(Vertex cur) //Поиск в глубину
    {
        if(MyWindow.visualisation)MyWindow.textBrowser.append("Вошли в вершину "+ cur.name +". Красим её в серый.");
        MyWindow.write_massage_to_file("Вошли в вершину "+ cur.name +". Красим её в серый.", MyWindow.visualisation);
        cur.color=Gray; //Красим вершину в серый
        repaint();
        Wait();
        for (int i = 0; i<cur.edg.size(); i++) // Проходим по всем ребрам идущим из вершины
        {
            if (!(cur.edg.get(i).v.color==Black)) // Если ребро ведет не в черную вершину
            {
                if(cur.edg.get(i).v.color==Gray) // Если ребро ведет в уже серую вершины -> цикл
                {
                    cur.edg.get(i).type='b';
                    cur.edg.get(i).used=true;

                    if(MyWindow.visualisation)MyWindow.textBrowser.append("Переход от вершины "+ cur.edg.get(i).v.name +" к её сыну " + cur.edg.get(i).v.name + ".");
                    MyWindow.write_massage_to_file("Переход от вершины "+ cur.name +" к её сыну " + cur.edg.get(i).v.name + ".", MyWindow.visualisation);
                    if(MyWindow.visualisation)MyWindow.textBrowser.append("Сын  " + cur.edg.get(i).v.name + " является серой вершиной. ");
                    MyWindow.write_massage_to_file("Сын  " + cur.edg.get(i).v.name + " является серой вершиной. ", MyWindow.visualisation);
                    MyWindow.textBrowser.append("Ошибка1!");
                    Ch=false;    // Ch=false - завершаем алгоритм
                    return;
                }
                cur.edg.get(i).used = true;// прошли по ребру
                cur.edg.get(i).type='d';  // Ребро - древесное
                if(MyWindow.visualisation)MyWindow.textBrowser.append("Переход от вершины "+ cur.name +" к её сыну " + cur.edg.get(i).v.name + ".");
                MyWindow.write_massage_to_file("Переход от вершины "+ cur.name +" к её сыну " + cur.edg.get(i).v.name + ".", MyWindow.visualisation);

                dfs1(cur.edg.get(i).v);//Запускаем алгоритм рекурсивно для следующей вершнины
                repaint();
                Wait();
            }
        }
        if(MyWindow.visualisation)MyWindow.textBrowser.append("Выходим из вершины "+ cur.name +". Красим её в черный.");
        MyWindow.write_massage_to_file("Выходим из вершины "+ cur.name +". Красим её в черный.", MyWindow.visualisation);
        for(int j=0;j<cur.edg.size();j++) { // Проверяем все ребра из текущей вершины(из которой мы сейчас вышли)
            if (!cur.edg.get(j).used) {
                if (cur.edg.get(j).v.color == Gray) cur.edg.get(j).type = 'b';// Если ребро идет в серую вершину -> оно направлено назад
                if (cur.edg.get(j).v.color == Black) // Если ребро идет в черную вершину -> оно направлено вперед
                {
                    cur.edg.get(j).type = 'u';
                }
            }
        }
        cur.color=Black;//Вышли из вершины - покрасили в черный
        repaint();
        Wait();
        for(int i=0;i<tree.vertices.size();i++) //Проверим все ребра в графе, если есть ребро Белой->Черную - тогда это поперечные ребра
        {
            if(tree.vertices.get(i).color==White)
            {
                for (int k = 0; k < tree.vertices.get(i).edg.size(); k++)
                    if(tree.vertices.get(i).edg.get(k).v.color == Black)
                    {
                        tree.vertices.get(i).edg.get(k).used=true;
                        tree.vertices.get(i).edg.get(k).type = 'p';
                    }
            }
        }
        tree.RTopSort.add(cur);//Добавили её в список
    }

    void TopSort() //Топологическая сортировка
    {
        Ch=true;//В начале работы Ch=true - циклов нет
        tree.RTopSort.clear(); //Очистим список вершин
        int m=0; // m -номер вершины для которой будем вызывать поиск в глубину
        while(tree.RTopSort.size()<tree.vertices.size()) //пока все вершины не попали в нужый список
        {
            if((tree.vertices.get(m).color==White)) //Если вершина не пройдена
            {
                dfs1(tree.vertices.get(m)); // запускаем поиск в глубину для неё
                if(!Ch) return;// Если нашелся цикл, завершаем работу алгоритма
            }
            else m++;//иначе переходим к следуюещей
        }
    }


    public void on_Next_clicked()
    {
        k=true;
    }
    public void on_step_clicked()
    {
        algorithm=true;
        processing = true;
        selected.clear();
        MyWindow.step.setEnabled(false);
        MyWindow.clear.setEnabled(false);
        int m = 0;
        TopSort();
        for(int i=0;i<tree.vertices.size();i++)
            for(int j=0;j<tree.vertices.get(i).edg.size();j++)//  'u' - направленное вперед , 'b' - направленное назад , 'p' - поперечное
            {
                if (tree.vertices.get(i).edg.get(j).type == 'n')
                    MyWindow.Result.append(Integer.toString(tree.vertices.get(i).name) + "->" + Integer.toString(tree.vertices.get(i).edg.get(j).v.name) + "Неиспользованное");
                if (tree.vertices.get(i).edg.get(j).type == 'd')
                    MyWindow.Result.append(Integer.toString(tree.vertices.get(i).name) + "->" + Integer.toString(tree.vertices.get(i).edg.get(j).v.name) + "Древесное");
                if (tree.vertices.get(i).edg.get(j).type == 'u')
                    MyWindow.Result.append(Integer.toString(tree.vertices.get(i).name) + "->" + Integer.toString(tree.vertices.get(i).edg.get(j).v.name) + "Направленное вперед");
                if (tree.vertices.get(i).edg.get(j).type == 'p')
                    MyWindow.Result.append(Integer.toString(tree.vertices.get(i).name) + "->" + Integer.toString(tree.vertices.get(i).edg.get(j).v.name) + "Поперечное");
                if (tree.vertices.get(i).edg.get(j).type == 'b')
                    MyWindow.Result.append(Integer.toString(tree.vertices.get(i).name) + "->" + Integer.toString(tree.vertices.get(i).edg.get(j).v.name) + "Направленное назад");
            }
        String str="Список отсортированных вершин: ";
        for(int i=0;i<tree.RTopSort.size();i++) {
            str += " ";
            str += tree.RTopSort.get(tree.RTopSort.size() - i - 1).name;
        }
        if(Ch) MyWindow.Result.append(str);
        else MyWindow.Result.append("Есть цикл!");
        if(MyWindow.visualisation) {
            repaint();
            Wait();
        }
        else
        {
            MyWindow.visualisation=true;
            repaint();
            Wait();
            MyWindow.visualisation=false;
        }
        for(int i=0;i<tree.vertices.size();i++) {
            tree.vertices.get(i).color = White;
            for (int j = 0; j < tree.vertices.get(i).edg.size(); j++) {
                tree.vertices.get(i).edg.get(j).used = false;
                tree.vertices.get(i).edg.get(j).type = 'n';
            }
        }
        algorithm=false;
        MyWindow.step.setEnabled(true);
        MyWindow.clear.setEnabled(true);
        processing = false;
        repaint();
    }
    public void on_clear_clicked()
    {
       /* if(!MyWindow.form.Ok.isChecked())
        {
            MyWindow.textBrowser.append("Не нажата.");
        }
        MyWindow.form.Ok.clicked.connect(this, "update_tree()");*/

       /* if(MyWindow.read_file_exist)
        {
            MyWindow.textBrowser.append("Отрисовка дерева из файла.");
           // tree= MyWindow.save_tree;
            MyWindow.textBrowser.append("Все вершины дерева: ");
            for (int k = 0; k < MyWindow.save_tree.vertices.size(); k++)
            {
                MyWindow.textBrowser.append(Integer.toString(MyWindow.save_tree.vertices.get(k).name));
            }
            processing = false;
            dragging= true;
            repaint();
        }*/

        selected.clear();
        tree.RTopSort.clear();
        tree.vertices.clear();
        repaint();
    }
    protected void closeEvent( QCloseEvent  e ) // переопределено закрытие файла, т.к. нужно чтобы файл закрывался( иначе не сохраняются данные)
    {
        if(MyWindow.write_file_exist)
            MyWindow.outFile.close();
        if(MyWindow.read_file_exist)
            MyWindow.fromFile.close();
        e.accept();
    }
}
