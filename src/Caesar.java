public class Caesar {
    private int shift;
    String[] alphabet = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    public Caesar(int shift)
    {
        this.shift = shift;
    }
    public void setShift(int shift){
        this.shift = (shift % 26);
    }
    public String cipher(String original) {
        //creating array
        String[] split = new String[original.length()];
        //splitting the word into an array
        for (int i = 0; i < original.length(); i++) {
            split[i] = original.substring(i, i + 1);
            split[i] = split[i].toUpperCase();
        }
        //shifting each letter
        for (int j = 0; j < split.length; j++) {
            if (split[j].equals(" ")) {
                j++;
            }
            int k = 0;
            while (!(split[j].equals(alphabet[k]))) {
                k++;
            }
            int newIndex = ((k + shift) % alphabet.length + alphabet.length) % alphabet.length;
            split[j] = alphabet[newIndex];
        }
        //forming the word back together
        String result = "";
        for (int l = 0; l < split.length; l++)
        {
            if(split[l].equals(" "))
            {
                result = result + "";
            }
            result = result + split[l];
        }
        return result;
    }
}
