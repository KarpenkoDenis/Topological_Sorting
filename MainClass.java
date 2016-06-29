/**
 * Created by Flame on 27.06.2016.
 */

import com.trolltech.qt.gui.*;
import com.trolltech.qt.gui.QWidget;

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
    boolean used; // Ходили ли мы через него
    Edge(Vertex v) // Конструктор
    {
        this.v = v;
        this.used=false;
    }
};

class Tree //Класс деерво
{
    static int MAX_VERTICES=1000;
    ArrayList<Vertex> vertices= new ArrayList<Vertex>();  // Список вершин
    ArrayList<Vertex> RTopSort= new ArrayList<Vertex>();     //Нужный список вершин, записанный в обратном порядке
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
};
public class MainClass extends QMainWindow{
    Ui_MainWindow MyWindow = new Ui_MainWindow();
    static tree= new Tree();
    static void dfs1(Vertex cur) //Поиск в глубину
    {
        cur.color=Gray; //Красим вершину в серый
        for (int i = 0; i<cur.edg.size(); i++)
        {
            if (cur.edg.get(i).v.color==White)
            {
                cur.edg.get(i).used=true;// прошли по ребру
                dfs1(cur.edg.get(i).v);//переходим к след. вершине
            }
        }
        cur.color=Black;//Вышли из вершины - покрасили в черный
        tree.RTopSort.add(cur);//Добавили её в список
    }

    static void TopSort() //Топологическая сортировка
    {
        tree.RTopSort.clear(); //Очистим список вершин
        int m=0; // m -номер вершины для которой будем вызывать поиск в глубину
        while(tree.RTopSort.size()<tree.vertices.size()) //пока все вершины не попали в нужый список
        {
            if((tree.vertices.get(m).color==White)) //Если вершина не пройдена
            {
                dfs1(tree.vertices.get(m)); // запускаем поиск в глубину
            }
            else m++;//иначе переходим к следуюещей
        }
    }
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
