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
