/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quebrasenha;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daiane
 */
public class MD5 {
    

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Angelo
 */


    public static String gerarMD5(String senha) {
        MessageDigest md;
        String crypto;
        try {
            /**
             * Aqui dizemos qual o tipo de hash vamos trabalhar, poderia ser
             * outro, como SHA.
             */            
            md = MessageDigest.getInstance("MD5");
            /**
             * Aqui trablamos com BigInteger para suportar uma grande quantia
             * de caracteres.
             */             
            BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
            
            /**
             * Transforma o hash em String.
             */
            crypto = hash.toString(16);
            
            /**
             * Verifica de um 0 a esquerda não foi ignorado, caso positivo,
             * readiciona.
             */
            if (crypto.length() % 2 != 0) {
                crypto = "0" + crypto;
            }
            
            /**
             * Retorna a palavra criptografada.
             */
            return crypto;
        } catch (NoSuchAlgorithmException ex) {
            System.out.println("Um erro ocorreu ao tentar gerar o Hash da palavra");
            return "ERRO";
        }
        

        
    }
}