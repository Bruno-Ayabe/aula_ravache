public class Main {
    public static void main(String[] args) {
        ArvoreAVL avl = new ArvoreAVL();

        int[] valores = {6, 4, 2, 5, 7, 9, 11};
        for (int v : valores) {
            avl.inserir(v);
        }

        System.out.println("Pré-ordem após inserção:");
        avl.preOrdem();

        System.out.println("Removendo 7");
        avl.remover(7);

        System.out.println("Pré-ordem após remoção:");
        avl.preOrdem();
    }
}

