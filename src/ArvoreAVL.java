public class ArvoreAVL {

   public NoAVL raiz;

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

   public NoAVL inserir(NoAVL no, int chave) {
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

   public void percursoEmOrdem(NoAVL no) {
       if (no != null) {
           percursoEmOrdem(no.esquerda);
           System.out.print(no.chave + " ");
           percursoEmOrdem(no.direita);
       }
   }
}
