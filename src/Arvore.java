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

public void buscaEmOrdemSemRecursividade(No node) {
    Stack<No> pilha = new Stack<>();
    No atual = node;

    while (atual != null || !pilha.isEmpty()) {
        while (atual != null) {
            pilha.push(atual);
            atual = atual.esquerda;
        }

        atual = pilha.pop();
        System.out.print(atual.valor + " ");
        atual = atual.direita;
    }
}

public void buscaPosOrdemSemRecursividade(No node) {
    if (node == null) return;

    Stack<No> pilha1 = new Stack<>();
    Stack<No> pilha2 = new Stack<>();

    pilha1.push(node);

    while (!pilha1.isEmpty()) {
        No atual = pilha1.pop();
        pilha2.push(atual);

        if (atual.esquerda != null) pilha1.push(atual.esquerda);
        if (atual.direita != null) pilha1.push(atual.direita);
    }

    while (!pilha2.isEmpty()) {
        System.out.print(pilha2.pop().valor + " ");
    }
}

class No {
    String valor;
    No esquerda, direita;

    No(String valor) {
        this.valor = valor;
        esquerda = direita = null;
    }
}
public class ArvoreBinaria {
    public static int contarNos(No raiz) {
        if (raiz == null) {
            return 0;
        }
        return 1 + contarNos(raiz.esquerda) + contarNos(raiz.direita);
    }
    public static void main(String[] args) {

        No raiz = new No("A");
        raiz.esquerda = new No("B");
        raiz.direita = new No("C");
        raiz.esquerda.esquerda = new No("D");
        raiz.esquerda.direita = new No("E");
        raiz.direita.direita = new No("F");
        int totalNos = contarNos(raiz);
        System.out.println("Número de nós da árvore: " + totalNos);
    }
}
