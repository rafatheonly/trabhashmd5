import quebrasenha.QS4digitos;

/**
 * Created by christian on 08/11/16.
 */
public class Main {
    public static void main(String[] args) {
        /**
         * Primeira Thread
         */
        QS4digitos grupoA = new QS4digitos(0, 14);
        Thread t1 = new Thread(grupoA);
        t1.start();

        /**
         * Segunda Thread
         */
        QS4digitos grupoB = new QS4digitos(14, 28);
        Thread t2 = new Thread(grupoB);
        t2.start();

        /**
         * Terceira Thread
         */
        QS4digitos grupoC = new QS4digitos(28, 42);
        Thread t3 = new Thread(grupoC);
        t3.start();

        /**
         * Quarta Thread
         */
        QS4digitos grupoD = new QS4digitos(42, 56);
        Thread t4 = new Thread(grupoD);
        t4.start();

        /**
         * Quinta Thread
         */
        QS4digitos grupoE = new QS4digitos(56, 71);
        Thread t5 = new Thread(grupoE);
        t5.start();

        /**
         * Sexta Thread
         */
        QS4digitos grupoF = new QS4digitos(71, 86);
        Thread t6 = new Thread(grupoF);
        t6.start();

    }
}
