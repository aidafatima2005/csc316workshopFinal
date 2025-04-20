package edu.ncsu.csc316.dsa.graph;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.dsa.graph.Graph.Edge;
import edu.ncsu.csc316.dsa.graph.Graph.Vertex;
import edu.ncsu.csc316.dsa.map.Map;

/**
 * Test class for GraphTraversalUtil
 * Checks the expected outputs of depth first search
 * and breadth first search
 *
 * @author Dr. King
 * @author Aida Fatima 
 *
 */
public class GraphTraversalUtilTest {

    /**
     * Test the output of depth first search on a graph
     */ 
    @Test
    public void testDepthFirstSearch() {
    	//GraphTraversalUtil gtu = new GraphTraversalUtil();
    	Graph<String, String> graph = new EdgeListGraph<>();
        
        // Create vertices
        Vertex<String> a = graph.insertVertex("A");
        Vertex<String> b = graph.insertVertex("B");
        Vertex<String> c = graph.insertVertex("C");
        Vertex<String> d = graph.insertVertex("D");
        Vertex<String> e = graph.insertVertex("E");
        
        // Create edges
        Edge<String> ab = graph.insertEdge(a, b, "AB");
        Edge<String> ac = graph.insertEdge(a, c, "AC");
        Edge<String> bd = graph.insertEdge(b, d, "BD");
        Edge<String> ce = graph.insertEdge(c, e, "CE");

        Map<Vertex<String>, Edge<String>> dfsResult = GraphTraversalUtil.depthFirstSearch(graph, a);
        
        assertEquals(4, dfsResult.size());
        assertEquals(ab, dfsResult.get(b));
        assertEquals(ac, dfsResult.get(c));
        assertEquals(bd, dfsResult.get(d));
        assertEquals(ce, dfsResult.get(e));
    }
    
    /**
     * Test the output of the breadth first search
     */ 
    @Test
    public void testBreadthFirstSearch() {
    	Graph<String, String> graph = new EdgeListGraph<>();
        
        // Create vertices
        Vertex<String> a = graph.insertVertex("A");
        Vertex<String> b = graph.insertVertex("B");
        Vertex<String> c = graph.insertVertex("C");
        Vertex<String> d = graph.insertVertex("D");
        Vertex<String> e = graph.insertVertex("E");
        
        // Create edges
        Edge<String> ab = graph.insertEdge(a, b, "AB");
        Edge<String> ac = graph.insertEdge(a, c, "AC");
        Edge<String> bd = graph.insertEdge(b, d, "BD");
        Edge<String> ce = graph.insertEdge(c, e, "CE");

        Map<Vertex<String>, Edge<String>> bfsResult = GraphTraversalUtil.breadthFirstSearch(graph, a);
        
        assertEquals(4, bfsResult.size());
        assertEquals(ab, bfsResult.get(b));
        assertEquals(ac, bfsResult.get(c));
        assertEquals(bd, bfsResult.get(d));
        assertEquals(ce, bfsResult.get(e));
    }
    
}
