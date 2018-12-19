package utils;

public final class Encryption {

  public static String encryptDecryptXOR(String rawString) {

    // If encryption is enabled in Config.
    if (Config.getEncryption()) {

      // The key is predefined and hidden in code
      // TODO: Create a more complex code and store it somewhere better (FIX)
      char[] key = Config.getKEY().toCharArray();

      // Stringbuilder enables you to play around with strings and make useful stuff
      StringBuilder thisIsEncrypted = new StringBuilder();

      // TODO: This is where the magic of XOR is happening. Are you able to explain what is going on?
      /**
       * Loopet har en variable som stiger hvergang med 1 når loopet kører
       * Loopet køre konstant, indtil der ikke er flere karakterer i rawString
       * Når det er, at loopet kører til at starte med i=0, tager den binære værdier af den char som har placering 0 i raString
       * Den tager også binær værdi af den første char som ligger i araylisten
       * Man bruger XOR til at ligge binære værdierne sammen, hvor man derefter får en ny binær værdi som bliver lavet om til en char
       * Denne char tilføjes til thisIsEncrypted ved at bruge thisIsEncrypted.append
       * Hvis man finder ud af, at længden på charArray key er mindre end længden på rawString, kan den ved brug af % starte key forfra
       */
      for (int i = 0; i < rawString.length(); i++) {
        thisIsEncrypted.append((char) (rawString.charAt(i) ^ key[i % key.length]));
      }

      // We return the encrypted string
      return thisIsEncrypted.toString();

    } else {
      // We return without having done anything
      return rawString;
    }
  }
}
