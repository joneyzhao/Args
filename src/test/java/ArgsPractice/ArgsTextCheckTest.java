package ArgsPractice;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArgsTextCheckTest {
    @Test
    public void should_return_true_when_antiDuplicationCheck_given_argsText(){
        ArgsTextCheck argsTextCheck = new ArgsTextCheck("-l true -l 8080 -d user/logs");

        Boolean isDuplication = argsTextCheck.antiDuplicationCheck();

        assertEquals(false, isDuplication);

    }

    @Test
    public void should_return_true_when_illegalBlankSpaceCheck_given_argsText(){
        ArgsTextCheck argsTextCheck = new ArgsTextCheck("-l true -l 8080 - d user/logs");

        Boolean isDuplication = argsTextCheck.antiDuplicationCheck();

        Boolean hasIllegalBlankSpace = argsTextCheck.illegalBlankSpaceBetweenFlagCheck();

        assertEquals(false, isDuplication);
        assertEquals(false, hasIllegalBlankSpace);
    }


}
