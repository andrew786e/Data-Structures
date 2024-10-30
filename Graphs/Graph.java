import java.util.ArrayList;

public class Graph{

    private ArrayList<Vertex> vertices ;
    private boolean isWeighted  ;
    private boolean isDirected ;

    public Graph(boolean inputIsWeighted , boolean inputIsDirected  ){
        this.vertices = new ArrayList<Vertex>() ;
        this.isDirected = inputIsWeighted ;
        this.isWeighted = inputIsDirected ;
    }

    public Vertex addVertex(String data){
        Vertex newVertex = new Vertex(data) ;
        this.vertices.add(newVertex) ;
        return newVertex ;
    }

    public void addEdge(Vertex vertex1 , Vertex vertex2 , Integer weight){
        if(!this.isWeighted){
            weight = null ;
        }

        vertex1.addEdge(vertex2 , weight);

        if(!this.isDirected){
            vertex2.addEdge(vertex1 , weight);
        }
    }

    public void removeEdge(Vertex vertex1 , Vertex vertex2){
        vertex1.removeEdge(vertex2);
        if(!this.isDirected){
            vertex2.removeEdge(vertex1);
        }
    }

    public void removeVertex(Vertex vertex){
        this.vertices.remove(vertex) ;
    }

    public boolean isWeighted() {
        return isWeighted;
    }

    public boolean isDirected() {
        return isDirected;
    }

    public Vertex getVertexByValue(String value){
        for(Vertex v : this.vertices){
            if(v.getData() == value){
                return v ;
            }
        }

        return null ;
    }

    public void print(){
        for(Vertex v: this.vertices){
            v.print(isWeighted());
        }
    }

    public static void main(String[] args){
        Graph busNetwork = new Graph(true , true) ;
        Vertex cliftonStation = busNetwork.addVertex("Clifton") ;
        Vertex capeMayStation = busNetwork.addVertex("Cape May") ;

        busNetwork.addEdge(cliftonStation , capeMayStation , 1000);
        busNetwork.print() ;
    }
}