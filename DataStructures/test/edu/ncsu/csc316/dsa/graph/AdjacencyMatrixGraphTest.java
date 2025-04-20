package edu.ncsu.csc316.dsa.graph;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.graph.Graph.Edge;
import edu.ncsu.csc316.dsa.graph.Graph.Vertex;

/**
 * Test class for AdjacencyMatrixGraph.
 * This class verifies that the AdjacencyMatrixGraph implementation
 * correctly maintains the graph data using a 2D edge matrix.
 * Tests are provided for both undirected and directed graphs.
 * 
 * Author: Your Name Here
 */
public class AdjacencyMatrixGraphTest {

	/** Test variable for Undirected Graph */
    private Graph<String, Integer> undirectedGraph;
    
    /** Test variable for Directed Graph */
    private Graph<String, Integer> directedGraph;
    
    /**
     * Test Set Up
     */
    @Before
    public void setUp() {
        undirectedGraph = new AdjacencyMatrixGraph<String, Integer>();
        directedGraph = new AdjacencyMatrixGraph<String, Integer>(true);
    }
    
    // Helper method to build a sample undirected graph with 5 vertices and 10 edges.
    private void buildUndirectedSample() {
        Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
        Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");
        Vertex<String> v3 = undirectedGraph.insertVertex("Wilmington");
        Vertex<String> v4 = undirectedGraph.insertVertex("Durham");
        Vertex<String> v5 = undirectedGraph.insertVertex("Greenville");
        
        undirectedGraph.insertEdge(v1, v2, 5);
        undirectedGraph.insertEdge(v1, v3, 10);
        undirectedGraph.insertEdge(v1, v4, 15);
        undirectedGraph.insertEdge(v1, v5, 20);
        undirectedGraph.insertEdge(v2, v3, 25);
        undirectedGraph.insertEdge(v2, v4, 30);
        undirectedGraph.insertEdge(v2, v5, 35);
        undirectedGraph.insertEdge(v3, v4, 40);
        undirectedGraph.insertEdge(v3, v5, 45);
        undirectedGraph.insertEdge(v4, v5, 50);
    }
    
    // Helper method to build a sample directed graph with 6 vertices and 11 edges.
    private void buildDirectedSample() {
        Vertex<String> v1 = directedGraph.insertVertex("Raleigh");
        Vertex<String> v2 = directedGraph.insertVertex("Asheville");
        Vertex<String> v3 = directedGraph.insertVertex("Wilmington");
        Vertex<String> v4 = directedGraph.insertVertex("Durham");
        Vertex<String> v5 = directedGraph.insertVertex("Greenville");
        Vertex<String> v6 = directedGraph.insertVertex("Boone");
        
        directedGraph.insertEdge(v1, v2, 5);
        directedGraph.insertEdge(v1, v3, 10);
        directedGraph.insertEdge(v1, v4, 15);
        directedGraph.insertEdge(v1, v5, 20);
        directedGraph.insertEdge(v2, v3, 25);
        directedGraph.insertEdge(v2, v4, 30);
        directedGraph.insertEdge(v2, v5, 35);
        directedGraph.insertEdge(v3, v4, 40);
        directedGraph.insertEdge(v3, v5, 45);
        directedGraph.insertEdge(v4, v5, 50);
        directedGraph.insertEdge(v5, v6, 55);
    }
    
    /**
     * Test Number of Vertices
     */
    @Test
    public void testNumVertices() {
        buildUndirectedSample();
        assertEquals("Undirected graph should have 5 vertices", 5, undirectedGraph.numVertices());
        
        buildDirectedSample();
        assertEquals("Directed graph should have 6 vertices", 6, directedGraph.numVertices());
    }
    
    /**
     * Test Vertices
     */
    @Test
    public void testVertices() {
        // UNDIRECTED
        undirectedGraph.insertVertex("Raleigh");
        undirectedGraph.insertVertex("Asheville");
        undirectedGraph.insertVertex("Wilmington");
        undirectedGraph.insertVertex("Durham");
        undirectedGraph.insertVertex("Greenville");
        
        Iterator<Vertex<String>> it = undirectedGraph.vertices().iterator();
        assertTrue("Vertex iterator should have a next element", it.hasNext());
        assertEquals("Raleigh", it.next().getElement());
        assertEquals("Asheville", it.next().getElement());
        assertEquals("Wilmington", it.next().getElement());
        assertEquals("Durham", it.next().getElement());
        assertEquals("Greenville", it.next().getElement());
        assertFalse("No more vertices expected", it.hasNext());
        
        // DIRECTED
        directedGraph.insertVertex("Raleigh");
        directedGraph.insertVertex("Asheville");
        directedGraph.insertVertex("Wilmington");
        directedGraph.insertVertex("Durham");
        directedGraph.insertVertex("Greenville");
        directedGraph.insertVertex("Boone");
        
        it = directedGraph.vertices().iterator();
        assertTrue(it.hasNext());
        assertEquals("Raleigh", it.next().getElement());
        assertEquals("Asheville", it.next().getElement());
        assertEquals("Wilmington", it.next().getElement());
        assertEquals("Durham", it.next().getElement());
        assertEquals("Greenville", it.next().getElement());
        assertEquals("Boone", it.next().getElement());
        assertFalse(it.hasNext());
    }
    
    /**
     * Test Number of Edges
     */
    @Test
    public void testNumEdges() {
        // UNDIRECTED
        Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
        Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");
        Vertex<String> v3 = undirectedGraph.insertVertex("Wilmington");
        Vertex<String> v4 = undirectedGraph.insertVertex("Durham");
        Vertex<String> v5 = undirectedGraph.insertVertex("Greenville");
        
        undirectedGraph.insertEdge(v1, v2, 5);
        undirectedGraph.insertEdge(v1, v3, 10);
        undirectedGraph.insertEdge(v1, v4, 15);
        undirectedGraph.insertEdge(v1, v5, 20);
        undirectedGraph.insertEdge(v2, v3, 25);
        undirectedGraph.insertEdge(v2, v4, 30);
        undirectedGraph.insertEdge(v2, v5, 35);
        undirectedGraph.insertEdge(v3, v4, 40);
        undirectedGraph.insertEdge(v3, v5, 45);
        undirectedGraph.insertEdge(v4, v5, 50);
        
        assertEquals("Undirected graph should have 10 edges", 10, undirectedGraph.numEdges());
        
        // DIRECTED
        v1 = directedGraph.insertVertex("Raleigh");
        v2 = directedGraph.insertVertex("Asheville");
        v3 = directedGraph.insertVertex("Wilmington");
        v4 = directedGraph.insertVertex("Durham");
        v5 = directedGraph.insertVertex("Greenville");
        Vertex<String> v6 = directedGraph.insertVertex("Boone");
        
        directedGraph.insertEdge(v1, v2, 5);
        directedGraph.insertEdge(v1, v3, 10);
        directedGraph.insertEdge(v1, v4, 15);
        directedGraph.insertEdge(v1, v5, 20);
        directedGraph.insertEdge(v2, v3, 25);
        directedGraph.insertEdge(v2, v4, 30);
        directedGraph.insertEdge(v2, v5, 35);
        directedGraph.insertEdge(v3, v4, 40);
        directedGraph.insertEdge(v3, v5, 45);
        directedGraph.insertEdge(v4, v5, 50);
        directedGraph.insertEdge(v5, v6, 55);
        
        assertEquals("Directed graph should have 11 edges", 11, directedGraph.numEdges());
    }
    
    /**
     * Test Edges
     */
    @Test
    public void testEdges() {
        // UNDIRECTED
        Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
        Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");
        Vertex<String> v3 = undirectedGraph.insertVertex("Wilmington");
        Vertex<String> v4 = undirectedGraph.insertVertex("Durham");
        Vertex<String> v5 = undirectedGraph.insertVertex("Greenville");
        undirectedGraph.insertEdge(v1, v2, 5);
        undirectedGraph.insertEdge(v1, v3, 10);
        undirectedGraph.insertEdge(v1, v4, 15);
        undirectedGraph.insertEdge(v1, v5, 20);
        undirectedGraph.insertEdge(v2, v3, 25);
        undirectedGraph.insertEdge(v2, v4, 30);
        undirectedGraph.insertEdge(v2, v5, 35);
        undirectedGraph.insertEdge(v3, v4, 40);
        undirectedGraph.insertEdge(v3, v5, 45);
        undirectedGraph.insertEdge(v4, v5, 50);
        
        int count = 0;
        Iterator<Edge<Integer>> it = undirectedGraph.edges().iterator();
        while (it.hasNext()) {
        	it.next();
        	count++;
        }
        assertEquals("Undirected graph should have 10 edges", 10, count);
        
        // DIRECTED
        v1 = directedGraph.insertVertex("Raleigh");
        v2 = directedGraph.insertVertex("Asheville");
        v3 = directedGraph.insertVertex("Wilmington");
        v4 = directedGraph.insertVertex("Durham");
        v5 = directedGraph.insertVertex("Greenville");
        Vertex<String> v6 = directedGraph.insertVertex("Boone");
        directedGraph.insertEdge(v1, v2, 5);
        directedGraph.insertEdge(v1, v3, 10);
        directedGraph.insertEdge(v1, v4, 15);
        directedGraph.insertEdge(v1, v5, 20);
        directedGraph.insertEdge(v2, v3, 25);
        directedGraph.insertEdge(v2, v4, 30);
        directedGraph.insertEdge(v2, v5, 35);
        directedGraph.insertEdge(v3, v4, 40);
        directedGraph.insertEdge(v3, v5, 45);
        directedGraph.insertEdge(v4, v5, 50);
        directedGraph.insertEdge(v5, v6, 55);
        
        count = 0;
        it = directedGraph.edges().iterator();
        while (it.hasNext()) {
        	it.next();
        	count++;
        }
        assertEquals("Directed graph should have 11 edges", 11, count);
    }
    
    /**
     * Test get edges
     */
    @Test
    public void testGetEdge() {
        // UNDIRECTED
        Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
        Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");
        Vertex<String> v3 = undirectedGraph.insertVertex("Wilmington");
        Vertex<String> v4 = undirectedGraph.insertVertex("Durham");
        Vertex<String> v5 = undirectedGraph.insertVertex("Greenville");
        Edge<Integer> e1 = undirectedGraph.insertEdge(v1, v2, 5);
        Edge<Integer> e2 = undirectedGraph.insertEdge(v1, v3, 10);
        Edge<Integer> e3 = undirectedGraph.insertEdge(v1, v4, 15);
        Edge<Integer> e4 = undirectedGraph.insertEdge(v1, v5, 20);
        
        assertEquals(e1, undirectedGraph.getEdge(v1, v2));
        assertEquals(e1, undirectedGraph.getEdge(v2, v1));
        assertEquals(e2, undirectedGraph.getEdge(v1, v3));
        assertEquals(e2, undirectedGraph.getEdge(v3, v1));
        assertEquals(e3, undirectedGraph.getEdge(v1, v4));
        assertEquals(e3, undirectedGraph.getEdge(v4, v1));
        assertEquals(e4, undirectedGraph.getEdge(v1, v5));
        assertEquals(e4, undirectedGraph.getEdge(v5, v1));
        
        // For missing edge.
        assertNull(undirectedGraph.getEdge(v2, v5));
        
        // DIRECTED
        v1 = directedGraph.insertVertex("Raleigh");
        v2 = directedGraph.insertVertex("Asheville");
        v3 = directedGraph.insertVertex("Wilmington");
        v4 = directedGraph.insertVertex("Durham");
        v5 = directedGraph.insertVertex("Greenville");
        Edge<Integer> e5 = directedGraph.insertEdge(v1, v2, 5);
        directedGraph.insertEdge(v1, v3, 10);
        directedGraph.insertEdge(v1, v4, 15);
        directedGraph.insertEdge(v1, v5, 20);
        
        assertEquals(e5, directedGraph.getEdge(v1, v2));
        assertNull(directedGraph.getEdge(v2, v1));
    }
    
    /**
     * Test end vertices
     */
    @Test
    public void testEndVertices() {
        // UNDIRECTED
        Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
        Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");
        Edge<Integer> e1 = undirectedGraph.insertEdge(v1, v2, 5);
        
        Vertex<String>[] endpoints = undirectedGraph.endVertices(e1);
        assertNotNull(endpoints);
        assertEquals(v1, endpoints[0]);
        assertEquals(v2, endpoints[1]);
        
        // DIRECTED
        v1 = directedGraph.insertVertex("Raleigh");
        v2 = directedGraph.insertVertex("Asheville");
        Edge<Integer> e2 = directedGraph.insertEdge(v1, v2, 5);
        
        endpoints = directedGraph.endVertices(e2);
        assertNotNull(endpoints);
        assertEquals(v1, endpoints[0]);
        assertEquals(v2, endpoints[1]);
    }
    
    /**
     * Test opposites
     */
    @Test
    public void testOpposite() {
        // UNDIRECTED
        Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
        Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");
        Vertex<String> v3 = undirectedGraph.insertVertex("Willow Spring");
        Edge<Integer> e1 = undirectedGraph.insertEdge(v1, v2, 5);
        assertEquals(v2, undirectedGraph.opposite(v1, e1));
        assertEquals(v1, undirectedGraph.opposite(v2, e1));
        try {
            undirectedGraph.opposite(v1, e1);
            // No exception expected here as v1 is incident.
        } catch (IllegalArgumentException ex) {
            fail("Did not expect an exception for a valid vertex.");
        }
        
        // DIRECTED
        v1 = directedGraph.insertVertex("Raleigh");
        v2 = directedGraph.insertVertex("Asheville");
        v3 = directedGraph.insertVertex("Willow Spring");
        Edge<Integer> e2 = directedGraph.insertEdge(v1, v2, 5);
        Edge<Integer> e3 = directedGraph.insertEdge(v1, v3, 10);
        assertEquals(v2, directedGraph.opposite(v1, e2));
        assertEquals(v1, directedGraph.opposite(v2, e2));

        try {
            directedGraph.opposite(v2, e3);
            fail("Expected IllegalArgumentException for vertex not incident as source");
        } catch (IllegalArgumentException ex) {
            // Expected
        }
    }
    
    /**
     * Test out degree
     */
    @Test
    public void testOutDegree() {
        // UNDIRECTED
        Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
        undirectedGraph.insertVertex("Asheville");
        undirectedGraph.insertVertex("Wilmington");
        undirectedGraph.insertVertex("Durham");
        undirectedGraph.insertVertex("Greenville");
        undirectedGraph.insertEdge(v1, undirectedGraph.vertices().iterator().next(), 5);
        // Because our test graph might not guarantee order, we simply test that
        // outDegree(v1) is nonzero once we add an edge.
        assertTrue(undirectedGraph.outDegree(v1) > 0);
        
        // DIRECTED
        v1 = directedGraph.insertVertex("Raleigh");
        directedGraph.insertVertex("Asheville");
        directedGraph.insertVertex("Wilmington");
        directedGraph.insertVertex("Durham");
        directedGraph.insertVertex("Greenville");
        directedGraph.insertVertex("Boone");
        // Insert some edges from v1.
        for(Vertex<String> v : directedGraph.vertices()){
            if(v != v1)
                directedGraph.insertEdge(v1, v, 10);
        }
        assertEquals(5, directedGraph.outDegree(v1));
    }
    
    /**
     * Test in degree
     */
    @Test
    public void testInDegree() {
        // UNDIRECTED
        Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
        undirectedGraph.insertVertex("Asheville");
        undirectedGraph.insertVertex("Wilmington");
        undirectedGraph.insertVertex("Durham");
        undirectedGraph.insertVertex("Greenville");
        undirectedGraph.insertEdge(v1, undirectedGraph.vertices().iterator().next(), 5);
        assertTrue(undirectedGraph.inDegree(v1) > 0);
        
        // DIRECTED
        Vertex<String> v2 = directedGraph.insertVertex("Raleigh");
        directedGraph.insertVertex("Asheville");
        directedGraph.insertVertex("Wilmington");
        directedGraph.insertVertex("Durham");
        directedGraph.insertVertex("Greenville");
        directedGraph.insertVertex("Boone");
        // Insert edges into v2.
        for (Vertex<String> v : directedGraph.vertices()){
            if(v != v2)
                directedGraph.insertEdge(v, v2, 10);
        }
        // There are 5 vertices other than v2.
        assertEquals(5, directedGraph.inDegree(v2));
    }
    
    /**
     * Test incoming edges
     */
    @Test
    public void testIncomingEdges() {
        // UNDIRECTED: incoming equals outgoing.
        Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
        Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");
        undirectedGraph.insertEdge(v1, v2, 5);
        int count = 0;
        Iterator<Edge<Integer>> it = undirectedGraph.incomingEdges(v2).iterator();
        while (it.hasNext()) {
        	it.next();
            count++;
        }
        assertTrue(count > 0);
        
        // DIRECTED:
        v1 = directedGraph.insertVertex("Raleigh");
        v2 = directedGraph.insertVertex("Asheville");
        directedGraph.insertEdge(v1, v2, 5);
        count = 0;
        it = directedGraph.incomingEdges(v2).iterator();
        while (it.hasNext()) {
        	it.next();
            count++;
        }
        assertEquals(1, count);
    }
    
    /**
     * Test Outgoing Edges
     */
    @Test
    public void testOutgoingEdges() {
        // UNDIRECTED: outgoing equals incident.
        Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
        undirectedGraph.insertVertex("Asheville");
        undirectedGraph.insertVertex("Wilmington");
        undirectedGraph.insertVertex("Durham");
        undirectedGraph.insertVertex("Greenville");
        undirectedGraph.insertEdge(v1, undirectedGraph.vertices().iterator().next(), 5);
        int count = 0;
        Iterator<Edge<Integer>> it = undirectedGraph.outgoingEdges(v1).iterator();
        while (it.hasNext()) {
        	it.next();
            count++;
        }
        
        assertEquals(count, 1);
        
        // DIRECTED:
        v1 = directedGraph.insertVertex("Raleigh");
        directedGraph.insertVertex("Asheville");
        directedGraph.insertVertex("Wilmington");
        directedGraph.insertVertex("Durham");
        directedGraph.insertVertex("Greenville");
        directedGraph.insertVertex("Boone");

        for(Vertex<String> v : directedGraph.vertices()){
            if(v != v1)
                directedGraph.insertEdge(v1, v, 5);
        }
        count = 0;
        it = directedGraph.outgoingEdges(v1).iterator();
        while (it.hasNext()) {
        	it.next();
            count++;
        }

        assertEquals(5, count);
    }
    
    /**
     * Test Remove Vertex
     */
    @Test
    public void testRemoveVertex() {
        // UNDIRECTED
        Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
        Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");
        Vertex<String> v3 = undirectedGraph.insertVertex("Wilmington");
        Vertex<String> v4 = undirectedGraph.insertVertex("Durham");
        Vertex<String> v5 = undirectedGraph.insertVertex("Greenville");
        undirectedGraph.insertEdge(v1, v2, 5);
        undirectedGraph.insertEdge(v1, v3, 10);
        undirectedGraph.insertEdge(v1, v4, 15);
        undirectedGraph.insertEdge(v1, v5, 20);
        assertEquals(5, undirectedGraph.numVertices());
        undirectedGraph.removeVertex(v5);
        assertEquals(4, undirectedGraph.numVertices());
        // For an undirected graph, removal of v5 should remove all edges incident to it.
        // For instance, getEdge(v1, v5) should return null.
        assertNull(undirectedGraph.getEdge(v1, v5));
        
        // DIRECTED
        v1 = directedGraph.insertVertex("Raleigh");
        v2 = directedGraph.insertVertex("Asheville");
        v3 = directedGraph.insertVertex("Wilmington");
        v4 = directedGraph.insertVertex("Durham");
        v5 = directedGraph.insertVertex("Greenville");
        Vertex<String> v6 = directedGraph.insertVertex("Boone");
        directedGraph.insertEdge(v1, v2, 5);
        directedGraph.insertEdge(v1, v3, 10);
        directedGraph.insertEdge(v1, v4, 15);
        directedGraph.insertEdge(v1, v5, 20);
        directedGraph.insertEdge(v5, v6, 25);
        assertEquals(6, directedGraph.numVertices());
        directedGraph.removeVertex(v6);
        assertEquals(5, directedGraph.numVertices());
        // Removal of v6 should remove the edge from v5 to v6.
        assertNull(directedGraph.getEdge(v5, v6));
    }
    
    /**
     * Test Remove Edge
     */
    @Test
    public void testRemoveEdge() {
        // UNDIRECTED
        Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
        Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");
        Edge<Integer> e1 = undirectedGraph.insertEdge(v1, v2, 5);
        int initialEdges = undirectedGraph.numEdges();
        undirectedGraph.removeEdge(e1);
        assertEquals(initialEdges - 1, undirectedGraph.numEdges());
        assertNull(undirectedGraph.getEdge(v1, v2));
        
        // DIRECTED
        v1 = directedGraph.insertVertex("Raleigh");
        v2 = directedGraph.insertVertex("Asheville");
        Edge<Integer> e2 = directedGraph.insertEdge(v1, v2, 5);
        initialEdges = directedGraph.numEdges();
        directedGraph.removeEdge(e2);
        assertEquals(initialEdges - 1, directedGraph.numEdges());
        assertNull(directedGraph.getEdge(v1, v2));
    }
    
    /**
     * Test validate by attempting to use an invalid vertex.
     */
    @Test
    public void testValidate() {
        Graph<String, Integer> graph = new AdjacencyMatrixGraph<>();
        // Create a dummy vertex that is not a MatrixVertex.
        Graph.Vertex<String> invalidVertex = new Graph.Vertex<String>() {
            @Override
            public String getElement() {
                return "Invalid";
            }
        };
        assertThrows(IllegalArgumentException.class, () -> graph.getEdge(invalidVertex, invalidVertex));
    }
}
