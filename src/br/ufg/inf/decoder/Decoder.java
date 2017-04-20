package br.ufg.inf.decoder;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Decoder implements Runnable{
    Password passwords = Password.getInstance();

    private String getPassword() throws InterruptedException{
        String nextPassword = passwords.nextPassword();
        nextPassword = passwords.toMd5(nextPassword);
        
        return nextPassword;
    }
    
    @Override
    public void run() {
        while(passwords.getFinalTime() == 0){
            try {
                System.out.println("Senha atual:             " + passwords.getActualPassword());
                System.out.println("Senha a ser comparada:   " + this.getPassword());
                if (this.getPassword().equals(passwords.getActualPassword())){
                    passwords.setFinalTime(System.currentTimeMillis());
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Decoder.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
