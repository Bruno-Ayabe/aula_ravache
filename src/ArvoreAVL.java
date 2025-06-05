public class ArvoreAVL {

    private NoAVL raiz;

    private int altura(NoAVL no) {
        return (no == null) ? 0 : no.altura;
    }

    private int fatorBalanceamento(NoAVL no) {
        return (no == null) ? 0 : altura(no.esquerda) - altura(no.direita);
    }

    private NoAVL rotacaoDireita(NoAVL y) {
        NoAVL x = y.esquerda;
        NoAVL T2 = x.direita;

        x.direita = y;
        y.esquerda = T2;

        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;
        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;

        return x;
    }

    private NoAVL rotacaoEsquerda(NoAVL x) {
        NoAVL y = x.direita;
        NoAVL T2 = y.esquerda;

        y.esquerda = x;
        x.direita = T2;

        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;
        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;

        return y;
    }

    public void inserir(int chave) {
        raiz = inserir(raiz, chave);
    }

    private NoAVL inserir(NoAVL no, int chave) {
        if (no == null) return new NoAVL(chave);

        if (chave < no.chave)
            no.esquerda = inserir(no.esquerda, chave);
        else if (chave > no.chave)
            no.direita = inserir(no.direita, chave);
        else
            return no;

        no.altura = 1 + Math.max(altura(no.esquerda), altura(no.direita));

        int balance = fatorBalanceamento(no);

        if (balance > 1 && chave < no.esquerda.chave)
            return rotacaoDireita(no);

        if (balance < -1 && chave > no.direita.chave)
            return rotacaoEsquerda(no);

        if (balance > 1 && chave > no.esquerda.chave) {
            no.esquerda = rotacaoEsquerda(no.esquerda);
            return rotacaoDireita(no);
        }

        if (balance < -1 && chave < no.direita.chave) {
            no.direita = rotacaoDireita(no.direita);
            return rotacaoEsquerda(no);
        }

        return no;
    }

    public void remover(int chave) {
        raiz = remover(raiz, chave);
    }

    private NoAVL remover(NoAVL no, int chave) {
        if (no == null)
            return no;

        if (chave < no.chave)
            no.esquerda = remover(no.esquerda, chave);
        else if (chave > no.chave)
            no.direita = remover(no.direita, chave);
        else {
            if ((no.esquerda == null) || (no.direita == null)) {
                NoAVL temp = (no.esquerda != null) ? no.esquerda : no.direita;
                if (temp == null)
                    return null;
                else
                    no = temp;
            } else {
                NoAVL temp = menorValorNo(no.direita);
                no.chave = temp.chave;
                no.direita = remover(no.direita, temp.chave);
            }
        }

        no.altura = Math.max(altura(no.esquerda), altura(no.direita)) + 1;

        int balance = fatorBalanceamento(no);

        if (balance > 1 && fatorBalanceamento(no.esquerda) >= 0)
            return rotacaoDireita(no);

        if (balance > 1 && fatorBalanceamento(no.esquerda) < 0) {
            no.esquerda = rotacaoEsquerda(no.esquerda);
            return rotacaoDireita(no);
        }

        if (balance < -1 && fatorBalanceamento(no.direita) <= 0)
            return rotacaoEsquerda(no);

        if (balance < -1 && fatorBalanceamento(no.direita) > 0) {
            no.direita = rotacaoDireita(no.direita);
            return rotacaoEsquerda(no);
        }

        return no;
    }

    private NoAVL menorValorNo(NoAVL no) {
        NoAVL atual = no;
        while (atual.esquerda != null)
            atual = atual.esquerda;
        return atual;
    }

    public void preOrdem() {
        preOrdem(raiz);
        System.out.println();
    }

    private void preOrdem(NoAVL no) {
        if (no != null) {
            System.out.print(no.chave + " ");
            preOrdem(no.esquerda);
            preOrdem(no.direita);
        }
    }
}
