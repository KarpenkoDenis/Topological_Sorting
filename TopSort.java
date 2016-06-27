package com.company;
import java.util.ArrayList;
import java.io.*;

class Vertex// Êëàññ âåðøèíà
{
    char color;//Öâåò ( 'g' - ñåðûé , 'b' - ÷åðíûé, 'w' - áåëûé )
    int name; // íîìåð âåðøèíû
    ArrayList<Edge> edg= new ArrayList<Edge>(); //Ñïèñîê ðåáåð èç âåðøèíû
    Vertex(int name) // êîíñòðóêòîð
    {
        this.color= 'w';   //Âíà÷àëå ó âñåõ öâåò - áåëûé
        this.name=name;    // Çàïèñàëè íîìåð âåðøèíû
    }
};

class Edge // Êëàññ ðåáðî
{
    Vertex v; // Â êàêóþ âåðøèíó îíî èäåò
    boolean used; // Õîäèëè ëè ìû ÷åðåç íåãî
    Edge(Vertex v) // Êîíñòðóêòîð
    {
        this.v = v;
        this.used=false;
    }
};

class Tree //Êëàññ äååðâî
{
    ArrayList<Vertex> vertices= new ArrayList<Vertex>();  // Ñïèñîê âåðøèí
    ArrayList<Vertex> RTopSort= new ArrayList<Vertex>();     //Íóæíûé ñïèñîê âåðøèí, çàïèñàííûé â îáðàòíîì ïîðÿäêå
};

public class TopSort
{
    static char White='w'; //Ââåäåì êîíñòàíòíûå öâåòà
    static char Black='b';
    static char Gray='g';
    static Tree tree=new Tree(); //Ñîçäàäèì äåðåâî
    static void dfs1(Vertex cur) //Ïîèñê â ãëóáèíó
    {
        cur.color=Gray; //Êðàñèì âåðøèíó â ñåðûé
        for (int i = 0; i<cur.edg.size(); i++)
        {
            if (cur.edg.get(i).v.color==White)
            {
                cur.edg.get(i).used=true;// ïðîøëè ïî ðåáðó
                dfs1(cur.edg.get(i).v);//ïåðåõîäèì ê ñëåä. âåðøèíå
            }
        }
        cur.color=Black;//Âûøëè èç âåðøèíû - ïîêðàñèëè â ÷åðíûé
        tree.RTopSort.add(cur);//Äîáàâèëè å¸ â ñïèñîê
    }

    static void TopSort() //Òîïîëîãè÷åñêàÿ ñîðòèðîâêà
    {
        tree.RTopSort.clear(); //Î÷èñòèì ñïèñîê âåðøèí
        int m=0; // m -íîìåð âåðøèíû äëÿ êîòîðîé áóäåì âûçûâàòü ïîèñê â ãëóáèíó
        while(tree.RTopSort.size()<tree.vertices.size()) //ïîêà âñå âåðøèíû íå ïîïàëè â íóæûé ñïèñîê
        {
            if((tree.vertices.get(m).color==White)) //Åñëè âåðøèíà íå ïðîéäåíà
            {
                dfs1(tree.vertices.get(m)); // çàïóñêàåì ïîèñê â ãëóáèíó
            }
            else m++;//èíà÷å ïåðåõîäèì ê ñëåäóþåùåé
        }
    }
    public static void main(String[] args) throws IOException
    {
     	        BufferedReader bReader = new BufferedReader (new InputStreamReader(System.in));
        char current;
        tree.vertices.clear();
        int x,y;
        Vertex v1=null,v2=null;
        boolean m=true;
        boolean k=true;
        String cStr;
        while(k)
        {
            System.out.println("1- продолжить ввод");
            System.out.println("2- завершить");
            cStr = bReader.readLine();
            x = Integer.parseInt(cStr);
            if(x==2)
            {
                k = false;
                break;
            }
            System.out.println("Введите 1ю вершину:");
            cStr = bReader.readLine();
            x = Integer.parseInt(cStr);
            for (int i = 0; i < tree.vertices.size(); i++)
                if (tree.vertices.get(i).name == x) {
                    v1 = tree.vertices.get(i);
                    m = false;
                }
            if (m) {
                v1 = new Vertex(x);
                tree.vertices.add(v1);
            }
            m = true;
            System.out.println("Введите 2ю вершину:");
            cStr = bReader.readLine();
            y = Integer.parseInt(cStr);
            for (int i = 0; i < tree.vertices.size(); i++)
                if (tree.vertices.get(i).name == y) {
                    v2 = tree.vertices.get(i);
                    m = false;
                }
            if (m) {
                v2 = new Vertex(y);
                tree.vertices.add(v2);
            }
            m = true;
            System.out.println("Ребро добавлено!");
            v1.edg.add(new Edge(v2));
        }//ñ÷èòûâàåì äåðåâî
        TopSort(); // Äåëàåì òîïîëîãè÷åñêóþ ñîðòèðîâêó
        for(int i=0;i<tree.RTopSort.size();i++)
            System.out.print(tree.RTopSort.get(tree.RTopSort.size()-i-1).name); //âûâîäèì íà ýêðàí âñå ýëåìåíòû íóæíîãî ñïèñêà â îáðàòíîì ïîðÿäêå
    }
}
