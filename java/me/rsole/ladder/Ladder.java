package me.rsole.ladder;

import com.google.common.collect.Sets;
import me.rsole.graph.Graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Ladder {
  private Ladder() {}

  public static void main(String[] args) throws FileNotFoundException {
    Graph g = buildGraph(groupWords(getWords()));
  }

  private static Graph buildGraph(Map<String, Set<String>> groups) {
    Graph graph = new Graph();

    for (Map.Entry<String, Set<String>> g : groups.entrySet()) {
      if (g.getValue().size() <= 1) {
        continue;
      }

      for (List<String> product : Sets.cartesianProduct(g.getValue(), g.getValue())) {
        if (product.get(0).equals(product.get(1))) {
          continue;
        }

        graph.addBiEdge(product.get(0), product.get(1));
      }
    }

    return graph;
  }

  private static Map<String, Set<String>> groupWords(Set<String> words) {
    Map<String, Set<String>> groups = new HashMap<>();

    for (String w : words) {
      for (int i = 0; i < w.length(); i++) {
        String groupName = String.format("%s_%s", w.substring(0, i), w.substring(i + 1));
        groups.putIfAbsent(groupName, new HashSet<>());
        groups.get(groupName).add(w);
      }
    }

    return groups;
  }

  private static Set<String> getWords() throws FileNotFoundException {
    File f = new File("third_party/data/words.txt");
    Scanner s = new Scanner(f);
    Set<String> words = new HashSet<>();

    while (s.hasNextLine()) {
      words.add(s.nextLine());
    }

    return words;
  }
}
