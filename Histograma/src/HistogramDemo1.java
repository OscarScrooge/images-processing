
import java.io.IOException;
import java.util.Random;

import javax.swing.JPanel;
import jdk.nashorn.internal.codegen.CompilerConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYBarPainter;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 * A demo of the {@link HistogramDataset} class.
 */
public class HistogramDemo1 extends ApplicationFrame {

    /**
     * Creates a new demo.
     *
     * @param title  the frame title.
     */
    
    
    public HistogramDemo1(String title,double[] frecuencias,double[] frecuencias2,double[] frecuencias3, int totalPixeles) {
        super(title);
        JPanel chartPanel = createDemoPanel(frecuencias,frecuencias2,frecuencias3,totalPixeles);
        chartPanel.setPreferredSize(new java.awt.Dimension(700, 700));
        setContentPane(chartPanel);
    }

    /**
     * Creates a sample {@link HistogramDataset}.
     *
     * @return the dataset.
     */
    private static IntervalXYDataset createDataset(double[] frecuencias,double[] frecuencias2,double[] frecuencias3,int totalPixeles) {
        HistogramDataset dataset = new HistogramDataset();
//        double[] values = new double[256];
//                Random generator = new Random(12345678L);

//        for (int i = 0; i <= 255; i++) {
//
//             if(i==254){
//                System.out.println("dsfds"); 
//                int j=0;
//            }            
//            values[i] = frcuencias[i][1];
//        }
        dataset.addSeries("Rojo", frecuencias, 255, 0.0, 255.0);
        dataset.addSeries("Azul", frecuencias2, 255, 0.0, 255.0);
        dataset.addSeries("Verde", frecuencias3, 255, 0.0, 255.0);

//        values = new double[1000];
//        for (int i = 0; i < 1000; i++) {
//            values[i] = generator.nextGaussian() + 7;
//        }
//        dataset.addSeries("H2", values, 100, 4.0, 10.0);
        return dataset;
    }

    /**
     * Creates a chart.
     *
     * @param dataset  a dataset.
     *
     * @return The chart.
     */
    private static JFreeChart createChart(IntervalXYDataset dataset) {
        JFreeChart chart = ChartFactory.createHistogram(
            "Histogram Demo 1",
            null,
            null,
            dataset,
            PlotOrientation.VERTICAL,
            true,
            true,
            false);
        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setDomainPannable(true);
        plot.setRangePannable(true);
        plot.setForegroundAlpha(0.85f);
        NumberAxis yAxis = (NumberAxis) plot.getRangeAxis();
        yAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        XYBarRenderer renderer = (XYBarRenderer) plot.getRenderer();
        renderer.setDrawBarOutline(false);
        // flat bars look best...
        renderer.setBarPainter(new StandardXYBarPainter());
        renderer.setShadowVisible(false);
        return chart;
    }

    /**
     * Creates a panel for the demo (used by SuperDemo.java).
     *
     * @return A panel.
     */
    public static JPanel createDemoPanel(double[] frecuencias,double[] frecuencias2,double[] frecuencias3,int totalPixeles) {
        JFreeChart chart = createChart(createDataset(frecuencias,frecuencias2,frecuencias3,totalPixeles));
        ChartPanel panel = new ChartPanel(chart);
        panel.setMouseWheelEnabled(true);
        return panel;
    }

    /**
     * The starting point for the demo.
     *
     * @param args  ignored.
     *
     * @throws IOException  if there is a problem saving the file.
     */
//    public static void main(String[] args) throws IOException {
//
//        HistogramDemo1 demo = new HistogramDemo1(
//                "JFreeChart: HistogramDemo1.java");
//        demo.pack();
//        RefineryUtilities.centerFrameOnScreen(demo);
//        demo.setVisible(true);
//
//    }

}