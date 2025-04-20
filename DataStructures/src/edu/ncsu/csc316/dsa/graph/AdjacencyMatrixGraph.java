package edu.ncsu.csc316.dsa.graph;

import edu.ncsu.csc316.dsa.list.List;
import edu.ncsu.csc316.dsa.list.SinglyLinkedList;

/**
 * An AdjacencyMatrixGraph is an implementation of the {@link Graph} abstract
 * data type. AdjacencyMatrixGraph maintains a list of vertices in the graph and
 * a list of edges in the graph. In addition, AdjacencyMatrixGraph maintains a
 * 2-dimensional array to store edges based on the endpoints of the edges
 * 
 * The AdjacencyMatrixGraph class is based on the textbook:
 *
 * Data Structures and Algorithms in Java, Sixth Edition Michael T. Goodrich,
 * Roberto Tamassia, and Michael H. Goldwasser John Wiley and Sons, 2014
 * 
 * @author Dr. King
 * @author Aida Fatima 
 *
 * @param <V> the type of data in the vertices in the graph
 * @param <E> the type of data in the edges in the graph
 */
public class AdjacencyMatrixGraph<V, E> extends EdgeListGraph<V, E> {

    /**
     * Represents a vertex in an AdjacencyMapGraph
     * 
     * @author Dr. King
     *
     */
    private class MatrixVertex extends GraphVertex {

        /** The integer index of the vertex **/
        private int index;

        /**
         * Creates a new adjacency matrix vertex.
         * 
         * @param data       the data to store in the vertex
         */
        public MatrixVertex(V data) {
            super(data);
            index = getVertexIndex();
            System.out.println("Vertex " + data + " has index " + index); 
        }

        /**
         * Returns the row/column index of the vertex in the matrix
         * 
         * @return the index of the vertex in the matrix
         */
        public int getIndex() {
            return index;
        }
    }
    
    /** Variable for GraphEdge */
    private GraphEdge[][] matrix;

    /** Variable for index */
    private int vertexIndexer;

    /**
     * Creates a new undirected adjacency matrix graph
     */
    public AdjacencyMatrixGraph() {
        this(false);
        vertexIndexer = 0;
    }

    /**
     * Creates a new adjacency matrix graph
     * 
     * @param directed if true, the graph is directed; if false, the graph is
     *                 undirected
     */
    @SuppressWarnings("unchecked")
    public AdjacencyMatrixGraph(boolean directed) {
        super(directed);
        matrix = (GraphEdge[][]) new AbstractGraph.GraphEdge[0][0];
    }

    /**
     * Creates a new vertex with the given data.
     *
     * @param vertexData the data to store in the vertex
     * @return a new {@code ALVertex} containing the given data and directed status matching the graph
     */
    protected Vertex<V> createVertex(V vertexData) {
        return new MatrixVertex(vertexData);
    }

    @Override
    public Edge<E> getEdge(Vertex<V> vertex1, Vertex<V> vertex2) {
    	MatrixVertex v1 = validate(vertex1);
        MatrixVertex v2 = validate(vertex2);
        return matrix[v1.getIndex()][v2.getIndex()];
    }

    /**
     * Generates and returns a unique index for a vertex.
     * 
     * Each call increments the internal vertex index counter and returns the previous value,
     * ensuring that each vertex receives a unique, sequential index starting from zero.
     *
     * @return the next available unique vertex index
     */
    private int getVertexIndex() {
        vertexIndexer++;
        return vertexIndexer - 1;
    }

    @SuppressWarnings("unchecked")
    private void growArray() {
        GraphEdge[][] temp = new AbstractGraph.GraphEdge[matrix.length + 1][matrix.length + 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                temp[i][j] = matrix[i][j];
            }
        }
        matrix = temp;
    }

    /**
     * Retrieves a list of all incoming edges for the specified vertex.
     * 
     * This method scans the adjacency matrix column corresponding to the given vertex and
     * collects all non-null edges, representing edges directed into the vertex.
     *
     * @param vertex the vertex whose incoming edges are to be retrieved
     * @return a list of incoming {@code Edge<E>} instances for the specified vertex
     * @throws IllegalArgumentException if the vertex is not a valid matrix vertex
     */
    private List<Edge<E>> incomingEdgeList(Vertex<V> vertex) {
        MatrixVertex v = validate(vertex);
        List<Edge<E>> list = new SinglyLinkedList<Edge<E>>();
        for (int i = 0; i < matrix.length; i++) {
            GraphEdge e = matrix[i][v.getIndex()];
            if (e != null) {
                list.addLast(e);
            }
        }
        return list;
    }

    @Override
    public Iterable<Edge<E>> incomingEdges(Vertex<V> vertex) {
        return incomingEdgeList(vertex);
    }

    @Override
    public int inDegree(Vertex<V> vertex) {
        return incomingEdgeList(vertex).size();
    }

    @Override
    public Edge<E> insertEdge(Vertex<V> vertex1, Vertex<V> vertex2, E edgeData) {
    	MatrixVertex v1 = validate(vertex1);
        MatrixVertex v2 = validate(vertex2);
        // Insert via the superclass to obtain the edge and add to the global list.
        Edge<E> edge = super.insertEdge(v1, v2, edgeData);
        int i1 = v1.getIndex();
        int i2 = v2.getIndex();
        matrix[i1][i2] = (GraphEdge) edge;
        if (!isDirected()) {
            matrix[i2][i1] = (GraphEdge) edge;
        }
        return edge;
    }

    @Override
    public Vertex<V> insertVertex(V vertexData) {
        growArray();
        return super.insertVertex(vertexData);
    }

    @Override
    public int outDegree(Vertex<V> vertex) {
        return outgoingEdgeList(vertex).size();
    }

    private List<Edge<E>> outgoingEdgeList(Vertex<V> vertex) {
    	MatrixVertex v = validate(vertex);
        List<Edge<E>> list = new SinglyLinkedList<Edge<E>>();
        int row = v.getIndex();
        for (int j = 0; j < matrix[row].length; j++) {
            GraphEdge edge = matrix[row][j];
            if (edge != null) {
                list.addLast(edge);
            }
        }
        return list;
    }
    
    @Override
    public Iterable<Edge<E>> outgoingEdges(Vertex<V> vertex) {
        return outgoingEdgeList(vertex);
    }

    @Override
    public void removeEdge(Edge<E> edge) {
    	GraphEdge e = validate(edge);
    	Vertex<V>[] endpoints = e.getEndpoints();
        MatrixVertex v1 = validate(endpoints[0]);
        MatrixVertex v2 = validate(endpoints[1]);
        matrix[v1.getIndex()][v2.getIndex()] = null;
        if (!isDirected()) {
            matrix[v2.getIndex()][v1.getIndex()] = null;
        }
        super.removeEdge(edge);
    }
    
    /**
     * Safely casts a Vertex to a graph vertex
     * 
     * @return a graph vertex representation of the given Vertex
     * @throws IllegalArgumentException if the vertex is not a valid graph vertex
     * @param v the vertex to validate
     */
    private MatrixVertex validate(Vertex<V> v) {
        if (!(v instanceof AdjacencyMatrixGraph.MatrixVertex)) {
            throw new IllegalArgumentException("Vertex is not a valid adjacency matrix vertex.");
        }
        return (MatrixVertex) v;
    }
}
