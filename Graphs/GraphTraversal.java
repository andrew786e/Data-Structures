import java.util.*;

public class GraphTraversal {
    public static void dfs(Vertex startingNode , Set<Vertex> visitedVertex){
        visitedVertex.add(startingNode) ;

        for(Edge neighbours : startingNode.getEdges()){
            if(!visitedVertex.contains(neighbours.getEnd())){
                dfs(neighbours.getEnd() , visitedVertex) ;
            }
        }
    }

    public static void bfs(Vertex startingNode){
        Queue<Vertex> vertexQueue = new LinkedList<>();
        HashSet<Vertex> visitedVertexs = new HashSet<>() ;

        vertexQueue.add(startingNode) ;
        visitedVertexs.add(startingNode) ;

        while(!vertexQueue.isEmpty()){
            int size = vertexQueue.size();

            for(int i = 0  ; i < size ; i++){
                Vertex currentVertex = vertexQueue.poll() ;

                for(Edge edge : currentVertex.getEdges()){
                    Vertex neighbours = edge.getEnd() ;
                    if(!visitedVertexs.contains(neighbours)){
                        visitedVertexs.add(neighbours) ;
                        vertexQueue.add(neighbours) ;
                    }
                }
            }
        }
    }
}
