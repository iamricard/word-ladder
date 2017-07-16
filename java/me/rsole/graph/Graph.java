package me.rsole.graph;

import java.util.HashMap;
import java.util.Map;

public class Graph {
  private Map<String, Vertex> vertices;

  public Graph() {
    this.vertices = new HashMap<>();
  }

  void addVertex(String name) {
    vertices.putIfAbsent(name, new Vertex(name));
  }

  void addEdge(Vertex from, Vertex to) {
    vertices.get(from.getKey()).addNeighbor(to);
  }

  void addBiEdge(Vertex a, Vertex b) {
    addEdge(a, b);
    addEdge(b, a);
  }

  public Vertex getVertex(String name) {
    return vertices.get(name);
  }

  public Map<String, Vertex> getVertices() {
    return vertices;
  }

  public boolean contains(String k) {
    return vertices.containsKey(k);
  }

  public boolean contains(Vertex v) {
    return vertices.containsKey(v.getKey());
  }
}
