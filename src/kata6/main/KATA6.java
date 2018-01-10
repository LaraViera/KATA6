package kata6.main;

import java.io.IOException;
import java.util.List;
import kata6.model.Histogram;
import kata6.model.Mail;
import kata6.view.HistogramDisplay;
import kata6.view.HistogramBuilder;
import kata6.view.MailListReader;

public class KATA6 {
    
    private String filename = "";
    private List<Mail> mailList;
    private HistogramBuilder<Mail> builder;
    
    private Histogram<String> domains;
    private Histogram<Character> letters; 

    public static void main(String[] args) throws IOException{
        KATA6 kata = new KATA6();
        kata.execute();
    }
    
    private  void execute() throws IOException{
        input();
        process();
        output();
    }
    
    private void input() throws IOException{
        filename = "C:\\Users\\la_mi\\Desktop\\Kata6\\KATA6\\emails.txt"; 
        mailList = MailListReader.read(filename);
    }
    private void process() throws IOException{
        builder = new HistogramBuilder<>(mailList);

        domains = builder.build(new Attribute<Mail, String>() {

            @Override
            public String get(Mail item) {
                return item.getMail().split("@")[1];
            }
        });

        letters = builder.build(new Attribute<Mail, Character>() {

            @Override
            public Character get(Mail item) {
                return item.getMail().charAt(0);
            }
});
    }
    private  void output(){
        new HistogramDisplay(domains, "Dominios").execute();
        new HistogramDisplay(letters, "Primer Caracter").execute();
    }
}
