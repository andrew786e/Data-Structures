import java.util.ArrayList;

public class Vertex{

    private String data ;
    private ArrayList<Edge> edges  ;

    public Vertex(String inputData){
        this.data = inputData ;
        this.edges = new ArrayList<Edge>() ;
    }

    public void addEdge(Vertex endVertex , Integer weightData){
        this.edges.add(new Edge(this, endVertex, weightData)) ;
    }

    public void removeEdge(Vertex end){
        this.edges.removeIf(edge -> edge.getEnd().equals(end)) ;
    }

    public String getData(){
        return this.data ;
    }

    public ArrayList<Edge> getEdges(){
        return this.edges ;
    }

    public void print(boolean showWeight){
        StringBuilder message = new StringBuilder();

        if(this.edges.isEmpty()){
            System.out.println("This vertex has no edges") ;
            System.out.println(this.data + "-->") ;
            return ;
        }

        for(int i = 0 ; i < edges.size() ; i++){
            if(i == 0){
                message.append(this.edges.get(0).getStart().data ) ;
                message.append( " --> " ) ;
            }

            message.append(this.edges.get(i).getEnd().data) ;

            if(showWeight){
                message.append(" (") ;
                message.append(this.edges.get(i).getWeight()) ;
                message.append(")") ;
            }

            if(i != this.edges.size() -1 ){
                message.append(" , ") ;
            }
        }

        System.out.println(message.toString()) ;
    }
}