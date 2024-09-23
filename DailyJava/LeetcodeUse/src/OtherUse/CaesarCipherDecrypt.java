package OtherUse;

public class CaesarCipherDecrypt {

    public static String decrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();
        shift = shift % 26 + 26; // Ensure the shift is positive

        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                int originalAlphabetPosition = character - (Character.isUpperCase(character) ? 'A' : 'a');
                int newAlphabetPosition = (originalAlphabetPosition - shift) % 26;
                char newCharacter = (char) ((Character.isUpperCase(character) ? 'A' : 'a') + newAlphabetPosition);
                result.append(newCharacter);
            } else {
                result.append(character);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String cipherText = "CKRUBKDOJOGTATOBKXYOZE";
        String lowerCase = cipherText.toLowerCase();
        for(int i = 0; i < 26; i ++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < cipherText.length(); j ++){
                char c = (char) (((lowerCase.charAt(j) - 'a' + i) % 26) + 'a');
                sb.append(c);
            }
            System.out.println(sb.toString());
        }


    }
}
