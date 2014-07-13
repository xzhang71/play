package cci.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xzhang71 on 7/13/14.
 */
public class TrieNode {
    public Map<Character, TrieNode> children = new HashMap<>();
}
