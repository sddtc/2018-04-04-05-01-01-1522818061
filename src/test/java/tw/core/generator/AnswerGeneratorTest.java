package tw.core.generator;

import org.junit.Before;
import org.junit.Test;
import tw.core.Answer;
import tw.core.exception.OutOfRangeAnswerException;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 在AnswerGeneratorTest文件中完成AnswerGenerator中对应的单元测试
 */
public class AnswerGeneratorTest {
    private RandomIntGenerator randomIntGenerator;
    private AnswerGenerator answerGenerator;
    private Answer answer;

    @Before
    public void setUp() throws Exception {
        randomIntGenerator = mock(RandomIntGenerator.class);
        answerGenerator = new AnswerGenerator(randomIntGenerator);
        answer = mock(Answer.class);
    }

    @Test
    public void testGenerateAnswerSuccess() throws OutOfRangeAnswerException {
        String randomAnser = "1 2 3 4";

        when(randomIntGenerator.generateNums(9,4)).thenReturn(randomAnser);

        assertEquals(answerGenerator.generate().toString(), Answer.createAnswer(randomAnser).toString());
    }

    @Test(expected = OutOfRangeAnswerException.class)
    public void testGenerateAnswerFailed() throws OutOfRangeAnswerException {
        String invalidRandomAnser = "1234";

        when(randomIntGenerator.generateNums(9,4)).thenReturn(invalidRandomAnser);

        answerGenerator.generate();
    }
}

