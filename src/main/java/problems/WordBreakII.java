package problems;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/word-break-ii/
 *
 * <p>Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence
 * where each word is a valid dictionary word. Return all such possible sentences in any order.
 *
 * <p>Note that the same word in the dictionary may be reused multiple times in the segmentation.
 *
 * <p>Example 1:
 *
 * <p>Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"] Output: ["cats and
 * dog","cat sand dog"] Example 2:
 *
 * <p>Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
 * Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"] Explanation: Note
 * that you are allowed to reuse a dictionary word. Example 3:
 *
 * <p>Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"] Output: []
 */
public class WordBreakII {

  public List<String> wordBreak(String s, List<String> wordDict) {
    List<String> result = new LinkedList<>();
    helper(s, new StringBuilder(), wordDict, result);
    return result;
  }

  private void helper(String s, StringBuilder sb, List<String> wordDict, List<String> result) {
    if (s.isEmpty()) {
      result.add(sb.toString());
      return;
    }
    for (String w : wordDict) {
      if (w.length() > s.length()) {
        continue;
      }
      if (s.startsWith(w)) {
        StringBuilder newSb = new StringBuilder(sb.toString());
        if (newSb.length() > 0) {
          newSb.append(' ').append(w);
        } else {
          newSb.append(w);
        }
        helper(s.substring(w.length()), newSb, wordDict, result);
      }
    }
  }
}
