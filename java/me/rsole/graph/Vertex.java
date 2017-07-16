package me.rsole.graph;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

class Vertex {
  private String key;
  private Map<String, Vertex> neighbors;

  Vertex(String key) {
    this.key = key;
    this.neighbors = new HashMap<>();
  }

  String getKey() {
    return key;
  }

  Collection<Vertex> getNeighbors() {
    return neighbors.values();
  }

  void addNeighbor(Vertex v) {
    this.neighbors.putIfAbsent(v.getKey(), v);
  }
}
