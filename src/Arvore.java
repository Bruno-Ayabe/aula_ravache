public class Arvore {
    No raiz;
}

public int contarNos(No node) {
    if(node == null) return 0;
    return 1 + contarNos(node.esquerda) + contarNos(node.direita);
}

public void buscaPreOrdem(No node){
    if(node != null) {
        System.out.println(node.valor + " ");
        buscaPreOrdem(node.esquerda);
        buscaPreOrdem(node.direita);
    }
}

public class buscaEmOrdem(No node) {
    if (node != null) {
        buscaEmOrdem(node.esquerda);
        System.out.println(node.valor + valor " ");
        buscaEmOrdem(node.direita);
    }

}

public void buscaPosOrdem(No node) {
    if (node != null) {
        buscaPosOrdem(node.esquerda);
        buscaPosOrdem(node.direita);
        System.out.println(node.valor + " ");
    }
}

public void bucaEmNivel(No node) {
    if (raiz == null) return;

    Queue<No> fila = new LinkedList<>();
    No atual = fila.poll();
    System.out.println(atual.valor + " ");

    if (atual.esquerda !=null) fila.add(atual.esquerda);
    if(atual.direita !-null) fila.add(atual.direita);
}

public void buscaPreOrdemSemRecurividade(No raiz) {
    if (raiz == null) return;
    Stack<No> stack = new Stack<>();
    stack.push(raiz);
    while (!stack.isEmpty()) {
        No node = stack.pop();
        System.out.println(node.valor + " ");
        if (node.direita != null) stack.push(node.direita);
        if (node.esquerda != null) stack.push(node.esquerda);
    }
}

public void buscaEmOrdemSemRecurividade(No raiz) {
    Stack<No> stack = new Stack<>();
    No current = raiz;
    while (current != null || !stack.isEmpty()) {
        while (current != null) {
            stack.push(current);
            current = current.esquerda;
        }
        current = stack.pop();
        System.out.println(current.valor + " ");
        current = current.direita;
    }
}

public void buscaPosOrdemSemRecurividade(No raiz) {
    if (raiz == null) return;
    Stack<No> stack1 = new Stack<>();
    Stack<No> stack2 = new Stack<>();
    stack1.push(raiz);
    while (!stack1.isEmpty()) {
        No node = stack1.pop();
        stack2.push(node);
        if (node.esquerda != null) stack1.push(node.esquerda);
        if (node.direita != null) stack1.push(node.direita);
    }
    while (!stack2.isEmpty()) {
        System.out.println(stack2.pop().valor + " ");
    }
}

public int contagemNoIterativo(No raiz){
    if(raiz == null) {
        return 0;
    }

    int contador = 0;
    Stack<No> pilha = new Stack<>();
    pilha.push(raiz);

    while(!pilha.isEmpty()){
        No atual = pilha.pop();
        contador++;

        if(atual.esquerda != null){
            pilha.push(atual.esquerda);
        }
        if(atual.direita != null){
            pilha.push(atual.direita);
        }
    }

    return contador;
}

public int contarFolhasRecursivo(No raiz) {
    if (raiz == null) return 0;
    if (raiz.esquerda == null && raiz.direita == null) return 1;
    return contarFolhasRecursivo(raiz.esquerda) + contarFolhasRecursivo(raiz.direita);
}

public int contarFolhasIterativo(No raiz) {
    if (raiz == null) return 0;

    int contadorFolhas = 0;
    Stack<No> stack = new Stack<>();
    stack.push(raiz);

    while (!stack.isEmpty()) {
        No atual = stack.pop();
        if (atual.esquerda == null && atual.direita == null) {
            contadorFolhas++;
        }
        if (atual.direita != null) stack.push(atual.direita);
        if (atual.esquerda != null) stack.push(atual.esquerda);
    }
    return contadorFolhas;
}

public int contarNosComFila(No raiz) {
    if (raiz == null) return 0;

    int contadorNos = 0;
    Queue<No> queue = new LinkedList<>();
    queue.offer(raiz);

    while (!queue.isEmpty()) {
        No atual = queue.poll();
        contadorNos++;

        if (atual.esquerda != null) queue.offer(atual.esquerda);
        if (atual.direita != null) queue.offer(atual.direita);
    }
    return contadorNos;
}


