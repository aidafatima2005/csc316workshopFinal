package edu.ncsu.csc316.dsa.graph;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.graph.Graph.Edge;
import edu.ncsu.csc316.dsa.graph.Graph.Vertex;

/**
 * Test class for AdjacencyMapGraph.
 * This test suite validates the behavior of an adjacency map based graph,
 * ensuring that both the global graph structure and the per-vertex incidence maps
 * are correctly maintained for both undirected and directed graphs.
 *
 * Author: Your Name Here (adapt as needed)
 */
public class AdjacencyMapGraphTest {

	/** Test variable for undirected Graph */
    private Graph<String, Integer> undirectedGraph;
    
    /** Test variable for directed Graph */
    private Graph<String, Integer> directedGraph;
    
    /**
     * Set up new graph instances before each test.
     */
    @Before
    public void setUp() {
        undirectedGraph = new AdjacencyMapGraph<String, Integer>();
        directedGraph = new AdjacencyMapGraph<String, Integer>(true);
    }
    
    /**
     * Builds a sample undirected graph with 5 vertices and 10 edges.
     */
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
    
    /**
     * Builds a sample directed graph with 6 vertices and 11 edges.
     */
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
     * Test number of vertices
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
        assertTrue("Vertex iterator should have next", it.hasNext());
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
     * TEst Number of edges
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
     * Test edges
     */
    @Test
    public void testEdges() {
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
        Edge<Integer> e5 = undirectedGraph.insertEdge(v2, v3, 25);
        Edge<Integer> e6 = undirectedGraph.insertEdge(v2, v4, 30);
        Edge<Integer> e7 = undirectedGraph.insertEdge(v2, v5, 35);
        Edge<Integer> e8 = undirectedGraph.insertEdge(v3, v4, 40);
        Edge<Integer> e9 = undirectedGraph.insertEdge(v3, v5, 45);
        Edge<Integer> e10 = undirectedGraph.insertEdge(v4, v5, 50);
        
        int count = 0;
        boolean foundE1 = false, foundE2 = false, foundE3 = false, foundE4 = false,
                foundE5 = false, foundE6 = false, foundE7 = false, foundE8 = false,
                foundE9 = false, foundE10 = false;
        for(Edge<Integer> e : undirectedGraph.edges()){
            count++;
            if(e == e1) foundE1 = true;
            if(e == e2) foundE2 = true;
            if(e == e3) foundE3 = true;
            if(e == e4) foundE4 = true;
            if(e == e5) foundE5 = true;
            if(e == e6) foundE6 = true;
            if(e == e7) foundE7 = true;
            if(e == e8) foundE8 = true;
            if(e == e9) foundE9 = true;
            if(e == e10) foundE10 = true;
        }
        assertEquals("Undirected graph should have 10 edges", 10, count);
        assertTrue(foundE1);
        assertTrue(foundE2);
        assertTrue(foundE3);
        assertTrue(foundE4);
        assertTrue(foundE5);
        assertTrue(foundE6);
        assertTrue(foundE7);
        assertTrue(foundE8);
        assertTrue(foundE9);
        assertTrue(foundE10);
        
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
        
        count = 0;
        boolean foundE11 = false;
        for(Edge<Integer> e : directedGraph.edges()){
            count++;
            if(e == e1) foundE1 = true;
            if(e == e2) foundE2 = true;
            if(e == e3) foundE3 = true;
            if(e == e4) foundE4 = true;
            if(e == e5) foundE5 = true;
            if(e == e6) foundE6 = true;
            if(e == e7) foundE7 = true;
            if(e == e8) foundE8 = true;
            if(e == e9) foundE9 = true;
            if(e == e10) foundE10 = true;
            if(e == e11) foundE11 = true;
        }
        assertEquals("Directed graph should have 11 edges", 11, count);
        assertTrue(foundE1);
        assertTrue(foundE2);
        assertTrue(foundE3);
        assertTrue(foundE4);
        assertTrue(foundE5);
        assertTrue(foundE6);
        assertTrue(foundE7);
        assertTrue(foundE8);
        assertTrue(foundE9);
        assertTrue(foundE10);
        assertTrue(foundE11);
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
         assertEquals(e3, undirectedGraph.getEdge(v1, v4));
         assertEquals(e3, undirectedGraph.getEdge(v4, v1));
         assertEquals(e4, undirectedGraph.getEdge(v1, v5));
         assertEquals(e4, undirectedGraph.getEdge(v5, v1));
         assertEquals(e5, undirectedGraph.getEdge(v2, v3));
         assertEquals(e5, undirectedGraph.getEdge(v3, v2));
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
     * Test end Vertices
     */
    @Test
    public void testEndVertices() {
         // UNDIRECTED
         Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
         Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");
         Vertex<String> v3 = undirectedGraph.insertVertex("Wilmington");
         Vertex<String> v4 = undirectedGraph.insertVertex("Durham");
         Vertex<String> v5 = undirectedGraph.insertVertex("Greenville");
         Edge<Integer> e1 = undirectedGraph.insertEdge(v1, v2, 5);
         undirectedGraph.insertEdge(v1, v3, 10);
         undirectedGraph.insertEdge(v1, v4, 15);
         undirectedGraph.insertEdge(v1, v5, 20);
         undirectedGraph.insertEdge(v2, v3, 25);
         undirectedGraph.insertEdge(v2, v4, 30);
         undirectedGraph.insertEdge(v2, v5, 35);
         undirectedGraph.insertEdge(v3, v4, 40);
         undirectedGraph.insertEdge(v3, v5, 45);
         undirectedGraph.insertEdge(v4, v5, 50);
         
         Vertex<String>[] endpoints = undirectedGraph.endVertices(e1);
         assertNotNull(endpoints);
         assertEquals(v1, endpoints[0]);
         assertEquals(v2, endpoints[1]);
         
         // DIRECTED
         v1 = directedGraph.insertVertex("Raleigh");
         v2 = directedGraph.insertVertex("Asheville");
         v3 = directedGraph.insertVertex("Wilmington");
         v4 = directedGraph.insertVertex("Durham");
         v5 = directedGraph.insertVertex("Greenville");
         Vertex<String> v6 = directedGraph.insertVertex("Boone");
         e1 = directedGraph.insertEdge(v1, v2, 5);
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
         
         Vertex<String>[] directedEndpoints = directedGraph.endVertices(e1);
         assertNotNull(directedEndpoints);
         assertEquals(v1, directedEndpoints[0]);
         assertEquals(v2, directedEndpoints[1]);
    }
    
    /**
     * Test opposite
     */
    @Test
    public void testOpposite() {
         // UNDIRECTED
         Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
         Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");
         Vertex<String> v3 = undirectedGraph.insertVertex("Wilmington");
         Vertex<String> v4 = undirectedGraph.insertVertex("Durham");
         Edge<Integer> e1 = undirectedGraph.insertEdge(v1, v2, 5);
         Edge<Integer> e2 = undirectedGraph.insertEdge(v1, v3, 10);
         Edge<Integer> e3 = undirectedGraph.insertEdge(v1, v4, 15);
         undirectedGraph.insertEdge(v2, v3, 25);
         undirectedGraph.insertEdge(v2, v4, 30);
         undirectedGraph.insertEdge(v3, v4, 40);
         
         assertEquals(v2, undirectedGraph.opposite(v1, e1));
         assertEquals(v1, undirectedGraph.opposite(v2, e1));
         assertEquals(v1, undirectedGraph.opposite(v3, e2));
         assertEquals(v3, undirectedGraph.opposite(v1, e2));
         assertEquals(v1, undirectedGraph.opposite(v4, e3));
         assertEquals(v4, undirectedGraph.opposite(v1, e3));
         try {
             undirectedGraph.opposite(v4, e1);
             fail("Expected IllegalArgumentException for vertex not incident on edge");
         } catch (IllegalArgumentException ex) {
             // Expected exception
         }
         
         // DIRECTED
         v1 = directedGraph.insertVertex("Raleigh");
         v2 = directedGraph.insertVertex("Asheville");
         v3 = directedGraph.insertVertex("Wilmington");
         v4 = directedGraph.insertVertex("Durham");
         Vertex<String> v5 = directedGraph.insertVertex("Greenville");
         Vertex<String> v6 = directedGraph.insertVertex("Boone");
         e1 = directedGraph.insertEdge(v1, v2, 5);
         e2 = directedGraph.insertEdge(v1, v3, 10);
         e3 = directedGraph.insertEdge(v1, v4, 15);
         Edge<Integer> e4 = directedGraph.insertEdge(v1, v5, 20);
         Edge<Integer> e5 = directedGraph.insertEdge(v2, v3, 25);
         Edge<Integer> e6 = directedGraph.insertEdge(v2, v4, 30);
         Edge<Integer> e7 = directedGraph.insertEdge(v2, v5, 35);
         Edge<Integer> e8 = directedGraph.insertEdge(v3, v4, 40);
         Edge<Integer> e9 = directedGraph.insertEdge(v3, v5, 45);
         Edge<Integer> e10 = directedGraph.insertEdge(v4, v5, 50);
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
         try {
             directedGraph.opposite(v6, e1);
             fail("Expected IllegalArgumentException for vertex not incident with directed edge");
         } catch (IllegalArgumentException ex) {
             // Expected exception
         }
    }
    
    /**
     * Test out degree
     */
    @Test
    public void testOutDegree() {
        // UNDIRECTED: outDegree equals the count of incident edges.
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
        
        assertEquals(4, undirectedGraph.outDegree(v1));
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
     * Test in degree
     */
    @Test
    public void testInDegree() {
        // UNDIRECTED: inDegree equals incident edge count.
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
        
        assertEquals(4, undirectedGraph.inDegree(v1));
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
     * TEst incoming edges
     */
    @Test
    public void testIncomingEdges() {
        // UNDIRECTED: For an undirected graph incomingEdges equals outgoingEdges.
        Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
        Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");
        Vertex<String> v3 = undirectedGraph.insertVertex("Wilmington");
        Vertex<String> v4 = undirectedGraph.insertVertex("Durham");
        Vertex<String> v5 = undirectedGraph.insertVertex("Greenville");
        undirectedGraph.insertEdge(v1, v2, 5);
        undirectedGraph.insertEdge(v1, v3, 10);
        undirectedGraph.insertEdge(v1, v4, 15);
        undirectedGraph.insertEdge(v1, v5, 20);
        
        int count = 0;
//        for(Edge<Integer> e : undirectedGraph.incomingEdges(v1)){
//            count++;
//        }
        Iterator<Edge<Integer>> e = undirectedGraph.incomingEdges(v1).iterator();
        while(e.hasNext()) {
        	e.next();
        	count++;
        }
        assertEquals(4, count);
        
        // DIRECTED: For v5, expect incoming edges from v1, v2, v3, and v4.
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
//        for(Edge<Integer> e : directedGraph.incomingEdges(v5)){
//            count++;
//        }
        e = directedGraph.incomingEdges(v5).iterator();
        while(e.hasNext()) {
        	e.next();
        	count++;
        }
        assertEquals(4, count);
        
    }
    
    /**
     * Test out going edges
     */
    @Test
    public void testOutgoingEdges() {
        // UNDIRECTED: For a vertex in an undirected graph, outgoingEdges equals incident edges.
        Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
        Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");
        Vertex<String> v3 = undirectedGraph.insertVertex("Wilmington");
        Vertex<String> v4 = undirectedGraph.insertVertex("Durham");
        Vertex<String> v5 = undirectedGraph.insertVertex("Greenville");
        undirectedGraph.insertEdge(v1, v2, 5);
        undirectedGraph.insertEdge(v1, v3, 10);
        undirectedGraph.insertEdge(v1, v4, 15);
        undirectedGraph.insertEdge(v1, v5, 20);
        
        int count = 0;
        Iterator<Edge<Integer>> it =  undirectedGraph.outgoingEdges(v1).iterator();
        while (it.hasNext()){
        	it.next();
            count++;
        }
        assertEquals(4, count);
        
        // DIRECTED: For v1, outgoingEdges should list edges from v1.
        v1 = directedGraph.insertVertex("Raleigh");
        v2 = directedGraph.insertVertex("Asheville");
        v3 = directedGraph.insertVertex("Wilmington");
        v4 = directedGraph.insertVertex("Durham");
        v5 = directedGraph.insertVertex("Greenville");
        directedGraph.insertVertex("Boone");
        directedGraph.insertEdge(v1, v2, 5);
        directedGraph.insertEdge(v1, v3, 10);
        directedGraph.insertEdge(v1, v4, 15);
        directedGraph.insertEdge(v1, v5, 20);
        
        count = 0;
        it =  directedGraph.outgoingEdges(v1).iterator();
        while (it.hasNext()){
        	it.next();
            count++;
        }
        assertEquals(4, count);
    }
    
    /**
     * Test Insert Vertex
     */
    @Test
    public void testInsertVertex() {
        // UNDIRECTED
        assertEquals(0, undirectedGraph.numVertices());
        undirectedGraph.insertVertex("Fayetteville");
        assertEquals(1, undirectedGraph.numVertices());
        
        Iterator<Vertex<String>> it = undirectedGraph.vertices().iterator();
        assertTrue(it.hasNext());
        assertEquals("Fayetteville", it.next().getElement());
        assertFalse(it.hasNext());
        
        // DIRECTED
        directedGraph.insertVertex("Cary");
        assertEquals(1, directedGraph.numVertices());
        
        it = directedGraph.vertices().iterator();
        assertTrue(it.hasNext());
        assertEquals("Cary", it.next().getElement());
        assertFalse(it.hasNext());
    }
    
    /**
     * Test Insert edge
     */
    @Test
    public void testInsertEdge() {
        // UNDIRECTED
        Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
        Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");
        
        assertEquals(0, undirectedGraph.numEdges());
        Edge<Integer> e = undirectedGraph.insertEdge(v1, v2, 99);
        assertEquals(1, undirectedGraph.numEdges());
        Iterator<Edge<Integer>> it = undirectedGraph.edges().iterator();
        assertTrue(it.hasNext());
        assertEquals(e, it.next());
        assertFalse(it.hasNext());
        
        // Additionally, test that per-vertex maps are updated.
        assertEquals(1, undirectedGraph.outDegree(v1));
        assertEquals(1, undirectedGraph.inDegree(v2));
        
        // DIRECTED
        v1 = directedGraph.insertVertex("Raleigh");
        v2 = directedGraph.insertVertex("Asheville");
        
        assertEquals(0, directedGraph.numEdges());
        e = directedGraph.insertEdge(v1, v2, 88);
        assertEquals(1, directedGraph.numEdges());
        it = directedGraph.edges().iterator();
        assertTrue(it.hasNext());
        assertEquals(e, it.next());
        assertFalse(it.hasNext());
        
        // Check incidence maps.
        assertEquals(1, directedGraph.outDegree(v1));
        assertEquals(1, directedGraph.inDegree(v2));
    }
    
    /**
     * TEst Remove Vertex
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
        undirectedGraph.insertEdge(v2, v3, 25);
        undirectedGraph.insertEdge(v2, v4, 30);
        undirectedGraph.insertEdge(v2, v5, 35);
        undirectedGraph.insertEdge(v3, v4, 40);
        undirectedGraph.insertEdge(v3, v5, 45);
        undirectedGraph.insertEdge(v4, v5, 50);
        
        assertEquals(5, undirectedGraph.numVertices());
        assertEquals(10, undirectedGraph.numEdges());
        undirectedGraph.removeVertex(v5);
        assertEquals(4, undirectedGraph.numVertices());
        // In undirected graph, v5 is incident with 4 edges (e.g., those from v1, v2, v3, v4)
        assertEquals(6, undirectedGraph.numEdges());
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
        directedGraph.insertEdge(v2, v3, 25);
        directedGraph.insertEdge(v2, v4, 30);
        directedGraph.insertEdge(v2, v5, 35);
        directedGraph.insertEdge(v3, v4, 40);
        directedGraph.insertEdge(v3, v5, 45);
        directedGraph.insertEdge(v4, v5, 50);
        directedGraph.insertEdge(v5, v6, 55);
        
        assertEquals(6, directedGraph.numVertices());
        assertEquals(11, directedGraph.numEdges());
        directedGraph.removeVertex(v6);
        assertEquals(5, directedGraph.numVertices());
        assertEquals(10, directedGraph.numEdges());
        assertNull(directedGraph.getEdge(v5, v6));
        // Also, v6 should have no incoming or outgoing edges.
        Iterator<Edge<Integer>> itIn = directedGraph.incomingEdges(v6).iterator();
        assertFalse(itIn.hasNext());
        Iterator<Edge<Integer>> itOut = directedGraph.outgoingEdges(v6).iterator();
        assertFalse(itOut.hasNext());
    }
    
    /**
     * Test Remove Edge
     */
    @Test
    public void testRemoveEdge() {
        // UNDIRECTED
        Vertex<String> v1 = undirectedGraph.insertVertex("Raleigh");
        Vertex<String> v2 = undirectedGraph.insertVertex("Asheville");
        Vertex<String> v3 = undirectedGraph.insertVertex("Wilmington");
        Vertex<String> v4 = undirectedGraph.insertVertex("Durham");
        Vertex<String> v5 = undirectedGraph.insertVertex("Greenville");
        Edge<Integer> e1 = undirectedGraph.insertEdge(v1, v2, 5);
        undirectedGraph.insertEdge(v1, v3, 10);
        undirectedGraph.insertEdge(v1, v4, 15);
        undirectedGraph.insertEdge(v1, v5, 20);
        undirectedGraph.insertEdge(v2, v3, 25);
        undirectedGraph.insertEdge(v2, v4, 30);
        undirectedGraph.insertEdge(v2, v5, 35);
        Edge<Integer> e8 = undirectedGraph.insertEdge(v3, v4, 40);
        undirectedGraph.insertEdge(v3, v5, 45);
        undirectedGraph.insertEdge(v4, v5, 50);
        Edge<Integer> e11 = undirectedGraph.insertEdge(v5, v2, 60); // Duplicate undirected edge (or not inserted if duplicates not allowed)
        
        int initialEdges = undirectedGraph.numEdges();
        undirectedGraph.removeEdge(e1);
        assertEquals(initialEdges - 1, undirectedGraph.numEdges());
        assertNull(undirectedGraph.getEdge(v1, v2));
        
        undirectedGraph.removeEdge(e11);
        assertEquals(initialEdges - 2, undirectedGraph.numEdges());
        // Verify that the incidence maps for v2 and v5 no longer contain the removed edge.
        assertNull(undirectedGraph.getEdge(v2, v5));
        
        // DIRECTED
        v1 = directedGraph.insertVertex("Raleigh");
        v2 = directedGraph.insertVertex("Asheville");
        v3 = directedGraph.insertVertex("Wilmington");
        v4 = directedGraph.insertVertex("Durham");
        v5 = directedGraph.insertVertex("Greenville");
        Vertex<String> v6 = directedGraph.insertVertex("Boone");
        e1 = directedGraph.insertEdge(v1, v2, 5);
        directedGraph.insertEdge(v1, v3, 10);
        directedGraph.insertEdge(v1, v4, 15);
        directedGraph.insertEdge(v1, v5, 20);
        directedGraph.insertEdge(v2, v3, 25);
        directedGraph.insertEdge(v2, v4, 30);
        directedGraph.insertEdge(v2, v5, 35);
        directedGraph.insertEdge(v3, v4, 40);
        directedGraph.insertEdge(v3, v5, 45);
        directedGraph.insertEdge(v4, v5, 50);
        e11 = directedGraph.insertEdge(v5, v6, 55);
        
        initialEdges = directedGraph.numEdges();
        directedGraph.removeEdge(e1);
        assertEquals(initialEdges - 1, directedGraph.numEdges());
        assertNull(directedGraph.getEdge(v1, v2));
        
        directedGraph.removeEdge(e8);
        assertEquals(initialEdges - 2, directedGraph.numEdges());
        // Check that v3's outgoing and v4's incoming no longer have the edge.
        Iterator<Edge<Integer>> outIt = directedGraph.outgoingEdges(v3).iterator();
        while(outIt.hasNext()){
            assertNotEquals(e8, outIt.next());
        }
    }
    
    /**
     * Test the validate method by attempting to use an invalid vertex.
     */
    @Test
    public void testValidate() {
        Graph<String, Integer> graph = new AdjacencyMapGraph<>();
        // Create a dummy vertex that is not an AMVertex
        Graph.Vertex<String> invalidVertex = new Graph.Vertex<String>() {
            @Override
            public String getElement() {
                return "Invalid";
            }
        };
        assertThrows(IllegalArgumentException.class, () -> graph.getEdge(invalidVertex, invalidVertex));
    }
}
