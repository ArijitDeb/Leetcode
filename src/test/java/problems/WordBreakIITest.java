package problems;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class WordBreakIITest {

  WordBreakII wordBreakII = new WordBreakII();

  @Test
  public void test1() {
    List<String> expected = Lists.newArrayList("cats and dog", "cat sand dog");
    List<String> actual =
        wordBreakII.wordBreak(
            "catsanddog", Lists.newArrayList("cat", "cats", "and", "sand", "dog"));
    Assert.assertTrue(CollectionUtils.isEqualCollection(expected, actual));
  }

  @Test
  public void test2() {
    List<String> expected =
        Lists.newArrayList("pine apple pen apple", "pineapple pen apple", "pine applepen apple");
    List<String> actual =
        wordBreakII.wordBreak(
            "pineapplepenapple",
            Lists.newArrayList("apple", "pen", "applepen", "pine", "pineapple"));
    Assert.assertTrue(CollectionUtils.isEqualCollection(expected, actual));
  }

  @Test
  public void test3() {
    List<String> actual =
        wordBreakII.wordBreak("catsandog", Lists.newArrayList("cats", "dog", "sand", "and", "cat"));
    Assert.assertTrue(CollectionUtils.isEmpty(actual));
  }
}
