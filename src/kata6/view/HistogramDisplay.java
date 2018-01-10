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

public final class HistogramDisplay<T> extends ApplicationFrame{
    
    private final Histogram<T> histogram;
    private final String labelEjeX;
    
    public HistogramDisplay(Histogram<T> histogram, String name){
            super("Histograma");
            this.histogram = histogram;
            this.labelEjeX = name;
            setContentPane(createPanel());
            pack();
    }
    
    public void execute(){
        setVisible(true);
    }
    
    private JPanel createPanel(){
        ChartPanel chartPanel = new ChartPanel (createChart(createDataset()));
        chartPanel.setPreferredSize(new Dimension(500,400));
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
        for (T key : histogram.keySet()) {
            dataSet.addValue(histogram.get(key), "", (Comparable)key);
        }
        return dataSet;
    }
}
