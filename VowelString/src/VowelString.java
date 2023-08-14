import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class VowelString {

    static void containsVowel(String input){

        char[] str = input.toLowerCase().toCharArray();
        char[] vowel = {'a','e','i','o','u'};


        int count = 0;

        for(int i = 0;i<vowel.length;i++ ){

            for(int j = 0;j<str.length;j++){

                  if(vowel[i] == str[j]){

                    count++;
                    break;
                  }
                
            }
        }


        if(count == 5){

            System.out.println("String contains all vowels");
        
        }else{

            System.out.println("Strings not contains all vowels");
        }


    }

    public static void main(String[] args) {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter The String:");

        String input = null;

        try{

            input = br.readLine();
        
        }catch (IOException e) {
        
        }
    
        containsVowel(input);


    }
    
}
