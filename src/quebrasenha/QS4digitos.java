package quebrasenha;

import com.twmacinta.util.MD5;
import java.awt.Toolkit;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
//import java.security.MessageDigest;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.util.concurrent.atomic.AtomicInteger;

public class QS4digitos implements Runnable {

    private int inicial;
    private int fim;

    public QS4digitos(int inicial, int fim) {
        this.inicial = inicial;
        this.fim = fim;
    }

    public void run() {
        String[] hashs = {"60bb1f9914c26fb929b724398e5d2f66",
            "4998654b7d255461cd5110d5dcbac05b",
            "6af5f30627d3823099c2541d0b9326fc"
        };
        char[] tudo = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
            'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'x', 'y',
            'w', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
            'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'X', 'Y',
            'W', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '!',
            '@', '#', '$', '%', '&', '*', '(', ')', '_', '-', '+', '=', '[',
            ']', '{', '}', '?', '/', '|', '<', '>', '.', '\\'};
        char hash4[] = {'0', '0', '0', '0'};
        long tempoInicial = System.currentTimeMillis();
        for (int i = inicial; i < (fim); i++) {
            hash4[0] = tudo[i];
            //System.out.println(tudo[i]);
            for (int j = 0; j < tudo.length; j++) {
                hash4[1] = tudo[j];
                for (int k = 0; k < tudo.length; k++) {
                    hash4[2] = tudo[k];
                    for (int l = 0; l < tudo.length; l++) {
                        hash4[3] = tudo[l];
                        //String palavra = "" + tudo[i] + tudo[j] + tudo[k] + tudo[l];

                        for (int q = 0; q < hashs.length; q++) {
                            MD5 md5 = new MD5();
                            md5.Update(String.valueOf(hash4));
                            if ((md5.asHex()).equals(hashs[q])) {
                                BufferedWriter bw = null;
                                try {
                                    bw = new BufferedWriter(new FileWriter(new File("D:/hashs4.txt"), true));
                                    bw.write("Quebrou ");
                                    bw.write(" Senha: " + String.valueOf(hash4));
                                    bw.write(" Hash: " + hashs[q]);
                                    bw.write(" Tempo de Execução " + ((System.currentTimeMillis() - tempoInicial) / 1000));
                                    bw.newLine();
                                    bw.close();
                                    //i = j = k = l = 100;
                                    Toolkit.getDefaultToolkit().beep();

                                } catch (IOException ex) {
                                    Logger.getLogger(QS4digitos.class.getName()).log(Level.SEVERE, null, ex);
                                } finally {
                                    try {
                                        bw.close();
                                    } catch (IOException ex) {
                                        Logger.getLogger(QS4digitos.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

