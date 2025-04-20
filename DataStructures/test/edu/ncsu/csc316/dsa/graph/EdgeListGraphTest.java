package edu.ncsu.csc316.dsa.graph;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.graph.Graph.Edge;
import edu.ncsu.csc316.dsa.graph.Graph.Vertex;

/**
 * Test class for EdgeListGraph
 * Checks the expected outputs of the Graph abstract data type behaviors when using
 * an edge list graph data structure
 *
 * @author Dr. King
 * @author Aida Fatima 
 *
 */
public class EdgeListGraphTest {

	/** Test variable for Undirected Graph */
    private Graph<String, Integer> undirectedGraph;
    
    /** Test variable for Directed Graph */
    private Graph<String, Integer> directedGraph;
    
    /**
     * Create a new instance of an edge list graph before each test case executes
     */ 
    @Before
    public void setUp() {
        undirectedGraph = new EdgeListGraph<String, Integer>();
        directedGraph = new EdgeListGraph<String, Integer>(true);
    }
    
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
     * Test the output of the numVertices() behavior
     */     
    @Test
    public void testNumVertices() {
        buildUndirectedSample();
        assertEquals("Undirected graph should have 5 vertices", 5, undirectedGraph.numVertices());
        
        buildDirectedSample();       
        assertEquals("Directed graph should have 6 vertices", 6, directedGraph.numVertices());
    }

    /**
     * Test the output of the vertices() behavior
     */ 
    @Test
    public void testVertices() {
        // We cannot call buildUndirectedSample() because
        // then we would not be able to reference specific edges
        // or vertices when testing
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
        
        Iterator<Vertex<String>> it = undirectedGraph.vertices().iterator();
        assertTrue("Vertex iterator should have next", it.hasNext());
        assertEquals("First vertex should be Raleigh", v1, it.next());
        assertEquals("Second vertex should be Asheville", v2, it.next());
        assertEquals("Third vertex should be Wilmington", v3, it.next());
        assertEquals("Fourth vertex should be Durham", v4, it.next());
        assertEquals("Fifth vertex should be Greenville", v5, it.next());
        assertFalse("No more vertices", it.hasNext());
        
        
        
        // DIRECTED
        // We cannot call buildDirectedSample() because
        // then we would not be able to reference specific edges
        // or vertices when testing     
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
        
        it = directedGraph.vertices().iterator();
        assertTrue("Vertex iterator should have next", it.hasNext());
        assertEquals("First vertex should be Raleigh", v1, it.next());
        assertEquals("Second vertex should be Asheville", v2, it.next());
        assertEquals("Third vertex should be Wilmington", v3, it.next());
        assertEquals("Fourth vertex should be Durham", v4, it.next());
        assertEquals("Fifth vertex should be Greenville", v5, it.next());
        assertEquals("Sixth vertex should be Boone", v6, it.next());
        assertFalse("No more vertices", it.hasNext());
    }

    /**
     * Test the output of the numEdges() behavior
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
     * Test the output of the edges() behavior
     */ 
    @Test
    public void testEdges() {
        Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
        Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");
        Vertex<String> v3 = undirectedGraph.insertVertex("Wilmington");
        Vertex<String> v4 = undirectedGraph.insertVertex("Durham");
        Vertex<String> v5 = undirectedGraph.insertVertex("Greenville");
        Edge<Integer> e1 = undirectedGraph.insertEdge(v1, v2, 5);
        Edge<Integer> e2 = undirectedGraph.insertEdge(v1, v3, 10);
        Edge<Integer> e3 = undirectedGraph.insertEdge(v1, v4, 15);
        Edge<Integer> e4 = undirectedGraph.insertEdge(v1, v5, 20);
        Edge<Integer> e5 = undirectedGraph.insertEdge(v2, v3, 25);
        Edge<Integer> e6 = undirectedGraph.insertEdge(v2, v4, 30);
        Edge<Integer> e7 = undirectedGraph.insertEdge(v2, v5, 35);
        Edge<Integer> e8 = undirectedGraph.insertEdge(v3, v4, 40);
        Edge<Integer> e9 = undirectedGraph.insertEdge(v3, v5, 45);
        Edge<Integer> e10 = undirectedGraph.insertEdge(v4, v5, 50);
        
        Iterator<Edge<Integer>> edgeIt = undirectedGraph.edges().iterator();
        int count = 0;
        boolean foundE1 = false, foundE2 = false, foundE3 = false, foundE4 = false, foundE5 = false,
                foundE6 = false, foundE7 = false, foundE8 = false, foundE9 = false, foundE10 = false;
        while(edgeIt.hasNext()){
            Edge<Integer> curr = edgeIt.next();
            count++;
            if(curr == e1) foundE1 = true;
            if(curr == e2) foundE2 = true;
            if(curr == e3) foundE3 = true;
            if(curr == e4) foundE4 = true;
            if(curr == e5) foundE5 = true;
            if(curr == e6) foundE6 = true;
            if(curr == e7) foundE7 = true;
            if(curr == e8) foundE8 = true;
            if(curr == e9) foundE9 = true;
            if(curr == e10) foundE10 = true;
        }
        assertEquals("Undirected graph should have 10 edges", 10, count);
        assertTrue("Edge e1 should be in the graph", foundE1);
        assertTrue("Edge e2 should be in the graph", foundE2);
        assertTrue("Edge e3 should be in the graph", foundE3);
        assertTrue("Edge e4 should be in the graph", foundE4);
        assertTrue("Edge e5 should be in the graph", foundE5);
        assertTrue("Edge e6 should be in the graph", foundE6);
        assertTrue("Edge e7 should be in the graph", foundE7);
        assertTrue("Edge e8 should be in the graph", foundE8);
        assertTrue("Edge e9 should be in the graph", foundE9);
        assertTrue("Edge e10 should be in the graph", foundE10);
        
        // DIRECTED
        v1 = directedGraph.insertVertex("Raleigh");
        v2 = directedGraph.insertVertex("Asheville");
        v3 = directedGraph.insertVertex("Wilmington");
        v4 = directedGraph.insertVertex("Durham");
        v5 = directedGraph.insertVertex("Greenville");
        Vertex<String> v6 = directedGraph.insertVertex("Boone");
        e1 = directedGraph.insertEdge(v1, v2, 5);
        e2 = directedGraph.insertEdge(v1, v3, 10);
        e3 = directedGraph.insertEdge(v1, v4, 15);
        e4 = directedGraph.insertEdge(v1, v5, 20);
        e5 = directedGraph.insertEdge(v2, v3, 25);
        e6 = directedGraph.insertEdge(v2, v4, 30);
        e7 = directedGraph.insertEdge(v2, v5, 35);
        e8 = directedGraph.insertEdge(v3, v4, 40);
        e9 = directedGraph.insertEdge(v3, v5, 45);
        e10 = directedGraph.insertEdge(v4, v5, 50);
        Edge<Integer> e11 = directedGraph.insertEdge(v5, v6, 55);
        
        edgeIt = directedGraph.edges().iterator();
        count = 0;
        boolean foundE11 = false;
        while(edgeIt.hasNext()){
            Edge<Integer> curr = edgeIt.next();
            count++;
            if(curr == e1) foundE1 = true;
            if(curr == e2) foundE2 = true;
            if(curr == e3) foundE3 = true;
            if(curr == e4) foundE4 = true;
            if(curr == e5) foundE5 = true;
            if(curr == e6) foundE6 = true;
            if(curr == e7) foundE7 = true;
            if(curr == e8) foundE8 = true;
            if(curr == e9) foundE9 = true;
            if(curr == e10) foundE10 = true;
            if(curr == e11) foundE11 = true;
        }
        assertEquals("Directed graph should have 11 edges", 11, count);
        assertTrue("Edge e1 should be in the graph", foundE1);
        assertTrue("Edge e2 should be in the graph", foundE2);
        assertTrue("Edge e3 should be in the graph", foundE3);
        assertTrue("Edge e4 should be in the graph", foundE4);
        assertTrue("Edge e5 should be in the graph", foundE5);
        assertTrue("Edge e6 should be in the graph", foundE6);
        assertTrue("Edge e7 should be in the graph", foundE7);
        assertTrue("Edge e8 should be in the graph", foundE8);
        assertTrue("Edge e9 should be in the graph", foundE9);
        assertTrue("Edge e10 should be in the graph", foundE10);
        assertTrue("Edge e11 should be in the graph", foundE11);
    }

    /**
     * Test the output of the getEdge(v1,v2) behavior
     */ 
    @Test
    public void testGetEdge() {
        Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
        Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");
        Vertex<String> v3 = undirectedGraph.insertVertex("Wilmington");
        Vertex<String> v4 = undirectedGraph.insertVertex("Durham");
        Vertex<String> v5 = undirectedGraph.insertVertex("Greenville");
        Vertex<String> v6 = undirectedGraph.insertVertex("Boone");
        Edge<Integer> e1 = undirectedGraph.insertEdge(v1, v2, 5);
        Edge<Integer> e2 = undirectedGraph.insertEdge(v1, v3, 10);
        Edge<Integer> e3 = undirectedGraph.insertEdge(v1, v4, 15);
        Edge<Integer> e4 = undirectedGraph.insertEdge(v1, v5, 20);
        Edge<Integer> e5 = undirectedGraph.insertEdge(v2, v3, 25);
        Edge<Integer> e6 = undirectedGraph.insertEdge(v2, v4, 30);
        Edge<Integer> e7 = undirectedGraph.insertEdge(v2, v5, 35);
        Edge<Integer> e8 = undirectedGraph.insertEdge(v3, v4, 40);
        Edge<Integer> e9 = undirectedGraph.insertEdge(v3, v5, 45);
        Edge<Integer> e10 = undirectedGraph.insertEdge(v4, v5, 50);
        
        assertEquals(e1, undirectedGraph.getEdge(v1, v2));
        assertEquals(e1, undirectedGraph.getEdge(v2, v1));
        assertEquals(e2, undirectedGraph.getEdge(v1, v3));
        assertEquals(e2, undirectedGraph.getEdge(v3, v1));
        assertEquals(e3, undirectedGraph.getEdge(v4, v1));
        assertEquals(e3, undirectedGraph.getEdge(v1, v4));
        assertEquals(e4, undirectedGraph.getEdge(v5, v1));
        assertEquals(e4, undirectedGraph.getEdge(v1, v5));
        assertEquals(e5, undirectedGraph.getEdge(v3, v2));
        assertEquals(e5, undirectedGraph.getEdge(v2, v3));
        assertEquals(e6, undirectedGraph.getEdge(v2, v4));
        assertEquals(e6, undirectedGraph.getEdge(v4, v2));
        assertEquals(e7, undirectedGraph.getEdge(v2, v5));
        assertEquals(e7, undirectedGraph.getEdge(v5, v2));
        assertEquals(e8, undirectedGraph.getEdge(v3, v4));
        assertEquals(e8, undirectedGraph.getEdge(v4, v3));
        assertEquals(e9, undirectedGraph.getEdge(v3, v5));
        assertEquals(e9, undirectedGraph.getEdge(v5, v3));
        assertEquals(e10, undirectedGraph.getEdge(v4, v5));
        assertEquals(e10, undirectedGraph.getEdge(v5, v4));
        
        assertNull(undirectedGraph.getEdge(v1, v6));
        assertNull(undirectedGraph.getEdge(v2, v6));
        assertNull(undirectedGraph.getEdge(v6, v3));
        
        // DIRECTED
        v1 = directedGraph.insertVertex("Raleigh");
        v2 = directedGraph.insertVertex("Asheville");
        v3 = directedGraph.insertVertex("Wilmington");
        v4 = directedGraph.insertVertex("Durham");
        v5 = directedGraph.insertVertex("Greenville");
        v6 = directedGraph.insertVertex("Boone");
        e1 = directedGraph.insertEdge(v1, v2, 5);
        e2 = directedGraph.insertEdge(v1, v3, 10);
        e3 = directedGraph.insertEdge(v1, v4, 15);
        e4 = directedGraph.insertEdge(v1, v5, 20);
        e5 = directedGraph.insertEdge(v2, v3, 25);
        e6 = directedGraph.insertEdge(v2, v4, 30);
        e7 = directedGraph.insertEdge(v2, v5, 35);
        e8 = directedGraph.insertEdge(v3, v4, 40);
        e9 = directedGraph.insertEdge(v3, v5, 45);
        e10 = directedGraph.insertEdge(v4, v5, 50);
        Edge<Integer> e11 = directedGraph.insertEdge(v5, v6, 55);
        
        assertEquals(e1, directedGraph.getEdge(v1, v2));
        assertNull(directedGraph.getEdge(v2, v1));
        assertEquals(e11, directedGraph.getEdge(v5, v6));
    }

    /**
     * Test the output of the endVertices(e) behavior
     */ 
    @Test
    public void testEndVertices() {
        Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
        Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");
        Vertex<String> v3 = undirectedGraph.insertVertex("Wilmington");
        Vertex<String> v4 = undirectedGraph.insertVertex("Durham");
        Vertex<String> v5 = undirectedGraph.insertVertex("Greenville");
        Vertex<String> v6 = undirectedGraph.insertVertex("Boone");
        Edge<Integer> e1 = undirectedGraph.insertEdge(v1, v2, 5);
        Edge<Integer> e2 = undirectedGraph.insertEdge(v1, v3, 10);
        Edge<Integer> e3 = undirectedGraph.insertEdge(v1, v4, 15);
        Edge<Integer> e4 = undirectedGraph.insertEdge(v1, v5, 20);
        Edge<Integer> e5 = undirectedGraph.insertEdge(v2, v3, 25);
        Edge<Integer> e6 = undirectedGraph.insertEdge(v2, v4, 30);
        Edge<Integer> e7 = undirectedGraph.insertEdge(v2, v5, 35);
        Edge<Integer> e8 = undirectedGraph.insertEdge(v3, v4, 40);
        Edge<Integer> e9 = undirectedGraph.insertEdge(v3, v5, 45);
        Edge<Integer> e10 = undirectedGraph.insertEdge(v4, v5, 50);
        
        Vertex<String>[] endpoints = undirectedGraph.endVertices(e1);
        assertNotNull(endpoints);
        assertEquals(v1, endpoints[0]);
        assertEquals(v2, endpoints[1]);
        
        endpoints = undirectedGraph.endVertices(e2);
        assertNotNull(endpoints);
        assertEquals(v1, endpoints[0]);
        assertEquals(v3, endpoints[1]);
        
        endpoints = undirectedGraph.endVertices(e3);
        assertNotNull(endpoints);
        assertEquals(v1, endpoints[0]);
        assertEquals(v4, endpoints[1]);
        
        endpoints = undirectedGraph.endVertices(e4);
        assertNotNull(endpoints);
        assertEquals(v1, endpoints[0]);
        assertEquals(v5, endpoints[1]);
        
        endpoints = undirectedGraph.endVertices(e5);
        assertNotNull(endpoints);
        assertEquals(v2, endpoints[0]);
        assertEquals(v3, endpoints[1]);
        
        endpoints = undirectedGraph.endVertices(e6);
        assertNotNull(endpoints);
        assertEquals(v2, endpoints[0]);
        assertEquals(v4, endpoints[1]);
        
        endpoints = undirectedGraph.endVertices(e7);
        assertNotNull(endpoints);
        assertEquals(v2, endpoints[0]);
        assertEquals(v5, endpoints[1]);
        
        endpoints = undirectedGraph.endVertices(e8);
        assertNotNull(endpoints);
        assertEquals(v3, endpoints[0]);
        assertEquals(v4, endpoints[1]);
        
        endpoints = undirectedGraph.endVertices(e9);
        assertNotNull(endpoints);
        assertEquals(v3, endpoints[0]);
        assertEquals(v5, endpoints[1]);
        
        endpoints = undirectedGraph.endVertices(e10);
        assertNotNull(endpoints);
        assertEquals(v4, endpoints[0]);
        assertEquals(v5, endpoints[1]);
        
        // DIRECTED
        v1 = directedGraph.insertVertex("Raleigh");
        v2 = directedGraph.insertVertex("Asheville");
        v3 = directedGraph.insertVertex("Wilmington");
        v4 = directedGraph.insertVertex("Durham");
        v5 = directedGraph.insertVertex("Greenville");
        v6 = directedGraph.insertVertex("Boone");
        e1 = directedGraph.insertEdge(v1, v2, 5);
        e2 = directedGraph.insertEdge(v1, v3, 10);
        e3 = directedGraph.insertEdge(v1, v4, 15);
        e4 = directedGraph.insertEdge(v1, v5, 20);
        e5 = directedGraph.insertEdge(v2, v3, 25);
        e6 = directedGraph.insertEdge(v2, v4, 30);
        e7 = directedGraph.insertEdge(v2, v5, 35);
        e8 = directedGraph.insertEdge(v3, v4, 40);
        e9 = directedGraph.insertEdge(v3, v5, 45);
        e10 = directedGraph.insertEdge(v4, v5, 50);
        Edge<Integer> e11 = directedGraph.insertEdge(v5, v6, 55);
        
        Vertex<String>[] directedEndpoints = directedGraph.endVertices(e1);
        assertNotNull(directedEndpoints);
        assertEquals(v1, directedEndpoints[0]);
        assertEquals(v2, directedEndpoints[1]);
        
        endpoints = directedGraph.endVertices(e2);
        assertNotNull(endpoints);
        assertEquals(v1, endpoints[0]);
        assertEquals(v3, endpoints[1]);
        
        endpoints = directedGraph.endVertices(e3);
        assertNotNull(endpoints);
        assertEquals(v1, endpoints[0]);
        assertEquals(v4, endpoints[1]);
        
        endpoints = directedGraph.endVertices(e4);
        assertNotNull(endpoints);
        assertEquals(v1, endpoints[0]);
        assertEquals(v5, endpoints[1]);
        
        endpoints = directedGraph.endVertices(e5);
        assertNotNull(endpoints);
        assertEquals(v2, endpoints[0]);
        assertEquals(v3, endpoints[1]);
        
        endpoints = directedGraph.endVertices(e6);
        assertNotNull(endpoints);
        assertEquals(v2, endpoints[0]);
        assertEquals(v4, endpoints[1]);
        
        endpoints = directedGraph.endVertices(e7);
        assertNotNull(endpoints);
        assertEquals(v2, endpoints[0]);
        assertEquals(v5, endpoints[1]);
        
        endpoints = directedGraph.endVertices(e8);
        assertNotNull(endpoints);
        assertEquals(v3, endpoints[0]);
        assertEquals(v4, endpoints[1]);
        
        endpoints = directedGraph.endVertices(e9);
        assertNotNull(endpoints);
        assertEquals(v3, endpoints[0]);
        assertEquals(v5, endpoints[1]);
        
        endpoints = directedGraph.endVertices(e10);
        assertNotNull(endpoints);
        assertEquals(v4, endpoints[0]);
        assertEquals(v5, endpoints[1]);
        
        endpoints = directedGraph.endVertices(e11);
        assertNotNull(endpoints);
        assertEquals(v5, endpoints[0]);
        assertEquals(v6, endpoints[1]);
    }

    /**
     * Test the output of the opposite(v, e) behavior
     */ 
    @Test
    public void testOpposite() {
        Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
        Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");
        Vertex<String> v3 = undirectedGraph.insertVertex("Wilmington");
        Vertex<String> v4 = undirectedGraph.insertVertex("Durham");
        Vertex<String> v5 = undirectedGraph.insertVertex("Greenville");
        Vertex<String> v6 = undirectedGraph.insertVertex("Boone");
        Edge<Integer> e1 = undirectedGraph.insertEdge(v1, v2, 5);
        Edge<Integer> e2 = undirectedGraph.insertEdge(v1, v3, 10);
        Edge<Integer> e3 = undirectedGraph.insertEdge(v1, v4, 15);
        Edge<Integer> e4 = undirectedGraph.insertEdge(v1, v5, 20);
        Edge<Integer> e5 = undirectedGraph.insertEdge(v2, v3, 25);
        Edge<Integer> e6 = undirectedGraph.insertEdge(v2, v4, 30);
        Edge<Integer> e7 = undirectedGraph.insertEdge(v2, v5, 35);
        Edge<Integer> e8 = undirectedGraph.insertEdge(v3, v4, 40);
        Edge<Integer> e9 = undirectedGraph.insertEdge(v3, v5, 45);
        Edge<Integer> e10 = undirectedGraph.insertEdge(v4, v5, 50);
        
        // Expect the opposite of v1 in e1 to be v2 and vice versa
        assertEquals(v2, undirectedGraph.opposite(v1, e1));
        assertEquals(v1, undirectedGraph.opposite(v2, e1));
        assertEquals(v1, undirectedGraph.opposite(v3, e2));
        assertEquals(v3, undirectedGraph.opposite(v1, e2));
        assertEquals(v1, undirectedGraph.opposite(v4, e3));
        assertEquals(v4, undirectedGraph.opposite(v1, e3));
        assertEquals(v1, undirectedGraph.opposite(v5, e4));
        assertEquals(v5, undirectedGraph.opposite(v1, e4));
        assertEquals(v2, undirectedGraph.opposite(v3, e5));
        assertEquals(v3, undirectedGraph.opposite(v2, e5));
        assertEquals(v2, undirectedGraph.opposite(v4, e6));
        assertEquals(v4, undirectedGraph.opposite(v2, e6));
        assertEquals(v2, undirectedGraph.opposite(v5, e7));
        assertEquals(v5, undirectedGraph.opposite(v2, e7));
        assertEquals(v3, undirectedGraph.opposite(v4, e8));
        assertEquals(v4, undirectedGraph.opposite(v3, e8));
        assertEquals(v3, undirectedGraph.opposite(v5, e9));
        assertEquals(v5, undirectedGraph.opposite(v3, e9));
        assertEquals(v4, undirectedGraph.opposite(v5, e10));
        assertEquals(v5, undirectedGraph.opposite(v4, e10));
        
        try {
            undirectedGraph.opposite(v5, e1);
            fail("Expected IllegalArgumentException for vertex not incident with edge");
        } catch (IllegalArgumentException ex) {
            // Expected exception
        }
        
        // DIRECTED
        v1 = directedGraph.insertVertex("Raleigh");
        v2 = directedGraph.insertVertex("Asheville");
        v3 = directedGraph.insertVertex("Wilmington");
        v4 = directedGraph.insertVertex("Durham");
        v5 = directedGraph.insertVertex("Greenville");
        v6 = directedGraph.insertVertex("Boone");
        e1 = directedGraph.insertEdge(v1, v2, 5);
        e2 = directedGraph.insertEdge(v1, v3, 10);
        e3 = directedGraph.insertEdge(v1, v4, 15);
        e4 = directedGraph.insertEdge(v1, v5, 20);
        e5 = directedGraph.insertEdge(v2, v3, 25);
        e6 = directedGraph.insertEdge(v2, v4, 30);
        e7 = directedGraph.insertEdge(v2, v5, 35);
        e8 = directedGraph.insertEdge(v3, v4, 40);
        e9 = directedGraph.insertEdge(v3, v5, 45);
        e10 = directedGraph.insertEdge(v4, v5, 50);
        Edge<Integer> e11 = directedGraph.insertEdge(v5, v6, 55);
        
        assertEquals(v2, directedGraph.opposite(v1, e1));
        assertEquals(v1, directedGraph.opposite(v2, e1));
        assertEquals(v1, directedGraph.opposite(v3, e2));
        assertEquals(v3, directedGraph.opposite(v1, e2));
        assertEquals(v1, directedGraph.opposite(v4, e3));
        assertEquals(v4, directedGraph.opposite(v1, e3));
        assertEquals(v1, directedGraph.opposite(v5, e4));
        assertEquals(v5, directedGraph.opposite(v1, e4));
        assertEquals(v2, directedGraph.opposite(v3, e5));
        assertEquals(v3, directedGraph.opposite(v2, e5));
        assertEquals(v2, directedGraph.opposite(v4, e6));
        assertEquals(v4, directedGraph.opposite(v2, e6));
        assertEquals(v2, directedGraph.opposite(v5, e7));
        assertEquals(v5, directedGraph.opposite(v2, e7));
        assertEquals(v3, directedGraph.opposite(v4, e8));
        assertEquals(v4, directedGraph.opposite(v3, e8));
        assertEquals(v3, directedGraph.opposite(v5, e9));
        assertEquals(v5, directedGraph.opposite(v3, e9));
        assertEquals(v4, directedGraph.opposite(v5, e10));
        assertEquals(v5, directedGraph.opposite(v4, e10));
        
        assertEquals(v6, directedGraph.opposite(v5, e11));
        assertEquals(v5, directedGraph.opposite(v6, e11));
        
        assertEquals(v2, directedGraph.opposite(v1, e1));
        try {
            directedGraph.opposite(v6, e1);
            fail("Expected IllegalArgumentException for vertex not incident with directed edge");
        } catch (IllegalArgumentException ex) {
            // Expected exception
        }
    }

    /**
     * Test the output of the outDegree(v) behavior
     */ 
    @Test
    public void testOutDegree() {
    	// UNDIRECTED
        Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
        Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");
        Vertex<String> v3 = undirectedGraph.insertVertex("Wilmington");
        Vertex<String> v4 = undirectedGraph.insertVertex("Durham");
        Vertex<String> v5 = undirectedGraph.insertVertex("Greenville");
        Vertex<String> v6 = undirectedGraph.insertVertex("Boone");
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
        
        assertEquals(4, undirectedGraph.outDegree(v1));
        assertEquals(4, undirectedGraph.outDegree(v2));
        assertEquals(4, undirectedGraph.outDegree(v3));
        assertEquals(4, undirectedGraph.outDegree(v4));
        assertEquals(4, undirectedGraph.outDegree(v5));
        assertEquals(0, undirectedGraph.outDegree(v6));
        
        
        // DIRECTED
        v1 = directedGraph.insertVertex("Raleigh");
        v2 = directedGraph.insertVertex("Asheville");
        v3 = directedGraph.insertVertex("Wilmington");
        v4 = directedGraph.insertVertex("Durham");
        v5 = directedGraph.insertVertex("Greenville");
        v6 = directedGraph.insertVertex("Boone");
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
        
        assertEquals(4, directedGraph.outDegree(v1));
        assertEquals(3, directedGraph.outDegree(v2));
        assertEquals(2, directedGraph.outDegree(v3));
        assertEquals(1, directedGraph.outDegree(v4));
        assertEquals(1, directedGraph.outDegree(v5));
        assertEquals(0, directedGraph.outDegree(v6));
    }

    /**
     * Test the output of the inDegree(v) behavior
     */ 
    @Test
    public void testInDegree() {
        Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
        Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");
        Vertex<String> v3 = undirectedGraph.insertVertex("Wilmington");
        Vertex<String> v4 = undirectedGraph.insertVertex("Durham");
        Vertex<String> v5 = undirectedGraph.insertVertex("Greenville");
        Vertex<String> v6 = undirectedGraph.insertVertex("Boone");
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
        
        assertEquals(4, undirectedGraph.inDegree(v1));
        assertEquals(4, undirectedGraph.inDegree(v2));
        assertEquals(4, undirectedGraph.inDegree(v3));
        assertEquals(4, undirectedGraph.inDegree(v4));
        assertEquals(4, undirectedGraph.inDegree(v5));
        assertEquals(0, undirectedGraph.inDegree(v6));
        
        
        // DIRECTED
        v1 = directedGraph.insertVertex("Raleigh");
        v2 = directedGraph.insertVertex("Asheville");
        v3 = directedGraph.insertVertex("Wilmington");
        v4 = directedGraph.insertVertex("Durham");
        v5 = directedGraph.insertVertex("Greenville");
        v6 = directedGraph.insertVertex("Boone");
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
        
        assertEquals(0, directedGraph.inDegree(v1));
        assertEquals(1, directedGraph.inDegree(v2));
        assertEquals(2, directedGraph.inDegree(v3));
        assertEquals(3, directedGraph.inDegree(v4));
        assertEquals(4, directedGraph.inDegree(v5));
        assertEquals(1, directedGraph.inDegree(v6));
    }

    /**
     * Test the output of the outgoingEdges(v) behavior
     */ 
    @SuppressWarnings("unchecked")
    @Test
    public void testOutgoingEdges() {
        Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
        Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");
        Vertex<String> v3 = undirectedGraph.insertVertex("Wilmington");
        Vertex<String> v4 = undirectedGraph.insertVertex("Durham");
        Vertex<String> v5 = undirectedGraph.insertVertex("Greenville");
        Vertex<String> v6 = undirectedGraph.insertVertex("Boone");
        Edge<Integer> e1 = undirectedGraph.insertEdge(v1, v2, 5);
        Edge<Integer> e2 = undirectedGraph.insertEdge(v1, v3, 10);
        Edge<Integer> e3 = undirectedGraph.insertEdge(v1, v4, 15);
        Edge<Integer> e4 = undirectedGraph.insertEdge(v1, v5, 20);
        Edge<Integer> e5 = undirectedGraph.insertEdge(v2, v3, 25);
        Edge<Integer> e6 = undirectedGraph.insertEdge(v2, v4, 30);
        Edge<Integer> e7 = undirectedGraph.insertEdge(v2, v5, 35);
        Edge<Integer> e8 = undirectedGraph.insertEdge(v3, v4, 40);
        Edge<Integer> e9 = undirectedGraph.insertEdge(v3, v5, 45);
        Edge<Integer> e10 = undirectedGraph.insertEdge(v4, v5, 50);
        
        // We can use a custom arrayContains() helper method to check that
        // an array *contains* a certain target edge.
        // This is helpful for testing graph ADT behaviors where an order
        // of edges cannot be guaranteed (such as .outgoingEdges or .incomingEdges
        // in adjacencyMaps, etc.)      
        Edge<Integer>[] temp = (Edge<Integer>[]) new Edge[4];
        int count = 0;
        Iterator<Edge<Integer>> it = undirectedGraph.outgoingEdges(v1).iterator();
        assertTrue(it.hasNext());
        temp[count] = it.next();
        count++;
        temp[count] = it.next();
        count++;
        temp[count] = it.next();
        count++;
        temp[count] = it.next();
        count++;
        assertFalse(it.hasNext());
        assertTrue(arrayContains(temp, e1));
        assertTrue(arrayContains(temp, e2));
        assertTrue(arrayContains(temp, e3));
        assertTrue(arrayContains(temp, e4));
        
        it = undirectedGraph.outgoingEdges(v2).iterator();
        count = 0;
        assertTrue(it.hasNext());
        temp[count] = it.next();
        count++;
        temp[count] = it.next();
        count++;
        temp[count] = it.next();
        count++;
        temp[count] = it.next();
        count++;
        assertFalse(it.hasNext());
        assertTrue(arrayContains(temp, e5));
        assertTrue(arrayContains(temp, e6));
        assertTrue(arrayContains(temp, e7));
        
        it = undirectedGraph.outgoingEdges(v3).iterator();
        count = 0;
        assertTrue(it.hasNext());
        temp[count] = it.next();
        count++;
        temp[count] = it.next();
        count++;
        temp[count] = it.next();
        count++;
        temp[count] = it.next();
        count++;
        assertFalse(it.hasNext());
        assertTrue(arrayContains(temp, e2));
        assertTrue(arrayContains(temp, e5));
        assertTrue(arrayContains(temp, e8));
        assertTrue(arrayContains(temp, e9));
        
        it = undirectedGraph.outgoingEdges(v4).iterator();
        count = 0;
        assertTrue(it.hasNext());
        temp[count] = it.next();
        count++;
        temp[count] = it.next();
        count++;
        temp[count] = it.next();
        count++;
        temp[count] = it.next();
        count++;
        assertFalse(it.hasNext());
        assertTrue(arrayContains(temp, e3));
        assertTrue(arrayContains(temp, e6));
        assertTrue(arrayContains(temp, e8));
        assertTrue(arrayContains(temp, e10));
        
        it = undirectedGraph.outgoingEdges(v5).iterator();
        count = 0;
        assertTrue(it.hasNext());
        temp[count] = it.next();
        count++;
        temp[count] = it.next();
        count++;
        temp[count] = it.next();
        count++;
        temp[count] = it.next();
        count++;
        assertFalse(it.hasNext());
        assertTrue(arrayContains(temp, e4));
        assertTrue(arrayContains(temp, e7));
        assertTrue(arrayContains(temp, e9));
        assertTrue(arrayContains(temp, e10));
        
        
        // DIRECTED
        v1 = directedGraph.insertVertex("Raleigh");
        v2 = directedGraph.insertVertex("Asheville");
        v3 = directedGraph.insertVertex("Wilmington");
        v4 = directedGraph.insertVertex("Durham");
        v5 = directedGraph.insertVertex("Greenville");
        v6 = directedGraph.insertVertex("Boone");
        e1 = directedGraph.insertEdge(v1, v2, 5);
        e2 = directedGraph.insertEdge(v1, v3, 10);
        e3 = directedGraph.insertEdge(v1, v4, 15);
        e4 = directedGraph.insertEdge(v1, v5, 20);
        e5 = directedGraph.insertEdge(v2, v3, 25);
        e6 = directedGraph.insertEdge(v2, v4, 30);
        e7 = directedGraph.insertEdge(v2, v5, 35);
        e8 = directedGraph.insertEdge(v3, v4, 40);
        e9 = directedGraph.insertEdge(v3, v5, 45);
        e10 = directedGraph.insertEdge(v4, v5, 50);
        Edge<Integer> e11 = directedGraph.insertEdge(v5, v6, 55);
        
        
        Edge<Integer>[] tempNew = (Edge<Integer>[]) new Edge[4];
        int countNew = 0;
        Iterator<Edge<Integer>> itNew = directedGraph.outgoingEdges(v1).iterator();
        assertTrue(itNew.hasNext());
        tempNew[countNew] = itNew.next();
        countNew++;
        tempNew[countNew] = itNew.next();
        countNew++;
        tempNew[countNew] = itNew.next();
        countNew++;
        tempNew[countNew] = itNew.next();
        countNew++;
        assertFalse(itNew.hasNext());
        assertTrue(arrayContains(tempNew, e1));
        assertTrue(arrayContains(tempNew, e2));
        assertTrue(arrayContains(tempNew, e3));
        assertTrue(arrayContains(tempNew, e4));
        
        countNew = 0;
        itNew = directedGraph.outgoingEdges(v2).iterator();
        assertTrue(itNew.hasNext());
        tempNew[countNew] = itNew.next();
        countNew++;
        tempNew[countNew] = itNew.next();
        countNew++;
        tempNew[countNew] = itNew.next();
        countNew++;
        assertFalse(itNew.hasNext());
        assertTrue(arrayContains(tempNew, e5));
        assertTrue(arrayContains(tempNew, e6));
        assertTrue(arrayContains(tempNew, e7));
        
        countNew = 0;
        itNew = directedGraph.outgoingEdges(v3).iterator();
        assertTrue(itNew.hasNext());
        tempNew[countNew] = itNew.next();
        countNew++;
        tempNew[countNew] = itNew.next();
        countNew++;
        assertFalse(itNew.hasNext());
        assertTrue(arrayContains(tempNew, e8));
        assertTrue(arrayContains(tempNew, e9));
        
        countNew = 0;
        itNew = directedGraph.outgoingEdges(v4).iterator();
        assertTrue(itNew.hasNext());
        tempNew[countNew] = itNew.next();
        countNew++;
        assertFalse(itNew.hasNext());
        assertTrue(arrayContains(tempNew, e10));
        
        countNew = 0;
        itNew = directedGraph.outgoingEdges(v5).iterator();
        assertTrue(itNew.hasNext());
        tempNew[countNew] = itNew.next();
        countNew++;
        assertFalse(itNew.hasNext());
        assertFalse(arrayContains(tempNew, e10));
        assertTrue(arrayContains(tempNew, e11));
        
        countNew = 0;
        itNew = directedGraph.outgoingEdges(v6).iterator();
        assertFalse(itNew.hasNext());
        assertFalse(arrayContains(tempNew, e10));
        assertTrue(arrayContains(tempNew, e11));
    }
    
    // Helper method to check that an array contains a certain target.
    // This is helpful for testing graph ADT behaviors where an order
    // of edges cannot be guaranteed (such as .outgoingEdges or .incomingEdges)
    private boolean arrayContains(Edge<Integer>[] temp, Edge<Integer> target) {
        for(Edge<Integer> e : temp) {
            if(e == target) {
                return true;
            }
        }
        return false;
    }

    /**
     * Test the output of the incomingEdges(v) behavior
     */ 
    @Test
    public void testIncomingEdges() {
        Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
        Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");
        Vertex<String> v3 = undirectedGraph.insertVertex("Wilmington");
        Vertex<String> v4 = undirectedGraph.insertVertex("Durham");
        Vertex<String> v5 = undirectedGraph.insertVertex("Greenville");
        Vertex<String> v6 = undirectedGraph.insertVertex("Boone");
        Edge<Integer> e1 = undirectedGraph.insertEdge(v1, v2, 5);
        Edge<Integer> e2 = undirectedGraph.insertEdge(v1, v3, 10);
        Edge<Integer> e3 = undirectedGraph.insertEdge(v1, v4, 15);
        Edge<Integer> e4 = undirectedGraph.insertEdge(v1, v5, 20);
        Edge<Integer> e5 = undirectedGraph.insertEdge(v2, v3, 25);
        Edge<Integer> e6 = undirectedGraph.insertEdge(v2, v4, 30);
        Edge<Integer> e7 = undirectedGraph.insertEdge(v2, v5, 35);
        Edge<Integer> e8 = undirectedGraph.insertEdge(v3, v4, 40);
        Edge<Integer> e9 = undirectedGraph.insertEdge(v3, v5, 45);
        Edge<Integer> e10 = undirectedGraph.insertEdge(v4, v5, 50);
        
        Iterator<Edge<Integer>> inIt = undirectedGraph.incomingEdges(v1).iterator();
        assertEquals(e1, inIt.next());
        assertEquals(e2, inIt.next());
        assertEquals(e3, inIt.next());
        assertEquals(e4, inIt.next());
        assertFalse(inIt.hasNext());
        
        inIt = undirectedGraph.incomingEdges(v2).iterator();
        assertEquals(e1, inIt.next());
        assertEquals(e5, inIt.next());
        assertEquals(e6, inIt.next());
        assertEquals(e7, inIt.next());
        assertFalse(inIt.hasNext());
        
        inIt = undirectedGraph.incomingEdges(v3).iterator();
        assertEquals(e2, inIt.next());
        assertEquals(e5, inIt.next());
        assertEquals(e8, inIt.next());
        assertEquals(e9, inIt.next());
        assertFalse(inIt.hasNext());
        
        inIt = undirectedGraph.incomingEdges(v4).iterator();
        assertEquals(e3, inIt.next());
        assertEquals(e6, inIt.next());
        assertEquals(e8, inIt.next());
        assertEquals(e10, inIt.next());
        assertFalse(inIt.hasNext());
        
        inIt = undirectedGraph.incomingEdges(v5).iterator();
        assertEquals(e4, inIt.next());
        assertEquals(e7, inIt.next());
        assertEquals(e9, inIt.next());
        assertEquals(e10, inIt.next());
        assertFalse(inIt.hasNext());
        
        // DIRECTED
        v1 = directedGraph.insertVertex("Raleigh");
        v2 = directedGraph.insertVertex("Asheville");
        v3 = directedGraph.insertVertex("Wilmington");
        v4 = directedGraph.insertVertex("Durham");
        v5 = directedGraph.insertVertex("Greenville");
        v6 = directedGraph.insertVertex("Boone");
        e1 = directedGraph.insertEdge(v1, v2, 5);
        e2 = directedGraph.insertEdge(v1, v3, 10);
        e3 = directedGraph.insertEdge(v1, v4, 15);
        e4 = directedGraph.insertEdge(v1, v5, 20);
        e5 = directedGraph.insertEdge(v2, v3, 25);
        e6 = directedGraph.insertEdge(v2, v4, 30);
        e7 = directedGraph.insertEdge(v2, v5, 35);
        e8 = directedGraph.insertEdge(v3, v4, 40);
        e9 = directedGraph.insertEdge(v3, v5, 45);
        e10 = directedGraph.insertEdge(v4, v5, 50);
        Edge<Integer> e11 = directedGraph.insertEdge(v5, v6, 55);
        
        inIt = directedGraph.incomingEdges(v1).iterator();
        assertFalse(inIt.hasNext());
        
        inIt = directedGraph.incomingEdges(v2).iterator();
        assertEquals(e1, inIt.next());
        assertFalse(inIt.hasNext());
        
        inIt = directedGraph.incomingEdges(v3).iterator();
        assertEquals(e2, inIt.next());
        assertEquals(e5, inIt.next());
        assertFalse(inIt.hasNext());
        
        inIt = directedGraph.incomingEdges(v4).iterator();
        assertEquals(e3, inIt.next());
        assertEquals(e6, inIt.next());
        assertEquals(e8, inIt.next());
        assertFalse(inIt.hasNext());
        
        inIt = directedGraph.incomingEdges(v5).iterator();
        assertEquals(e4, inIt.next());
        assertEquals(e7, inIt.next());
        assertEquals(e9, inIt.next());
        assertEquals(e10, inIt.next());
        assertFalse(inIt.hasNext());
        
        inIt = directedGraph.incomingEdges(v6).iterator();
        assertEquals(e11, inIt.next());
        assertFalse(inIt.hasNext());
    }

    /**
     * Test the output of the insertVertex(x) behavior
     */ 
    @Test
    public void testInsertVertex() {
    	// UNDIRECTED
        assertEquals(0, undirectedGraph.numVertices());
        Vertex<String> v1 = undirectedGraph.insertVertex("Fayetteville");
        assertEquals(1, undirectedGraph.numVertices());
        
        Iterator<Vertex<String>> it = undirectedGraph.vertices().iterator();
        assertTrue(it.hasNext());
        assertEquals(v1, it.next());
        assertFalse(it.hasNext());      

        // DIRECTED
        Vertex<String> v2 = directedGraph.insertVertex("Cary");
        assertEquals(1, directedGraph.numVertices());
        
        it = directedGraph.vertices().iterator();
        assertTrue(it.hasNext());
        assertEquals(v2, it.next());
        assertFalse(it.hasNext()); 
    }

    /**
     * Test the output of the insertEdge(v1, v2, x) behavior
     */ 
    @Test
    public void testInsertEdge() {
    	
    	// UNDIRECTED
        Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
        Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");
        Vertex<String> v3 = undirectedGraph.insertVertex("Cary");
        
        assertEquals(0, undirectedGraph.numEdges());
        Edge<Integer> e1 = undirectedGraph.insertEdge(v1, v2, 99);
        assertEquals(1, undirectedGraph.numEdges());
        Iterator<Edge<Integer>> it = undirectedGraph.edges().iterator();
        assertTrue(it.hasNext());
        assertEquals(e1, it.next());
        assertFalse(it.hasNext());
        
        // DIRECTED
        directedGraph.insertVertex("Raleigh");
        directedGraph.insertVertex("Asheville");
        directedGraph.insertVertex("Cary");
        
        assertEquals(0, directedGraph.numEdges());
        e1 = directedGraph.insertEdge(v1, v3, 70);
        assertEquals(1, directedGraph.numEdges());
        it = directedGraph.edges().iterator();
        assertTrue(it.hasNext());
        assertEquals(e1, it.next());
        assertFalse(it.hasNext());
    }

    /**
     * Test the output of the removeVertex(v) behavior
     */ 
    @Test
    public void testRemoveVertex() {
        Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
        Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");
        Vertex<String> v3 = undirectedGraph.insertVertex("Wilmington");
        Vertex<String> v4 = undirectedGraph.insertVertex("Durham");
        Vertex<String> v5 = undirectedGraph.insertVertex("Greenville");
        Edge<Integer> e1 = undirectedGraph.insertEdge(v1, v2, 5);
        Edge<Integer> e2 = undirectedGraph.insertEdge(v1, v3, 10);
        Edge<Integer> e3 = undirectedGraph.insertEdge(v1, v4, 15);
        Edge<Integer> e4 = undirectedGraph.insertEdge(v1, v5, 20);
        undirectedGraph.insertEdge(v2, v3, 25);
        undirectedGraph.insertEdge(v2, v4, 30);
        Edge<Integer> e7 = undirectedGraph.insertEdge(v2, v5, 35);
        undirectedGraph.insertEdge(v3, v4, 40);
        Edge<Integer> e9 = undirectedGraph.insertEdge(v3, v5, 45);
        Edge<Integer> e10 = undirectedGraph.insertEdge(v4, v5, 50);
        
        assertEquals(5, undirectedGraph.numVertices());
        assertEquals(10, undirectedGraph.numEdges());
        undirectedGraph.removeVertex(v5);
        assertEquals(4, undirectedGraph.numVertices());
        assertEquals(6, undirectedGraph.numEdges());
        
        Iterator<Edge<Integer>> inIt = undirectedGraph.incomingEdges(v1).iterator();
        assertEquals(e1, inIt.next());
        assertEquals(e2, inIt.next());
        assertEquals(e3, inIt.next());
        assertFalse(inIt.hasNext());
        
        // DIRECTED
        v1 = directedGraph.insertVertex("Raleigh");
        v2 = directedGraph.insertVertex("Asheville");
        v3 = directedGraph.insertVertex("Wilmington");
        v4 = directedGraph.insertVertex("Durham");
        v5 = directedGraph.insertVertex("Greenville");
        Vertex<String> v6 = directedGraph.insertVertex("Boone");
        e1 = directedGraph.insertEdge(v1, v2, 5);
        e2 = directedGraph.insertEdge(v1, v3, 10);
        e3 = directedGraph.insertEdge(v1, v4, 15);
        e4 = directedGraph.insertEdge(v1, v5, 20);
        directedGraph.insertEdge(v2, v3, 25);
        directedGraph.insertEdge(v2, v4, 30);
        e7 = directedGraph.insertEdge(v2, v5, 35);
        directedGraph.insertEdge(v3, v4, 40);
        e9 = directedGraph.insertEdge(v3, v5, 45);
        e10 = directedGraph.insertEdge(v4, v5, 50);
        directedGraph.insertEdge(v5, v6, 55);
        
        assertEquals(6, directedGraph.numVertices());
        assertEquals(11, directedGraph.numEdges());
        directedGraph.removeVertex(v6);
        assertEquals(5, directedGraph.numVertices());
        assertEquals(10, directedGraph.numEdges());
        inIt = directedGraph.incomingEdges(v5).iterator();
        assertEquals(e4, inIt.next());
        assertEquals(e7, inIt.next());
        assertEquals(e9, inIt.next());
        assertEquals(e10, inIt.next());
        assertFalse(inIt.hasNext());
        
        inIt = directedGraph.outgoingEdges(v5).iterator();
        assertFalse(inIt.hasNext());
    }

    /**
     * Test the output of the removeEdge(e) behavior
     */ 
    @Test
    public void testRemoveEdge() {
        Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
        Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");
        Vertex<String> v3 = undirectedGraph.insertVertex("Wilmington");
        Vertex<String> v4 = undirectedGraph.insertVertex("Durham");
        Vertex<String> v5 = undirectedGraph.insertVertex("Greenville");
        Vertex<String> v6 = undirectedGraph.insertVertex("Boone");
        Edge<Integer> e1 = undirectedGraph.insertEdge(v1, v2, 5);
        Edge<Integer> e2 = undirectedGraph.insertEdge(v1, v3, 10);
        Edge<Integer> e3 = undirectedGraph.insertEdge(v1, v4, 15);
        Edge<Integer> e4 = undirectedGraph.insertEdge(v1, v5, 20);
        Edge<Integer> e5 = undirectedGraph.insertEdge(v2, v3, 25);
        undirectedGraph.insertEdge(v2, v4, 30);
        Edge<Integer> e7 = undirectedGraph.insertEdge(v2, v5, 35);
        Edge<Integer> e8 = undirectedGraph.insertEdge(v3, v4, 40);
        Edge<Integer> e9 = undirectedGraph.insertEdge(v3, v5, 45);
        Edge<Integer> e10 = undirectedGraph.insertEdge(v4, v5, 50);
        Edge<Integer> e11 = undirectedGraph.insertEdge(v5, v6, 55);
        
        assertEquals(6, undirectedGraph.numVertices());
        assertEquals(11, undirectedGraph.numEdges());
        undirectedGraph.removeEdge(e1);
        assertEquals(6, undirectedGraph.numVertices());
        assertEquals(10, undirectedGraph.numEdges());
        Iterator<Edge<Integer>> inIt = undirectedGraph.incomingEdges(v1).iterator();
        assertEquals(e2, inIt.next());
        assertEquals(e3, inIt.next());
        assertEquals(e4, inIt.next());
        assertFalse(inIt.hasNext());
        
        undirectedGraph.removeEdge(e11);
        inIt = undirectedGraph.outgoingEdges(v5).iterator();
        assertEquals(e4, inIt.next());
        assertEquals(e7, inIt.next());
        assertEquals(e9, inIt.next());
        assertEquals(e10, inIt.next());
        assertFalse(inIt.hasNext());
        
        assertEquals(6, undirectedGraph.numVertices());
        assertEquals(9, undirectedGraph.numEdges());
        
        inIt = undirectedGraph.outgoingEdges(v6).iterator();
        assertFalse(inIt.hasNext());
        
        inIt = undirectedGraph.incomingEdges(v6).iterator();
        assertFalse(inIt.hasNext());
        
        // DIRECTED
        v1 = directedGraph.insertVertex("Raleigh");
        v2 = directedGraph.insertVertex("Asheville");
        v3 = directedGraph.insertVertex("Wilmington");
        v4 = directedGraph.insertVertex("Durham");
        v5 = directedGraph.insertVertex("Greenville");
        v6 = directedGraph.insertVertex("Boone");
        e1 = directedGraph.insertEdge(v1, v2, 5);
        e2 = directedGraph.insertEdge(v1, v3, 10);
        e3 = directedGraph.insertEdge(v1, v4, 15);
        e4 = directedGraph.insertEdge(v1, v5, 20);
        e5 = directedGraph.insertEdge(v2, v3, 25);
        directedGraph.insertEdge(v2, v4, 30);
        e7 = directedGraph.insertEdge(v2, v5, 35);
        e8 = directedGraph.insertEdge(v3, v4, 40);
        e9 = directedGraph.insertEdge(v3, v5, 45);
        e10 = directedGraph.insertEdge(v4, v5, 50);
        e11 = directedGraph.insertEdge(v5, v6, 55);
        
        assertEquals(6, directedGraph.numVertices());
        assertEquals(11, directedGraph.numEdges());
        directedGraph.removeEdge(e1);
        assertEquals(6, directedGraph.numVertices());
        assertEquals(10, directedGraph.numEdges());
        inIt = directedGraph.incomingEdges(v2).iterator();
        assertFalse(inIt.hasNext());
         
        directedGraph.removeEdge(e8);
        inIt = directedGraph.outgoingEdges(v3).iterator();
        assertEquals(e9, inIt.next());
        assertFalse(inIt.hasNext());
        inIt = directedGraph.incomingEdges(v3).iterator();
        assertEquals(e2, inIt.next());
        assertEquals(e5, inIt.next());
        assertFalse(inIt.hasNext());
        
        assertEquals(6, directedGraph.numVertices());
        assertEquals(9, directedGraph.numEdges());
        
    }
    
    /**
     * Method to test Validate
     */
    @Test
    public void testValidate() {
        Graph<String, Integer> graph = new EdgeListGraph<>();
        
        // Create an invalid vertex that does not extend AbstractGraph.GraphVertex
        Graph.Vertex<String> invalidVertex = new Graph.Vertex<String>() {
            @Override
            public String getElement() {
                return "Invalid";
            }
        };
        
        assertThrows(IllegalArgumentException.class, () -> graph.getEdge(invalidVertex, invalidVertex));
    }
    
    /**
     * Method to test to string from abstract
     */
    @Test
    public void testToString() {
        Graph<String, String> graph = new EdgeListGraph<>();
        
        Vertex<String> v1 = graph.insertVertex("vertex1");
        Vertex<String> v2 = graph.insertVertex("vertex2");
        
        Edge<String> edge = graph.insertEdge(v1, v2, "edgeData");
        
        String expectedString = "Edge[element=edgeData]";
        assertEquals(expectedString, edge.toString());
    }
    
    /**
     * Method to test get element from abstract
     */
    @Test
    public void testGetElement() {
        Graph<String, String> graph = new EdgeListGraph<>();
        
        Vertex<String> v1 = graph.insertVertex("vertex1");
        Vertex<String> v2 = graph.insertVertex("vertex2");
        
        Edge<String> edge = graph.insertEdge(v1, v2, "edgeData");
        
        assertEquals("edgeData", edge.getElement());
    }

}
