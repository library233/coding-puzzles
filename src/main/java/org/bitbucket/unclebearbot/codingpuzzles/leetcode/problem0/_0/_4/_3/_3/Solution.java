package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._4._3._3;

/*

https://leetcode.com/problems/minimum-genetic-mutation

433. Minimum Genetic Mutation
(Medium)

A gene string can be represented by an 8-character long string, with choices from 'A', 'C', 'G', and 'T'.

Suppose we need to investigate a mutation from a gene string startGene to a gene string endGene where one mutation is defined as one single character changed in the gene string.

    For example, "AACCGGTT" --> "AACCGGTA" is one mutation.

There is also a gene bank `bank` that records all the valid gene mutations. A gene must be in bank to make it a valid gene string.

Given the two gene strings startGene and endGene and the gene bank `bank`, return the minimum number of mutations needed to mutate from startGene to endGene. If there is no such a mutation, return -1.

Note that the starting point is assumed to be valid, so it might not be included in the bank.

Example 1:

Input: startGene = "AACCGGTT", endGene = "AACCGGTA", bank = ["AACCGGTA"]
Output: 1

Example 2:

Input: startGene = "AACCGGTT", endGene = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA","AAACGGTA"]
Output: 2

Constraints:

    0 <= bank.length <= 10
    startGene.length == endGene.length == bank[i].length == 8
    startGene, endGene, and bank[i] consist of only the characters ['A', 'C', 'G', 'T'].

 */

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    private final char[] genes = new char[]{'A', 'C', 'G', 'T'};

    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> available = Arrays.stream(bank).collect(Collectors.toSet());
        if (!available.contains(endGene)) {
            return -1;
        }
        int count = 0;
        if (Objects.equals(startGene, endGene)) {
            return count;
        }
        Set<String> mutated = new HashSet<>();
        mutated.add(startGene);
        Queue<String> mutating = new LinkedList<>();
        mutating.offer(startGene);
        while (!mutating.isEmpty()) {
            ++count;
            int size = mutating.size();
            for (int poll = 0; poll < size; ++poll) {
                char[] current = mutating.poll().toCharArray();
                for (int mutate = 0; mutate < current.length; ++mutate) {
                    for (char gene : genes) {
                        char temp = current[mutate];
                        if (temp == gene) {
                            continue;
                        }
                        current[mutate] = gene;
                        String mutation = new String(current);
                        current[mutate] = temp;
                        if (Objects.equals(mutation, endGene)) {
                            return count;
                        }
                        if (mutated.contains(mutation)) {
                            continue;
                        }
                        if (!available.contains(mutation)) {
                            continue;
                        }
                        mutated.add(mutation);
                        mutating.offer(mutation);
                    }
                }
            }
        }
        return -1;
    }
}
