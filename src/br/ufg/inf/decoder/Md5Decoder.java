package br.ufg.inf.decoder;

public class Md5Decoder {
    public static void main(String[] args) throws InterruptedException {
        Password password = Password.getInstance();
        String[] md5Passwords = new String[3];
        long[] times = new long[3];
        long initialTime;
        int index = 0;
       
        md5Passwords[0] = "17a0a00212dde12b063af7dc22fdf02b";
        md5Passwords[1] = "75abfe3020804dd73a2a6040da9df96c";
        md5Passwords[2] = "c77aeec24015ad7e6e0b1db9d9deed68";
        
        for(String md5Password : md5Passwords){
            initialTime = System.currentTimeMillis();
            password.setFinalTime(0);
            password.setActualPassword(md5Password);
            
            Thread generatorMaster = new Thread(new GeneratorMaster());
            generatorMaster.start();
            
            Thread decoderMaster = new Thread(new DecoderMaster());
            decoderMaster.start();
            
            decoderMaster.join();
            
            times[index] = password.getFinalTime() - initialTime;
            index++;
        }
        
        
        for(int i = 0 ; i < 3 ; i++){
            System.out.println("Password " + i + ":" + times[i]);
        }
    }
}
