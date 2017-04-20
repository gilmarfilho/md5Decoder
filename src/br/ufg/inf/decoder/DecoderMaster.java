package br.ufg.inf.decoder;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DecoderMaster implements Runnable{
    Thread[] decoders = new Thread[20];
    Password password = Password.getInstance();

    @Override
    public void run() {
        for(int index = 0 ; index < 20 ; index++){
            if(password.getFinalTime() != 0){
                break;
            }
            Decoder decoder = new Decoder();
            this.decoders[index] = new Thread(decoder);
            this.decoders[index].start();
            index++;
        }
        try {
            this.decoders[0].join();
        } catch (InterruptedException ex) {
            Logger.getLogger(DecoderMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}
