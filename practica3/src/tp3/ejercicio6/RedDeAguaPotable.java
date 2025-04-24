package tp3.ejercicio6;

import tp3.ejercicio1_3.GeneralTree;

public class RedDeAguaPotable {
    private GeneralTree<Character> red;

    public RedDeAguaPotable(GeneralTree<Character> red) {
        this.red = red;
    }

    public double minimoCaudal(double caudal){
        return minimoCaudal(this.red, caudal);
    }

    private double minimoCaudal(GeneralTree<Character> ag, double caudal){
        double min = caudal; //--> seteo como minimo el caudal que me viene
        if(ag.isLeaf()){
           return min;
        }
        if(ag.hasChildren()){
            double aux = 0;
            for (GeneralTree<Character> child: ag.getChildren()){
                aux = minimoCaudal(child, caudal/ag.getChildren().size());
                if(aux < min) min = aux;
            }
        }
        return min;
    }
    public static void main(String[] args) {
        /*
                    A
          /       |       |       \
         B        C       D        E
               /     \   / | | | \
              F       G H  I J K  P
                        |     \
                        M      N

        */

        // Nivel más profundo
        GeneralTree<Character> l = new GeneralTree<>('L');
        GeneralTree<Character> m = new GeneralTree<>('M');
        GeneralTree<Character> n = new GeneralTree<>('N');

        // Nivel intermedio
        GeneralTree<Character> f = new GeneralTree<>('F');
        GeneralTree<Character> g = new GeneralTree<>('G');
        g.addChild(l);

        GeneralTree<Character> h = new GeneralTree<>('H');
        GeneralTree<Character> i = new GeneralTree<>('I');
        GeneralTree<Character> j = new GeneralTree<>('J');
        j.addChild(m);
        j.addChild(n);
        GeneralTree<Character> k = new GeneralTree<>('K');
        GeneralTree<Character> p = new GeneralTree<>('P');

        // Nivel padres intermedios
        GeneralTree<Character> b = new GeneralTree<>('B');

        GeneralTree<Character> c = new GeneralTree<>('C');
        c.addChild(f);
        c.addChild(g);

        GeneralTree<Character> d = new GeneralTree<>('D');
        d.addChild(h);
        d.addChild(i);
        d.addChild(j);
        d.addChild(k);
        d.addChild(p);

        GeneralTree<Character> e = new GeneralTree<>('E');

        // Raíz
        GeneralTree<Character> a = new GeneralTree<>('A');
        a.addChild(b);
        a.addChild(c);
        a.addChild(d);
        a.addChild(e);

        RedDeAguaPotable ag = new RedDeAguaPotable(a);
        // Prueba de impresión o recorrido (si querés testear)
        System.out.println(ag.minimoCaudal(1000));
    }
}
