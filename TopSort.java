package com.company;
import java.util.ArrayList;
import java.io.*;

class Vertex// Класс вершина
{
    char color;//Цвет ( 'g' - серый , 'b' - черный, 'w' - белый )
    int name; // номер вершины
    ArrayList<Edge> edg= new ArrayList<Edge>(); //Список ребер из вершины
    Vertex(int name) // конструктор
    {
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
    ArrayList<Vertex> vertices= new ArrayList<Vertex>();  // Список вершин
    ArrayList<Vertex> RTopSort= new ArrayList<Vertex>();     //Нужный список вершин, записанный в обратном порядке
};

public class TopSort
{
    static char White='w'; //Введем константные цвета
    static char Black='b';
    static char Gray='g';
    static Tree tree=new Tree(); //Создадим дерево
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
    public static void main(String[] args) throws IOException
    {
     	//считываем дерево
        TopSort(); // Делаем топологическую сортировку
        for(int i=0;i<tree.RTopSort.size();i++)
            System.out.print(tree.RTopSort.get(tree.RTopSort.size()-i-1).name); //выводим на экран все элементы нужного списка в обратном порядке
    }
}
