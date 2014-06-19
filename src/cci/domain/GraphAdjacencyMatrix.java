package cci.domain;

/**
 * Created by xzhang on 6/19/14.
 */
public class GraphAdjacencyMatrix {

    public boolean[][] matrix;

    public GraphAdjacencyMatrix(int numOfVertices) {
        this.matrix = new boolean[numOfVertices][numOfVertices];
    }
}
