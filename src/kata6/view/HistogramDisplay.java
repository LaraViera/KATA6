package kata6.view;

import kata6.model.Histogram;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class HistogramDisplay extends ApplicationFrame{
    
    private final Histogram<String> histogram;
    
    public HistogramDisplay(Histogram<String> histogram){
            super("Histograma");
            this.histogram = histogram;
            setContentPane(createPanel());
            pack();
    }
    
    public void execute(){
        setVisible(true);
    }
    
    private JPanel createPanel(){
        ChartPanel chartPanel = new ChartPanel (createChart(createDataset()));
        setPreferredSize(new Dimension(500,400));
        return chartPanel;
    }
    
    private JFreeChart createChart (DefaultCategoryDataset dataset){
        return ChartFactory.createBarChart(
                "histograma JFreeChart",
                "dominios email",
                "Nº de emails",
                dataset, 
                PlotOrientation.VERTICAL, 
                false,
                true,
                true);
    }
    
    private DefaultCategoryDataset createDataset(){
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        for (String key : histogram.keySet()) {
            dataSet.addValue(histogram.get(key), "", key);
        }
        return dataSet;
    }
}
