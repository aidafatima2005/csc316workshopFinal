package edu.ncsu.csc316.dsa.graph;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import edu.ncsu.csc316.dsa.Weighted;
import edu.ncsu.csc316.dsa.graph.Graph.Edge;
import edu.ncsu.csc316.dsa.graph.Graph.Vertex;
import edu.ncsu.csc316.dsa.list.positional.PositionalList;

/**
 * Test class for MinimumSpanningTreeUtil
 * Checks the expected outputs of Prim-Jarnik's algorithm
 * and Kruskal's algorithm
 *
 * @author Dr. King
 * @author Aida Fatima 
 *
 */
public class MinimumSpanningTreeUtilTest {

    /**
     * Test the output of Prim-Jarnik's algorithm
     */ 
    @Test
    public void testPrimJarnik() {
    	Graph<String, Highway> g = new AdjacencyListGraph<>();
        Vertex<String> raleigh = g.insertVertex("Raleigh");
        Vertex<String> durham = g.insertVertex("Durham");
        Vertex<String> chapelHill = g.insertVertex("Chapel Hill");

        Highway hRD  = new Highway("I-40", 20);
        Highway hRCH = new Highway("I-40", 30);
        Highway hDCH = new Highway("15-501", 10);

        Edge<Highway> eRD  = g.insertEdge(raleigh, durham, hRD);
        g.insertEdge(raleigh, chapelHill, hRCH);
        Edge<Highway> eDCH = g.insertEdge(durham, chapelHill, hDCH);

        PositionalList<Edge<Highway>> tree = MinimumSpanningTreeUtil.primJarnik(g);
        assertEquals(2, tree.size());

        Iterator<Edge<Highway>> it = tree.iterator();
        assertEquals(eRD, it.next());
        assertEquals(eDCH, it.next());
    }
    
    /**
     * Test the output of Kruskal's algorithm
     */ 
    @Test
    public void testKruskal() {
    	Graph<String, Highway> g = new AdjacencyListGraph<>();
        Vertex<String> raleigh = g.insertVertex("Raleigh");
        Vertex<String> durham = g.insertVertex("Durham");
        Vertex<String> chapelHill = g.insertVertex("Chapel Hill");

        Highway hRD  = new Highway("I-40",    20);
        Highway hRCH = new Highway("I-40",    30);
        Highway hDCH = new Highway("15-501",  10);

        Edge<Highway> eRD = g.insertEdge(raleigh,   durham,     hRD);
        g.insertEdge(raleigh,   chapelHill, hRCH);
        Edge<Highway> eDCH = g.insertEdge(durham,    chapelHill, hDCH);

        PositionalList<Edge<Highway>> tree = MinimumSpanningTreeUtil.kruskal(g);
        assertEquals("Kruskal MST should have 2 edges", 2, tree.size());

        Iterator<Edge<Highway>> it = tree.iterator();
        assertEquals("First edge must be Durham->Chapel Hill",
                     eDCH, it.next());
        assertEquals(eRD, it.next());
    }
    
    /**
     * Simple weighted edge implementation representing a highway with a name
     * and a length (weight).
     */
    public class Highway implements Weighted {
    	
    	/** Name of the highway */
        private String name;
        
        /** Name of the length */
        private int length;

        /**
         * Constructs a new Highway.
         *
         * @param n the highway's name
         * @param l the highway's length (weight)
         */
        public Highway(String n, int l) {
            setName(n);
            setLength(l);
        }

        /**
         * Sets the highway's name.
         *
         * @param name the name to set
         */
        public void setName(String name) {
            this.name = name;
        }
        
        /**
         * Gets the highway's name.
         *
         * @return name the highway's name
         */
        public String getName() {
            return this.name;
        }

        /**
         * Returns the highway's length.
         *
         * @return the length of the highway
         */
        public int getLength() {
            return length;
        }

        /**
         * Sets the highway's length.
         *
         * @param length the length to set
         */
        public void setLength(int length) {
            this.length = length;
        }
        
        @Override
        public int getWeight() {
            return getLength();
        }
    }
    
}