package br.ufg.inf.decoder;

public class Generator implements Runnable{
    char firstLetter;
    Password passwordController = Password.getInstance();
    
    public Generator(char firstLetter) {
        this.firstLetter = firstLetter;
    }
    
    private String passwordGenerator(){
        String possibleLetters = "abcdefghijklmnopqrstuvxyz1234567890";
        String generatedPassword = "";
        
        for (char letter1 : possibleLetters.toCharArray()){
            for (char letter2 : possibleLetters.toCharArray()){
                for (char letter3 : possibleLetters.toCharArray()){
                    for (char letter4 : possibleLetters.toCharArray()){
                        generatedPassword = "" + firstLetter + letter1 + letter2 + letter3 + letter4;
                        passwordController.addPassword(generatedPassword);
                    }
                }
            }
        }
        return generatedPassword;
    }
    
    @Override
    public void run() {
        this.passwordGenerator();
    }
}
