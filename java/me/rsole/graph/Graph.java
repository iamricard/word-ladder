package me.rsole.graph;

import java.util.HashMap;
import java.util.Map;

public class Graph {
  private Map<String, Vertex> vertices;

  public Graph() {
    this.vertices = new HashMap<>();
  }

  public void addVertex(String name) {
    vertices.putIfAbsent(name, new Vertex(name));
  }

  public void addEdge(String from, String to) {
    Vertex fromV = vertices.get(from);
    Vertex toV = vertices.get(to);

    if (fromV == null) {
      addVertex(from);
      fromV = getVertex(from);
    }

    if (toV == null) {
      addVertex(to);
      toV = getVertex(to);
    }

    fromV.addNeighbor(toV);
  }

  public void addBiEdge(String a, String b) {
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
