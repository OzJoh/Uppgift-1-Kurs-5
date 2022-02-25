import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class morseTest {

    @Test
    public void EnglishToMorse() {

        //Arrange
        morseLogic myMorse = new morseLogic();

        //Act
        String actual = myMorse.translate("Hej");

        //Assert
        String expected = "**** * *--- ";

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void MorseToEnglish() {

        //Arrange
        morseLogic myMorse = new morseLogic();

        //Act
        String actual = myMorse.translate("**** * *---");

        //Assert
        String expected = "HEJ";

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void InvalidInput() {

        //Arrange
        morseLogic myMorse = new morseLogic();

        //Act
        String actual = myMorse.translate("Kalle*!@:;");

        //Assert
        String expected = "Error: använder ogiltiga tecken och/eller blandar morse alfabetet med engelska alfabetet.";

        Assertions.assertEquals(expected, actual);
    }

}
