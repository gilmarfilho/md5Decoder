package br.ufg.inf.decoder;

public class GeneratorMaster implements Runnable {
    Thread[] generators = new Thread[35];
    Password password = Password.getInstance();
    
    @Override
    public void run() {
        String possibleLetters = "abcdefghijklmnopqrstuvxyz1234567890";
        int index = 0;
        
        for(char letter : possibleLetters.toCharArray()){
            if(password.getFinalTime() != 0){
                break;
            }
            Generator generator = new Generator(letter);
            this.generators[index] = new Thread(generator);
            this.generators[index].start();
            index++;
        }
    }
}
