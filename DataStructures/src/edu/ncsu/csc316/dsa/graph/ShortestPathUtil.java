package edu.ncsu.csc316.dsa.graph;

import edu.ncsu.csc316.dsa.Weighted;
import edu.ncsu.csc316.dsa.graph.Graph.Edge;
import edu.ncsu.csc316.dsa.graph.Graph.Vertex;
import edu.ncsu.csc316.dsa.map.Map;
import edu.ncsu.csc316.dsa.map.hashing.LinearProbingHashMap;
import edu.ncsu.csc316.dsa.priority_queue.AdaptablePriorityQueue;
import edu.ncsu.csc316.dsa.priority_queue.HeapAdaptablePriorityQueue;
import edu.ncsu.csc316.dsa.priority_queue.PriorityQueue.Entry;
import edu.ncsu.csc316.dsa.set.HashSet;
import edu.ncsu.csc316.dsa.set.Set;

/**
 * ShortestPathUtil provides a collection of behaviors for computing shortest
 * path spanning trees for a given graph.
 * 
 * The ShortestPathUtil class is based on the textbook:
 * Data Structures and Algorithms in Java, Sixth Edition
 * Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 */
public class ShortestPathUtil {
    
    /**
     * Computes shortest‐path distances from the start vertex to all others
     * using Dijkstra’s algorithm.
     * 
     * @param <V> the type of data in the graph vertices
     * @param <E> the type of data in the graph edges
     * @param graph graph the graph for which to compute a minimum spanning tree
     * @param start a starting vertex 
     * @return the shortest path costs from the starting vertex to every other vertex
     */
    public static <V, E extends Weighted> Map<Vertex<V>, Integer> dijkstra(Graph<V, E> graph, Vertex<V> start) {
    	
    	Map<Vertex<V>, Integer> c  = new LinearProbingHashMap<Vertex<V>, Integer>();

    	Map<Vertex<V>, Entry<Integer, Vertex<V>>> e = new LinearProbingHashMap<Vertex<V>, Entry<Integer, Vertex<V>>>();

        AdaptablePriorityQueue<Integer, Vertex<V>> q = new HeapAdaptablePriorityQueue<>();

        Set<Vertex<V>> s = new HashSet<>();
        
        for (Vertex<V> v : graph.vertices()) {
            int dist = v.equals(start) ? 0 : Integer.MAX_VALUE;
            c.put(v, dist);
            Entry<Integer, Vertex<V>> entry = q.insert(dist, v);
            e.put(v, entry);
        }
        
        while (!q.isEmpty()) {
        	
        	Entry<Integer, Vertex<V>> minE = q.min();
            Vertex<V> u = minE.getValue();
            q.remove(minE);
            s.add(u);

            for (Edge<E> edge : graph.outgoingEdges(u)) {
                Vertex<V> v = graph.opposite(u, edge);
                if (!s.contains(v)) {
                    Entry<Integer, Vertex<V>> vEntry = e.get(v);
                    int alt = c.get(u) + edge.getElement().getWeight();
                    if (alt < c.get(v)) {
                        c.put(v, alt);
                        q.replaceKey(vEntry, alt); 
                    }
                }
            }
        }

        return c;
    }
    
    /**
     * Reconstructs the shortest‐path tree edges given the distance map D.
     * For each v≠start, finds the unique incoming edge (u→v) satisfying
     * D(v) = D(u) + weight(u→v).
     * 
     * @param <V> the type of data in the graph vertices
     * @param <E> the type of data in the graph edges
     * @param graph graph the graph for which to compute a minimum spanning tree
     * @param start a starting vertex 
     * @param costs a map of the shortest path distances D
     * @return a map of the edges in the shortest path tree
     */
    public static <V, E extends Weighted> Map<Vertex<V>, Edge<E>> shortestPathTree(Graph<V, E> graph, Vertex<V> start, Map<Vertex<V>, Integer> costs) {
        Map<Vertex<V>, Edge<E>> tree = new LinearProbingHashMap<>();
        for (Vertex<V> v : graph.vertices()) {
            if (!v.equals(start)) {
                for (Edge<E> e : graph.incomingEdges(v)) {
                    Vertex<V> u = graph.opposite(v, e);
                    if (costs.get(v) == costs.get(u) + e.getElement().getWeight()) {
                        tree.put(v, e);
                        break;
                    }
                }
            }
        }
        return tree;
    }
}
