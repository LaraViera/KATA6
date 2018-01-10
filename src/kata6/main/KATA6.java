package kata6.main;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import kata6.model.Histogram;
import kata6.model.Person;
import kata6.view.DataBaseList;
import kata6.view.HistogramDisplay;
import kata6.view.HistogramBuilder;

public class KATA6 {
    
    private String filename = "";
    private List<Person> personList;
    private HistogramBuilder<Person> builderPerson;
    
    private Histogram<Float> weight;
    private Histogram<Character> gender; 

    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException{
        KATA6 kata = new KATA6();
        kata.execute();
    }
    
    private  void execute() throws IOException, ClassNotFoundException, SQLException{
        input();
        process();
        output();
    }
    
    private void input() throws IOException, ClassNotFoundException, SQLException{
        filename = "C:\\Users\\la_mi\\Desktop\\Kata6\\KATA6\\KATA.sDB"; 
        personList = DataBaseList.read(filename);
    }
    private void process() throws IOException{
        builderPerson = new HistogramBuilder<>(personList);

        gender = builderPerson.build(new Attribute<Person, Character>() {

            @Override
            public Character get(Person item) {
                return item.getGender();
            }
        });

        weight = builderPerson.build(new Attribute<Person, Float>() {

            @Override
            public Float get(Person item) {
                return item.getWeight();
            }
});
    }
    private  void output(){
        new HistogramDisplay(gender, "Género").execute();
        new HistogramDisplay(weight, "Peso").execute();
    }
}
