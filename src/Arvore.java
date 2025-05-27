public class Arvore {

    No raiz;
    
//Implementar um método para contar os nós da árvore
    public int contarNos(No node) {
        if (node == null) return 0;
        return 1 + contarNos(node.esquerda) + contarNos(node.direita);
    }
}

//Implementar um método para percorrer os nós da árvore em pré-ordem
    public void buscarPreOrdem(No node) {
        if (node != null) {
            System.out.print(node.valor + " ");
            buscarPreOrdem(node.esquerda);
            buscarPreOrdem(node.direita);
        }
    }

    //Implemente um método para percorrer os nós da árvore em em-ordem
    public void buscaEmOrdem(No node) {
        if (node != null) {
            buscarEmOrdem(node.esquerda);
            System.out.print(node.valor + " ");
            buscarPreOrdem(node.direita);
        }
    }

    //Implemente um método para percorrer os nós da árvore em pós-ordem
public void buscaPosOrdem (No node) {
    if (nomde != null) {
        buscaPosOrdem(node.esquerda);
        buscaPosOrdem(node.direita);
        System.out.print(node.valor + " ");
    }
}

    public void buscaEmNivel() {
        if (raiz == null) return;

        Queue<No> fila new LinkedList <>();

        while (!fila.isEmpty()) {
            No atual = fila.poll();
            System.out.print(atual.valor + " ");

            if (atual.esquerda != null) fila.add(atual.esquerda);
            if (atual.direita != null) fila.direita(atual.direita);
        }
    }

public void buscarPreOrdemSemRecursividade(No node) {
    if (node == null) return;

    Stack<No> pilha = new Stack<>();
    pilha.push(node);

    while (!pilha.isEmpty()) {
        No atual = pilha.pop();
        System.out.print(atual.valor + " ");

        if (atual.direita != null) {
            pilha.push(atual.direita);
        }
        if (atual.esquerda != null) {
            pilha.push(atual.esquerda);
        }
    }
}

