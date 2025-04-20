package edu.ncsu.csc316.dsa.graph;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.dsa.Weighted;
import edu.ncsu.csc316.dsa.graph.Graph.Edge;
import edu.ncsu.csc316.dsa.graph.Graph.Vertex;
import edu.ncsu.csc316.dsa.map.Map;

/**
 * Unit tests for the ShortestPathUtil class, verifying both Dijkstra's
 * algorithm and the shortest-path tree reconstruction.
 *
 * @author Dr. King
 * @author // Your Name Here
 */
public class ShortestPathUtilTest {

    /**
     * Tests that Dijkstra's algorithm computes the correct minimum path costs
     * from a given start vertex in a simple three-node graph.
     */
    @Test
    public void testDijkstra() {
        Graph<String, Highway> g = new AdjacencyListGraph<>();
        Vertex<String> raleigh = g.insertVertex("Raleigh");
        Vertex<String> durham = g.insertVertex("Durham");
        Vertex<String> chapelHill = g.insertVertex("Chapel Hill");

        Highway hRD = new Highway("I-40", 20);
        Highway hRCH = new Highway("I-40", 30);
        Highway hDCH = new Highway("15-501", 10);
        g.insertEdge(raleigh, durham, hRD);
        g.insertEdge(raleigh, chapelHill, hRCH);
        g.insertEdge(durham, chapelHill, hDCH);

        Map<Vertex<String>, Integer> cost = ShortestPathUtil.dijkstra(g, raleigh);
        assertEquals("Cost to Raleigh should be zero", 
                     Integer.valueOf(0), cost.get(raleigh));
        assertEquals("Cost to Durham should be 20 via I-40", 
                     Integer.valueOf(20), cost.get(durham));
        assertEquals("Cost to Chapel Hill should be 30 via direct edge", 
                     Integer.valueOf(30), cost.get(chapelHill));
    }

    /**
     * Tests that shortestPathTree reconstructs the correct parent edges
     * given the cost map computed by Dijkstra's algorithm.
     */
    @Test
    public void testShortestPathTree() {
        Graph<String, Highway> g = new AdjacencyListGraph<>();
        Vertex<String> raleigh = g.insertVertex("Raleigh");
        Vertex<String> durham = g.insertVertex("Durham");
        Vertex<String> chapelHill = g.insertVertex("Chapel Hill");

        Highway hRD = new Highway("I-40", 20);
        Highway hRCH = new Highway("I-40", 30);
        Highway hDCH = new Highway("15-501", 10);
        Edge<Highway> eRD = g.insertEdge(raleigh, durham, hRD);
        Edge<Highway> eRCH = g.insertEdge(raleigh, chapelHill, hRCH);
        g.insertEdge(durham, chapelHill, hDCH);

        // Compute distances and then build the shortest-path tree
        Map<Vertex<String>, Integer> cost = ShortestPathUtil.dijkstra(g, raleigh);
        Map<Vertex<String>, Edge<Highway>> tree = 
            ShortestPathUtil.shortestPathTree(g, raleigh, cost);

        assertEquals("Durham should have parent edge Raleigh->Durham", 
                     eRD, tree.get(durham));
        assertEquals("Chapel Hill should have parent edge Raleigh->Chapel Hill", 
                     eRCH, tree.get(chapelHill));
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