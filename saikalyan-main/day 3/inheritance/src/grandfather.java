public class grandfather {
    public static void main(String args[]){
        String car;
        String house;
        grandfather(String car,String house){
            this.car = "swift";
            this.house = "apartment";
        }
        void runcar(){
            System.out.println("car is running");
        }
        void createhouse(){
            System.out.println("house is clean");
        }

    }
}
public class father extends grandfather{
String bike;
father(){
    this.bike = bike;
}
void bikerun(){
    System.out.println("bike is running");
}
}
public son extends father{
String truck;
son(String truck){
    this.truck = truck;

}
void runtruck(){
    System.out.println("truck is running");
}
}
